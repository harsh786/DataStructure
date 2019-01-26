package StackPkg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java.util.Stack;

class RectArea {
    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    static int getMaxArea(int hist[], int n) {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> s = new Stack<>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
  while (i < n) {
            // If this bar is higher than the bar on top st6ack, push it to stack
           if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false) {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    // Driver program to test above function
    public static void main(String[] args) {
        int hist[] = {3, 2, 4, 5, 3};
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}


class QueueImplementation {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void pushQueue(int data) {

        s1.push(data);

    }

    public void pullQueue() {

        if (s2.size() == 0) {

            while (s1.size() != 0) {
                s2.push(s1.pop());

            }

        }
        if (s2.size() == 0) {
            System.out.println("No element is:");
            return;
        }
        System.out.println("Pop element is:" + s2.pop());


    }


}


class StackImplementation {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    public void push(int a) {

        if (queue1.size() != 0) {
            queue1.add(a);
        } else {
            queue2.add(a);

        }


    }

    public void pop() {


        if (queue1.size() != 0) {
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }

            System.out.println("dequeue elemnt is :" + queue1.poll());


        } else {
            if (queue2.size() == 0) {
                System.out.println("no elemnt");

            } else {
                while (queue2.size() != 1) {
                    queue1.add(queue2.poll());
                }

                System.out.println("dequeue elemnt is :" + queue2.poll());

            }

        }
    }


}

class StockSpanProblem {

    Stack<Integer> s = new Stack<>();
    int price[] = {100, 85, 70, 60, 65, 75, 80};


    public void calculate() {

        int si[] = new int[price.length];
        si[0] = 1;
        s.push(0);
        for (int i = 1; i < price.length; i++) {
            while (s.size() != 0 && price[s.peek()] <= price[i]) {
                s.pop();

            }
            si[i] = s.size() == 0 ? i + 1 : i - s.peek();
            s.push(i);


        }

    }


}


class StackQuestions {

    public int CalculateReversePolishNotation(String exp) {
        if (exp == null || exp.isEmpty()) {
            return 0;

        }
        String[] arr = exp.split(" ");

        Stack<Integer> stk = new Stack<Integer>();

        /// List<Integer>ls= new ();


        for (String val : arr) {
            try {
                if (val == " ") {
                    continue;
                }
                int a = Integer.parseInt(val);
                stk.push(a);
            } catch (Exception ex) { // System.out.println( stk.elementAt(1));
                // System.out.println( stk.toString());
                int f = stk.pop();
                int s = stk.pop();

                int cal = 0;
                if (val.equals("+")) {
                    cal = f + s;

                }
                if (val.equals("-")) {
                    cal = f - s;

                }
                if (val.equals("*")) {
                    cal = f * s;

                }
                if (val.equals("/")) {
                    cal = f / s;

                }
                stk.push(cal);
            }


        }
        if (stk.size() == 1) {
            return stk.pop();

        }
        return 0;
    }


}


public class StackPoblems {
    public StackPoblems() {
        StackQuestions obStackQuestions = new StackQuestions();
        System.out.println(obStackQuestions.CalculateReversePolishNotation("17 14 + "));
        System.out.println(obStackQuestions.CalculateReversePolishNotation("14 17 2 * - 13 +"));
    }


}
