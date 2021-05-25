package com.avito.android.short_term_rent.di.component;

import com.avito.android.di.PerActivity;
import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.di.module.HotelsFiltersLocationModule;
import com.avito.android.short_term_rent.di.module.HotelsModule;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialog;
import dagger.BindsInstance;
import dagger.Component;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent;", "", "Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialog;", "dialog", "", "inject", "(Lcom/avito/android/short_term_rent/hotels/dialogs/location/HotelsLocationDialog;)V", "Builder", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HotelsDependencies.class}, modules = {HotelsFiltersLocationModule.class, HotelsModule.class})
@PerActivity
public interface HotelsFilterLocationComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent$Builder;", "", "", "Lcom/avito/android/remote/model/hotels/HotelsLocation;", "locations", "bindDefaultLocations", "(Ljava/util/List;)Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent$Builder;", "Lcom/avito/android/short_term_rent/di/component/HotelsDependencies;", "dependencies", "(Lcom/avito/android/short_term_rent/di/component/HotelsDependencies;)Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent$Builder;", "Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent;", "build", "()Lcom/avito/android/short_term_rent/di/component/HotelsFilterLocationComponent;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindDefaultLocations(@NotNull List<HotelsLocation> list);

        @NotNull
        HotelsFilterLocationComponent build();

        @NotNull
        Builder dependencies(@NotNull HotelsDependencies hotelsDependencies);
    }

    void inject(@NotNull HotelsLocationDialog hotelsLocationDialog);
}
