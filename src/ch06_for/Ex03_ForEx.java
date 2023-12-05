package ch06_for;

public class Ex03_ForEx {
    public static void main(String[] args) {
        /**
         * 1부터 10까지의 합계를 출력
         * 1+2+3+4+5+6+7+8+9+10=
         */
//        int sum = 0;
//        sum = 1;
//        sum = sum + 2;
//        sum = sum + 3;
//        sum = sum + 4;
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + i;
            if(i<=9) {
                System.out.print(i + "+");
            }else{
                System.out.print(i);
            }

        }
        System.out.print("=" + sum);
    }
}
