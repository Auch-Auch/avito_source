package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b'\u0018\u0000 \u000e*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u000eB\t\b\u0004¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/collections/AbstractSet;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<init>", "()V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0007\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/collections/AbstractSet$Companion;", "", "", "c", "", "unorderedHashCode$kotlin_stdlib", "(Ljava/util/Collection;)I", "unorderedHashCode", "", "other", "", "setEquals$kotlin_stdlib", "(Ljava/util/Set;Ljava/util/Set;)Z", "setEquals", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public final boolean setEquals$kotlin_stdlib(@NotNull Set<?> set, @NotNull Set<?> set2) {
            Intrinsics.checkNotNullParameter(set, "c");
            Intrinsics.checkNotNullParameter(set2, "other");
            if (set.size() != set2.size()) {
                return false;
            }
            return set.containsAll(set2);
        }

        public final int unorderedHashCode$kotlin_stdlib(@NotNull Collection<?> collection) {
            Intrinsics.checkNotNullParameter(collection, "c");
            Iterator<?> it = collection.iterator();
            int i = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i += next != null ? next.hashCode() : 0;
            }
            return i;
        }

        public Companion(j jVar) {
        }
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        return Companion.setEquals$kotlin_stdlib(this, (Set) obj);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return Companion.unorderedHashCode$kotlin_stdlib(this);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
