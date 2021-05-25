package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import t6.n.q;
import t6.n.r;
import t6.n.y;
public final class AnnotationQualifiersFqNamesKt {
    @NotNull
    public static final FqName a = new FqName("javax.annotation.meta.TypeQualifierNickname");
    @NotNull
    public static final FqName b = new FqName("javax.annotation.meta.TypeQualifier");
    @NotNull
    public static final FqName c = new FqName("javax.annotation.meta.TypeQualifierDefault");
    @NotNull
    public static final FqName d = new FqName("kotlin.annotations.jvm.UnderMigration");
    @NotNull
    public static final List<AnnotationQualifierApplicabilityType> e;
    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> f;
    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> g;
    @NotNull
    public static final Set<FqName> h = y.setOf((Object[]) new FqName[]{JvmAnnotationNamesKt.getJAVAX_NONNULL_ANNOTATION(), JvmAnnotationNamesKt.getJAVAX_CHECKFORNULL_ANNOTATION()});

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List<AnnotationQualifierApplicabilityType> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AnnotationQualifierApplicabilityType[]{AnnotationQualifierApplicabilityType.FIELD, AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE, annotationQualifierApplicabilityType, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE});
        e = listOf;
        FqName jspecify_default_not_null = JvmAnnotationNamesKt.getJSPECIFY_DEFAULT_NOT_NULL();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map<FqName, JavaDefaultQualifiers> mapOf = q.mapOf(TuplesKt.to(jspecify_default_not_null, new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), listOf, false)));
        f = mapOf;
        g = r.plus(r.mapOf(TuplesKt.to(new FqName("javax.annotation.ParametersAreNullableByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(NullabilityQualifier.NULLABLE, false, 2, null), d.listOf(annotationQualifierApplicabilityType), false, 4, null)), TuplesKt.to(new FqName("javax.annotation.ParametersAreNonnullByDefault"), new JavaDefaultQualifiers(new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, false, 2, null), d.listOf(annotationQualifierApplicabilityType), false, 4, null))), mapOf);
    }

    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> getBUILT_IN_TYPE_QUALIFIER_DEFAULT_ANNOTATIONS() {
        return g;
    }

    @NotNull
    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_FQ_NAMES() {
        return h;
    }

    @NotNull
    public static final Map<FqName, JavaDefaultQualifiers> getJSPECIFY_DEFAULT_ANNOTATIONS() {
        return f;
    }

    @NotNull
    public static final FqName getMIGRATION_ANNOTATION_FQNAME() {
        return d;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_DEFAULT_FQNAME() {
        return c;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_FQNAME() {
        return b;
    }

    @NotNull
    public static final FqName getTYPE_QUALIFIER_NICKNAME_FQNAME() {
        return a;
    }
}
