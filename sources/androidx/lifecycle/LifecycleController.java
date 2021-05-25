package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "", "finish", "()V", "Landroidx/lifecycle/Lifecycle;", AuthSource.BOOKING_ORDER, "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/DispatchQueue;", "d", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/Lifecycle$State;", "c", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/LifecycleEventObserver;", AuthSource.SEND_ABUSE, "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
@MainThread
public final class LifecycleController {
    public final LifecycleEventObserver a;
    public final Lifecycle b;
    public final Lifecycle.State c;
    public final DispatchQueue d;

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull DispatchQueue dispatchQueue, @NotNull Job job) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(state, "minState");
        Intrinsics.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics.checkNotNullParameter(job, "parentJob");
        this.b = lifecycle;
        this.c = state;
        this.d = dispatchQueue;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleEventObserver(this, job) { // from class: androidx.lifecycle.LifecycleController$observer$1
            public final /* synthetic */ LifecycleController a;
            public final /* synthetic */ Job b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
                Intrinsics.checkNotNullParameter(event, "<anonymous parameter 1>");
                Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
                if (lifecycle2.getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = this.a;
                    Job.DefaultImpls.cancel$default(this.b, (CancellationException) null, 1, (Object) null);
                    lifecycleController.finish();
                    return;
                }
                Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle3, "source.lifecycle");
                if (lifecycle3.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.a)) < 0) {
                    LifecycleController.access$getDispatchQueue$p(this.a).pause();
                } else {
                    LifecycleController.access$getDispatchQueue$p(this.a).resume();
                }
            }
        };
        this.a = lifecycleController$observer$1;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            finish();
            return;
        }
        lifecycle.addObserver(lifecycleController$observer$1);
    }

    public static final void access$handleDestroy(LifecycleController lifecycleController, Job job) {
        Objects.requireNonNull(lifecycleController);
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        lifecycleController.finish();
    }

    @MainThread
    public final void finish() {
        this.b.removeObserver(this.a);
        this.d.finish();
    }
}
