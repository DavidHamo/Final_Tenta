import javax.swing.*;
import java.awt.*;



public class ObjectButton  extends JButton{
    ObjectButton(String text){
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setFocusPainted(false);
        this.setBackground(Color.WHITE);
        this.setForeground(new Color(0, 51, 102));
        this.setText(text);
    }

}
