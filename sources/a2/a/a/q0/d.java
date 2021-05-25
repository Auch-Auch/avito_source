package a2.a.a.q0;

import com.avito.android.component.contact_bar.ContactBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<ContactBar.Action, Unit> {
    public final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super(1);
        this.a = eVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(ContactBar.Action action) {
        ContactBar.Action action2 = action;
        Intrinsics.checkNotNullParameter(action2, "it");
        this.a.a.v.handleDeepLink(action2.getDeepLink());
        return Unit.INSTANCE;
    }
}
