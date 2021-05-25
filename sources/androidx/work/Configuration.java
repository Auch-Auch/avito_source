package androidx.work;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.impl.DefaultRunnableScheduler;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorKt;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public final class Configuration {
    @SuppressLint({"MinMaxConstant"})
    public static final int MIN_SCHEDULER_LIMIT = 20;
    @NonNull
    public final Executor a;
    @NonNull
    public final Executor b;
    @NonNull
    public final WorkerFactory c;
    @NonNull
    public final InputMergerFactory d;
    @NonNull
    public final RunnableScheduler e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final boolean j;

    public interface Provider {
        @NonNull
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(@NonNull Builder builder) {
        Executor executor = builder.a;
        if (executor == null) {
            this.a = a();
        } else {
            this.a = executor;
        }
        Executor executor2 = builder.d;
        if (executor2 == null) {
            this.j = true;
            this.b = a();
        } else {
            this.j = false;
            this.b = executor2;
        }
        WorkerFactory workerFactory = builder.b;
        if (workerFactory == null) {
            this.c = WorkerFactory.getDefaultWorkerFactory();
        } else {
            this.c = workerFactory;
        }
        InputMergerFactory inputMergerFactory = builder.c;
        if (inputMergerFactory == null) {
            this.d = InputMergerFactory.getDefaultInputMergerFactory();
        } else {
            this.d = inputMergerFactory;
        }
        RunnableScheduler runnableScheduler = builder.e;
        if (runnableScheduler == null) {
            this.e = new DefaultRunnableScheduler();
        } else {
            this.e = runnableScheduler;
        }
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
    }

    @NonNull
    public final Executor a() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    @NonNull
    public Executor getExecutor() {
        return this.a;
    }

    @NonNull
    public InputMergerFactory getInputMergerFactory() {
        return this.d;
    }

    public int getMaxJobSchedulerId() {
        return this.h;
    }

    @IntRange(from = 20, to = ChatListAdBannerInteractorKt.UPDATE_BANNER_MUTATOR_THROTTLE_MS)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxSchedulerLimit() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.i / 2;
        }
        return this.i;
    }

    public int getMinJobSchedulerId() {
        return this.g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMinimumLoggingLevel() {
        return this.f;
    }

    @NonNull
    public RunnableScheduler getRunnableScheduler() {
        return this.e;
    }

    @NonNull
    public Executor getTaskExecutor() {
        return this.b;
    }

    @NonNull
    public WorkerFactory getWorkerFactory() {
        return this.c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUsingDefaultTaskExecutor() {
        return this.j;
    }

    public static final class Builder {
        public Executor a;
        public WorkerFactory b;
        public InputMergerFactory c;
        public Executor d;
        public RunnableScheduler e;
        public int f;
        public int g;
        public int h;
        public int i;

        public Builder() {
            this.f = 4;
            this.g = 0;
            this.h = Integer.MAX_VALUE;
            this.i = 20;
        }

        @NonNull
        public Configuration build() {
            return new Configuration(this);
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.a = executor;
            return this;
        }

        @NonNull
        public Builder setInputMergerFactory(@NonNull InputMergerFactory inputMergerFactory) {
            this.c = inputMergerFactory;
            return this;
        }

        @NonNull
        public Builder setJobSchedulerJobIdRange(int i2, int i3) {
            if (i3 - i2 >= 1000) {
                this.g = i2;
                this.h = i3;
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs a range of at least 1000 job ids.");
        }

        @NonNull
        public Builder setMaxSchedulerLimit(int i2) {
            if (i2 >= 20) {
                this.i = Math.min(i2, 50);
                return this;
            }
            throw new IllegalArgumentException("WorkManager needs to be able to schedule at least 20 jobs in JobScheduler.");
        }

        @NonNull
        public Builder setMinimumLoggingLevel(int i2) {
            this.f = i2;
            return this;
        }

        @NonNull
        public Builder setRunnableScheduler(@NonNull RunnableScheduler runnableScheduler) {
            this.e = runnableScheduler;
            return this;
        }

        @NonNull
        public Builder setTaskExecutor(@NonNull Executor executor) {
            this.d = executor;
            return this;
        }

        @NonNull
        public Builder setWorkerFactory(@NonNull WorkerFactory workerFactory) {
            this.b = workerFactory;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(@NonNull Configuration configuration) {
            this.a = configuration.a;
            this.b = configuration.c;
            this.c = configuration.d;
            this.d = configuration.b;
            this.f = configuration.f;
            this.g = configuration.g;
            this.h = configuration.h;
            this.i = configuration.i;
            this.e = configuration.e;
        }
    }
}
