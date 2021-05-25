package a2.a.a.f2.a;

import com.avito.android.publish_limits_info.history.PublishLimitsHistoryActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublishLimitsHistoryActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PublishLimitsHistoryActivity publishLimitsHistoryActivity) {
        super(0);
        this.a = publishLimitsHistoryActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.getHistoryViewModel().onRetryClicked();
        return Unit.INSTANCE;
    }
}
