package src;

import javax.swing.JPanel;

class winMain extends JPanel implements Runnable{
    
    Thread gThread;

    public winMain(){
        run();
    }
    @Override
    public void run() {
         try{
            new Windows();
        } catch(Exception e){
            e.printStackTrace();
        }
        while(gThread != null){
            System.out.println("Hello Worl");
        }
    }

    public static void main(String[] args) {
           
        new winMain();

    }


}
