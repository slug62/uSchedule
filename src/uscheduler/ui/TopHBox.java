package uscheduler.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by aa8439 on 3/31/2016.
 */
public class TopHBox extends HBox {
    private ComboBox<Term> cmbTerm = new ComboBox<>();
    private ListView<String> listCampus = new ListView<>();
    private VBox vCampus = new VBox(5);
    private VBox vLabels = new VBox(5);
    private Label before = new Label("No Classes Before:");
    private Label after = new Label("No Classes After:");
    private final Tooltip tooltip = new Tooltip();
    private final ObservableList<Term> terms = FXCollections.observableArrayList();
    private ObservableList<String> campuses = FXCollections.observableArrayList();
    private ArrayList<DayVBox> days = new ArrayList<>();

    TopHBox() {
        vCampus.getChildren().addAll(new Label("Desired Campuses"),listCampus);
        vLabels.getChildren().addAll(before, after);
        this.getChildren().addAll(cmbTerm, vCampus, vLabels);
        days.add(new DayVBox("Monday", 8, 20));
        days.add(new DayVBox("Tuesday", 8, 20));
        days.add(new DayVBox("Wednesday", 8, 20));
        days.add(new DayVBox("Thursday", 8, 20));
        days.add(new DayVBox("Friday", 8, 20));
        days.add(new DayVBox("Saturday", 8, 20));
        days.add(new DayVBox("Sunday", 8, 20));
        this.getChildren().addAll(days);
        formatItems();
    }
    private void formatItems(){
        tooltip.setText("Press control and left mouse click\n to select multiple entries.");
        listCampus.setMaxHeight(75);
        listCampus.setMaxWidth(175);
        listCampus.setTooltip(tooltip);
        listCampus.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        before.setAlignment(Pos.CENTER);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);
    }
}