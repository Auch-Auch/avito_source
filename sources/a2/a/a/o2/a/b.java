package a2.a.a.o2.a;

import a2.b.a.a.a;
import com.avito.android.service.short_task.BundlesKt;
import com.avito.android.service.short_task.RunJobFailedListener;
import com.avito.android.service.short_task.ShortTask;
import com.avito.android.service.short_task.ShortTasksKt;
import com.avito.android.util.Logs;
import com.evernote.android.job.Job;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends Job {
    public final ShortTask j;
    public final RunJobFailedListener k;

    public b(@NotNull ShortTask shortTask, @NotNull RunJobFailedListener runJobFailedListener) {
        Intrinsics.checkNotNullParameter(shortTask, "shortTask");
        Intrinsics.checkNotNullParameter(runJobFailedListener, "runJobFailedListener");
        this.j = shortTask;
        this.k = runJobFailedListener;
    }

    @Override // com.evernote.android.job.Job
    @NotNull
    public Job.Result onRunJob(@NotNull Job.Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Logs.debug$default("AndroidJobCreator", "onRunTask: tag=" + this.j.getTag() + "; extras=" + params.getExtras(), null, 4, null);
        try {
            ShortTask shortTask = this.j;
            PersistableBundleCompat extras = params.getExtras();
            Intrinsics.checkNotNullExpressionValue(extras, "params.extras");
            shortTask.initialize(BundlesKt.toBundle(extras));
            ShortTask.Status blockingGet = this.j.start().blockingGet();
            Intrinsics.checkNotNullExpressionValue(blockingGet, "shortTask.start()\n                .blockingGet()");
            Job.Result androidJobResult = ShortTasksKt.toAndroidJobResult(blockingGet);
            Logs.debug$default("AndroidJobCreator", "onRunTask: " + androidJobResult + " tag=" + this.j.getTag() + "; extras=" + params.getExtras(), null, 4, null);
            return androidJobResult;
        } catch (Exception e) {
            StringBuilder L = a.L("onRunTask: FAILED tag=");
            L.append(this.j.getTag());
            L.append("; extras=");
            L.append(params.getExtras());
            Logs.error$default("AndroidJobCreator", L.toString(), null, 4, null);
            this.k.onRunJobFailed(this.j, e);
            return Job.Result.FAILURE;
        }
    }
}
