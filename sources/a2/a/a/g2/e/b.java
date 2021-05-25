package a2.a.a.g2.e;

import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ UserReviewDetailsPresenterImpl a;

    public b(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
        this.a = userReviewDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        UserReviewDetailsPresenterImpl.access$handleError(userReviewDetailsPresenterImpl, th2);
    }
}
