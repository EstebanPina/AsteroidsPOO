package main;
import javax.swing.JFrame;

public class Window extends JFrame{
    public static final int WIDTH = 1000, HEIGHT = 800,
    
    public Windows()
    {
        setTitle(''Asterioids POO'');
        setSize (WIDTH, HEIGHT);
        SetDefaulltCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
       }
   
   
   
   
   public static vold main(String[] args) {
       new Window();
       }
)