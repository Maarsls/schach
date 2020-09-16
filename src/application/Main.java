package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			GridPane feld = new GridPane();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					Button b = new Button();
					b.setMinHeight(100);
					b.setMinWidth(100);
					b.setMaxWidth(100);
					b.setMaxHeight(100);
					char id = (char) ('A' + i);
					String idB = id + String.valueOf(j + 1);
					System.out.println(idB);
					b.setId(idB);
					feld.add(b, i, j);
					b.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							System.out.println("Hello World!");
						}
					});
				}
			}

			// Bauer setzten
			for (int i = 1; i < 8; i = i + 5) {

				for (int bauer = 0; bauer < 8; bauer++) {

					for (Node node : feld.getChildren()) {
						if (feld.getRowIndex(node) == i && feld.getColumnIndex(node) == bauer) {
							Button b = (Button) node;
							if (i == 1) {
								Image im1 = new Image("images/BW.png");
								b.setGraphic(new ImageView(im1));
							}
							if (i == 6) {
								Image im1 = new Image("images/BB.png");
								b.setGraphic(new ImageView(im1));
							}
						}

					}
				}
			}
			for (Node node : feld.getChildren()) {
				for (int t = 0; t < 8; t = t + 2) {
					for (int i = 1; i <= 8; i = i + 2) {

						if (feld.getRowIndex(node) == t && feld.getColumnIndex(node) == i) {
							Button b = (Button) node;
							b.setStyle("-fx-background-color: #585858");
						}
					}
				}
			}

			for (Node node : feld.getChildren()) {
				for (int t = 1; t <= 8; t = t + 2) {
					for (int i = 0; i < 8; i = i + 2) {

						if (feld.getRowIndex(node) == t && feld.getColumnIndex(node) == i) {
							Button b = (Button) node;
							b.setStyle("-fx-background-color: #585858");
						}
					}
				}
			}

			Label zug = new Label("Letzter Zug: ");
			root.setBottom(zug);
			root.setCenter(feld);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
