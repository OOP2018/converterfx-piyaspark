package converter;

/**the enum class of Length.*/
public enum Length {
    Meter(1.0),
    Kilometer(1000.0),
    Centimeter(0.010),
    Mile(1609.344),
    Foot(0.30480),
    wa(2.000),
    AU(149597870700.0);

    private final double value;

    /** the constructor of enum
     * @param value
     */
    private Length(double value){ this.value = value; }

    /**
     * get value of unit in meter.
     * @return value.
     */
    public double getValue(){ return this.value;}
}
