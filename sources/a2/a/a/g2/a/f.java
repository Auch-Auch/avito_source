package a2.a.a.g2.a;

import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.remote.model.rating_details.RatingDetailsResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<RatingDetailsResult> {
    public final /* synthetic */ RatingDetailsPresenterImpl a;

    public f(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        this.a = ratingDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(RatingDetailsResult ratingDetailsResult) {
        this.a.h = ratingDetailsResult.getRequestReviewAction();
    }
}
