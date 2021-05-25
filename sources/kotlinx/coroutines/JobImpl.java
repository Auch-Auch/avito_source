package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\r\u001a\u00020\u00038\u0010@\u0010X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u00038P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0005¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/JobImpl;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/CompletableJob;", "", Tracker.Events.CREATIVE_COMPLETE, "()Z", "", OkListener.KEY_EXCEPTION, "completeExceptionally", "(Ljava/lang/Throwable;)Z", AuthSource.BOOKING_ORDER, "Z", "getHandlesException$kotlinx_coroutines_core", "handlesException", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/Job;", "parent", "<init>", "(Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class JobImpl extends JobSupport implements CompletableJob {
    public final boolean b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobImpl(@Nullable Job job) {
        super(true);
        JobSupport jobSupport;
        boolean z = true;
        initParentJobInternal$kotlinx_coroutines_core(job);
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        ChildHandleNode childHandleNode = (ChildHandleNode) (!(parentHandle$kotlinx_coroutines_core instanceof ChildHandleNode) ? null : parentHandle$kotlinx_coroutines_core);
        if (childHandleNode != null && (jobSupport = (JobSupport) childHandleNode.job) != null) {
            while (true) {
                if (!jobSupport.getHandlesException$kotlinx_coroutines_core()) {
                    ChildHandle parentHandle$kotlinx_coroutines_core2 = jobSupport.getParentHandle$kotlinx_coroutines_core();
                    ChildHandleNode childHandleNode2 = (ChildHandleNode) (!(parentHandle$kotlinx_coroutines_core2 instanceof ChildHandleNode) ? null : parentHandle$kotlinx_coroutines_core2);
                    if (childHandleNode2 != null) {
                        jobSupport = (JobSupport) childHandleNode2.job;
                        if (jobSupport == null) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        this.b = z;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean complete() {
        return makeCompleting$kotlinx_coroutines_core(Unit.INSTANCE);
    }

    @Override // kotlinx.coroutines.CompletableJob
    public boolean completeExceptionally(@NotNull Throwable th) {
        return makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(th, false, 2, null));
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return this.b;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
