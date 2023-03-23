package Ex1_Next;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Rectangle rectangle = new Rectangle();

        //Luong nhap 2 gia tri chieu dai, chieu rong
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập chiều dài: ");
            double length = scanner.nextDouble();
            System.out.print("Nhập chiều rộng: ");
            double width = scanner.nextDouble();
            rectangle.setDimensions(length, width);
        });


        //Luong tinh dien tich
        Thread areaThread = new Thread(() -> {
            double area = rectangle.getArea();
            rectangle.setArea(area);
        });

        //Luong tinh chu vi
        Thread perimeterThread = new Thread(() -> {
            double peri = rectangle.getPerimeter();
            rectangle.setPerimeter(peri);
        });

        // Cho cac luong hoan thanh
        inputThread.start();
        inputThread.join();

        areaThread.start();
        perimeterThread.start();

        perimeterThread.join();
        areaThread.join();

        // in ket qua
        System.out.println("Diện tích của hình chữ nhật là: " + rectangle.getArea());
        System.out.println("Chu vi của hình chữ nhật là: " + rectangle.getPerimeter());
    }
}

