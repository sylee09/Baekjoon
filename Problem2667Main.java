package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Problem2667Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int area = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        int rowIdx = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder houseInfo = new StringBuilder();
            houseInfo.append(scanner.next());
            int idx = 0;
            while (idx < n) {
                arr[n - 1 - rowIdx][idx] = Integer.parseInt(String.valueOf(houseInfo.charAt(idx)));
                idx++;
            }
            rowIdx++;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 1) {
                    dfs(arr, i, j);
                    list.add(area);
                    area = 0;
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int element : list) {
            System.out.println(element);
        }
    }

    private static void dfs(int[][] arr, int i, int j) {
        if (arr[i][j] == 0) {
            return;
        } else {
            area++;
            arr[i][j] = 0;
            for (int k = 0; k < 4; k++) {
                int ni = dx[k] + i;
                int nj = dy[k] + j;
                if (ni >= 0 && ni < arr.length && nj >= 0 && nj < arr.length) {
                    dfs(arr, ni, nj);
                }
            }
        }
    }
}
