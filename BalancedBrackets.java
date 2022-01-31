package com.gl.labsesion;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {
        String bracketExpression = "( [ [ { } ] ] ) )";
        if (isBalanced(bracketExpression)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }

    public static boolean isBalanced(String bracketExpression) {
        Stack<Character> stack = new Stack<>();
        int length = bracketExpression.length();
        int i = 0;
        Character previous;
        boolean status = false;
        while (i < length) {
            Character c = bracketExpression.charAt(i);
           // System.out.println("c =" + c);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if(stack.empty()){
                    status = false;
                    break;
                }
                else {
                    previous = stack.peek();
                    if (previous == '(') {
                        //   System.out.println("Inside )");
                        stack.pop();
                        status = true;
                    } else {
                        status = false;
                        break;
                    }
                }
            }

            if (c == ']') {
                if (stack.empty()) {
                    status = false;
                    break;
                } else {
                    previous = stack.peek();
                    if (previous == '[') {
                        //   System.out.println("Inside ]");
                        stack.pop();
                        status = true;
                    } else {
                        status = false;
                        break;
                    }
                }
            }


                if (c == '}') {
                    if (stack.empty()) {
                        status = false;
                        break;
                    } else {
                        previous = stack.peek();
                        if (previous == '{') {
                            //  System.out.println("Inside }");
                            stack.pop();
                            status = true;
                        } else {
                            status = false;
                            break;
                        }
                    }
                }


            i++;
        }
        return status;
    }
}