package a2.a.a.o1.d.a0.k.a.e;

import android.view.View;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView;
public final class c implements View.OnClickListener {
    public final /* synthetic */ ContextActionsView a;
    public final /* synthetic */ ContextActionsPresenter.State.Action b;

    public c(ContextActionsView contextActionsView, ContextActionsPresenter.State.Action action) {
        this.a = contextActionsView;
        this.b = action;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.i.accept(this.b);
    }
}
