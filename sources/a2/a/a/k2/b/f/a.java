package a2.a.a.k2.b.f;

import com.avito.android.remote.model.PageParams;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.search.map.interactor.SerpDataSources;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.interactor.SerpKey;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<SerpDataSources, SerpInteractor.Result> {
    public final /* synthetic */ SerpKey a;
    public final /* synthetic */ SerpElementResult b;
    public final /* synthetic */ int c;
    public final /* synthetic */ SerpDisplayType d;

    public a(SerpKey serpKey, SerpElementResult serpElementResult, int i, SerpDisplayType serpDisplayType) {
        this.a = serpKey;
        this.b = serpElementResult;
        this.c = i;
        this.d = serpDisplayType;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpInteractor.Result apply(SerpDataSources serpDataSources) {
        SerpDataSources serpDataSources2 = serpDataSources;
        PageParams build = this.a.getPageParams().builder().lastStamp(Long.valueOf(this.b.getLastStamp())).nextPageId(this.b.getNextPageId()).build();
        SerpKey serpKey = this.a;
        Intrinsics.checkNotNullExpressionValue(build, "updatedPageParams");
        SerpKey copy$default = SerpKey.copy$default(serpKey, null, build, 0, this.b.getSubscriptionId(), this.b.getSearchHint(), this.b.getSearchDescription(), 5, null);
        Intrinsics.checkNotNullExpressionValue(serpDataSources2, "it");
        return new SerpInteractor.Result(copy$default, serpDataSources2, this.b.getElements().size() > this.c, this.b.getSubscriptionId(), this.b.getCount(), this.d, this.b.isSubscribed(), this.b.getXHash());
    }
}
