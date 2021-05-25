package a2.a.a.g2.a;

import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.remote.model.rating_details.RatingDetailsResult;
import io.reactivex.rxjava3.functions.Consumer;
public final class d<T> implements Consumer<RatingDetailsResult> {
    public final /* synthetic */ RatingDetailsPresenterImpl a;

    public d(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        this.a = ratingDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(RatingDetailsResult ratingDetailsResult) {
        this.a.g = ratingDetailsResult.getAction();
    }
}
