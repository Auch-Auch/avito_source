package com.avito.android.short_term_rent.di.module;

import com.avito.android.di.PerActivity;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModel;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationViewModelFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/short_term_rent/di/module/HotelsFiltersLocationModule;", "", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModelFactory;", "viewModelFactory", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "provideLocationViewModel$short_term_rent_release", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModelFactory;)Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationViewModel;", "provideLocationViewModel", "<init>", "()V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class HotelsFiltersLocationModule {
    @NotNull
    public static final HotelsFiltersLocationModule INSTANCE = new HotelsFiltersLocationModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final HotelsLocationViewModel provideLocationViewModel$short_term_rent_release(@NotNull HotelsLocationViewModelFactory hotelsLocationViewModelFactory) {
        Intrinsics.checkNotNullParameter(hotelsLocationViewModelFactory, "viewModelFactory");
        return (HotelsLocationViewModel) hotelsLocationViewModelFactory.create(HotelsLocationViewModel.class);
    }
}
