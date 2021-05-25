package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b \u0018\u0000*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001*\u0004\b\u0001\u0010\u0003*\u0004\b\u0002\u0010\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001H&¢\u0006\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lkotlin/collections/builders/AbstractMapBuilderEntrySet;", "", ExifInterface.LONGITUDE_EAST, "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMutableSet;", "element", "", "contains", "(Ljava/util/Map$Entry;)Z", "containsEntry", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractMutableSet<E> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.collections.builders.AbstractMapBuilderEntrySet<E extends java.util.Map$Entry<? extends K, ? extends V>, K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((AbstractMapBuilderEntrySet<E, K, V>) ((Map.Entry) obj));
        }
        return false;
    }

    public abstract boolean containsEntry(@NotNull Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public final boolean contains(@NotNull E e) {
        Intrinsics.checkNotNullParameter(e, "element");
        return containsEntry(e);
    }

    public /* bridge */ boolean remove(Map.Entry entry) {
        return super.remove((Object) entry);
    }
}
