package com.avito.android.user_stats.tab;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabItem;", "Lcom/avito/android/ui/adapter/tab/BaseTabItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "e", "getShortcut", "shortcut", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabItem extends BaseTabItem {
    public static final Parcelable.Creator<UserStatsTabItem> CREATOR = new Creator();
    @NotNull
    public final String d;
    @NotNull
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserStatsTabItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserStatsTabItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UserStatsTabItem(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserStatsTabItem[] newArray(int i) {
            return new UserStatsTabItem[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserStatsTabItem(@NotNull String str, @NotNull String str2) {
        super(str, null, str2);
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "shortcut");
        this.d = str;
        this.e = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
    }
}
