import java.util.Scanner;

class Task {
	public int job;
	public int priority;

	public Task(int job, int priority) {
		this.job = job;
		this.priority = priority;
	}
}

public class Queue implements Priority {

	public Task task[];
	public int capacity;
	public int size;

	public Queue(int capacity) {
		this.capacity = capacity;
		task = new Task[this.capacity];
		this.size = 0;
	}

	public Task[] getTask() {
		return this.task;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public boolean isFull() {
		return this.size == this.capacity;
	}

	/*
	 * Adding Element to Queue
	 * 
	 * @param value to be added in Queue
	 * 
	 * @priority of task
	 */

	@Override
	public void enqueue(int val, int priority) {
		if (isFull()) {
			throw new AssertionError("Queue is Full");
		}

		Task newJob = new Task(val, priority);
		boolean flag = false;
		for (int i = 0; i < this.size; i++) {
			if (this.task[i].priority < priority) {
				int move = size;
				while (i <= move) {
					this.task[move + 1] = this.task[move];
					move--;
				}
				task[i] = newJob;
				size++;
				flag = true;
				break;
			}
		}
		if (!flag) {
			task[size++] = newJob;
		}
	}

	/*
	 * Remove an Element from Queue
	 */

	@Override
	public int dequeue() {
		if (isEmpty()) {
			throw new AssertionError("Empty Queue");
		}
		int data = task[0].job;
		for (int i = 1; i < size; i++) {
			task[i - 1] = task[i];
			size--;
		}
		return data;
	}

	/*
	 * Get TopMost Element of Queue
	 */

	@Override
	public int peek() {
		if (isEmpty()) {
			throw new AssertionError("Empty List");
		}

		int data = task[0].job;
		return data;
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int i;
		System.out.println("Enter the size of queue : ");
		int sizeOfQueue = sc.nextInt();
		Queue queue=new Queue(sizeOfQueue+1);
		System.out.println("\n===================================================================================================================================================");
		for(i = 0; i< sizeOfQueue; i++){
			System.out.println("Enter the job : ");
			int job = sc.nextInt();
			System.out.println("Enter the priority of job : ");
			int priority = sc.nextInt();
			System.out.println("\n===================================================================================================================================================");
			queue.enqueue(job, priority);
		}
		System.out.println("The Job at the peek is : " + queue.peek());
		System.out.println("The Job after dequeue is : " + queue.dequeue());
		System.out.println("The Job after dequeue is : " + queue.dequeue());
	}
}
