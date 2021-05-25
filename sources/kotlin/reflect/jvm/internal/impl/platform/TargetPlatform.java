package kotlin.reflect.jvm.internal.impl.platform;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class TargetPlatform implements Collection<SimplePlatform>, KMappedMarker {
    public boolean add(SimplePlatform simplePlatform) {
        Intrinsics.checkNotNullParameter(simplePlatform, "element");
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends SimplePlatform> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof SimplePlatform)) {
            return false;
        }
        return contains((SimplePlatform) obj);
    }

    public boolean contains(@NotNull SimplePlatform simplePlatform) {
        Intrinsics.checkNotNullParameter(simplePlatform, "element");
        throw null;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        throw null;
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TargetPlatform)) {
            return false;
        }
        Objects.requireNonNull((TargetPlatform) obj);
        return Intrinsics.areEqual(null, null);
    }

    @NotNull
    public final Set<SimplePlatform> getComponentPlatforms() {
        return null;
    }

    public int getSize() {
        throw null;
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        throw null;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        throw null;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<SimplePlatform> iterator() {
        throw null;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return PlatformUtilKt.getPresentableDescription(this);
    }
}
