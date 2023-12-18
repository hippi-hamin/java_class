package ch12_classes.ex03;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();

    /**
     * 회원가입 메서드
     * name: save
     * parameter: memberDTO
     * return: boolean
     * 실행내용
     * Service로 부터 전달 받은 DTO 객체를 리스트에 저장하고 결과를 리턴
     */
    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    /**
     * 로그인 메서드
     * name: login
     * parameter: String
     * return: MemberDTO
     * 실행내용
     * Service로 부터 도서제목을 전달받고 일치하는 결과를 찾아서 DTO를 리턴
     * 없으면 null 리턴
     */
    public MemberDTO login(String memberEmail, String memberPassword) {
        // id 와 일치하는 데이터가 있으면 해당 DTO - 객체를 리턴하고
        // 없으면 null을 리턴함
        MemberDTO memberDTO = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPassword.equals(memberDTOList.get(i).getMemberPassword())){
                memberDTO = memberDTOList.get(i);
            }
        }
        return memberDTO;
    }
}
