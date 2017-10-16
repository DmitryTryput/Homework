package tasks10.garage;

public enum Transmission {
    AUTOMATIC {
        public String toString() {
            return "Автоматическая";
        }
    }, MANUAL{
        public String toString() {
            return "Механическая";
        }
    }
}
