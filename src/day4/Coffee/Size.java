package day4.Coffee;

public enum Size {
    Middle, Large,SuperLarge;
    @Override
    public String toString() {
        switch(this) {
            case Middle: return "中杯";
            case Large: return "大杯";
            case SuperLarge: return "超大杯";
            default:       return "unspecified";
        }
    }
}
