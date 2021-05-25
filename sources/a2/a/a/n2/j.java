package a2.a.a.n2;

import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.serp.SerpElementResultWithPageParams;
import com.avito.android.serp.SerpInteractorImpl;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import t6.n.d;
public final class j<T, R> implements Function<SerpElementResult, SerpElementResultWithPageParams> {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SerpElementResultWithPageParams apply(SerpElementResult serpElementResult) {
        SerpElementResult serpElementResult2 = serpElementResult;
        this.a.a.f = false;
        if (this.a.b.isFirstPage()) {
            SerpInteractorImpl serpInteractorImpl = this.a.a;
            Intrinsics.checkNotNullExpressionValue(serpElementResult2, "serpElementResult");
            if (SerpInteractorImpl.access$isEmpty(serpInteractorImpl, serpElementResult2)) {
                this.a.a.g = true;
                return new SerpElementResultWithPageParams(serpElementResult2.cloneWithNewElements(d.listOf(SerpInteractorImpl.access$createEmptySearchItem(this.a.a, serpElementResult2.getEmptySearchText()))), this.a.b.createEmptySearch(Long.valueOf(serpElementResult2.getLastStamp())));
            }
            this.a.a.g = false;
            SerpElementResult cloneWithNewElements = this.a.a.B ? serpElementResult2.cloneWithNewElements(SerpInteractorImpl.access$addJobNearbyBanner(this.a.a, serpElementResult2)) : serpElementResult2;
            Intrinsics.checkNotNullExpressionValue(cloneWithNewElements, "serpElementResultWithJobsNearbyWarningIfNeeded");
            return new SerpElementResultWithPageParams(cloneWithNewElements, this.a.b.createNextPage(Long.valueOf(serpElementResult2.getLastStamp()), Integer.valueOf(serpElementResult2.getElements().size()), serpElementResult2.getNextPageId()));
        }
        Intrinsics.checkNotNullExpressionValue(serpElementResult2, "serpElementResult");
        return new SerpElementResultWithPageParams(serpElementResult2, this.a.b.createNextPage(Long.valueOf(serpElementResult2.getLastStamp()), Integer.valueOf(serpElementResult2.getElements().size()), serpElementResult2.getNextPageId()));
    }
}
