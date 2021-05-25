package a2.a.a.w.c;

import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
public final class b<T, R> implements Function<List<? extends TextMeasurableItem>, List<? extends BrandspaceItem>> {
    public final /* synthetic */ List a;

    public b(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends BrandspaceItem> apply(List<? extends TextMeasurableItem> list) {
        return this.a;
    }
}
