package com.avito.android.payment.wallet.history.details;

import android.content.res.Resources;
import com.avito.android.payment.R;
import com.avito.android.payment.wallet.history.details.item.AdvertItem;
import com.avito.android.payment.wallet.history.details.item.BaseItem;
import com.avito.android.payment.wallet.history.details.item.ButtonItem;
import com.avito.android.payment.wallet.history.details.item.SimpleItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.payment.history.OperationTarget;
import com.avito.android.remote.model.payment.history.OrderTarget;
import com.avito.android.remote.model.payment.history.PaymentDetails;
import com.avito.android.remote.model.payment.history.PaymentOrderStatus;
import com.avito.android.remote.model.payment.history.Receipt;
import com.avito.konveyor.blueprint.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/payment/history/PaymentDetails;", "Landroid/content/res/Resources;", "resources", "", "Lcom/avito/konveyor/blueprint/Item;", "toItemList", "(Lcom/avito/android/remote/model/payment/history/PaymentDetails;Landroid/content/res/Resources;)Ljava/util/List;", "Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/payment/history/PaymentOrderStatus;Landroid/content/res/Resources;)Ljava/lang/String;", "payment_release"}, k = 2, mv = {1, 4, 2})
public final class PaymentDetailsDataMapperKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PaymentOrderStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            PaymentOrderStatus paymentOrderStatus = PaymentOrderStatus.DONE;
            iArr[1] = 1;
            PaymentOrderStatus paymentOrderStatus2 = PaymentOrderStatus.ACTIVE;
            iArr[0] = 2;
            PaymentOrderStatus paymentOrderStatus3 = PaymentOrderStatus.CANCELED;
            iArr[2] = 3;
            PaymentOrderStatus paymentOrderStatus4 = PaymentOrderStatus.FAILED;
            iArr[3] = 4;
        }
    }

    public static final String a(PaymentOrderStatus paymentOrderStatus, Resources resources) {
        int ordinal = paymentOrderStatus.ordinal();
        if (ordinal == 0) {
            String string = resources.getString(R.string.payment_order_status_in_progress);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…order_status_in_progress)");
            return string;
        } else if (ordinal == 1) {
            String string2 = resources.getString(R.string.payment_order_status_done);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…ayment_order_status_done)");
            return string2;
        } else if (ordinal == 2) {
            String string3 = resources.getString(R.string.payment_order_status_rejected);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…nt_order_status_rejected)");
            return string3;
        } else if (ordinal == 3) {
            String string4 = resources.getString(R.string.payment_order_status_rejected);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…nt_order_status_rejected)");
            return string4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final List<Item> toItemList(@NotNull PaymentDetails paymentDetails, @NotNull Resources resources) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(paymentDetails, "$this$toItemList");
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (paymentDetails instanceof PaymentDetails.OrderDetails) {
            PaymentDetails.OrderDetails orderDetails = (PaymentDetails.OrderDetails) paymentDetails;
            arrayList = new ArrayList();
            for (T t : orderDetails.getTargets()) {
                if (t instanceof OrderTarget.Advert) {
                    T t2 = t;
                    String title = t2.getTitle();
                    String description = t2.getDescription();
                    String amount = t2.getAmount();
                    Image image = t2.getImage();
                    String string = resources.getString(R.string.payment_services);
                    Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.payment_services)");
                    arrayList.add(new AdvertItem(0, title, description, amount, image, string, t2.getServices(), 1, null));
                } else if (t instanceof OrderTarget.Base) {
                    arrayList.add(new BaseItem(0, t.getTitle(), 1, null));
                }
            }
            String string2 = resources.getString(R.string.payment_amount);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.payment_amount)");
            arrayList.add(new SimpleItem(0, string2, orderDetails.getAmount(), 1, null));
            String string3 = resources.getString(R.string.payment_payment_method);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…g.payment_payment_method)");
            arrayList.add(new SimpleItem(0, string3, orderDetails.getPaymentMethod(), 1, null));
            String string4 = resources.getString(R.string.payment_status);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.string.payment_status)");
            arrayList.add(new SimpleItem(0, string4, a(orderDetails.getStatus(), resources), 1, null));
            String string5 = resources.getString(R.string.payment_date);
            Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.string.payment_date)");
            arrayList.add(new SimpleItem(0, string5, orderDetails.getDate(), 1, null));
            Receipt receipt = orderDetails.getReceipt();
            if (receipt != null) {
                String string6 = resources.getString(R.string.payment_look_at_receipt);
                Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st….payment_look_at_receipt)");
                arrayList.add(new ButtonItem(0, string6, receipt, 1, null));
            }
        } else if (paymentDetails instanceof PaymentDetails.OperationDetails) {
            PaymentDetails.OperationDetails operationDetails = (PaymentDetails.OperationDetails) paymentDetails;
            arrayList = new ArrayList();
            OperationTarget target = operationDetails.getTarget();
            if (target instanceof OperationTarget.Advert) {
                OperationTarget.Advert advert = (OperationTarget.Advert) target;
                String title2 = advert.getTitle();
                String description2 = advert.getDescription();
                String amount2 = advert.getAmount();
                Image image2 = advert.getImage();
                String string7 = resources.getString(R.string.payment_service);
                Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(R.string.payment_service)");
                arrayList.add(new AdvertItem(0, title2, description2, amount2, image2, string7, d.listOf(advert.getService()), 1, null));
            } else if (target instanceof OperationTarget.Base) {
                arrayList.add(new BaseItem(0, ((OperationTarget.Base) target).getTitle(), 1, null));
            }
            String string8 = resources.getString(R.string.payment_amount);
            Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(R.string.payment_amount)");
            arrayList.add(new SimpleItem(0, string8, operationDetails.getAmount(), 1, null));
            String string9 = resources.getString(R.string.payment_payment_method);
            Intrinsics.checkNotNullExpressionValue(string9, "resources.getString(R.st…g.payment_payment_method)");
            arrayList.add(new SimpleItem(0, string9, operationDetails.getPaymentMethod(), 1, null));
            String string10 = resources.getString(R.string.payment_status);
            Intrinsics.checkNotNullExpressionValue(string10, "resources.getString(R.string.payment_status)");
            arrayList.add(new SimpleItem(0, string10, a(operationDetails.getStatus(), resources), 1, null));
            String string11 = resources.getString(R.string.payment_date);
            Intrinsics.checkNotNullExpressionValue(string11, "resources.getString(R.string.payment_date)");
            arrayList.add(new SimpleItem(0, string11, operationDetails.getDate(), 1, null));
            Receipt receipt2 = operationDetails.getReceipt();
            if (receipt2 != null) {
                String string12 = resources.getString(R.string.payment_look_at_receipt);
                Intrinsics.checkNotNullExpressionValue(string12, "resources.getString(R.st….payment_look_at_receipt)");
                arrayList.add(new ButtonItem(0, string12, receipt2, 1, null));
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return arrayList;
    }
}
