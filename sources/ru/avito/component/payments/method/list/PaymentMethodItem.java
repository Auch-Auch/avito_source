package ru.avito.component.payments.method.list;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000b\u0001\u0004\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lru/avito/component/payments/method/list/PaymentMethodItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.BOOKING_ORDER, "Z", "isEnabled", "()Z", "", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lru/avito/component/payments/method/list/ButtonPaymentMethodItem;", "Lru/avito/component/payments/method/list/SimplePaymentMethodItem;", "Lru/avito/component/payments/method/list/CheckablePaymentMethodItem;", "Lru/avito/component/payments/method/list/MaterialPaymentMethodItem;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentMethodItem implements Item {
    @NotNull
    public final String a;
    public final boolean b;
    @NotNull
    public final String c;
    @NotNull
    public final DeepLink d;

    public PaymentMethodItem(String str, boolean z, String str2, DeepLink deepLink, j jVar) {
        this.a = str;
        this.b = z;
        this.c = str2;
        this.d = deepLink;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    public final boolean isEnabled() {
        return this.b;
    }
}
