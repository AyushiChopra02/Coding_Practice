import java.util.*;

public class Mellon {
    static class Pair {
        int score;
        int index;

        Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    public static long maxTeamScore(int[] scores, int teamSize, int k) {
        int n = scores.length;
        long totalScore = 0;

        PriorityQueue<Pair> frontPQ = new PriorityQueue<>((a, b) -> 
            a.score == b.score ? a.index - b.index : b.score - a.score);

        PriorityQueue<Pair> backPQ = new PriorityQueue<>((a, b) -> 
            a.score == b.score ? a.index - b.index : b.score - a.score);

        int i = 0, j = n - 1;
        Set<Integer> used = new HashSet<>();

        // Initially fill front and back queues
        while (i < k && i <= j) {
            frontPQ.offer(new Pair(scores[i], i));
            used.add(i);
            i++;
        }

        while (j >= n - k && j >= i) {
            if (!used.contains(j)) {
                backPQ.offer(new Pair(scores[j], j));
            }
            j--;
        }

        // Choose teamSize members
        while (teamSize-- > 0) {
            Pair frontTop = frontPQ.peek();
            Pair backTop = backPQ.peek();

            // Choose better one
            if (backTop == null || (frontTop != null && frontTop.score >= backTop.score)) {
                totalScore += frontTop.score;
                frontPQ.poll();
               

                // Next available index from front
                if (i <= j) {
                    frontPQ.offer(new Pair(scores[i], i));
                    i++;
                }
            } else {
                totalScore += backTop.score;
                backPQ.poll();
              

                // Next available index from back
                if (i <= j) {
                    backPQ.offer(new Pair(scores[j], j));
                    j--;
                }
            }
        }

        return totalScore;
    }

    public static void main(String[] args) {
        int[] scores = {10, 20, 10, 15, 5, 30, 20};
        int teamSize = 2;
        int k = 3;

        long result = maxTeamScore(scores, teamSize, k);
        System.out.println("Total Team Score: " + result);  
    }
}
