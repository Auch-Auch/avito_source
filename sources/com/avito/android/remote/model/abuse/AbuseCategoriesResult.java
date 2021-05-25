package com.avito.android.remote.model.abuse;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/abuse/AbuseCategory;", "categories", "Ljava/util/List;", "getCategories", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseCategoriesResult implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @SerializedName("categories")
    @NotNull
    private final List<AbuseCategory> categories;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/model/abuse/AbuseCategoriesResult;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AbuseCategoriesResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(j jVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AbuseCategoriesResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AbuseCategoriesResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AbuseCategoriesResult[] newArray(int i) {
            return new AbuseCategoriesResult[i];
        }
    }

    public AbuseCategoriesResult(@NotNull List<AbuseCategory> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.categories = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<AbuseCategory> getCategories() {
        return this.categories;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeTypedList(this.categories);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AbuseCategoriesResult(@org.jetbrains.annotations.NotNull android.os.Parcel r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.avito.android.remote.model.abuse.AbuseCategory$CREATOR r0 = com.avito.android.remote.model.abuse.AbuseCategory.CREATOR
            java.util.ArrayList r2 = r2.createTypedArrayList(r0)
            if (r2 == 0) goto L_0x000e
            goto L_0x0012
        L_0x000e:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0012:
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.abuse.AbuseCategoriesResult.<init>(android.os.Parcel):void");
    }
}
