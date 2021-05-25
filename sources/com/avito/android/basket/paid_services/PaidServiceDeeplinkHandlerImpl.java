package com.avito.android.basket.paid_services;

import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.bundles.ui.VasBundlesFragment;
import com.avito.android.bundles.vas_union.VasUnionFragment;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.BundlesLink;
import com.avito.android.deep_linking.links.CheckoutLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.FeeMethodsLink;
import com.avito.android.deep_linking.links.PerformanceVasLink;
import com.avito.android.deep_linking.links.TariffCountLink;
import com.avito.android.deep_linking.links.TariffEditInfoLink;
import com.avito.android.deep_linking.links.TariffInfoLink;
import com.avito.android.deep_linking.links.TariffLandingLink;
import com.avito.android.deep_linking.links.TariffPackageInfoLink;
import com.avito.android.deep_linking.links.TariffRegionLink;
import com.avito.android.deep_linking.links.VasUnionLink;
import com.avito.android.deep_linking.links.VisualVasLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.count.TariffCountFragment;
import com.avito.android.tariff.edit_info.EditInfoFragment;
import com.avito.android.tariff.fees_methods.FeesMethodsFragment;
import com.avito.android.tariff.info.TariffInfoFragment;
import com.avito.android.tariff.landing.TariffLandingFragment;
import com.avito.android.tariff.region.RegionFragment;
import com.avito.android.tariff.routing.PaidServiceDeeplinkHandler;
import com.avito.android.tariff.routing.RoutingAction;
import com.avito.android.tariff.tariff_package_info.TariffPackageInfoFragment;
import com.avito.android.vas_performance.ui.PerformanceVasFragment;
import com.avito.android.vas_performance.ui.VisualVasFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/basket/paid_services/PaidServiceDeeplinkHandlerImpl;", "Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "", "isUpIntent", "Lcom/avito/android/tariff/routing/RoutingAction;", "resolveDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;Z)Lcom/avito/android/tariff/routing/RoutingAction;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class PaidServiceDeeplinkHandlerImpl implements PaidServiceDeeplinkHandler {
    public final DeepLinkIntentFactory a;

    @Inject
    public PaidServiceDeeplinkHandlerImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.a = deepLinkIntentFactory;
    }

    @Override // com.avito.android.tariff.routing.PaidServiceDeeplinkHandler
    @NotNull
    public RoutingAction resolveDeeplink(@NotNull DeepLink deepLink, boolean z) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        if (deepLink instanceof FeeMethodsLink) {
            FeeMethodsLink feeMethodsLink = (FeeMethodsLink) deepLink;
            return new RoutingAction.FragmentRoutingAction(FeesMethodsFragment.Companion.newInstance(feeMethodsLink.getCheckoutContext(), feeMethodsLink.getClosable()));
        } else if (deepLink instanceof TariffLandingLink) {
            return new RoutingAction.FragmentRoutingAction(TariffLandingFragment.Companion.newInstance(((TariffLandingLink) deepLink).getCheckoutContext()));
        } else {
            if (deepLink instanceof TariffInfoLink) {
                return new RoutingAction.FragmentRoutingAction(TariffInfoFragment.Companion.newInstance(((TariffInfoLink) deepLink).getCheckoutContext()));
            }
            if (deepLink instanceof TariffRegionLink) {
                return new RoutingAction.FragmentRoutingAction(RegionFragment.Companion.newInstance(((TariffRegionLink) deepLink).getCheckoutContext()));
            }
            if (deepLink instanceof TariffCountLink) {
                return new RoutingAction.FragmentRoutingAction(TariffCountFragment.Companion.newInstance(((TariffCountLink) deepLink).getCheckoutContext()));
            }
            if (deepLink instanceof CheckoutLink) {
                CheckoutLink checkoutLink = (CheckoutLink) deepLink;
                return new RoutingAction.FragmentRoutingAction(CheckoutFragment.Companion.newInstance(checkoutLink.getCheckoutContext(), checkoutLink.getClosable()));
            } else if (deepLink instanceof TariffEditInfoLink) {
                return new RoutingAction.FragmentRoutingAction(EditInfoFragment.Companion.newInstance(((TariffEditInfoLink) deepLink).getCheckoutContext()));
            } else {
                if (deepLink instanceof PerformanceVasLink) {
                    PerformanceVasLink performanceVasLink = (PerformanceVasLink) deepLink;
                    return new RoutingAction.FragmentRoutingAction(PerformanceVasFragment.Companion.newInstance(performanceVasLink.getClosable(), performanceVasLink.getItemId(), performanceVasLink.getCheckoutContext()));
                } else if (deepLink instanceof TariffPackageInfoLink) {
                    TariffPackageInfoLink tariffPackageInfoLink = (TariffPackageInfoLink) deepLink;
                    return new RoutingAction.FragmentRoutingAction(TariffPackageInfoFragment.Companion.newInstance(tariffPackageInfoLink.getContractId(), tariffPackageInfoLink.getPackageId()));
                } else if (deepLink instanceof VisualVasLink) {
                    VisualVasLink visualVasLink = (VisualVasLink) deepLink;
                    return new RoutingAction.FragmentRoutingAction(VisualVasFragment.Companion.newInstance(visualVasLink.getClosable(), visualVasLink.getItemId(), visualVasLink.getCheckoutContext()));
                } else if (deepLink instanceof BundlesLink) {
                    BundlesLink bundlesLink = (BundlesLink) deepLink;
                    return new RoutingAction.FragmentRoutingAction(VasBundlesFragment.Companion.newInstance(bundlesLink.getClosable(), bundlesLink.getCheckoutContext(), bundlesLink.getCurrentFlow()));
                } else if (!(deepLink instanceof VasUnionLink)) {
                    return new RoutingAction.ActivityRoutingAction(this.a.getIntent(deepLink), z);
                } else {
                    VasUnionLink vasUnionLink = (VasUnionLink) deepLink;
                    return new RoutingAction.FragmentRoutingAction(VasUnionFragment.Companion.newInstance(vasUnionLink.getClosable(), vasUnionLink.getCheckoutContext(), vasUnionLink.getCurrentFlow()));
                }
            }
        }
    }
}
