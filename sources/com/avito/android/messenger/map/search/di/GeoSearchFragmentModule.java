package com.avito.android.messenger.map.search.di;

import a2.b.a.a.a;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.messenger.channels.mvi.di.ViewModelFactory;
import com.avito.android.messenger.map.search.GeoSearchFragment;
import com.avito.android.messenger.map.search.GeoSearchInteractor;
import com.avito.android.messenger.map.search.GeoSearchInteractorImpl;
import com.avito.android.messenger.map.search.GeoSearchPresenter;
import com.avito.android.messenger.map.search.GeoSearchPresenterImpl;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemBlueprint;
import com.avito.android.messenger.map.search.adapter.GeoSearchSuggestItemPresenter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0016\u0010!\u001a\u00020\u001b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001d¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentModule;", "", "Lcom/avito/android/messenger/map/search/GeoSearchFragment;", "fragment", "Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;", "viewModelFactory", "Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "provideGeoSearchInteractor", "(Lcom/avito/android/messenger/map/search/GeoSearchFragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/map/search/GeoSearchInteractor;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "provideGeoSearchPresenter", "(Lcom/avito/android/messenger/map/search/GeoSearchFragment;Lcom/avito/android/messenger/channels/mvi/di/ViewModelFactory;)Lcom/avito/android/messenger/map/search/GeoSearchPresenter;", "presenter", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemPresenter;", "provideGeoSearchSuggestItemPresenter", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenter;)Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemPresenter;", "Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemBlueprint;", "provideGeoSearchSuggestItemBlueprint", "(Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemPresenter;)Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemBlueprint;", "geoSearchSuggestItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/messenger/map/search/adapter/GeoSearchSuggestItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "", "CENTER_POINT", "Ljava/lang/String;", "ERROR_INDICATOR_MESSAGE", "ITEM_LOCATION", "CHANNEL_ID", "ERROR_INDICATOR_ACTION_NAME", "<init>", "()V", "Declarations", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class GeoSearchFragmentModule {
    @NotNull
    public static final String CENTER_POINT = "center_point";
    @NotNull
    public static final String CHANNEL_ID = "channel_id";
    @NotNull
    public static final String ERROR_INDICATOR_ACTION_NAME = "error_indicator_action_name";
    @NotNull
    public static final String ERROR_INDICATOR_MESSAGE = "error_indicator_message";
    @NotNull
    public static final GeoSearchFragmentModule INSTANCE = new GeoSearchFragmentModule();
    @NotNull
    public static final String ITEM_LOCATION = "item_location";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/map/search/di/GeoSearchFragmentModule$Declarations;", "", "Lcom/avito/android/messenger/map/search/GeoSearchInteractorImpl;", "impl", "Landroidx/lifecycle/ViewModel;", "bindGeoSearchInteractorViewModel", "(Lcom/avito/android/messenger/map/search/GeoSearchInteractorImpl;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/messenger/map/search/GeoSearchPresenterImpl;", "bindGeoSearchPresenterViewModel", "(Lcom/avito/android/messenger/map/search/GeoSearchPresenterImpl;)Landroidx/lifecycle/ViewModel;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @ClassKey(GeoSearchInteractorImpl.class)
        @IntoMap
        ViewModel bindGeoSearchInteractorViewModel(@NotNull GeoSearchInteractorImpl geoSearchInteractorImpl);

        @Binds
        @NotNull
        @ClassKey(GeoSearchPresenterImpl.class)
        @IntoMap
        ViewModel bindGeoSearchPresenterViewModel(@NotNull GeoSearchPresenterImpl geoSearchPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final AdapterPresenter provideAdapterPresenter(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final GeoSearchInteractor provideGeoSearchInteractor(@NotNull GeoSearchFragment geoSearchFragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(geoSearchFragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(geoSearchFragment, viewModelFactory).get(GeoSearchInteractorImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (GeoSearchInteractor) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final GeoSearchPresenter provideGeoSearchPresenter(@NotNull GeoSearchFragment geoSearchFragment, @NotNull ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(geoSearchFragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModelFactory, "viewModelFactory");
        ViewModel viewModel = new ViewModelProvider(geoSearchFragment, viewModelFactory).get(GeoSearchPresenterImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, …ctory).get(T::class.java)");
        return (GeoSearchPresenter) viewModel;
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final GeoSearchSuggestItemBlueprint provideGeoSearchSuggestItemBlueprint(@NotNull GeoSearchSuggestItemPresenter geoSearchSuggestItemPresenter) {
        Intrinsics.checkNotNullParameter(geoSearchSuggestItemPresenter, "presenter");
        return new GeoSearchSuggestItemBlueprint(geoSearchSuggestItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final GeoSearchSuggestItemPresenter provideGeoSearchSuggestItemPresenter(@NotNull GeoSearchPresenter geoSearchPresenter) {
        Intrinsics.checkNotNullParameter(geoSearchPresenter, "presenter");
        return new GeoSearchSuggestItemPresenter(geoSearchPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final ItemBinder provideItemBinder(@NotNull GeoSearchSuggestItemBlueprint geoSearchSuggestItemBlueprint) {
        Intrinsics.checkNotNullParameter(geoSearchSuggestItemBlueprint, "geoSearchSuggestItemBlueprint");
        return new ItemBinder.Builder().registerItem(geoSearchSuggestItemBlueprint).build();
    }
}
