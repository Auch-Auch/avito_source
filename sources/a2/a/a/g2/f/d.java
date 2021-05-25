package a2.a.a.g2.f;

import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import com.avito.android.remote.model.user_reviews.UserReviewsResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<UserReviewsResult> {
    public final /* synthetic */ UserReviewsPresenterImpl a;

    public d(UserReviewsPresenterImpl userReviewsPresenterImpl) {
        this.a = userReviewsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(UserReviewsResult userReviewsResult) {
        this.a.f = userReviewsResult.getNextPage();
    }
}
