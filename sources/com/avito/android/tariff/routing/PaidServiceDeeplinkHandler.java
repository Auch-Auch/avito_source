package com.avito.android.tariff.routing;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/tariff/routing/PaidServiceDeeplinkHandler;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "", "isUpIntent", "Lcom/avito/android/tariff/routing/RoutingAction;", "resolveDeeplink", "(Lcom/avito/android/deep_linking/links/DeepLink;Z)Lcom/avito/android/tariff/routing/RoutingAction;", "tariff_release"}, k = 1, mv = {1, 4, 2})
public interface PaidServiceDeeplinkHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ RoutingAction resolveDeeplink$default(PaidServiceDeeplinkHandler paidServiceDeeplinkHandler, DeepLink deepLink, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return paidServiceDeeplinkHandler.resolveDeeplink(deepLink, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveDeeplink");
        }
    }

    @NotNull
    RoutingAction resolveDeeplink(@NotNull DeepLink deepLink, boolean z);
}
