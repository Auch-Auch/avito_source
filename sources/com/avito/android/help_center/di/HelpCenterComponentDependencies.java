package com.avito.android.help_center.di;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.SessionHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.server_time.ServerTimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/help_center/di/HelpCenterComponentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/interceptor/GeoHeaderProvider;", "geoHeaderProvider", "()Lcom/avito/android/remote/interceptor/GeoHeaderProvider;", "Lcom/avito/android/remote/interceptor/SessionHeaderProvider;", "sessionHeaderProvider", "()Lcom/avito/android/remote/interceptor/SessionHeaderProvider;", "Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "dateHeaderProvider", "()Lcom/avito/android/remote/interceptor/DateHeaderProvider;", "Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "deviceIdHeaderProvider", "()Lcom/avito/android/remote/interceptor/DeviceIdHeaderProvider;", "Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "supportFeaturesHeaderProvider", "()Lcom/avito/android/remote/SupportFeaturesHeaderProvider;", "Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "userAgentHeaderProvider", "()Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "Lcom/avito/android/server_time/ServerTimeSource;", "serverTimeSource", "()Lcom/avito/android/server_time/ServerTimeSource;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deeplinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "help-center_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterComponentDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies
    @NotNull
    DateHeaderProvider dateHeaderProvider();

    @Override // com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies
    @NotNull
    DeepLinkFactory deeplinkFactory();

    @Override // com.avito.android.fees.di.FeesActivityDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.payment.di.component.PaymentDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.vas_discount.di.DiscountDependencies, com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.tariff.TariffDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.bundles.vas_union.di.VasUnionDependencies, com.avito.android.job.cv_packages.di.CvPackagesDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies
    @NotNull
    DeviceIdHeaderProvider deviceIdHeaderProvider();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies
    @NotNull
    GeoHeaderProvider geoHeaderProvider();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.webview.di.WebViewDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies
    @NotNull
    ServerTimeSource serverTimeSource();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies
    @NotNull
    SessionHeaderProvider sessionHeaderProvider();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies
    @NotNull
    SupportFeaturesHeaderProvider supportFeaturesHeaderProvider();

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesDependencies, com.avito.android.help_center.help_center_request.di.HelpCenterRequestDependencies, com.avito.android.autodeal_details.di.AutoDealDetailsDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies
    @NotNull
    UserAgentHeaderProvider userAgentHeaderProvider();
}
