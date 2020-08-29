package day5;

public enum Property {
    Id,CompanyName,ContactName,ContactTitle,RegionPostalCode,Country;

    @Override
    public String toString() {
        switch(this) {
            case Id:return "id";
            case CompanyName:return "companyName";
            case ContactName:return "contactName";
            case ContactTitle:return "contactTitle";
            case RegionPostalCode:return "regionPostalCode";
            case Country:return "country";
            default:return "unknown";
        }
    }

}
