package com.avito.android.basket_legacy.di.shared;

import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.di.LfRequired;
import com.avito.android.basket_legacy.di.VasContext;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.PaidService;
import com.avito.android.basket_legacy.utils.VasType;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModel;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModelFactory;
import com.avito.android.basket_legacy.viewmodels.activity.BasketViewModelImpl;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModel;
import com.avito.android.basket_legacy.viewmodels.shared.SharedBasketViewModelFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.auth.AuthSource;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\u0006\u00101\u001a\u00020\u001b\u0012\u0006\u00103\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\u0018\u0012\u0006\u0010.\u001a\u00020\u0012\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001e\u0010\u001aJ\u000f\u0010 \u001a\u00020\u001fH\u0007¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010#¨\u00066"}, d2 = {"Lcom/avito/android/basket_legacy/di/shared/SharedModule;", "", "Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;", "factory", "Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModel;", "provideSharedViewModel", "(Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;)Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModel;", "provideFactory", "()Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModelFactory;", "Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModelFactory;", "fabric", "Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModel;", "provideBasketViewModel", "(Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModelFactory;)Lcom/avito/android/basket_legacy/viewmodels/activity/BasketViewModel;", "viewModel", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "provideBasketRepository", "(Lcom/avito/android/basket_legacy/viewmodels/shared/SharedBasketViewModel;)Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "Landroidx/fragment/app/FragmentActivity;", "provideActivity", "()Landroidx/fragment/app/FragmentActivity;", "Landroid/content/res/Resources;", "provideResources", "()Landroid/content/res/Resources;", "", "provideAdvertId", "()Ljava/lang/String;", "", "provideFeesParam", "()Z", "provideVasContext", "Lcom/avito/android/basket_legacy/utils/VasType;", "provideVasType", "()Lcom/avito/android/basket_legacy/utils/VasType;", "d", "Ljava/lang/String;", "vasType", "", "Lcom/avito/android/basket_legacy/utils/PaidService;", "f", "Ljava/util/List;", "state", AuthSource.SEND_ABUSE, BookingInfoActivity.EXTRA_ITEM_ID, "e", "Landroidx/fragment/app/FragmentActivity;", "activity", AuthSource.BOOKING_ORDER, "Z", "feesRequired", "c", "vasContext", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;Ljava/util/List;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {LegacyPaidServicesAnalyticsModule.class})
public final class SharedModule {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final FragmentActivity e;
    public final List<PaidService> f;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.avito.android.basket_legacy.utils.PaidService> */
    /* JADX WARN: Multi-variable type inference failed */
    public SharedModule(@NotNull String str, boolean z, @NotNull String str2, @NotNull String str3, @NotNull FragmentActivity fragmentActivity, @Nullable List<? extends PaidService> list) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "vasContext");
        Intrinsics.checkNotNullParameter(str3, "vasType");
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = str3;
        this.e = fragmentActivity;
        this.f = list;
    }

    @Provides
    @PerActivity
    @NotNull
    public final FragmentActivity provideActivity() {
        return this.e;
    }

    @Provides
    @AdvertId
    @NotNull
    @PerActivity
    public final String provideAdvertId() {
        return this.a;
    }

    @Provides
    @PerActivity
    @NotNull
    public final BasketRepository provideBasketRepository(@NotNull SharedBasketViewModel sharedBasketViewModel) {
        Intrinsics.checkNotNullParameter(sharedBasketViewModel, "viewModel");
        return sharedBasketViewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final BasketViewModel provideBasketViewModel(@NotNull BasketViewModelFactory basketViewModelFactory) {
        Intrinsics.checkNotNullParameter(basketViewModelFactory, "fabric");
        ViewModel viewModel = ViewModelProviders.of(this.e, basketViewModelFactory).get(BasketViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…iewModelImpl::class.java)");
        return (BasketViewModel) viewModel;
    }

    @Provides
    @PerActivity
    @NotNull
    public final SharedBasketViewModelFactory provideFactory() {
        return new SharedBasketViewModelFactory(this.f);
    }

    @LfRequired
    @Provides
    @PerActivity
    public final boolean provideFeesParam() {
        return this.b;
    }

    @Provides
    @PerActivity
    @NotNull
    public final Resources provideResources() {
        Resources resources = this.e.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return resources;
    }

    @Provides
    @PerActivity
    @NotNull
    public final SharedBasketViewModel provideSharedViewModel(@NotNull SharedBasketViewModelFactory sharedBasketViewModelFactory) {
        Intrinsics.checkNotNullParameter(sharedBasketViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.e, sharedBasketViewModelFactory).get(SharedBasketViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(ac…ketViewModel::class.java)");
        return (SharedBasketViewModel) viewModel;
    }

    @Provides
    @NotNull
    @VasContext
    @PerActivity
    public final String provideVasContext() {
        return this.c;
    }

    @Provides
    @PerActivity
    @NotNull
    public final VasType provideVasType() {
        return VasType.Companion.fromString(this.d);
    }
}
