package a2.a.a.s0.h0.a;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RecommendationItemPresenterImpl a;
    public final /* synthetic */ TypedError b;
    public final /* synthetic */ SellerCarouselItem c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(RecommendationItemPresenterImpl recommendationItemPresenterImpl, TypedError typedError, SellerCarouselItem sellerCarouselItem) {
        super(0);
        this.a = recommendationItemPresenterImpl;
        this.b = typedError;
        this.c = sellerCarouselItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Action action;
        DeepLink deepLink;
        List<Action> actions = ((ErrorResult.ErrorDialog) this.b).getUserDialog().getActions();
        if (!(actions == null || (action = actions.get(0)) == null || (deepLink = action.getDeepLink()) == null)) {
            this.a.a(deepLink, this.c);
        }
        return Unit.INSTANCE;
    }
}
