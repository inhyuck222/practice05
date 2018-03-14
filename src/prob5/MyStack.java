package prob5;

public class MyStack<T> {
	private T[] buffer;
	private int size;
	private int top;

	@SuppressWarnings("unchecked")
	public MyStack(int size) {
		buffer = (T[])new Object[size];
		this.size = size;
		this.top = -1;
	}

	public void push(T pushValue) {
		if ((top + 1) >= size) {
			resize(size);
		}
		
		buffer[++top] = pushValue;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int recentSize) {
		int newSize = recentSize * 2;
		T[] newBuffer = (T[])new Object[newSize];
		
		for (int i = 0; i < recentSize; i++) {
			newBuffer[i] = buffer[i];
		}
		
		buffer = newBuffer;
		size = newSize;
	}

	public T pop() throws MyStackException {
		if (top < 0) {
			throw new MyStackException("stack is empty");
		}

		return buffer[top--];
	}
	
	public boolean isEmpty() {
		if(top < 0) {
			return true;
		}
		
		return false;
		
		//return top == -1;
	}	

}