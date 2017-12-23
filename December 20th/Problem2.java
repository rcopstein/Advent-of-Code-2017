import java.util.*;

public class Problem2 {

    static class Vector3 {

        long x;
        long y;
        long z;

        double mdistance() {

            double xabs = Math.abs(x);
            double yabs = Math.abs(y);
            double zabs = Math.abs(z);

            return xabs + yabs + zabs;

        }

        public String toString() {

            return x + "," + y + "," + z;

        }

    }

    static class Particle implements Comparable<Particle> {

        public int name;
        public Vector3 position;
        public Vector3 velocity;
        public Vector3 acceleration;

        public int compareTo(Particle other) {

            if (acceleration.mdistance() - other.acceleration.mdistance() == 0) {
                if (velocity.mdistance() - other.velocity.mdistance() == 0) {
                    return (int)(position.mdistance() - other.position.mdistance());
                }

                return (int)(velocity.mdistance() - other.velocity.mdistance()) * -1;
            }
            
            return (int)(acceleration.mdistance() - other.acceleration.mdistance());

        }

    }

    static Vector3 readAttribute(String input) {

        Vector3 attribute = new Vector3();

        input = input.substring(3, input.length() - 1);
        String[] values = input.split(",");

        attribute.x = Integer.parseInt(values[0]);
        attribute.y = Integer.parseInt(values[1]);
        attribute.z = Integer.parseInt(values[2]);

        return attribute;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int aux = 0;
        ArrayList<Particle> particles = new ArrayList<>(1000);

        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] attributes = line.split(", ");

            Particle p     = new Particle();
            p.name         = aux++;
            p.position     = readAttribute(attributes[0]);
            p.velocity     = readAttribute(attributes[1]);
            p.acceleration = readAttribute(attributes[2]);

            particles.add(p);
            
        }

        int count = 1000;
        ArrayList<String> toRemove = new ArrayList<>();
        HashMap<String, ArrayList<Particle>> map = new HashMap<>();

        for (int i = 0; i < 1000; ++i) {

            map.clear();
            toRemove.clear();

            for (int j = 0; j < particles.size(); ++j) {

                Particle p = particles.get(j);
                String key = p.position.toString();

                if (!map.containsKey(key)) map.put(key, new ArrayList<Particle>());
                map.get(key).add(p);

                if (map.get(key).size() == 2) toRemove.add(key);

                p.velocity.x += p.acceleration.x;
                p.velocity.y += p.acceleration.y;
                p.velocity.z += p.acceleration.z;

                p.position.x += p.velocity.x;
                p.position.y += p.velocity.y;
                p.position.z += p.velocity.z;

            }

            for (String s : toRemove) {
                for (Particle p : map.get(s)) {
                    particles.remove(p);
                    --count;
                }
            }

        }

        System.out.println(count);

    }

}