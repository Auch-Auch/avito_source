package com.avito.android.remote.model.abuse;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0010¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/abuse/AbuseCategory;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "subcategories", "Ljava/util/List;", "getSubcategories", "()Ljava/util/List;", "id", "I", "getId", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategory implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("id")
    private final int id;
    @SerializedName("subcategories")
    @Nullable
    private final List<AbuseCategory> subcategories;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/abuse/AbuseCategory$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/abuse/AbuseCategory;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/abuse/AbuseCategory;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/abuse/AbuseCategory;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AbuseCategory> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AbuseCategory createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AbuseCategory(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AbuseCategory[] newArray(int i) {
            return new AbuseCategory[i];
        }
    }

    public AbuseCategory(int i, @NotNull String str, @Nullable List<AbuseCategory> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.id = i;
        this.title = str;
        this.subcategories = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final List<AbuseCategory> getSubcategories() {
        return this.subcategories;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeTypedList(this.subcategories);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AbuseCategory(@NotNull Parcel parcel) {
        this(parcel.readInt(), a.u2(parcel, "parcel.readString()!!"), parcel.createTypedArrayList(CREATOR));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
