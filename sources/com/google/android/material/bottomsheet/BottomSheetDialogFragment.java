package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    public boolean a;

    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public b(a aVar) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i) {
            if (i == 5) {
                BottomSheetDialogFragment.a(BottomSheetDialogFragment.this);
            }
        }
    }

    public static void a(BottomSheetDialogFragment bottomSheetDialogFragment) {
        if (bottomSheetDialogFragment.a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    public final boolean b(boolean z) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof BottomSheetDialog)) {
            return false;
        }
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) dialog;
        BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
        if (!behavior.isHideable() || !bottomSheetDialog.getDismissWithAnimation()) {
            return false;
        }
        this.a = z;
        if (behavior.getState() != 5) {
            if (getDialog() instanceof BottomSheetDialog) {
                BottomSheetDialog bottomSheetDialog2 = (BottomSheetDialog) getDialog();
                bottomSheetDialog2.c.removeBottomSheetCallback(bottomSheetDialog2.i);
            }
            behavior.addBottomSheetCallback(new b(null));
            behavior.setState(5);
            return true;
        } else if (this.a) {
            super.dismissAllowingStateLoss();
            return true;
        } else {
            super.dismiss();
            return true;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (!b(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (!b(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new BottomSheetDialog(getContext(), getTheme());
    }
}
