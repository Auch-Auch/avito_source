package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u0018\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Larrow/core/GetterOperation;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "getGetter", "()Lkotlin/jvm/functions/Function1;", "getter", "arrow-core"}, k = 1, mv = {1, 4, 0})
public interface GetterOperation<K, V> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static <K, V> V get(GetterOperation<? super K, ? extends V> getterOperation, K k) {
            return (V) getterOperation.getGetter().invoke(k);
        }
    }

    V get(K k);

    @NotNull
    Function1<K, V> getGetter();
}
