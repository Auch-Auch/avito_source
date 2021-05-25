package a2.a.a.k0.c;

import android.view.View;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewImpl;
public final class f implements View.OnClickListener {
    public final /* synthetic */ DeliveryProfileSettingsViewImpl a;

    public f(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl) {
        this.a = deliveryProfileSettingsViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.j.onCloseClicked();
    }
}
