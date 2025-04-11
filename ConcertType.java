package concert.concert;

public enum ConcertType {
    ROCK("Rock Night", 1500),
    POP("Pop Extravaganza", 1200),
    JAZZ("Jazz Evening", 1000),
    CLASSICAL("Classical Symphony", 800);
    
    private final String displayName;
    private final double basePrice;
    
    ConcertType(String displayName, double basePrice) {
        this.displayName = displayName;
        this.basePrice = basePrice;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
}