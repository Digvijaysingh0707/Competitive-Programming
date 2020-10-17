import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
/*
17-10-2020
 */
//---------------------------------------------------------------------------------------------------------------

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n=sc.nextInt();
        int a[]=new int[n+1];
        for (int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
       int fre[]= new int[10];
       for (int i=1;i<=n;i++){
           fre[a[i]]++;
       }
       ArrayList<int[]>  ans = new ArrayList<>();
       boolean flag=true;
       if (fre[7]>0||fre[5]>0){
           flag=false;
       }
       n/=3;
       while (n-->=1) {
           boolean c = false;
           if (fre[1] > 0 && fre[3] > 0 && fre[6] > 0) {
               c = true;
               fre[1]--;
               fre[3]--;
               fre[6]--;
               ans.add(new int[]{1, 3, 6});
           } else if (fre[1] > 0 && fre[2] > 0 && fre[6] > 0) {
               c = true;
               fre[1]--;
               fre[2]--;
               fre[6]--;
               ans.add(new int[]{1, 2, 6});
           } else if (fre[1] > 0 && fre[2] > 0 && fre[4] > 0) {
               c = true;
               fre[1]--;
               fre[2]--;
               fre[4]--;
               ans.add(new int[]{1, 2, 4});
           }
           if (c == false) {
               flag = false;
           }
       }

           if (flag) {
               for (int i = 0; i < ans.size(); i++) {
                   System.out.println(ans.get(i)[0] + " " + ans.get(i)[1] + " " + ans.get(i)[2]);
               }
           } else {
               System.out.println(-1);
           }


        out.flush();
    }
    //------------------------------------------------------------------------------------------------------------
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static int[] find(int n,int start,int diff){
        int a[]= new int[n];
        a[0]=start;
        for (int i=1;i<n;i++)a[i]=a[i-1]+diff;
        return a;
    }
    static void swap(int a,int b){
        int c=a;
        a=b;
        b=c;
    }

    static void printArray(int a[]){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    static boolean sorted(int a[]){
        int n=a.length;
        boolean flag=true;
        for (int i=0;i<n-1;i++){
            if (a[i]>a[i+1])flag=false;
        }
        if (flag)return true;
        else  return false;
    }
    public static int findlog(long n){
        if(n == 0)
            return 0;

        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        double num = Math.log(n);
        double den = Math.log(2);
        if(den == 0)
            return 0;
        return (int)(num/den);
    }
    public static long gcd(long a,long b){
        if(b%a == 0)
            return a;
        return gcd(b%a,a);
    }
    public static int gcdInt(int a,int b){

        if(b%a == 0)
            return a;

        return gcdInt(b%a,a);

    }

    static void sortReverse(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
//        Collections.sort.(l);
        Collections.sort(l,Collections.reverseOrder());
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long[] readArrayLong(long n) {
            long[] a=new long[(int)n];
            for (int i=0; i<n; i++) a[i]=nextLong();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
