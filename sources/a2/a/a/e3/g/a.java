package a2.a.a.e3.g;

import android.view.View;
import com.avito.android.tariff.landing.TariffLandingFragment;
import com.avito.android.tariff.landing.viewmodel.TariffLanding;
public final class a implements View.OnClickListener {
    public final /* synthetic */ TariffLandingFragment a;
    public final /* synthetic */ TariffLanding b;

    public a(TariffLandingFragment tariffLandingFragment, TariffLanding tariffLanding) {
        this.a = tariffLandingFragment;
        this.b = tariffLanding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getViewModel().onContinueButtonClick(this.b.getAction().getDeepLink());
    }
}
