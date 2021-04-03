import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        int logsNum;
        List<String> logs = new ArrayList<>();
        n = input.nextInt();
        logsNum = input.nextInt();
        for (int i = 0; i < logsNum; i++) {
            logs.add(input.next());
        }
        Solution solution = new Solution();
        for (int i : solution.exclusiveTime(n, logs)) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> callStack = new Stack<>();
        int lastLogTimeStamp = -1;
        int[] ans = new int[n];
        for (String log : logs) {
            String[] str = log.split(":");
            int funcId = Integer.parseInt(str[0]);
            boolean isStart = "start".equals(str[1]);
            int timeStamp = Integer.parseInt(str[2]);
            if (!isStart) timeStamp += 1;

            if (!callStack.empty()) {
                int currentFunc = callStack.peek();
                ans[currentFunc] += timeStamp - lastLogTimeStamp;
            }

            if (isStart) {
                callStack.push(funcId);
            } else {
                callStack.pop();
            }

            lastLogTimeStamp = timeStamp;
        }
        return ans;
    }
}