package com.avito.android.messenger.map.search.di;

import com.avito.android.messenger.map.search.GeoSearchFragment;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
@Component(dependencies = {GeoSearchFragmentDependencies.class}, modules = {GeoSearchFragmentModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent;", "", "Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/map/search/GeoSearchFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface GeoSearchFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\f\u001a\u00020\u00002\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00002\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u0006H'¢\u0006\u0004\b\u0011\u0010\tJ\u0019\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u0006H'¢\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "", "Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "fragment", "bindFragment", "(Lcom/avito/android/messenger/map/search/GeoSearchFragment;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "", "channelId", "bindChannelId", "(Ljava/lang/String;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "bindCenterPoint", "(Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "itemLocation", "bindItemLocation", "message", "bindErrorIndicatorMessage", "name", "bindErrorIndicatorActionName", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;", "defaultState", "bindDefaultState", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter$State;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentDependencies;", "dependencies", "(Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentDependencies;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentModule;", BaseAnalyticKt.ANALYTIC_FAIL_MODULE, "(Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentModule;)Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent;", "build", "()Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindCenterPoint(@Named("center_point") @Nullable GeoPoint geoPoint);

        @BindsInstance
        @NotNull
        Builder bindChannelId(@Named("channel_id") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder bindDefaultState(@NotNull GeoSearchPresenter.State state);

        @BindsInstance
        @NotNull
        Builder bindErrorIndicatorActionName(@Named("error_indicator_action_name") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder bindErrorIndicatorMessage(@Named("error_indicator_message") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder bindFragment(@NotNull GeoSearchFragment geoSearchFragment);

        @BindsInstance
        @NotNull
        Builder bindItemLocation(@Named("item_location") @Nullable GeoPoint geoPoint);

        @NotNull
        GeoSearchFragmentComponent build();

        @NotNull
        Builder dependencies(@NotNull GeoSearchFragmentDependencies geoSearchFragmentDependencies);

        @NotNull
        Builder module(@NotNull GeoSearchFragmentModule geoSearchFragmentModule);
    }

    void inject(@NotNull GeoSearchFragment geoSearchFragment);
}
