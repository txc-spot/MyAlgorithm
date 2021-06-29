/**
 * @program: AlgorithmSelf
 * @description: 机器人不能进入行列坐标之和大于k的格子，总共能到达多少个格子 P92
 * @author: tan.xc
 * @create: 2021-06-27
 */
public class movingCount {
    public static void main(String args[]){
        int rows = 10;
        int col = 10;
        int k = 5;
        int movingCount = getMovingCount(rows, col, k);
        System.out.println(movingCount);
    }
    public static int getMovingCount(int rows,int cols, int k){
        boolean[][] booleans = new boolean[rows][cols];
        int count = isAchieve(rows,cols,0,0,k,booleans);
        return count;
    }

    public static int isAchieve(int rows,int cols,int row,int col,int k,boolean[][] booleans){
        //获得当前位置（row、col各位相加之和）

        int count = 0;
        if(row>=rows || row<0 || col>=cols || col<0){
            return 0;
        }

        // TODO: 2021/6/29 我认为计算各位相加应该采用如下写法，而不应该使用下面的方法getDigitSum（），因为有可能是百位以上的可能
        //抽象成getSumMyself（）
        int result = getSumMyself(row) + getSumMyself(col);

        int result2 = getDigitSum(row)+getDigitSum(col);//用于测试
        //判断当前点是否能达到，能达到就继续进行递归
        if(row<rows && row>=0 && col<cols && col>=0 && result<=k && !booleans[row][col]){
            booleans[row][col] = true;
            count =
            // TODO: 2021/6/29  count中要注意一定要在前面+1，这里+1 表示是当前点已经被判断为是正确的，不加这个+1 的话怎么算都是0
            1 + isAchieve(rows,cols,row-1,col,k ,booleans)+
            isAchieve(rows,cols,row,col-1,k ,booleans)+
            isAchieve(rows,cols,row+1,col,k ,booleans)+
            isAchieve(rows,cols,row,col+1,k ,booleans);
        }
        return count;
    }

    public static int getDigitSum(int number){
        int sum = 0;
        while(number > 0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    public static int getSumMyself(int num){
        String str = num+"";
        char[] charArr = str.toCharArray();
        int result=0;
        for(int i=0;i<charArr.length;i++){
            result += charArr[i]-48;
        }
        return result;
    }
}
