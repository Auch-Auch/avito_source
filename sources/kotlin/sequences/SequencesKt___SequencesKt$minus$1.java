package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"kotlin/sequences/SequencesKt___SequencesKt$minus$1", "Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class SequencesKt___SequencesKt$minus$1 implements Sequence<T> {
    public final /* synthetic */ Sequence a;
    public final /* synthetic */ Object b;

    public static final class a extends Lambda implements Function1<T, Boolean> {
        public final /* synthetic */ SequencesKt___SequencesKt$minus$1 a;
        public final /* synthetic */ Ref.BooleanRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SequencesKt___SequencesKt$minus$1 sequencesKt___SequencesKt$minus$1, Ref.BooleanRef booleanRef) {
            super(1);
            this.a = sequencesKt___SequencesKt$minus$1;
            this.b = booleanRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(Object obj) {
            boolean z = true;
            if (!this.b.element && Intrinsics.areEqual(obj, this.a.b)) {
                this.b.element = true;
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public SequencesKt___SequencesKt$minus$1(Sequence<? extends T> sequence, Object obj) {
        this.a = sequence;
        this.b = obj;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        return SequencesKt___SequencesKt.filter(this.a, new a(this, booleanRef)).iterator();
    }
}
