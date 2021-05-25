package a2.a.a.f1.f;

import com.avito.android.calls_shared.AppCallInfo;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import com.avito.android.in_app_calls.service.binder.CallState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
public final class g<T> implements Consumer<CallManagerServiceDelegate.State> {
    public final /* synthetic */ CallManagerService a;
    public final /* synthetic */ Ref.ObjectRef b;

    public g(CallManagerService callManagerService, Ref.ObjectRef objectRef) {
        this.a = callManagerService;
        this.b = objectRef;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CallManagerServiceDelegate.State state) {
        AppCallInfo call;
        T t = (T) state;
        T t2 = this.b.element;
        String str = null;
        CallState callState = t2 != null ? t2.getCallState() : null;
        boolean z = true;
        this.a.getIncomingCallHandler().setAcceptReconnectCalls((t.getCallState() instanceof CallState.Connected) && ((CallState.Connected) t.getCallState()).isReconnecting());
        CallState callState2 = t.getCallState();
        if (callState2 instanceof CallState.Idle) {
            if (callState != null) {
                z = callState instanceof CallState.Idle;
            }
            if (!z) {
                this.a.getNotificationsDelegate().stopForeground();
            }
            this.a.a();
            this.a.getRingtoneDelegate().stopRingtone();
        } else if (callState2 instanceof CallState.Ringing) {
            CallState.Ringing ringing = (CallState.Ringing) callState2;
            this.a.getNotificationsDelegate().showCallNotification(ringing.getCall(), t.isUiBound(), false);
            if (!(callState == null || (call = callState.getCall()) == null)) {
                str = call.getCallId();
            }
            if (!Intrinsics.areEqual(str, ringing.getCall().getCallId())) {
                this.a.getNotificationsDelegate().showCallActivity(ringing.getCall());
            }
            this.a.a();
            this.a.getRingtoneDelegate().playRingtone();
        } else if (callState2 instanceof CallState.Dialing) {
            this.a.getNotificationsDelegate().showCallNotification(((CallState.Dialing) callState2).getCall(), t.isUiBound(), false);
            CallManagerService.access$updateProximityWakeLockState(this.a, t.getAudioDevice());
            this.a.getRingtoneDelegate().stopRingtone();
        } else if (callState2 instanceof CallState.Connected) {
            this.a.getNotificationsDelegate().showCallNotification(((CallState.Connected) callState2).getCall(), t.isUiBound(), true);
            this.a.getRingtoneDelegate().stopRingtone();
            CallManagerService.access$updateProximityWakeLockState(this.a, t.getAudioDevice());
        }
        this.b.element = t;
    }
}
