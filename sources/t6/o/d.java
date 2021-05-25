package t6.o;

import com.avito.android.remote.auth.AuthSource;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class d implements Comparator<Comparable<? super Object>> {
    @NotNull
    public static final d a = new d();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public int compare(Comparable<? super Object> comparable, Comparable<? super Object> comparable2) {
        Comparable<? super Object> comparable3 = comparable;
        Comparable<? super Object> comparable4 = comparable2;
        Intrinsics.checkNotNullParameter(comparable3, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(comparable4, AuthSource.BOOKING_ORDER);
        return comparable3.compareTo(comparable4);
    }

    /* Return type fixed from 'java.util.Comparator<java.lang.Comparable<java.lang.Object>>' to match base method */
    @Override // java.util.Comparator
    @NotNull
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.a;
    }
}
