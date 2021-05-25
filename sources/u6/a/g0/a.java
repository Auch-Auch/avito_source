package u6.a.g0;

import android.view.Choreographer;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
public final class a implements Choreographer.FrameCallback {
    public final /* synthetic */ CancellableContinuation a;

    public a(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a.resumeUndispatched(Dispatchers.getMain(), Long.valueOf(j));
    }
}
