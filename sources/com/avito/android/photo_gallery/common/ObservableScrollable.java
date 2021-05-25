package com.avito.android.photo_gallery.common;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/photo_gallery/common/ObservableScrollable;", "", "Lcom/avito/android/photo_gallery/common/OnScrollChangedListener;", "callback", "", "addOnScrollChangedListener", "(Lcom/avito/android/photo_gallery/common/OnScrollChangedListener;)V", "removeOnScrollChangedListener", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public interface ObservableScrollable {
    void addOnScrollChangedListener(@Nullable OnScrollChangedListener onScrollChangedListener);

    void removeOnScrollChangedListener(@Nullable OnScrollChangedListener onScrollChangedListener);
}
