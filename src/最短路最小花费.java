import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PC on 2017/8/8.
 */
public class 最短路最小花费 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] length = new int[n][n];
        int[][] value = new int[n][n];
        init(length);
        init(value);
        for(int i = 0;i<m;i++){
            int x = input.nextInt();
            int y = input.nextInt();
            length[y-1][x-1]=length[x-1][y-1] = input.nextInt();
            value[y-1][x-1]=value[x-1][y-1] = input.nextInt();
        }
        print(length);
        int start,end;
        while(true){
            start = input.nextInt();
            end = input.nextInt();
            if(start==0&&end==0)break;
            dijkstra(length,value,start-1,end-1);
        }
    }
    public static void dijkstra(int[][] length,int[][] value,int start,int end){
        //prepare
        if(length[start][start]==0){
            System.out.println(length[start][end]+" "+value[start][end]);
            return;
        }
        int n = length.length;
        boolean[] visited = new boolean[n];
        //init
        visited[start]=true;
        length[start][start]=0;
        value[start][start]=0;
        //start
        for(int i = 1;i < n;i++){
            int k = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<n;j++){
                if(!visited[j]&&length[start][j]<min){
                    min = length[start][j];
                    k = j;
                }
            }
            visited[k] = true;
            for(int j = 0;j<n;j++){
                if(!visited[j]&&length[start][k]+length[k][j]<length[start][j]){
                    length[start][j]=length[start][k]+length[k][j];
                    value[start][j]=value[start][k]+value[k][j];
                }else if(!visited[j]&&length[start][j]==length[start][k]+length[k][j]&&value[start][k]+value[k][j]<value[start][j]){
                    value[start][j]=value[start][k]+value[k][j];
                }
            }
        }
        System.out.println(length[start][end]+" "+value[start][end]);
    }
    public static void dij(int[][] length,int start,int end){
        int n = length.length;
        boolean[] visited = new boolean[n];
        length[start][start] = 0;
        visited[start] = true;
        for(int i = 0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int j = 0;j<n;j++){
                if(!visited[j]){
                    min = length[start][j];
                    minIndex = j;
                }
            }
            visited[minIndex]=true;
            for(int j = 0;j<n;j++){
                if(!visited[j]){
                    if(length[start][minIndex]+length[minIndex][j]<length[start][j]){
                        length[start][j] = length[start][minIndex]+length[minIndex][j];
                    }
                }
            }
        }
        System.out.println(length[start][end]);
    }
    public static void init(int[][] a){
        for(int i =0;i<a.length;i++)init(a[i]);
    }
    public static void init(int[] a){
        for(int j = 0;j<a.length;j++)a[j]=Integer.MAX_VALUE;
    }
    public static void print(int[][] a){
        for(int i =0;i<a.length;i++)System.out.println(Arrays.toString(a[i]));
    }
}
