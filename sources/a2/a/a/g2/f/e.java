package a2.a.a.g2.f;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import com.avito.android.rating.user_reviews.UserReviewsView;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class e<T> implements Consumer<List<? extends RatingDetailsItem>> {
    public final /* synthetic */ UserReviewsPresenterImpl a;

    public e(UserReviewsPresenterImpl userReviewsPresenterImpl) {
        this.a = userReviewsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends RatingDetailsItem> list) {
        this.a.e = list;
        this.a.a();
        UserReviewsView userReviewsView = this.a.a;
        if (userReviewsView != null) {
            UserReviewsPresenterImpl.access$scrollToErrorIfNeeded(this.a, userReviewsView);
        }
    }
}
