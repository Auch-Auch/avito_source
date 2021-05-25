package androidx.work;

import a2.b.a.a.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
public abstract class ListenableWorker {
    @NonNull
    public Context a;
    @NonNull
    public WorkerParameters b;
    public volatile boolean c;
    public boolean d;
    public boolean e;

    public static abstract class Result {

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Failure extends Result {
            public final Data a;

            public Failure() {
                this(Data.EMPTY);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((Failure) obj).a);
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public Data getOutputData() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode() + 846803280;
            }

            public String toString() {
                StringBuilder L = a.L("Failure {mOutputData=");
                L.append(this.a);
                L.append('}');
                return L.toString();
            }

            public Failure(@NonNull Data data) {
                this.a = data;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Retry extends Result {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public int hashCode() {
                return 25945934;
            }

            public String toString() {
                return "Retry";
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final class Success extends Result {
            public final Data a;

            public Success() {
                this(Data.EMPTY);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((Success) obj).a);
            }

            @NonNull
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public Data getOutputData() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode() - 1876823561;
            }

            public String toString() {
                StringBuilder L = a.L("Success {mOutputData=");
                L.append(this.a);
                L.append('}');
                return L.toString();
            }

            public Success(@NonNull Data data) {
                this.a = data;
            }
        }

        @NonNull
        public static Result failure() {
            return new Failure();
        }

        @NonNull
        public static Result retry() {
            return new Retry();
        }

        @NonNull
        public static Result success() {
            return new Success();
        }

        @NonNull
        public static Result failure(@NonNull Data data) {
            return new Failure(data);
        }

        @NonNull
        public static Result success(@NonNull Data data) {
            return new Success(data);
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.a = context;
            this.b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.a;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Executor getBackgroundExecutor() {
        return this.b.getBackgroundExecutor();
    }

    @NonNull
    public final UUID getId() {
        return this.b.getId();
    }

    @NonNull
    public final Data getInputData() {
        return this.b.getInputData();
    }

    @Nullable
    @RequiresApi(28)
    public final Network getNetwork() {
        return this.b.getNetwork();
    }

    @IntRange(from = 0)
    public final int getRunAttemptCount() {
        return this.b.getRunAttemptCount();
    }

    @NonNull
    public final Set<String> getTags() {
        return this.b.getTags();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return this.b.getTaskExecutor();
    }

    @NonNull
    @RequiresApi(24)
    public final List<String> getTriggeredContentAuthorities() {
        return this.b.getTriggeredContentAuthorities();
    }

    @NonNull
    @RequiresApi(24)
    public final List<Uri> getTriggeredContentUris() {
        return this.b.getTriggeredContentUris();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkerFactory getWorkerFactory() {
        return this.b.getWorkerFactory();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRunInForeground() {
        return this.e;
    }

    public final boolean isStopped() {
        return this.c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean isUsed() {
        return this.d;
    }

    public void onStopped() {
    }

    @NonNull
    public final ListenableFuture<Void> setForegroundAsync(@NonNull ForegroundInfo foregroundInfo) {
        this.e = true;
        return this.b.getForegroundUpdater().setForegroundAsync(getApplicationContext(), getId(), foregroundInfo);
    }

    @NonNull
    public final ListenableFuture<Void> setProgressAsync(@NonNull Data data) {
        return this.b.getProgressUpdater().updateProgress(getApplicationContext(), getId(), data);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setUsed() {
        this.d = true;
    }

    @NonNull
    @MainThread
    public abstract ListenableFuture<Result> startWork();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void stop() {
        this.c = true;
        onStopped();
    }
}
