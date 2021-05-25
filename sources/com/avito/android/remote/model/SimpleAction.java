package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ0\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\"\u0010\r¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/SimpleAction;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "component3", "title", ShareConstants.MEDIA_URI, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "copy", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)Lcom/avito/android/remote/model/SimpleAction;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Landroid/net/Uri;", "getUri", "getStyle", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleAction implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SimpleAction> CREATOR = Parcels.creator(SimpleAction$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @Nullable
    private final String style;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final Uri uri;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SimpleAction$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SimpleAction;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SimpleAction(@NotNull String str, @NotNull Uri uri2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.title = str;
        this.uri = uri2;
        this.style = str2;
    }

    public static /* synthetic */ SimpleAction copy$default(SimpleAction simpleAction, String str, Uri uri2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simpleAction.title;
        }
        if ((i & 2) != 0) {
            uri2 = simpleAction.uri;
        }
        if ((i & 4) != 0) {
            str2 = simpleAction.style;
        }
        return simpleAction.copy(str, uri2, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final Uri component2() {
        return this.uri;
    }

    @Nullable
    public final String component3() {
        return this.style;
    }

    @NotNull
    public final SimpleAction copy(@NotNull String str, @NotNull Uri uri2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        return new SimpleAction(str, uri2, str2);
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
        if (!(obj instanceof SimpleAction)) {
            return false;
        }
        SimpleAction simpleAction = (SimpleAction) obj;
        return Intrinsics.areEqual(this.title, simpleAction.title) && Intrinsics.areEqual(this.uri, simpleAction.uri) && Intrinsics.areEqual(this.style, simpleAction.style);
    }

    @Nullable
    public final String getStyle() {
        return this.style;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Uri uri2 = this.uri;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        String str2 = this.style;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SimpleAction(title=");
        L.append(this.title);
        L.append(", uri=");
        L.append(this.uri);
        L.append(", style=");
        return a.t(L, this.style, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@Nullable Parcel parcel, int i) {
        if (parcel != null) {
            parcel.writeString(this.title);
        }
        if (parcel != null) {
            parcel.writeParcelable(this.uri, i);
        }
        if (parcel != null) {
            ParcelsKt.writeNullableValue(parcel, this.style);
        }
    }
}
