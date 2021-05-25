package com.avito.android.short_term_rent.di.component;

import com.avito.android.di.PerActivity;
import com.avito.android.short_term_rent.di.module.HotelsModule;
import com.avito.android.short_term_rent.hotels.HotelsActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/HotelsComponent;", "", "Lcom/avito/android/short_term_rent/hotels/HotelsActivity;", "activity", "", "inject", "(Lcom/avito/android/short_term_rent/hotels/HotelsActivity;)V", "Builder", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {HotelsDependencies.class}, modules = {HotelsModule.class})
@PerActivity
public interface HotelsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/short_term_rent/di/component/HotelsComponent$Builder;", "", "Lcom/avito/android/short_term_rent/di/component/HotelsDependencies;", "dependencies", "hotelsDependencies", "(Lcom/avito/android/short_term_rent/di/component/HotelsDependencies;)Lcom/avito/android/short_term_rent/di/component/HotelsComponent$Builder;", "", "marker", "withMarker", "(Ljava/lang/String;)Lcom/avito/android/short_term_rent/di/component/HotelsComponent$Builder;", "Lcom/avito/android/short_term_rent/di/component/HotelsComponent;", "build", "()Lcom/avito/android/short_term_rent/di/component/HotelsComponent;", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        HotelsComponent build();

        @NotNull
        Builder hotelsDependencies(@NotNull HotelsDependencies hotelsDependencies);

        @BindsInstance
        @NotNull
        Builder withMarker(@Nullable String str);
    }

    void inject(@NotNull HotelsActivity hotelsActivity);
}
