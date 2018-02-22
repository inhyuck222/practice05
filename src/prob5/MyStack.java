package prob5;

public class MyStack {
	private String[] buffer;
	private int size;
	private int top;

	public MyStack(int size) {
		buffer = new String[size];
		this.size = size;
		this.top = -1;
	}

	public void push(String pushValue) {
		if ((top + 1) >= size) {
			resize(size);
		}
		
		buffer[++top] = pushValue;
	}
	
	public void resize(int recentSize) {
		int newSize = recentSize * 2;
		String[] newBuffer = new String[newSize];
		
		for (int i = 0; i < recentSize; i++) {
			newBuffer[i] = buffer[i];
		}
		
		buffer = newBuffer;
		size = newSize;
	}

	public String pop() throws MyStackException {
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
	}	

}