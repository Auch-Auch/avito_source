package kotlin.reflect.jvm.internal.impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
public final class SpecialJvmAnnotations {
    @NotNull
    public static final SpecialJvmAnnotations INSTANCE = new SpecialJvmAnnotations();
    @NotNull
    public static final Set<ClassId> a;

    static {
        List<FqName> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (FqName fqName : listOf) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        a = linkedHashSet;
    }

    @NotNull
    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return a;
    }
}
