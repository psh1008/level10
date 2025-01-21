package _12콜렉션멤버;

import java.util.Comparator;

public class MemberComp implements Comparator<Member>{

	enum SortBy{ID,NAME}
	enum SortDir{ASC,DESC}
	
	private SortBy sortBy;
	private SortDir sortDir;
	
	MemberComp(SortBy sortBy, SortDir sortDir) {
		super();
		this.sortBy = sortBy;
		this.sortDir = sortDir;
	}
	@Override
	public int compare(Member o1, Member o2) {
		int result = 0;
		switch(sortBy) {
		case NAME: result = o1.getName().compareTo(o2.getName());
		break;
		case ID: result = o1.getId().compareTo(o2.getId());
		break;
		}
		
		return result * (sortDir == sortDir.ASC ? 1: -1);
	}

}
