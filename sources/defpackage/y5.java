package defpackage;

import com.avito.android.publish.premoderation.AdvertDuplicatePresenter;
import com.avito.android.publish.premoderation.AdvertDuplicatePresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: y5  reason: default package */
public final class y5 extends Lambda implements Function1<Unit, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y5(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Unit unit) {
        int i = this.a;
        if (i == 0) {
            AdvertDuplicatePresenter.Router router = ((AdvertDuplicatePresenterImpl) this.b).b;
            if (router != null) {
                router.onContinueClicked();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            AdvertDuplicatePresenter.Router router2 = ((AdvertDuplicatePresenterImpl) this.b).b;
            if (router2 != null) {
                router2.leaveScreen();
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
