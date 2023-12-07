package ch08_string;

public class Ex01_String {
    public static void main(String[] args) {
        String str1 = "안녕";
        String str2 = "안녕";
        String str3 = new String("안녕"); // 제대로 String을 선언하려면 이런식으로 해야함.

        // str1, str2 같은 지
        System.out.println(str1 == str2);      // true   but 항상 맞다는 보장이 없음
        System.out.println(str1 == str3);      // false, 값은 같지만 다른 값...
                                               // 참조형 변수에선 ==으로 비교하는 건 스펙 부분에서의 비교라서 다름.
        System.out.println(str1.equals(str3)); // true
    }
}
