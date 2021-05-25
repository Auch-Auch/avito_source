package defpackage;

import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: n4  reason: default package */
public final class n4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n4(int i, Object obj) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            PublishDetailsPresenterImpl.access$goToNextStep(((PublishDetailsPresenterImpl.w) this.b).a);
            return Unit.INSTANCE;
        } else if (i == 1) {
            PublishDetailsPresenterImpl.access$goToNextStep(((PublishDetailsPresenterImpl.w) this.b).a);
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
