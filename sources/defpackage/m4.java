package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: m4  reason: default package */
public final class m4 extends Lambda implements Function0<Long> {
    public static final m4 b = new m4(0);
    public static final m4 c = new m4(1);
    public static final m4 d = new m4(2);
    public static final m4 e = new m4(3);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m4(int i) {
        super(0);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        int i = this.a;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        if (i == 1) {
            return Long.MIN_VALUE;
        }
        if (i == 2) {
            return Long.MIN_VALUE;
        }
        if (i == 3) {
            return Long.MIN_VALUE;
        }
        throw null;
    }
}
