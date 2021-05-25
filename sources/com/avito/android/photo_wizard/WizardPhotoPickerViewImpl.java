package com.avito.android.photo_wizard;

import a2.a.a.z1.h;
import a2.a.a.z1.i;
import a2.g.r.g;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.avito.android.Features;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.photo_picker.camera.CameraViewport;
import com.avito.android.photo_picker.camera.CameraViewportImpl;
import com.avito.android.photo_wizard.WizardPhotoPickerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Dimension;
import com.avito.android.util.Views;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010r\u001a\u00020o\u0012\u0006\u0010Q\u001a\u00020N¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0015\u001a\u00020\n2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J;\u0010!\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010\u0012J\u000f\u0010*\u001a\u00020\nH\u0016¢\u0006\u0004\b*\u0010\u0012J\u000f\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b+\u0010\u0012J\u0017\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\bH\u0016¢\u0006\u0004\b-\u0010\fJ\u000f\u0010.\u001a\u00020\nH\u0016¢\u0006\u0004\b.\u0010\u0012J\u0017\u00101\u001a\u00020\n2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010>\u001a\b\u0012\u0004\u0012\u000209088\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001e\u0010B\u001a\n 4*\u0004\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010D\u001a\n 4*\u0004\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010AR\u001e\u0010\u001a\u001a\n 4*\u0004\u0018\u00010E0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001e\u0010I\u001a\n 4*\u0004\u0018\u00010E0E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010GR\u001e\u0010M\u001a\n 4*\u0004\u0018\u00010J0J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001e\u0010U\u001a\n 4*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010W\u001a\n 4*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010TR\u001e\u0010Y\u001a\n 4*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010TR\u001e\u0010[\u001a\n 4*\u0004\u0018\u00010?0?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010AR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u001e\u0010_\u001a\n 4*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010TR\u001e\u0010a\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u00106R\u001e\u0010e\u001a\n 4*\u0004\u0018\u00010b0b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010j\u001a\n 4*\u0004\u0018\u00010R0R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bi\u0010TR\u001e\u0010n\u001a\n 4*\u0004\u0018\u00010k0k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u001e\u0010v\u001a\n 4*\u0004\u0018\u00010s0s8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u001e\u0010z\u001a\n 4*\u0004\u0018\u00010w0w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u001e\u0010|\u001a\n 4*\u0004\u0018\u00010k0k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010mR\u001e\u0010~\u001a\n 4*\u0004\u0018\u00010k0k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010mR,\u0010\u0001\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R \u0010\u0001\u001a\n 4*\u0004\u0018\u00010b0b8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010d¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_wizard/WizardPhotoPickerViewImpl;", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView;", "Lcom/avito/android/photo_picker/camera/CameraViewportImpl;", "preview", "()Lcom/avito/android/photo_picker/camera/CameraViewportImpl;", "Lcom/avito/android/util/Dimension;", "getFullPreviewSize", "()Lcom/avito/android/util/Dimension;", "", "titleText", "", "setTitle", "(Ljava/lang/String;)V", "", "iconResId", "setFlashIcon", "(I)V", "hideFlashIcon", "()V", "Lkotlin/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSurfaceMeasureListener", "(Lkotlin/jvm/functions/Function2;)V", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;", "setPhotoWizardViewListener", "(Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;)V", "hint", "maskResId", "", "Lcom/avito/android/photo_wizard/DocumentType;", "types", "Lcom/avito/android/photo_wizard/PictureType;", "type", "showPreview", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/photo_wizard/PictureType;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "actionText", "showTakenPhoto", "(Landroid/net/Uri;Ljava/lang/String;)V", "showLoading", "showError", "enablePreviewControls", "disablePreviewControls", "buttonText", "showPermissionMessage", "hideNoPermission", "", "fade", "fadeTakenPhoto", "(Z)V", "Landroid/widget/ImageButton;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/widget/ImageButton;", "btnClose", "Lio/reactivex/Observable;", "Lcom/avito/android/photo_picker/camera/CameraViewport$FocusArea;", VKApiConst.VERSION, "Lio/reactivex/Observable;", "getFocusObservable", "()Lio/reactivex/Observable;", "focusObservable", "Landroid/widget/LinearLayout;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/LinearLayout;", "photoControls", "c", "permissionContainer", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "title", "Lcom/avito/android/lib/design/spinner/Spinner;", "u", "Lcom/avito/android/lib/design/spinner/Spinner;", "loading", "Lcom/avito/android/Features;", "z", "Lcom/avito/android/Features;", "features", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "previewContainer", "j", "takenPhotoContainer", "p", "previewControls", "l", "togglesContainer", "w", "Lcom/avito/android/photo_wizard/WizardPhotoPickerView$Listener;", "s", "errorContainer", "r", "btnFlash", "Landroid/widget/ImageView;", VKApiConst.Q, "Landroid/widget/ImageView;", "btnTakePhoto", g.a, "Lcom/avito/android/photo_picker/camera/CameraViewportImpl;", "previewViewport", "e", "content", "Lcom/avito/android/lib/design/button/Button;", "t", "Lcom/avito/android/lib/design/button/Button;", "btnRetry", "Landroid/view/View;", "y", "Landroid/view/View;", "view", "Landroid/widget/Button;", "d", "Landroid/widget/Button;", "btnAllowAccess", "Lcom/facebook/drawee/view/SimpleDraweeView;", "k", "Lcom/facebook/drawee/view/SimpleDraweeView;", "takenPhoto", "n", "btnPrimary", "o", "btnSecondary", "x", "Lkotlin/jvm/functions/Function2;", "surfaceMeasureListener", "h", "mask", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public final class WizardPhotoPickerViewImpl implements WizardPhotoPickerView {
    public final ImageButton a;
    public final TextView b;
    public final LinearLayout c;
    public final Button d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final CameraViewportImpl g;
    public final ImageView h;
    public final TextView i;
    public final FrameLayout j;
    public final SimpleDraweeView k;
    public final LinearLayout l;
    public final LinearLayout m;
    public final com.avito.android.lib.design.button.Button n;
    public final com.avito.android.lib.design.button.Button o;
    public final FrameLayout p;
    public final ImageView q;
    public final ImageButton r;
    public final FrameLayout s;
    public final com.avito.android.lib.design.button.Button t;
    public final Spinner u;
    @NotNull
    public final Observable<CameraViewport.FocusArea> v;
    public WizardPhotoPickerView.Listener w;
    public Function2<? super Integer, ? super Integer, Unit> x;
    public final View y;
    public final Features z;

    public WizardPhotoPickerViewImpl(@NotNull View view, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.y = view;
        this.z = features;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.close_button);
        this.a = imageButton;
        this.b = (TextView) view.findViewById(R.id.title);
        this.c = (LinearLayout) view.findViewById(R.id.permission_container);
        Button button = (Button) view.findViewById(R.id.btn_allow_access);
        this.d = button;
        this.e = (FrameLayout) view.findViewById(R.id.content);
        this.f = (FrameLayout) view.findViewById(R.id.preview_container);
        CameraViewportImpl cameraViewportImpl = new CameraViewportImpl(view);
        this.g = cameraViewportImpl;
        this.h = (ImageView) view.findViewById(R.id.mask);
        this.i = (TextView) view.findViewById(R.id.hint);
        this.j = (FrameLayout) view.findViewById(R.id.taken_photo_container);
        this.k = (SimpleDraweeView) view.findViewById(R.id.taken_photo);
        this.l = (LinearLayout) view.findViewById(R.id.toggles_container);
        this.m = (LinearLayout) view.findViewById(R.id.photo_controls);
        com.avito.android.lib.design.button.Button button2 = (com.avito.android.lib.design.button.Button) view.findViewById(R.id.primary_button);
        this.n = button2;
        com.avito.android.lib.design.button.Button button3 = (com.avito.android.lib.design.button.Button) view.findViewById(R.id.secondary_button);
        this.o = button3;
        this.p = (FrameLayout) view.findViewById(R.id.preview_controls);
        ImageView imageView = (ImageView) view.findViewById(R.id.take_photo_button);
        this.q = imageView;
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.flash_button);
        this.r = imageButton2;
        this.s = (FrameLayout) view.findViewById(R.id.error_container);
        com.avito.android.lib.design.button.Button button4 = (com.avito.android.lib.design.button.Button) view.findViewById(R.id.retry_button);
        this.t = button4;
        this.u = (Spinner) view.findViewById(R.id.loading);
        this.v = cameraViewportImpl.getFocusObservable();
        imageButton.setOnClickListener(new g(0, this));
        imageView.setOnClickListener(new g(1, this));
        button2.setOnClickListener(new g(2, this));
        button3.setOnClickListener(new g(3, this));
        imageButton2.setOnClickListener(new g(4, this));
        button4.setOnClickListener(new g(5, this));
        button.setOnClickListener(new g(6, this));
        cameraViewportImpl.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.avito.android.photo_wizard.WizardPhotoPickerViewImpl$initListeners$8
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(@Nullable SurfaceTexture surfaceTexture, int i2, int i3) {
                Dimension fullPreviewSize = WizardPhotoPickerViewImpl.this.getFullPreviewSize();
                Function2 function2 = WizardPhotoPickerViewImpl.this.x;
                if (function2 != null) {
                    Unit unit = (Unit) function2.invoke(Integer.valueOf(fullPreviewSize.getWidth()), Integer.valueOf(fullPreviewSize.getHeight()));
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture surfaceTexture) {
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(@Nullable SurfaceTexture surfaceTexture) {
            }
        });
    }

    public static void a(WizardPhotoPickerViewImpl wizardPhotoPickerViewImpl, boolean z2, boolean z3, boolean z4, boolean z5, int i2) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        if ((i2 & 2) != 0) {
            z3 = false;
        }
        if ((i2 & 4) != 0) {
            z4 = false;
        }
        if ((i2 & 8) != 0) {
            z5 = false;
        }
        Views.setVisible(wizardPhotoPickerViewImpl.p, z2);
        Views.setVisible(wizardPhotoPickerViewImpl.m, z3);
        Views.setVisible(wizardPhotoPickerViewImpl.u, z4);
        Views.setVisible(wizardPhotoPickerViewImpl.s, z5);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void disablePreviewControls() {
        Views.disable(this.q);
        Views.disable(this.r);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void enablePreviewControls() {
        Views.enable(this.q);
        Views.enable(this.r);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void fadeTakenPhoto(boolean z2) {
        if (z2) {
            FrameLayout frameLayout = this.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "takenPhotoContainer");
            Drawable foreground = frameLayout.getForeground();
            Objects.requireNonNull(foreground, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
            ((TransitionDrawable) foreground).startTransition(200);
            return;
        }
        FrameLayout frameLayout2 = this.j;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "takenPhotoContainer");
        Drawable foreground2 = frameLayout2.getForeground();
        Objects.requireNonNull(foreground2, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) foreground2).reverseTransition(200);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    @NotNull
    public Observable<CameraViewport.FocusArea> getFocusObservable() {
        return this.v;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    @NotNull
    public Dimension getFullPreviewSize() {
        FrameLayout frameLayout = this.e;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "content");
        if (frameLayout.getMeasuredWidth() > 0) {
            FrameLayout frameLayout2 = this.e;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "content");
            if (frameLayout2.getMeasuredHeight() > 0) {
                FrameLayout frameLayout3 = this.e;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "content");
                int measuredWidth = frameLayout3.getMeasuredWidth();
                FrameLayout frameLayout4 = this.e;
                Intrinsics.checkNotNullExpressionValue(frameLayout4, "content");
                return new Dimension(measuredWidth, frameLayout4.getMeasuredHeight());
            }
        }
        this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        FrameLayout frameLayout5 = this.e;
        Intrinsics.checkNotNullExpressionValue(frameLayout5, "content");
        int measuredWidth2 = frameLayout5.getMeasuredWidth();
        FrameLayout frameLayout6 = this.e;
        Intrinsics.checkNotNullExpressionValue(frameLayout6, "content");
        return new Dimension(measuredWidth2, frameLayout6.getMeasuredHeight());
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void hideFlashIcon() {
        Views.setVisible(this.r, false);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void hideNoPermission() {
        Views.setVisible(this.c, false);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void setFlashIcon(int i2) {
        Views.setVisible(this.r, true);
        this.r.setImageResource(i2);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void setPhotoWizardViewListener(@Nullable WizardPhotoPickerView.Listener listener) {
        this.w = listener;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void setSurfaceMeasureListener(@Nullable Function2<? super Integer, ? super Integer, Unit> function2) {
        this.x = function2;
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void setTitle(@Nullable String str) {
        TextView textView = this.b;
        Intrinsics.checkNotNullExpressionValue(textView, "title");
        textView.setText(str);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void showError() {
        a(this, false, false, false, true, 7);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void showLoading() {
        a(this, false, false, true, false, 11);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void showPermissionMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        Views.setVisible(this.c, true);
        Button button = this.d;
        Intrinsics.checkNotNullExpressionValue(button, "btnAllowAccess");
        button.setText(str);
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void showPreview(@Nullable String str, @DrawableRes @Nullable Integer num, @NotNull List<DocumentType> list, @NotNull PictureType pictureType) {
        Intrinsics.checkNotNullParameter(list, "types");
        Intrinsics.checkNotNullParameter(pictureType, "type");
        enablePreviewControls();
        Views.setVisible(this.f, true);
        Views.setVisible(this.j, false);
        FrameLayout frameLayout = this.f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "previewContainer");
        int height = frameLayout.getHeight();
        int height2 = getFullPreviewSize().getHeight();
        int i2 = pictureType == PictureType.HORIZONTAL ? (int) (((float) height2) * 0.6f) : height2;
        if (height != i2) {
            FrameLayout frameLayout2 = this.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "takenPhotoContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "takenPhotoContainer.layoutParams");
            layoutParams.height = i2;
            FrameLayout frameLayout3 = this.j;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "takenPhotoContainer");
            frameLayout3.setLayoutParams(layoutParams);
            ValueAnimator ofInt = ValueAnimator.ofInt(height, i2);
            Intrinsics.checkNotNullExpressionValue(ofInt, "valueAnimator");
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new i(this, ofInt));
            ofInt.start();
            CameraViewportImpl cameraViewportImpl = this.g;
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, ((float) height2) / ((float) i2));
            cameraViewportImpl.transformViewport(matrix);
        }
        a(this, true, false, false, false, 14);
        if (!this.z.getOwnerWizardLocalMasks().invoke().booleanValue() || num == null) {
            Views.hide(this.h);
            TextView textView = this.i;
            Intrinsics.checkNotNullExpressionValue(textView, "this.hint");
            textView.setText(str);
        } else {
            this.h.setImageDrawable(ContextCompat.getDrawable(this.y.getContext(), num.intValue()));
            Views.show(this.h);
        }
        if (list.size() > 1) {
            this.l.removeAllViews();
            Views.setVisible(this.l, true);
            LayoutInflater from = LayoutInflater.from(this.y.getContext());
            for (T t2 : list) {
                View inflate = from.inflate(R.layout.view_document_type_bubble, (ViewGroup) this.l, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView2 = (TextView) inflate;
                textView2.setText(t2.getName());
                if (t2.isSelected()) {
                    textView2.setSelected(true);
                }
                textView2.setOnClickListener(new h(t2, this, from));
                this.l.addView(textView2);
            }
        }
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    public void showTakenPhoto(@NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(str, "actionText");
        Views.setVisible(this.f, false);
        Views.setVisible(this.l, false);
        Views.setVisible(this.j, true);
        this.n.setText(str);
        a(this, false, true, false, false, 13);
        Fresco.getImagePipeline().evictFromCache(uri);
        this.k.setImageURI(uri, this.y.getContext());
    }

    @Override // com.avito.android.photo_wizard.WizardPhotoPickerView
    @NotNull
    public CameraViewportImpl preview() {
        return this.g;
    }
}
