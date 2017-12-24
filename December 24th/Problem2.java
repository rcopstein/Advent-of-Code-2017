import java.util.*;

public class Problem2 {

    static int longest = 0;
    static int longestStrength = 0;

    static void find(List<Connection> connections) {

        find(connections, 0, 0, 0);

    }
    static void find(List<Connection> connections, int port, int strength, int longitude) {

        boolean found = false;

        for (int i = 0; i < connections.size(); ++i) {

            Connection conn = connections.get(i);

            if (!conn.used && (conn.from == port || conn.to == port)) {

                conn.used = true;
                found = true;

                int nport = conn.from == port ? conn.to : conn.from;
                find(connections, nport, strength + conn.strength, longitude + 1);
                conn.used = false;

            }

        }

        if (!found) {

            if (longitude >= longest) {

                longest = longitude;
                longestStrength = Math.max(strength, longestStrength);

            }

        }

    }

    static class Connection {

        boolean used = false;
        int strength;
        int from;
        int to;

        public Connection(String input) {

            String[] parts = input.split("/");

            from = Integer.parseInt(parts[0]);
            to = Integer.parseInt(parts[1]);
            strength = from + to;

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Connection> connections = new ArrayList<>();
        while (sc.hasNext()) connections.add(new Connection(sc.nextLine()));

        connections.sort(new Comparator<Connection>() {

            public int compare(Connection item, Connection other) {

                return (item.strength - other.strength) * -1;
                
            }

        });

        find(connections);
        System.out.println(longestStrength);

    }

}