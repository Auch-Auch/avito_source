package com.avito.android.safedeal.delivery_courier.order_update;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.safedeal.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProviderImpl;", "Lcom/avito/android/safedeal/delivery_courier/order_update/DeliveryCourierOrderUpdateResourceProvider;", "", "e", "Ljava/lang/String;", "getAbstractError", "()Ljava/lang/String;", "abstractError", g.a, "getTimeIntervalSelectError", "timeIntervalSelectError", "c", "getNetworkLoadingError", "networkLoadingError", AuthSource.BOOKING_ORDER, "getSellerTitle", "sellerTitle", AuthSource.SEND_ABUSE, "getBuyerTitle", "buyerTitle", "d", "getSelectDeeplinkError", "selectDeeplinkError", "f", "getTryAgainError", "tryAgainError", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderUpdateResourceProviderImpl implements DeliveryCourierOrderUpdateResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final String g;

    @Inject
    public DeliveryCourierOrderUpdateResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.order_update_fragment_toolbar_title_buyer);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ment_toolbar_title_buyer)");
        this.a = string;
        String string2 = resources.getString(R.string.order_update_fragment_toolbar_title_seller);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…ent_toolbar_title_seller)");
        this.b = string2;
        String string3 = resources.getString(R.string.network_loading_error);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ng.network_loading_error)");
        this.c = string3;
        String string4 = resources.getString(R.string.select_deeplink_error);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…ng.select_deeplink_error)");
        this.d = string4;
        String string5 = resources.getString(R.string.has_error_occurred);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.has_error_occurred)");
        this.e = string5;
        String string6 = resources.getString(R.string.try_again_error);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.string.try_again_error)");
        this.f = string6;
        String string7 = resources.getString(R.string.delivery_courier_time_interval_select_error);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.st…me_interval_select_error)");
        this.g = string7;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getAbstractError() {
        return this.e;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getBuyerTitle() {
        return this.a;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getNetworkLoadingError() {
        return this.c;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getSelectDeeplinkError() {
        return this.d;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getSellerTitle() {
        return this.b;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getTimeIntervalSelectError() {
        return this.g;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.DeliveryCourierOrderUpdateResourceProvider
    @NotNull
    public String getTryAgainError() {
        return this.f;
    }
}
