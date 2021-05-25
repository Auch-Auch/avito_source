package com.sumsub.sns.camera;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.otaliastudios.cameraview.size.SizeSelectors;
import com.sumsub.sns.camera.SNSCameraPhotoViewModel;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.presentation.base.Event;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.RuntimePermissions;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u001f*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001c\u001a\u00020\u001bH$¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraPhotoActivity;", "Lcom/sumsub/sns/camera/SNSCameraPhotoViewModel;", "VM", "Lcom/sumsub/sns/camera/SNSCameraActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "initCamera", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "intent", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "showExternalStorage", "onCameraNeverAskAgain", "Landroid/view/View;", "getTakeGallery", "()Landroid/view/View;", "<init>", "Companion", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
@RuntimePermissions
public abstract class SNSCameraPhotoActivity<VM extends SNSCameraPhotoViewModel> extends SNSCameraActivity<VM> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_GALLERY_AVAILABLE = "EXTRA_GALLERY_AVAILABLE";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/camera/SNSCameraPhotoActivity$Companion;", "", "", SNSCameraPhotoActivity.EXTRA_GALLERY_AVAILABLE, "Ljava/lang/String;", "", "MAX_PHOTO_DIMENSION", "I", "REQUEST_ID_GALLERY_IMAGE", "<init>", "()V", "sns-camera_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ SNSCameraPhotoActivity a;

        public a(SNSCameraPhotoActivity sNSCameraPhotoActivity) {
            this.a = sNSCameraPhotoActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            ExtensionsKt.openAppSettings(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ SNSCameraPhotoActivity a;

        public b(SNSCameraPhotoActivity sNSCameraPhotoActivity) {
            this.a = sNSCameraPhotoActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SNSCameraPhotoActivityPermissionsDispatcher.showExternalStorageWithPermissionCheck(this.a);
        }
    }

    @NotNull
    public abstract View getTakeGallery();

    @Override // com.sumsub.sns.camera.SNSCameraActivity
    public void initCamera() {
        super.initCamera();
        getCameraView().setPictureSize(SizeSelectors.and(SizeSelectors.maxWidth(1500), SizeSelectors.maxHeight(1500), SizeSelectors.biggest()));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            Uri fileUriFromResult = ExtensionsKt.getFileUriFromResult(this, i2, intent);
            String valueOf = String.valueOf(fileUriFromResult);
            String substring = valueOf.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) valueOf, ".", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            File createTempFile = File.createTempFile("from_gallery", substring, getCacheDir());
            Intrinsics.checkNotNullExpressionValue(createTempFile, "tempFile");
            ((SNSCameraPhotoViewModel) getViewModel()).onGalleryImagePicked(fileUriFromResult, createTempFile);
        }
    }

    @OnNeverAskAgain({"android.permission.READ_EXTERNAL_STORAGE"})
    public final void onCameraNeverAskAgain() {
        new MaterialAlertDialogBuilder(this).setMessage(getTextResource(R.string.sns_alert_lackOfPhotoLibraryPermissions)).setPositiveButton(getTextResource(R.string.sns_alert_action_ok), (DialogInterface.OnClickListener) null).setNeutralButton(getTextResource(R.string.sns_alert_action_settings), (DialogInterface.OnClickListener) new a(this)).show();
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity, com.sumsub.sns.core.presentation.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int i = 0;
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_GALLERY_AVAILABLE, false);
        View takeGallery = getTakeGallery();
        if (!booleanExtra) {
            i = 8;
        }
        takeGallery.setVisibility(i);
        getTakeGallery().setOnClickListener(new b(this));
        ((SNSCameraPhotoViewModel) getViewModel()).getShowGallery().observe(this, new Observer<Event<? extends T>>(this) { // from class: com.sumsub.sns.camera.SNSCameraPhotoActivity$onCreate$$inlined$observeEvent$1
            public final /* synthetic */ SNSCameraPhotoActivity a;

            {
                this.a = r1;
            }

            public final void onChanged(Event<? extends T> event) {
                if (event != null && event.getContentIfNotHandled() != null) {
                    this.a.startActivityForResult(ExtensionsKt.getImagePickerIntent$default(this.a, null, 1, null), 1);
                }
            }

            @Override // androidx.lifecycle.Observer
            public /* bridge */ /* synthetic */ void onChanged(Object obj) {
                onChanged((Event) ((Event) obj));
            }
        });
    }

    @Override // com.sumsub.sns.camera.SNSCameraActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        SNSCameraPhotoActivityPermissionsDispatcher.onRequestPermissionsResult(this, i, iArr);
    }

    @NeedsPermission({"android.permission.READ_EXTERNAL_STORAGE"})
    public final void showExternalStorage() {
        ((SNSCameraPhotoViewModel) getViewModel()).onGalleryClicked();
    }
}
