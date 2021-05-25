package com.avito.android.basket.checkout.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.basket.checkout.utils.CheckoutCalculator;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b4\u00105J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "e", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/util/Kundle;", "j", "Lcom/avito/android/util/Kundle;", "savedState", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "c", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "converter", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "checkoutContext", "Lcom/avito/android/Features;", "k", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", g.a, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkFactory", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "h", "Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;", "checkoutCalculator", "Lcom/avito/android/tariff/StringProvider;", "f", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "d", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;", "commitConverter", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;", "repository", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "i", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "priceItemCreator", "<init>", "(Ljava/lang/String;Lcom/avito/android/basket/checkout/viewmodel/CheckoutRepository;Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;Lcom/avito/android/basket/checkout/viewmodel/CheckoutCommitConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/tariff/StringProvider;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/basket/checkout/utils/CheckoutCalculator;Lcom/avito/android/basket/checkout/utils/PriceItemCreator;Lcom/avito/android/util/Kundle;Lcom/avito/android/Features;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutViewModelFactory implements ViewModelProvider.Factory {
    public final String a;
    public final CheckoutRepository b;
    public final CheckoutConverter c;
    public final CheckoutCommitConverter d;
    public final SchedulersFactory e;
    public final StringProvider f;
    public final DeepLinkIntentFactory g;
    public final CheckoutCalculator h;
    public final PriceItemCreator i;
    public final Kundle j;
    public final Features k;

    @Inject
    public CheckoutViewModelFactory(@NotNull String str, @NotNull CheckoutRepository checkoutRepository, @NotNull CheckoutConverter checkoutConverter, @NotNull CheckoutCommitConverter checkoutCommitConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull StringProvider stringProvider, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull CheckoutCalculator checkoutCalculator, @NotNull PriceItemCreator priceItemCreator, @NotNull Kundle kundle, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, "checkoutContext");
        Intrinsics.checkNotNullParameter(checkoutRepository, "repository");
        Intrinsics.checkNotNullParameter(checkoutConverter, "converter");
        Intrinsics.checkNotNullParameter(checkoutCommitConverter, "commitConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(checkoutCalculator, "checkoutCalculator");
        Intrinsics.checkNotNullParameter(priceItemCreator, "priceItemCreator");
        Intrinsics.checkNotNullParameter(kundle, "savedState");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = str;
        this.b = checkoutRepository;
        this.c = checkoutConverter;
        this.d = checkoutCommitConverter;
        this.e = schedulersFactory;
        this.f = stringProvider;
        this.g = deepLinkIntentFactory;
        this.h = checkoutCalculator;
        this.i = priceItemCreator;
        this.j = kundle;
        this.k = features;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(CheckoutViewModelImpl.class)) {
            return new CheckoutViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.h, this.i, this.g, this.j, this.k);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
