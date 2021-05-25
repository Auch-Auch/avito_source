package a2.a.a.q3.f;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.vas_performance.ui.LegacyPerformanceVasFragment;
public final class j implements View.OnClickListener {
    public final /* synthetic */ LegacyPerformanceVasFragment a;

    public j(LegacyPerformanceVasFragment legacyPerformanceVasFragment) {
        this.a = legacyPerformanceVasFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}
