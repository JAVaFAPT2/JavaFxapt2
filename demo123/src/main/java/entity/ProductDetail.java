package entity;

public class ProductDetail {
    private int productDetailId;
    private int productId;
    private int IngredientId;

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(int ingredientId) {
        IngredientId = ingredientId;
    }

    public ProductDetail(int productDetailId, int productId, int ingredientId) {
        this.productDetailId = productDetailId;
        this.productId = productId;
        IngredientId = ingredientId;
    }

    public ProductDetail() {
    }
}
