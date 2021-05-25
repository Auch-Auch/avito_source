package com.avito.android.basket_legacy.di.checkout;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.di.AdvertId;
import com.avito.android.basket_legacy.di.LfRequired;
import com.avito.android.basket_legacy.di.VasContext;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.util.SchedulersFactory;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H'¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H'¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u001bH'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/basket_legacy/di/checkout/LegacyCheckoutDependencies;", "", "Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "basketRepository", "()Lcom/avito/android/basket_legacy/repositories/BasketRepository;", "Landroid/content/res/Resources;", "resources", "()Landroid/content/res/Resources;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "", BookingInfoActivity.EXTRA_ITEM_ID, "()Ljava/lang/String;", "vasContext", "", "lfRequired", "()Z", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyCheckoutDependencies {
    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @AdvertId
    @NotNull
    String advertId();

    @NotNull
    BasketRepository basketRepository();

    @Override // com.avito.android.vas_performance.di.perfomance_legacy.PerformanceVasDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @NotNull
    Features features();

    @LfRequired
    boolean lfRequired();

    @NotNull
    Locale locale();

    @NotNull
    Resources resources();

    @NotNull
    SchedulersFactory schedulersFactory();

    @VasContext
    @NotNull
    String vasContext();
}
