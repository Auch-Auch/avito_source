package kotlin.reflect.jvm.internal.impl.load.java;

import org.jetbrains.annotations.NotNull;
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    AnnotationQualifierApplicabilityType(String str) {
        this.a = str;
    }

    @NotNull
    public final String getJavaTarget() {
        return this.a;
    }
}
