package com.avito.android.photo_picker.gallery.gallery_list;

import android.net.Uri;
import com.avito.android.photo_picker.legacy.thumbnail_list.BasePhotoItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryUriPhotoItem;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "", "e", "Ljava/lang/String;", "getFolderName", "()Ljava/lang/String;", "folderName", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "imageUri", "", "f", "I", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "selectedPosition", "id", "", "isLoading", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;IZ)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryUriPhotoItem extends BasePhotoItem {
    @NotNull
    public final Uri d;
    @NotNull
    public final String e;
    public int f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GalleryUriPhotoItem(String str, Uri uri, String str2, int i, boolean z, int i2, j jVar) {
        this(str, uri, str2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z);
    }

    @NotNull
    public final String getFolderName() {
        return this.e;
    }

    @NotNull
    public final Uri getImageUri() {
        return this.d;
    }

    public final int getSelectedPosition() {
        return this.f;
    }

    public final void setSelectedPosition(int i) {
        this.f = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryUriPhotoItem(@NotNull String str, @NotNull Uri uri, @NotNull String str2, int i, boolean z) {
        super(str, i > 0, z);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(uri, "imageUri");
        Intrinsics.checkNotNullParameter(str2, "folderName");
        this.d = uri;
        this.e = str2;
        this.f = i;
    }
}
