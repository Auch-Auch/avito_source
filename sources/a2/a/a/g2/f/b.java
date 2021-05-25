package a2.a.a.g2.f;

import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ UserReviewsPresenterImpl a;

    public b(UserReviewsPresenterImpl userReviewsPresenterImpl) {
        this.a = userReviewsPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.h = false;
    }
}
