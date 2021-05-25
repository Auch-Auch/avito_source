package a2.a.a.w.c;

import com.avito.android.brandspace.items.carousel.CarouselItem;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import t6.n.d;
public final class i<T, R> implements Function<List<? extends TextMeasurableItem>, List<? extends BrandspaceItem>> {
    public final /* synthetic */ CarouselItem a;

    public i(CarouselItem carouselItem) {
        this.a = carouselItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends BrandspaceItem> apply(List<? extends TextMeasurableItem> list) {
        return d.listOf(this.a);
    }
}
