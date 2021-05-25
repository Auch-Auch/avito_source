package defpackage;

import com.avito.android.calls_shared.tracker.errors.CallIllegalMviStateException;
import com.avito.android.calls_shared.tracker.errors.CallIllegalStateException;
import com.avito.android.calls_shared.tracker.events.CallEvent;
import com.avito.android.communications_common.analytics.ErrorTracker;
import com.avito.android.in_app_calls.service.CallManagerService;
import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import com.avito.android.in_app_calls.service.binder.CallState;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: i1  reason: default package */
public final class i1<V> implements Callable<CallManagerServiceDelegate.State> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public i1(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final CallManagerServiceDelegate.State call() {
        int i = this.a;
        if (i != 0) {
            if (i == 1) {
                CallState callState = ((CallManagerServiceDelegate.State) this.c).getCallState();
                if (callState instanceof CallState.Ringing) {
                    if (((CallManagerService.StartRequest.PendingAction) ((CallManagerServiceDelegate.p) this.b).d).getPendingAction().ordinal() == 1) {
                        ((CallManagerServiceDelegate.p) this.b).e.z.track(new CallEvent.RedButtonClicked(((CallState.Ringing) callState).getCall(), false));
                        ((CallManagerServiceDelegate.p) this.b).e.decline();
                    } else {
                        throw new CallIllegalStateException("Can't perform pending action [" + ((CallManagerService.StartRequest.PendingAction) ((CallManagerServiceDelegate.p) this.b).d).getPendingAction() + "] here");
                    }
                }
                return (CallManagerServiceDelegate.State) this.c;
            }
            throw null;
        } else if (!(((CallManagerServiceDelegate.State) this.c).getCallState() instanceof CallState.Connected) || !((CallState.Connected) ((CallManagerServiceDelegate.State) this.c).getCallState()).isReconnecting() || !Intrinsics.areEqual(((CallManagerServiceDelegate.p) this.b).d.getCallUuid(), ((CallState.Connected) ((CallManagerServiceDelegate.State) this.c).getCallState()).getCall().getCallId())) {
            ErrorTracker.DefaultImpls.track$default(((CallManagerServiceDelegate.p) this.b).e.B, new CallIllegalMviStateException("Can't reconnect"), null, null, 6, null);
            return (CallManagerServiceDelegate.State) this.c;
        } else {
            ((CallManagerServiceDelegate.p) this.b).e.t.onReconnectCall(((CallState.Connected) ((CallManagerServiceDelegate.State) this.c).getCallState()).getCall(), ((CallManagerServiceDelegate.State) this.c).getSendAudio());
            ((CallManagerServiceDelegate.p) this.b).e.y.selectAudioDevice(((CallManagerServiceDelegate.State) this.c).getAudioDevice());
            return (CallManagerServiceDelegate.State) this.c;
        }
    }
}
