package ch07_while;

public class Ex07_WhileEx {
    public static void main(String[] args) {
        /**
         * 1 + (-2) + 3 +(-4) + 5 + (-6) ~~~
         * 처럼 계산을 했을 때 합계가 100이 됐을 때의 숫자를 출력
         * 정답 : 199
         */

        int sum = 0;
        // 1,2,3,4,5~~
        int cnt = 1;
        // 1, -2, 3, -4, 5, -6~~
        int num = 0;
        // 부호용 변수
        int s = 1;
        boolean run = true;
        while (run) {
            sum += num;
            if(sum >= 100) {
                run = false;
                System.out.println("num = " + num);
            } else {
                num = s * cnt;
                s = -s; // 1, -1, 1, -1
                cnt++;
            }
        }
    }
}






//
//        int i = 0;
//        int sum = 0;
//
//        while (i >= 0) {
//            i++;
//            if (i % 2 == 0) {
//                i = i * (-1);
//                System.out.println("i = " + i);
//            }
//            sum = sum + i;
//            if (sum == 100) {
//                System.out.println("정답 = " + i);
//                break;
//            }
//        }
//    }
//}
