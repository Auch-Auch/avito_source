package com.avito.android.search.map.di;

import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.PersistedSerpModule;
import com.avito.android.search.map.SearchMapState;
import com.avito.android.search.map.interactor.SerpCacheInteractor;
import com.avito.android.search.map.interactor.SerpCacheInteractorImpl;
import com.avito.android.search.map.interactor.SerpInteractor;
import com.avito.android.search.map.interactor.SerpInteractorImpl;
import com.avito.android.search.map.interactor.SerpKey;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.adapter.SerpItemSaturator;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/search/map/di/SerpInteractorModule;", "", "Lcom/avito/android/serp/SerpItemProcessor;", "itemProcessor", "Lcom/avito/android/serp/adapter/SerpItemSaturator;", "saturator", "Lcom/avito/android/search/map/SearchMapState;", "searchMapState", "Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "provideCacheInteractor", "(Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/serp/adapter/SerpItemSaturator;Lcom/avito/android/search/map/SearchMapState;)Lcom/avito/android/search/map/interactor/SerpCacheInteractor;", "<init>", "()V", "Declarations", "map_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CommercialBannersInteractorModule.class, PersistedSerpModule.class, ClosedItemModule.class, Declarations.class})
public final class SerpInteractorModule {
    @NotNull
    public static final SerpInteractorModule INSTANCE = new SerpInteractorModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/search/map/di/SerpInteractorModule$Declarations;", "", "Lcom/avito/android/search/map/interactor/SerpInteractorImpl;", "interactor", "Lcom/avito/android/search/map/interactor/SerpInteractor;", "bindSerpInteractor", "(Lcom/avito/android/search/map/interactor/SerpInteractorImpl;)Lcom/avito/android/search/map/interactor/SerpInteractor;", "map_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        SerpInteractor bindSerpInteractor(@NotNull SerpInteractorImpl serpInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SerpCacheInteractor provideCacheInteractor(@SerpList @NotNull SerpItemProcessor serpItemProcessor, @NotNull SerpItemSaturator serpItemSaturator, @Nullable SearchMapState searchMapState) {
        SearchMapState.SerpState serpState;
        SearchMapState.SerpState serpState2;
        SearchMapState.SerpState serpState3;
        SerpKey key;
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemProcessor");
        Intrinsics.checkNotNullParameter(serpItemSaturator, "saturator");
        return new SerpCacheInteractorImpl(serpItemProcessor, serpItemSaturator, (searchMapState == null || (serpState3 = searchMapState.getSerpState()) == null || (key = serpState3.getKey()) == null) ? null : key.getId(), (searchMapState == null || (serpState2 = searchMapState.getSerpState()) == null) ? null : serpState2.getDataSources(), (searchMapState == null || (serpState = searchMapState.getSerpState()) == null) ? null : serpState.getSubscriptionId());
    }
}
