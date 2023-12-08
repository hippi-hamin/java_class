package ch09_array;

public class Ex07_ArrayEx {
    public static void main(String[] args) {
        int[] num = {3, 2, 1, 5, 4};
        int temp = 0; // swap을 위한 중간 저장용 변수
        /* 위와 같은 배열이 있을 때
         * {1, 2, 3, 4, 5} 와 같이 오름차순 정렬을 하는 코드를 작성 해봅시다.
         */

        // 중첩 for를 이용하여 정렬하기
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if(num[i] > num[j]){
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }
}