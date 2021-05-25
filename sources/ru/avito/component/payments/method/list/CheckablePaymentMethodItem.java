package ru.avito.component.payments.method.list;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.payments.method.PaymentLabel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lru/avito/component/payments/method/list/CheckablePaymentMethodItem;", "Lru/avito/component/payments/method/list/PaymentMethodItem;", "", g.a, "Ljava/lang/String;", "getMethodSignature", "()Ljava/lang/String;", "methodSignature", "Lru/avito/component/payments/method/PaymentLabel;", "f", "Lru/avito/component/payments/method/PaymentLabel;", "getLabel", "()Lru/avito/component/payments/method/PaymentLabel;", "label", "e", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "i", "getInformation", "information", "", "h", "Z", "isChecked", "()Z", "id", "isEnabled", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lru/avito/component/payments/method/PaymentLabel;Ljava/lang/String;ZLjava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CheckablePaymentMethodItem extends PaymentMethodItem {
    @NotNull
    public final String e;
    @NotNull
    public final PaymentLabel f;
    @NotNull
    public final String g;
    public final boolean h;
    @NotNull
    public final String i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckablePaymentMethodItem(@NotNull String str, boolean z, @NotNull String str2, @NotNull DeepLink deepLink, @NotNull String str3, @NotNull PaymentLabel paymentLabel, @NotNull String str4, boolean z2, @NotNull String str5) {
        super(str, z, str2, deepLink, null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(str3, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(paymentLabel, "label");
        Intrinsics.checkNotNullParameter(str4, "methodSignature");
        Intrinsics.checkNotNullParameter(str5, "information");
        this.e = str3;
        this.f = paymentLabel;
        this.g = str4;
        this.h = z2;
        this.i = str5;
    }

    @NotNull
    public final String getInformation() {
        return this.i;
    }

    @NotNull
    public final PaymentLabel getLabel() {
        return this.f;
    }

    @NotNull
    public final String getMethodSignature() {
        return this.g;
    }

    @NotNull
    public final String getSubtitle() {
        return this.e;
    }

    public final boolean isChecked() {
        return this.h;
    }
}
