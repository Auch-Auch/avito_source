package com.avito.android.photo_picker.gallery.data;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/photo_picker/gallery/data/Folder;", "", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFolderName", "()Ljava/lang/String;", "folderName", "Landroid/net/Uri;", AuthSource.BOOKING_ORDER, "Landroid/net/Uri;", "getPhotoUri", "()Landroid/net/Uri;", "photoUri", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class Folder {
    @NotNull
    public final String a;
    @Nullable
    public final Uri b;

    public Folder(@NotNull String str, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(str, "folderName");
        this.a = str;
        this.b = uri;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Folder) {
            return Intrinsics.areEqual(this.a, ((Folder) obj).a);
        }
        return false;
    }

    @NotNull
    public final String getFolderName() {
        return this.a;
    }

    @Nullable
    public final Uri getPhotoUri() {
        return this.b;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Folder(String str, Uri uri, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : uri);
    }
}
