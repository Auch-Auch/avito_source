package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Larrow/core/PartialFunction;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "", "isDefinedAt", "(Ljava/lang/Object;)Z", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public abstract class PartialFunction<A, B> implements Function1<A, B> {
    public abstract boolean isDefinedAt(A a);
}
