package com.avito.android.extended_profile.adapter.gallery;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.extended_profile.R;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.tns_gallery.TnsGallerySettings;
import com.avito.android.tns_gallery.TnsGalleryView;
import com.avito.android.tns_gallery.TnsGalleryViewImpl;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/gallery/GalleryItemView;", "", "title", "", "showTitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroidx/recyclerview/widget/RecyclerView;", "t", "Landroidx/recyclerview/widget/RecyclerView;", "gallery", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "u", "Lcom/avito/android/tns_gallery/TnsGalleryView;", "getGalleryView", "()Lcom/avito/android/tns_gallery/TnsGalleryView;", "galleryView", "Landroid/view/View;", "rootView", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "imageClicks", "Landroid/app/Activity;", "activity", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lio/reactivex/rxjava3/functions/Consumer;Landroid/app/Activity;Lcom/avito/android/Features;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryItemViewImpl extends BaseViewHolder implements GalleryItemView {
    public final TextView s;
    public final RecyclerView t;
    @NotNull
    public final TnsGalleryView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryItemViewImpl(@NotNull View view, @NotNull Consumer<TnsGalleryItemClickAction> consumer, @NotNull Activity activity, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(consumer, "imageClicks");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(features, "features");
        View findViewById = view.findViewById(R.id.extended_gallery_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.extended_gallery_images);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.t = recyclerView;
        this.u = new TnsGalleryViewImpl(recyclerView, consumer, activity, features, new TnsGallerySettings(135, 0, 0, 10, 6, null));
    }

    @Override // com.avito.android.extended_profile.adapter.gallery.GalleryItemView
    @NotNull
    public TnsGalleryView getGalleryView() {
        return this.u;
    }

    @Override // com.avito.android.extended_profile.adapter.gallery.GalleryItemView
    public void showTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }
}
