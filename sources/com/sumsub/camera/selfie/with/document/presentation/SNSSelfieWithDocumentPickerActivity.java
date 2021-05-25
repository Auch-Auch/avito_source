package com.sumsub.camera.selfie.with.document.presentation;

import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import butterknife.BindView;
import com.avito.android.util.preferences.SessionContract;
import com.otaliastudios.cameraview.CameraView;
import com.sumsub.camera.selfie.with.document.R;
import com.sumsub.sns.camera.SNSCameraActivity;
import com.sumsub.sns.camera.SNSCameraPhotoActivity;
import com.sumsub.sns.core.ServiceLocator;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.common.SNSSession;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.DocumentType;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 h2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001hB\u0007¢\u0006\u0004\bf\u0010gJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001c\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001e\u0010\u0015J\u0019\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010-R\u001d\u00102\u001a\u00020\u00028T@\u0014X\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00103\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\bB\u00104\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u00107R\"\u0010E\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\bE\u00109\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010<R\"\u0010H\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\bH\u00109\u001a\u0004\bI\u0010\u0015\"\u0004\bJ\u0010<R\"\u0010K\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bK\u0010>\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010AR\"\u0010N\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u00109\u001a\u0004\bO\u0010\u0015\"\u0004\bP\u0010<R\"\u0010Q\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u000b\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u0012\n\u0004\b]\u00104\u001a\u0004\b^\u0010\u001a\"\u0004\b_\u00107R\"\u0010`\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010*\u001a\u0004\ba\u0010\b\"\u0004\bb\u0010-R\"\u0010c\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u0012\n\u0004\bc\u00109\u001a\u0004\bd\u0010\u0015\"\u0004\be\u0010<¨\u0006i"}, d2 = {"Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerActivity;", "Lcom/sumsub/sns/camera/SNSCameraPhotoActivity;", "Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerViewModel;", "", "getLayoutId", "()I", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Lcom/otaliastudios/cameraview/CameraView;", "getCameraView", "()Lcom/otaliastudios/cameraview/CameraView;", "getTakePicture", "Landroid/widget/ImageButton;", "getFlashButton", "()Landroid/widget/ImageButton;", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "Landroid/view/ViewGroup;", "getToolbar", "()Landroid/view/ViewGroup;", "getCloseButton", "getHelper", "Landroid/widget/TextView;", "getHelperTitle", "()Landroid/widget/TextView;", "getHelperBrief", "getHelperDetails", "getTakeGallery", "getHelperDetailsFrame", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "pbProgress", "Landroid/widget/ProgressBar;", "getPbProgress", "setPbProgress", "(Landroid/widget/ProgressBar;)V", "btnTakePicture", "Landroid/view/View;", "getBtnTakePicture", "setBtnTakePicture", "(Landroid/view/View;)V", g.a, "Lkotlin/Lazy;", "getViewModel", "()Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerViewModel;", "viewModel", "tvHelperTitle", "Landroid/widget/TextView;", "getTvHelperTitle", "setTvHelperTitle", "(Landroid/widget/TextView;)V", "vgHelperDetailsFrame", "Landroid/view/ViewGroup;", "getVgHelperDetailsFrame", "setVgHelperDetailsFrame", "(Landroid/view/ViewGroup;)V", "btnTorchToggle", "Landroid/widget/ImageButton;", "getBtnTorchToggle", "setBtnTorchToggle", "(Landroid/widget/ImageButton;)V", "tvHelperDetails", "getTvHelperDetails", "setTvHelperDetails", "vgHelper", "getVgHelper", "setVgHelper", "vgFrameLayout", "getVgFrameLayout", "setVgFrameLayout", "btnClose", "getBtnClose", "setBtnClose", "vgRoot", "getVgRoot", "setVgRoot", "cvCamera", "Lcom/otaliastudios/cameraview/CameraView;", "getCvCamera", "setCvCamera", "(Lcom/otaliastudios/cameraview/CameraView;)V", "Landroid/widget/ImageView;", "ivFrameImage", "Landroid/widget/ImageView;", "getIvFrameImage", "()Landroid/widget/ImageView;", "setIvFrameImage", "(Landroid/widget/ImageView;)V", "tvHelperBrief", "getTvHelperBrief", "setTvHelperBrief", "btnTakeGallery", "getBtnTakeGallery", "setBtnTakeGallery", "vgToolbar", "getVgToolbar", "setVgToolbar", "<init>", "()V", "Companion", "sns-camera-selfie-with-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSSelfieWithDocumentPickerActivity extends SNSCameraPhotoActivity<SNSSelfieWithDocumentPickerViewModel> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @BindView(1935)
    public ImageButton btnClose;
    @BindView(1936)
    public View btnTakeGallery;
    @BindView(1937)
    public View btnTakePicture;
    @BindView(1938)
    public ImageButton btnTorchToggle;
    @BindView(1942)
    public CameraView cvCamera;
    @NotNull
    public final Lazy g = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SNSSelfieWithDocumentPickerViewModel.class), new Function0<ViewModelStore>(this) { // from class: com.sumsub.camera.selfie.with.document.presentation.SNSSelfieWithDocumentPickerActivity$$special$$inlined$viewModels$2
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
    @BindView(2045)
    public ImageView ivFrameImage;
    @BindView(2136)
    public ProgressBar pbProgress;
    @BindView(2253)
    public TextView tvHelperBrief;
    @BindView(2254)
    public TextView tvHelperDetails;
    @BindView(2255)
    public TextView tvHelperTitle;
    @BindView(2263)
    public ViewGroup vgFrameLayout;
    @BindView(2264)
    public ViewGroup vgHelper;
    @BindView(2265)
    public ViewGroup vgHelperDetailsFrame;
    @BindView(2267)
    public ViewGroup vgRoot;
    @BindView(2268)
    public ViewGroup vgToolbar;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/sumsub/camera/selfie/with/document/presentation/SNSSelfieWithDocumentPickerActivity$Companion;", "", "Landroid/content/Context;", "context", "Lcom/sumsub/sns/core/common/SNSSession;", SessionContract.SESSION, "Lcom/sumsub/sns/core/data/model/Applicant;", "applicant", "Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "", "gallery", "Landroid/content/Intent;", "newIntent", "(Landroid/content/Context;Lcom/sumsub/sns/core/common/SNSSession;Lcom/sumsub/sns/core/data/model/Applicant;Lcom/sumsub/sns/core/data/model/DocumentType;Z)Landroid/content/Intent;", "<init>", "()V", "sns-camera-selfie-with-document-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public static /* synthetic */ Intent newIntent$default(Companion companion, Context context, SNSSession sNSSession, Applicant applicant, DocumentType documentType, boolean z, int i, Object obj) {
            return companion.newIntent(context, sNSSession, applicant, documentType, (i & 16) != 0 ? false : z);
        }

        @NotNull
        public final Intent newIntent(@NotNull Context context, @NotNull SNSSession sNSSession, @NotNull Applicant applicant, @NotNull DocumentType documentType, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sNSSession, SessionContract.SESSION);
            Intrinsics.checkNotNullParameter(applicant, "applicant");
            Intrinsics.checkNotNullParameter(documentType, "type");
            Intent intent = new Intent(context, SNSSelfieWithDocumentPickerActivity.class);
            intent.putExtra(SNSConstants.Intent.SNS_EXTRA_SESSION, sNSSession);
            intent.putExtra(SNSCameraActivity.EXTRA_APPLICANT, applicant);
            intent.putExtra(SNSCameraActivity.EXTRA_DOCUMENT_TYPE, documentType.getValue());
            intent.putExtra(SNSCameraPhotoActivity.EXTRA_GALLERY_AVAILABLE, z);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<ViewModelProvider.Factory> {
        public final /* synthetic */ SNSSelfieWithDocumentPickerActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSSelfieWithDocumentPickerActivity sNSSelfieWithDocumentPickerActivity) {
            super(0);
            this.a = sNSSelfieWithDocumentPickerActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ViewModelProvider.Factory invoke() {
            SNSSelfieWithDocumentPickerActivity sNSSelfieWithDocumentPickerActivity = this.a;
            ServiceLocator serviceLocator = sNSSelfieWithDocumentPickerActivity.getServiceLocator();
            Intent intent = this.a.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            return new SNSSelfieWithDocumentPickerViewModelFactory(sNSSelfieWithDocumentPickerActivity, serviceLocator, intent.getExtras());
        }
    }

    @NotNull
    public final ImageButton getBtnClose() {
        ImageButton imageButton = this.btnClose;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        }
        return imageButton;
    }

    @NotNull
    public final View getBtnTakeGallery() {
        View view = this.btnTakeGallery;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeGallery");
        }
        return view;
    }

    @NotNull
    public final View getBtnTakePicture() {
        View view = this.btnTakePicture;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakePicture");
        }
        return view;
    }

    @NotNull
    public final ImageButton getBtnTorchToggle() {
        ImageButton imageButton = this.btnTorchToggle;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTorchToggle");
        }
        return imageButton;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public CameraView getCameraView() {
        CameraView cameraView = this.cvCamera;
        if (cameraView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cvCamera");
        }
        return cameraView;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public ImageButton getCloseButton() {
        ImageButton imageButton = this.btnClose;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        }
        return imageButton;
    }

    @NotNull
    public final CameraView getCvCamera() {
        CameraView cameraView = this.cvCamera;
        if (cameraView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cvCamera");
        }
        return cameraView;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public ImageButton getFlashButton() {
        ImageButton imageButton = this.btnTorchToggle;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTorchToggle");
        }
        return imageButton;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public View getHelper() {
        ViewGroup viewGroup = this.vgHelper;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgHelper");
        }
        return viewGroup;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public TextView getHelperBrief() {
        TextView textView = this.tvHelperBrief;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperBrief");
        }
        return textView;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public TextView getHelperDetails() {
        TextView textView = this.tvHelperDetails;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperDetails");
        }
        return textView;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public ViewGroup getHelperDetailsFrame() {
        ViewGroup viewGroup = this.vgHelperDetailsFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgHelperDetailsFrame");
        }
        return viewGroup;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public TextView getHelperTitle() {
        TextView textView = this.tvHelperTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperTitle");
        }
        return textView;
    }

    @NotNull
    public final ImageView getIvFrameImage() {
        ImageView imageView = this.ivFrameImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivFrameImage");
        }
        return imageView;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    public int getLayoutId() {
        return R.layout.sns_activity_selfie_with_document_picker;
    }

    @NotNull
    public final ProgressBar getPbProgress() {
        ProgressBar progressBar = this.pbProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbProgress");
        }
        return progressBar;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public ProgressBar getProgressBar() {
        ProgressBar progressBar = this.pbProgress;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbProgress");
        }
        return progressBar;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public View getRootView() {
        ViewGroup viewGroup = this.vgRoot;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgRoot");
        }
        return viewGroup;
    }

    @Override // com.sumsub.sns.camera.SNSCameraPhotoActivity
    @NotNull
    public View getTakeGallery() {
        View view = this.btnTakeGallery;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakeGallery");
        }
        return view;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public View getTakePicture() {
        View view = this.btnTakePicture;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnTakePicture");
        }
        return view;
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    @NotNull
    public ViewGroup getToolbar() {
        ViewGroup viewGroup = this.vgToolbar;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgToolbar");
        }
        return viewGroup;
    }

    @NotNull
    public final TextView getTvHelperBrief() {
        TextView textView = this.tvHelperBrief;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperBrief");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvHelperDetails() {
        TextView textView = this.tvHelperDetails;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperDetails");
        }
        return textView;
    }

    @NotNull
    public final TextView getTvHelperTitle() {
        TextView textView = this.tvHelperTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHelperTitle");
        }
        return textView;
    }

    @NotNull
    public final ViewGroup getVgFrameLayout() {
        ViewGroup viewGroup = this.vgFrameLayout;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgFrameLayout");
        }
        return viewGroup;
    }

    @NotNull
    public final ViewGroup getVgHelper() {
        ViewGroup viewGroup = this.vgHelper;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgHelper");
        }
        return viewGroup;
    }

    @NotNull
    public final ViewGroup getVgHelperDetailsFrame() {
        ViewGroup viewGroup = this.vgHelperDetailsFrame;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgHelperDetailsFrame");
        }
        return viewGroup;
    }

    @NotNull
    public final ViewGroup getVgRoot() {
        ViewGroup viewGroup = this.vgRoot;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgRoot");
        }
        return viewGroup;
    }

    @NotNull
    public final ViewGroup getVgToolbar() {
        ViewGroup viewGroup = this.vgToolbar;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vgToolbar");
        }
        return viewGroup;
    }

    @Override // com.sumsub.sns.core.presentation.BaseActivity
    @NotNull
    public SNSSelfieWithDocumentPickerViewModel getViewModel() {
        return (SNSSelfieWithDocumentPickerViewModel) this.g.getValue();
    }

    @Override // com.sumsub.sns.camera.SNSCameraPhotoActivity, com.sumsub.sns.camera.SNSCameraActivity, com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().initHelper(this);
    }

    public final void setBtnClose(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.btnClose = imageButton;
    }

    public final void setBtnTakeGallery(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.btnTakeGallery = view;
    }

    public final void setBtnTakePicture(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.btnTakePicture = view;
    }

    public final void setBtnTorchToggle(@NotNull ImageButton imageButton) {
        Intrinsics.checkNotNullParameter(imageButton, "<set-?>");
        this.btnTorchToggle = imageButton;
    }

    public final void setCvCamera(@NotNull CameraView cameraView) {
        Intrinsics.checkNotNullParameter(cameraView, "<set-?>");
        this.cvCamera = cameraView;
    }

    public final void setIvFrameImage(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivFrameImage = imageView;
    }

    public final void setPbProgress(@NotNull ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.pbProgress = progressBar;
    }

    public final void setTvHelperBrief(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvHelperBrief = textView;
    }

    public final void setTvHelperDetails(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvHelperDetails = textView;
    }

    public final void setTvHelperTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvHelperTitle = textView;
    }

    public final void setVgFrameLayout(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgFrameLayout = viewGroup;
    }

    public final void setVgHelper(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgHelper = viewGroup;
    }

    public final void setVgHelperDetailsFrame(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgHelperDetailsFrame = viewGroup;
    }

    public final void setVgRoot(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgRoot = viewGroup;
    }

    public final void setVgToolbar(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.vgToolbar = viewGroup;
    }
}
