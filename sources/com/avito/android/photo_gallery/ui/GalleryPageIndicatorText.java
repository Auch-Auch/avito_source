package com.avito.android.photo_gallery.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.photo_gallery.R;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorText;", "Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorView;", "", "isRedesign", "", "setIsRedesign", "(Z)V", "", VKApiConst.POSITION, "count", "setPage", "(ILjava/lang/Integer;)V", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "getView", "()Landroid/widget/TextView;", "view", AuthSource.SEND_ABUSE, "I", "resPageIndicator", "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/view/ViewGroup;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryPageIndicatorText implements GalleryPageIndicatorView {
    public int a = R.string.current_page_indicator;
    @NotNull
    public final TextView b;

    public GalleryPageIndicatorText(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.page_indicator_text, viewGroup, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) inflate;
        viewGroup.addView(getView());
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    public void setIsRedesign(boolean z) {
        int i;
        if (z) {
            i = R.string.rds_current_page_indicator;
        } else {
            i = R.string.current_page_indicator;
        }
        this.a = i;
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    public void setPage(int i, @Nullable Integer num) {
        getView().setText(getView().getResources().getString(this.a, Integer.valueOf(i + 1), num));
    }

    @Override // com.avito.android.photo_gallery.ui.GalleryPageIndicatorView
    @NotNull
    public TextView getView() {
        return this.b;
    }
}
