package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _06스트림실습_기본 {

	public static List<Item> setData(){
		List<Item> itemList = new ArrayList<Item>();

		itemList.add(new Item(1001,"과자", "새우깡", 1500));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1003,"과자", "고래밥", 3000));
		itemList.add(new Item(1004,"음료수", "콜라", 500));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1006,"고기", "돼지고기", 20000));
		itemList.add(new Item(1005,"고기", "닭고기", 15000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1002,"음료수", "사이다", 1000));
		itemList.add(new Item(1008,"과자", "홈런볼", 3500));
		
		return itemList;
	}
	public static void main(String[] args) {
		
		
		List<Item> itemList = setData();
		
		
		// 문제 1번 전체 출력
		System.out.println("=====[ 1 ]=====");
		System.out.println(itemList);
		// 문제 2번 중복된 데이터 제거 후 출력
		System.out.println("=====[ 2 ]=====");
		List<Item> copyNames = itemList.stream().distinct().collect(Collectors.toList());
		System.out.println(copyNames);
		// 문제 3번 카테고리가 과자인 itemList 출력
		System.out.println("=====[ 3 ]=====");
		List<Item> copyNames3 = itemList.stream().filter(item -> "과자".equals(item.getCategroy())).collect(Collectors.toList());
		System.out.println(copyNames3);
		// 문제 4번 카테고리가 고기인 item 갯수 출력
		System.out.println("=====[ 4 ]=====");
		long itemCount = itemList.stream().filter(item ->"고기".equals(item.getCategroy())).count();
		System.out.println(itemCount+"개");
		// 문제 5번 가격이 10000원 이상인 값들의 ArrayList<Item> 만들기
		System.out.println("=====[ 5 ]=====");
		ArrayList<Item> copyList = (ArrayList<Item>) itemList.stream().filter(item -> item.getPrice() > 10000).distinct().collect(Collectors.toList());
		System.out.println(copyList);
		// 문제 6번 카테고리가 고기인 아이템 이름만 가져와서 ArrayList<String>으로 만들기
		System.out.println("=====[ 6 ]=====");
		ArrayList<String> meatName = (ArrayList<String>) itemList.stream().filter(item -> "고기".equals(item.getCategroy())).map(Item::getName).collect(Collectors.toList());
		System.out.println(meatName);
		// 문제 7번 아이템 번호로 정렬 후 출력
		System.out.println("=====[ 7 ]=====");
		ArrayList<Item> itemAscList = (ArrayList<Item>) itemList.stream().sorted(Comparator.comparingInt(Item::getItemNo)).collect(Collectors.toList());
		System.out.println(itemAscList);
				
		// 문제 8번 아이템 가격 순으로 정렬
		System.out.println("=====[ 8 ]=====");
		ArrayList<Item> itemSortedByPrice = (ArrayList<Item>) itemList.stream().sorted(Comparator.comparingInt(Item::getPrice)).collect(Collectors.toList());
		System.out.println(itemSortedByPrice);
	}

}
