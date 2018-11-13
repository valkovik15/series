import javax.swing.*;
import java.awt.*;
import java.io.*;

    public class Demo {




        public static void main(String[] args) {
            Model Ser=new Model();
            MyForm f = new MyForm(Ser);
            f.pack();
            f.setSize(new Dimension(500, 500));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        }
    }
