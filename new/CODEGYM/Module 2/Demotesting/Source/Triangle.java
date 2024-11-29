package Source;

public class Triangle {
    public static String checkTriangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "Dữ liệu không hợp lệ";
        }
        if (a >= b + c || b >= a + c || c >= a + b) {
            return "Không là tam giác";
        }
        if (a == b && b == c) {
            return "Tam giác đều";
        }
        if (b == c) {
            return "Tam giác cân tại A";
        }
        return "Tam giác thường";
    }


}
