package com.pandawork.common.utils;

/**
 * @author chant
 * @time: 16/4/3 下午6:02
 */
public class MyQuickSort {
    public int aSort(int a[], int left, int  right){
        int pivot = a[(left+right)/2];
        int tmp = a[left];
        while (right > left){
            while (a[right] >= tmp && right > left){
                right--;
            }
            a[left] = a[right];
            while (a[left] <= tmp && right > left){
                left++;
            }
            a[right] = a[left];
        }
        a[left] = tmp;
        return left;
    }

    public int[] quickSort(int a[], int left, int right){
        int pivotKey = aSort(a,left,right);

        if (left < pivotKey) quickSort(a,left,pivotKey);
        if (right > pivotKey + 1) quickSort(a,pivotKey + 1, right);
        return a;
    }

    public static void main(String[] args) {
        MyQuickSort myQuickSort = new MyQuickSort();
        int[] a = {5,8,4,5,11,4,7,5};
        int[] b = new int[a.length];
        b = myQuickSort.quickSort(a,0,a.length-1);
        for (int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
    }
}
