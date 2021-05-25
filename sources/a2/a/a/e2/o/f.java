package a2.a.a.e2.o;

import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.WizardParameter;
import com.vk.sdk.api.model.VKApiUserFull;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<WizardParameter, WizardParameter> {
    public final /* synthetic */ Navigation a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Navigation navigation) {
        super(1);
        this.a = navigation;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public WizardParameter invoke(WizardParameter wizardParameter) {
        WizardParameter wizardParameter2 = wizardParameter;
        Intrinsics.checkNotNullParameter(wizardParameter2, VKApiUserFull.RelativeType.CHILD);
        return wizardParameter2.findNodeByNavigation(this.a);
    }
}
