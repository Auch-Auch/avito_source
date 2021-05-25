package com.avito.android.orders.feature.host.viewpager;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/orders/feature/host/viewpager/OrdersTabItem;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getShortcut", "()Ljava/lang/String;", "shortcut", "d", "getTitle", "title", "f", "Ljava/lang/Integer;", "getCount", "()Ljava/lang/Integer;", "count", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersTabItem extends BaseTabItem {
    public static final Parcelable.Creator<OrdersTabItem> CREATOR = new Creator();
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @Nullable
    public final Integer f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrdersTabItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersTabItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrdersTabItem(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersTabItem[] newArray(int i) {
            return new OrdersTabItem[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrdersTabItem(String str, String str2, Integer num, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem
    @Nullable
    public Integer getCount() {
        return this.f;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem
    @NotNull
    public String getShortcut() {
        return this.e;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem, com.avito.android.design.widget.tab.Tab
    @NotNull
    public String getTitle() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        Integer num = this.f;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrdersTabItem(@NotNull String str, @NotNull String str2, @Nullable Integer num) {
        super(str, num, str2);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        this.d = str;
        this.e = str2;
        this.f = num;
    }
}
