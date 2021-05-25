package kotlin.comparisons;

import com.avito.android.remote.auth.AuthSource;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class ComparisonsKt__ComparisonsKt$compareBy$2<T> implements Comparator<T> {
    public final /* synthetic */ Function1 a;

    public ComparisonsKt__ComparisonsKt$compareBy$2(Function1 function1) {
        this.a = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues((Comparable) this.a.invoke(t), (Comparable) this.a.invoke(t2));
    }
}
