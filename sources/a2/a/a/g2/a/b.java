package a2.a.a.g2.a;

import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Action;
public final class b implements Action {
    public final /* synthetic */ RatingDetailsPresenterImpl a;

    public b(RatingDetailsPresenterImpl ratingDetailsPresenterImpl) {
        this.a = ratingDetailsPresenterImpl;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.j = false;
    }
}
