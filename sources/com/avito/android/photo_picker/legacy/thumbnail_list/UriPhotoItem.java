package com.avito.android.photo_picker.legacy.thumbnail_list;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.util.Uris;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0015\u0010\b\u001a\u0004\u0018\u00010\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\u0007R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/UriPhotoItem;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "", "toString", "()Ljava/lang/String;", "Landroid/net/Uri;", "getPhotoUri", "()Landroid/net/Uri;", "photoUri", "e", "Landroid/net/Uri;", "getSourceUri", "sourceUri", "d", "getImageUri", "imageUri", "Lcom/avito/android/krop/util/Transformation;", "f", "Lcom/avito/android/krop/util/Transformation;", "getTransformation", "()Lcom/avito/android/krop/util/Transformation;", "setTransformation", "(Lcom/avito/android/krop/util/Transformation;)V", "transformation", "id", "", "selected", "isLoading", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;ZZLcom/avito/android/krop/util/Transformation;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class UriPhotoItem extends BasePhotoItem {
    @Nullable
    public final Uri d;
    @NotNull
    public final Uri e;
    @Nullable
    public Transformation f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UriPhotoItem(String str, Uri uri, Uri uri2, boolean z, boolean z2, Transformation transformation, int i, j jVar) {
        this(str, uri, uri2, z, z2, (i & 32) != 0 ? null : transformation);
    }

    @Nullable
    public final Uri getImageUri() {
        return this.d;
    }

    @Nullable
    public final Uri getPhotoUri() {
        Uri uri = this.e;
        if (Uris.isNullOrEmpty(uri)) {
            uri = null;
        }
        return uri != null ? uri : this.d;
    }

    @NotNull
    public final Uri getSourceUri() {
        return this.e;
    }

    @Nullable
    public final Transformation getTransformation() {
        return this.f;
    }

    public final void setTransformation(@Nullable Transformation transformation) {
        this.f = transformation;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UriPhotoItem(id=");
        L.append(getStringId());
        L.append(", imageUri=");
        L.append(this.d);
        L.append(", sourceUri=");
        L.append(this.e);
        L.append(')');
        return L.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriPhotoItem(@NotNull String str, @Nullable Uri uri, @NotNull Uri uri2, boolean z, boolean z2, @Nullable Transformation transformation) {
        super(str, z, z2);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri2, "sourceUri");
        this.d = uri;
        this.e = uri2;
        this.f = transformation;
    }
}
