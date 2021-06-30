/**
 * @author tanxincheng
 * @version 1.5
 * @description  P96 给定长度n的绳子，吧绳子剪成m段，，可能的最大乘积是多少。如长度为8的绳子，剪成2,3,3三段，此时得到最大乘积18.
 * @date 2021/6/30
 * @link
 */
public class CutLine {
    /**
     * 动态规划：
     * 其中，f(1)=1,f(2)=1*1,f(3)=1*2；
     * f(4)=max[f(1)f(3),f(2)f(2)]；
     * f(5) = max[f(1)f(4),f(2)f(3),f(3)f(2),f(4)f(1)]，
     * 其实本还应该有分成3段的情况， 如：f(1)f(4)-->f(1)f(1)f(3),f(2)f(3)-->f(2)f(1)f(2)...
     * 可以看出f(1)f(3) 就是 f(4)，所以这种分成3段，4段甚至更多的情况都是没必要的
     * --------
     * 经过上面的分析，可以看出从下至上的进行计算，可以求得最大值，同时从f(5) = max[f(1)f(4),f(2)f(3),f(3)f(2),f(4)f(1)]可以看出只用计算一半，后一半是重复的
     */

    public static void main(String args[]){
        int len = 4;
        System.out.println(getMaxNum(len));
    }

    //动态规划：
    public static int getMaxNum(int len){
        int[] maxNum = new int[len+1];
        //f(1)=1,f(2)=1*1,f(3)=1*2；
        maxNum[0]=0;
        maxNum[1]=1;
        maxNum[2]=2;
        maxNum[3]=3;
        //从下至上的进行计算，对数组进行赋值
        for(int i=4;i<len+1;i++){
            int max = 0;
            for(int j=1;j<=i/2;j++){
                // TODO: 2021/6/30 错误写法 "int i1 = maxNum[j] * maxNum[len - j];"  这里数组有值部分的下标上限是len
                int i1 = maxNum[j] * maxNum[i - j];
                if(max< i1){
                    max = i1;
                }
                maxNum[i]=max;
            }
        }
        return maxNum[len];

    }


}
