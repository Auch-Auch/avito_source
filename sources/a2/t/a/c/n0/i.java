package a2.t.a.c.n0;

import com.voximplant.sdk.call.CallError;
import com.voximplant.sdk.call.CallException;
import com.voximplant.sdk.call.ICallCompletionHandler;
import com.voximplant.sdk.internal.call.Call;
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ Call.a a;
    public final /* synthetic */ CallError b;

    public /* synthetic */ i(Call.a aVar, CallError callError) {
        this.a = aVar;
        this.b = callError;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Call.a aVar = this.a;
        CallError callError = this.b;
        ICallCompletionHandler iCallCompletionHandler = aVar.b;
        if (iCallCompletionHandler != null) {
            CallError callError2 = CallError.INTERNAL_ERROR;
            if (callError == callError2) {
                iCallCompletionHandler.onFailure(new CallException(callError2, "Internal error"));
            }
            CallError callError3 = CallError.REJECTED;
            if (callError == callError3) {
                aVar.b.onFailure(new CallException(callError3, "Operation is rejected"));
            }
            CallError callError4 = CallError.ALREADY_IN_THIS_STATE;
            if (callError == callError4) {
                aVar.b.onFailure(new CallException(callError4, "Operation is failed due to the call is already in this state"));
            }
            CallError callError5 = CallError.TIMEOUT;
            if (callError == callError5) {
                aVar.b.onFailure(new CallException(callError5, "Operation is failed due to timeout"));
            }
            CallError callError6 = CallError.MEDIA_IS_ON_HOLD;
            if (callError == callError6) {
                aVar.b.onFailure(new CallException(callError6, "Operation is not permitted while media is on hold. Call ICall.hold(false) and repeat operation"));
            }
            CallError callError7 = CallError.MISSING_PERMISSION;
            if (callError == callError7) {
                aVar.b.onFailure(new CallException(callError7, "Operation is failed due to CAMERA permission is missing"));
            }
        }
    }
}
