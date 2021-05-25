package com.avito.android.photo_picker.legacy.thumbnail_list;

import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ResourcePhotoItem;", "Lcom/avito/android/photo_picker/legacy/thumbnail_list/BasePhotoItem;", "", "d", "I", "getDrawableId", "()I", "drawableId", "", "id", "", "selected", "<init>", "(Ljava/lang/String;IZ)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ResourcePhotoItem extends BasePhotoItem {
    public final int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResourcePhotoItem(@NotNull String str, @DrawableRes int i, boolean z) {
        super(str, z, false, 4, null);
        Intrinsics.checkNotNullParameter(str, "id");
        this.d = i;
    }

    public final int getDrawableId() {
        return this.d;
    }
}
