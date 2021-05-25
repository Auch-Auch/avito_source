package com.avito.android.photo_gallery.ui;

import android.view.View;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorView;", "", "", "isRedesign", "", "setIsRedesign", "(Z)V", "", VKApiConst.POSITION, "count", "setPage", "(ILjava/lang/Integer;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public interface GalleryPageIndicatorView {
    @NotNull
    View getView();

    void setIsRedesign(boolean z);

    void setPage(int i, @Nullable Integer num);
}
