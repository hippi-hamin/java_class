package chxx_project.dto;

public class DessertDTO {
    // 필드
    private Long id;
    private String category;
    private String dessertName;
    private int dessertPrice;
    private String dessertCalories;
    private String dessertSugars;
    private String dessertProtein;
    private String dessertNatrium;
    private String dessertFats;

    // getter/setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    public int getDessertPrice() {
        return dessertPrice;
    }

    public void setDessertPrice(int dessertPrice) {
        this.dessertPrice = dessertPrice;
    }

    public String getDessertCalories() {
        return dessertCalories;
    }

    public void setDessertCalories(String dessertCalories) {
        this.dessertCalories = dessertCalories;
    }

    public String getDessertSugars() {
        return dessertSugars;
    }

    public void setDessertSugars(String dessertSugars) {
        this.dessertSugars = dessertSugars;
    }

    public String getDessertProtein() {
        return dessertProtein;
    }

    public void setDessertProtein(String dessertProtein) {
        this.dessertProtein = dessertProtein;
    }

    public String getDessertNatrium() {
        return dessertNatrium;
    }

    public void setDessertNatrium(String dessertNatrium) {
        this.dessertNatrium = dessertNatrium;
    }

    public String getDessertFats() {
        return dessertFats;
    }

    public void setDessertFats(String dessertFats) {
        this.dessertFats = dessertFats;
    }

    // 기본생성자
    public DessertDTO(){

    }

    public static Long idValue = 1L;
    // 필드값을 매개변수로 갖는 생성자
    public DessertDTO(String category, String dessertName, int dessertPrice, String dessertCalories, String dessertSugars, String dessertProtein, String dessertNatrium, String dessertFats) {
        this.id = idValue++;
        this.category = category;
        this.dessertName = dessertName;
        this.dessertPrice = dessertPrice;
        this.dessertCalories = dessertCalories;
        this.dessertSugars = dessertSugars;
        this.dessertProtein = dessertProtein;
        this.dessertNatrium = dessertNatrium;
        this.dessertFats = dessertFats;
    }

    // toString

    @Override
    public String toString() {
        return "DessertDTO{" +
                "id=" + id +
                ", dessertName='" + dessertName + '\'' +
                ", dessertPrice=" + dessertPrice +
                ", dessertCalories='" + dessertCalories + '\'' +
                ", dessertSugars='" + dessertSugars + '\'' +
                ", dessertProtein='" + dessertProtein + '\'' +
                ", dessertNatrium='" + dessertNatrium + '\'' +
                ", dessertFats='" + dessertFats + '\'' +
                '}';
    }
}
