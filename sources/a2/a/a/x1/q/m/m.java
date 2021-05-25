package a2.a.a.x1.q.m;

import com.avito.android.util.Rotation;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class m<T> implements Predicate<Rotation> {
    public static final m a = new m();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Rotation rotation) {
        Rotation rotation2 = rotation;
        Intrinsics.checkNotNullParameter(rotation2, "it");
        return !Intrinsics.areEqual(rotation2, new Rotation.Rotation_180());
    }
}
