package com.avito.android.search.map.di;

import com.avito.android.di.PerFragment;
import com.avito.android.search.map.interactor.ViewedPinsInteractor;
import com.avito.android.search.map.interactor.ViewedPinsInteractorImpl;
import com.avito.android.search.map.viewed_pins.ViewedPinsStorage;
import com.avito.android.search.map.viewed_pins.ViewedPinsStorageImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/search/map/di/ViewedPinsModule;", "", "Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorageImpl;", "storage", "Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorage;", "bindViewedPinsStorage", "(Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorageImpl;)Lcom/avito/android/search/map/viewed_pins/ViewedPinsStorage;", "Lcom/avito/android/search/map/interactor/ViewedPinsInteractorImpl;", "interactor", "Lcom/avito/android/search/map/interactor/ViewedPinsInteractor;", "provideViewedPinsInteractor", "(Lcom/avito/android/search/map/interactor/ViewedPinsInteractorImpl;)Lcom/avito/android/search/map/interactor/ViewedPinsInteractor;", "map_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ViewedPinsModule {
    @Binds
    @NotNull
    ViewedPinsStorage bindViewedPinsStorage(@NotNull ViewedPinsStorageImpl viewedPinsStorageImpl);

    @PerFragment
    @Binds
    @NotNull
    ViewedPinsInteractor provideViewedPinsInteractor(@NotNull ViewedPinsInteractorImpl viewedPinsInteractorImpl);
}
