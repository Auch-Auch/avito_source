package a2.a.a.w.b.a;

import com.avito.android.brandspace.items.carousel.CarouselItemView;
import com.avito.android.brandspace.items.carousel.WrapHeightCarouselItemViewImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class a<T> implements Consumer<Integer> {
    public final /* synthetic */ WrapHeightCarouselItemViewImpl a;

    public a(WrapHeightCarouselItemViewImpl wrapHeightCarouselItemViewImpl) {
        this.a = wrapHeightCarouselItemViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        CarouselItemView.Listener listener = this.a.C;
        if (listener != null) {
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            listener.onHeightChanged(num2.intValue());
        }
    }
}
