package _12콜렉션멤버;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		
		if(!MemberDAO.getInstance().sizeCheck()) {
			System.out.println("수정할 회원이 없습니다");return;
		}
		System.out.println("==== 회원수정 ====");
		String id = Utils.getInstance().getStringValue("수정할 아이디 입력 >>");
		int idx = MemberDAO.getInstance().CheckIdDup(id);
		if(idx == -1) {
			System.out.println("아이디가 존재하지 않습니다.");
		}else {
			String pw = Utils.getInstance().getStringValue("비밀번호 확인 >>");
			if(MemberDAO.getInstance().checkPw(pw, idx)) {
				MemberDAO.getInstance().updateUser(idx);
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
				return;
			}
			System.out.println("회원수정 완료");
		}
		
	}

}
