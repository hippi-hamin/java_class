package chxx_project.dto;

public class TeaDTO {
    // 필드
    private Long id;
    private String teaName;
    private int teaPrice;
    private String teaCalories;
    private String teaCarbohydrate;
    private String teaSugars;
    private String teaProtein;
    private String teaNatrium;
    private String teaFats;

    // getter/setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(int teaPrice) {
        this.teaPrice = teaPrice;
    }

    public String getTeaCalories() {
        return teaCalories;
    }

    public void setTeaCalories(String teaCalories) {
        this.teaCalories = teaCalories;
    }

    public String getTeaCarbohydrate() {
        return teaCarbohydrate;
    }

    public void setTeaCarbohydrate(String teaCarbohydrate) {
        this.teaCarbohydrate = teaCarbohydrate;
    }

    public String getTeaSugars() {
        return teaSugars;
    }

    public void setTeaSugars(String teaSugars) {
        this.teaSugars = teaSugars;
    }

    public String getTeaProtein() {
        return teaProtein;
    }

    public void setTeaProtein(String teaProtein) {
        this.teaProtein = teaProtein;
    }

    public String getTeaNatrium() {
        return teaNatrium;
    }

    public void setTeaNatrium(String teaNatrium) {
        this.teaNatrium = teaNatrium;
    }

    public String getTeaFats() {
        return teaFats;
    }

    public void setTeaFats(String teaFats) {
        this.teaFats = teaFats;
    }

    // 기본생성자
    public TeaDTO(){

    }

    // 필드값을 매개변수로 갖는 생성자
    public static Long idValue = 1L;
    public TeaDTO(String teaName, int teaPrice, String teaCalories, String teaCarbohydrate, String teaSugars, String teaProtein, String teaNatrium, String teaFats) {
        this.id = idValue;
        this.teaName = teaName;
        this.teaPrice = teaPrice;
        this.teaCalories = teaCalories;
        this.teaCarbohydrate = teaCarbohydrate;
        this.teaSugars = teaSugars;
        this.teaProtein = teaProtein;
        this.teaNatrium = teaNatrium;
        this.teaFats = teaFats;
    }

    //toString

    @Override
    public String toString() {
        return "TeaDTO{" +
                "id=" + id +
                ", teaName='" + teaName + '\'' +
                ", teaPrice=" + teaPrice +
                ", teaCalories='" + teaCalories + '\'' +
                ", teaCarbohydrate='" + teaCarbohydrate + '\'' +
                ", teaSugars='" + teaSugars + '\'' +
                ", teaProtein='" + teaProtein + '\'' +
                ", teaNatrium='" + teaNatrium + '\'' +
                ", teaFats='" + teaFats + '\'' +
                '}';
    }
}
