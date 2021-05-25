package a2.a.a.s0.h0.a;

import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ RecommendationItemPresenterImpl a;

    public a(RecommendationItemPresenterImpl recommendationItemPresenterImpl) {
        this.a = recommendationItemPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        RecommendationItemPresenter.Router router = this.a.f;
        if (router != null) {
            router.openNotificationsSettings();
        }
    }
}
