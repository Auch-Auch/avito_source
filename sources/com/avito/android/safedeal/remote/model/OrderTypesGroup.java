package com.avito.android.safedeal.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JF\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010#\u001a\u0004\b&\u0010\u0004R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b(\u0010\t¨\u0006+"}, d2 = {"Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "component2", "", "Lcom/avito/android/safedeal/remote/model/OrderType;", "component3", "()Ljava/util/List;", "component4", "title", MessengerShareContentUtility.SUBTITLE, "orderTypes", "disclaimer", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/safedeal/remote/model/OrderTypesGroup;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "getSubtitle", "getDisclaimer", "Ljava/util/List;", "getOrderTypes", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class OrderTypesGroup implements Parcelable {
    public static final Parcelable.Creator<OrderTypesGroup> CREATOR = new Creator();
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName("orderTypes")
    @Nullable
    private final List<OrderType> orderTypes;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final AttributedText subtitle;
    @SerializedName("title")
    @Nullable
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrderTypesGroup> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderTypesGroup createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            AttributedText attributedText = (AttributedText) parcel.readParcelable(OrderTypesGroup.class.getClassLoader());
            AttributedText attributedText2 = (AttributedText) parcel.readParcelable(OrderTypesGroup.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(OrderType.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new OrderTypesGroup(attributedText, attributedText2, arrayList, (AttributedText) parcel.readParcelable(OrderTypesGroup.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrderTypesGroup[] newArray(int i) {
            return new OrderTypesGroup[i];
        }
    }

    public OrderTypesGroup(@Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable List<OrderType> list, @Nullable AttributedText attributedText3) {
        this.title = attributedText;
        this.subtitle = attributedText2;
        this.orderTypes = list;
        this.disclaimer = attributedText3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.safedeal.remote.model.OrderTypesGroup */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OrderTypesGroup copy$default(OrderTypesGroup orderTypesGroup, AttributedText attributedText, AttributedText attributedText2, List list, AttributedText attributedText3, int i, Object obj) {
        if ((i & 1) != 0) {
            attributedText = orderTypesGroup.title;
        }
        if ((i & 2) != 0) {
            attributedText2 = orderTypesGroup.subtitle;
        }
        if ((i & 4) != 0) {
            list = orderTypesGroup.orderTypes;
        }
        if ((i & 8) != 0) {
            attributedText3 = orderTypesGroup.disclaimer;
        }
        return orderTypesGroup.copy(attributedText, attributedText2, list, attributedText3);
    }

    @Nullable
    public final AttributedText component1() {
        return this.title;
    }

    @Nullable
    public final AttributedText component2() {
        return this.subtitle;
    }

    @Nullable
    public final List<OrderType> component3() {
        return this.orderTypes;
    }

    @Nullable
    public final AttributedText component4() {
        return this.disclaimer;
    }

    @NotNull
    public final OrderTypesGroup copy(@Nullable AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable List<OrderType> list, @Nullable AttributedText attributedText3) {
        return new OrderTypesGroup(attributedText, attributedText2, list, attributedText3);
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
        if (!(obj instanceof OrderTypesGroup)) {
            return false;
        }
        OrderTypesGroup orderTypesGroup = (OrderTypesGroup) obj;
        return Intrinsics.areEqual(this.title, orderTypesGroup.title) && Intrinsics.areEqual(this.subtitle, orderTypesGroup.subtitle) && Intrinsics.areEqual(this.orderTypes, orderTypesGroup.orderTypes) && Intrinsics.areEqual(this.disclaimer, orderTypesGroup.disclaimer);
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final List<OrderType> getOrderTypes() {
        return this.orderTypes;
    }

    @Nullable
    public final AttributedText getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AttributedText attributedText = this.title;
        int i = 0;
        int hashCode = (attributedText != null ? attributedText.hashCode() : 0) * 31;
        AttributedText attributedText2 = this.subtitle;
        int hashCode2 = (hashCode + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        List<OrderType> list = this.orderTypes;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        AttributedText attributedText3 = this.disclaimer;
        if (attributedText3 != null) {
            i = attributedText3.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("OrderTypesGroup(title=");
        L.append(this.title);
        L.append(", subtitle=");
        L.append(this.subtitle);
        L.append(", orderTypes=");
        L.append(this.orderTypes);
        L.append(", disclaimer=");
        L.append(this.disclaimer);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.title, i);
        parcel.writeParcelable(this.subtitle, i);
        List<OrderType> list = this.orderTypes;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((OrderType) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.disclaimer, i);
    }
}
