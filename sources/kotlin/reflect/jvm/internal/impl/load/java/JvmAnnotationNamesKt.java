package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import t6.n.z;
public final class JvmAnnotationNamesKt {
    @NotNull
    public static final FqName a;
    @NotNull
    public static final FqName b;
    @NotNull
    public static final FqName c;
    @NotNull
    public static final List<FqName> d;
    @NotNull
    public static final FqName e;
    @NotNull
    public static final FqName f = new FqName("javax.annotation.CheckForNull");
    @NotNull
    public static final List<FqName> g;
    @NotNull
    public static final FqName h;
    @NotNull
    public static final FqName i;
    @NotNull
    public static final FqName j;
    @NotNull
    public static final FqName k;
    @NotNull
    public static final List<FqName> l = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
    @NotNull
    public static final List<FqName> m = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});

    static {
        FqName fqName = new FqName("org.jspecify.annotations.Nullable");
        a = fqName;
        FqName fqName2 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        b = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.DefaultNonNull");
        c = fqName3;
        List<FqName> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, new FqName("androidx.annotation.Nullable"), new FqName("android.support.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable")});
        d = listOf;
        FqName fqName4 = new FqName("javax.annotation.Nonnull");
        e = fqName4;
        List<FqName> listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.support.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull")});
        g = listOf2;
        FqName fqName5 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        h = fqName5;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        i = fqName6;
        FqName fqName7 = new FqName("androidx.annotation.RecentlyNullable");
        j = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNonNull");
        k = fqName8;
        z.plus(z.plus(z.plus(z.plus(z.plus(z.plus(z.plus(z.plus(z.plus(z.plus((Set) new LinkedHashSet(), (Iterable) listOf), fqName4), (Iterable) listOf2), fqName5), fqName6), fqName7), fqName8), fqName), fqName2), fqName3);
    }

    @NotNull
    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return k;
    }

    @NotNull
    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return j;
    }

    @NotNull
    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return i;
    }

    @NotNull
    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return h;
    }

    @NotNull
    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return f;
    }

    @NotNull
    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return e;
    }

    @NotNull
    public static final FqName getJSPECIFY_DEFAULT_NOT_NULL() {
        return c;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULLABLE() {
        return a;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return b;
    }

    @NotNull
    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return m;
    }

    @NotNull
    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return g;
    }

    @NotNull
    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return d;
    }

    @NotNull
    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return l;
    }
}
