package RingProgress;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        ringProgressIndicator.setRingWidth(200);
        ringProgressIndicator.makeIndeterminate();

        StackPane root = new StackPane();
        root.getChildren().add(ringProgressIndicator);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Ring");
        primaryStage.setScene(scene);
        primaryStage.show();

        new WorkerThred(ringProgressIndicator).start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class WorkerThred extends Thread{
        RingProgressIndicator rp1;
        int progress =0;

        private WorkerThred(RingProgressIndicator rp1){
            this.rp1 = rp1;
        }

        @Override
        public void run(){
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> rp1.setProgress(progress));
                progress +=1;
                if(progress >100){
                    break;
                }
            }
        }
    }
}
