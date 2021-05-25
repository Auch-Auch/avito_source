package defpackage;

import com.avito.android.dialog.DialogWithDeeplinkActions;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: i4  reason: default package */
public final class i4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i4(int i, Object obj, Object obj2, Object obj3) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            DialogWithDeeplinkActions.access$onButtonClick(((DialogWithDeeplinkActions.a) this.c).a, ((DeepLinksDialogInfo.Action) this.b).getUriLink());
            return Unit.INSTANCE;
        } else if (i == 1) {
            DialogWithDeeplinkActions.access$onButtonClick(((DialogWithDeeplinkActions.a) this.c).a, ((DeepLinksDialogInfo.Action) this.b).getUriLink());
            return Unit.INSTANCE;
        } else if (i == 2) {
            DialogWithDeeplinkActions.access$onButtonClick(((DialogWithDeeplinkActions.a) this.c).a, ((DeepLinksDialogInfo.Action) this.b).getUriLink());
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
