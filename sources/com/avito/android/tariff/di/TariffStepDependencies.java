package com.avito.android.tariff.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.TariffApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/tariff/di/TariffStepDependencies;", "", "Lcom/avito/android/remote/TariffApi;", "tariffApi", "()Lcom/avito/android/remote/TariffApi;", "Lcom/avito/android/remote/PublishLimitsApi;", "publishLimitsApi", "()Lcom/avito/android/remote/PublishLimitsApi;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/tariff/StringProvider;", "stringProvider", "()Lcom/avito/android/tariff/StringProvider;", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface TariffStepDependencies {
    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.VasDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies
    @NotNull
    AttributedTextFormatter attributedTextFormatter();

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    Features features();

    @NotNull
    PublishLimitsApi publishLimitsApi();

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies, com.avito.android.vas_performance.di.perfomance.PerformanceVasDependenciesNew, com.avito.android.vas_performance.di.visual.VisualVasDependenciesNew
    @NotNull
    SchedulersFactory schedulersFactory();

    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @Override // com.avito.android.basket.checkout.di.CheckoutDependencies
    @NotNull
    StringProvider stringProvider();

    @NotNull
    TariffApi tariffApi();
}
