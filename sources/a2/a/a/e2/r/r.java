package a2.a.a.e2.r;

import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class r extends Lambda implements Function1<PhotoUploadObserver.UploadStatus, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(1);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(PhotoUploadObserver.UploadStatus uploadStatus) {
        this.a.c(PublishDetailsFlowTracker.FlowContext.PARAMETER_VALUE_UPDATE);
        return Unit.INSTANCE;
    }
}
