package a2.a.a.p3.a.a;

import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelImpl;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Consumer;
import java.util.List;
public final class g<T> implements Consumer<List<? extends Item>> {
    public final /* synthetic */ DiscountPickerViewModelImpl a;

    public g(DiscountPickerViewModelImpl discountPickerViewModelImpl) {
        this.a = discountPickerViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(List<? extends Item> list) {
        this.a.c.setValue(list);
    }
}
