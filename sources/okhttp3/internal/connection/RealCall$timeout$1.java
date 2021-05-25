package okhttp3.internal.connection;

import kotlin.Metadata;
import okio.AsyncTimeout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/connection/RealCall$timeout$1", "Lokio/AsyncTimeout;", "", "timedOut", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealCall$timeout$1 extends AsyncTimeout {
    public final /* synthetic */ RealCall this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public RealCall$timeout$1(RealCall realCall) {
        this.this$0 = realCall;
    }

    @Override // okio.AsyncTimeout
    public void timedOut() {
        this.this$0.cancel();
    }
}
