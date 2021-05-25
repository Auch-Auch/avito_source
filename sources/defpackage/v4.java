package defpackage;

import com.avito.android.remote.model.search.InlineFilterValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: v4  reason: default package */
public final class v4 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v4(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        super(0);
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
        this.f = obj5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        int i = this.a;
        if (i == 0) {
            ((Function0) this.d).invoke();
            return Unit.INSTANCE;
        } else if (i == 1) {
            ((Function1) this.e).invoke(new InlineFilterValue.InlineFilterNumericRangeValue(null, null));
            ((Function0) this.d).invoke();
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
