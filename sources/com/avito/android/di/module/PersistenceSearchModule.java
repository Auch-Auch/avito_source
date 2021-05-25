package com.avito.android.di.module;

import com.avito.android.home.default_search_location.DefaultSearchLocationStorage;
import com.avito.android.home.default_search_location.DefaultSearchLocationStorageImpl;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/PersistenceSearchModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "provideDefaultSearchLocationStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/home/default_search_location/DefaultSearchLocationStorage;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PersistenceSearchModule {
    @NotNull
    public static final PersistenceSearchModule INSTANCE = new PersistenceSearchModule();

    @Provides
    @JvmStatic
    @NotNull
    public static final DefaultSearchLocationStorage provideDefaultSearchLocationStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new DefaultSearchLocationStorageImpl(preferences.getSharedPreferences());
    }
}
