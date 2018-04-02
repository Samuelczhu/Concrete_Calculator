import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TestData {
    private SimpleStringProperty placeUsed;
    private SimpleIntegerProperty stiffLevel;
    private SimpleIntegerProperty sampleAge;
    private SimpleDoubleProperty representData;
    private SimpleDoubleProperty reachPercent;

    public TestData(String placeUsed, Integer stiffLevel, Integer sampleAge, double representData) {
        this.placeUsed = new SimpleStringProperty(placeUsed);
        this.stiffLevel = new SimpleIntegerProperty(stiffLevel);
        this.sampleAge = new SimpleIntegerProperty(sampleAge);
        this.representData = new SimpleDoubleProperty(representData);
        this.reachPercent = new SimpleDoubleProperty((double)Math.round((representData/stiffLevel * 100) * 100d) / 100d);
    }

    public double getReachPercent() {
        return reachPercent.get();
    }

    public String getPlaceUsed() {

        return placeUsed.get();
    }

    public Integer getStiffLevel() {
        return stiffLevel.get();
    }

    public Integer getSampleAge() {
        return sampleAge.get();
    }

    public double getRepresentData() {
        return representData.get();
    }
}
