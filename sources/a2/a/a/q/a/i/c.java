package a2.a.a.q.a.i;

import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelImpl;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ CheckoutViewModelImpl a;

    public c(CheckoutViewModelImpl checkoutViewModelImpl) {
        this.a = checkoutViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.h.setValue(Boolean.FALSE);
        this.a.g.postValue(this.a.G.getUnknownError());
    }
}
