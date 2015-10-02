
public class Solution58 {
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int col1 = x1 / 8;
		int col2 = x2 / 8;
		for (int col = col1; col <= col2; col++) {
			int start = 0;
			int end = 8;
			if (col == col1)
				start = x1 % 8;
			if (col == col2)
				end = x2 % 8 + 1;
			for (int i = start; i < end; i++) {
				screen[y * (width/8) + col] |= (1<<i);
			}
		}
	}
	public static void main(String[] args) {
		byte[] screen = new byte[10];
		int width = 16;
		int x1 = 4;
		int x2 = 9;
		int y = 3;
		drawLine(screen, width, x1, x2, y);
		for (int h = 0; h < screen.length / (width/8); h++) {
			for (int i = 0; i < width / 8; i++) {
				for (int b = 0; b < 8; b++) {
					if ((screen[h*(width/8) + i] & (1<<b)) == 0) {
						System.out.print("0");
					} else {
						System.out.print("1");
					}
				}
			}
			System.out.println("");
		}
	}
}
