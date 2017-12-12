package Hw0;

class Main{
	
	public static void main(String[] args){
		FriendGraph graph = new FriendGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addPerson(rachel);
		graph.addPerson(ross);
		graph.addPerson(ben);
		graph.addPerson(kramer);
		graph.addFriendship("Rachel", "Ross");
		graph.addFriendship("Ross", "Ben");
		
		System.out.println(graph.getDistance("Rachel", "Ross")); // should print 1
		System.out.println(graph.getDistance("Rachel", "Ben")); // should print 2
		System.out.println(graph.getDistance("Rachel", "Rachel")); // should print 0
		System.out.println(graph.getDistance("Rachel", "Kramer")); // should print -1
	}
}