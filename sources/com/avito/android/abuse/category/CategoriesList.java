package com.avito.android.abuse.category;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.abuse.AbuseCategory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0017\u0010\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/abuse/category/CategoriesList;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "Lcom/avito/android/abuse/category/CategoriesList;", "getParent", "()Lcom/avito/android/abuse/category/CategoriesList;", "parent", "", "Lcom/avito/android/remote/model/abuse/AbuseCategory;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getCategories", "()Ljava/util/List;", "categories", "<init>", "(Lcom/avito/android/abuse/category/CategoriesList;Ljava/util/List;)V", "(Landroid/os/Parcel;)V", "CREATOR", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class CategoriesList implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    public final CategoriesList a;
    @NotNull
    public final List<AbuseCategory> b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/abuse/category/CategoriesList$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/category/CategoriesList;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/abuse/category/CategoriesList;", "", "size", "", "newArray", "(I)[Lcom/avito/android/abuse/category/CategoriesList;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<CategoriesList> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public CategoriesList createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CategoriesList(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public CategoriesList[] newArray(int i) {
            return new CategoriesList[i];
        }
    }

    public CategoriesList(@Nullable CategoriesList categoriesList, @NotNull List<AbuseCategory> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.a = categoriesList;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<AbuseCategory> getCategories() {
        return this.b;
    }

    @Nullable
    public final CategoriesList getParent() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CategoriesList(@org.jetbrains.annotations.NotNull android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.Class<com.avito.android.abuse.category.CategoriesList> r0 = com.avito.android.abuse.category.CategoriesList.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r3.readParcelable(r0)
            com.avito.android.abuse.category.CategoriesList r0 = (com.avito.android.abuse.category.CategoriesList) r0
            com.avito.android.remote.model.abuse.AbuseCategory$CREATOR r1 = com.avito.android.remote.model.abuse.AbuseCategory.CREATOR
            java.util.ArrayList r3 = r3.createTypedArrayList(r1)
            if (r3 == 0) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001e:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.abuse.category.CategoriesList.<init>(android.os.Parcel):void");
    }
}
