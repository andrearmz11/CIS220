//Andrea Ramirez 
//Chpt5 PA

//This program shows how a queue works using a linked list.
// It adds, removes, and displays items in the queue.
// Each item is a node that points to the next one.

// Define a Node class to represent each element in the queue
class Node {
    int data;
    Node next;

    // Constructor to initialize a new node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Define a Queue class to represent the queue implemented as a linked list 
class Queue {
    Node front;
    Node rear;

    // Constructor to initialize an empty queue
    public Queue() {
        front = null;
        rear = null;
    }
	
	// Enqueue operation: adds an item to the end of the queue, pseudocode found in PA 5.5.1
    public void enqueue(int item) {
        // Allocate new node and assign data
        // newNode.next is automatically set to null in the Node constructor
		Node newNode = new Node(item);
        
        if (front == null) {
            // If the queue is empty, set front to the new node
            front = newNode;
        } else {
            // Otherwise, link the new node at the end of the queue
            rear.next = newNode;
        }
        // Update the rear pointer to the new node
        rear = newNode;
    }
    
    // Dequeue operation: removes and returns the item from the front of the queue, pseudocode found in PA 5.5.1
    public int dequeue() {
		// If queue is empty return -1 (assuming only positive integers will be added) 
        if (front == null) {
            return -1;
        }
        // Save the data from the front node
        int dequeuedItem = front.data;
        // Move the front pointer to the next node
        front = front.next;
        // If the queue becomes empty, update the rear pointer to null
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty() {
            return front == null;
    }
    
    // Method to peek at the front item without removing it
    public int peek() {
             if (front == null) {
            return 0;
        }
        return front.data;
    }

    // Method to get the length of the queue
    public int getLength() {
        int count = 0;
        Node current = front;

        // Traverse the queue to count the number of nodes
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }	
	
    // Method to traverse and print the list, pseudocode found in PA 4.8.1
		public void displayQueue() {
			Node current = front;
			if (current == null) {
				System.out.println("NULL");
				return;
			}	
			while (current != null) {
				System.out.print(current.data);
				if (current.next != null) {
					System.out.print(" -> ");
				}
				current = current.next;
			}	
			System.out.println(" -> NULL");
		}
}

// Main class to demonstrate the queue operations
public class QueueAsLinkedList {
    public static void main(String[] args) {
		        Queue queue = new Queue();
				
        queue.displayQueue();

        // Check if the queue is empty
        System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
        System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");

        // Print the queue's length
        System.out.println("The queue's length is: " + queue.getLength());

        // Enqueue item 
        queue.enqueue(1);
        queue.enqueue(2);

        // Print the item on the top 
        System.out.println("The top item on the queue is: " + queue.peek());

        // Enqueue item
        queue.enqueue(3);

        // Print the queue's length
        System.out.println("The queue's length is: " + queue.getLength());

        // Dequeue an item
        int item = queue.dequeue();
        System.out.println("Item " + item + " was removed from the queue.");

        // Print the item on the top 
        System.out.println("The top item on the queue is: " + queue.peek());

        // Enqueue item
        queue.enqueue(4);

        // Display the queue
        queue.displayQueue();

        // Enqueue item
        queue.enqueue(5);

        // Dequeue an item
        item = queue.dequeue();
        System.out.println("Item " + item + " was removed from the queue.");

        // Enqueue item
        queue.enqueue(6);

        // Print the queue's length
        System.out.println("The queue's length is: " + queue.getLength());

        // Display the queue
        queue.displayQueue();

        // Dequeue an item
        item = queue.dequeue();
        System.out.println("Item " + item + " was removed from the queue.");

        // Check if the queue is empty
        System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");

        // Dequeue an item
        item = queue.dequeue();
        System.out.println("Item " + item + " was removed from the queue.");
        item = queue.dequeue();
        System.out.println("Item " + item + " was removed from the queue.");

        // Print the queue's length
        System.out.println("The queue's length is: " + queue.getLength());

        // Dequeue items
        item = queue.dequeue();
        if (item != -1) {
            System.out.println("Item " + item + " was removed from the queue.");
		} else { 
			System.out.println("An item was not dequeued.");
		}
		
        item = queue.dequeue();

        if (item != -1) {
            System.out.println("Item " + item + " was removed from the queue.");
		} else {
			System.out.println("An item was not dequeued.");
		} 
        // Check if the queue is empty
        System.out.println(queue.isEmpty() ? "The queue is empty." : "The queue is not empty.");
    }

}
