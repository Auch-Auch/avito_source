package defpackage;

import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.grouping_adverts.GroupingAdvertsPresenterImpl;
import com.avito.android.grouping_adverts.GroupingAdvertsView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: d4  reason: default package */
public final class d4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d4(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            Analytics analytics = ((GroupingAdvertsPresenterImpl.i) this.b).a.A;
            GroupingAdvertsPresenterImpl.i iVar = (GroupingAdvertsPresenterImpl.i) this.b;
            analytics.track(new ShowPhoneDialerEvent(iVar.b, iVar.e, true, null, null, 24, null));
            return Unit.INSTANCE;
        } else if (i == 1) {
            GroupingAdvertsView groupingAdvertsView = ((GroupingAdvertsPresenterImpl.i) this.b).a.c;
            if (groupingAdvertsView != null) {
                groupingAdvertsView.showToastMessage(((GroupingAdvertsPresenterImpl.i) this.b).a.x.getCallUnavailableMessage());
            }
            Analytics analytics2 = ((GroupingAdvertsPresenterImpl.i) this.b).a.A;
            GroupingAdvertsPresenterImpl.i iVar2 = (GroupingAdvertsPresenterImpl.i) this.b;
            analytics2.track(new ShowPhoneDialerEvent(iVar2.b, iVar2.e, false, null, null, 24, null));
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
