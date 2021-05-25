package a2.a.a.g2.b;

import com.avito.android.rating.publish.RatingPublishPresenter;
import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import com.avito.android.remote.model.publish.AddRatingResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl.f a;
    public final /* synthetic */ AddRatingResult b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(RatingPublishPresenterImpl.f fVar, AddRatingResult addRatingResult) {
        super(0);
        this.a = fVar;
        this.b = addRatingResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.q.trackSendRatingLoadingSuccess();
        this.a.a.q.startSendRatingDraw();
        RatingPublishPresenter.Router router = this.a.a.b;
        if (router != null) {
            router.closeWithMessage(this.a.b.getUserKey(), this.b.getMessage());
        }
        this.a.a.q.trackSendRatingDrawSuccess();
        return Unit.INSTANCE;
    }
}
