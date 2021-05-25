package com.avito.android.brandspace.items.videogallery;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.brandspace.items.videogallery.VideoGalleryItemView;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\"\u0010#JE\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006%"}, d2 = {"Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "", "precalculatedTextHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "Landroid/view/View$OnClickListener;", "imageClickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;IILandroid/view/View$OnClickListener;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", VKApiConst.VERSION, "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "imageContainer", "w", "textContainer", "<init>", "(Landroid/view/View;)V", "MeasurerImpl", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class VideoGalleryItemViewImpl extends BaseViewHolder implements VideoGalleryItemView {
    public final ViewGroup s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final ViewGroup w;
    public final View x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0019\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemViewImpl$MeasurerImpl;", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Measurer;", "", "title", "description", "Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Layout;", "measure", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/videogallery/VideoGalleryItemView$Layout;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "titleParams", AuthSource.SEND_ABUSE, "I", "getTextWidth", "textWidth", "c", "descriptionParams", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "d", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "textMeasurer", "Landroid/view/View;", "view", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "resources", "<init>", "(Landroid/view/View;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class MeasurerImpl implements VideoGalleryItemView.Measurer {
        public final int a;
        public final TextMeasurer.TextParams b;
        public final TextMeasurer.TextParams c;
        public final TextMeasurer d;

        public MeasurerImpl(@NotNull View view, @NotNull TextMeasurer textMeasurer, @NotNull DeviceMetrics deviceMetrics, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
            Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
            Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "resources");
            this.d = textMeasurer;
            this.a = deviceMetrics.getDisplayWidth() - (brandspaceResourcesProvider.getContentHorizontalPadding() * 2);
            VideoGalleryItemViewImpl videoGalleryItemViewImpl = new VideoGalleryItemViewImpl(view);
            this.b = textMeasurer.createTextParams(videoGalleryItemViewImpl.u, getTextWidth());
            this.c = textMeasurer.createTextParams(videoGalleryItemViewImpl.v, getTextWidth());
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(MeasurerImpl.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.brandspace.items.videogallery.VideoGalleryItemViewImpl.MeasurerImpl");
            MeasurerImpl measurerImpl = (MeasurerImpl) obj;
            return !(Intrinsics.areEqual(this.b, measurerImpl.b) ^ true) && !(Intrinsics.areEqual(this.c, measurerImpl.c) ^ true);
        }

        @Override // com.avito.android.brandspace.items.videogallery.VideoGalleryItemView.Measurer
        public int getTextWidth() {
            return this.a;
        }

        public int hashCode() {
            return this.c.hashCode() + (this.b.hashCode() * 31);
        }

        @Override // com.avito.android.brandspace.items.videogallery.VideoGalleryItemView.Measurer
        @NotNull
        public VideoGalleryItemView.Layout measure(@Nullable String str, @Nullable String str2) {
            return new VideoGalleryItemView.Layout(this.d.measure(str, this.b), this.d.measure(str2, this.c));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoGalleryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        View findViewById = view.findViewById(R.id.image_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image_container)");
        this.s = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.image)");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.title)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.description)");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.text_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.text_container)");
        this.w = (ViewGroup) findViewById5;
    }

    @Override // com.avito.android.brandspace.items.videogallery.VideoGalleryItemView
    public void bind(@NotNull Image image, @Nullable String str, @Nullable String str2, int i, int i2, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(image, "image");
        TextViews.bindText$default(this.u, str, false, 2, null);
        TextViews.bindText$default(this.v, str2, false, 2, null);
        this.w.getLayoutParams().height = i;
        this.x.getLayoutParams().width = i2;
        if (onClickListener != null) {
            this.s.setOnClickListener(onClickListener);
        } else {
            this.s.setClickable(false);
        }
        this.t.setAspectRatio(Images.aspectRatio(image, 1.794f));
        SimpleDraweeViewsKt.getRequestBuilder(this.t).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).cancelOnDetach(false).load();
    }
}
