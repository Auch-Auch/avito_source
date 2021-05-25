package com.avito.android.safedeal.delivery_courier.summary.konveyor;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import com.facebook.appevents.integrity.IntegrityManager;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProviderImpl;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/DeliveryCourierSummaryKonveyorResourceProvider;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContact", "()Ljava/lang/String;", "contact", AuthSource.SEND_ABUSE, "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "d", "getButtonTitle", "buttonTitle", "c", "getCost", "cost", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierSummaryKonveyorResourceProviderImpl implements DeliveryCourierSummaryKonveyorResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;

    @Inject
    public DeliveryCourierSummaryKonveyorResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.delivery_summary_address);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…delivery_summary_address)");
        this.a = string;
        String string2 = resources.getString(R.string.delivery_summary_contact);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…delivery_summary_contact)");
        this.b = string2;
        String string3 = resources.getString(R.string.delivery_summary_cost);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ng.delivery_summary_cost)");
        this.c = string3;
        String string4 = resources.getString(R.string.delivery_summary_button);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st….delivery_summary_button)");
        this.d = string4;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider
    @NotNull
    public String getAddress() {
        return this.a;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider
    @NotNull
    public String getButtonTitle() {
        return this.d;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider
    @NotNull
    public String getContact() {
        return this.b;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.DeliveryCourierSummaryKonveyorResourceProvider
    @NotNull
    public String getCost() {
        return this.c;
    }
}
