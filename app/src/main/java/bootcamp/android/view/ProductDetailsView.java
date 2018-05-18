package bootcamp.android.view;

import bootcamp.android.models.Product;

public interface ProductDetailsView {

    void renderProduct(Product product);

    void addToCart(Product product);
}
