import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SportManagement {
    public static void main(String[] args) {
        // Tạo JFrame chính
        JFrame frame = new JFrame("Types of Sports"); // Đặt tiêu đề
        frame.setSize(400, 450); // Thiết lập kích thước
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng chương trình khi click vào "X"
        frame.setLayout(new BorderLayout()); // Bố cục chính

        // Tạo menu
        JPanel menu = new JPanel(); // Tạo bảng chứa menu
        menu.setLayout(new GridLayout(3, 2, 10, 10)); // Tạo lưới 3x2
        menu.setBorder(BorderFactory.createTitledBorder("Sport Menu")); // Đặt tiêu đề viền

        // Tạo giỏ hàng
        JPanel cart = new JPanel(); // Tạo bảng chứa giỏ hàng
        cart.setLayout(new BorderLayout()); // Bố cục viền chia E, W, S, N, Center
        cart.setBorder(BorderFactory.createTitledBorder("Your Cart")); // Đặt tiêu đề viền

        // Danh sách các môn thể thao và phối màu
        String[] sports = {"Football", "Pickleball", "Basketball", "Badminton", "Baseball", "Golf"};
        Color[] colors = {
                new Color(52, 152, 219),
                new Color(1, 0, 128),
                new Color(39, 174, 96),
                new Color(255, 0, 255),
                new Color(153, 67, 24),
                new Color(243, 156, 18)
        };

        // Danh sách giỏ hàng
        ArrayList<String> cartItems = new ArrayList<>(); // Lưu các môn thể thao đã chọn
        DefaultListModel<String> cartModel = new DefaultListModel<>(); // Hiển thị trong JList
        JList<String> cartList = new JList<>(cartModel); // Hiển thị giỏ hàng, dùng cartModel làm data
        cartList.setBackground(new Color(236, 240, 241)); // Đặt màu nền giỏ hàng: trắng xám hiện đại
        cart.add(new JScrollPane(cartList), BorderLayout.CENTER); // Thêm JList vào JScrollPane trong giỏ hàng

        // Label hiển thị tổng số items
        JLabel totalItemsLabel = new JLabel("Total sport: 0");
        totalItemsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        cart.add(totalItemsLabel, BorderLayout.SOUTH); // Thêm label vào dưới cùng của giỏ hàng

        // Thêm button môn thể thao
        for (int i = 0; i < sports.length; i++) { // Vòng lặp duyệt môn thể thao
            JButton sportsButton = new JButton(sports[i]); // Tạo nút với tên môn thể thao
            sportsButton.setBackground(colors[i]); // Đặt màu nền cho nút từ danh sách màu
            sportsButton.setForeground(Color.WHITE); // Đặt màu chữ
            sportsButton.setFont(new Font("Arial", Font.BOLD, 16)); // Đặt phông chữ và kích cỡ
            sportsButton.setFocusPainted(false); // Tắt viền khi nút được chọn

            // Xử lí nút bấm
            sportsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { // Phương thức xử lý khi nút được bấm
                    cartItems.add(sportsButton.getText()); // Thêm tên môn thể thao vào danh sách các mục trong giỏ hàng
                    cartModel.addElement(sportsButton.getText()); // Cập nhật giao diện
                    totalItemsLabel.setText("Total sport: " + cartItems.size()); // Cập nhật nhãn hiển thị tổng số lượng mục trong giỏ hàng
                    JOptionPane.showMessageDialog(frame, sportsButton.getText() + " added to cart!");
                }
            });

            menu.add(sportsButton); // Thêm nút vào menu
        }

        // Button xóa giỏ hàng
        JButton clearCartButton = new JButton("Clear Cart"); // Tạo button mới
        clearCartButton.setBackground(new Color(90, 76, 60)); // Đặt màu nền là đỏ gạch
        clearCartButton.setForeground(Color.WHITE); // Màu chữ trắng
        clearCartButton.setFont(new Font("Arial", Font.BOLD, 16)); // Đặt phông và cỡ chữ
        clearCartButton.setFocusPainted(false);
        clearCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cartItems.clear(); // Xóa tất cả môn thể thao trong danh sách giỏ hàng
                cartModel.clear(); // Xóa dữ liệu trong giao diện
                totalItemsLabel.setText("Total sport: 0"); // Đặt lại nhãn số mục thành 0
                JOptionPane.showMessageDialog(frame, "Cart cleared!");
            }
        });

        cart.add(clearCartButton, BorderLayout.NORTH); // Thêm nút xóa giỏ hàng vào trên cùng của giỏ hàng

        // Thêm menu và giỏ hàng vào frame
        frame.add(menu, BorderLayout.NORTH);
        frame.add(cart, BorderLayout.CENTER);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
