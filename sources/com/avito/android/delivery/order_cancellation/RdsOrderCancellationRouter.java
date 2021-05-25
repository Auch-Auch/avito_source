package com.avito.android.delivery.order_cancellation;

import com.avito.android.remote.model.ReasonRds;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/RdsOrderCancellationRouter;", "", "", "activityResult", "", "forceLeaveScreen", "(I)V", "Lcom/avito/android/remote/model/ReasonRds;", "reason", "commentMaxLength", "openReasonDetailsScreen", "(Lcom/avito/android/remote/model/ReasonRds;I)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface RdsOrderCancellationRouter {
    void forceLeaveScreen(int i);

    void openReasonDetailsScreen(@NotNull ReasonRds reasonRds, int i);
}
