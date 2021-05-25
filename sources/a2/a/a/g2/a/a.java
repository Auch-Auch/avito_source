package a2.a.a.g2.a;

import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ RatingDetailsPresenterImpl a;

    public a(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        this.a = ratingDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(Throwable th) {
        Throwable th2 = th;
        RatingDetailsPresenterImpl ratingDetailsPresenterImpl = this.a;
        List list = ratingDetailsPresenterImpl.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List access$withoutLoadingItem = RatingDetailsPresenterImpl.access$withoutLoadingItem(ratingDetailsPresenterImpl, list);
        RatingDetailsPresenterImpl ratingDetailsPresenterImpl2 = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return RatingDetailsPresenterImpl.access$withErrorSnippet(ratingDetailsPresenterImpl, access$withoutLoadingItem, RatingDetailsPresenterImpl.access$getMessage(ratingDetailsPresenterImpl2, th2));
    }
}
