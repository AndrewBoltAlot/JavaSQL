package mapsql.util;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
	private class Node implements Position<T> {
		T element;
		Node next, prev;
		
		public Node(T element) {
			this.element = element;
		}

		@Override
		public T element() {
			return element;
		}
	}
	
	Node front, rear;
	int size = 0;
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Position<T> first() {
		if (front == null) throw new ListEmptyException();
		return front;
	}

	@Override
	public Position<T> last() {
		if (rear == null) throw new ListEmptyException();
		return rear;
	}

	@Override
	public Position<T> prev(Position<T> p) {
		return ((Node) p).prev;
	}

	@Override
	public Position<T> next(Position<T> p) {
		return ((Node) p).next;
	}

	@Override
	public Position<T> insertFirst(T e) {
		Node n = new Node(e);
		if (front == null) {
			rear = n;
		} else {
			n.next = front;
			front.prev = n;
		}
		front = n;
		size++;
		return n;
	}

	@Override
	public Position<T> insertLast(T e) {
		Node n = new Node(e);
		if (rear == null) {
			front = n;
		} else {
			n.prev = rear;
			rear.next = n;
		}
		rear = n;
		size++;
		return n;
	}

	@Override
	public Position<T> insertBefore(Position<T> p, T e) {
		if (p == front) return insertFirst(e);
		
		Node node = (Node) p;
		
		Node n = new Node(e);
		n.prev = node.prev;
		n.next = node;
		node.prev.next = n;
		node.prev = n;
		size++;
		return n;
	}

	@Override
	public Position<T> insertAfter(Position<T> p, T e) {
		if (p == rear) return insertLast(e);
		
		Node node = (Node) p;
		
		Node n = new Node(e);
		n.next = node.next;
		n.prev = node;
		node.next.prev = n;
		node.next = n;
		size++;
		return n;
	}

	@Override
	public T replace(Position<T> p, T e) {
		T temp = p.element();
		((Node) p).element = e;
		return temp;
	}

	@Override
	public T remove(Position<T> p) {
		Node current = front;
		while (current != null) {
			if(current.element() == p.element()) {
				if (current == front && current == rear) {
					front = rear = null;
				} else if (current == front) {
					front = current.next;
				} else if (current == rear) {
					rear = current.prev;
				} else {
					Node temp = current;
					current.prev.next = current.next;
					temp = null;
				}
			}
			current = current.next;
		}

		size--;
		return p.element();
	}

	public String toString() {
		if (size == 0) return "";
		
		String output = "[" + size + "]";
		Node c = front;
		while (c != null) {
			output += " " + c.element;
			c = c.next;
		}
		return output;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Position<T> current;

			@Override
			public boolean hasNext() {
				if (isEmpty()) return false;
				if (current == null) return true;
				return !current.equals(last());
			}

			@Override
			public T next() {
				if (current == null) {
					current = first();
				} else {
					current = LinkedList.this.next(current);
				}
				return current.element();
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
