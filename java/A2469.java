import java.math.BigDecimal;

public class A2469 {
    public double[] convertTemperature(double celsius) {
        BigDecimal b1 = new BigDecimal(Double.toString(celsius));
        BigDecimal b2 = new BigDecimal(Double.toString(273.15));

        double r1 = b1.add(b2).doubleValue();
        double r2 = b1.multiply(new BigDecimal("1.8")).doubleValue();
        return new double[]{r1,r2};
    }
}