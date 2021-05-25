package com.avito.android.suggest_locations.di;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerFragment;
import com.avito.android.suggest_locations.SuggestLocationsFragment;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent;", "", "Lcom/avito/android/suggest_locations/SuggestLocationsFragment;", "fragment", "", "inject", "(Lcom/avito/android/suggest_locations/SuggestLocationsFragment;)V", "Builder", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {SuggestLocationsDependencies.class}, modules = {SuggestLocationsListModule.class})
@PerFragment
public interface SuggestLocationsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00002\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0013\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00002\b\b\u0001\u0010\u0017\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00002\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u0018\u0010\u000eJ\u0019\u0010\u001a\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0014H'¢\u0006\u0004\b\u001a\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u00002\b\b\u0001\u0010\u0019\u001a\u00020\u0014H'¢\u0006\u0004\b\u001b\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "", "Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent;", "build", "()Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent;", "Lcom/avito/android/suggest_locations/di/SuggestLocationsDependencies;", "dependencies", "(Lcom/avito/android/suggest_locations/di/SuggestLocationsDependencies;)Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "savedState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "", "locationId", "(Ljava/lang/String;)Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "categoryId", "", BookingInfoActivity.EXTRA_FROM_BLOCK, "(I)Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "query", "", "showHistoricalSuggest", "(Z)Lcom/avito/android/suggest_locations/di/SuggestLocationsComponent$Builder;", "suggestAddress", "geoSessionId", "value", "autoOpenKeyboard", "useLegacyApi", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder autoOpenKeyboard(@AutoOpenKeyboard boolean z);

        @NotNull
        SuggestLocationsComponent build();

        @BindsInstance
        @NotNull
        Builder categoryId(@CategoryId @Nullable String str);

        @NotNull
        Builder dependencies(@NotNull SuggestLocationsDependencies suggestLocationsDependencies);

        @BindsInstance
        @NotNull
        Builder fromBlock(@OpenFromBlock int i);

        @BindsInstance
        @NotNull
        Builder geoSessionId(@GeoSessionId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder locationId(@LocationId @Nullable String str);

        @BindsInstance
        @NotNull
        Builder query(@AddressQuery @Nullable String str);

        @BindsInstance
        @NotNull
        Builder savedState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder showHistoricalSuggest(@HistoricalSuggest boolean z);

        @BindsInstance
        @NotNull
        Builder suggestAddress(@SuggestAddress boolean z);

        @BindsInstance
        @NotNull
        Builder useLegacyApi(@UseLegacyApi boolean z);
    }

    void inject(@NotNull SuggestLocationsFragment suggestLocationsFragment);
}
