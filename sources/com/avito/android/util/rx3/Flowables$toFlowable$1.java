package com.avito.android.util.rx3;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/avito/android/util/rx3/Flowables$toFlowable$1", "", "", "iterator", "()Ljava/util/Iterator;", "rx"}, k = 1, mv = {1, 4, 2})
public final class Flowables$toFlowable$1 implements Iterable<T>, KMappedMarker {
    public final /* synthetic */ Sequence a;

    public Flowables$toFlowable$1(Sequence<? extends T> sequence) {
        this.a = sequence;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return this.a.iterator();
    }
}
