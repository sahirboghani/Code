import java.util.*;

class train {

	static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();	
	static String ans = "";
	static boolean found = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = Integer.parseInt(sc.nextLine());

		while(N-- > 0) {

			String[] in = sc.nextLine().split(" "); 

			String source = in[0];

			ArrayList<String> temp;

			if(map.containsKey(source))
				temp = map.get(source);
			else {
				temp = new ArrayList<String>();
				map.put(source, temp);
			}

			for(int i = 1; i != in.length; ++i) {

				String dest = in[i];

				if(!temp.contains(dest)) {
					temp.add(dest);
				}

				if(!map.containsKey(dest))
					map.put(dest, new ArrayList<String>());
		
				if(!map.get(dest).contains(source))
					map.get(dest).add(source);
			}
		}

		for (String ss: map.keySet()) {

			ArrayList<String> me = map.get(ss);
			System.out.print(ss + ": ");
			for(String sss: me)
				System.out.print(sss + " ");

			System.out.println();

		}

		String start = sc.next();
		String end = sc.next();

		ArrayList<String> al = new ArrayList<String>();
		al.add(start);
		search(end, al);

		if(ans.equals(""))
			System.out.println("no route found");
	}

	public static void search(String d, ArrayList<String> path) {
	
		if(found)
			return;

		String me = path.get(path.size()-1);

		if(me.equals(d)) {
			for(String ss: path)
				ans += ss + " ";
			System.out.println(ans.substring(0,ans.length()-1));
			found = true;
			return;
		}

		ArrayList<String> neighbors = map.get(me);

		for(String ss: neighbors) {	
				
			if(!path.contains(ss)) {
			
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 0; i != path.size(); ++i)
					temp.add(path.get(i));

				temp.add(ss);
				search(d, temp);
			}
		} 

	}

}
