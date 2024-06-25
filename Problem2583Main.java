package baekjoon;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class Problem2583Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int x = y1; x <= y2 - 1; x++) {
                for (int y = x1; y <= x2 - 1; y++) {
                    arr[x][y] = 1;
                }
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    dfs(arr, i, j);
                    list.add(answer);
                    answer = 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int element : list) {
            System.out.print(element+" ");
        }
    }

    private static void dfs(int[][] arr, int i, int j) {
        if (arr[i][j] == 1) {
            return;
        } else {
            answer++;
            arr[i][j] = 1;
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if(ni>=0&&ni<arr.length&&nj>=0&&nj<arr[0].length){
                    dfs(arr, ni, nj);
                }
            }
        }
    }
}

