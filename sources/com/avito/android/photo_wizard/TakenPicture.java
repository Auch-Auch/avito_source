package com.avito.android.photo_wizard;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/photo_wizard/TakenPicture;", "", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "id", ShareConstants.MEDIA_URI, "copy", "(Ljava/lang/String;Landroid/net/Uri;)Lcom/avito/android/photo_wizard/TakenPicture;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getUri", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class TakenPicture {
    @NotNull
    public final String a;
    @NotNull
    public final Uri b;

    public TakenPicture(@NotNull String str, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.a = str;
        this.b = uri;
    }

    public static /* synthetic */ TakenPicture copy$default(TakenPicture takenPicture, String str, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = takenPicture.a;
        }
        if ((i & 2) != 0) {
            uri = takenPicture.b;
        }
        return takenPicture.copy(str, uri);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final Uri component2() {
        return this.b;
    }

    @NotNull
    public final TakenPicture copy(@NotNull String str, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return new TakenPicture(str, uri);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TakenPicture)) {
            return false;
        }
        TakenPicture takenPicture = (TakenPicture) obj;
        return Intrinsics.areEqual(this.a, takenPicture.a) && Intrinsics.areEqual(this.b, takenPicture.b);
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final Uri getUri() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Uri uri = this.b;
        if (uri != null) {
            i = uri.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TakenPicture(id=");
        L.append(this.a);
        L.append(", uri=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
