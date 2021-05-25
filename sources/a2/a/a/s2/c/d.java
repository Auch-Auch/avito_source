package a2.a.a.s2.c;

import com.avito.android.shop.filter.ShopsFilterPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ ShopsFilterPresenterImpl a;

    public d(ShopsFilterPresenterImpl shopsFilterPresenterImpl) {
        this.a = shopsFilterPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        ShopsFilterPresenterImpl shopsFilterPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        ShopsFilterPresenterImpl.access$onFailedToLoadFilterData(shopsFilterPresenterImpl, th2);
    }
}
