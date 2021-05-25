package a2.a.a.f1.f;

import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallNotificationsDelegate;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class f<T> implements Consumer<CallManager.MissedCallData> {
    public final /* synthetic */ CallManagerService a;

    public f(CallManagerService callManagerService) {
        this.a = callManagerService;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CallManager.MissedCallData missedCallData) {
        CallManager.MissedCallData missedCallData2 = missedCallData;
        CallNotificationsDelegate notificationsDelegate = this.a.getNotificationsDelegate();
        Intrinsics.checkNotNullExpressionValue(missedCallData2, "missedCall");
        notificationsDelegate.showMissedCallNotification(missedCallData2);
    }
}
