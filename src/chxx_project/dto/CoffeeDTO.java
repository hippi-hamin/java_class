package chxx_project.dto;

public class CoffeeDTO {
    // 필드
    private Long id;
    private String coffeeName;
    private int coffeePrice;
    private String coffeeCaffein;
    private String coffeeCalories;
    private String coffeeCarbohydrate;
    private String coffeeSugars;
    private String coffeeProtein;
    private String coffeeNatrium;
    private String coffeeFats;

    // getter/setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public int getCoffeePrice() {
        return coffeePrice;
    }

    public void setCoffeePrice(int coffeePrice) {
        this.coffeePrice = coffeePrice;
    }

    public String getCoffeeCaffein() {
        return coffeeCaffein;
    }

    public void setCoffeeCaffein(String coffeeCaffein) {
        this.coffeeCaffein = coffeeCaffein;
    }

    public String getCoffeeCalories() {
        return coffeeCalories;
    }

    public void setCoffeeCalories(String coffeeCalories) {
        this.coffeeCalories = coffeeCalories;
    }

    public String getCoffeeCarbohydrate() {
        return coffeeCarbohydrate;
    }

    public void setCoffeeCarbohydrate(String coffeeCarbohydrate) {
        this.coffeeCarbohydrate = coffeeCarbohydrate;
    }

    public String getCoffeeSugars() {
        return coffeeSugars;
    }

    public void setCoffeeSugars(String coffeeSugars) {
        this.coffeeSugars = coffeeSugars;
    }

    public String getCoffeeProtein() {
        return coffeeProtein;
    }

    public void setCoffeeProtein(String coffeeProtein) {
        this.coffeeProtein = coffeeProtein;
    }

    public String getCoffeeNatrium() {
        return coffeeNatrium;
    }

    public void setCoffeeNatrium(String coffeeNatrium) {
        this.coffeeNatrium = coffeeNatrium;
    }

    public String getCoffeeFats() {
        return coffeeFats;
    }

    public void setCoffeeFats(String coffeeFats) {
        this.coffeeFats = coffeeFats;
    }

    // 기본생성자
    public CoffeeDTO() {

    }

    // 필드값을 매개변수로 갖는 생성자
    public static Long idValue = 1L;
    public CoffeeDTO(String coffeeName, int coffeePrice, String coffeeCaffein, String coffeeCalories, String coffeeCarbohydrate, String coffeeSugars, String coffeeProtein, String coffeeNatrium, String coffeeFats) {
        this.id = idValue++;
        this.coffeeName = coffeeName;
        this.coffeePrice = coffeePrice;
        this.coffeeCaffein = coffeeCaffein;
        this.coffeeCalories = coffeeCalories;
        this.coffeeCarbohydrate = coffeeCarbohydrate;
        this.coffeeSugars = coffeeSugars;
        this.coffeeProtein = coffeeProtein;
        this.coffeeNatrium = coffeeNatrium;
        this.coffeeFats = coffeeFats;
    }

    // toString

    @Override
    public String toString() {
        return "CoffeeDTO{" +
                "id=" + id +
                ", coffeeName='" + coffeeName + '\'' +
                ", coffeePrice=" + coffeePrice +
                ", coffeeCaffein='" + coffeeCaffein + '\'' +
                ", coffeeCalories='" + coffeeCalories + '\'' +
                ", coffeeCarbohydrate='" + coffeeCarbohydrate + '\'' +
                ", coffeeSugars='" + coffeeSugars + '\'' +
                ", coffeeProtein='" + coffeeProtein + '\'' +
                ", coffeeNatrium='" + coffeeNatrium + '\'' +
                ", coffeeFats='" + coffeeFats + '\'' +
                '}';
    }
}
