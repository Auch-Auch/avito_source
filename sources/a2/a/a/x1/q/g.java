package a2.a.a.x1.q;

import com.avito.android.util.Rotation;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Predicate<Rotation> {
    public static final g a = new g();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Rotation rotation) {
        Rotation rotation2 = rotation;
        Intrinsics.checkNotNullParameter(rotation2, "it");
        return !Intrinsics.areEqual(rotation2, new Rotation.Rotation_180());
    }
}
