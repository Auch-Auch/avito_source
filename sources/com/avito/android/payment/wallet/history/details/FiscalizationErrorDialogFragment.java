package com.avito.android.payment.wallet.history.details;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.avito.android.lastclick.LastClick;
import com.avito.android.payment.R;
import com.avito.android.util.ToastsKt;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/FiscalizationErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class FiscalizationErrorDialogFragment extends DialogFragment {

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = new a();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            dialogInterface.dismiss();
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ FiscalizationErrorDialogFragment a;

        public b(FiscalizationErrorDialogFragment fiscalizationErrorDialogFragment) {
            this.a = fiscalizationErrorDialogFragment;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            Context applicationContext;
            Context context = this.a.getContext();
            Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(this.a.getString(R.string.payment_avito_support), "support@avito.ru"));
            LastClick.Updater.update();
            Context context2 = this.a.getContext();
            if (context2 != null) {
                String string = this.a.getString(R.string.payment_email_copied);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.payment_email_copied)");
                ToastsKt.showToast$default(context2, string, 0, 2, (Object) null);
            }
            dialogInterface.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.payment_fiscalization_error_title)).setMessage(getString(R.string.payment_please_write_to_email_pattern, "support@avito.ru")).setPositiveButton(getString(R.string.payment_close), a.a).setNeutralButton(getString(R.string.payment_copy_email), new b(this)).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…  }\n            .create()");
        return create;
    }
}
