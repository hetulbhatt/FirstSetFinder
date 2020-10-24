import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class FirstFinder {
	static Map<String,String> map;
	static Map<String,Set<Character>> output;
	static List<String> orderMaintainer;
	public static void main(String[] args) {
		
		map = new HashMap<>();
		orderMaintainer = new ArrayList<>();
		output = new HashMap<>();

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Number of production rules (CFG statements)? ");
		int rules = Integer.parseInt(sc.nextLine());

		for(int i=0; i<rules; i++) {
			System.out.print("Non-terminal "+(i+1)+": ");
			String key = sc.nextLine();
			System.out.print("Production rule (put pipe to seperate): ");
			String val = sc.nextLine();
			orderMaintainer.add(key);
			map.put(key,val);
		}
		sc.close();

		System.out.println("\nProvided production rules: ");
		for(String key : orderMaintainer) {
			System.out.println(key+" -> "+map.get(key));
			output.put(key,first(key));
		}
		
		System.out.println("\nFirst of:");
		for(String key : orderMaintainer) {
			System.out.println(key+" =FIRST> "+output.get(key));
		}
	}

	public static Set<Character> first(String key) {
		String rule = (String)map.get(key);
		String[] prods = rule.split("\\|");
		Set<Character> set = new TreeSet<>();
		boolean[] prodHavingNulls = new boolean[prods.length];

		for(int index=0; index<prods.length; index++) {

			String prod = prods[index];
			
			for(int i=0; i<prod.length(); i++) {
				if(prod.charAt(i) == '#') {
					set.add('#');
					prodHavingNulls[index] = true;
				} else if(!Character.isUpperCase(prod.charAt(i))) {
					set.add(prod.charAt(i));
					prodHavingNulls[index] = false;
					set.remove('#');
					break;
				} else {
					Set<Character> temp = first(Character.toString(prod.charAt(i)));
					for(char x : temp) {
						set.add(x);
					}
					if(!temp.contains('#')) {
						prodHavingNulls[index] = false;
						break;
					} else {
						prodHavingNulls[index] = true;
					}
				}
			}
		}

		if(set.contains('#')) {
			set.remove('#');
		}
		for(boolean b : prodHavingNulls) {
			if(b) {
				set.add('#');
				break;
			}
		}

		return set; 
	}
}
