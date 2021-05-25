package a2.a.a.g2.b;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import com.avito.android.remote.model.Action;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl a;
    public final /* synthetic */ Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(RatingPublishPresenterImpl ratingPublishPresenterImpl, Action action) {
        super(0);
        this.a = ratingPublishPresenterImpl;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DeepLink deepLink;
        Action action = this.b;
        if (action == null || (deepLink = action.getDeepLink()) == null) {
            RatingPublishPresenter.Router router = this.a.b;
            if (router != null) {
                router.onExit();
            }
        } else {
            this.a.a(deepLink);
        }
        return Unit.INSTANCE;
    }
}
