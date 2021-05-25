package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import com.facebook.appevents.integrity.IntegrityManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "", "", "getButtonTitle", "()Ljava/lang/String;", "buttonTitle", "getCost", "cost", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getContact", "contact", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryCourierSummaryKonveyorResourceProvider {
    @NotNull
    String getAddress();

    @NotNull
    String getButtonTitle();

    @NotNull
    String getContact();

    @NotNull
    String getCost();
}
