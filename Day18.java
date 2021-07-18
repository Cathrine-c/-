package InterviewImportant.Shuati;

import java.util.concurrent.CountDownLatch;

public class Day18 {

    private static final int count = 1000_000_000;

    public static void main1(String[] args) throws InterruptedException {

        currency();
        serial();

    }

    private static void currency() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int a =0;
                for (long i=0;i<count;i++){

                    a--;
                }
            }
        });
        t.start();

        int b =0;

        for (long i=0;i<count;i++){
            b--;
        }

        t.join();

        long end = System.currentTimeMillis();
        System.out.println("并发花费的时间："+(end-begin));

    }

    private static void serial() {

        long begin = System.currentTimeMillis();

        int a = 0;
        for (long i=0;i<count;i++){
            a--;

        }
        int b =0;

        for (long i=0;i<count;i++){
            b--;
        }

        long end = System.currentTimeMillis();

        System.out.println("串行花费时间:"+(end-begin));

    }




    public static void main2(String[] args) throws Exception {
     CountDownLatch latch = new CountDownLatch(10);
          Runnable r = new Runnable() {
              @Override
              public void run() {
                  try {
                      Thread.sleep((long) (Math.random() * 10000));
                      latch.countDown();
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
          };

        for (int i = 0; i < 10; i++) {
             new Thread(r).start();
       }
      // 必须等到 10 人全部回来
        latch.await();
        System.out.println("比赛结束");
    }


    public static void main(String[] args) {


    }


    
}
