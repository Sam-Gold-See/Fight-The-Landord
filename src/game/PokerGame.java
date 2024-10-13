package game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PokerGame {

	static ArrayList<String> list = new ArrayList<>();

	static {
		String[] colors = {"♣", "♦", "♥", "♠"};
		String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

		for(String color : colors)
			for(String number : numbers)
				list.add(color + number);
		list.add("小王");
		list.add("大王");
	}

	public PokerGame() {
		Collections.shuffle(list);

		ArrayList<String> lord = new ArrayList<>();
		ArrayList<String> player1 = new ArrayList<>();
		ArrayList<String> player2 = new ArrayList<>();
		ArrayList<String> player3 = new ArrayList<>();

		for(int i=0;i<list.size();i++){
			String poker = list.get(i);
			if(i<=2)
				lord.add(poker);
			else if(i%3==0)
				player1.add(poker);
			else if(i%3==1)
				player2.add(poker);
			else
				player3.add(poker);
		}

		lookPoker("底牌",lord);
		lookPoker("张三",player1);
		lookPoker("李四",player2);
		lookPoker("王五",player3);
	}

	public void lookPoker(String name, ArrayList<String> list) {
		System.out.print(name + ":");
		for(String poker:list)
			System.out.print(poker+" ");
		System.out.println();
	}
}