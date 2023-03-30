package Ex3_Next;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Tạo ra 7 thread
        RandomNumberThread[] threads = new RandomNumberThread[7];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new RandomNumberThread();
            threads[i].start();
        }

        // Đợi các thread hoàn thành
        for (RandomNumberThread thread : threads) {
            thread.join();
        }

        // Tính tổng các số được tạo ra từ các thread
        int total = 0;
        for (RandomNumberThread thread : threads) {
            total += thread.getNumber();
        }

        // In ra màn hình tổng các số
        System.out.println("Tổng các số được tạo ra là: " + total);
    }
}

class RandomNumberThread extends Thread {
    private int number;

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        Random random = new Random();
        number = random.nextInt(30) + 1;
        System.out.println("Thread " + this.getName() + " đã tạo ra số " + number);
    }
}

