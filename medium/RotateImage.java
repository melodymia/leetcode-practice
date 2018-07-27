//将图片顺时针旋转90度
//Solution 1 
/*
  每次循环换四个数字
  例如，
  1  2  3               【7】  2  【1】            7  【4】  1

  4  5  6      -->        4   5   6　　 -->  　  【8】  5  【2】　　

  7  8  9               【9】  8  【3】　　　　　    9  【6】  3

*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }
}


//Solution 2
/*
  先以对角线为翻转轴翻转，再以中轴为翻转轴翻转
  例如，
  1  2  3　　　 　9   6  【3】　　　　  7    4    1

  4  5  6　-->　 8  【5】  2　 -->  【8】 【5】 【2】　　

  7  8  9 　　　【7】  4   1　　　　    9    6    3
  
  或者
  
  1  2  3　　　 　【1】  4   7　　　　     7  【4】  1

  4  5  6　-->　   2  【5】  8　  -->    8  【5】  2　　

  7  8  9 　　　   3    6  【9】　　   　 9  【6】  3
*/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // along the left top to right bottom diagonal line, swap symmetrical pair
        for(int i=0; i<n; i++) {        // for each row
            for(int j=i+1; j<n; j++) {  // for each number
                // swap the pair
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // flip each row horizontally
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
                 
            }
        }
    }
}
