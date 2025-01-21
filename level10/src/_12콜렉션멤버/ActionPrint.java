package _12콜렉션멤버;

public class ActionPrint implements Action{

	@Override
	public void excute() {
		if(!MemberDAO.getInstance().sizeCheck()) {
			System.out.println("출력할 회원이 없습니다");return;
		}
		System.out.println("==== 전체회원 출력 ====");
		MemberDAO.getInstance().printAll();
		
	}

}
