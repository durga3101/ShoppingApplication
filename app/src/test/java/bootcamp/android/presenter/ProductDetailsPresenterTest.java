package bootcamp.android.presenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import bootcamp.android.models.Product;
import bootcamp.android.view.ProductDetailsView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductDetailsPresenterTest {

    @Mock
    ProductDetailsView mockView;
    ProductDetailsPresenter presenter;


    @Test
    public void shouldReturnProductTitle() {
        ProductDetailsPresenter productDetailsPresenter = new ProductDetailsPresenter(mockView);

        productDetailsPresenter.getProduct("title", "desc", "imageUrl");

        verify(mockView).renderProduct(any(Product.class));
    }
}
