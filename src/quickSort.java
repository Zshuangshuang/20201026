import java.util.Arrays;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-26
 * Time:19:52
 **/
public class quickSort {

    public static void qSort(int[] array){
        qSortInternal(array,0,array.length-1);
    }

    private static void qSortInternal(int[] array, int left, int right) {
        //如果当前区间仅剩余一个元素时，排序结束
        if (left >= right){
            return;
        }
        //找到中间元素的位置
        int index = partition(array,left,right);
        //递归遍历基准元素的左侧和右侧
        qSortInternal(array,left,index-1);
        qSortInternal(array,index+1,right);
    }

    private static int partition(int[] array,int left,int right){
        int i = left;
        int j = right;
        int base = array[right];
        while (i < j){
            while(i<j && array[i] <= base){
                i++;
            }
            while (i <j && array[j] >= base){
                j--;
            }

            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }

    public static void main(String[] args) {
        int[] array = {2,3,5,1,6,9,7};
        qSort(array);
        System.out.println(Arrays.toString(array));
    }

}
