package com.avito.android.publish.uploading_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.avito.android.publish.R;
import com.avito.android.publish.uploading_dialog.UploadingErrorPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\fJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/publish/uploading_dialog/UploadingErrorFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter$Router;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onDestroyView", "()V", "showRetry", "showSkip", "leaveScreen", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;", "presenter", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;", "getPresenter", "()Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;", "setPresenter", "(Lcom/avito/android/publish/uploading_dialog/UploadingErrorPresenter;)V", "Lcom/avito/android/publish/uploading_dialog/UploadingErrorDialogListener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/uploading_dialog/UploadingErrorDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UploadingErrorFragment extends DialogFragment implements UploadingErrorPresenter.Router {
    public UploadingErrorDialogListener a;
    public UploadingErrorPresenter presenter;

    @NotNull
    public final UploadingErrorPresenter getPresenter() {
        UploadingErrorPresenter uploadingErrorPresenter = this.presenter;
        if (uploadingErrorPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return uploadingErrorPresenter;
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorPresenter.Router
    public void leaveScreen() {
        dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.presenter = new UploadingErrorPresenterImpl();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.upload_error_dialog, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(getContext()).setView(inflate).create();
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        UploadingErrorPresenter uploadingErrorPresenter = this.presenter;
        if (uploadingErrorPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        new UploadingErrorViewImpl(inflate, uploadingErrorPresenter);
        UploadingErrorPresenter uploadingErrorPresenter2 = this.presenter;
        if (uploadingErrorPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        uploadingErrorPresenter2.onAttached(this);
        Fragment targetFragment = getTargetFragment();
        Objects.requireNonNull(targetFragment, "null cannot be cast to non-null type com.avito.android.publish.uploading_dialog.UploadingErrorDialogListener");
        this.a = (UploadingErrorDialogListener) targetFragment;
        Intrinsics.checkNotNullExpressionValue(create, "dialog");
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        UploadingErrorPresenter uploadingErrorPresenter = this.presenter;
        if (uploadingErrorPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        uploadingErrorPresenter.onDetached();
    }

    public final void setPresenter(@NotNull UploadingErrorPresenter uploadingErrorPresenter) {
        Intrinsics.checkNotNullParameter(uploadingErrorPresenter, "<set-?>");
        this.presenter = uploadingErrorPresenter;
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorPresenter.Router
    public void showRetry() {
        UploadingErrorDialogListener uploadingErrorDialogListener = this.a;
        if (uploadingErrorDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        uploadingErrorDialogListener.onRetryClicked();
    }

    @Override // com.avito.android.publish.uploading_dialog.UploadingErrorPresenter.Router
    public void showSkip() {
        UploadingErrorDialogListener uploadingErrorDialogListener = this.a;
        if (uploadingErrorDialogListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }
        uploadingErrorDialogListener.onSkipClicked();
    }
}
