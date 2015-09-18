public class Solution31 {
	/**
	 * Assumption: stackID = 0 ~ 2
	 * Assumption: data type in container is integer
	 * divide the array into 3 segment, each segment present a stack. 
	 */
	public static class threeIsOne {
		private int[] array;
		private int[] start = new int[3];
		private int[] index = new int[3];
		public threeIsOne(int size) {
			array = new int[size];
			start[0] = index[0] = 0;
			start[1] = index[1] = size / 3;
			start[2] = index[2] = 2 * size / 3;
		}
		public void push(int stackID, int value) throws Exception {
			if (isFull(stackID))
				throw new Exception("full, can not push!");
			array[index[stackID]++] = value;
		}
		public void pop(int stackID) throws Exception {
			if (isEmpty(stackID))
				throw new Exception("empty, can not pop!");
			index[stackID]--;
		}
		public int peek(int stackID) throws Exception {
			if (isEmpty(stackID))
				throw new Exception("empty, can not peek!");
			return array[index[stackID] - 1];
		}
		public boolean isEmpty(int stackID) {
			return index[stackID] == start[stackID];
		}
		public boolean isFull(int stackID) {
			if (stackID == 2)
				return index[2] == array.length;
			return index[stackID] == start[stackID + 1];
		}
	}
	public static void main(String[] args) throws Exception {
		Solution31.threeIsOne stack3 = new Solution31.threeIsOne(100);
		stack3.push(0, 1);
		stack3.push(0, 2);
		stack3.push(0, 3);
		stack3.push(1, 101);
		stack3.push(1, 102);
		stack3.push(2, -1);
		stack3.push(2, -2);
		for (int stackID = 0; stackID < 3; stackID++) {
			System.out.print("pop from stack[" + stackID + "]: ");
			while (!stack3.isEmpty(stackID)) {
				System.out.print(stack3.peek(stackID) + " ");
				stack3.pop(stackID);				
			}
			System.out.println("");
		}
	}
}
