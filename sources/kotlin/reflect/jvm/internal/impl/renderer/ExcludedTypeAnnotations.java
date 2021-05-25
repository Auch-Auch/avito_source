package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
public final class ExcludedTypeAnnotations {
    @NotNull
    public static final ExcludedTypeAnnotations INSTANCE = new ExcludedTypeAnnotations();
    @NotNull
    public static final Set<FqName> a = y.setOf((Object[]) new FqName[]{new FqName("kotlin.internal.NoInfer"), new FqName("kotlin.internal.Exact")});

    @NotNull
    public final Set<FqName> getInternalAnnotationsForResolve() {
        return a;
    }
}
