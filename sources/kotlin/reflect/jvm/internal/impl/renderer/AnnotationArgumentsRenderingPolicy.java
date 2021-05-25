package kotlin.reflect.jvm.internal.impl.renderer;
public enum AnnotationArgumentsRenderingPolicy {
    NO_ARGUMENTS(false, false, 3),
    UNLESS_EMPTY(true, false, 2),
    ALWAYS_PARENTHESIZED(true, true);
    
    public final boolean a;
    public final boolean b;

    /* access modifiers changed from: public */
    AnnotationArgumentsRenderingPolicy(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.a;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.b;
    }

    /* access modifiers changed from: public */
    AnnotationArgumentsRenderingPolicy(boolean z, boolean z2, int i) {
        z = (i & 1) != 0 ? false : z;
        z2 = (i & 2) != 0 ? false : z2;
        this.a = z;
        this.b = z2;
    }
}
