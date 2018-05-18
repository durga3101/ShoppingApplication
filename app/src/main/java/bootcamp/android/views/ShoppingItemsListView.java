package bootcamp.android.views;

import java.util.List;

import bootcamp.android.models.Product;

public interface ShoppingItemsListView {
    void displayProductList(List<Product> body);

    void displayErrorMessage();
}
