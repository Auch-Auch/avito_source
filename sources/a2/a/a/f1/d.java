package a2.a.a.f1;

import com.avito.android.in_app_calls.CallManager;
import com.avito.android.in_app_calls.CallManagerImpl;
import com.avito.android.in_app_calls.analytics.CallPushHandlingTracker;
import io.reactivex.functions.Action;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
public final class d implements Action {
    public final /* synthetic */ CallManagerImpl.d a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ String c;

    public d(CallManagerImpl.d dVar, AtomicBoolean atomicBoolean, String str) {
        this.a = dVar;
        this.b = atomicBoolean;
        this.c = str;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        if (!this.b.get()) {
            CallPushHandlingTracker callPushHandlingTracker = this.a.a.z;
            String str = this.c;
            Intrinsics.checkNotNullExpressionValue(str, "pushId");
            callPushHandlingTracker.trackPushHandlingFailed(str, ((CallManager.State) this.a.a.getStateBlocking()).getConnected());
        }
    }
}
