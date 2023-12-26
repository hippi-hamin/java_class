package ch13_map;

import java.util.HashMap;
import java.util.Map;

public class Ex01_MapBasic {
    public static void main(String[] args) {
        // key : 정수(Integer), Value : String
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "안녕");
        map1.put(2, "Hello");
//        map1.put(3, 100); // value 타입 불일치
//        map1.put("4", "안녕하세요"); // key 타입 불일치
        // key가 1인 데이터
        System.out.println(map1.get(1));
        String s1 = map1.get(2);
        System.out.println("s1 = " + s1);
        map1.put(100, "메롱");
        // 동일한 키에 다른 데이터를 넣는다면 덮어쓰기 처럼 됨
        map1.put(1, "안녕하십니까");
        System.out.println(map1.get(1));
        // 반복문으로 접근
        for (Integer i : map1.keySet()) {
            System.out.println("i = " + i); // key 값만 출력됨.
        }

        // key : String, value : String
        Map<String, String> map2 = new HashMap<>();
        map2.put("가", "안녕");
        map2.put("나", "ㅎㅎㅎ");
        map2.put("a", "ㅋㅋㅋ");
        System.out.println(map2.get("a"));

        // 반복문
        for (String s : map2.keySet()) {
            System.out.println(map2.get(s));
        }

        Map<Long, String> map3 = new HashMap<>();
        String ss1 = map3.put(1L, "안녕");
        System.out.println("ss1 = " + ss1); // null
        String ss2 = map3.put(2L, "hello");
        System.out.println("ss2 = " + ss2); // null
        String ss3 = map3.put(1L, "안녕하세요");
        System.out.println("ss3 = " + ss3); // 안녕

        // 키에다가 처음 저장하는 거라면 null but 이 키에 새로운 값을 저장한다면 이전에 저장되있던 값을 호출
    }
}
