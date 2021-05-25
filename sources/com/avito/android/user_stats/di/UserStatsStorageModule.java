package com.avito.android.user_stats.di;

import android.app.Application;
import com.avito.android.di.PerFragment;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorageImpl;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsStorageModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/util/preferences/Preferences;", "provideEditorPreferences", "(Landroid/app/Application;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/util/preferences/Preferences;", "<init>", "()V", "Declarations", "user-stats_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class UserStatsStorageModule {
    @NotNull
    public static final UserStatsStorageModule INSTANCE = new UserStatsStorageModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_stats/di/UserStatsStorageModule$Declarations;", "", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorageImpl;", "impl", "Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "provideSmbStatsTooltipSessionStorage", "(Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorageImpl;)Lcom/avito/android/user_stats/storage/SmbStatsTooltipSessionStorage;", "user-stats_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        SmbStatsTooltipSessionStorage provideSmbStatsTooltipSessionStorage(@NotNull SmbStatsTooltipSessionStorageImpl smbStatsTooltipSessionStorageImpl);
    }

    @SmbTooltipPreferences
    @Provides
    @NotNull
    public final Preferences provideEditorPreferences(@NotNull Application application, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return preferenceFactory.getCustomPreferences(application, Names.SMB_STATS_TOOLTIP);
    }
}
