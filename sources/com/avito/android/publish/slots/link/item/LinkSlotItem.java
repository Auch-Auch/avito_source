package com.avito.android.publish.slots.link.item;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.slot.link.LinkSlotAlert;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\n¨\u0006$"}, d2 = {"Lcom/avito/android/publish/slots/link/item/LinkSlotItem;", "Lcom/avito/conveyor_item/Item;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "component3", "()Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "stringId", "text", "alert", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;)Lcom/avito/android/publish/slots/link/item/LinkSlotItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getText", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "c", "Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;", "getAlert", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/slot/link/LinkSlotAlert;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class LinkSlotItem implements Item {
    @NotNull
    public final String a;
    @NotNull
    public final AttributedText b;
    @Nullable
    public final LinkSlotAlert c;

    public LinkSlotItem(@NotNull String str, @NotNull AttributedText attributedText, @Nullable LinkSlotAlert linkSlotAlert) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.a = str;
        this.b = attributedText;
        this.c = linkSlotAlert;
    }

    public static /* synthetic */ LinkSlotItem copy$default(LinkSlotItem linkSlotItem, String str, AttributedText attributedText, LinkSlotAlert linkSlotAlert, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkSlotItem.getStringId();
        }
        if ((i & 2) != 0) {
            attributedText = linkSlotItem.b;
        }
        if ((i & 4) != 0) {
            linkSlotAlert = linkSlotItem.c;
        }
        return linkSlotItem.copy(str, attributedText, linkSlotAlert);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final AttributedText component2() {
        return this.b;
    }

    @Nullable
    public final LinkSlotAlert component3() {
        return this.c;
    }

    @NotNull
    public final LinkSlotItem copy(@NotNull String str, @NotNull AttributedText attributedText, @Nullable LinkSlotAlert linkSlotAlert) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "text");
        return new LinkSlotItem(str, attributedText, linkSlotAlert);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkSlotItem)) {
            return false;
        }
        LinkSlotItem linkSlotItem = (LinkSlotItem) obj;
        return Intrinsics.areEqual(getStringId(), linkSlotItem.getStringId()) && Intrinsics.areEqual(this.b, linkSlotItem.b) && Intrinsics.areEqual(this.c, linkSlotItem.c);
    }

    @Nullable
    public final LinkSlotAlert getAlert() {
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
    public final AttributedText getText() {
        return this.b;
    }

    public int hashCode() {
        String stringId = getStringId();
        int i = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        LinkSlotAlert linkSlotAlert = this.c;
        if (linkSlotAlert != null) {
            i = linkSlotAlert.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("LinkSlotItem(stringId=");
        L.append(getStringId());
        L.append(", text=");
        L.append(this.b);
        L.append(", alert=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
