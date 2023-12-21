package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();

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

    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public MemberDTO login(String memberEmail, String memberPassword) {
        MemberDTO memberDTO = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                memberDTO = memberDTOList.get(i);
            }
        }
        return memberDTO;
    }

    public List<MemberDTO> findAll() {
        return memberDTOList;
    }

    public boolean passwordCheck(String loginEmail, String memberPassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // logingEmail과 같은 값 찾기.
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // 이메일을 찾은 후 그 이메일의 비밀번호와 같은 비밀번호인 지 찾기.
                if (memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                    result = true; // 맞으면 true
                }
            }
        }
        return result;
    }

    public boolean updatePassword(String loginEmail, String updatePassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // logingEmail과 같은 값 찾기.
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // loginEmail의 비밀번호를 바꿔주기.
                memberDTOList.get(i).setMemberPassword(updatePassword);
                result = true;
            }
        }
        return result;
    }

    public boolean updateName(String loginEmail, String updateName) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // loginEmail과 같은 값 찾기.
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // loginEmail의 이름을 바꿔주기
                memberDTOList.get(i).setMemberName(updateName);
                result = true;
            }
        }
        return result;
    }

    public boolean updateMobile(String loginEmail, String updateMobile) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // loginEmail과 같은 값 찾기.
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // loginEmail의 이름을 바꿔주기
                memberDTOList.get(i).setMemberMobile(updateMobile);
                result = true;
            }
        }
        return result;
    }


    public boolean delete(String loginEmail, String memberPassword) {
        boolean result = false;
        for (int i = 0; i < memberDTOList.size(); i++) {
            // logingEmail과 같은 값 찾기.
            if (loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                // 이메일을 찾은 후 그 이메일의 비밀번호와 같은 비밀번호인 지 찾기.
                if (memberPassword.equals(memberDTOList.get(i).getMemberPassword())) {
                    memberDTOList.remove(i); // 삭제하는 기능
                    result = true; // 맞으면 true
                }
            }
        }
        return result;
    }
}


