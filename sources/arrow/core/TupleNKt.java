package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\u0004¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", AuthSource.BOOKING_ORDER, "Larrow/core/Tuple2;", "toT", "(Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple2;", "arrow-core"}, k = 2, mv = {1, 4, 0})
public final class TupleNKt {
    @NotNull
    public static final <A, B> Tuple2<A, B> toT(A a, B b) {
        return new Tuple2<>(a, b);
    }
}
