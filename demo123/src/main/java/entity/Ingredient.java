package entity;

public class Ingredient {
    private int ingredientId;
    private String ingredientName;
    private int servingAmount;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getServingAmount() {
        return servingAmount;
    }

    public void setServingAmount(int servingAmount) {
        this.servingAmount = servingAmount;
    }

    public Ingredient(int ingredientId, String ingredientName, int servingAmount) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.servingAmount = servingAmount;
    }

    public Ingredient() {
    }
}
