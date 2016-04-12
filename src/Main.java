import java.util.*;

/**
 * Given:
 *  a list of numbers: [400, 200, 100, 500]
 *  a goal number: 600
 * Find:
 *  all pairs (2 numbers per pair, it's not the knapsack problem) of numbers that sum to the goal number.
 * Result: [{400, 200}, {100, 500}]
 */
class Pair<A, B> {

  public final A left;
  public final B right;

  Pair(A left, B right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    return "<" + left + ", " + right + ">";
  }
}

/**
 * Created by falven on 4/12/16.
 */
public class Main {

  public static void main(String[] args) {
    List<Long> numbers = new ArrayList<>();
//    numbers.add(400L);
    numbers.add(400L);
//    numbers.add(200L);
    numbers.add(200L);
    numbers.add(100L);
    numbers.add(500L);
    numbers.add(300L);
    Long goal = 600L;

    List<Pair<Long, Long>> result = findSummingPairs(numbers, goal);

    List<Pair<Long, Long>> expected = new ArrayList<>();
    expected.add(new Pair<Long, Long>(400L, 200L));
    expected.add(new Pair<Long, Long>(100L, 500L));
  }

  static List<Pair<Long, Long>> findSummingPairs(List<Long> numbers, Long goal) {
    Map<Long, Integer> lookup = new HashMap<>();
    for(int i = 0; i < numbers.size(); ++i) {
      lookup.put(numbers.get(i), i);
    }
    // 400 -> 1
    // 200 -> 2
    // 100 -> 3
    // 500 -> 4
    // 300 -> 5
    System.out.println(lookup);
    List<Pair<Long, Long>> pairs = new ArrayList<>();
    for(int i = 0; i < numbers.size(); ++i) {
      Integer got = lookup.get(goal - numbers.get(i));
      if (got != null) {
        System.out.println("Pair: " + got + " has sum " + goal);
      }
    }
    return null;
  }

}
