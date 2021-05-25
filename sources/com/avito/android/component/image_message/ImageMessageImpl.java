package com.avito.android.component.image_message;

import a2.g.r.g;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.avito.android.component.circular_action_progress.CircularActionProgressImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0014\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00070\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u0017\u001a\u0004\b.\u0010\u0019¨\u00064"}, d2 = {"Lcom/avito/android/component/image_message/ImageMessageImpl;", "Lcom/avito/android/component/image_message/ImageMessage;", "Lcom/avito/android/image_loader/Picture;", "picture", "thumbnail", "Lcom/avito/android/image_loader/ImageRequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setImage", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/Picture;Lcom/avito/android/image_loader/ImageRequestListener;)V", "showProgress", "()V", "hideProgress", "showError", "hideError", "Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "d", "Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "getProgress", "()Lcom/avito/android/component/circular_action_progress/CircularActionProgressImpl;", "progress", "Lio/reactivex/rxjava3/core/Observable;", "e", "Lio/reactivex/rxjava3/core/Observable;", "getCancelClicks", "()Lio/reactivex/rxjava3/core/Observable;", "cancelClicks", "Landroid/widget/FrameLayout;", AuthSource.SEND_ABUSE, "Landroid/widget/FrameLayout;", "imageContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "image", "f", "getErrorClicks", "errorClicks", "h", "getImageLongClicks", "imageLongClicks", "Landroid/widget/ImageButton;", "c", "Landroid/widget/ImageButton;", "errorButton", g.a, "getImageClicks", "imageClicks", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ImageMessageImpl implements ImageMessage {
    public final FrameLayout a;
    public final SimpleDraweeView b;
    public final ImageButton c;
    @NotNull
    public final CircularActionProgressImpl d;
    @NotNull
    public final Observable<Unit> e = getProgress().getCancelActionClicks();
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<Unit> h;

    public ImageMessageImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.a = frameLayout;
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.error_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById3;
        this.c = imageButton;
        View findViewById4 = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = new CircularActionProgressImpl(findViewById4);
        this.f = RxView.clicks(imageButton);
        this.g = RxView.clicks(frameLayout);
        this.h = RxView.longClicks$default(frameLayout, null, 1, null);
        getProgress().stopProgress();
        getProgress().setBackground(view.getContext().getDrawable(R.drawable.bg_image_message_progress_background));
        getProgress().setCancelable(true);
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    @NotNull
    public Observable<Unit> getCancelClicks() {
        return this.e;
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    @NotNull
    public Observable<Unit> getErrorClicks() {
        return this.f;
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    @NotNull
    public Observable<Unit> getImageClicks() {
        return this.g;
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    @NotNull
    public Observable<Unit> getImageLongClicks() {
        return this.h;
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    public void hideError() {
        Views.hide(this.c);
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    public void hideProgress() {
        getProgress().stopProgress();
        getProgress().hide();
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    public void setImage(@NotNull Picture picture, @Nullable Picture picture2, @Nullable ImageRequestListener imageRequestListener) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        ImageRequest.Builder picture3 = SimpleDraweeViewsKt.getRequestBuilder(this.b).picture(picture);
        if (picture2 != null) {
            picture3.lowResPicture(picture2);
        }
        if (imageRequestListener != null) {
            picture3.listener(imageRequestListener);
        }
        picture3.load();
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    public void showError() {
        Views.show(this.c);
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    public void showProgress() {
        getProgress().show();
        getProgress().startProgress();
    }

    @Override // com.avito.android.component.image_message.ImageMessage
    @NotNull
    public CircularActionProgressImpl getProgress() {
        return this.d;
    }
}
