package ex01;

import java.util.Scanner;

public class BOJ2661 {

    static int N;

    private static boolean isPromising(String num){
        int start = num.length()-2;
        int end = num.length();
        //���� �ڸ���
        for(int i=2;i<=num.length()/2;i++){
            //�� �ڿ������� Ȯ���Ѵ�.
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
            //���ӵ� �� �ڸ� ���� ���� �ʴ´�.
            if((c-48)!=i){
                num += String.valueOf(i);
                //�������� Ȯ��
                if(isPromising(num)){
                   dfs(num);
                }
                //��Ʈ��ŷ
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