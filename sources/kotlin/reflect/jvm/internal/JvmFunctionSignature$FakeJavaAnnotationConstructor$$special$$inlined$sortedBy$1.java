package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class JvmFunctionSignature$FakeJavaAnnotationConstructor$$special$$inlined$sortedBy$1<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        T t3 = t;
        Intrinsics.checkNotNullExpressionValue(t3, "it");
        String name = t3.getName();
        T t4 = t2;
        Intrinsics.checkNotNullExpressionValue(t4, "it");
        return a.compareValues(name, t4.getName());
    }
}
