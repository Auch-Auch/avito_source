package a2.a.a.p3.a.a;

import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class h<T> implements Consumer<Throwable> {
    public final /* synthetic */ DiscountPickerViewModelImpl a;

    public h(DiscountPickerViewModelImpl discountPickerViewModelImpl) {
        this.a = discountPickerViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        this.a.e.setValue(Unit.INSTANCE);
    }
}
