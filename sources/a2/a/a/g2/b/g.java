package a2.a.a.g2.b;

import com.avito.android.rating.publish.RatingPublishPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RatingPublishPresenterImpl.g a;
    public final /* synthetic */ Throwable b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(RatingPublishPresenterImpl.g gVar, Throwable th) {
        super(0);
        this.a = gVar;
        this.b = th;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.a.q.trackSendRatingLoadingFail();
        this.a.a.q.startSendRatingDraw();
        RatingPublishPresenterImpl ratingPublishPresenterImpl = this.a.a;
        Throwable th = this.b;
        Intrinsics.checkNotNullExpressionValue(th, "error");
        ratingPublishPresenterImpl.b(th);
        this.a.a.q.trackSendRatingDrawFail();
        return Unit.INSTANCE;
    }
}
