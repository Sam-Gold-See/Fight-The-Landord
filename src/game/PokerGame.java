package game;

import java.lang.reflect.Array;
import java.util.*;

public class PokerGame {

	static ArrayList<Integer> list = new ArrayList<>();
	static HashMap<Integer, String> hashMap = new HashMap<>();

	static {
		String[] colors = {"♣", "♦", "♥", "♠"};
		String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

		int index = 1;
		for (String number : numbers)
			for (String color : colors) {
				list.add(index);
				hashMap.put(index++, color + number);
			}
		list.add(index);
		hashMap.put(index++, "小王");

		list.add(index);
		hashMap.put(index++, "大王");
	}

	public PokerGame() {
		Collections.shuffle(list);

		TreeSet<Integer> lord = new TreeSet<>();
		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> player3 = new TreeSet<>();

		for (int i = 0; i < list.size(); i++) {
			int poker = list.get(i);
			if (i <= 2)
				lord.add(poker);
			else if (i % 3 == 0)
				player1.add(poker);
			else if (i % 3 == 1)
				player2.add(poker);
			else
				player3.add(poker);
		}

		lookPoker("底牌", lord);
		lookPoker("张三", player1);
		lookPoker("李四", player2);
		lookPoker("王五", player3);

	}

	public void lookPoker(String name, TreeSet<Integer> pokers) {
		System.out.print(name + ": ");
		for (int poker : pokers)
			System.out.print(hashMap.get(poker) + " ");
		System.out.println();
	}
}