package ch12_classes.ex03_member;

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
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                memberDTO = memberDTOList.get(i);
            }
        }
        return memberDTO;
    }

    public List<MemberDTO> memberList() {
        return memberDTOList;
    }

    public boolean updatePassword(String loginEmail, String updatePassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 LoginEmail과 같은 memberEmail 정보를 찾는 문장
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // memberDTOList.get(i) = 해당 인덱스에 접근 하여
                // setMemberMobile(memberMobile) = 해당 데이터에 member 값을 수정.
                memberDTOList.get(i).setMemberMobile(updatePassword);
                result = true;
            }
        }
        return result;
    }
    public boolean updateName(String loginEmail, String updateName) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 LoginEmail과 같은 memberEmail 정보를 찾는 문장
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // memberDTOList.get(i) = 해당 인덱스에 접근 하여
                // setMemberMobile(memberMobile) = 해당 데이터에 member 값을 수정.
                memberDTOList.get(i).setMemberMobile(updateName);
                result = true;
            }
        }
        return result;
    }
    public boolean updateMobile(String loginEmail, String updateMobile) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 LoginEmail과 같은 memberEmail 정보를 찾는 문장
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // memberDTOList.get(i) = 해당 인덱스에 접근 하여
                // setMemberMobile(memberMobile) = 해당 데이터에 member 값을 수정.
                memberDTOList.get(i).setMemberMobile(updateMobile);
                result = true;
            }
        }
        return result;
    }

    public boolean delete(String loginEmail, String memberPassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // memberDTOList.get(i) 인덱스에서 memberlogin 정보를 찾는 문장
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                memberDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

      public boolean emailCheck(String memberEmail) {
        boolean result = true;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // 중복되는 이메일이 있다 => 결과를 false로 주자
                result = false;
            }
        }
        return result;
    }
}
