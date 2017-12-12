package com;


class FriendGraph{
	
	//FriendGraph attributes
	private static final int MAX_PEOPLE = 50;
	private static final int MAX_QUEUE_SIZE = 300;
	private Person[] people;
	int numPeople;
	Queue queue = new Queue(MAX_QUEUE_SIZE);
	
	//FriendGraph constructor
	public FriendGraph(){
		this.people = new Person[MAX_PEOPLE];
		numPeople = 0;
	}
	
	//add a person to our friendgraph
	public void addPerson(Person person){
		
		//iterate through people in friendgraph
		for (int i=0; i<MAX_PEOPLE; i++){
			
			//if this person slot is empty
			if (this.people[i] == null){
				this.people[i] = person;
				this.numPeople++;
				return;
			}
			
			//if new persons name has already been added
			else if (this.people[i].getName().equals(person.getName())){
				System.out.println("Cannot add two people with same name!");
				return;
			}
			
			//person cannot be added because friendgraph is full
			else if (i == MAX_PEOPLE-1){
				System.out.println("FriendGraph is currently full!");
				return;
			}
		}
		
	}
	
	//add a friendship between two people in the graph
	public void addFriendship(String n1, String n2){
		Person p1, p2;
		p1 = this.getPerson(n1);
		p2 = this.getPerson(n2);
		
		if (n1.equals(n2)){
			System.out.println("The two names are the same, cannot create friendship.");
			return;
		}
		if (p1 != null && p2 != null){
			if (p1.numFriends < 50 && p2.numFriends < 50){
				p1.addFriend(p2);
				p2.addFriend(p1);
			}
		}
	}
	
	//get person from person name
	private Person getPerson(String name){
		
		for (int i=0; i<MAX_PEOPLE; i++){	
			//if we found the person with this name
			if (this.people[i] == null) break;
			
			if (this.people[i].getName().equals(name))
				return this.people[i];	
		}
		
		//if we did not find a person
		System.out.println("Person " + name + " Not Found!");
		return null;
	}
	
	
	public int getDistance(String n1, String n2){
		Person p1 = getPerson(n1);
		Person curPerson;
		int i=0, j=0;
		int distance = 1;
		Person[] checked = new Person[MAX_PEOPLE];
		
		queue.addPerson(p1);
		
		//if the names are equal, distance is 0
		if (n1.equals(n2)) return 0;
		
		//This loop is the heart of the BFS. While there are still things in the queue,
		//we know that people still need to be searched.
		while (!queue.isEmpty()){
			
			//pop the current person off of the fron of the queue
			curPerson = queue.pop();
			
			//add this current person to the list of already checked people in our search.
			while (checked[j] != null) j++;
			checked[j] = curPerson;
			
			//iterate through current persons friends, if we find our person,
			//return the current distance.
			while (curPerson.getFriends()[i] != null){
				if (curPerson.getFriends()[i].getName().equals(n2)) return distance;
				i++;
			}
			
			//if person wasnt found, add that persons friends that haven't already been
			//checked to the end of the queue, increment the distance.
			queue.addFriends(checked, curPerson.getFriends());
			distance++;
		}
		return -1;
	}
	
			
}