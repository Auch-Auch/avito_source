package ru.avito.component.payments.method.list;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/component/payments/method/list/ButtonPaymentMethodItem;", "Lru/avito/component/payments/method/list/PaymentMethodItem;", "", "id", "", "isEnabled", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonPaymentMethodItem extends PaymentMethodItem {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonPaymentMethodItem(@NotNull String str, boolean z, @NotNull String str2, @NotNull DeepLink deepLink) {
        super(str, z, str2, deepLink, null);
        a.W0(str, "id", str2, "title", deepLink, "deepLink");
    }
}
