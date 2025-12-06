package models;

public class LuxuryRoom extends Room {
    private static final double LUXURY_SURCHARGE = 150.0;

    public LuxuryRoom(String number, double basePrice) {
        super(number, "luxury", basePrice);
    }

    @Override
    public double calculateTotal(int nights) {
        double baseTotal = super.calculateTotal(nights);
        return baseTotal + (LUXURY_SURCHARGE * nights);
    }
}

