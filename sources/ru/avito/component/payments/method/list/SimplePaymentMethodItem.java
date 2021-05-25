package ru.avito.component.payments.method.list;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.PaymentLabel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lru/avito/component/payments/method/list/SimplePaymentMethodItem;", "Lru/avito/component/payments/method/list/PaymentMethodItem;", "Lru/avito/component/payments/method/PaymentLabel;", "f", "Lru/avito/component/payments/method/PaymentLabel;", "getLabel", "()Lru/avito/component/payments/method/PaymentLabel;", "label", "", "e", "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, g.a, "getInformation", "information", "id", "", "isEnabled", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lru/avito/component/payments/method/PaymentLabel;Ljava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SimplePaymentMethodItem extends PaymentMethodItem {
    @NotNull
    public final String e;
    @NotNull
    public final PaymentLabel f;
    @NotNull
    public final String g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimplePaymentMethodItem(@NotNull String str, boolean z, @NotNull String str2, @NotNull DeepLink deepLink, @NotNull String str3, @NotNull PaymentLabel paymentLabel, @NotNull String str4) {
        super(str, z, str2, deepLink, null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(paymentLabel, "label");
        Intrinsics.checkNotNullParameter(str4, "information");
        this.e = str3;
        this.f = paymentLabel;
        this.g = str4;
    }

    @NotNull
    public final String getInformation() {
        return this.g;
    }

    @NotNull
    public final PaymentLabel getLabel() {
        return this.f;
    }

    @NotNull
    public final String getSubtitle() {
        return this.e;
    }
}
