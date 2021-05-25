package a2.a.a.r.b.a;

import com.avito.android.basket_legacy.viewmodels.checkout.CheckoutViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class c<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public c(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MediatorLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        this.a.c.postValue(list);
    }
}
