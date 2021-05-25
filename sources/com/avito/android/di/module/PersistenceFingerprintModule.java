package com.avito.android.di.module;

import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.preferences.PrefFingerprintStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/PersistenceFingerprintModule;", "", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/preferences/FingerprintStorage;", "provideFingerprintStorage", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/preferences/FingerprintStorage;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PersistenceFingerprintModule {
    @Provides
    @NotNull
    public final FingerprintStorage provideFingerprintStorage(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new PrefFingerprintStorage(preferences);
    }
}
