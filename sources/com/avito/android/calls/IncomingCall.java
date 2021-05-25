package com.avito.android.calls;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/calls/IncomingCall;", "Lcom/avito/android/calls/Call;", "", "decline", "()V", "busy", "", "enableVideo", "answer", "(Z)V", "", "getCallerId", "()Ljava/lang/String;", "callerId", "calls_release"}, k = 1, mv = {1, 4, 2})
public interface IncomingCall extends Call {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void answer$default(IncomingCall incomingCall, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                incomingCall.answer(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: answer");
        }
    }

    void answer(boolean z);

    void busy();

    void decline();

    @NotNull
    String getCallerId();
}
