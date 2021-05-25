package com.avito.android.vas_performance.di.visual;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemBlueprint;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenter;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItemPresenterImpl;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VasListModuleNew;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideHeaderPresenter", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "Declarations", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, AttributedTextFormatterModule.class, Declarations.class})
public final class VasListModuleNew {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/vas_performance/di/visual/VasListModuleNew$Declarations;", "", "Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "provideVasPresenter", "(Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemBlueprint;", "itemBlueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideVasBlueprint", "(Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideTitlePresenter", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemPresenterImpl;", "providVasItemPresenterImpl", "(Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemPresenterImpl;)Lcom/avito/android/vas_performance/ui/items/visual/VisualVasItemPresenter;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        VisualVasItemPresenter providVasItemPresenterImpl(@NotNull VisualVasItemPresenterImpl visualVasItemPresenterImpl);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideTitlePresenter(@NotNull PaidServiceHeaderItemPresenter paidServiceHeaderItemPresenter);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemBlueprint<?, ?> provideVasBlueprint(@NotNull VisualVasItemBlueprint visualVasItemBlueprint);

        @Binds
        @IntoSet
        @NotNull
        @PerFragment
        ItemPresenter<?, ?> provideVasPresenter(@NotNull VisualVasItemPresenter visualVasItemPresenter);
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
