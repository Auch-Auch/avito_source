package kotlinx.coroutines;

import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "", Tracker.Events.CREATIVE_COMPLETE, "()Z", "", OkListener.KEY_EXCEPTION, "completeExceptionally", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public interface CompletableJob extends Job {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static <R> R fold(@NotNull CompletableJob completableJob, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) Job.DefaultImpls.fold(completableJob, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E get(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.Key<E> key) {
            return (E) Job.DefaultImpls.get(completableJob, key);
        }

        @NotNull
        public static CoroutineContext minusKey(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.minusKey(completableJob, key);
        }

        @NotNull
        public static CoroutineContext plus(@NotNull CompletableJob completableJob, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.plus(completableJob, coroutineContext);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static Job plus(@NotNull CompletableJob completableJob, @NotNull Job job) {
            return Job.DefaultImpls.plus((Job) completableJob, job);
        }
    }

    boolean complete();

    boolean completeExceptionally(@NotNull Throwable th);
}
