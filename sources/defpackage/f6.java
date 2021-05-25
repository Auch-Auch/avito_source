package defpackage;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OrderCallbackLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.service_subscription_legacy.ServiceSubscriptionResponse;
import com.avito.android.service_subscription.remote.ServiceSubscription;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: f6  reason: default package */
public final class f6 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f6(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        ServiceSubscription subscription;
        Action action;
        int i = this.a;
        DeepLink deepLink = null;
        if (i == 0) {
            ServiceSubscriptionResponse serviceSubscriptionResponse = ((ServiceSubscriptionPresenterImpl) this.b).c;
            if (!(serviceSubscriptionResponse == null || (subscription = serviceSubscriptionResponse.getSubscription()) == null || (action = subscription.getAction()) == null)) {
                deepLink = action.getDeepLink();
            }
            if (deepLink instanceof OrderCallbackLink) {
                ServiceSubscriptionPresenterImpl.access$orderCallback((ServiceSubscriptionPresenterImpl) this.b);
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((ServiceSubscriptionPresenterImpl) this.b).b();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
