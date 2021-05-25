package t6.x;

import java.util.Iterator;
import kotlin.collections.EmptyIterator;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
public final class b implements Sequence, DropTakeSequence {
    @NotNull
    public static final b a = new b();

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence drop(int i) {
        return a;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence take(int i) {
        return a;
    }
}
