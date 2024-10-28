import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();

		int caseNum = Integer.parseInt(buffer.readLine());

		for (int i = 0; i < caseNum; ++i) {
			int cnt = Integer.parseInt(buffer.readLine());
			builder.append("Material Management ").append(i + 1).append("\n");
			for (int j = 0; j <= cnt; ++j) {
				buffer.readLine();
			}
			builder.append("Classification ---- End!\n");
		}

		System.out.println(builder);
	}
}