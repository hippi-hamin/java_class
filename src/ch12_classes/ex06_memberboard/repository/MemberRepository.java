package ch12_classes.ex06_memberboard.repository;

import ch12_classes.ex06_memberboard.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();

    public boolean save(MemberDTO memberDTO){
        return memberDTOList.add(memberDTO);
    }
}
