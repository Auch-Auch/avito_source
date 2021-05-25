package defpackage;

import com.avito.android.publish.select.SelectViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: d6  reason: default package */
public final class d6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d6(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((SelectViewModel) this.b).onLeaveClicked();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((SelectViewModel) this.b).onMainButtonClicked();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
