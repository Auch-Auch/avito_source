package a2.a.a.p3.a.a;

import com.avito.android.vas_discount.ui.dialog.DiscountPickerViewModelImpl;
import com.avito.conveyor_item.Item;
import java.util.List;
import java.util.concurrent.Callable;
public final class f<V> implements Callable<List<? extends Item>> {
    public final /* synthetic */ DiscountPickerViewModelImpl a;

    public f(DiscountPickerViewModelImpl discountPickerViewModelImpl) {
        this.a = discountPickerViewModelImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends Item> call() {
        return this.a.l.convert(this.a.k);
    }
}
