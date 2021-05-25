package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\"\u0010\"\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u0012\u0004\b \u0010!\u001a\u0004\b\u001f\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/deep_linking/links/OrdersLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "component1", "()Ljava/lang/String;", "component2", "tab", "ordersToPrefetch", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/deep_linking/links/OrdersLink;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/lang/String;", "getTab", "e", "getOrdersToPrefetch", "c", "getPath", "getPath$annotations", "()V", MessageMetaInfo.COLUMN_PATH, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersLink extends DeepLink {
    public static final Parcelable.Creator<OrdersLink> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/profile/orders/open";
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/OrdersLink$Companion;", "", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrdersLink> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersLink createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrdersLink(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersLink[] newArray(int i) {
            return new OrdersLink[i];
        }
    }

    public OrdersLink() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrdersLink(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ OrdersLink copy$default(OrdersLink ordersLink, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ordersLink.d;
        }
        if ((i & 2) != 0) {
            str2 = ordersLink.e;
        }
        return ordersLink.copy(str, str2);
    }

    public static /* synthetic */ void getPath$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.d;
    }

    @Nullable
    public final String component2() {
        return this.e;
    }

    @NotNull
    public final OrdersLink copy(@Nullable String str, @Nullable String str2) {
        return new OrdersLink(str, str2);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrdersLink)) {
            return false;
        }
        OrdersLink ordersLink = (OrdersLink) obj;
        return Intrinsics.areEqual(this.d, ordersLink.d) && Intrinsics.areEqual(this.e, ordersLink.e);
    }

    @Nullable
    public final String getOrdersToPrefetch() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getTab() {
        return this.d;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrdersLink(tab=");
        L.append(this.d);
        L.append(", ordersToPrefetch=");
        return a.t(L, this.e, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public OrdersLink(@Nullable String str, @Nullable String str2) {
        this.d = str;
        this.e = str2;
        this.c = PATH;
    }
}
