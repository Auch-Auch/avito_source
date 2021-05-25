package com.avito.android.profile_phones.phone_action;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/PhoneActionArguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/profile_phones/phone_action/PhoneParcelableEntity;", "d", "Ljava/util/List;", "getPhonesForReplacement", "()Ljava/util/List;", "phonesForReplacement", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "getActionCode", "()Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "actionCode", "c", "Ljava/lang/Integer;", "getAdvertsCount", "()Ljava/lang/Integer;", "advertsCount", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;Ljava/lang/Integer;Ljava/util/List;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionArguments implements Parcelable {
    public static final Parcelable.Creator<PhoneActionArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final PhoneActionCode b;
    @Nullable
    public final Integer c;
    @NotNull
    public final List<PhoneParcelableEntity> d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneActionArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneActionArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            PhoneActionCode phoneActionCode = (PhoneActionCode) Enum.valueOf(PhoneActionCode.class, parcel.readString());
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(PhoneParcelableEntity.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new PhoneActionArguments(readString, phoneActionCode, valueOf, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneActionArguments[] newArray(int i) {
            return new PhoneActionArguments[i];
        }
    }

    public PhoneActionArguments(@NotNull String str, @NotNull PhoneActionCode phoneActionCode, @Nullable Integer num, @NotNull List<PhoneParcelableEntity> list) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(phoneActionCode, "actionCode");
        Intrinsics.checkNotNullParameter(list, "phonesForReplacement");
        this.a = str;
        this.b = phoneActionCode;
        this.c = num;
        this.d = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final PhoneActionCode getActionCode() {
        return this.b;
    }

    @Nullable
    public final Integer getAdvertsCount() {
        return this.c;
    }

    @NotNull
    public final String getPhone() {
        return this.a;
    }

    @NotNull
    public final List<PhoneParcelableEntity> getPhonesForReplacement() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b.name());
        Integer num = this.c;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.d, parcel);
        while (n0.hasNext()) {
            ((PhoneParcelableEntity) n0.next()).writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneActionArguments(String str, PhoneActionCode phoneActionCode, Integer num, List list, int i, j jVar) {
        this(str, phoneActionCode, (i & 4) != 0 ? null : num, (i & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
