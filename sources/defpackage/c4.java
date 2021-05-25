package defpackage;

import com.avito.android.blocked_ip.BlockedIpDialogPresenter;
import com.avito.android.blocked_ip.BlockedIpDialogPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: c4  reason: default package */
public final class c4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c4(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            BlockedIpDialogPresenter.Router router = ((BlockedIpDialogPresenterImpl) this.b).c;
            if (router != null) {
                router.closeDialog();
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            BlockedIpDialogPresenter.Router router2 = ((BlockedIpDialogPresenterImpl) this.b).c;
            if (router2 != null) {
                router2.openHelpCenterRequest();
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
