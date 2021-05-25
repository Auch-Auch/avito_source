package a2.a.a.g2.a;

import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.rating.details.RatingDetailsView;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
public final class g<T> implements Consumer<List<? extends RatingDetailsItem>> {
    public final /* synthetic */ RatingDetailsPresenterImpl a;

    public g(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        this.a = ratingDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(List<? extends RatingDetailsItem> list) {
        this.a.e = list;
        RatingDetailsPresenterImpl.access$updateCommentButton(this.a);
        this.a.a();
        RatingDetailsPresenterImpl.access$updateItems(this.a);
        RatingDetailsView ratingDetailsView = this.a.c;
        if (ratingDetailsView != null) {
            RatingDetailsPresenterImpl.access$scrollToErrorIfNeeded(this.a, ratingDetailsView);
        }
    }
}
