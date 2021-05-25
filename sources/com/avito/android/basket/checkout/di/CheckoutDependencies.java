package com.avito.android.basket.checkout.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.CheckoutApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/basket/checkout/di/CheckoutDependencies;", "", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "()Lcom/avito/android/tariff/StringProvider;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/remote/CheckoutApi;", "checkoutApi", "()Lcom/avito/android/remote/CheckoutApi;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface CheckoutDependencies {
    @Override // com.avito.android.vas_performance.di.VasDependencies
    @NotNull
    Analytics analytics();

    @NotNull
    AttributedTextFormatter attributedTextFormatter();

    @NotNull
    CheckoutApi checkoutApi();

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    Features features();

    @NotNull
    Locale locale();

    @Override // com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    SchedulersFactory schedulersFactory();

    @NotNull
    StringProvider stringProvider();
}
