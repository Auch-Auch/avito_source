package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
public final class WorkerParameters {
    @NonNull
    public UUID a;
    @NonNull
    public Data b;
    @NonNull
    public Set<String> c;
    @NonNull
    public RuntimeExtras d;
    public int e;
    @NonNull
    public Executor f;
    @NonNull
    public TaskExecutor g;
    @NonNull
    public WorkerFactory h;
    @NonNull
    public ProgressUpdater i;
    @NonNull
    public ForegroundUpdater j;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class RuntimeExtras {
        @RequiresApi(28)
        public Network network;
        @NonNull
        public List<String> triggeredContentAuthorities = Collections.emptyList();
        @NonNull
        public List<Uri> triggeredContentUris = Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerParameters(@NonNull UUID uuid, @NonNull Data data, @NonNull Collection<String> collection, @NonNull RuntimeExtras runtimeExtras, @IntRange(from = 0) int i2, @NonNull Executor executor, @NonNull TaskExecutor taskExecutor, @NonNull WorkerFactory workerFactory, @NonNull ProgressUpdater progressUpdater, @NonNull ForegroundUpdater foregroundUpdater) {
        this.a = uuid;
        this.b = data;
        this.c = new HashSet(collection);
        this.d = runtimeExtras;
        this.e = i2;
        this.f = executor;
        this.g = taskExecutor;
        this.h = workerFactory;
        this.i = progressUpdater;
        this.j = foregroundUpdater;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getBackgroundExecutor() {
        return this.f;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ForegroundUpdater getForegroundUpdater() {
        return this.j;
    }

    @NonNull
    public UUID getId() {
        return this.a;
    }

    @NonNull
    public Data getInputData() {
        return this.b;
    }

    @Nullable
    @RequiresApi(28)
    public Network getNetwork() {
        return this.d.network;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ProgressUpdater getProgressUpdater() {
        return this.i;
    }

    @IntRange(from = 0)
    public int getRunAttemptCount() {
        return this.e;
    }

    @NonNull
    public Set<String> getTags() {
        return this.c;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return this.g;
    }

    @NonNull
    @RequiresApi(24)
    public List<String> getTriggeredContentAuthorities() {
        return this.d.triggeredContentAuthorities;
    }

    @NonNull
    @RequiresApi(24)
    public List<Uri> getTriggeredContentUris() {
        return this.d.triggeredContentUris;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerFactory getWorkerFactory() {
        return this.h;
    }
}
