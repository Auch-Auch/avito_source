package a2.a.a.g2.f;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, List<? extends RatingDetailsItem>> {
    public final /* synthetic */ UserReviewsPresenterImpl a;

    public a(UserReviewsPresenterImpl userReviewsPresenterImpl) {
        this.a = userReviewsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public List<? extends RatingDetailsItem> apply(Throwable th) {
        Throwable th2 = th;
        UserReviewsPresenterImpl userReviewsPresenterImpl = this.a;
        List list = userReviewsPresenterImpl.e;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = userReviewsPresenterImpl.b(list);
        UserReviewsPresenterImpl userReviewsPresenterImpl2 = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        return UserReviewsPresenterImpl.access$withErrorSnippet(userReviewsPresenterImpl, list2, UserReviewsPresenterImpl.access$getMessage(userReviewsPresenterImpl2, th2));
    }
}
