/**
 * @program: AlgorithmSelf
 * @description: 判断一个矩阵中是否包含某个字符串所有字符的路径，T12 P89（剑值Offer）
 * @author: tan.xc
 * @create: 2021-06-24
 */

/**过程中存在的问题：
 * 1.递归方法中的判断条件
 * 2.递归方法中的返回条件：字符串已经被检索完毕，则直接进行返回
 * */
public class hasPath {
    public static void main(String[] args){
        char[][] arr = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
                        };
        String str = "cfbtgsh";
        int rows = arr.length;
        int cols = arr[0].length;
        boolean result = hasPath(arr, rows, cols, str);
        System.out.println(result);
    }
    /**
     *@Description:  涉及这种二维数组，类似于存在路径的问题，都是采用回溯方法来判断是否存在
     *@Param: [arr, str]
     *@return: boolean
     *@Author: tan.xc
     *@date: 2021/6/24
     */
    public static boolean hasPath(char[][] arr,int rows,int cols,String str){
        //1.首先找到字符串的首字符所在位置
        //2.看下一步能达到的字符是否有满足条件的，如果有，则继续往下找，如果没有，则回到上一步的选择步骤，重新选择另一个选择进行下一步的跳转

        boolean[][] arr2 = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPath2(arr,str,rows,cols,i,j,0,arr2)){
                    return true;
                };
            }
        }
        return false;
    }
    /**
     *@Description: 判断当前 arr[row][col] 是否可达，可达返回ture,不可达返回false
     *@Param: [arr, str, rows, cols, row, col, strNum, isPath]
     *@return: boolean
     *@Author: tan.xc
     *@date: 2021/6/29
     */
    public static boolean hasPath2(char[][] arr,String str,int rows,int cols,int row,int col,int strNum, boolean[][] isPath){
        boolean result = false;
        if(strNum>=str.length()){
            return true;
        }
        //满足条件就找下一个字符
        if(row>=0 && row<rows && col>=0 && col<=cols && arr[row][col]==str.charAt(strNum) && !isPath[row][col]){
            strNum++;
            isPath[row][col]=true;
            result = hasPath2(arr,str,rows,cols,row -1 ,col,strNum,isPath) ||
                    hasPath2(arr,str,rows,cols,row  ,col-1,strNum,isPath) ||
                    hasPath2(arr,str,rows,cols,row+1,col,strNum,isPath) ||
                    hasPath2(arr,str,rows,cols,row,col+1,strNum,isPath) ;
            //结果都为否时，返回上一级
            if(!result){
                strNum--;
                isPath[row][col]=false;
            }
        }
        return result;
    }
}
