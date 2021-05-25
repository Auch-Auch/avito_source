package a2.a.a.e2.a0;

import com.avito.android.publish.publish_advert_request.PublishAdvertRequestViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublishAdvertRequestViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(PublishAdvertRequestViewModel publishAdvertRequestViewModel) {
        super(0);
        this.a = publishAdvertRequestViewModel;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.onRetryClicked();
        return Unit.INSTANCE;
    }
}
