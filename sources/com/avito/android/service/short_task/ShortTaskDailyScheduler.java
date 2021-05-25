package com.avito.android.service.short_task;

import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/service/short_task/ShortTaskDailyScheduler;", "", "Lcom/avito/android/service/short_task/ShortTask;", "task", "", "startMs", "endMs", "", "updateCurrent", "Landroid/os/Bundle;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "", "schedule", "(Lcom/avito/android/service/short_task/ShortTask;JJZLandroid/os/Bundle;)V", "job-scheduler_release"}, k = 1, mv = {1, 4, 2})
public interface ShortTaskDailyScheduler {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void schedule$default(ShortTaskDailyScheduler shortTaskDailyScheduler, ShortTask shortTask, long j, long j2, boolean z, Bundle bundle, int i, Object obj) {
            if (obj == null) {
                shortTaskDailyScheduler.schedule(shortTask, j, j2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: schedule");
        }
    }

    void schedule(@NotNull ShortTask shortTask, long j, long j2, boolean z, @Nullable Bundle bundle);
}
