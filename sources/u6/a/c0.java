package u6.a;

import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class c0 extends JobImpl {
    public c0(@Nullable Job job) {
        super(job);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean childCancelled(@NotNull Throwable th) {
        return false;
    }
}
