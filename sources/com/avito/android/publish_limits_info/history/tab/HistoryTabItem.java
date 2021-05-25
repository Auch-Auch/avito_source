package com.avito.android.publish_limits_info.history.tab;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/HistoryTabItem;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "e", "Ljava/lang/String;", "getShortcut", "()Ljava/lang/String;", "shortcut", "d", "getTitle", "title", "f", "I", "getCount", "()Ljava/lang/Integer;", "count", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class HistoryTabItem extends BaseTabItem {
    public static final Parcelable.Creator<HistoryTabItem> CREATOR = new Creator();
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final int f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<HistoryTabItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HistoryTabItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new HistoryTabItem(parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final HistoryTabItem[] newArray(int i) {
            return new HistoryTabItem[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HistoryTabItem(@NotNull String str, @NotNull String str2, int i) {
        super(str, Integer.valueOf(i), str2);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        this.d = str;
        this.e = str2;
        this.f = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.ui.adapter.tab.BaseTabItem
    @NotNull
    public Integer getCount() {
        return Integer.valueOf(this.f);
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
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
    }
}
