package com.avito.android.enabler.di;

import android.content.Context;
import com.avito.android.enabler.CachedTogglesStorage;
import com.avito.android.enabler.PreferencesTogglesCache;
import com.avito.android.enabler.TogglesStorage;
import com.avito.android.util.BuildInfo;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/enabler/di/FeaturesEnablerModule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/enabler/TogglesStorage;", "provideTogglesStorage", "(Landroid/content/Context;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/enabler/TogglesStorage;", "<init>", "()V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FeaturesEnablerModule {
    @NotNull
    public static final FeaturesEnablerModule INSTANCE = new FeaturesEnablerModule();

    private FeaturesEnablerModule() {
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final TogglesStorage provideTogglesStorage(@NotNull Context context, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new CachedTogglesStorage(new PreferencesTogglesCache(context), buildInfo.getVersionCode());
    }
}
