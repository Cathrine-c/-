package InterviewImportant.jianzhi;

public class Day0802 {


    //统计1-n中1出现的次数
    public static int countDigitOne(int n) {

        int digit = 1,res = 0;

        int high = n/10,cur = n%10,low = 0;

        while(high!=0||cur!=0){

            if(cur==0) res+=high*digit;
            else if(cur==1)res+=high*digit+low+1;
            else res+=(high+1)*digit;

            low += cur*digit;

            cur = high%10;
            high /=10;
            digit *=10;

        }

        return res;
    }



    private static int[] count = {0,1,20,300,4000,50000,600000,7000000,8000000,900000000};
    public static int countDigitOne1(int n){
        int res = 0;
        int index = 0,pow = 1,pre = 0;

        while (n != 0) {

            int num = n%10;
            if (num == 1) {
                res += pre +1 + count[index];

            } else if (num > 1) {

                res += pow + num*count[index];

            }

            pre = pre +num*pow;
            pow *=10;
            index++;
            n/=10;

        }
        return res;

    }


    public static void main(String[] args) {

        int n = 12;
        System.out.println(countDigitOne1(n));

    }



}
