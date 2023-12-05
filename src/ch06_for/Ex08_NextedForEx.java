package ch06_for;

public class Ex08_NextedForEx {
    public static void main(String[] args) {


        for(int i = 2; i <= 9; i++) {
            System.out.println(i + "단");
            for (int j = 1; j < 10; j++) {
                    int mul = i * j;
                if(j<9) {
                    System.out.print(i + " X " + j + " = " + mul + ", ");
                }else{
                    System.out.println(i + " X " + j + " = " + mul);
                }
            }
        }
    }
}
