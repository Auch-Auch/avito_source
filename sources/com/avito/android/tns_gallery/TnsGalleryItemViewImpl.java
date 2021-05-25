package com.avito.android.tns_gallery;

import android.view.View;
import android.widget.ImageView;
import com.avito.android.Features;
import com.avito.android.image_loader.Picture;
import com.avito.android.tns_core.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0019¨\u00060"}, d2 = {"Lcom/avito/android/tns_gallery/TnsGalleryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tns_gallery/TnsGalleryItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/android/image_loader/Picture;", "picture", "showImage", "(Lcom/avito/android/image_loader/Picture;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setContainerSize", "(II)V", "", "isImageFitsContainer", "setImageMustFitContainer", "(Z)V", "Landroid/view/View;", "w", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "Lio/reactivex/rxjava3/core/Observable;", VKApiConst.VERSION, "Lio/reactivex/rxjava3/core/Observable;", "getItemClicks", "()Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "t", "container", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "tns-core_release"}, k = 1, mv = {1, 4, 2})
public final class TnsGalleryItemViewImpl extends BaseViewHolder implements TnsGalleryItemView {
    public final SimpleDraweeView s;
    public final View t;
    public Function0<Unit> u;
    @NotNull
    public final Observable<Unit> v;
    @NotNull
    public final View w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TnsGalleryItemViewImpl(@NotNull View view, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.w = view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.image_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById2;
        findViewById2.setClipToOutline(true);
        this.v = RxView.clicks(findViewById2);
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemView
    @NotNull
    public Observable<Unit> getItemClicks() {
        return this.v;
    }

    @NotNull
    public final View getView() {
        return this.w;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemView
    public void setContainerSize(int i, int i2) {
        this.t.getLayoutParams().width = i;
        this.t.getLayoutParams().height = i2;
        this.t.requestLayout();
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemView
    public void setImageMustFitContainer(boolean z) {
        if (z) {
            this.s.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            this.s.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }

    @Override // com.avito.android.tns_gallery.TnsGalleryItemView
    public void showImage(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        SimpleDraweeViewsKt.getRequestBuilder(this.s).backgroundColorReceiver(this.s.getScaleType() == ImageView.ScaleType.FIT_CENTER ? new TnsGalleryItemViewImpl$showImage$receiver$1(this) : null).picture(picture).load();
    }
}
