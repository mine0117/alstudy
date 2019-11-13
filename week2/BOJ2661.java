package ex01;

import java.util.Scanner;

public class BOJ2661 {

    static int N;

    private static boolean isPromising(String num){
        int start = num.length()-2;
        int end = num.length();
        //비교할 자리수
        for(int i=2;i<=num.length()/2;i++){
            //맨 뒤에서부터 확인한다.
            if (num.substring(start - i, end - i).equals(num.substring(start, end))) {
                return false;
            }
            start--;
        }
        return true;
    }

    private static void dfs(String num){
        if(num.length()==N){
            System.out.println(num);
            System.exit(0);
        }
        char c = num.charAt(num.length()-1);
        for(int i=1;i<=3;i++){
            //연속된 한 자리 수는 넣지 않는다.
            if((c-48)!=i){
                num += String.valueOf(i);
                //유망한지 확인
                if(isPromising(num)){
                   dfs(num);
                }
                //백트래킹
                num = num.substring(0,num.length()-1);
            }
        }
    }

    public static void main(String[] args){
  
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        dfs("1");
    }
}