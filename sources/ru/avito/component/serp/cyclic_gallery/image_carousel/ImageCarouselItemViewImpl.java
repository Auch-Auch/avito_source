package ru.avito.component.serp.cyclic_gallery.image_carousel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.design.widget.RatioFrameLayout;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.Picture;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b>\u0010?J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010%R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010*R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006@"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarouselItemView;", "", "widthRatio", "", "setWidthRatio", "(F)V", "Lcom/avito/android/image_loader/Picture;", "image", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "isVideoPreview", "setIsVideoPreview", "(Z)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/graphics/drawable/Drawable;", "t", "()Landroid/graphics/drawable/Drawable;", "Lcom/avito/android/design/widget/RatioFrameLayout;", "s", "Lcom/avito/android/design/widget/RatioFrameLayout;", "ratioContainer", "Lcom/avito/android/image_loader/ForegroundConverter;", "B", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", VKApiConst.VERSION, "Lcom/avito/android/image_loader/Picture;", "w", "Landroid/graphics/drawable/Drawable;", "videoOverlay", "Landroid/view/View;", "C", "Landroid/view/View;", "view", "u", DownloadService.KEY_FOREGROUND, "y", "Ljava/lang/Float;", "z", "Z", "withVideoPreview", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "x", "Lcom/facebook/drawee/drawable/ScaleTypeDrawable;", "failureImage", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageCarouselItemViewImpl extends BaseViewHolder implements ImageCarouselItemView {
    public Function0<Unit> A;
    public final ForegroundConverter B = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public final View C;
    public final RatioFrameLayout s;
    public final SimpleDraweeView t;
    public Drawable u;
    public Picture v;
    public final Drawable w;
    public final ScaleTypeDrawable x;
    public Float y;
    public boolean z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCarouselItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.C = view;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.design.widget.RatioFrameLayout");
        this.s = (RatioFrameLayout) view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
        this.t = simpleDraweeView;
        Drawable drawable = Views.getDrawable(view, R.drawable.gallery_video_overlay);
        ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER;
        this.w = new ScaleTypeDrawable(drawable, scaleType);
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(Views.getDrawable(view, R.drawable.ic_stub_grey), scaleType);
        this.x = scaleTypeDrawable;
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setFailureImage(scaleTypeDrawable);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.C);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.A;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemView
    public void setImage(@Nullable Picture picture) {
        this.v = picture;
        ForegroundConverter foregroundConverter = this.B;
        Context context = this.C.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.u = ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null);
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, t(), 2, null);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemView
    public void setIsVideoPreview(boolean z2) {
        this.z = z2;
        SimpleDraweeViewsKt.loadPicture$default(this.t, this.v, null, t(), 2, null);
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.A = function0;
    }

    @Override // ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemView
    public void setWidthRatio(float f) {
        if (!Intrinsics.areEqual(this.y, f)) {
            this.s.setRatio(f);
            this.s.requestLayout();
            this.y = Float.valueOf(f);
        }
    }

    public final Drawable t() {
        ArrayList arrayList = new ArrayList();
        if (this.z) {
            arrayList.add(this.w);
        }
        Drawable drawable = this.u;
        if (drawable != null) {
            arrayList.add(drawable);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Drawable) arrayList.get(0);
        }
        Object[] array = arrayList.toArray(new Drawable[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new LayerDrawable((Drawable[]) array);
    }
}
