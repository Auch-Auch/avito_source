package com.avito.android.bundles.di;

import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenter;
import com.avito.android.bundles.ui.recycler.item.benefit.BenefitItemPresenterImpl;
import com.avito.android.bundles.ui.recycler.item.benefit.BundleBenefitItemBlueprint;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleBlueprint;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenter;
import com.avito.android.bundles.ui.recycler.item.bundle.VasBundleItemPresenterImpl;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemBlueprint;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenter;
import com.avito.android.bundles.ui.recycler.item.skip_button.BundleSkipButtonItemPresenterImpl;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesListModule;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideHeaderPresenter", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "Declarations", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, Declarations.class})
public final class VasBundlesListModule {
    @NotNull
    public static final VasBundlesListModule INSTANCE = new VasBundlesListModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0012H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0018H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u001bH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u001eH'¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020!H'¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/bundles/di/VasBundlesListModule$Declarations;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideVasBundleBlueprint", "(Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;", "provideVasBundleItemPresenter", "(Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenterImpl;", "provideVasBundleItemPresenterImpl", "(Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenterImpl;)Lcom/avito/android/bundles/ui/recycler/item/bundle/VasBundleItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItemBlueprint;", "provideBundleBenefitItemBlueprint", "(Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenter;", "provideBundleBenefitItemPresenter", "(Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenterImpl;", "provideBundleBenefitItemPresenterImpl", "(Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenterImpl;)Lcom/avito/android/bundles/ui/recycler/item/benefit/BenefitItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemBlueprint;", "provideBundleSkipButtonItemBlueprint", "(Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenter;", "provideBundleSkipButtonItemPresenter", "(Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenterImpl;", "provideBundleSkipButtonItemPresenterImpl", "(Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenterImpl;)Lcom/avito/android/bundles/ui/recycler/item/skip_button/BundleSkipButtonItemPresenter;", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideBundleBenefitItemBlueprint(@NotNull BundleBenefitItemBlueprint bundleBenefitItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideBundleBenefitItemPresenter(@NotNull BenefitItemPresenter benefitItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        BenefitItemPresenter provideBundleBenefitItemPresenterImpl(@NotNull BenefitItemPresenterImpl benefitItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideBundleSkipButtonItemBlueprint(@NotNull BundleSkipButtonItemBlueprint bundleSkipButtonItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideBundleSkipButtonItemPresenter(@NotNull BundleSkipButtonItemPresenter bundleSkipButtonItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        BundleSkipButtonItemPresenter provideBundleSkipButtonItemPresenterImpl(@NotNull BundleSkipButtonItemPresenterImpl bundleSkipButtonItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideVasBundleBlueprint(@NotNull VasBundleBlueprint vasBundleBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideVasBundleItemPresenter(@NotNull VasBundleItemPresenter vasBundleItemPresenter);

        @PerFragment
        @Binds
        @NotNull
        VasBundleItemPresenter provideVasBundleItemPresenterImpl(@NotNull VasBundleItemPresenterImpl vasBundleItemPresenterImpl);
    }

    @Provides
    @JvmStatic
    @IntoSet
    @NotNull
    @PerFragment
    public static final ItemBlueprint<?, ?> provideHeaderBlueprint(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter) {
        Intrinsics.checkNotNullParameter(paidServiceHeaderItemPresenter, "presenter");
        return new PaidServiceHeaderBlueprint(paidServiceHeaderItemPresenter);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final PaidServiceHeaderItemPresenter provideHeaderPresenter() {
        return new PaidServiceHeaderItemPresenter();
    }
}
