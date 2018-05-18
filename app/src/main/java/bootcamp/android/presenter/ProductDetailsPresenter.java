package bootcamp.android.presenter;

import bootcamp.android.models.Product;
import bootcamp.android.view.ProductDetailsView;


public class ProductDetailsPresenter {

    private final ProductDetailsView view;

    public ProductDetailsPresenter(ProductDetailsView view) {
        this.view = view;
    }

    public void renderProduct(String title, String description, String imageUrl) {
        view.renderProduct(new Product(title, description,imageUrl));
    }
}
