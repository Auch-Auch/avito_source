package com.avito.android.photo_gallery.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.lib.design.page_indicator.PageIndicator;
import com.avito.android.photo_gallery.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorDots;", "Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorView;", "", "isRedesign", "", "setIsRedesign", "(Z)V", "", VKApiConst.POSITION, "count", "setPage", "(ILjava/lang/Integer;)V", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "getView", "()Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "view", "Landroid/view/ViewGroup;", "parent", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "<init>", "(Landroid/view/ViewGroup;Landroidx/viewpager/widget/ViewPager;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPageIndicatorDots implements GalleryPageIndicatorView {
    @NotNull
    public final PageIndicator a;

    public GalleryPageIndicatorDots(@NotNull ViewGroup viewGroup, @NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.page_indicator_dots, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.page_indicator.PageIndicator");
        this.a = (PageIndicator) inflate;
        viewGroup.addView(getView());
        getView().attachToViewPager(viewPager);
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    public void setIsRedesign(boolean z) {
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    public void setPage(int i, @Nullable Integer num) {
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    @NotNull
    public PageIndicator getView() {
        return this.a;
    }
}
