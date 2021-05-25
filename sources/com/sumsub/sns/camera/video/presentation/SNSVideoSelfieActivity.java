package com.sumsub.sns.camera.video.presentation;

import a2.q.a.b.d.a.b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import butterknife.BindView;
import com.avito.android.util.preferences.SessionContract;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;
import com.sumsub.sns.camera.video.R;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieViewModel;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.Document;
import com.sumsub.sns.core.presentation.BaseActivity;
import com.sumsub.sns.core.presentation.base.Event;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl.droidsonroids.gif.GifImageView;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b<\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010 \u001a\u00020\u00028T@\u0014X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\u00020!8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b6\u0010*\u001a\u0004\b7\u0010,\"\u0004\b8\u0010.R\"\u00109\u001a\u00020(8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b9\u0010*\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.¨\u0006>"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieActivity;", "Lcom/sumsub/sns/core/presentation/BaseActivity;", "Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel;", "", "getLayoutId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lpl/droidsonroids/gif/GifImageView;", "gifView", "Lpl/droidsonroids/gif/GifImageView;", "getGifView", "()Lpl/droidsonroids/gif/GifImageView;", "setGifView", "(Lpl/droidsonroids/gif/GifImageView;)V", "f", "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieViewModel;", "viewModel", "Lcom/otaliastudios/cameraview/CameraView;", "cameraView", "Lcom/otaliastudios/cameraview/CameraView;", "getCameraView", "()Lcom/otaliastudios/cameraview/CameraView;", "setCameraView", "(Lcom/otaliastudios/cameraview/CameraView;)V", "Landroid/widget/TextView;", "tvDescription2", "Landroid/widget/TextView;", "getTvDescription2", "()Landroid/widget/TextView;", "setTvDescription2", "(Landroid/widget/TextView;)V", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "tvText", "getTvText", "setTvText", "tvDescription1", "getTvDescription1", "setTvDescription1", "<init>", "Companion", "sns-camera-video-selfie_release"}, k = 1, mv = {1, 4, 2})
public final class SNSVideoSelfieActivity extends BaseActivity<SNSVideoSelfieViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_DOCUMENT = "EXTRA_DOCUMENT";
    @NotNull
    public static final String EXTRA_FILE = "EXTRA_FILE";
    @NotNull
    public static final String EXTRA_PHRASE = "EXTRA_PHRASE";
    public static final String[] g = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    @BindView(1950)
    public CameraView cameraView;
    @NotNull
    public final Lazy f = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SNSVideoSelfieViewModel.class), new Function0<ViewModelStore>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$$special$$inlined$viewModels$2
        public final /* synthetic */ ComponentActivity a;

        {
            this.a = r1;
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = this.a.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }, new a(this));
    @BindView(2279)
    public GifImageView gifView;
    @BindView(2252)
    public Toolbar toolbar;
    @BindView(2263)
    public TextView tvDescription1;
    @BindView(2264)
    public TextView tvDescription2;
    @BindView(2270)
    public TextView tvText;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/camera/video/presentation/SNSVideoSelfieActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/data/model/Document;", "document", "Landroid/content/Intent;", "newIntent", "(Landroid/content/Context;Lcom/sumsub/sns/core/common/SNSSession;Lcom/sumsub/sns/core/data/model/Document;)Landroid/content/Intent;", "", SNSVideoSelfieActivity.EXTRA_DOCUMENT, "Ljava/lang/String;", SNSVideoSelfieActivity.EXTRA_FILE, SNSVideoSelfieActivity.EXTRA_PHRASE, "", "REQUEST_CAMERA_PERMISSION", "I", "", "REQUIRED_PERMISSIONS", "[Ljava/lang/String;", "<init>", "()V", "sns-camera-video-selfie_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent newIntent(@NotNull Context context, @NotNull SNSSession sNSSession, @NotNull Document document) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            Intrinsics.checkNotNullParameter(document, "document");
            Intent intent = new Intent(context, SNSVideoSelfieActivity.class);
            intent.putExtra(SNSVideoSelfieActivity.EXTRA_DOCUMENT, document).putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SNSVideoSelfieViewModel.State.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
        }
    }

    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSVideoSelfieActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSVideoSelfieActivity sNSVideoSelfieActivity) {
            super(0);
            this.a = sNSVideoSelfieActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSVideoSelfieActivity sNSVideoSelfieActivity = this.a;
            ServiceLocator serviceLocator = sNSVideoSelfieActivity.getServiceLocator();
            Intent intent = this.a.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            return new SNSVideoSelfieViewModelFactory(sNSVideoSelfieActivity, serviceLocator, intent.getExtras());
        }
    }

    @NotNull
    public final CameraView getCameraView() {
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        return cameraView2;
    }

    @NotNull
    public final GifImageView getGifView() {
        GifImageView gifImageView = this.gifView;
        if (gifImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gifView");
        }
        return gifImageView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    public int getLayoutId() {
        return R.layout.sns_activity_video_selfie;
    }

    @NotNull
    public final Toolbar getToolbar() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar2;
    }

    @NotNull
    public final TextView getTvDescription1() {
        TextView textView = this.tvDescription1;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescription1");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvDescription2() {
        TextView textView = this.tvDescription2;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescription2");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvText() {
        TextView textView = this.tvText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        return textView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    @NotNull
    public SNSVideoSelfieViewModel getViewModel() {
        return (SNSVideoSelfieViewModel) this.f.getValue();
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        setSupportActionBar(toolbar2);
        Toolbar toolbar3 = this.toolbar;
        if (toolbar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        toolbar3.setNavigationOnClickListener(new a2.q.a.b.d.a.a(this));
        CameraView cameraView2 = this.cameraView;
        if (cameraView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        cameraView2.setLifecycleOwner(this);
        CameraView cameraView3 = this.cameraView;
        if (cameraView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        CameraView cameraView4 = this.cameraView;
        if (cameraView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        CameraOptions cameraOptions = cameraView4.getCameraOptions();
        cameraView3.setExposureCorrection(cameraOptions != null ? cameraOptions.getExposureCorrectionMaxValue() : Float.MAX_VALUE);
        TextView textView = this.tvDescription1;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescription1");
        }
        textView.setText(getTextResource(R.string.sns_step_SELFIE_recording_header));
        TextView textView2 = this.tvDescription2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDescription2");
        }
        textView2.setText(getTextResource(R.string.sns_step_SELFIE_recording_instructions));
        SNSVideoSelfieViewModel viewModel = getViewModel();
        Parcelable parcelableExtra = getIntent().getParcelableExtra(EXTRA_DOCUMENT);
        Intrinsics.checkNotNull(parcelableExtra);
        viewModel.setPhrase(this, (Document) parcelableExtra);
        getViewModel().getMessage().observe(this, new Observer<T>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$onCreate$$inlined$observe$1
            public final /* synthetic */ SNSVideoSelfieActivity a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                this.a.getTvText().setText(t);
            }
        });
        getViewModel().getState().observe(this, new SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$1(this));
        getViewModel().getStartRecording().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$2
            public final /* synthetic */ SNSVideoSelfieActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    this.a.getCameraView().takeVideoSnapshot((File) contentIfNotHandled);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getStopRecording().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$3
            public final /* synthetic */ SNSVideoSelfieActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.getCameraView().stopVideo();
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getResult().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$4
            public final /* synthetic */ SNSVideoSelfieActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                Object contentIfNotHandled;
                if (event != null && (contentIfNotHandled = event.getContentIfNotHandled()) != null) {
                    SNSVideoSelfieViewModel.Result result = (SNSVideoSelfieViewModel.Result) contentIfNotHandled;
                    SNSVideoSelfieActivity sNSVideoSelfieActivity = this.a;
                    Intent intent = new Intent();
                    File file = result.getFile();
                    String str = null;
                    if (!(file instanceof File)) {
                        file = null;
                    }
                    if (file != null) {
                        str = file.getAbsolutePath();
                    }
                    intent.putExtra(SNSVideoSelfieActivity.EXTRA_FILE, str);
                    intent.putExtra(SNSVideoSelfieActivity.EXTRA_PHRASE, result.getPhrase());
                    Unit unit = Unit.INSTANCE;
                    sNSVideoSelfieActivity.setResult(-1, intent);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
        getViewModel().getFinish().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity$onCreate$$inlined$observeEvent$5
            public final /* synthetic */ SNSVideoSelfieActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
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
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i == 41) {
            if (!(iArr.length == 0)) {
                int length = iArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    if (iArr[i2] == -1) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    String[] strArr2 = g;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z2 = false;
                            break;
                        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, strArr2[i3])) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (z2) {
                        finish();
                        return;
                    } else {
                        new MaterialAlertDialogBuilder(this).setMessage(getTextResource(com.sumsub.sns.camera.R.string.sns_alert_lackOfCameraPermissions)).setPositiveButton(getTextResource(com.sumsub.sns.camera.R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) new p(0, this)).setOnCancelListener((DialogInterface.OnCancelListener) new b(this)).setNeutralButton(getTextResource(R.string.sns_alert_action_settings), (DialogInterface.OnClickListener) new p(1, this)).create().show();
                        return;
                    }
                }
            }
            getViewModel().startCountdown();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        String[] strArr = g;
        int length = strArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (ContextCompat.checkSelfPermission(this, strArr[i]) == -1) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            ActivityCompat.requestPermissions(this, g, 41);
        } else {
            getViewModel().startCountdown();
        }
    }

    public final void setCameraView(@NotNull CameraView cameraView2) {
        Intrinsics.checkNotNullParameter(cameraView2, "<set-?>");
        this.cameraView = cameraView2;
    }

    public final void setGifView(@NotNull GifImageView gifImageView) {
        Intrinsics.checkNotNullParameter(gifImageView, "<set-?>");
        this.gifView = gifImageView;
    }

    public final void setToolbar(@NotNull Toolbar toolbar2) {
        Intrinsics.checkNotNullParameter(toolbar2, "<set-?>");
        this.toolbar = toolbar2;
    }

    public final void setTvDescription1(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvDescription1 = textView;
    }

    public final void setTvDescription2(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvDescription2 = textView;
    }

    public final void setTvText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvText = textView;
    }
}
