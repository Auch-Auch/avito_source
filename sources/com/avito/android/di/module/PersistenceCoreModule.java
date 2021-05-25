package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.db.DbHelper;
import com.avito.android.db.SavedSearchDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.db.viewed.ViewedAdvertsDaoImpl;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.preferences.PrefMessengerStorage;
import com.avito.android.preferences.PrefTokenStorage;
import com.avito.android.preferences.PrefUserAdvertsInfoStorage;
import com.avito.android.preferences.PrefVersionStorage;
import com.avito.android.preferences.SocialNotificationStateStorage;
import com.avito.android.preferences.SocialNotificationStateStorageImpl;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.preferences.UpdateStorage;
import com.avito.android.preferences.UserAdvertsInfoStorage;
import com.avito.android.preferences.UserFavoritesStorage;
import com.avito.android.preferences.UserFavoritesStorageImpl;
import com.avito.android.preferences.VersionStorage;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.PreferenceFactoryImpl;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020$2\u0006\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020/2\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010\u0018\u001a\u00020\u0013H\u0007¢\u0006\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/avito/android/di/module/PersistenceCoreModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/db/DbHelper;", "provideDbHelper", "(Landroid/app/Application;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/db/DbHelper;", "dbHelper", "Lcom/avito/android/db/SavedSearchDao;", "provideSavedSearchDao", "(Lcom/avito/android/db/DbHelper;)Lcom/avito/android/db/SavedSearchDao;", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "provideViewedItemsDao", "(Lcom/avito/android/db/DbHelper;)Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "context", "Lcom/avito/android/util/preferences/Preferences;", "provideDefaultPreferences", "(Lcom/avito/android/util/preferences/PreferenceFactory;Landroid/app/Application;)Lcom/avito/android/util/preferences/Preferences;", "providePreferenceFactory", "()Lcom/avito/android/util/preferences/PreferenceFactory;", "prefs", "Lcom/avito/android/preferences/TokenStorage;", "provideGcmTokenStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/TokenStorage;", "Lcom/avito/android/preferences/MutableTokenStorage;", "provideMutableGcmTokenStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/MutableTokenStorage;", "Lcom/avito/android/preferences/PrefVersionStorage;", "versionStorage", "Lcom/avito/android/preferences/VersionStorage;", "provideVersionStorage", "(Lcom/avito/android/preferences/PrefVersionStorage;)Lcom/avito/android/preferences/VersionStorage;", "Lcom/avito/android/preferences/UpdateStorage;", "provideUpdateStorage", "(Lcom/avito/android/preferences/PrefVersionStorage;)Lcom/avito/android/preferences/UpdateStorage;", "providePrefVersionStorage", "(Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/preferences/PrefVersionStorage;", "Lcom/avito/android/preferences/MessengerStorage;", "provideMessengerStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/MessengerStorage;", "Lcom/avito/android/preferences/UserFavoritesStorage;", "provideUserFavoritesStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/UserFavoritesStorage;", "Lcom/avito/android/preferences/SocialNotificationStateStorage;", "provideSocialNotificationsStateStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/SocialNotificationStateStorage;", "Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "provideUserAdvertsInfoStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/UserAdvertsInfoStorage;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PersistenceCoreModule {
    @Provides
    @Singleton
    @NotNull
    public final DbHelper provideDbHelper(@NotNull Application application, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new DbHelper(application, buildInfo);
    }

    @Provides
    @NotNull
    public final Preferences provideDefaultPreferences(@NotNull PreferenceFactory preferenceFactory, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        Intrinsics.checkNotNullParameter(application, "context");
        return preferenceFactory.getDefaultPreferences(application);
    }

    @Provides
    @NotNull
    public final TokenStorage provideGcmTokenStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefTokenStorage(preferences);
    }

    @Provides
    @NotNull
    public final MessengerStorage provideMessengerStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefMessengerStorage(preferences);
    }

    @Provides
    @NotNull
    public final MutableTokenStorage provideMutableGcmTokenStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefTokenStorage(preferences);
    }

    @Provides
    @Singleton
    @NotNull
    public final PrefVersionStorage providePrefVersionStorage(@NotNull Preferences preferences, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new PrefVersionStorage(preferences, buildInfo.getVersionCode());
    }

    @Provides
    @Singleton
    @NotNull
    public final PreferenceFactory providePreferenceFactory() {
        return new PreferenceFactoryImpl();
    }

    @Provides
    @NotNull
    public final SavedSearchDao provideSavedSearchDao(@NotNull DbHelper dbHelper) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        return new SavedSearchDao(dbHelper);
    }

    @Provides
    @NotNull
    public final SocialNotificationStateStorage provideSocialNotificationsStateStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new SocialNotificationStateStorageImpl(preferences);
    }

    @Provides
    @NotNull
    public final UpdateStorage provideUpdateStorage(@NotNull PrefVersionStorage prefVersionStorage) {
        Intrinsics.checkNotNullParameter(prefVersionStorage, "versionStorage");
        return prefVersionStorage;
    }

    @Provides
    @NotNull
    public final UserAdvertsInfoStorage provideUserAdvertsInfoStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new PrefUserAdvertsInfoStorage(preferences);
    }

    @Provides
    @NotNull
    public final UserFavoritesStorage provideUserFavoritesStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new UserFavoritesStorageImpl(preferences);
    }

    @Provides
    @NotNull
    public final VersionStorage provideVersionStorage(@NotNull PrefVersionStorage prefVersionStorage) {
        Intrinsics.checkNotNullParameter(prefVersionStorage, "versionStorage");
        return prefVersionStorage;
    }

    @Provides
    @NotNull
    public final ViewedAdvertsDao provideViewedItemsDao(@NotNull DbHelper dbHelper) {
        Intrinsics.checkNotNullParameter(dbHelper, "dbHelper");
        return new ViewedAdvertsDaoImpl(TimeSource.DEFAULT, dbHelper);
    }
}
