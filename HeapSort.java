package Heap;

/**
 * 堆排序算法（算法导论p84-p90）
 * MAX_HEAPPIFY过程：其时间复杂度为O(lg n) 它是维护最大堆性质的关键。
 * BUILD_MAX_HEAP过程：具有线性时间复杂度，功能是从无序的输入数据数组中构造一个最大堆。
 * HEAPSORT过程：时间复杂度为O(nlgn),功能是对一个数组进行原址排序。
 */
public class HeapSort {
    public static void main(String[] args){
        int [] list={13,20,5,23,18,7,12,16,22,15};
        printArray(list);
        int [] list3=BUILD_HEAPSORT(list);
        printArray(list3);
    }

    /**保证根节点始终是最大值 */
    public static int [] MAX_HEAPPIFY(int [] list,int i,int j){
        int l=2*i+1;
        int r=2*i+2;
        int largest;
       if(l<=j&&list[l]>list[i])
       {
           largest=l;
       }
       else
       {  largest=i;}
       if(r<=j&&list[r]>list[largest])
       {
           largest=r;
       }
       if(largest!=i)
       {
           int temp;
           temp=list[i];
           list[i]=list[largest];
           list[largest]=temp;
           MAX_HEAPPIFY(list,largest,j);
       }
       return list;
    }

    /** 建最大堆
     * 最大堆含义：每一个父节点的值大于其左右孩子（但是左孩子不一定大于右孩子）*/
    public static int[] BUILD_MAX_HEAP(int [] list){
        int l=list.length;
        for(int i=l/2-1;i>=0;i--){
            MAX_HEAPPIFY(list,i,list.length-1);
        }
        return list;
    }
    /**实现堆排序
     *        23                          22
     *       *  *                       *  *
     *      22     12                 20      12
     *     *  *   *  *     step1:    *  *   *  *
     *    20  18  7   5             18  16  7    5
     *   *  * * * *  *  *           *  * * * *  *  *
     *   16 13 15                  13  15  *23*
      */
    public static int[] BUILD_HEAPSORT(int [] list){
       BUILD_MAX_HEAP(list);//将数组元素放入堆，保证根节点大于左右
        printArray(list);
        int i;
        i =list.length-1;
        for(;i>=0;i--){//将放入堆中的数据完成根节点最大
            int temp;
            temp=list[0];
            list[0]=list[i];
            list[i]=temp;
            MAX_HEAPPIFY(list,0,i-1);
        }
        return list;
    }

    public static void printArray(int[] list){
        for(int i=0;i<list.length;i++)
        {
            System.out.print(list[i]+"----");
        }
        System.out.print("\n");
    }
}
