package com.avito.android.tariff.change.item.button;

import a2.b.a.a.a;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/tariff/change/item/button/ButtonItem;", "Lcom/avito/conveyor_item/Item;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/Action$Confirmation;", "d", "Lcom/avito/android/remote/model/Action$Confirmation;", "getConfirmation", "()Lcom/avito/android/remote/model/Action$Confirmation;", "confirmation", AuthSource.BOOKING_ORDER, "getText", "text", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Action$Confirmation;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final DeepLink c;
    @Nullable
    public final Action.Confirmation d;

    public ButtonItem(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink, @Nullable Action.Confirmation confirmation) {
        a.W0(str, "stringId", str2, "text", deepLink, "deepLink");
        this.a = str;
        this.b = str2;
        this.c = deepLink;
        this.d = confirmation;
    }

    @Nullable
    public final Action.Confirmation getConfirmation() {
        return this.d;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.c;
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
    public final String getText() {
        return this.b;
    }
}
