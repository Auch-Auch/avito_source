package a2.a.a.o1.d.a0.k.a;

import androidx.transition.Transition;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
public final class c extends Lambda implements Function1<Transition, Unit> {
    public final /* synthetic */ LegacyPlatformActionsViewImpl a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Ref.ObjectRef c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl, boolean z, Ref.ObjectRef objectRef) {
        super(1);
        this.a = legacyPlatformActionsViewImpl;
        this.b = z;
        this.c = objectRef;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "it");
        LegacyPlatformActionsViewImpl legacyPlatformActionsViewImpl = this.a;
        boolean z = this.b;
        T t = this.c.element;
        legacyPlatformActionsViewImpl.a(z, t != null ? t.getTitleView() : null);
        return Unit.INSTANCE;
    }
}
