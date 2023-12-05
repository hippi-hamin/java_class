package ch06_for;

public class Ex04_ForEx {
    public static void main(String[] args) {
        /**
         * 1부터 100까지의 합계를 출력
         * 1+2+3+4+5+6+7+8+9+10+ ... 100 =
         */
//        int sum = 0;
//        sum = 1;
//        sum = sum + 2;
//        sum = sum + 3;
//        sum = sum + 4;
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
            if(i<=99) {
                System.out.print(i + "+");
            }else{
                System.out.print(i);
            }

        }
        System.out.print("=" + sum);
    }
}


