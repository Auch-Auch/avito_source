package defpackage;

import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.SerpPresenterImpl;
import com.avito.android.serp.SerpPresenterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: m5  reason: default package */
public final class m5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m5(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            Analytics analytics = ((SerpPresenterImpl.r) this.b).a.I;
            SerpPresenterImpl.r rVar = (SerpPresenterImpl.r) this.b;
            analytics.track(new ShowPhoneDialerEvent(rVar.b, rVar.e, true, null, null, 24, null));
            return Unit.INSTANCE;
        } else if (i == 1) {
            SerpPresenterView serpPresenterView = ((SerpPresenterImpl.r) this.b).a.a;
            if (serpPresenterView != null) {
                serpPresenterView.showToastMessage(((SerpPresenterImpl.r) this.b).a.N.getCallUnavailableMessage());
            }
            Analytics analytics2 = ((SerpPresenterImpl.r) this.b).a.I;
            SerpPresenterImpl.r rVar2 = (SerpPresenterImpl.r) this.b;
            analytics2.track(new ShowPhoneDialerEvent(rVar2.b, rVar2.e, false, null, null, 24, null));
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
