import java.util.Arrays;
import java.util.Iterator;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println("Original List "+list.toString());
		
		System.out.println(list.set(0,"Anna"));
		
		System.out.println("Changed List "+list.toString());
		
		

		//LinkedList<String> sub = (LinkedList<String>) list.getSubList(0, 1);
		//		System.out.println(sub.size());
		//		System.out.println(sub.get(0));
		//		System.out.println(sub.get(1));
		//		System.out.println( toArray(sub));


	}

	private static Object[] toArray(LinkedList<String> list) {
		Object[] result = new Object[list.size()];
		Iterator<String> it = list.iterator();
		int index = 0;
		while( it.hasNext() ){
			result[index] = it.next();
			index++;
		}
		return result;
	}
}
