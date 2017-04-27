import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int person1, person2;
        List<Set<Integer>> persons = new ArrayList<Set<Integer>>(n+1);
        while( n-- >= 0 ) {
            persons.add(new HashSet<Integer>());
        }
        while( m-- > 0 ) {
            person1 = in.nextInt();
            person2 = in.nextInt();
            persons.get(person1).add(person2);
            persons.get(person2).add(person1);
        }
        System.out.println(canSeparate(persons) ? "YES" : "NO");
        in.close();
    }

    private static boolean canSeparate(List<Set<Integer>> persons) {
        Set<Integer> current, otherRoom, currentRoom, room1 = new HashSet<Integer>(), room2 = new HashSet<Integer>();
        for(int i = 1; i < persons.size(); i++ ) {
            current = persons.get(i);
            if ( current.isEmpty() ) continue;
            if (room1.isEmpty() && room2.isEmpty()) {
                room1.add(i);
            }
          currentRoom = room1.contains(i) ? room1 : room2;
          otherRoom = room1.contains(i) ? room2 : room1;
          for(Integer knowPerson : current) {
              if (currentRoom.contains(knowPerson)) {
                  return false;
              }
              otherRoom.add(knowPerson);
          }
        }
        return true;
    }
}
