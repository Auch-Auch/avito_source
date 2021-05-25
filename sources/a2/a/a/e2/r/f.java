package a2.a.a.e2.r;

import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        super(0);
        this.a = publishDetailsPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PublishViewModel.goToNextStep$default(PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a), null, 1, null);
        return Unit.INSTANCE;
    }
}
