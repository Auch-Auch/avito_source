package com.avito.android.settings.di;

import a2.b.a.a.a;
import com.avito.android.di.PerFragment;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.settings.SettingsPresenter;
import com.avito.android.settings.SettingsPresenterImpl;
import com.avito.android.settings.SettingsResourceProvider;
import com.avito.android.settings.SettingsResourceProviderImpl;
import com.avito.android.settings.adapter.CategorySettingsItemBlueprint;
import com.avito.android.settings.adapter.CategorySettingsItemPresenter;
import com.avito.android.settings.adapter.CategorySettingsItemPresenterImpl;
import com.avito.android.settings.adapter.DividerItemBlueprint;
import com.avito.android.settings.adapter.DividerItemPresenter;
import com.avito.android.settings.adapter.DividerItemPresenterImpl;
import com.avito.android.settings.adapter.InfoSettingsItemBlueprint;
import com.avito.android.settings.adapter.InfoSettingsItemPresenter;
import com.avito.android.settings.adapter.InfoSettingsItemPresenterImpl;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemBlueprint;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemPresenter;
import com.avito.android.settings.adapter.InfoSettingsWithProgressItemPresenterImpl;
import com.avito.android.settings.adapter.ListItemBlueprint;
import com.avito.android.settings.adapter.ListItemPresenter;
import com.avito.android.settings.adapter.ListItemPresenterImpl;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemBlueprint;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemPresenter;
import com.avito.android.settings.adapter.LogoWithVersionSettingsItemPresenterImpl;
import com.avito.android.settings.adapter.SelectSettingsItemBlueprint;
import com.avito.android.settings.adapter.SelectSettingsItemPresenter;
import com.avito.android.settings.adapter.SelectSettingsItemPresenterImpl;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.shared_providers.SupportEmailResourceProviderImpl;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0014\u001a\u00020\b2\u0019\u0010\u0011\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f¢\u0006\u0002\b\u00100\u000eH\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/settings/di/SettingsModule;", "", "Lcom/avito/android/util/BuildInfo;", "info", "", "provideAppVersionName$settings_release", "(Lcom/avito/android/util/BuildInfo;)Ljava/lang/String;", "provideAppVersionName", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter$settings_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$settings_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "<init>", "()V", "Declarations", "settings_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, Declarations.class})
public final class SettingsModule {
    @NotNull
    public static final SettingsModule INSTANCE = new SettingsModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\f\u001a\u00020 H'¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010\f\u001a\u00020$H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\f\u001a\u00020(H'¢\u0006\u0004\b*\u0010+J\u001f\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u00020,H'¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u000201H'¢\u0006\u0004\b2\u00103J\u001f\u00105\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u000204H'¢\u0006\u0004\b5\u00106J\u001f\u00108\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u000207H'¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u00020:H'¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u00020=H'¢\u0006\u0004\b>\u0010?J\u001f\u0010A\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u0010-\u001a\u00020@H'¢\u0006\u0004\bA\u0010BJ\u0017\u0010F\u001a\u00020E2\u0006\u0010D\u001a\u00020CH'¢\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001a\u00020I2\u0006\u0010D\u001a\u00020HH'¢\u0006\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Lcom/avito/android/settings/di/SettingsModule$Declarations;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/settings/SettingsPresenterImpl;", "presenter", "Lcom/avito/android/settings/SettingsPresenter;", "bindSettingsPresenter", "(Lcom/avito/android/settings/SettingsPresenterImpl;)Lcom/avito/android/settings/SettingsPresenter;", "Lcom/avito/android/settings/adapter/SelectSettingsItemPresenterImpl;", "Lcom/avito/android/settings/adapter/SelectSettingsItemPresenter;", "bindSelectSettingsItemPresenter", "(Lcom/avito/android/settings/adapter/SelectSettingsItemPresenterImpl;)Lcom/avito/android/settings/adapter/SelectSettingsItemPresenter;", "Lcom/avito/android/settings/adapter/ListItemPresenterImpl;", "Lcom/avito/android/settings/adapter/ListItemPresenter;", "bindListItemPresenter", "(Lcom/avito/android/settings/adapter/ListItemPresenterImpl;)Lcom/avito/android/settings/adapter/ListItemPresenter;", "Lcom/avito/android/settings/adapter/InfoSettingsItemPresenterImpl;", "Lcom/avito/android/settings/adapter/InfoSettingsItemPresenter;", "bindInfoSettingsItemPresenter", "(Lcom/avito/android/settings/adapter/InfoSettingsItemPresenterImpl;)Lcom/avito/android/settings/adapter/InfoSettingsItemPresenter;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenterImpl;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenter;", "bindLogoWithVersionSettingsItemPresenter", "(Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenterImpl;)Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenter;", "Lcom/avito/android/settings/adapter/DividerItemPresenterImpl;", "Lcom/avito/android/settings/adapter/DividerItemPresenter;", "bindSavedLocationInteractor", "(Lcom/avito/android/settings/adapter/DividerItemPresenterImpl;)Lcom/avito/android/settings/adapter/DividerItemPresenter;", "Lcom/avito/android/settings/adapter/CategorySettingsItemPresenterImpl;", "Lcom/avito/android/settings/adapter/CategorySettingsItemPresenter;", "bindCategorySettingsItemPresenter", "(Lcom/avito/android/settings/adapter/CategorySettingsItemPresenterImpl;)Lcom/avito/android/settings/adapter/CategorySettingsItemPresenter;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenterImpl;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenter;", "bindInfoSettingsWithProgressItemPresenter", "(Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenterImpl;)Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenter;", "Lcom/avito/android/settings/adapter/DividerItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindDividerItemBlueprint", "(Lcom/avito/android/settings/adapter/DividerItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/CategorySettingsItemBlueprint;", "bindCategorySettingsItemBlueprint", "(Lcom/avito/android/settings/adapter/CategorySettingsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemBlueprint;", "bindLogoWithVersionSettingsItemBlueprint", "(Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/InfoSettingsItemBlueprint;", "bindInfoSettingsItemBlueprint", "(Lcom/avito/android/settings/adapter/InfoSettingsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/SelectSettingsItemBlueprint;", "bindSelectSettingsItemBlueprint", "(Lcom/avito/android/settings/adapter/SelectSettingsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/ListItemBlueprint;", "bindListItemBlueprint", "(Lcom/avito/android/settings/adapter/ListItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemBlueprint;", "bindInfoSettingsWithProgressItemBlueprint", "(Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/settings/SettingsResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/settings/SettingsResourceProvider;", "bindSettingsResourceProvider", "(Lcom/avito/android/settings/SettingsResourceProviderImpl;)Lcom/avito/android/settings/SettingsResourceProvider;", "Lcom/avito/android/shared_providers/SupportEmailResourceProviderImpl;", "Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "bindSupportEmailResourceProvider", "(Lcom/avito/android/shared_providers/SupportEmailResourceProviderImpl;)Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "settings_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindCategorySettingsItemBlueprint(@NotNull CategorySettingsItemBlueprint categorySettingsItemBlueprint);

        @Binds
        @NotNull
        CategorySettingsItemPresenter bindCategorySettingsItemPresenter(@NotNull CategorySettingsItemPresenterImpl categorySettingsItemPresenterImpl);

        @Binds
        @NotNull
        Consumer<String> bindConsumer(@NotNull PublishRelay<String> publishRelay);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindDividerItemBlueprint(@NotNull DividerItemBlueprint dividerItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindInfoSettingsItemBlueprint(@NotNull InfoSettingsItemBlueprint infoSettingsItemBlueprint);

        @Binds
        @NotNull
        InfoSettingsItemPresenter bindInfoSettingsItemPresenter(@NotNull InfoSettingsItemPresenterImpl infoSettingsItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindInfoSettingsWithProgressItemBlueprint(@NotNull InfoSettingsWithProgressItemBlueprint infoSettingsWithProgressItemBlueprint);

        @Binds
        @NotNull
        InfoSettingsWithProgressItemPresenter bindInfoSettingsWithProgressItemPresenter(@NotNull InfoSettingsWithProgressItemPresenterImpl infoSettingsWithProgressItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindListItemBlueprint(@NotNull ListItemBlueprint listItemBlueprint);

        @Binds
        @NotNull
        ListItemPresenter bindListItemPresenter(@NotNull ListItemPresenterImpl listItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindLogoWithVersionSettingsItemBlueprint(@NotNull LogoWithVersionSettingsItemBlueprint logoWithVersionSettingsItemBlueprint);

        @Binds
        @NotNull
        LogoWithVersionSettingsItemPresenter bindLogoWithVersionSettingsItemPresenter(@NotNull LogoWithVersionSettingsItemPresenterImpl logoWithVersionSettingsItemPresenterImpl);

        @Binds
        @NotNull
        Observable<String> bindObservable(@NotNull PublishRelay<String> publishRelay);

        @Binds
        @NotNull
        DividerItemPresenter bindSavedLocationInteractor(@NotNull DividerItemPresenterImpl dividerItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        ItemBlueprint<?, ?> bindSelectSettingsItemBlueprint(@NotNull SelectSettingsItemBlueprint selectSettingsItemBlueprint);

        @Binds
        @NotNull
        SelectSettingsItemPresenter bindSelectSettingsItemPresenter(@NotNull SelectSettingsItemPresenterImpl selectSettingsItemPresenterImpl);

        @Binds
        @NotNull
        SettingsPresenter bindSettingsPresenter(@NotNull SettingsPresenterImpl settingsPresenterImpl);

        @Binds
        @NotNull
        SettingsResourceProvider bindSettingsResourceProvider(@NotNull SettingsResourceProviderImpl settingsResourceProviderImpl);

        @Binds
        @NotNull
        SupportEmailResourceProvider bindSupportEmailResourceProvider(@NotNull SupportEmailResourceProviderImpl supportEmailResourceProviderImpl);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$settings_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }

    @Provides
    @NotNull
    public final String provideAppVersionName$settings_release(@NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(buildInfo, "info");
        return buildInfo.getVersionName();
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder$settings_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }
}
