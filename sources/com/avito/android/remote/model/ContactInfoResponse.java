package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ContactInfoResponse;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/Phone;", "component2", "()Ljava/util/List;", "name", "phones", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/ContactInfoResponse;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getPhones", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class ContactInfoResponse implements Parcelable {
    public static final Parcelable.Creator<ContactInfoResponse> CREATOR = new Creator();
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("phones")
    @Nullable
    private final List<Phone> phones;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ContactInfoResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactInfoResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Phone.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ContactInfoResponse(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactInfoResponse[] newArray(int i) {
            return new ContactInfoResponse[i];
        }
    }

    public ContactInfoResponse(@NotNull String str, @Nullable List<Phone> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.phones = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.ContactInfoResponse */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContactInfoResponse copy$default(ContactInfoResponse contactInfoResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = contactInfoResponse.name;
        }
        if ((i & 2) != 0) {
            list = contactInfoResponse.phones;
        }
        return contactInfoResponse.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final List<Phone> component2() {
        return this.phones;
    }

    @NotNull
    public final ContactInfoResponse copy(@NotNull String str, @Nullable List<Phone> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ContactInfoResponse(str, list);
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
        if (!(obj instanceof ContactInfoResponse)) {
            return false;
        }
        ContactInfoResponse contactInfoResponse = (ContactInfoResponse) obj;
        return Intrinsics.areEqual(this.name, contactInfoResponse.name) && Intrinsics.areEqual(this.phones, contactInfoResponse.phones);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Phone> getPhones() {
        return this.phones;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<Phone> list = this.phones;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ContactInfoResponse(name=");
        L.append(this.name);
        L.append(", phones=");
        return a.w(L, this.phones, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        List<Phone> list = this.phones;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((Phone) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
