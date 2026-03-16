import java.util.*;

public class Martian{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        int marciano = ran.nextInt(100);

        System.out.println("O marciano se escondeu em uma árvore! Tente adivinhar em qual das 100 árvores ele está!!");
        
        do{
            System.out.println("Tente um número:");
            int number=scan.nextInt();
            if (marciano>number){
                System.out.println("Tente maior");;
            }else if(marciano<number){
                System.out.println("Tente menor");
            }else{
                System.out.println("Você encontrou o Marciano!");
                break;
            }
        }while(true);
    }
}