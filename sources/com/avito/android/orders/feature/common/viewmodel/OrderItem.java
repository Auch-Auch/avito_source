package com.avito.android.orders.feature.common.viewmodel;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.orders.model.OrderStatus;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u00012\u00020\u0002B[\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\n\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u000e\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u0011\u0012\u0006\u0010!\u001a\u00020\u0016¢\u0006\u0004\bL\u0010MJ\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0013J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018Jv\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\b\b\u0002\u0010!\u001a\u00020\u0016HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b$\u0010\u0005J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020%HÖ\u0001¢\u0006\u0004\b-\u0010'J \u00102\u001a\u0002012\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020%HÖ\u0001¢\u0006\u0004\b2\u00103R\u0019\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0010R\u001c\u0010\u0019\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0005R\u0019\u0010!\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u0018R\u0019\u0010\u001a\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\bR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00118\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\u0013R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010A\u001a\u0004\bD\u0010\u0013R\u0019\u0010\u001d\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010\bR\u0019\u0010\u001c\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010\fR\u0019\u0010\u001b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bK\u0010\b¨\u0006N"}, d2 = {"Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "Lcom/avito/conveyor_item/Item;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component5", "Lcom/avito/android/remote/orders/model/OrderStatus;", "component6", "()Lcom/avito/android/remote/orders/model/OrderStatus;", "", "component7", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Image;", "component8", "Lcom/avito/android/remote/model/ParametrizedEvent;", "component9", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "stringId", "title", Sort.DATE, "deepLink", "price", "status", "items", "images", "clickEvent", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/orders/model/OrderStatus;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/orders/feature/common/viewmodel/OrderItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Lcom/avito/android/remote/orders/model/OrderStatus;", "getStatus", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "i", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getClickEvent", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "h", "Ljava/util/List;", "getImages", g.a, "getItems", "e", "getPrice", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "c", "getDate", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/orders/model/OrderStatus;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/ParametrizedEvent;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrderItem implements Item, Parcelable {
    public static final Parcelable.Creator<OrderItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final AttributedText b;
    @NotNull
    public final AttributedText c;
    @NotNull
    public final DeepLink d;
    @NotNull
    public final AttributedText e;
    @NotNull
    public final OrderStatus f;
    @NotNull
    public final List<AttributedText> g;
    @NotNull
    public final List<Image> h;
    @NotNull
    public final ParametrizedEvent i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(OrderItem.class.getClassLoader());
            AttributedText attributedText2 = (AttributedText) parcel.readParcelable(OrderItem.class.getClassLoader());
            DeepLink deepLink = (DeepLink) parcel.readParcelable(OrderItem.class.getClassLoader());
            AttributedText attributedText3 = (AttributedText) parcel.readParcelable(OrderItem.class.getClassLoader());
            OrderStatus orderStatus = (OrderStatus) parcel.readParcelable(OrderItem.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AttributedText) parcel.readParcelable(OrderItem.class.getClassLoader()));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((Image) parcel.readParcelable(OrderItem.class.getClassLoader()));
                readInt2--;
            }
            return new OrderItem(readString, attributedText, attributedText2, deepLink, attributedText3, orderStatus, arrayList, arrayList2, (ParametrizedEvent) parcel.readParcelable(OrderItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderItem[] newArray(int i) {
            return new OrderItem[i];
        }
    }

    public OrderItem(@NotNull String str, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @NotNull DeepLink deepLink, @NotNull AttributedText attributedText3, @NotNull OrderStatus orderStatus, @NotNull List<AttributedText> list, @NotNull List<Image> list2, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(attributedText2, Sort.DATE);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(attributedText3, "price");
        Intrinsics.checkNotNullParameter(orderStatus, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "images");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        this.a = str;
        this.b = attributedText;
        this.c = attributedText2;
        this.d = deepLink;
        this.e = attributedText3;
        this.f = orderStatus;
        this.g = list;
        this.h = list2;
        this.i = parametrizedEvent;
    }

    public static /* synthetic */ OrderItem copy$default(OrderItem orderItem, String str, AttributedText attributedText, AttributedText attributedText2, DeepLink deepLink, AttributedText attributedText3, OrderStatus orderStatus, List list, List list2, ParametrizedEvent parametrizedEvent, int i2, Object obj) {
        return orderItem.copy((i2 & 1) != 0 ? orderItem.getStringId() : str, (i2 & 2) != 0 ? orderItem.b : attributedText, (i2 & 4) != 0 ? orderItem.c : attributedText2, (i2 & 8) != 0 ? orderItem.d : deepLink, (i2 & 16) != 0 ? orderItem.e : attributedText3, (i2 & 32) != 0 ? orderItem.f : orderStatus, (i2 & 64) != 0 ? orderItem.g : list, (i2 & 128) != 0 ? orderItem.h : list2, (i2 & 256) != 0 ? orderItem.i : parametrizedEvent);
    }

    @NotNull
    public final String component1() {
        return getStringId();
    }

    @NotNull
    public final AttributedText component2() {
        return this.b;
    }

    @NotNull
    public final AttributedText component3() {
        return this.c;
    }

    @NotNull
    public final DeepLink component4() {
        return this.d;
    }

    @NotNull
    public final AttributedText component5() {
        return this.e;
    }

    @NotNull
    public final OrderStatus component6() {
        return this.f;
    }

    @NotNull
    public final List<AttributedText> component7() {
        return this.g;
    }

    @NotNull
    public final List<Image> component8() {
        return this.h;
    }

    @NotNull
    public final ParametrizedEvent component9() {
        return this.i;
    }

    @NotNull
    public final OrderItem copy(@NotNull String str, @NotNull AttributedText attributedText, @NotNull AttributedText attributedText2, @NotNull DeepLink deepLink, @NotNull AttributedText attributedText3, @NotNull OrderStatus orderStatus, @NotNull List<AttributedText> list, @NotNull List<Image> list2, @NotNull ParametrizedEvent parametrizedEvent) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(attributedText2, Sort.DATE);
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(attributedText3, "price");
        Intrinsics.checkNotNullParameter(orderStatus, "status");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(list2, "images");
        Intrinsics.checkNotNullParameter(parametrizedEvent, "clickEvent");
        return new OrderItem(str, attributedText, attributedText2, deepLink, attributedText3, orderStatus, list, list2, parametrizedEvent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderItem)) {
            return false;
        }
        OrderItem orderItem = (OrderItem) obj;
        return Intrinsics.areEqual(getStringId(), orderItem.getStringId()) && Intrinsics.areEqual(this.b, orderItem.b) && Intrinsics.areEqual(this.c, orderItem.c) && Intrinsics.areEqual(this.d, orderItem.d) && Intrinsics.areEqual(this.e, orderItem.e) && Intrinsics.areEqual(this.f, orderItem.f) && Intrinsics.areEqual(this.g, orderItem.g) && Intrinsics.areEqual(this.h, orderItem.h) && Intrinsics.areEqual(this.i, orderItem.i);
    }

    @NotNull
    public final ParametrizedEvent getClickEvent() {
        return this.i;
    }

    @NotNull
    public final AttributedText getDate() {
        return this.c;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @NotNull
    public final List<Image> getImages() {
        return this.h;
    }

    @NotNull
    public final List<AttributedText> getItems() {
        return this.g;
    }

    @NotNull
    public final AttributedText getPrice() {
        return this.e;
    }

    @NotNull
    public final OrderStatus getStatus() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
        AttributedText attributedText = this.b;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.c;
        int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        DeepLink deepLink = this.d;
        int hashCode4 = (hashCode3 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        AttributedText attributedText3 = this.e;
        int hashCode5 = (hashCode4 + (attributedText3 != null ? attributedText3.hashCode() : 0)) * 31;
        OrderStatus orderStatus = this.f;
        int hashCode6 = (hashCode5 + (orderStatus != null ? orderStatus.hashCode() : 0)) * 31;
        List<AttributedText> list = this.g;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
        List<Image> list2 = this.h;
        int hashCode8 = (hashCode7 + (list2 != null ? list2.hashCode() : 0)) * 31;
        ParametrizedEvent parametrizedEvent = this.i;
        if (parametrizedEvent != null) {
            i2 = parametrizedEvent.hashCode();
        }
        return hashCode8 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderItem(stringId=");
        L.append(getStringId());
        L.append(", title=");
        L.append(this.b);
        L.append(", date=");
        L.append(this.c);
        L.append(", deepLink=");
        L.append(this.d);
        L.append(", price=");
        L.append(this.e);
        L.append(", status=");
        L.append(this.f);
        L.append(", items=");
        L.append(this.g);
        L.append(", images=");
        L.append(this.h);
        L.append(", clickEvent=");
        L.append(this.i);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i2);
        parcel.writeParcelable(this.c, i2);
        parcel.writeParcelable(this.d, i2);
        parcel.writeParcelable(this.e, i2);
        parcel.writeParcelable(this.f, i2);
        Iterator n0 = a.n0(this.g, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((AttributedText) n0.next(), i2);
        }
        Iterator n02 = a.n0(this.h, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((Image) n02.next(), i2);
        }
        parcel.writeParcelable(this.i, i2);
    }
}
