import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series set1 = new XYChart.Series<>();

        set1.getData().add(new XYChart.Data("A", 5000));
        set1.getData().add(new XYChart.Data("B", 3999));
        set1.getData().add(new XYChart.Data("C", 200));
        set1.getData().add(new XYChart.Data("D", 10000));

        barChart.getData().addAll(set1);
    }
}
