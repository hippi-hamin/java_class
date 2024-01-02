package chxx_project.dto;

public class MenuDTO {
    // 필드
    private Long id;
    private String category;
    private String menuName;
    private int menuPrice;
    private String menuCalories;
    private String menuSugars;
    private String menuFats;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuCalories() {
        return menuCalories;
    }

    public void setMenuCalories(String menuCalories) {
        this.menuCalories = menuCalories;
    }

    public String getMenuSugars() {
        return menuSugars;
    }

    public void setMenuSugars(String menuSugars) {
        this.menuSugars = menuSugars;
    }

    public String getMenuFats() {
        return menuFats;
    }

    public void setMenuFats(String menuFats) {
        this.menuFats = menuFats;
    }

    // 기본생성자
    public MenuDTO() {

    }

    // 필드값을 매개변수로 갖는 생성자
    public static Long idValue = 1L;
    public MenuDTO(String category, String menuName, int menuPrice, String menuCalories, String menuSugars, String menuFats) {
        this.id = idValue++;
        this.category = category;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCalories = menuCalories;
        this.menuSugars = menuSugars;
        this.menuFats = menuFats;
    }

    // toString
    @Override
    public String toString() {
        return "MenuDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuCalories='" + menuCalories + '\'' +
                ", menuSugars='" + menuSugars + '\'' +
                ", menuFats='" + menuFats + '\'' +
                '}';
    }
}
