package a2.a.a.o1.d.a0.k.a.e;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ContextActionsView a;
    public final /* synthetic */ ContextActionsPresenter.State.Action b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ContextActionsView contextActionsView, ContextActionsPresenter.State.Action action) {
        super(0);
        this.a = contextActionsView;
        this.b = action;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.o.dismiss();
        this.a.j.accept(this.b);
        return Unit.INSTANCE;
    }
}
