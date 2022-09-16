package helloworld;

import java.util.Scanner;

public class CircularLinkedList {
	class node {
		int data;
		node next;

		public node(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public static node head = null;
	static node tail = null;

	public void InsertAtFirst(int value) {
		node new_node = new node(value);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			new_node.next = head;
			head = new_node;
		}
		tail.next = head;

	}

	public void InsertAtLast(int value) {
		node new_node = new node(value);
		if (head == null) {
			head = new_node;
			tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
		tail.next = head;

	}

	public void InsertAtPosition(int value, int pos) {
		Scanner sc = new Scanner(System.in);
		node new_node = new node(value);
		if (head == null) {
			head = tail = new_node;

		}

		else if (pos == 1) {
			new_node.next = head;
			head = new_node;
		} else if (pos == GetLength()) {
			tail.next = new_node;
			tail = new_node;
		} else {
			node n = head;
			for (int i = 0; i < pos - 1; i++) {
				n = n.next;
			}
			new_node.next = n.next;
			n.next = new_node;

		}
		tail.next = head;

	}

	public static void DeleteAtFirst() {
		if (head == null) {
			System.out.println("LIST IS EMPTY: ");
		} else if (head.next == head) {
			head = null;
			tail = null;
		} else {

			// tail.next = head.next;
			head = head.next;

			tail.next = head;
		}

	}

	public void DeleteAtLast() {
		if (head == null) {
			System.out.println("LIST IS EMPTY: ");
		} else if (head.next == head) {
			head = null;
			tail = null;
		} else {
			node n1 = head;

			while (n1.next != tail) {
				n1 = n1.next;
			}
			tail = n1;
			n1.next = head;
		}
	}

	public void DeleteAtPosition(int pos) {

		if (head == null) {
			System.out.println("LIST IS EMPTY: ");
		} else if (pos == 1) {
			DeleteAtFirst();
		} else if (head.next == head) {
			head = tail = null;
		} else if (pos < 0 || pos > GetLength()) {
			System.out.println("INVALID POSITION: ");
		} else {
			node n1 = head;
			node n2 = head;
			for (int i = 1; i < pos; i++) {
				n2 = n1;
				n1 = n1.next;
			}
			n2.next = n1.next;

			tail.next = head;
		}
	}

	public static int GetLength() {
		int count = 1;
		if (head == null) {
			return 0;
		} else {
			node n = head;

			do {
				count++;
				n = n.next;

			} while (n != tail);

		}
		return count;
	}

	public void Display() {
		if (head == null) {
			System.out.println("SORRY!!!  LIST IS EMPTY: ");
		} else {
			node n = head;
			do {
				System.out.print(" " + n.data);
				n = n.next;
			} while (n != head);
			System.out.println();
		}

	}

	public static void main(String args[]) {
		CircularLinkedList list = new CircularLinkedList();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.InsertAtFirst");
			System.out.println("2.InsertAtLast");
			System.out.println("3.InsertAtPosition");
			System.out.println("4.DeleteAtFirst");
			System.out.println("5.DeleteAtLast");
			System.out.println("6.DeleteAtPosition");
			System.out.println("7.GetLength");
			System.out.println("8.Display");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				int x;
				System.out.println("Enter value: ");
				x = sc.nextInt();
				list.InsertAtFirst(x);
				break;
			case 2:
				int y;
				System.out.println("Enter value: ");
				y = sc.nextInt();
				list.InsertAtLast(y);
				break;
			case 3:
				int z, pos;
				System.out.println("Enter Position: ");
				pos = sc.nextInt();
				if (pos < 0 || pos > GetLength()) {
					System.out.println("INVALID POSITION: ");
				} else {
					System.out.println("Enter value: ");
					z = sc.nextInt();
					list.InsertAtPosition(z, pos);
				}
				break;
			case 4:
				list.DeleteAtFirst();
				break;
			case 5:
				list.DeleteAtLast();
				break;
			case 6:
				int pos1 = 0;
				System.out.println("Enter position: ");
				pos1 = sc.nextInt();
				list.DeleteAtPosition(pos1);
				break;

			case 7:
				list.GetLength();
				break;
			case 8:
				list.Display();
				break;

			}

		}

	}
}
