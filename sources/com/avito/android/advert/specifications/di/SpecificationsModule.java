package com.avito.android.advert.specifications.di;

import com.avito.android.advert.specifications.SpecificationsPresenter;
import com.avito.android.advert.specifications.SpecificationsPresenterImpl;
import com.avito.android.advert_core.specifications.SpecificationsConverter;
import com.avito.android.advert_core.specifications.SpecificationsConverterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.serp.adapter.LayoutTypeProviderImpl;
import com.avito.android.util.DeviceMetrics;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/specifications/di/SpecificationsModule;", "", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "provideLayoutTypeProvider", "(Lcom/avito/android/util/DeviceMetrics;)Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "<init>", "()V", "Dependencies", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class SpecificationsModule {
    @NotNull
    public static final SpecificationsModule INSTANCE = new SpecificationsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/advert/specifications/di/SpecificationsModule$Dependencies;", "", "Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;", "converter", "Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "bindsSpecificationsConverter", "(Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;)Lcom/avito/android/advert_core/specifications/SpecificationsConverter;", "Lcom/avito/android/advert/specifications/SpecificationsPresenterImpl;", "presenter", "Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "bindsPresenter", "(Lcom/avito/android/advert/specifications/SpecificationsPresenterImpl;)Lcom/avito/android/advert/specifications/SpecificationsPresenter;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        SpecificationsPresenter bindsPresenter(@NotNull SpecificationsPresenterImpl specificationsPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SpecificationsConverter bindsSpecificationsConverter(@NotNull SpecificationsConverterImpl specificationsConverterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final LayoutTypeProvider provideLayoutTypeProvider(@NotNull DeviceMetrics deviceMetrics) {
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        return new LayoutTypeProviderImpl(deviceMetrics);
    }
}
