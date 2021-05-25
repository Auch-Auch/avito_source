package com.avito.android.brandspace.router;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/avito/android/brandspace/router/BrandspaceArguments;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "c", "getBrandspaceSource", "brandspaceSource", "<init>", "(Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceArguments implements Parcelable {
    public static final Parcelable.Creator<BrandspaceArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final TreeClickStreamParent b;
    @Nullable
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<BrandspaceArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new BrandspaceArguments(parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(BrandspaceArguments.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BrandspaceArguments[] newArray(int i) {
            return new BrandspaceArguments[i];
        }
    }

    public BrandspaceArguments(@NotNull String str, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.a = str;
        this.b = treeClickStreamParent;
        this.c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getBrandspaceSource() {
        return this.c;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeString(this.c);
    }
}
