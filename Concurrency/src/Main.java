
class MyThread extends Thread{
    public void run(){
        for(int i =1;i<=5;i++){
            System.out.println("Thread running: "+i);
        }
    }
}

class MyRunnable implements Runnable{
    public void run(){
        for(int i =1; i<=5;i++){
            System.out.println("Runnable Thread: "+ i );
        }
    }
}

void main() {
    MyRunnable task = new MyRunnable();
    Thread t1 = new Thread(task);
    t1.start();

    for (int i = 1; i <= 5; i++) {
        System.out.println("Main Thread: "+ i);
    }
}
