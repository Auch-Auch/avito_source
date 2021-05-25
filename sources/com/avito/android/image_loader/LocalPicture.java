package com.avito.android.image_loader;

import a2.b.a.a.a;
import android.net.Uri;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.common.util.UriUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/image_loader/LocalPicture;", "Lcom/avito/android/image_loader/Picture;", "Landroid/view/View;", "view", "Landroid/net/Uri;", "getUri", "(Landroid/view/View;)Landroid/net/Uri;", "", "resId", "copy", "(I)Lcom/avito/android/image_loader/LocalPicture;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "<init>", "(I)V", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public final class LocalPicture implements Picture {
    public final int a;

    public LocalPicture(@DrawableRes int i) {
        this.a = i;
    }

    public static /* synthetic */ LocalPicture copy$default(LocalPicture localPicture, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = localPicture.a;
        }
        return localPicture.copy(i);
    }

    @NotNull
    public final LocalPicture copy(@DrawableRes int i) {
        return new LocalPicture(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof LocalPicture) && this.a == ((LocalPicture) obj).a;
        }
        return true;
    }

    @Override // com.avito.android.image_loader.Picture
    @NotNull
    public Uri getUri(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Uri build = new Uri.Builder().scheme(UriUtil.LOCAL_RESOURCE_SCHEME).path(String.valueOf(this.a)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Uri.Builder()\n        .s…tring())\n        .build()");
        return build;
    }

    public int hashCode() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return a.j(a.L("LocalPicture(resId="), this.a, ")");
    }
}
