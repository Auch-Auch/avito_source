package com.avito.android.image_loader;

import a2.b.a.a.a;
import android.net.Uri;
import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/image_loader/SimplePicture;", "Lcom/avito/android/image_loader/Picture;", "Landroid/view/View;", "view", "Landroid/net/Uri;", "getUri", "(Landroid/view/View;)Landroid/net/Uri;", ShareConstants.MEDIA_URI, "copy", "(Landroid/net/Uri;)Lcom/avito/android/image_loader/SimplePicture;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class SimplePicture implements Picture {
    public final Uri a;

    public SimplePicture(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.a = uri;
    }

    public static /* synthetic */ SimplePicture copy$default(SimplePicture simplePicture, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = simplePicture.a;
        }
        return simplePicture.copy(uri);
    }

    @NotNull
    public final SimplePicture copy(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return new SimplePicture(uri);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SimplePicture) && Intrinsics.areEqual(this.a, ((SimplePicture) obj).a);
        }
        return true;
    }

    @Override // com.avito.android.image_loader.Picture
    @NotNull
    public Uri getUri(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.a;
    }

    public int hashCode() {
        Uri uri = this.a;
        if (uri != null) {
            return uri.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SimplePicture(uri=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
