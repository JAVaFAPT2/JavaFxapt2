package entity;

public class Storage {
    private int ingredient_id;
    private String ingredient_name;
    private int serving_amount;

    public Storage(int ingredient_id, String ingredient_name, int serving_amount) {
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
        this.serving_amount = serving_amount;
    }

    public Storage() {
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public int getServing_amount() {
        return serving_amount;
    }

    public void setServing_amount(int serving_amount) {
        this.serving_amount = serving_amount;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "ingredient_id=" + ingredient_id +
                ", ingredient_name='" + ingredient_name + '\'' +
                ", serving_amount=" + serving_amount +
                '}';
    }

}
