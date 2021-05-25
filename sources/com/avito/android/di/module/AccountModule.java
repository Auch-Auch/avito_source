package com.avito.android.di.module;

import android.accounts.AccountManager;
import android.app.Application;
import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountInteractorImpl;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.AccountStorageInteractorImpl;
import com.avito.android.account.AccountStorageMigrationManager;
import com.avito.android.account.AccountUpdateInteractor;
import com.avito.android.account.AccountUpdateInteractorImpl;
import com.avito.android.account.LegacyAccountUpdateInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.MutableLastLoggedEmailStorage;
import com.avito.android.account.MutableLastUserStorage;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.account_manager.AccountManagerStorage;
import com.avito.android.account.plugin.AuthorizationPlugin;
import com.avito.android.analytics.Analytics;
import com.avito.android.preferences.MutableSessionStorage;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.profile.MutableProfileInfoStorage;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bC\u0010DJ_\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010%\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b%\u0010&J'\u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b*\u0010+J/\u0010/\u001a\u00020.2\u0006\u0010-\u001a\u00020,2\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u00192\u0006\u00102\u001a\u000201H\u0007¢\u0006\u0004\b3\u00104JP\u0010>\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010'\u001a\u00020)2\u0006\u00106\u001a\u0002052\u0017\u0010;\u001a\u0013\u0012\u000f\u0012\r\u0012\t\u0012\u000709¢\u0006\u0002\b:08072\u0006\u0010=\u001a\u00020<2\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020)H\u0007¢\u0006\u0004\bA\u0010B¨\u0006E"}, d2 = {"Lcom/avito/android/di/module/AccountModule;", "", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/preferences/TokenStorage;", "tokenStorage", "Lcom/avito/android/account/LoginSuggestStorage;", "loginSuggestStorage", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/account/AccountUpdateInteractor;", "accountUpdateInteractor", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConverter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/account/AccountInteractor;", "provideAccountInteractor", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/preferences/TokenStorage;Lcom/avito/android/account/LoginSuggestStorage;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountUpdateInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/account/AccountInteractor;", "Landroid/accounts/AccountManager;", "accountManager", "Lcom/avito/android/account/account_manager/AccountManagerStorage;", "provideAccountManagerStorage", "(Landroid/accounts/AccountManager;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/account/account_manager/AccountManagerStorage;", "Lcom/avito/android/preferences/MutableSessionStorage;", "sessionStorage", "Lcom/avito/android/profile/MutableProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/account/MutableLastUserStorage;", "lastUserStorage", "Lcom/avito/android/account/AccountStorageInteractorImpl;", "provideAccountStorageInteractorImpl", "(Lcom/avito/android/preferences/MutableSessionStorage;Lcom/avito/android/profile/MutableProfileInfoStorage;Lcom/avito/android/account/MutableLastUserStorage;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/account/AccountStorageInteractorImpl;", "accountStorageInteractor", "accountManagerStorage", "Lcom/avito/android/account/AccountStorageInteractor;", "provideAccountStorageInteractor", "(Lcom/avito/android/account/AccountStorageInteractorImpl;Lcom/avito/android/account/account_manager/AccountManagerStorage;Lcom/avito/android/Features;)Lcom/avito/android/account/AccountStorageInteractor;", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/account/AccountStorageMigrationManager;", "provideAccountStorageMigrationManager", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/account/AccountStorageInteractorImpl;Lcom/avito/android/account/account_manager/AccountManagerStorage;Lcom/avito/android/Features;)Lcom/avito/android/account/AccountStorageMigrationManager;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideAccountManager", "(Landroid/app/Application;)Landroid/accounts/AccountManager;", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Ldagger/Lazy;", "", "Lcom/avito/android/account/plugin/AuthorizationPlugin;", "Lkotlin/jvm/JvmSuppressWildcards;", "plugins", "Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "mutableLastLoggedEmailStorage", "provideAccountUpdateInteractor", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/account/SessionChangeTracker;Ldagger/Lazy;Lcom/avito/android/account/MutableLastLoggedEmailStorage;Lcom/avito/android/Features;)Lcom/avito/android/account/AccountUpdateInteractor;", "storageInteractor", "provideAccountStatusProvider", "(Lcom/avito/android/account/AccountStorageInteractor;)Lcom/avito/android/account/AccountStateProvider;", "<init>", "()V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SessionUpdateTrackerModule.class})
public final class AccountModule {
    @NotNull
    public static final AccountModule INSTANCE = new AccountModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountInteractor provideAccountInteractor(@NotNull ProfileApi profileApi, @NotNull TokenStorage tokenStorage, @NotNull LoginSuggestStorage loginSuggestStorage, @NotNull Features features, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountUpdateInteractor accountUpdateInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(tokenStorage, "tokenStorage");
        Intrinsics.checkNotNullParameter(loginSuggestStorage, "loginSuggestStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(accountUpdateInteractor, "accountUpdateInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConverter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new AccountInteractorImpl(profileApi, tokenStorage, loginSuggestStorage, features, schedulersFactory3, accountUpdateInteractor, accountStateProvider, typedErrorThrowableConverter, analytics, buildInfo);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountManager provideAccountManager(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        AccountManager accountManager = AccountManager.get(application);
        Intrinsics.checkNotNullExpressionValue(accountManager, "AccountManager.get(application)");
        return accountManager;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountManagerStorage provideAccountManagerStorage(@NotNull AccountManager accountManager, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(accountManager, "accountManager");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new AccountManagerStorage(accountManager, buildInfo);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountStateProvider provideAccountStatusProvider(@NotNull AccountStorageInteractor accountStorageInteractor) {
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "storageInteractor");
        return accountStorageInteractor;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountStorageInteractor provideAccountStorageInteractor(@NotNull AccountStorageInteractorImpl accountStorageInteractorImpl, @NotNull AccountManagerStorage accountManagerStorage, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(accountStorageInteractorImpl, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(accountManagerStorage, "accountManagerStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        return features.getAccountManager().invoke().booleanValue() ? accountManagerStorage : accountStorageInteractorImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountStorageInteractorImpl provideAccountStorageInteractorImpl(@NotNull MutableSessionStorage mutableSessionStorage, @NotNull MutableProfileInfoStorage mutableProfileInfoStorage, @NotNull MutableLastUserStorage mutableLastUserStorage, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(mutableSessionStorage, "sessionStorage");
        Intrinsics.checkNotNullParameter(mutableProfileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(mutableLastUserStorage, "lastUserStorage");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new AccountStorageInteractorImpl(mutableSessionStorage, mutableProfileInfoStorage, mutableLastUserStorage, buildInfo);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountStorageMigrationManager provideAccountStorageMigrationManager(@NotNull Preferences preferences, @NotNull AccountStorageInteractorImpl accountStorageInteractorImpl, @NotNull AccountManagerStorage accountManagerStorage, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(accountStorageInteractorImpl, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(accountManagerStorage, "accountManagerStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AccountStorageMigrationManager(preferences, features, accountManagerStorage, accountStorageInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final AccountUpdateInteractor provideAccountUpdateInteractor(@NotNull Analytics analytics, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull Lazy<Set<AuthorizationPlugin>> lazy, @NotNull MutableLastLoggedEmailStorage mutableLastLoggedEmailStorage, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(lazy, "plugins");
        Intrinsics.checkNotNullParameter(mutableLastLoggedEmailStorage, "mutableLastLoggedEmailStorage");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getAccountManager().invoke().booleanValue()) {
            return new AccountUpdateInteractorImpl(analytics, accountStorageInteractor, sessionChangeTracker, lazy, mutableLastLoggedEmailStorage);
        }
        return new LegacyAccountUpdateInteractor(analytics, accountStorageInteractor, sessionChangeTracker, lazy, mutableLastLoggedEmailStorage);
    }
}
