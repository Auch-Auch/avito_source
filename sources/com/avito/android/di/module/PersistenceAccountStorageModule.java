package com.avito.android.di.module;

import com.avito.android.account.LastLoggedEmailStorage;
import com.avito.android.account.LastUserStorage;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.account.LoginSuggestStorageImpl;
import com.avito.android.account.MutableLastLoggedEmailStorage;
import com.avito.android.account.MutableLastUserStorage;
import com.avito.android.account.PrefLastLoggedEmailStorage;
import com.avito.android.account.PrefLastUserStorage;
import com.avito.android.db.sqlbrite.Database;
import com.avito.android.profile.PrefProfileInfoStorage;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/di/module/PersistenceAccountStorageModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/profile/ProfileInfoStorage;", "getProfileInfoStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/account/MutableLastUserStorage;", "provideMutableLastUserStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/account/MutableLastUserStorage;", "lastUserStorage", "Lcom/avito/android/account/LastUserStorage;", "provideLastUserStorage", "(Lcom/avito/android/account/MutableLastUserStorage;)Lcom/avito/android/account/LastUserStorage;", "Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "provideLastLoggedEmailStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/account/MutableLastLoggedEmailStorage;", "Lcom/avito/android/db/sqlbrite/Database;", "database", "Lcom/avito/android/account/LoginSuggestStorage;", "provideLoginSuggestStorage", "(Lcom/avito/android/db/sqlbrite/Database;)Lcom/avito/android/account/LoginSuggestStorage;", "storage", "Lcom/avito/android/account/LastLoggedEmailStorage;", "provideReadOnlyLastLoggedEmailStorage", "(Lcom/avito/android/account/MutableLastLoggedEmailStorage;)Lcom/avito/android/account/LastLoggedEmailStorage;", "<init>", "()V", "account-storage_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PersistenceAccountStorageModule {
    @Provides
    @NotNull
    public final ProfileInfoStorage getProfileInfoStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefProfileInfoStorage(preferences);
    }

    @Provides
    @NotNull
    public final MutableLastLoggedEmailStorage provideLastLoggedEmailStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefLastLoggedEmailStorage(preferences.getSharedPreferences());
    }

    @Provides
    @NotNull
    public final LastUserStorage provideLastUserStorage(@NotNull MutableLastUserStorage mutableLastUserStorage) {
        Intrinsics.checkNotNullParameter(mutableLastUserStorage, "lastUserStorage");
        return mutableLastUserStorage;
    }

    @Provides
    @NotNull
    public final LoginSuggestStorage provideLoginSuggestStorage(@NotNull Database database) {
        Intrinsics.checkNotNullParameter(database, "database");
        return new LoginSuggestStorageImpl(database);
    }

    @Provides
    @NotNull
    public final MutableLastUserStorage provideMutableLastUserStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefLastUserStorage(preferences);
    }

    @Provides
    @NotNull
    public final LastLoggedEmailStorage provideReadOnlyLastLoggedEmailStorage(@NotNull MutableLastLoggedEmailStorage mutableLastLoggedEmailStorage) {
        Intrinsics.checkNotNullParameter(mutableLastLoggedEmailStorage, "storage");
        return mutableLastLoggedEmailStorage;
    }
}
