package com.avito.android.safedeal.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/safedeal/remote/model/SafeDealPayoutRedirectResponse;", "Landroid/os/Parcelable;", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "payoutUrl", "copy", "(Landroid/net/Uri;)Lcom/avito/android/safedeal/remote/model/SafeDealPayoutRedirectResponse;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "getPayoutUrl", "<init>", "(Landroid/net/Uri;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SafeDealPayoutRedirectResponse implements Parcelable {
    public static final Parcelable.Creator<SafeDealPayoutRedirectResponse> CREATOR = new Creator();
    @SerializedName("payoutUrl")
    @NotNull
    private final Uri payoutUrl;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SafeDealPayoutRedirectResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealPayoutRedirectResponse createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SafeDealPayoutRedirectResponse((Uri) parcel.readParcelable(SafeDealPayoutRedirectResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDealPayoutRedirectResponse[] newArray(int i) {
            return new SafeDealPayoutRedirectResponse[i];
        }
    }

    public SafeDealPayoutRedirectResponse(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "payoutUrl");
        this.payoutUrl = uri;
    }

    public static /* synthetic */ SafeDealPayoutRedirectResponse copy$default(SafeDealPayoutRedirectResponse safeDealPayoutRedirectResponse, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = safeDealPayoutRedirectResponse.payoutUrl;
        }
        return safeDealPayoutRedirectResponse.copy(uri);
    }

    @NotNull
    public final Uri component1() {
        return this.payoutUrl;
    }

    @NotNull
    public final SafeDealPayoutRedirectResponse copy(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "payoutUrl");
        return new SafeDealPayoutRedirectResponse(uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SafeDealPayoutRedirectResponse) && Intrinsics.areEqual(this.payoutUrl, ((SafeDealPayoutRedirectResponse) obj).payoutUrl);
        }
        return true;
    }

    @NotNull
    public final Uri getPayoutUrl() {
        return this.payoutUrl;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Uri uri = this.payoutUrl;
        if (uri != null) {
            return uri.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SafeDealPayoutRedirectResponse(payoutUrl=");
        L.append(this.payoutUrl);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.payoutUrl, i);
    }
}
