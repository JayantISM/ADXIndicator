package adx;

import myadx.ADXIndicatorImpl;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

import java.io.IOException;
import java.util.List;

public class ADXIndicatorTest {
    private static final BarSeriesDataExtractor barSeriesDataExtractor = new BarSeriesDataExtractor();
    private static BarSeries barSeries = null;

    static {
        try {
            barSeries = barSeriesDataExtractor.extractBarSeriesData("/Users/jayanttiwari/IdeaProjects/SupertrendIndicator/tst/data/SampleBANKNIFTYData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final ADXIndicatorImpl ADX_INDICATOR = new ADXIndicatorImpl(barSeries, 14);

    public static void main(String[] args) {
        System.out.println("BarSeries Count is: " + barSeries.getBarCount());
        List<Bar> barList = barSeries.getBarData();
        System.out.println(barSeries.getBarCount());
        for (int i=14;i<barSeries.getBarCount();i++) {
            Bar barData = barList.get(i);
            System.out.println("[ " + barData.getBeginTime() + ", " + ADX_INDICATOR.calculateADXForBarIndex(i) + " ]");
        }
        System.out.println(ADX_INDICATOR.calculateADXForBarIndex(2149));
    }
}
