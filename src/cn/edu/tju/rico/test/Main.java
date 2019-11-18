package cn.edu.tju.rico.test;

/**
 * Created by hbs on 2019/11/17.
 */
import java.util.*;
public class Main {

    public static int[] heapSort(int[] target) {
        if (target != null && target.length > 1) {

            // 调整为最大堆
            int pos = (target.length - 2) / 2;
            while (pos >= 0) {
                shiftDown(target, pos, target.length - 1);
                pos--;
            }

            // 堆排序
            for (int i = target.length-1; i > 0; i--) {
                int temp = target[i];
                target[i] = target[0];
                target[0] = temp;
                shiftDown(target, 0, i-1);
            }
            return target;
        }
        return target;
    }


    private static void shiftDown(int[] target, int start, int end) {
        int i = start;
        int j = 2 * start + 1;
        int temp = target[i];
        while (j <= end) {   // 迭代条件
            if (j < end && target[j + 1] < target[j]) {  //找出较大子女
                j = j + 1;
            }
            if (target[j] >= temp) {  // 父亲大于子女
                break;
            } else {
                target[i] = target[j];
                i = j;
                j = 2 * j + 1;
            }
        }
        target[i] = temp;
    }



    public static void main(String[] args){
        Integer[] target1 = { 38, 65, 97, 76, 13, 27, 49 };
//        97,76,65,49,38,27,13,
        Arrays.sort(target1); //升序排列
        Arrays.sort(target1,Collections.reverseOrder());
        //降序排列，注意：使用Collections.reverseOrder()时，
        // 不能使用基本类型（int,double, char），如果是int型需要改成Integer，float要改成Float

//        heapSort(target1);
        for (int i = 0; i < target1.length; i++) {
            System.out.print(target1[i]+",");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        Point[] points=new Point[num];


        for (int i = 0; i < num; i++) {
            String line = scanner.nextLine();
            points[i] = new Point(Integer.valueOf(line.split(" ")[0]),Integer.valueOf(line.split(" ")[1]));
        }
        for (int i = 0; i < num; i++) {
            System.out.println(points[i].toString());
        }

        Arrays.sort(points,(a,b)->a.x-b.x);

        for (int i = 0; i < num; i++) {
            System.out.println(points[i].toString());
        }

    }

    static class Point implements Comparator<Point>{
        int x;
        int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }


        @Override
        public int compare(Point o1,Point o2) {
            return (o1.x < o2.x) ? -1 : ((o1.x == o2.x) ? 0 : 1);
        }

        @Override
        public String toString() {
            return this.x+ " " +this.y;
        }
    }


}
