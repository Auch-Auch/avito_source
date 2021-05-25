package com.avito.android.analytics.di;

import android.app.Application;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorageImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.util.preferences.Names;
import com.avito.android.util.preferences.PreferenceFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/analytics/di/BivrostStatisticsModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/util/preferences/PreferenceFactory;", "factory", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "provideBivrostStorage", "(Landroid/app/Application;Lcom/avito/android/util/preferences/PreferenceFactory;)Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BivrostStatisticsModule {
    @NotNull
    public static final BivrostStatisticsModule INSTANCE = new BivrostStatisticsModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final BivrostTutorialSessionStorage provideBivrostStorage(@NotNull Application application, @NotNull PreferenceFactory preferenceFactory) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(preferenceFactory, "factory");
        return new BivrostTutorialSessionStorageImpl(preferenceFactory.getCustomPreferences(application, Names.BIVROST_STATISTICS));
    }
}
