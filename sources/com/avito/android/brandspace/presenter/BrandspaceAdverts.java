package com.avito.android.brandspace.presenter;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005¨\u0006 "}, d2 = {"Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/brandspace/items/adverts/BrandspaceAdvertItem;", "component1", "()Ljava/util/List;", "adverts", "copy", "(Ljava/util/List;)Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getAdverts", "<init>", "(Ljava/util/List;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdverts implements Parcelable {
    public static final Parcelable.Creator<BrandspaceAdverts> CREATOR = new Creator();
    @NotNull
    public final List<BrandspaceAdvertItem> a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceAdverts> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAdverts createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(BrandspaceAdvertItem.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new BrandspaceAdverts(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceAdverts[] newArray(int i) {
            return new BrandspaceAdverts[i];
        }
    }

    public BrandspaceAdverts() {
        this(null, 1, null);
    }

    public BrandspaceAdverts(@NotNull List<BrandspaceAdvertItem> list) {
        Intrinsics.checkNotNullParameter(list, "adverts");
        this.a = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.brandspace.presenter.BrandspaceAdverts */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BrandspaceAdverts copy$default(BrandspaceAdverts brandspaceAdverts, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = brandspaceAdverts.a;
        }
        return brandspaceAdverts.copy(list);
    }

    @NotNull
    public final List<BrandspaceAdvertItem> component1() {
        return this.a;
    }

    @NotNull
    public final BrandspaceAdverts copy(@NotNull List<BrandspaceAdvertItem> list) {
        Intrinsics.checkNotNullParameter(list, "adverts");
        return new BrandspaceAdverts(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof BrandspaceAdverts) && Intrinsics.areEqual(this.a, ((BrandspaceAdverts) obj).a);
        }
        return true;
    }

    @NotNull
    public final List<BrandspaceAdvertItem> getAdverts() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<BrandspaceAdvertItem> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.w(a.L("BrandspaceAdverts(adverts="), this.a, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.a, parcel);
        while (n0.hasNext()) {
            ((BrandspaceAdvertItem) n0.next()).writeToParcel(parcel, 0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrandspaceAdverts(List list, int i, j jVar) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
