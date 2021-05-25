package com.avito.android.paid_services.routing;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/paid_services/routing/PaidServicesRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "navigate", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/paid_services/routing/DialogInfo;", "dialogInfo", "finishFlow", "(Lcom/avito/android/paid_services/routing/DialogInfo;)V", "", "activityResult", "finishFlowWithResult", "(Lcom/avito/android/paid_services/routing/DialogInfo;I)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PaidServicesRouter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void finishFlow$default(PaidServicesRouter paidServicesRouter, DialogInfo dialogInfo, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    dialogInfo = null;
                }
                paidServicesRouter.finishFlow(dialogInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishFlow");
        }

        public static /* synthetic */ void finishFlowWithResult$default(PaidServicesRouter paidServicesRouter, DialogInfo dialogInfo, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    dialogInfo = null;
                }
                paidServicesRouter.finishFlowWithResult(dialogInfo, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishFlowWithResult");
        }
    }

    void finishFlow(@Nullable DialogInfo dialogInfo);

    void finishFlowWithResult(@Nullable DialogInfo dialogInfo, int i);

    void navigate(@NotNull DeepLink deepLink);
}
