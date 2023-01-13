public class A566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(m *n != r*c) return mat;

        int index1 = 0;  //r
        int index2 = 0;  //c
        int[][] res = new int[r][c];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(index2 < c){
                    res[index1][index2] = mat[i][j];
                    index2 ++;
                } else{
                    index1 ++;
                    index2 = 0;
                    j--;
                }
            }
        }
        return res;
    }
}
