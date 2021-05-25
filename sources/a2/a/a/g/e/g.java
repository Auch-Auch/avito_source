package a2.a.a.g.e;

import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<Throwable> {
    public final /* synthetic */ AdvertContactsPresenterImpl a;

    public g(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
        this.a = advertContactsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        AdvertCoreView advertCoreView = this.a.f;
        if (advertCoreView != null) {
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            advertCoreView.showError(th2);
        }
    }
}
