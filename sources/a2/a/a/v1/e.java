package a2.a.a.v1;

import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.phone_confirmation.view.VisibilityText;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<Long, VisibilityText> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public VisibilityText apply(Long l) {
        Long l2 = l;
        Intrinsics.checkNotNullParameter(l2, "it");
        if (l2.longValue() < 0) {
            return new VisibilityText(true, null);
        }
        return new VisibilityText(false, DateTimeFormatter.Companion.convertMillisecondsToTimeString(l2.longValue()));
    }
}
