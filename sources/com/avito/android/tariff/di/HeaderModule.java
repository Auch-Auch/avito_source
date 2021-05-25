package com.avito.android.tariff.di;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderBlueprint;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.di.PerFragment;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/tariff/di/HeaderModule;", "", "Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "provideHeaderPresenter", "()Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHeaderBlueprint", "(Lcom/avito/android/conveyor_shared_item/paid_services/PaidServiceHeaderItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "<init>", "()V", "tariff_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class HeaderModule {
    @NotNull
    public static final HeaderModule INSTANCE = new HeaderModule();

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
