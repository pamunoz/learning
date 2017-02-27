/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.ratmanager.ui;

import com.pfariasmunoz.ratmanager.model.Rat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class RatViewController implements Initializable {

    @FXML
    private StackPane ratStackPane;

    @FXML
    private Label ratTitle;

    @FXML
    private TableView ratTable;

    private ObservableList rats;
    private Rat currentRat;

    // Persistence
    final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("RatManagerPU");
    ;
    final EntityManager em = emf.createEntityManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Retrieving data from the database
        updateRatList();
        // Setup the tableview
        setupTable();
        // setup the Button add
        setupButton();
    }

    private void setupTable() {
        // Code Column
        TableColumn codeColumn = new TableColumn<Rat, String>();
        codeColumn.setText("Code");
        codeColumn.setMinWidth(100);
        codeColumn.setCellValueFactory(new PropertyValueFactory("code"));

        // Weight Column
        TableColumn weightColumn = new TableColumn<Rat, Double>();
        weightColumn.setText("Weight");
        weightColumn.setMinWidth(50);
        weightColumn.setCellValueFactory(new PropertyValueFactory("weight"));

        // Weight Column
        TableColumn concentrationColumn = new TableColumn<Rat, Double>();
        concentrationColumn.setText("Brain Concentration");
        concentrationColumn.setMinWidth(100);
        concentrationColumn.setCellValueFactory(
                new PropertyValueFactory("brainConcentration"));

        // Options Column
        TableColumn optionsColumn = new TableColumn();
        optionsColumn.setText("Options");
        optionsColumn.setMinWidth(100);
        // Use the CellFactory to customize the TableCell
        optionsColumn.setCellFactory(new Callback<TableColumn, TableCell>() {
            // Let's put a delete button and a display button
            @Override
            public TableCell call(TableColumn p) {

                TableCell tc = new TableCell() {
                    @Override
                    public void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        // Get the cell index
                        int i = getIndex();

                        if (i >= rats.size()) {
                            return;
                        }
                        // Select the cell whose button we clicked
                        ratTable.getSelectionModel().select(i);

                        final Rat ratItem = (Rat) ratTable
                                .getSelectionModel()
                                .getSelectedItem();
                        HBox hb = new HBox();
                        Button delButton = new Button("X");
                        delButton.setOnAction(new );

                        Button dispButton = new Button("D");
                        dispButton.setOnAction(new EventHandler() {

                            @Override
                            public void handle(ActionEvent t) {
                                showRat(ratItem);
                            }
                        });

                        hb.getChildren().addAll(delButton, dispButton);
                        hb.setAlignment(Pos.CENTER);
                        // Change the graphics of the cell to put the buttons
                        setGraphic(hb);
                    }
                };

                return tc;
            }
        });

        ratTable.getColumns().addAll(codeColumn,
                weightColumn,
                concentrationColumn,
                optionsColumn);
        // items in the table view
        ratTable.setItems(rats);
    }

    private void setupButton() {
        // put the action on the button
        addRatButton.setOnAction(new EventHandler() {

            @Override
            public void handle(ActionEvent t) {
                currentRat = new Rat();
                final VBox vb = new VBox();
                Label codeLabel = new Label("Code: ");
                TextField codeText = new TextField();
                codeLabel.setLabelFor(codeText);
                // Property binding
                codeText.textProperty().addListener(new ChangeListener() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldV, String newV) {
                        currentRat.setCode(newV);
                    }
                });

                Label weightLabel = new Label("Weight: ");
                TextField weightText = new TextField();
                weightLabel.setLabelFor(weightText);
                weightText.textProperty().addListener(new ChangeListener() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldV, String newV) {
                        currentRat.setWeight(Double.parseDouble(newV));
                    }
                });
                Label concLabel = new Label("Concentration: ");
                TextField concText = new TextField();
                concLabel.setLabelFor(concText);
                concText.textProperty().addListener(new ChangeListener() {

                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldV, String newV) {
                        currentRat.setBrainConcentration(Double.parseDouble(newV));
                    }
                });

                Button addButton = new Button("Add");
                addButton.setOnAction(new EventHandler() {

                    @Override
                    public void handle(ActionEvent t) {
                        saveRat();
                        // Maybe another animation/fade out
                        ratStackPane.getChildren().remove(vb);
                    }
                });

                vb.getChildren().addAll(codeLabel,
                        codeText,
                        weightLabel,
                        weightText,
                        concLabel,
                        concText,
                        addButton);
                vb.setFillWidth(false);
                vb.setAlignment(Pos.CENTER);
                vb.getStyleClass().add("add-rat-pane");
                ratStackPane.getChildren().add(vb);

                FadeTransition tf = FadeTransitionBuilder.create()
                        .fromValue(0)
                        .toValue(100)
                        .node(vb)
                        .duration(Duration.seconds(.5))
                        .build();
                tf.play();
            }
        });
    }

    private void updateRatList() {
        Query rq = em.createNamedQuery("Rat.findAll");
        List results = rq.getResultList();

        if (rats == null) {
            rats = FXCollections.observableArrayList(results);
        } else {
            rats.clear();
            rats.addAll(results);
        }
    }

    private void saveRat() {
        em.getTransaction().begin();
        em.persist(currentRat);
        em.getTransaction().commit();
        updateRatList();
    }

    private void deleteRat(Rat rat) {
        em.getTransaction().begin();
        em.remove(rat);
        em.getTransaction().commit();
        updateRatList();
    }

}
