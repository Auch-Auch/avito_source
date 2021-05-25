package com.avito.android.publish.sts_scanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.avito.android.lastclick.LastClick;
import com.avito.android.publish.R;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "(Landroid/content/DialogInterface;)V", "Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;)Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/sts_scanner/StsRecognitionErrorDialogListener;", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class StsRecognitionErrorDialog extends DialogFragment {
    public StsRecognitionErrorDialogListener a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((StsRecognitionErrorDialog) this.b).dismiss();
                LastClick.Updater.update();
                StsRecognitionErrorDialogListener stsRecognitionErrorDialogListener = ((StsRecognitionErrorDialog) this.b).a;
                if (stsRecognitionErrorDialogListener != null) {
                    stsRecognitionErrorDialogListener.retryStsScan();
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((StsRecognitionErrorDialog) this.b).dismiss();
                LastClick.Updater.update();
                StsRecognitionErrorDialogListener stsRecognitionErrorDialogListener2 = ((StsRecognitionErrorDialog) this.b).a;
                if (stsRecognitionErrorDialogListener2 != null) {
                    stsRecognitionErrorDialogListener2.cancelScanning();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        StsRecognitionErrorDialogListener stsRecognitionErrorDialogListener = this.a;
        if (stsRecognitionErrorDialogListener != null) {
            stsRecognitionErrorDialogListener.retryStsScan();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sts_recognition_error_dialog, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(getContext()).setView(inflate).create();
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        Intrinsics.checkNotNullExpressionValue(inflate, "rootView");
        View findViewById = inflate.findViewById(R.id.button_retry_scan);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById);
        buttonImpl.setText(R.string.sts_recognition_error_retry_scan);
        buttonImpl.setClickListener(new a(0, this));
        View findViewById2 = inflate.findViewById(R.id.button_cancel);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById2);
        buttonImpl2.setText(R.string.sts_recognition_error_continue);
        buttonImpl2.setClickListener(new a(1, this));
        Intrinsics.checkNotNullExpressionValue(create, "dialog");
        return create;
    }

    @NotNull
    public final StsRecognitionErrorDialog setListener(@NotNull StsRecognitionErrorDialogListener stsRecognitionErrorDialogListener) {
        Intrinsics.checkNotNullParameter(stsRecognitionErrorDialogListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = stsRecognitionErrorDialogListener;
        return this;
    }
}
