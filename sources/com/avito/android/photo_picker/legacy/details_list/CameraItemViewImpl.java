package com.avito.android.photo_picker.legacy.details_list;

import a2.a.a.x1.q.m.k;
import a2.a.a.x1.q.m.l;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.photo_picker.R;
import com.avito.android.photo_picker.legacy.details_list.CameraItemView;
import com.avito.android.remote.model.Size;
import com.avito.android.util.Contexts;
import com.avito.android.util.Dimension;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Rotation;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010p\u001a\u00020\n\u0012\u0006\u0010`\u001a\u00020]¢\u0006\u0006\b\u0001\u0010\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\r\u001a\u00020\u0005*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00020\u0005*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0005*\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\u0016J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0016J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0016J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0016J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0016J\u000f\u0010/\u001a\u00020\u0005H\u0016¢\u0006\u0004\b/\u0010\u0016J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b4\u0010\u0007J\u0017\u00105\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b5\u0010#J-\u00105\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\u0006\u00106\u001a\u00020 2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000507H\u0016¢\u0006\u0004\b5\u00109J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0003H\u0016¢\u0006\u0004\b;\u0010\u0007J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020 H\u0016¢\u0006\u0004\b=\u0010#J\u000f\u0010>\u001a\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010\u0016R\u0018\u0010A\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010@R\u0016\u0010H\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010@R\u0018\u0010L\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010@R\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010@R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010@R\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001e\u0010e\u001a\n b*\u0004\u0018\u00010a0a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010WR\u0016\u0010j\u001a\u00020h8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010iR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010@R\u0016\u0010s\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010rR\u001c\u0010w\u001a\u00020k8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bt\u0010m\u001a\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010@R\u001e\u0010|\u001a\n b*\u0004\u0018\u00010z0z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010{R\u0016\u0010}\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010@R\u0016\u0010~\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010GR\u0018\u0010\u0001\u001a\u0002008V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/CameraItemViewImpl;", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "enabled", "", "w", "(Z)V", "noCameraPermission", "x", "Landroid/view/View;", "Lcom/avito/android/util/Rotation;", "rotation", "t", "(Landroid/view/View;Lcom/avito/android/util/Rotation;)V", "Lcom/avito/android/remote/model/Size;", "portraitSize", "u", "(Landroid/view/View;Lcom/avito/android/util/Rotation;Lcom/avito/android/remote/model/Size;)V", VKApiConst.VERSION, "(Landroid/view/View;)V", "ensureKeyboardHidden", "()V", "previewIsVisible", "setPreviewStubImageVisibility", "isAvailable", "setFlashToggleAvailability", "setCameraToggleAvailability", "setFlashToggleButtonSrcAuto", "setFlashToggleButtonSrcOff", "setFlashToggleButtonSrcOn", "setTakeShotButtonAvailability", "", "text", "setEnablePermissionsButtonText", "(Ljava/lang/String;)V", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "showNoCameraPermissionPlaceholder", "showNoCameraPlaceHolder", "hideCameraPlaceholders", "Landroid/graphics/Bitmap;", "bitmap", "setGalleryButtonSrc", "(Landroid/graphics/Bitmap;)V", "showNoImagesFromGalleryAvailable", "setGalleryButtonHidden", "startCameraShotAnimation", "Lcom/avito/android/util/Dimension;", "previewSize", "setPreviewSize", "(Lcom/avito/android/util/Dimension;)V", "setPlaceholdersBackground", "showMessage", "actionTitle", "Lkotlin/Function0;", "action", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "visible", "setCameraControlsVisible", "description", "setDescription", "hideDescription", "L", "Landroid/view/View;", "scannerFrame", "z", "placeholdersContainer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "noCameraPlaceholder", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "takeShotButton", "D", "noCameraPermissionPlaceholder", "F", "goToGalleryButton", "B", "previewStub", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "cameraDescription", "C", "previewStubIcon", "", "K", "I", "colorBackgroundWhite", "Landroid/widget/Button;", ExifInterface.LONGITUDE_EAST, "Landroid/widget/Button;", "allowAccessButton", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView$Presenter;", "O", "Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView$Presenter;", "presenter", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "H", "Landroid/view/animation/Animation;", "cameraBlinkAnimation", "J", "colorBackgroundGrey", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "flashToggle", "Landroid/view/TextureView;", "s", "Landroid/view/TextureView;", "previewView", "N", "rootView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "galleryButton", "M", "getPreviewSurface", "()Landroid/view/TextureView;", "previewSurface", "y", "galleryButtonContainer", "Landroid/content/Context;", "Landroid/content/Context;", "context", "flashToggleContainer", "cameraToggle", "getDesiredPreviewSize", "()Lcom/avito/android/util/Dimension;", "desiredPreviewSize", "<init>", "(Landroid/view/View;Lcom/avito/android/photo_picker/legacy/details_list/CameraItemView$Presenter;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class CameraItemViewImpl extends BaseViewHolder implements CameraItemView {
    public View A;
    public final View B;
    public final View C;
    public View D;
    public Button E;
    public View F;
    public final TextView G;
    public final Animation H;
    public final Context I;
    public final int J;
    public final int K;
    public final View L;
    @NotNull
    public final TextureView M;
    public final View N;
    public final CameraItemView.Presenter O;
    public final TextureView s;
    public final ImageButton t;
    public final View u;
    public final ImageView v;
    public final ImageButton w;
    public final SimpleDraweeView x;
    public final View y;
    public final View z;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((CameraItemViewImpl) this.b).O.onTakeShotClicked();
            } else if (i == 1) {
                ((CameraItemViewImpl) this.b).O.onFlashToggleClicked();
            } else if (i == 2) {
                ((CameraItemViewImpl) this.b).O.onCameraToggleClicked();
            } else if (i == 3) {
                ((CameraItemViewImpl) this.b).O.onGalleryClicked();
            } else {
                throw null;
            }
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CameraItemViewImpl a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Rotation c;

        public b(CameraItemViewImpl cameraItemViewImpl, View view, Rotation rotation) {
            this.a = cameraItemViewImpl;
            this.b = view;
            this.c = rotation;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Size size = new Size(this.b.getWidth(), this.b.getHeight());
            this.b.setTag(R.id.photo_picker_placeholder_size_tag, size);
            this.a.u(this.b, this.c, size);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraItemViewImpl(@NotNull View view, @NotNull CameraItemView.Presenter presenter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.N = view;
        this.O = presenter;
        View findViewById = view.findViewById(R.id.preview_surface);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.TextureView");
        TextureView textureView = (TextureView) findViewById;
        this.s = textureView;
        View findViewById2 = view.findViewById(R.id.take_shot_button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) findViewById2;
        this.t = imageButton;
        View findViewById3 = view.findViewById(R.id.flash_toggle_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById3;
        View findViewById4 = view.findViewById(R.id.flash_toggle);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById4;
        this.v = imageView;
        View findViewById5 = view.findViewById(R.id.camera_toggle);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton2 = (ImageButton) findViewById5;
        this.w = imageButton2;
        View findViewById6 = view.findViewById(R.id.gallery_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById6;
        this.x = simpleDraweeView;
        View findViewById7 = view.findViewById(R.id.gallery_button_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.y = findViewById7;
        View findViewById8 = view.findViewById(R.id.placeholders_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        this.z = findViewById8;
        View findViewById9 = view.findViewById(R.id.preview_stub);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.B = findViewById9;
        View findViewById10 = view.findViewById(R.id.preview_stub_icon);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.C = findViewById10;
        View findViewById11 = view.findViewById(R.id.camera_preview_description);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.G = (TextView) findViewById11;
        this.H = AnimationUtils.loadAnimation(view.getContext(), R.anim.camera_blink);
        Context context = view.getContext();
        this.I = context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        context.getResources();
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "rootView.context");
        this.J = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray8);
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "rootView.context");
        this.K = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.white);
        this.L = view.findViewById(R.id.scanner_frame_container);
        imageButton.setOnClickListener(new a(0, this));
        imageView.setOnClickListener(new a(1, this));
        imageButton2.setOnClickListener(new a(2, this));
        simpleDraweeView.setOnClickListener(new a(3, this));
        this.M = textureView;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void ensureKeyboardHidden() {
        Keyboards.hideKeyboard$default(this.N, false, 1, null);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    @NotNull
    public Dimension getDesiredPreviewSize() {
        return new Dimension(this.s.getWidth(), this.s.getHeight());
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    @NotNull
    public TextureView getPreviewSurface() {
        return this.M;
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void hideCameraPlaceholders() {
        Views.setVisible(this.z, false);
        w(true);
        Views.setVisible(this.L, true);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void hideDescription() {
        if (this.G.getVisibility() != 8) {
            this.G.animate().alpha(0.0f).setDuration(300).setListener(new AnimatorListenerAdapter(this) { // from class: com.avito.android.photo_picker.legacy.details_list.CameraItemViewImpl$hideDescription$1
                public final /* synthetic */ CameraItemViewImpl a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@Nullable Animator animator) {
                    super.onAnimationEnd(animator);
                    this.a.G.setVisibility(8);
                }
            }).start();
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CameraItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void rotateUi(@NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter(rotation, "rotation");
        for (View view : CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.v, this.w, this.x, this.C})) {
            Views.rotateByShortestPath(view, rotation.getDegree());
        }
        View view2 = this.D;
        if (view2 != null) {
            t(view2, rotation);
        }
        View view3 = this.A;
        if (view3 != null) {
            t(view3, rotation);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setCameraControlsVisible(boolean z2) {
        Views.setVisible(this.u, z2);
        Views.setVisible(this.t, z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setCameraToggleAvailability(boolean z2) {
        this.w.setClickable(z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.G.setText(str);
        this.G.setVisibility(0);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setEnablePermissionsButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Button button = this.E;
        if (button != null) {
            button.setText(str);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setFlashToggleAvailability(boolean z2) {
        this.v.setClickable(z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setFlashToggleButtonSrcAuto() {
        this.v.setImageResource(com.avito.android.ui_components.R.drawable.ic_flash_auto_24);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setFlashToggleButtonSrcOff() {
        this.v.setImageResource(com.avito.android.ui_components.R.drawable.ic_flash_off_24);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setFlashToggleButtonSrcOn() {
        this.v.setImageResource(R.drawable.ic_flash_on_black_24);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setGalleryButtonHidden() {
        Views.hide(this.y);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setGalleryButtonSrc(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        SimpleDraweeViewsKt.getRequestBuilder(this.x).drawable(new BitmapDrawable(this.N.getResources(), bitmap)).load();
        Views.show(this.y);
        this.x.setClickable(true);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setPlaceholdersBackground(boolean z2) {
        if (z2) {
            this.z.setBackgroundColor(this.J);
        } else {
            this.z.setBackgroundColor(this.K);
        }
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setPreviewSize(@NotNull Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "previewSize");
        float width = (float) dimension.getWidth();
        float height = (float) dimension.getHeight();
        float width2 = (float) this.s.getWidth();
        float height2 = (float) this.s.getHeight();
        TextureView textureView = this.s;
        Matrix matrix = new Matrix();
        matrix.setScale(width / width2, height / height2);
        matrix.postTranslate((width2 - width) / 2.0f, (height2 - height) / 2.0f);
        textureView.setTransform(matrix);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setPreviewStubImageVisibility(boolean z2) {
        Views.setVisible(this.B, z2);
        w(!z2);
        Views.setVisible(this.L, !z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void setTakeShotButtonAvailability(boolean z2) {
        this.t.setClickable(z2);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Views.showSnackBar$default(this.N, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void showNoCameraPermissionPlaceholder() {
        if (this.D == null) {
            ViewStub viewStub = (ViewStub) this.N.findViewById(R.id.no_camera_permission_placeholder_stub);
            View inflate = viewStub != null ? viewStub.inflate() : null;
            this.D = inflate;
            if (inflate != null) {
                v(inflate);
            }
            View findViewById = this.N.findViewById(R.id.allow_access_btn);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.Button");
            Button button = (Button) findViewById;
            this.E = button;
            button.setOnClickListener(new k(this));
        }
        x(true);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void showNoCameraPlaceHolder() {
        if (this.A == null) {
            ViewStub viewStub = (ViewStub) this.N.findViewById(R.id.no_camera_placeholder_stub);
            View inflate = viewStub != null ? viewStub.inflate() : null;
            this.A = inflate;
            if (inflate != null) {
                v(inflate);
            }
            View findViewById = this.N.findViewById(R.id.go_to_gallery_button);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            this.F = findViewById;
            findViewById.setOnClickListener(new l(this));
        }
        x(false);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void showNoImagesFromGalleryAvailable() {
        Views.show(this.y);
        this.x.setClickable(true);
        ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(this.x);
        Drawable drawable = this.I.getDrawable(R.drawable.img_gallery_placeholder_48);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(R.dr…gallery_placeholder_48)!!");
        requestBuilder.drawable(drawable).load();
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void startCameraShotAnimation() {
        this.s.startAnimation(this.H);
    }

    public final void t(View view, Rotation rotation) {
        Object tag = view.getTag(R.id.photo_picker_placeholder_size_tag);
        if (tag == null) {
            view.post(new b(this, view, rotation));
        } else {
            u(view, rotation, (Size) tag);
        }
    }

    public final void u(View view, Rotation rotation, Size size) {
        Object tag = view.getTag(R.id.photo_picker_placeholder_real_height_tag);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        View findViewById = view.findViewById(R.id.no_camera_image);
        if ((rotation instanceof Rotation.Rotation_0) || (rotation instanceof Rotation.Rotation_180)) {
            view.getLayoutParams().height = size.getHeight();
            view.getLayoutParams().width = size.getWidth();
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
        } else {
            view.getLayoutParams().height = size.getWidth();
            view.getLayoutParams().width = size.getHeight();
            view.setTranslationX((float) ((size.getWidth() - size.getHeight()) / 2));
            view.setTranslationY((float) ((size.getHeight() - size.getWidth()) / 2));
        }
        Views.setVisible(findViewById, intValue <= view.getLayoutParams().height);
        view.requestLayout();
        Views.rotateByShortestPath(view, rotation.getDegree());
    }

    public final void v(View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        view.measure(makeMeasureSpec, makeMeasureSpec);
        view.setTag(R.id.photo_picker_placeholder_real_height_tag, Integer.valueOf(view.getMeasuredHeight()));
    }

    public final void w(boolean z2) {
        this.t.setClickable(z2);
        this.v.setClickable(z2);
        this.w.setClickable(z2);
        float f = z2 ? 1.0f : 0.4f;
        this.t.setAlpha(f);
        this.v.setAlpha(f);
        this.w.setAlpha(f);
    }

    public final void x(boolean z2) {
        View view = this.D;
        if (view != null) {
            Views.setVisible(view, z2);
        }
        View view2 = this.A;
        if (view2 != null) {
            Views.setVisible(view2, !z2);
        }
        Views.setVisible(this.z, true);
        w(false);
        Views.setVisible(this.L, false);
    }

    @Override // com.avito.android.photo_picker.legacy.details_list.CameraItemView
    public void showMessage(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "actionTitle");
        Intrinsics.checkNotNullParameter(function0, "action");
        Views.showSnackBar$default(this.N, str, 0, str2, 0, function0, (Function0) null, 0, 106, (Object) null);
    }
}
