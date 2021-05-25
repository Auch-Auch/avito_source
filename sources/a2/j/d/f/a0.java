package a2.j.d.f;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public interface a0<N, V> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    void d(N n, V v);

    @NullableDecl
    V e(N n);

    @CanIgnoreReturnValue
    V f(N n);

    void g(N n);

    @CanIgnoreReturnValue
    V h(N n, V v);
}
