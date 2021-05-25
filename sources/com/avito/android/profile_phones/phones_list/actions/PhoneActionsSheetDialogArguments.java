package com.avito.android.profile_phones.phones_list.actions;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile_phones.phones_list.list_item.PhoneListItem;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/profile_phones/phones_list/actions/PhoneActionsSheetDialogArguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneListItem$Action;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionsSheetDialogArguments implements Parcelable {
    public static final Parcelable.Creator<PhoneActionsSheetDialogArguments> CREATOR = new Creator();
    @NotNull
    public final List<PhoneListItem.Action> a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneActionsSheetDialogArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneActionsSheetDialogArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(PhoneListItem.Action.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new PhoneActionsSheetDialogArguments(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneActionsSheetDialogArguments[] newArray(int i) {
            return new PhoneActionsSheetDialogArguments[i];
        }
    }

    public PhoneActionsSheetDialogArguments(@NotNull List<PhoneListItem.Action> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(str, "phone");
        this.a = list;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<PhoneListItem.Action> getActions() {
        return this.a;
    }

    @NotNull
    public final String getPhone() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.a, parcel);
        while (n0.hasNext()) {
            ((PhoneListItem.Action) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.b);
    }
}
