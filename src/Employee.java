public class Employee {
    private  String name;
    private  int age;
    private  String favoriteFood;

    public Employee(){

    }
    public Employee(String name,int age, String favoriteFood){
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return String.format ("Name:%-10s Age:%-5dFavoriteFood:%-10s ",name,age,favoriteFood);
    }
}
