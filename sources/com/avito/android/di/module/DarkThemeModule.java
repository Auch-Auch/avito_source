package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.lib.util.DarkThemeManagerImpl;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/di/module/DarkThemeModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "prefs", "Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;", "provideDarkThemeStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;", "storage", "Lcom/avito/android/lib/util/DarkThemeManager;", "provideDarkThemeManager", "(Lcom/avito/android/lib/util/DarkThemeManagerImpl$Storage;)Lcom/avito/android/lib/util/DarkThemeManager;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/lib/util/DarkThemeConfig;", "provideDarkThemeConfig", "(Lcom/avito/android/Features;)Lcom/avito/android/lib/util/DarkThemeConfig;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DarkThemeModule {
    @NotNull
    public static final DarkThemeModule INSTANCE = new DarkThemeModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final DarkThemeConfig provideDarkThemeConfig(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return new DarkThemeConfig(features) { // from class: com.avito.android.di.module.DarkThemeModule$provideDarkThemeConfig$1
            public final /* synthetic */ Features a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.util.DarkThemeConfig
            public boolean isEnabled() {
                return this.a.getDarkTheme().invoke().booleanValue();
            }
        };
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final DarkThemeManager provideDarkThemeManager(@NotNull DarkThemeManagerImpl.Storage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return new DarkThemeManagerImpl(storage);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final DarkThemeManagerImpl.Storage provideDarkThemeStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "prefs");
        return new DarkThemeManagerImpl.Storage(preferences) { // from class: com.avito.android.di.module.DarkThemeModule$provideDarkThemeStorage$1
            public final /* synthetic */ Preferences a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.lib.util.DarkThemeManagerImpl.Storage
            public int get(int i) {
                return this.a.getInt("com.avito.android.lib.design.DarkThemeState", i);
            }

            @Override // com.avito.android.lib.util.DarkThemeManagerImpl.Storage
            public void put(int i) {
                this.a.putInt("com.avito.android.lib.design.DarkThemeState", i);
            }
        };
    }
}
