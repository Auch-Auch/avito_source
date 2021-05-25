package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00002\u00020\u0003J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\t8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Larrow/core/SetterOperation;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "key", "value", "", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function2;", "getSetter", "()Lkotlin/jvm/functions/Function2;", "setter", "arrow-core"}, k = 1, mv = {1, 4, 0})
public interface SetterOperation<K, V> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static <K, V> void set(SetterOperation<? super K, ? super V> setterOperation, K k, V v) {
            setterOperation.getSetter().invoke(k, v);
        }
    }

    @NotNull
    Function2<K, V, Unit> getSetter();

    void set(K k, V v);
}
