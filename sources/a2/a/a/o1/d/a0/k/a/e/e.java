package a2.a.a.o1.d.a0.k.a.e;

import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsView;
import com.jakewharton.rxrelay2.PublishRelay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ContextActionsView a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ContextActionsView contextActionsView) {
        super(0);
        this.a = contextActionsView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PublishRelay publishRelay = this.a.k;
        Unit unit = Unit.INSTANCE;
        publishRelay.accept(unit);
        return unit;
    }
}
