package Hw0;


//a queue object to make BFS easier
//NOTE: The queue used for the friendgraph is assumed to be larger
//than the amount of people that are possibly added to the queue.
class Queue{
	
	//the actual person queue
	private Person[] queue;
	
	//The queue constructor. 
	//Construcs an empty queue of maxSize people
	public Queue(int maxSize){
		queue = new Person[maxSize];
	}
	
	//A method to add a person's friends list to the queue. 
	//checked represents all the people that we have already
	//checked in our search. Array represents the array we are adding to the queue.
	public void addFriends(Person[] checked, Person[] array){
		int i=0;
		int j=0;
		int k=0;
		boolean isChecked = false;
		
		while(i<queue.length && queue[i] != null){
			i++;
		}
		
		//iterate through array and add each person to the end of the queue
		while(array[j] != null && j<array.length && i<queue.length){
			isChecked = false;
			
			//Make sure the 
			while (checked[k] != null) {
				if (array[j].getName().equals(checked[k].getName())){
					isChecked = true;
				}
				k++;
			}
			
			if (!isChecked){
				queue[i] = array[j];
				i++;
			}
			
			j++;
		}
	}
	
	//add a single person to the queue
	public void addPerson(Person person){
		int i=0;
		
		while(queue[i] != null && i<queue.length){
			i++;
		}
		
		queue[i] = person;
		
	}
	
	//pop the first element off of the queue
	public Person pop(){
		Person ret = queue[0];
		int i = 0;
		
		if (queue[0] == null){
			System.out.println("Queue is empty, cannot pop.");
			return null;
		}
		
		//iterate through the queue shifting everything forward one.
		while (queue[i] != null && i<queue.length-1){
			if (queue[i+1] == null)
				queue[i] = null;
			else 
				queue[i] = queue[i+1];
			
			i++;
		}
		
		return ret;
	}
	
	//tell if the queue is empty or not
	public boolean isEmpty(){
		if (queue[0] == null) return true;
		else return false;
	}
	
	//print the queue
	public void print(){
		int i=0;
		
		while(queue[i] != null){
			System.out.println(i + ", " + queue[i].getName());
			i++;
		}
		
	}
}