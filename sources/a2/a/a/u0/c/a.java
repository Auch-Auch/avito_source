package a2.a.a.u0.c;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.fees.refactor.MvvmPackageFeeFragment;
public final class a implements View.OnClickListener {
    public final /* synthetic */ MvvmPackageFeeFragment a;

    public a(MvvmPackageFeeFragment mvvmPackageFeeFragment) {
        this.a = mvvmPackageFeeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
