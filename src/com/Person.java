package com;

class Person{
	
	//person attributes
	private String name;
	private Person[] friends;
	int numFriends;
	
	//class constructor
	public Person(String name){
		friends = new Person[50];
		this.name = name;
		numFriends = 0;
	}
	
	//checks person's friends for goal. returns true if found, false if not found
	public boolean checkFriends(Person goal){
		int i = 0;
			
		while (this.friends[i] != null && i < 50){
			if (this.friends[i].name.equals(goal.name))
				return true;		
		}
			
		return false;
	}
	
	//method to retrieve persons name
	public String getName(){
		return this.name;
	}
	
	//method to retrieve persons friends
	public Person[] getFriends(){
		return this.friends;
	}
	//add second person to first person's friend list, return true upon success, false otherwise
	public void addFriend(Person newFriend){
		for (int i=0; i<50; i++){
			
			if (this.friends[i] == null){
				this.friends[i] = newFriend;
				this.numFriends++;
				return;
			}
			
			else if (this.friends[i].name.equals(newFriend.name)){
				System.out.println(newFriend.name + " is already friends with " + this.name);
				return;
			}
			
		}
	}
	
}