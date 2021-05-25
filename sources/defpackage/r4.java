package defpackage;

import com.avito.android.analytics.clickstream.FieldConverter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: r4  reason: default package */
public final class r4 extends Lambda implements Function1<Object, CharSequence> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r4(int i, Object obj) {
        super(1);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function1
    public final CharSequence invoke(Object obj) {
        int i = this.a;
        if (i != 0) {
            if (i != 1) {
                throw null;
            } else if (obj instanceof Float) {
                return ((FieldConverter) this.b).a.format((double) ((Number) obj).floatValue());
            } else {
                if (obj instanceof Double) {
                    return ((FieldConverter) this.b).a.format(((Number) obj).doubleValue());
                }
                return String.valueOf(obj);
            }
        } else if (obj instanceof Float) {
            return ((FieldConverter) this.b).a.format((double) ((Number) obj).floatValue());
        } else {
            if (obj instanceof Double) {
                return ((FieldConverter) this.b).a.format(((Number) obj).doubleValue());
            }
            return String.valueOf(obj);
        }
    }
}
