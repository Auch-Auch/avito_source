package com.avito.android.image_loader;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/image_loader/ImageRequestListener;", "", "", "onStarted", "()V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onLoaded", "(II)V", "onFailed", "image-loader_release"}, k = 1, mv = {1, 4, 2})
public interface ImageRequestListener {
    void onFailed();

    void onLoaded(int i, int i2);

    void onStarted();
}
