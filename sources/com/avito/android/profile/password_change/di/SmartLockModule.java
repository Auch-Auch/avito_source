package com.avito.android.profile.password_change.di;

import android.app.Activity;
import android.content.Intent;
import com.avito.android.Features;
import com.avito.android.account.Credentials;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.SmartLockLoaderImpl;
import com.avito.android.authorization.smart_lock.SmartLockSaver;
import com.avito.android.authorization.smart_lock.SmartLockSaverImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preference;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/profile/password_change/di/SmartLockModule;", "", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "features", "Landroid/app/Activity;", "activity", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "provideSmartLockLoader", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Landroid/app/Activity;Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/smart_lock/SmartLockLoader;", "Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "provideSmartLockSaver", "(Landroid/app/Activity;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;)Lcom/avito/android/authorization/smart_lock/SmartLockSaver;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SmartLockModule {
    @NotNull
    public static final SmartLockModule INSTANCE = new SmartLockModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SmartLockLoader provideSmartLockLoader(@NotNull Analytics analytics, @NotNull DialogRouter dialogRouter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @NotNull Activity activity, @SmartLockLoaderState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (features.getSmartLock().invoke().booleanValue()) {
            return new SmartLockLoaderImpl(analytics, dialogRouter, activity, schedulersFactory3, kundle);
        }
        return new SmartLockLoader() { // from class: com.avito.android.profile.password_change.di.SmartLockModule$provideSmartLockLoader$1
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

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SmartLockSaver provideSmartLockSaver(@NotNull Activity activity, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @SmartLockSaverState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getSmartLock().invoke().booleanValue()) {
            return new SmartLockSaverImpl(activity, analytics, schedulersFactory3, kundle);
        }
        return new SmartLockSaver() { // from class: com.avito.android.profile.password_change.di.SmartLockModule$provideSmartLockSaver$1
            public final PublishRelay<SmartLockSaver.Command> a;

            {
                PublishRelay<SmartLockSaver.Command> create = PublishRelay.create();
                Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
                this.a = create;
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            @NotNull
            public Observable<SmartLockSaver.Command> connect() {
                return this.a;
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            @NotNull
            public Observable<Maybe<Unit>> connectWithObservables() {
                return SmartLockSaver.DefaultImpls.connectWithObservables(this);
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            public void handleResult(int i, @Nullable Intent intent) {
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            @NotNull
            public Kundle onSaveState() {
                return new Kundle();
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            @NotNull
            public Maybe<Unit> run(@NotNull SmartLockSaver.Command command) {
                Intrinsics.checkNotNullParameter(command, "command");
                Maybe<Unit> just = Maybe.just(Unit.INSTANCE);
                Intrinsics.checkNotNullExpressionValue(just, "Maybe.just(Unit)");
                return just;
            }

            @Override // com.avito.android.authorization.smart_lock.SmartLockSaver
            public void save(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "login");
                Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
                this.a.accept(new SmartLockSaver.Command.Save("", ""));
            }
        };
    }
}
