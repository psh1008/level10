package _12콜렉션멤버;

public class ActionSave implements Action{

	@Override
	public void excute() {
		if(!MemberDAO.getInstance().sizeCheck()) {
			System.out.println("저장할 회원이 없습니다");return;
		}
		Utils.getInstance().saveMemberList();
	}

}
