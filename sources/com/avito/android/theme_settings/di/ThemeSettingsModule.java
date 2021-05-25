package com.avito.android.theme_settings.di;

import a2.b.a.a.a;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.serp.adapter.GridPositionProviderImpl;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SerpSpanProviderImpl;
import com.avito.android.serp.adapter.SpanLookup;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProvider;
import com.avito.android.theme_settings.utils.ThemeSettingsResourceProviderImpl;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsConverter;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsConverterImpl;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModel;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModelFactory;
import com.avito.android.theme_settings.viewmodel.ThemeSettingsViewModelImpl;
import com.avito.android.ui.adapter.AppendingListener;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/theme_settings/di/ThemeSettingsModule;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "provideViewModel", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "provideSimpleRecyclerAdapter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider$settings_release", "()Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "provideGridPositionProvider", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", GeoContract.PROVIDER, "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup$settings_release", "(Lcom/avito/android/serp/adapter/SerpSpanProvider;)Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "provideSpanLookup", "gridPositionProvider", "provideSpanProvider$settings_release", "(Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;)Lcom/avito/android/serp/adapter/SerpSpanProvider;", "provideSpanProvider", "<init>", "()V", "Declarations", "settings_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class ThemeSettingsModule {
    @NotNull
    public static final ThemeSettingsModule INSTANCE = new ThemeSettingsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/theme_settings/di/ThemeSettingsModule$Declarations;", "", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverterImpl;", "converter", "Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;", "provideConverter", "(Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverterImpl;)Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsConverter;", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "bindThemeSettingsResourceProvider", "(Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProviderImpl;)Lcom/avito/android/theme_settings/utils/ThemeSettingsResourceProvider;", "settings_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ThemeSettingsResourceProvider bindThemeSettingsResourceProvider(@NotNull ThemeSettingsResourceProviderImpl themeSettingsResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        ThemeSettingsConverter provideConverter(@NotNull ThemeSettingsConverterImpl themeSettingsConverterImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull ThemeSettingsViewModelFactory themeSettingsViewModelFactory);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SpannedGridPositionProvider provideGridPositionProvider$settings_release() {
        return new GridPositionProviderImpl(2);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SimpleRecyclerAdapter provideSimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        return a.E1(adapterPresenter, "adapterPresenter", itemBinder, "itemBinder", adapterPresenter, itemBinder);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final GridLayoutManager.SpanSizeLookup provideSpanLookup$settings_release(@NotNull SerpSpanProvider serpSpanProvider) {
        Intrinsics.checkNotNullParameter(serpSpanProvider, GeoContract.PROVIDER);
        return new SpanLookup(serpSpanProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final SerpSpanProvider provideSpanProvider$settings_release(@NotNull SpannedGridPositionProvider spannedGridPositionProvider) {
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        SerpSpanProviderImpl serpSpanProviderImpl = new SerpSpanProviderImpl(2, spannedGridPositionProvider);
        serpSpanProviderImpl.setAppendingListener(new AppendingListener() { // from class: com.avito.android.theme_settings.di.ThemeSettingsModule$provideSpanProvider$1$1
            @Override // com.avito.android.ui.adapter.AppendingListener
            public boolean canAppend() {
                return false;
            }

            @Override // com.avito.android.ui.adapter.AppendingListener
            public void onAppend() {
            }
        });
        return serpSpanProviderImpl;
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ThemeSettingsViewModel provideViewModel(@NotNull Fragment fragment, @NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(factory, "viewModelFactory");
        ViewModel viewModel = ViewModelProviders.of(fragment, factory).get(ThemeSettingsViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(fr…iewModelImpl::class.java)");
        return (ThemeSettingsViewModel) viewModel;
    }
}
