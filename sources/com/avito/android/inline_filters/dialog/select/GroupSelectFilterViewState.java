package com.avito.android.inline_filters.dialog.select;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/GroupSelectFilterViewState;", "Landroid/os/Parcelable;", "", "id", "", "isChecked", "(Ljava/lang/String;)Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "checkedOptionIds", "<init>", "(Ljava/util/Set;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectFilterViewState implements Parcelable {
    public static final Parcelable.Creator<GroupSelectFilterViewState> CREATOR = new Creator();
    public final Set<String> a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GroupSelectFilterViewState> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GroupSelectFilterViewState createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
            while (readInt != 0) {
                linkedHashSet.add(parcel.readString());
                readInt--;
            }
            return new GroupSelectFilterViewState(linkedHashSet);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GroupSelectFilterViewState[] newArray(int i) {
            return new GroupSelectFilterViewState[i];
        }
    }

    public GroupSelectFilterViewState(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "checkedOptionIds");
        this.a = set;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean isChecked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return this.a.contains(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Set<String> set = this.a;
        parcel.writeInt(set.size());
        for (String str : set) {
            parcel.writeString(str);
        }
    }
}
