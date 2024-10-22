import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int parkingLotCnt;
	static int carCnt;
	static PriorityQueue<Integer> emptyQue = new PriorityQueue<>();
	static ArrayList<Integer> waitList = new ArrayList<>();
	static ArrayList<Integer> inOutList = new ArrayList<>();
	static int[] parking;
	static int[] parkingCost;
	static int[] carWeight;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(buffer.readLine());

		parkingLotCnt = Integer.parseInt(token.nextToken());
		carCnt = Integer.parseInt(token.nextToken());

		parkingCost = new int[parkingLotCnt];
		parking = new int[carCnt + 1];
		carWeight = new int[carCnt + 1];
		for (int i = 0; i < parkingLotCnt; i++) {
			int value = Integer.parseInt(buffer.readLine());
			parkingCost[i] = value;
			emptyQue.add(i);
		}

		for (int i = 1; i <= carCnt; i++) {
			int value = Integer.parseInt(buffer.readLine());
			carWeight[i] = value;
		}

		for (int i = 0; i < carCnt * 2; i++) {
			int value = Integer.parseInt(buffer.readLine());
			inOutList.add(value);
		}
		Arrays.fill(parking, -1);
		calculateCost();
		System.out.println(result);
	}

	public static void calculateCost() {
		while (!inOutList.isEmpty() || !waitList.isEmpty()) {
			int target = 0;

			if (inOutList.isEmpty()) {
				target = waitList.get(0);
				waitList.remove(0);
			} else {
				target = inOutList.get(0);
				inOutList.remove(0);
			}

			if (target > 0) {
				if (!emptyQue.isEmpty()) {
					int parkingNum = emptyQue.poll();
					parking[target] = parkingNum;
					result += (carWeight[target] * parkingCost[parkingNum]);
				} else {
					waitList.add(target);
				}
			} else {
				target *= -1;
				int parkingNum = parking[target];
				parking[target] = -1;
				emptyQue.add(parkingNum);
				if (!waitList.isEmpty()) {
					parkingNum = emptyQue.poll();
					target = waitList.get(0);
					waitList.remove(0);
					parking[target] = parkingNum;
					result += (carWeight[target] * parkingCost[parkingNum]);
				}
			}
		}
	}
}
