package t6.w.f.a.m.c.b.a;

import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import org.jetbrains.annotations.NotNull;
public class a extends ReadKotlinClassHeaderAnnotationVisitor.b {
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.c b;

    public a(ReadKotlinClassHeaderAnnotationVisitor.c cVar) {
        this.b = cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor.b
    public void b(@NotNull String[] strArr) {
        if (strArr != null) {
            ReadKotlinClassHeaderAnnotationVisitor.this.f = strArr;
            return;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
    }
}
