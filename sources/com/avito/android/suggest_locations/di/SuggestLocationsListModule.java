package com.avito.android.suggest_locations.di;

import com.avito.android.di.module.AbTestGroupModule;
import com.avito.android.suggest_locations.SuggestLocationsInteractor;
import com.avito.android.suggest_locations.SuggestLocationsInteractorImpl;
import com.avito.android.suggest_locations.SuggestLocationsItemConverterImpl;
import com.avito.android.suggest_locations.SuggestLocationsItemsConverter;
import com.avito.android.suggest_locations.SuggestLocationsPresenter;
import com.avito.android.suggest_locations.SuggestLocationsPresenterImpl;
import com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractor;
import com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/suggest_locations/di/SuggestLocationsListModule;", "", "<init>", "()V", "Declarations", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AbTestGroupModule.class})
public final class SuggestLocationsListModule {
    @NotNull
    public static final SuggestLocationsListModule INSTANCE = new SuggestLocationsListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/suggest_locations/di/SuggestLocationsListModule$Declarations;", "", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenterImpl;", "presenter", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "bindSuggestLocationsPresenter", "(Lcom/avito/android/suggest_locations/SuggestLocationsPresenterImpl;)Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "Lcom/avito/android/suggest_locations/SuggestLocationsInteractorImpl;", "interactor", "Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "bindSuggestLocationsInteractor", "(Lcom/avito/android/suggest_locations/SuggestLocationsInteractorImpl;)Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "Lcom/avito/android/suggest_locations/SuggestLocationsItemConverterImpl;", "converter", "Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "bindSuggestLocationsConverter", "(Lcom/avito/android/suggest_locations/SuggestLocationsItemConverterImpl;)Lcom/avito/android/suggest_locations/SuggestLocationsItemsConverter;", "Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractorImpl;", "Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "bindSuggestLocationsAnalyticsInteractor", "(Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractorImpl;)Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        SuggestLocationsAnalyticsInteractor bindSuggestLocationsAnalyticsInteractor(@NotNull SuggestLocationsAnalyticsInteractorImpl suggestLocationsAnalyticsInteractorImpl);

        @Binds
        @NotNull
        SuggestLocationsItemsConverter bindSuggestLocationsConverter(@NotNull SuggestLocationsItemConverterImpl suggestLocationsItemConverterImpl);

        @Binds
        @NotNull
        SuggestLocationsInteractor bindSuggestLocationsInteractor(@NotNull SuggestLocationsInteractorImpl suggestLocationsInteractorImpl);

        @Binds
        @NotNull
        SuggestLocationsPresenter bindSuggestLocationsPresenter(@NotNull SuggestLocationsPresenterImpl suggestLocationsPresenterImpl);
    }
}
