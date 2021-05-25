package a2.a.a.e2.r;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.remote.model.PretendResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class i0 extends Lambda implements Function1<PretendResult, Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(1);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(PretendResult pretendResult) {
        PretendResult pretendResult2 = pretendResult;
        PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(pretendResult2, "it");
        PublishDetailsPresenterImpl.access$onValidationFinished(publishDetailsPresenterImpl, pretendResult2);
        return Unit.INSTANCE;
    }
}
