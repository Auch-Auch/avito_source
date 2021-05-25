package arrow.syntax.collections;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.GetterOperation;
import arrow.core.GetterOperationImpl;
import arrow.core.Option;
import arrow.core.OptionKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"A\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Larrow/core/GetterOperation;", "Larrow/core/Option;", "getOption", "(Ljava/util/Map;)Larrow/core/GetterOperation;", "option", "arrow-syntax"}, k = 2, mv = {1, 4, 0})
public final class MapKt {

    public static final class a extends Lambda implements Function1<K, Option<? extends V>> {
        public final /* synthetic */ Map a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Map map) {
            super(1);
            this.a = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            return OptionKt.toOption(this.a.get(obj));
        }
    }

    @NotNull
    public static final <K, V> GetterOperation<K, Option<V>> getOption(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "$receiver");
        return new GetterOperationImpl(new a(map));
    }
}
