package a2.a.a.g2.b;

import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import com.avito.android.remote.model.publish.RatingPublishResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl.h a;
    public final /* synthetic */ RatingPublishResult b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(RatingPublishPresenterImpl.h hVar, RatingPublishResult ratingPublishResult) {
        super(0);
        this.a = hVar;
        this.b = ratingPublishResult;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.q.trackNextStepLoadingSuccess();
        this.a.a.q.startNextStepDraw();
        RatingPublishPresenterImpl ratingPublishPresenterImpl = this.a.a;
        RatingPublishResult ratingPublishResult = this.b;
        Intrinsics.checkNotNullExpressionValue(ratingPublishResult, "it");
        RatingPublishPresenterImpl.access$handleStep(ratingPublishPresenterImpl, ratingPublishResult);
        this.a.a.q.trackNextStepDrawSuccess();
        return Unit.INSTANCE;
    }
}
