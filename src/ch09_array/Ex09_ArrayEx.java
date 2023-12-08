package ch09_array;

import java.util.Scanner;

public class Ex09_ArrayEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int select = 0, student = 0, score = 0, list = 0, temp = 0;
        double avg = 0, sum = 0;
        int[] stu = null;
        boolean run = true;

        while (run) {
            System.out.println("----------------------------------------------------------");
            System.out.println("1.학생수입력 | 2.점수입력 | 3.점수목록 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------------------");
            System.out.print("선택> ");
            select = sc.nextInt();
            if (select == 1) {
                System.out.print("학생수> ");
                student = sc.nextInt();
                if (student > 0) {
                    stu = new int[student];
                } else {
                    stu = null;
                }
            }else if (select == 2) {
                for (int i = 0; i < stu.length; i++) {
                    System.out.print((i + 1) + "번 학생 점수 : ");
                    score = sc.nextInt();
                    stu[i] = score;
                }
            }else if (select == 3) {
                for (int i = 0; i < stu.length; i++) {
                    System.out.println((i + 1) + "번 학생 점수 : " + stu[i]);
                }
            }else if (select == 4) {
                for (int i = 0; i < stu.length; i++) {
                    sum += stu[i];
                    for (int j = i + 1; j < stu.length; j++) {
                        if (stu[i] < stu[j]) {
                            temp = stu[i];
                            stu[i] = stu[j];
                            stu[j] = temp;
                        }
                    }
                }
                avg = sum / stu.length;
                System.out.println("반 최고 점수 : " + stu[0]);
                System.out.println("반평균 점수 : " + avg);
                for (int i = 0; i < stu.length; i++) {
                    System.out.println((i + 1) + "등 : " + stu[i]);
                }
            }else if(select == 5){
                System.out.println("종료합니다.");
                run = false;
            }else{
                System.out.println("입력 범위를 초과하셨습니다.");
                System.out.println("다시 입력해주십시오.");
                System.out.println("");
            }
        }
    }
}



