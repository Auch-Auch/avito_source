package a2.a.a.s2.c;

import com.avito.android.shop.filter.ShopsFilterData;
import com.avito.android.shop.filter.ShopsFilterPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<ShopsFilterData> {
    public final /* synthetic */ ShopsFilterPresenterImpl a;

    public c(ShopsFilterPresenterImpl shopsFilterPresenterImpl) {
        this.a = shopsFilterPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(ShopsFilterData shopsFilterData) {
        ShopsFilterData shopsFilterData2 = shopsFilterData;
        ShopsFilterPresenterImpl shopsFilterPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(shopsFilterData2, "it");
        ShopsFilterPresenterImpl.access$onFilterDataLoaded(shopsFilterPresenterImpl, shopsFilterData2);
    }
}
