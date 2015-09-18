import java.util.Iterator;
import java.util.LinkedList;

/**
 * Algorithm: search from head for the specific animal (dog or cat) to dequeue.
 * Complexity: O(N) (search in linked list)
 *   Since the delete cause O(1), the bottleneck of complexity should be the searching.
 */
public class Solution36 {
	public static abstract class Animal {
		public abstract String toString();
	}
	public static class Dog extends Animal {
		private int id;
		public Dog(int id) {
			this.id = id;
		}
		public String toString() {
			return "Dog " + id;
		}
	}
	public static class Cat extends Animal {
		private int id;
		public Cat(int id) {
			this.id = id;
		}
		public String toString() {
			return "Cat " + id;
		}		
	}
	public static class AnimalShelter {
		LinkedList<Animal> animals = new LinkedList<Animal>(); 
		public void enqueue(Animal animal) {
			animals.add(animal);
		}
		public Animal dequeueAnimal() {
			Animal animal = animals.getFirst();
			animals.removeFirst();
			return animal;
		}
		public Dog dequeueDog() {
			Iterator<Animal> iter = animals.iterator();
			while (iter.hasNext()) {
				Animal animal = iter.next();
				if (animal instanceof Dog) {
					iter.remove();
					return (Dog)animal;
				}
			}
			return null;
		}
		public Cat dequeueCat() {
			Iterator<Animal> iter = animals.iterator();
			while (iter.hasNext()) {
				Animal animal = iter.next();
				if (animal instanceof Cat) {
					iter.remove();
					return (Cat)animal;
				}
			}
			return null;			
		}
	}
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(new Dog(1));
		shelter.enqueue(new Cat(1));
		shelter.enqueue(new Dog(2));
		shelter.enqueue(new Dog(3));
		shelter.enqueue(new Cat(2));
		shelter.enqueue(new Dog(4));
		shelter.enqueue(new Cat(3));
		shelter.enqueue(new Cat(4));
		shelter.enqueue(new Cat(5));
		System.out.println(shelter.dequeueAnimal().toString());
		System.out.println(shelter.dequeueDog().toString());
		System.out.println(shelter.dequeueCat().toString());
		System.out.println(shelter.dequeueCat().toString());
		System.out.println(shelter.dequeueCat().toString());
		System.out.println(shelter.dequeueAnimal().toString());
		System.out.println(shelter.dequeueAnimal().toString());
		System.out.println(shelter.dequeueCat().toString());
		System.out.println(shelter.dequeueAnimal().toString());
	}
}
