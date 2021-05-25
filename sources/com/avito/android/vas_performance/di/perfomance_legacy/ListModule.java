package com.avito.android.vas_performance.di.perfomance_legacy;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemBlueprint;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenter;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItemPresenterImpl;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemBlueprint;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenter;
import com.avito.android.vas_performance.ui.items.tabs.TabsItemPresenterImpl;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasBlueprint;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenter;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance_legacy/ListModule;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideHeaderPresenter", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, AttributedTextFormatterModule.class})
public final class ListModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0010H'¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\r\u001a\u00020\u0013H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\r\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020 H'¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020#H'¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/vas_performance/di/perfomance_legacy/ListModule$Declarations;", "", "Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemPresenter;", "tabsItemPresenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTabsPresenter", "(Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideTabsBlueprint", "(Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasItemPresenter;", "presenter", "provideVasPerformancePresenter", "(Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasBlueprint;", "provideVasPerformanceBlueprint", "(Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenter;", "provideInfoActionPresenter", "(Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemBlueprint;", "provideInfoActionBlueprint", "(Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemPresenterImpl;", "tabsItemPresenterImpl", "provideTabsPresenterImpl", "(Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemPresenterImpl;)Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasItemPresenterImpl;", "providVasItemPresenterImpl", "(Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasItemPresenterImpl;)Lcom/avito/android/vas_performance/ui/items/vas/PerformanceVasItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenterImpl;", "provideInfoActionPresenterImpl", "(Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenterImpl;)Lcom/avito/android/vas_performance/ui/items/info_action/InfoActionItemPresenter;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        PerformanceVasItemPresenter providVasItemPresenterImpl(@NotNull PerformanceVasItemPresenterImpl performanceVasItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideInfoActionBlueprint(@NotNull InfoActionItemBlueprint infoActionItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideInfoActionPresenter(@NotNull InfoActionItemPresenter infoActionItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        InfoActionItemPresenter provideInfoActionPresenterImpl(@NotNull InfoActionItemPresenterImpl infoActionItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideTabsBlueprint(@NotNull TabsItemBlueprint tabsItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTabsPresenter(@NotNull TabsItemPresenter tabsItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        TabsItemPresenter provideTabsPresenterImpl(@NotNull TabsItemPresenterImpl tabsItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideVasPerformanceBlueprint(@NotNull PerformanceVasBlueprint performanceVasBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideVasPerformancePresenter(@NotNull PerformanceVasItemPresenter performanceVasItemPresenter);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerFragment
    public final ItemBlueprint<?, ?> provideHeaderBlueprint(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        Intrinsics.checkNotNullParameter(paidServiceHeaderItemPresenter, "presenter");
        return new PaidServiceHeaderBlueprint(paidServiceHeaderItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PaidServiceHeaderItemPresenter provideHeaderPresenter() {
        return new PaidServiceHeaderItemPresenter();
    }
}
