package com.avito.android.authorization.smart_lock.di;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.Features;
import com.avito.android.account.Credentials;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/authorization/smart_lock/di/SmartLockLoaderModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "features", "Landroid/app/Activity;", "activity", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "provideSmartLockLoader", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Landroid/app/Activity;Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "<init>", "()V", "smartlock_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class})
public final class SmartLockLoaderModule {
    @NotNull
    public static final SmartLockLoaderModule INSTANCE = new SmartLockLoaderModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SmartLockLoader provideSmartLockLoader(@NotNull Analytics analytics, @NotNull DialogRouter dialogRouter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @NotNull Activity activity, @SmartLockState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (features.getSmartLock().invoke().booleanValue()) {
            return new SmartLockLoaderImpl(analytics, dialogRouter, activity, schedulersFactory3, kundle);
        }
        return new SmartLockLoader() { // from class: com.avito.android.authorization.smart_lock.di.SmartLockLoaderModule$provideSmartLockLoader$1
            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            @NotNull
            public Single<Boolean> check() {
                Single<Boolean> just = Single.just(Boolean.FALSE);
                Intrinsics.checkNotNullExpressionValue(just, "Single.just(false)");
                return just;
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            @NotNull
            public Observable<SmartLockLoader.Command> connect() {
                Observable<SmartLockLoader.Command> never = Observable.never();
                Intrinsics.checkNotNullExpressionValue(never, "Observable.never()");
                return never;
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            @NotNull
            public Observable<Maybe<Credentials.PasswordCredentials>> connectWithObservables() {
                return SmartLockLoader.DefaultImpls.connectWithObservables(this);
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            public void handleResult(int i, @Nullable Intent intent) {
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            public void load(boolean z) {
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            @NotNull
            public Kundle onSaveState() {
                return new Kundle();
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockLoader
            @NotNull
            public Maybe<Credentials.PasswordCredentials> run(@NotNull SmartLockLoader.Command command) {
                Intrinsics.checkNotNullParameter(command, "command");
                Maybe<Credentials.PasswordCredentials> empty = Maybe.empty();
                Intrinsics.checkNotNullExpressionValue(empty, "Maybe.empty()");
                return empty;
            }
        };
    }
}
