package a2.a.a.f.x;

import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.remote.model.AdvertDetails;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class l<T> implements Consumer<Boolean> {
    public final /* synthetic */ AdvertDetailsPresenterImpl a;
    public final /* synthetic */ AdvertDetails b;

    public l(AdvertDetailsPresenterImpl advertDetailsPresenterImpl, AdvertDetails advertDetails) {
        this.a = advertDetailsPresenterImpl;
        this.b = advertDetails;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        AdvertDetailsPresenterImpl advertDetailsPresenterImpl = this.a;
        AdvertDetails advertDetails = this.b;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        AdvertDetailsPresenterImpl.access$onOnlineStatusChanged(advertDetailsPresenterImpl, advertDetails, bool2.booleanValue());
    }
}
