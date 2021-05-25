package com.avito.android.service.short_task;

import android.content.Context;
import android.os.Bundle;
import com.avito.android.BaseApp;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.FingerprintCalculationDependencies;
import com.avito.android.di.component.DaggerFingerprintCalculationComponent;
import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.avito.security.libfp.FingerprintService;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/service/short_task/FingerprintCalculationTask;", "Lcom/avito/android/service/short_task/ShortTask;", "Landroid/os/Bundle;", "bundle", "", "initialize", "(Landroid/os/Bundle;)V", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Lcom/avito/android/preferences/FingerprintStorage;", "fingerprintStorage", "Lcom/avito/android/preferences/FingerprintStorage;", "getFingerprintStorage", "()Lcom/avito/android/preferences/FingerprintStorage;", "setFingerprintStorage", "(Lcom/avito/android/preferences/FingerprintStorage;)V", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "getRequiredNetworkState", "()Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "requiredNetworkState", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public class FingerprintCalculationTask implements ShortTask {
    @NotNull
    public final ShortTask.NetworkState a = ShortTask.NetworkState.ANY;
    @NotNull
    public final String b = FingerprintCalculationTaskKt.FINGERPRINT_CALC_TASK_TAG;
    @Inject
    public Context context;
    @Inject
    public FingerprintStorage fingerprintStorage;

    public static final class a<T> implements SingleSource<ShortTask.Status> {
        public final /* synthetic */ Future a;
        public final /* synthetic */ ExecutorService b;

        public a(Future future, ExecutorService executorService) {
            this.a = future;
            this.b = executorService;
        }

        @Override // io.reactivex.SingleSource
        public final void subscribe(@NotNull SingleObserver<? super ShortTask.Status> singleObserver) {
            Intrinsics.checkNotNullParameter(singleObserver, "it");
            this.a.cancel(true);
            this.b.shutdownNow();
            throw new InterruptedException();
        }
    }

    public static final class b implements ThreadFactory {
        public static final b a = new b();

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "FingerprintCalculationTask");
        }
    }

    public static final ShortTask.Status access$fingerprintRoutine(FingerprintCalculationTask fingerprintCalculationTask) {
        Objects.requireNonNull(fingerprintCalculationTask);
        try {
            Context context2 = fingerprintCalculationTask.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            }
            FingerprintService init = FingerprintService.init(context2);
            Intrinsics.checkNotNullExpressionValue(init, "FingerprintService.init(context)");
            String calculateFingerprint = init.calculateFingerprint();
            if (calculateFingerprint != null) {
                FingerprintStorage fingerprintStorage2 = fingerprintCalculationTask.fingerprintStorage;
                if (fingerprintStorage2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fingerprintStorage");
                }
                fingerprintStorage2.setFingerprint(calculateFingerprint);
                return ShortTask.Status.SUCCESS;
            }
            FingerprintStorage fingerprintStorage3 = fingerprintCalculationTask.fingerprintStorage;
            if (fingerprintStorage3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fingerprintStorage");
            }
            fingerprintStorage3.setFingerprint("ERR");
            return ShortTask.Status.FAILED;
        } catch (Throwable unused) {
            FingerprintStorage fingerprintStorage4 = fingerprintCalculationTask.fingerprintStorage;
            if (fingerprintStorage4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fingerprintStorage");
            }
            fingerprintStorage4.setFingerprint("ERR");
            return ShortTask.Status.FAILED;
        }
    }

    @NotNull
    public final Context getContext() {
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return context2;
    }

    @NotNull
    public final FingerprintStorage getFingerprintStorage() {
        FingerprintStorage fingerprintStorage2 = this.fingerprintStorage;
        if (fingerprintStorage2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fingerprintStorage");
        }
        return fingerprintStorage2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public ShortTask.NetworkState getRequiredNetworkState() {
        return this.a;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public String getTag() {
        return this.b;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    public void initialize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        DaggerFingerprintCalculationComponent.builder().dependencies((FingerprintCalculationDependencies) ComponentDependenciesKt.getDependencies(FingerprintCalculationDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(BaseApp.Companion.getInstance()))).build().inject(this);
    }

    public final void setContext(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public final void setFingerprintStorage(@NotNull FingerprintStorage fingerprintStorage2) {
        Intrinsics.checkNotNullParameter(fingerprintStorage2, "<set-?>");
        this.fingerprintStorage = fingerprintStorage2;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public Single<ShortTask.Status> start() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(b.a);
        Future submit = newSingleThreadExecutor.submit(new a2.a.a.o2.a.a(this));
        Intrinsics.checkNotNullExpressionValue(submit, "executor.submit(createFingerprintCallable())");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Single<ShortTask.Status> subscribeOn = Single.fromFuture(submit, 8, timeUnit).timeout(5, timeUnit, new a(submit, newSingleThreadExecutor)).subscribeOn(Schedulers.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Single.fromFuture(future…Schedulers.computation())");
        return subscribeOn;
    }
}
