package kotlinx.coroutines.flow.internal;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "Lkotlinx/coroutines/flow/FlowCollector;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/flow/FlowCollector;", "getOwner", "()Lkotlinx/coroutines/flow/FlowCollector;", UrlParams.OWNER, "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class AbortFlowException extends CancellationException {
    @NotNull
    public final FlowCollector<?> a;

    public AbortFlowException(@NotNull FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.a = flowCollector;
    }

    @Override // java.lang.Throwable
    @NotNull
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @NotNull
    public final FlowCollector<?> getOwner() {
        return this.a;
    }
}
