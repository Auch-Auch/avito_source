package com.avito.android.payment.wallet.history.details;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.avito.android.lastclick.LastClick;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/FiscalizationInProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class FiscalizationInProgressDialogFragment extends DialogFragment {

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = new a();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            LastClick.Updater.update();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(requireContext(), R.style.Theme_Avito_Dialog_Alert).setTitle(getString(com.avito.android.payment.R.string.payment_fiscalization_error_title)).setMessage(getString(com.avito.android.payment.R.string.payment_repeat_in_10_minutes)).setPositiveButton(getString(com.avito.android.payment.R.string.payment_clear), a.a).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…  }\n            .create()");
        return create;
    }
}
