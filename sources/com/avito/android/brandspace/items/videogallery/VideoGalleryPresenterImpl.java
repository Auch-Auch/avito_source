package com.avito.android.brandspace.items.videogallery;

import android.view.View;
import com.avito.android.brandspace.interactor.BrandspaceAnalyticsInteractor;
import com.avito.android.brandspace.items.BlockType;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import com.avito.android.brandspace.presenter.BrandspacePresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenterImpl;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryPresenter;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView;", "view", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView;Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItem;I)V", "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/presenter/BrandspacePresenter;", "brandspacePresenter", "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;", "c", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;", "measurer", "<init>", "(Lcom/avito/android/brandspace/presenter/BrandspacePresenter;Lcom/avito/android/brandspace/interactor/BrandspaceAnalyticsInteractor;Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class VideoGalleryPresenterImpl implements VideoGalleryPresenter {
    public final BrandspacePresenter a;
    public final BrandspaceAnalyticsInteractor b;
    public final VideoGalleryItemView.Measurer c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VideoGalleryPresenterImpl a;
        public final /* synthetic */ VideoGalleryItem b;

        public a(VideoGalleryPresenterImpl videoGalleryPresenterImpl, VideoGalleryItem videoGalleryItem) {
            this.a = videoGalleryPresenterImpl;
            this.b = videoGalleryItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            BrandspaceAnalyticsInteractor.DefaultImpls.trackBlockClick$default(this.a.b, this.b, null, false, 4, null);
            this.a.a.openVideoUrl(this.b.getVideoUrl(), BlockType.BS_VIDEO_GALLERY.getValue());
        }
    }

    @Inject
    public VideoGalleryPresenterImpl(@NotNull BrandspacePresenter brandspacePresenter, @NotNull BrandspaceAnalyticsInteractor brandspaceAnalyticsInteractor, @NotNull VideoGalleryItemView.Measurer measurer) {
        Intrinsics.checkNotNullParameter(brandspacePresenter, "brandspacePresenter");
        Intrinsics.checkNotNullParameter(brandspaceAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        this.a = brandspacePresenter;
        this.b = brandspaceAnalyticsInteractor;
        this.c = measurer;
    }

    public void bindView(@NotNull VideoGalleryItemView videoGalleryItemView, @NotNull VideoGalleryItem videoGalleryItem, int i) {
        a aVar;
        Intrinsics.checkNotNullParameter(videoGalleryItemView, "view");
        Intrinsics.checkNotNullParameter(videoGalleryItem, "item");
        Image image = videoGalleryItem.getImage();
        String title = videoGalleryItem.getTitle();
        String description = videoGalleryItem.getDescription();
        int precalculatedTextHeight = videoGalleryItem.getPrecalculatedTextHeight();
        int textWidth = this.c.getTextWidth();
        String videoUrl = videoGalleryItem.getVideoUrl();
        if (videoUrl != null) {
            boolean z = true;
            if (!(videoUrl.length() > 0)) {
                z = false;
            }
            if (!z) {
                videoUrl = null;
            }
            if (videoUrl != null) {
                aVar = new a(this, videoGalleryItem);
                videoGalleryItemView.bind(image, title, description, precalculatedTextHeight, textWidth, aVar);
            }
        }
        aVar = null;
        videoGalleryItemView.bind(image, title, description, precalculatedTextHeight, textWidth, aVar);
    }
}
