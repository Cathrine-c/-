package InterviewImportant.jianzhi;

import 蓝桥.S;

import java.util.Arrays;
import java.util.Scanner;

public class Day0808 {


    //美团笔试
    public static void main1(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t>0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int i=0;i<n;i++){

                arr[i] = sc.nextInt();

            }

            isExsitX(arr,n,k);
            t--;
        }
    }

    private static void isExsitX(int[] arr,int n,int k) {

        int mid = arr.length/2;

        Arrays.sort(arr);
        while (mid<arr.length&&mid>=0){
            if (mid<k){
                mid++;

            }else if (mid>k){
                mid--;
            }else {
                if (arr[mid-1]<n) {
                    System.out.println("YES");
                    System.out.println(arr[mid - 1] + 1);
                    return;
                }
            }
        }
        System.out.println("NO");


    }


    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String s1 = "";
        String s2 = "";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' ')continue;
            s1+=s.charAt(i);

        }

        s2+=s1.charAt(0);
        for (int i=1;i<s1.length();i++){

            if (s1.charAt(i)==s1.charAt(i-1)){
                continue;
            }

            s2+=s1.charAt(i);
        }

        System.out.println(s2);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int[] prev = new int[n];

        prev[0] = arr[0]-1;
        for (int i=1;i<arr.length;i++){

            Arrays.sort(arr,0,i);
            for (int j=i-1;j>=0;j--){

                if (arr[j]<arr[i]){
                    prev[i] = arr[j];
                    break;
                }
            }

        }

        int sum = 0;
        for (int i=0;i<prev.length;i++){

            sum+=(i+1)*(prev[i]);

        }
        System.out.println(sum);
    }


}
