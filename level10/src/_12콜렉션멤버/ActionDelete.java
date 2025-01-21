package _12콜렉션멤버;

public class ActionDelete implements Action{

	@Override
	public void excute() {
		if(!MemberDAO.getInstance().sizeCheck()) {
			System.out.println("삭제할 회원이 없습니다");return;
		}
		System.out.println("==== 회원삭제 ====");
		String id = Utils.getInstance().getStringValue("삭제할 아이디 입력 >>");
		int idx = MemberDAO.getInstance().CheckIdDup(id);
		if(idx == -1) {
			System.out.println("아이디가 존재하지 않습니다.");
		}else {
			MemberDAO.getInstance().delUserId(idx);
			System.out.println("회원삭제 완료");
		}
	}

}
