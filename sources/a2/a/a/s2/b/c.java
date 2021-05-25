package a2.a.a.s2.b;

import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.shop.detailed.ShopDetailedInteractorImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class c<T> implements Consumer<SerpElementResult> {
    public final /* synthetic */ ShopDetailedInteractorImpl a;

    public c(ShopDetailedInteractorImpl shopDetailedInteractorImpl) {
        this.a = shopDetailedInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SerpElementResult serpElementResult) {
        SerpElementResult serpElementResult2 = serpElementResult;
        ShopDetailedInteractorImpl shopDetailedInteractorImpl = this.a;
        PageParams build = shopDetailedInteractorImpl.b.builder().incrementPage().lastStamp(Long.valueOf(serpElementResult2.getLastStamp())).nextPageId(serpElementResult2.getNextPageId()).build();
        Intrinsics.checkNotNullExpressionValue(build, "pageParams.builder()\n   …                 .build()");
        shopDetailedInteractorImpl.b = build;
    }
}
