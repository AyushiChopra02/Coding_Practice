import java.util.Scanner;
import java.util.Stack;

public class Atlassian {
    public static long sumOfGoodness(int[] nums) {
        int n = nums.length;
        long totalSum = 0;

        int[] left = new int[n];  
        int[] right = new int[n]; 

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long count = (long) left[i] * right[i];
            totalSum += count * nums[i];
        }

        return totalSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + "elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long result = sumOfGoodness(arr);
        System.out.println("Sum" + result);
    }
}
