package com.sumsub.sns.camera;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.transition.TransitionManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;
import com.sumsub.sns.camera.SNSCameraViewModel;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.DocumentPickerResult;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.base.Event;
import com.transitionseverywhere.Crossfade;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 2*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u00012B\u0007¢\u0006\u0004\b1\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0015H$¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H$¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0015H$¢\u0006\u0004\b\u001b\u0010\u0017J\u000f\u0010\u001d\u001a\u00020\u001cH$¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH$¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H$¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001cH$¢\u0006\u0004\b%\u0010\u001eJ\u000f\u0010&\u001a\u00020\u0015H$¢\u0006\u0004\b&\u0010\u0017J\u000f\u0010(\u001a\u00020'H$¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\"H$¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020'H$¢\u0006\u0004\b+\u0010)J\u000f\u0010,\u001a\u00020'H$¢\u0006\u0004\b,\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraActivity;", "Lcom/sumsub/sns/camera/SNSCameraViewModel;", "VM", "Lcom/sumsub/sns/core/presentation/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "initCamera", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Lcom/otaliastudios/cameraview/CameraView;", "getCameraView", "()Lcom/otaliastudios/cameraview/CameraView;", "getTakePicture", "Landroid/widget/ImageButton;", "getFlashButton", "()Landroid/widget/ImageButton;", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "Landroid/view/ViewGroup;", "getToolbar", "()Landroid/view/ViewGroup;", "getCloseButton", "getHelper", "Landroid/widget/TextView;", "getHelperTitle", "()Landroid/widget/TextView;", "getHelperDetailsFrame", "getHelperBrief", "getHelperDetails", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "f", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "processor", "<init>", "Companion", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSCameraActivity<VM extends SNSCameraViewModel> extends BaseActivity<VM> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_APPLICANT = "EXTRA_APPLICANT";
    @NotNull
    public static final String EXTRA_DOCUMENT_SIDE = "EXTRA_DOCUMENT_SIDE";
    @NotNull
    public static final String EXTRA_DOCUMENT_TYPE = "EXTRA_DOCUMENT_TYPE";
    @NotNull
    public static final String EXTRA_ONLY_ID_DOC = "EXTRA_ONLY_ID_DOC";
    public final FrameProcessor f = new b(this);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraActivity$Companion;", "", "", SNSCameraActivity.EXTRA_APPLICANT, "Ljava/lang/String;", SNSCameraActivity.EXTRA_DOCUMENT_SIDE, SNSCameraActivity.EXTRA_DOCUMENT_TYPE, SNSCameraActivity.EXTRA_ONLY_ID_DOC, "", "REQUEST_CAMERA_PERMISSION", "I", "<init>", "()V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Flash.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
        }
    }

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
                SNSCameraActivity.access$getViewModel$p((SNSCameraActivity) this.b).onBackClicked();
            } else if (i == 1) {
                SNSCameraActivity.access$getViewModel$p((SNSCameraActivity) this.b).onTakePictureClicked();
            } else if (i == 2) {
                SNSCameraViewModel access$getViewModel$p = SNSCameraActivity.access$getViewModel$p((SNSCameraActivity) this.b);
                Flash flash = ((SNSCameraActivity) this.b).getCameraView().getFlash();
                Intrinsics.checkNotNullExpressionValue(flash, "getCameraView().flash");
                access$getViewModel$p.onToggleFlashClicked(flash);
            } else {
                throw null;
            }
        }
    }

    public static final class b implements FrameProcessor {
        public final /* synthetic */ SNSCameraActivity a;

        public b(SNSCameraActivity sNSCameraActivity) {
            this.a = sNSCameraActivity;
        }

        @Override // com.otaliastudios.cameraview.frame.FrameProcessor
        public final void process(@NotNull Frame frame) {
            Intrinsics.checkNotNullParameter(frame, "it");
            SNSCameraActivity.access$getViewModel$p(this.a).onHandleVideoFrame(frame);
        }
    }

    public static final /* synthetic */ SNSCameraViewModel access$getViewModel$p(SNSCameraActivity sNSCameraActivity) {
        return (SNSCameraViewModel) sNSCameraActivity.getViewModel();
    }

    @NotNull
    public abstract CameraView getCameraView();

    @NotNull
    public abstract ImageButton getCloseButton();

    @NotNull
    public abstract ImageButton getFlashButton();

    @NotNull
    public abstract View getHelper();

    @NotNull
    public abstract TextView getHelperBrief();

    @NotNull
    public abstract TextView getHelperDetails();

    @NotNull
    public abstract ViewGroup getHelperDetailsFrame();

    @NotNull
    public abstract TextView getHelperTitle();

    @NotNull
    public abstract ProgressBar getProgressBar();

    @NotNull
    public abstract View getRootView();

    @NotNull
    public abstract View getTakePicture();

    @NotNull
    public abstract ViewGroup getToolbar();

    public void initCamera() {
        CameraView cameraView = getCameraView();
        cameraView.setLifecycleOwner(this);
        CameraOptions cameraOptions = cameraView.getCameraOptions();
        cameraView.setExposureCorrection(cameraOptions != null ? cameraOptions.getExposureCorrectionMaxValue() : Float.MAX_VALUE);
        cameraView.addCameraListener(new CameraListener(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$initCamera$$inlined$with$lambda$1
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // com.otaliastudios.cameraview.CameraListener
            public void onPictureTaken(@NotNull PictureResult pictureResult) {
                Intrinsics.checkNotNullParameter(pictureResult, "result");
                super.onPictureTaken(pictureResult);
                SNSCameraViewModel access$getViewModel$p = SNSCameraActivity.access$getViewModel$p(this.a);
                byte[] data = pictureResult.getData();
                Intrinsics.checkNotNullExpressionValue(data, "result.data");
                access$getViewModel$p.onPictureTaken(data);
            }
        });
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initCamera();
        ExtensionsKt.addSystemTopPadding$default(getToolbar(), null, false, 3, null);
        ExtensionsKt.addSystemBottomPadding$default(getRootView(), null, false, 3, null);
        ExtensionsKt.addSystemBottomPadding$default(getHelper(), null, true, 1, null);
        BottomSheetBehavior from = BottomSheetBehavior.from(getHelper());
        from.setHideable(false);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$apply$lambda$1
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(@NotNull View view, float f2) {
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(@NotNull View view, int i) {
                Intrinsics.checkNotNullParameter(view, "bottomSheet");
                CharSequence text = this.a.getHelperDetails().getText();
                if (!(text == null || text.length() == 0)) {
                    if (i == 3) {
                        TransitionManager.beginDelayedTransition(this.a.getHelperDetailsFrame(), new Crossfade());
                        this.a.getHelperBrief().setVisibility(4);
                        this.a.getHelperDetails().setVisibility(0);
                    } else if (i == 4) {
                        TransitionManager.beginDelayedTransition(this.a.getHelperDetailsFrame(), new Crossfade());
                        this.a.getHelperBrief().setVisibility(0);
                        this.a.getHelperDetails().setVisibility(4);
                    }
                }
            }
        });
        getCloseButton().setOnClickListener(new a(0, this));
        getTakePicture().setOnClickListener(new a(1, this));
        getFlashButton().setOnClickListener(new a(2, this));
        ((SNSCameraViewModel) getViewModel()).getShowProgress().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$1
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getProgressBar().setVisibility(t.booleanValue() ? 0 : 4);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getShowCamera().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$2
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getCameraView().setVisibility(t.booleanValue() ? 0 : 4);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getShowTakePicture().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$3
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getTakePicture().setVisibility(t.booleanValue() ? 0 : 4);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getFlash().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$4
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                int i;
                if (t != null) {
                    T t2 = t;
                    this.a.getCameraView().setFlash(t2);
                    if (t2.ordinal() != 0) {
                        i = R.drawable.sns_ic_torch_on;
                    } else {
                        i = R.drawable.sns_ic_torch_off;
                    }
                    this.a.getFlashButton().setImageResource(i);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getStartScanner().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observeEvent$1
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.getCameraView().clearFrameProcessors();
                    this.a.getCameraView().addFrameProcessor(this.a.f);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        ((SNSCameraViewModel) getViewModel()).getStopScanner().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observeEvent$2
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.getCameraView().clearFrameProcessors();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        ((SNSCameraViewModel) getViewModel()).getTakePicture().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observeEvent$3
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.getCameraView().takePicture();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        ((SNSCameraViewModel) getViewModel()).getHelperTitle().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$5
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getHelperTitle().setText(t);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getHelperBrief().observe(this, new SNSCameraActivity$onCreate$$inlined$observe$6(this));
        ((SNSCameraViewModel) getViewModel()).getHelperDetails().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observe$7
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.getHelperDetails().setText(t);
                }
            }
        });
        ((SNSCameraViewModel) getViewModel()).getFinishWithResult().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.SNSCameraActivity$onCreate$$inlined$observeEvent$4
            public final /* synthetic */ SNSCameraActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    DocumentPickerResult documentPickerResult = (DocumentPickerResult) contentIfNotHandled;
                    SNSCameraActivity sNSCameraActivity = this.a;
                    Intent intent = new Intent();
                    if (!documentPickerResult.isEmpty()) {
                        intent.putExtra(SNSConstants.Extra.DOCUMENT_RESULT, documentPickerResult);
                    }
                    Unit unit = Unit.INSTANCE;
                    sNSCameraActivity.setResult(-1, intent);
                    this.a.finish();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 41) {
            if ((!(iArr.length == 0)) && iArr[0] == -1) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
                    finish();
                } else {
                    new MaterialAlertDialogBuilder(this).setMessage(getTextResource(R.string.sns_alert_lackOfCameraPermissions)).setPositiveButton(getTextResource(R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) new c3(0, this)).setNeutralButton(getTextResource(R.string.sns_alert_action_settings), (DialogInterface.OnClickListener) new c3(1, this)).setOnCancelListener((DialogInterface.OnCancelListener) new a2.q.a.b.a(this)).create().show();
                }
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == -1) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 41);
        }
    }
}
