package a2.a.a.k0.c;

import androidx.lifecycle.Observer;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettings;
import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewImpl;
public final class a<T> implements Observer<DeliveryProfileSettings> {
    public final /* synthetic */ DeliveryProfileSettingsViewImpl a;

    public a(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl) {
        this.a = deliveryProfileSettingsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(DeliveryProfileSettings deliveryProfileSettings) {
        DeliveryProfileSettings deliveryProfileSettings2 = deliveryProfileSettings;
        if (deliveryProfileSettings2 != null) {
            DeliveryProfileSettingsViewImpl.access$dataChanged(this.a, deliveryProfileSettings2);
        }
    }
}
