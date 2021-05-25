package com.avito.android.bundles.vas_union.di;

import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionBlueprint;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionPresenter;
import com.avito.android.bundles.vas_union.item.performance.description.PerformanceDescriptionPresenterImpl;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemBlueprint;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.info_action.InfoActionItemPresenterImpl;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemBlueprint;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.tabs.PerformanceTabsItemPresenterImpl;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasBlueprint;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemPresenter;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemPresenterImpl;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/bundles/vas_union/di/VasPerformanceListModule;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideHeaderPresenter", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "Declarations", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class, AttributedTextFormatterModule.class})
public final class VasPerformanceListModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0016H'¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0013\u001a\u00020\u0019H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u001cH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\"H'¢\u0006\u0004\b#\u0010$J\u001f\u0010&\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020%H'¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020)2\u0006\u0010\b\u001a\u00020(H'¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/avito/android/bundles/vas_union/di/VasPerformanceListModule$Declarations;", "", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindPerformanceTabsBlueprint", "(Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "providePerformanceTabsPresenter", "(Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenterImpl;", "bindPerformanceTabsPresenter", "(Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenter;", "provideVasPerformancePresenter", "(Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasBlueprint;", "itemBlueprint", "provideVasPerformanceBlueprint", "(Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemPresenter;", "provideInfoActionPresenter", "(Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemBlueprint;", "provideInfoActionBlueprint", "(Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenterImpl;", "providVasItemPresenterImpl", "(Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemPresenterImpl;", "provideInfoActionPresenterImpl", "(Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/performance/info_action/InfoActionItemPresenter;", "Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionBlueprint;", "bindPerformanceDescriptionBlueprint", "(Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionPresenterImpl;", "Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionPresenter;", "bindPerformanceDescriptionPresenter", "(Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionPresenterImpl;)Lcom/avito/android/bundles/vas_union/item/performance/description/PerformanceDescriptionPresenter;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindPerformanceDescriptionBlueprint(@NotNull PerformanceDescriptionBlueprint performanceDescriptionBlueprint);

        @PerFragment
        @Binds
        @NotNull
        PerformanceDescriptionPresenter bindPerformanceDescriptionPresenter(@NotNull PerformanceDescriptionPresenterImpl performanceDescriptionPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> bindPerformanceTabsBlueprint(@NotNull PerformanceTabsItemBlueprint performanceTabsItemBlueprint);

        @PerFragment
        @Binds
        @NotNull
        PerformanceTabsItemPresenter bindPerformanceTabsPresenter(@NotNull PerformanceTabsItemPresenterImpl performanceTabsItemPresenterImpl);

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
        ItemPresenter<?, ?> providePerformanceTabsPresenter(@NotNull PerformanceTabsItemPresenter performanceTabsItemPresenter);

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
