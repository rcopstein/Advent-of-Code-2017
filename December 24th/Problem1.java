import java.util.*;

// Run down the list of connections
// Find every connection that matches the current state
// Try until the end
// Go back and try the different approaches

public class Problem1 {

    static int find(List<Connection> connections) {

        return find(connections, 0);

    }
    static int find(List<Connection> connections, int port) {

        int max = 0;

        for (int i = 0; i < connections.size(); ++i) {

            Connection conn = connections.get(i);

            if (!conn.used && (conn.from == port || conn.to == port)) {

                conn.used = true;
                int nport = conn.from == port ? conn.to : conn.from;
                int result = find(connections, nport);
                max = Math.max(max, conn.strength + result);
                conn.used = false;

            }

        }

        return max;

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

        int strength = find(connections);
        System.out.println(strength);

    }

}