package a2.a.a.n2.w.b;

import android.widget.PopupWindow;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandlerImpl;
public final class b implements PopupWindow.OnDismissListener {
    public final /* synthetic */ SerpOnboardingHandlerImpl a;

    public b(SerpOnboardingHandlerImpl serpOnboardingHandlerImpl) {
        this.a = serpOnboardingHandlerImpl;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.unbind();
    }
}
