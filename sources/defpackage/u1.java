package defpackage;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.calls_shared.AppCallResult;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.in_app_calls.service.CallInfoSender;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import com.avito.android.in_app_calls.service.binder.CallState;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: u1  reason: default package */
public final class u1<V> implements Callable<CallManagerServiceDelegate.State> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ boolean d;

    public u1(int i, Object obj, Object obj2, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final CallManagerServiceDelegate.State call() {
        int i = this.a;
        if (i == 0) {
            String callUuid = ((CallManagerServiceDelegate.p) this.b).d.getCallUuid();
            long now = ((CallManagerServiceDelegate.p) this.b).e.u.now();
            AppCallInfo appCallInfo = new AppCallInfo(callUuid, false, ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getRecipient(), now, ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getScenario(), null, null, ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getItem(), 96, null);
            ((CallManagerServiceDelegate.p) this.b).e.z.track(new CallEvent.CallProcessStarted(appCallInfo));
            if (((CallManagerServiceDelegate.p) this.b).e.A.getCallsDontDropCalls().invoke().booleanValue() && ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).isNewCall()) {
                CompositeDisposable compositeDisposable = ((CallManagerServiceDelegate.p) this.b).e.p;
                CallInfoSender callInfoSender = ((CallManagerServiceDelegate.p) this.b).e.w;
                String callUuid2 = ((CallManagerServiceDelegate.p) this.b).d.getCallUuid();
                String itemId = ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getItem().getItemId();
                String callAs = ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getCallAs();
                if (callAs == null) {
                    callAs = "";
                }
                Disposable subscribe = InteropKt.toV2(callInfoSender.sendCallInfo(callUuid2, itemId, callAs, ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getRecipient().getContact())).subscribe();
                Intrinsics.checkNotNullExpressionValue(subscribe, "callInfoSender.sendCallI…     ).toV2().subscribe()");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
            }
            if (this.d) {
                ((CallManagerServiceDelegate.p) this.b).e.t.makeCall(appCallInfo, ((CallManagerService.StartRequest.Dial) ((CallManagerServiceDelegate.p) this.b).d).getCallAs());
                return new CallManagerServiceDelegate.State(new CallState.Dialing(appCallInfo), false, null, ((CallManagerServiceDelegate.State) this.c).isUiBound(), 6, null);
            }
            ((CallManagerServiceDelegate.p) this.b).e.z.track(new CallEvent.Disconnected(AppCallInfo.copy$default(appCallInfo, null, false, null, 0, null, null, Long.valueOf(((CallManagerServiceDelegate.p) this.b).e.u.now()), null, 191, null), AppCallResult.Busy.App.INSTANCE));
            return (CallManagerServiceDelegate.State) this.c;
        } else if (i == 1) {
            AppCallInfo appCallInfo2 = new AppCallInfo(((CallManagerServiceDelegate.p) this.b).d.getCallUuid(), true, ((CallManagerService.StartRequest.Receive) ((CallManagerServiceDelegate.p) this.b).d).getCaller(), ((CallManagerServiceDelegate.p) this.b).e.u.now(), AppCallScenario.INCOMING_CALL, null, null, ((CallManagerService.StartRequest.Receive) ((CallManagerServiceDelegate.p) this.b).d).getItem(), 96, null);
            ((CallManagerServiceDelegate.p) this.b).e.z.track(new CallEvent.CallProcessStarted(appCallInfo2));
            ((CallManagerServiceDelegate.p) this.b).e.t.onIncomingCall(appCallInfo2);
            if (this.d) {
                if (!((CallManagerService.StartRequest.Receive) ((CallManagerServiceDelegate.p) this.b).d).getCaller().isKnown()) {
                    ((CallManagerServiceDelegate.p) this.b).e.x.requestCallInfo(((CallManagerServiceDelegate.p) this.b).d.getCallUuid());
                }
                return new CallManagerServiceDelegate.State(new CallState.Ringing(appCallInfo2), false, null, ((CallManagerServiceDelegate.State) this.c).isUiBound(), 6, null);
            }
            ((CallManagerServiceDelegate.p) this.b).e.z.track(new CallEvent.Disconnected(AppCallInfo.copy$default(appCallInfo2, null, false, null, 0, null, null, Long.valueOf(((CallManagerServiceDelegate.p) this.b).e.u.now()), null, 191, null), AppCallResult.Busy.App.INSTANCE));
            return (CallManagerServiceDelegate.State) this.c;
        } else {
            throw null;
        }
    }
}
