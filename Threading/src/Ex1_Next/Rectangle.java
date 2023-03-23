package Ex1_Next;
// Viết chương trình tạo 3 Luồng: Luồng 1 cho phép người dùng nhập vào 2 số thực là hai cạnh của hình chữ nhật,
// Luồng 2 và Luồng 3 sẽ đồng thời tính diện tích và chu vi của hình chữ nhật với 2 cạnh nhập được ở tuyến 1.
// Luồng chính chờ các Luồng hoàn thành rồi in kết quả chu vi và diện tích của hình chữ nhật ra màn hình.

public class Rectangle {
    private double length;
    private double width;
    private double area;
    private double perimeter;

    public synchronized void setDimensions(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public synchronized double getArea() {
        return length * width;
    }

    public synchronized void setArea(double area) {
        this.area = area;
    }

    public synchronized double getPerimeter() {
        return 2 * (length + width);
    }

    public synchronized void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
