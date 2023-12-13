package ch10_class.ex11;

import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {
        /**
         * 메뉴
         * 1. 글작성(매개변수 있는 생성자이용)
         *      글작성 정보는 스캐너로 받음. 글번호도 같이 입력함.
         * 2. 글조회
         *      글번호를 입력 받고 Board 클래스의 findById로 글번호를 넘긴다.
         * 3. 종료
         */
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int selectNo = 0;
        Board board1 = null; // null은 비어있다는 뜻, 0은 숫자 0이라는 데이터가 들어있는 상태

        while (run) {
            System.out.println("--------------------------------------------------------------");
            System.out.println("1.글작성 | 2.글조회 | 3.종료");
            System.out.println("--------------------------------------------------------------");
            System.out.print("선택> ");
            selectNo = sc.nextInt();
            if (selectNo == 1) {
                board1 = new Board();

                System.out.print("글번호 : ");
                board1.setId(sc.nextLong());

                System.out.print("제목 : ");
                board1.setBoardTitle(sc.next());
                System.out.print("작성자 : ");
                board1.setBoardWriter(sc.next());
                System.out.print("내용 : ");
                board1.setBoardContents(sc.next());
                //System.out.println("조회수 : " + board1.getBoardHits());

            } else if (selectNo == 2) {
                System.out.print("글번호를 입력하세요 : ");
                Long id = sc.nextLong();
                boolean findResult = board1.findById(id);
                if(findResult){
                    board1.print();
                } else {
                    System.out.println("일치하는 글이 없습니다.");
                }

            } else if (selectNo == 3) {
                run = false;
            }
        }
    }
}
