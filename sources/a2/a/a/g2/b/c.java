package a2.a.a.g2.b;

import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(RatingPublishPresenterImpl ratingPublishPresenterImpl) {
        super(0);
        this.a = ratingPublishPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        RatingPublishPresenter.Router router = this.a.b;
        if (router != null) {
            router.onExit();
        }
        return Unit.INSTANCE;
    }
}
