package com.avito.android.developments_catalog.items.photoGallery;

import android.content.Context;
import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.UncoveredScreen;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentManagerDelegate;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.photo_gallery.ui.PhotoGallery;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b'\u0010(JK\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/photoGallery/PhotoGalleryView;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;", "fragmentManagerDelegate", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "galleryActionListener", "", "currentPosition", "", "stateId", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentManagerDelegate;Lcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;IJ)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "t", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "Lcom/avito/android/util/ImplicitIntentFactory;", "u", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/analytics/Analytics;", VKApiConst.VERSION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "s", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "photoGallery", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGalleryViewImpl extends BaseViewHolder implements PhotoGalleryView {
    public final PhotoGallery s;
    public GalleryActionListener t;
    public final ImplicitIntentFactory u;
    public final Analytics v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PhotoGalleryViewImpl a;

        public a(PhotoGalleryViewImpl photoGalleryViewImpl) {
            this.a = photoGalleryViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.s.canShowFullscreen(this.a.s.getCurrentItem())) {
                GalleryActionListener galleryActionListener = this.a.t;
                if (galleryActionListener != null) {
                    galleryActionListener.onPhotoGalleryClick(this.a.s.getPager().getCurrentItem());
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            ToastsKt.showToast$default(context, R.string.network_unavailable_message, 0, 2, (Object) null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoGalleryViewImpl(@NotNull View view, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.u = implicitIntentFactory;
        this.v = analytics;
        View findViewById = view.findViewById(com.avito.android.photo_gallery.R.id.gallery_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.av…lery.R.id.gallery_holder)");
        PhotoGallery photoGallery = (PhotoGallery) findViewById;
        this.s = photoGallery;
        photoGallery.getPager().setOnClickListener(new a(this));
    }

    @Override // com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryView
    public void bindGallery(@Nullable List<Image> list, @NotNull DevelopmentsCatalogFragmentManagerDelegate developmentsCatalogFragmentManagerDelegate, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, long j) {
        Intrinsics.checkNotNullParameter(developmentsCatalogFragmentManagerDelegate, "fragmentManagerDelegate");
        this.t = galleryActionListener;
        PhotoGallery.initGallery$default(this.s, developmentsCatalogFragmentManagerDelegate.childFragmentManager(), null, list, null, this.u, this.v, null, galleryPageListener, i, j, true, false, UncoveredScreen.INSTANCE, null, null, null, 24640, null);
        if (i > -1) {
            setCurrentPosition(i);
        } else {
            setCurrentPosition(0);
        }
    }

    @Override // com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryView
    public int currentPosition() {
        return this.s.getPager().getCurrentItem();
    }

    @Override // com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryView
    public void setCurrentPosition(int i) {
        PhotoGallery.setCurrentItem$default(this.s, i, false, false, 4, null);
    }
}
