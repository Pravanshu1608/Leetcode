package DailyChallenges;

public class ZigZagSum {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 14}, {4, 5, 6, 15}, {7, 8, 9, 16}, {10, 11, 12, 17}};
        int sum = 0;
        int rows = a.length;
        int col = a[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(i==0 || i==rows-1){
                    sum += a[i][j];
                }else{
                    sum += a[rows-i-1][i];
                    break;
                }
            }
            //sum += a[rows-i-1][i];
        }
        System.out.println(sum);
    }
}
