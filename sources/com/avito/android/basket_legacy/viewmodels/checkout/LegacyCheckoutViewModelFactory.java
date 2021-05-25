package com.avito.android.basket_legacy.viewmodels.checkout;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.DisclaimerProvider;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverter;
import com.avito.android.basket_legacy.utils.PriceCalculator;
import com.avito.android.basket_legacy.utils.StringProvider;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverter;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u00103\u001a\u00020\u0014\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\b<\u0010=J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0016R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/avito/android/basket_legacy/viewmodels/checkout/LegacyCheckoutViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "f", "Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;", "vasConverter", "Lcom/avito/android/Features;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/ActivityIntentFactory;", "i", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "c", "openedFrom", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "j", "Lcom/avito/android/basket_legacy/utils/PriceCalculator;", "priceCalculator", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "k", "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "h", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/util/SchedulersFactory;", "n", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "e", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "l", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "disclaimerProvider", AuthSource.BOOKING_ORDER, "vasContext", "", "d", "Z", "lfRequired", "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", g.a, "Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;", "feesConverter", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/basket_legacy/repositories/BasketRepository;Lcom/avito/android/basket_legacy/utils/VasToBasketItemConverter;Lcom/avito/android/basket_legacy/utils/FeesToBasketItemConverter;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/basket_legacy/utils/PriceCalculator;Lcom/avito/android/basket_legacy/utils/StringProvider;Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;Lcom/avito/android/Features;Lcom/avito/android/util/SchedulersFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyCheckoutViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final BasketRepository e;
    public final VasToBasketItemConverter f;
    public final FeesToBasketItemConverter g;
    public final DeepLinkIntentFactory h;
    public final ActivityIntentFactory i;
    public final PriceCalculator j;
    public final StringProvider k;
    public final DisclaimerProvider l;
    public final Features m;
    public final SchedulersFactory n;

    public LegacyCheckoutViewModelFactory(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z, @NotNull BasketRepository basketRepository, @NotNull VasToBasketItemConverter vasToBasketItemConverter, @NotNull FeesToBasketItemConverter feesToBasketItemConverter, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull PriceCalculator priceCalculator, @NotNull StringProvider stringProvider, @NotNull DisclaimerProvider disclaimerProvider, @NotNull Features features, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "vasContext");
        Intrinsics.checkNotNullParameter(basketRepository, "basketRepository");
        Intrinsics.checkNotNullParameter(vasToBasketItemConverter, "vasConverter");
        Intrinsics.checkNotNullParameter(feesToBasketItemConverter, "feesConverter");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(priceCalculator, "priceCalculator");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(disclaimerProvider, "disclaimerProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
        this.e = basketRepository;
        this.f = vasToBasketItemConverter;
        this.g = feesToBasketItemConverter;
        this.h = deepLinkIntentFactory;
        this.i = activityIntentFactory;
        this.j = priceCalculator;
        this.k = stringProvider;
        this.l = disclaimerProvider;
        this.m = features;
        this.n = schedulersFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(CheckoutViewModelImpl.class)) {
            return new CheckoutViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
