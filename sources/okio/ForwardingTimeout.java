package okio;

import com.avito.android.remote.auth.AuthSource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0002\u0010\u0012\"\u0004\b\u0003\u0010\u0019¨\u0006\u001b"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "setDelegate", "(Lokio/Timeout;)Lokio/ForwardingTimeout;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "timeoutNanos", "()J", "", "hasDeadline", "()Z", "deadlineNanoTime", "(J)Lokio/Timeout;", "clearTimeout", "()Lokio/Timeout;", "clearDeadline", "", "throwIfReached", "()V", AuthSource.SEND_ABUSE, "Lokio/Timeout;", "(Lokio/Timeout;)V", "<init>", "okio"}, k = 1, mv = {1, 4, 0})
public class ForwardingTimeout extends Timeout {
    @NotNull
    public Timeout a;

    public ForwardingTimeout(@NotNull Timeout timeout) {
        Intrinsics.checkNotNullParameter(timeout, "delegate");
        this.a = timeout;
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearDeadline() {
        return this.a.clearDeadline();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout clearTimeout() {
        return this.a.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.a.deadlineNanoTime();
    }

    @JvmName(name = "delegate")
    @NotNull
    public final Timeout delegate() {
        return this.a;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.a.hasDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.a.throwIfReached();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout timeout(long j, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return this.a.timeout(j, timeUnit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.a.timeoutNanos();
    }

    @Override // okio.Timeout
    @NotNull
    public Timeout deadlineNanoTime(long j) {
        return this.a.deadlineNanoTime(j);
    }

    @NotNull
    public final ForwardingTimeout setDelegate(@NotNull Timeout timeout) {
        Intrinsics.checkNotNullParameter(timeout, "delegate");
        this.a = timeout;
        return this;
    }
}
