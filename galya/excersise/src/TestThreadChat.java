class Chat {
    boolean flag = false;

    public synchronized void Question(String msg) {
        try {
            Thread.sleep(3000);
        if (flag) {


                System.out.println("Qeus typing...");

                wait();


        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void Answer(String msg) {
        try {
            Thread.sleep(500);
        if (!flag) {
            System.out.println("Ans typing...");

                wait();
        }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        flag = false;
        notify();
    }
}

class T1 implements Runnable {
    Chat m;
    String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

    public T1(Chat m1) {
        this.m = m1;
        new Thread(this, "Question").start();
    }

    public void run() {
        for (int i = 0; i < s1.length; i++) {
            m.Question(s1[i]);
        }
    }
}

class T2 implements Runnable {
    Chat m;
    String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

    public T2(Chat m2) {
        this.m = m2;
        new Thread(this, "Answer").start();
    }

    public void run() {

                for (int i = 0; i < s2.length; i++) {
                    //Thread.sleep(3000);
                    m.Answer(s2[i]);
                }
    }
}

public class TestThreadChat {

    public static void main(String[] args) throws InterruptedException {
        Chat m = new Chat();

        Thread t1=new Thread(new T1(m));
        Thread t2= new Thread(new T2(m));




    }
}