package com.avito.android.advert.item.photogallery;

import android.content.Context;
import android.view.View;
import com.avito.android.Features;
import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert_core.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.photo_gallery.ui.PhotoGallery;
import com.avito.android.recycler.base.DestroyableViewHolder;
import com.avito.android.remote.model.AutotekaCpoTeaser;
import com.avito.android.remote.model.AutotekaTeaserResponseKt;
import com.avito.android.remote.model.AutotekaTeaserResult;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0001\u0010\u001e\u001a\u00020\u001d2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010#J\u000f\u0010$\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u001dH\u0016¢\u0006\u0004\b&\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104¨\u0006<"}, d2 = {"Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/photogallery/AdvertDetailsGalleryView;", "Lcom/avito/android/recycler/base/DestroyableViewHolder;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/AutotekaCpoTeaser;", "cpoTeaser", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "advertDetailsDelegate", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "advertDetailsGalleryActionHandler", "", "currentPosition", "", "stateId", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/AutotekaTeaserResult;", "autotekaTeaser", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;Lcom/avito/android/remote/model/AutotekaCpoTeaser;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;Lcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;IJLcom/avito/android/analytics/screens/Screen;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/AutotekaTeaserResult;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "removeListener", "()V", "destroy", "Lcom/avito/android/analytics/Analytics;", VKApiConst.VERSION, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "s", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "photoGallery", "Lcom/avito/android/util/ImplicitIntentFactory;", "u", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "t", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "galleryActionListener", "Landroid/view/View;", "view", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsGalleryViewImpl extends BaseViewHolder implements AdvertDetailsGalleryView, DestroyableViewHolder {
    public final PhotoGallery s;
    public GalleryActionListener t;
    public final ImplicitIntentFactory u;
    public final Analytics v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ AdvertDetailsGalleryViewImpl a;

        public a(AdvertDetailsGalleryViewImpl advertDetailsGalleryViewImpl) {
            this.a = advertDetailsGalleryViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.s.getCurrentItem() instanceof GalleryItem.GalleryVideo) {
                GalleryActionListener galleryActionListener = this.a.t;
                if (galleryActionListener != null) {
                    galleryActionListener.onVideoGalleryClick(this.a.s.getPager().getCurrentItem());
                }
            } else if (this.a.s.canShowFullscreen(this.a.s.getCurrentItem())) {
                GalleryActionListener galleryActionListener2 = this.a.t;
                if (galleryActionListener2 != null) {
                    galleryActionListener2.onPhotoGalleryClick(this.a.s.getPager().getCurrentItem());
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                ToastsKt.showToast$default(context, R.string.network_unavailable_message, 0, 2, (Object) null);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsGalleryViewImpl(@NotNull View view, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.u = implicitIntentFactory;
        this.v = analytics;
        View findViewById = view.findViewById(com.avito.android.photo_gallery.R.id.gallery_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.av…lery.R.id.gallery_holder)");
        PhotoGallery photoGallery = (PhotoGallery) findViewById;
        this.s = photoGallery;
        photoGallery.getPager().setOnClickListener(new a(this));
    }

    @Override // com.avito.android.advert.item.photogallery.AdvertDetailsGalleryView
    public void bindGallery(@Nullable List<Image> list, @Nullable Video video, @Nullable AutotekaCpoTeaser autotekaCpoTeaser, @Nullable String str, @NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, long j, @NotNull Screen screen, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserResult autotekaTeaserResult) {
        Intrinsics.checkNotNullParameter(advertDetailsFragmentDelegate, "advertDetailsDelegate");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.t = galleryActionListener;
        PhotoGallery.initGallery$default(this.s, advertDetailsFragmentDelegate.childFragmentManager(), video, list, str, this.u, this.v, null, galleryPageListener, i, j, true, true, screen, foregroundImage, null, autotekaTeaserResult != null ? AutotekaTeaserResponseKt.toAutotekaTeaserGalleryModel(autotekaTeaserResult) : null, 16448, null);
        if (i > -1) {
            setCurrentPosition(i);
        } else {
            setCurrentPosition(0);
        }
    }

    @Override // com.avito.android.advert.item.photogallery.AdvertDetailsGalleryView
    public int currentPosition() {
        return this.s.getPager().getCurrentItem();
    }

    @Override // com.avito.android.recycler.base.DestroyableViewHolder
    public void destroy() {
        this.s.destroy();
    }

    @Override // com.avito.android.advert.item.photogallery.AdvertDetailsGalleryView
    public void removeListener() {
    }

    @Override // com.avito.android.advert.item.photogallery.AdvertDetailsGalleryView
    public void setCurrentPosition(int i) {
        PhotoGallery.setCurrentItem$default(this.s, i, true, false, 4, null);
    }
}
