package pongsys;

import java.util.Scanner;

public class PongSys {

    public static void main(String[] args) {
        System.out.println("Heyio :3");
        
        cadastrarUsuario();
    }
    
    public static void cadastrarUsuario() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("None: ");
        String nome = scan.nextLine();
        
        scan.close();
    }
}
