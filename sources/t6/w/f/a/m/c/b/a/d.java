package t6.w.f.a.m.c.b.a;

import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import org.jetbrains.annotations.NotNull;
public class d extends ReadKotlinClassHeaderAnnotationVisitor.b {
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.d b;

    public d(ReadKotlinClassHeaderAnnotationVisitor.d dVar) {
        this.b = dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.b
    public void b(@NotNull String[] strArr) {
        if (strArr != null) {
            ReadKotlinClassHeaderAnnotationVisitor.this.g = strArr;
            return;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
    }
}
