import java.util.*;

public class Martian{
    private static ArrayList<Integer> recordes = new ArrayList<>();
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        carregarRecordes();
        
        do{
            int tentativas = initGame(args);
            if(tentativas > 0) {
                adicionarRecorde(tentativas);
            }
            mostrarRecordes();
            System.out.println("Deseja continuar jogando?(S/N)");
            String continua = scan.nextLine().toUpperCase();
            if(continua.equals("S")){
                System.out.println("OKAY!");
            }else{
                System.out.println("Recordes finais:");
                mostrarRecordes();
                break;
            }
        }while(true);
        
        scan.close();
    }

    public static int initGame(String args[]){
        Scanner scan = new Scanner(System.in);
        Random ran = new Random();
        int marciano = ran.nextInt(100) + 1;
        Set<Integer> arvoresCombustao = new HashSet<>();
        while(arvoresCombustao.size() < 6) {
        int combustao = ran.nextInt(100) + 1;
        if(combustao != marciano) {
            arvoresCombustao.add(combustao);
        }
    }
    
        // Iterator<Integer> it = arvoresCombustao.iterator();
        // for(int i = 0; i < 6 && it.hasNext(); i++) {
        // System.out.print(it.next() + " ");
    //    }
        int count = 0;
        final int MAX_TENTATIVAS = 10;

        System.out.println("Após ser expulso de sua terra-natal, Mark decide fugir de seu planeta, e encontrar um lugar em que possa iniciar suas pesquisas");
        System.out.println("O explorador intergalático Niel precisa descobrir aonde o Mark se escondeu e o localiza na região de uma floresta no Brasil");
        System.out.println("Mas há um detalhe, está em tempo de queimadas no Brasil, e algumas árvores estão prestes a entrar em combustão!");
        System.out.println("Tente adivinhar em qual das 100 árvores ele está antes que ele fuja!!");
        System.out.println("Ah! E cuidado. Algumas árvores podem começar a pegar fogo...");
        System.out.println("Você tem " + MAX_TENTATIVAS + " chances!");
        
        do{
            count++;
            if(count > MAX_TENTATIVAS) {
                System.out.println("O alienígena escapou após " + MAX_TENTATIVAS + " tentativas!");
                return 0;
            }
            
            System.out.print("Tentativa " + count + "/" + MAX_TENTATIVAS + ": ");
            int number = scan.nextInt();
            
            if(number < 1 || number > 100) {
                System.out.println("Use números de 1 a 100!");
                count--;
                continue;
            }

            if(arvoresCombustao.contains(number)){
                System.out.println("Você acabou se queimando numa árvore!");
                System.out.println("'Mark: HAHAHA! Humano idiota'");
                return 0;
            }
            
            if(marciano > number){
                System.out.println("Tente maior");
            }else if(marciano < number){
                System.out.println("Tente menor");
            }else{
                System.out.println("Você achou o Marciano em " + count + " tentativas!");
                return count; 
            }
        }while(true);
    }
    
    public static void adicionarRecorde(int tentativas) {
        recordes.add(tentativas);
        Collections.sort(recordes);
        while(recordes.size() > 5) {
            recordes.remove(recordes.size() - 1);
        }
        
        System.out.println("Jogo adicionado aos recordes!");
    }
    
    public static void mostrarRecordes() {
        System.out.println("Top 5 recordes:");
        if(recordes.isEmpty()) {
            System.out.println("Nenhum recorde ainda!");
        } else {
            for(int i = 0; i < recordes.size(); i++) {
                System.out.println((i+1) + "º lugar: " + recordes.get(i) + " tentativas");
            }
        }
        System.out.println();
    }
    
    public static void carregarRecordes() {
        recordes.clear();
        Collections.sort(recordes);
        System.out.println("Recordes carregados!");
    }
}