public class getMinNumFromCircleArr {
    //循环数组中查找最小值
    public static void main (String args[]){
        int[] arr ={4,5,1,2,3,4};
        int minNum = getMinNum(arr,0,arr.length-1);
        System.out.println(minNum);
    }

    public static int getMinNum(int[] arr,int lIndex,int rIndex){

        //定义两个指针分别指向数组的第一个和最后一个值
        int p1 = lIndex;
        int p2 = rIndex;
        //使用二分法进行查找（因为整个数组是部分有序的，因此考虑使用二分法）
        //判断中间位置的值是属于左边组还是右边组
        int mid = (p1+p2)/2;
        if(rIndex-lIndex<=1){
            return arr[mid];
        }
        if(arr[mid]>arr[p1]){
            return getMinNum(arr,p1,mid);
        }
        else {
            return getMinNum(arr,mid,p2);

        }
    }


}

