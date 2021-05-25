package a2.a.a.g.j;

import android.content.Intent;
import com.avito.android.advert_core.phone_request.PhoneRequestPresenterImpl;
import com.avito.android.advert_core.phone_request.PhoneRequestRouter;
import com.avito.android.advert_core.phone_request.PhoneRequestView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.util.Logs;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DeepLink, Unit> {
    public final /* synthetic */ PhoneRequestPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PhoneRequestPresenterImpl phoneRequestPresenterImpl) {
        super(1);
        this.a = phoneRequestPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeepLink deepLink) {
        DeepLink deepLink2 = deepLink;
        Intrinsics.checkNotNullParameter(deepLink2, "it");
        if (deepLink2 instanceof PhoneLink.Call) {
            PhoneRequestView phoneRequestView = this.a.b;
            if (phoneRequestView != null) {
                phoneRequestView.call((PhoneLink.Call) deepLink2);
            }
            this.a.d.trackPhoneShowed();
        } else {
            Intent intent = this.a.e.getIntent(deepLink2);
            if (intent == null) {
                Logs.error$default("Can't receive intent from link " + deepLink2, null, 2, null);
            } else {
                PhoneRequestRouter phoneRequestRouter = this.a.a;
                if (phoneRequestRouter != null) {
                    phoneRequestRouter.startActivitySafely(intent);
                }
            }
            PhoneRequestRouter phoneRequestRouter2 = this.a.a;
            if (phoneRequestRouter2 != null) {
                phoneRequestRouter2.leaveScreen();
            }
        }
        return Unit.INSTANCE;
    }
}
