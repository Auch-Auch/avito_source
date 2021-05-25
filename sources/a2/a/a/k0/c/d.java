package a2.a.a.k0.c;

import com.avito.android.delivery.profile_settings.DeliveryProfileSettingsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ DeliveryProfileSettingsViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(DeliveryProfileSettingsViewImpl deliveryProfileSettingsViewImpl, boolean z) {
        super(1);
        this.a = deliveryProfileSettingsViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        this.a.j.onSwitchToggleChanges(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
