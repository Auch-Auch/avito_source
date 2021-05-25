package a2.a.a.g2.e;

import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import com.avito.android.rating.user_review_details.UserReviewDetailsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ UserReviewDetailsPresenterImpl a;

    public a(UserReviewDetailsPresenterImpl userReviewDetailsPresenterImpl) {
        this.a = userReviewDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        UserReviewDetailsView userReviewDetailsView = this.a.a;
        if (userReviewDetailsView != null) {
            userReviewDetailsView.showProgress();
        }
    }
}
