package _12콜렉션멤버;

public class ActionInsert implements Action{

	@Override
	public void excute() {
		
		System.out.println("==== [ 회원가입 ] ====");
		
		// 추가하는 dao 연결
		String id = Utils.getInstance().getStringValue("ID 입력 >>");
		String pw = Utils.getInstance().getStringValue("PW 입력 >>");
		String name = Utils.getInstance().getStringValue("이름 입력 >>");
		
		
		if(MemberDAO.getInstance().CheckIdDup(id) != -1) {
			System.out.println("이미 존재하는 아이디 입니다");
			return;
		}
		MemberDAO.getInstance().addMember(id,pw,name);
		System.out.println("회원가입 완료");
		
	}

	
	
}
