package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.utils.JavaTypeEnhancementState;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class JavaResolverComponents {
    @NotNull
    public final StorageManager a;
    @NotNull
    public final JavaClassFinder b;
    @NotNull
    public final KotlinClassFinder c;
    @NotNull
    public final DeserializedDescriptorResolver d;
    @NotNull
    public final SignaturePropagator e;
    @NotNull
    public final ErrorReporter f;
    @NotNull
    public final JavaResolverCache g;
    @NotNull
    public final JavaPropertyInitializerEvaluator h;
    @NotNull
    public final SamConversionResolver i;
    @NotNull
    public final JavaSourceElementFactory j;
    @NotNull
    public final ModuleClassResolver k;
    @NotNull
    public final PackagePartProvider l;
    @NotNull
    public final SupertypeLoopChecker m;
    @NotNull
    public final LookupTracker n;
    @NotNull
    public final ModuleDescriptor o;
    @NotNull
    public final ReflectionTypes p;
    @NotNull
    public final AnnotationTypeQualifierResolver q;
    @NotNull
    public final SignatureEnhancement r;
    @NotNull
    public final JavaClassesTracker s;
    @NotNull
    public final JavaResolverSettings t;
    @NotNull
    public final NewKotlinTypeChecker u;
    @NotNull
    public final JavaTypeEnhancementState v;

    public JavaResolverComponents(@NotNull StorageManager storageManager, @NotNull JavaClassFinder javaClassFinder, @NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull SignaturePropagator signaturePropagator, @NotNull ErrorReporter errorReporter, @NotNull JavaResolverCache javaResolverCache, @NotNull JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, @NotNull SamConversionResolver samConversionResolver, @NotNull JavaSourceElementFactory javaSourceElementFactory, @NotNull ModuleClassResolver moduleClassResolver, @NotNull PackagePartProvider packagePartProvider, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull LookupTracker lookupTracker, @NotNull ModuleDescriptor moduleDescriptor, @NotNull ReflectionTypes reflectionTypes, @NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull SignatureEnhancement signatureEnhancement, @NotNull JavaClassesTracker javaClassesTracker, @NotNull JavaResolverSettings javaResolverSettings, @NotNull NewKotlinTypeChecker newKotlinTypeChecker, @NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(javaClassFinder, "finder");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(signaturePropagator, "signaturePropagator");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        Intrinsics.checkNotNullParameter(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        Intrinsics.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory, "sourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver, "moduleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        Intrinsics.checkNotNullParameter(supertypeLoopChecker, "supertypeLoopChecker");
        Intrinsics.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        Intrinsics.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        Intrinsics.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics.checkNotNullParameter(signatureEnhancement, "signatureEnhancement");
        Intrinsics.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        Intrinsics.checkNotNullParameter(javaResolverSettings, "settings");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = storageManager;
        this.b = javaClassFinder;
        this.c = kotlinClassFinder;
        this.d = deserializedDescriptorResolver;
        this.e = signaturePropagator;
        this.f = errorReporter;
        this.g = javaResolverCache;
        this.h = javaPropertyInitializerEvaluator;
        this.i = samConversionResolver;
        this.j = javaSourceElementFactory;
        this.k = moduleClassResolver;
        this.l = packagePartProvider;
        this.m = supertypeLoopChecker;
        this.n = lookupTracker;
        this.o = moduleDescriptor;
        this.p = reflectionTypes;
        this.q = annotationTypeQualifierResolver;
        this.r = signatureEnhancement;
        this.s = javaClassesTracker;
        this.t = javaResolverSettings;
        this.u = newKotlinTypeChecker;
        this.v = javaTypeEnhancementState;
    }

    @NotNull
    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.q;
    }

    @NotNull
    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.d;
    }

    @NotNull
    public final ErrorReporter getErrorReporter() {
        return this.f;
    }

    @NotNull
    public final JavaClassFinder getFinder() {
        return this.b;
    }

    @NotNull
    public final JavaClassesTracker getJavaClassesTracker() {
        return this.s;
    }

    @NotNull
    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.h;
    }

    @NotNull
    public final JavaResolverCache getJavaResolverCache() {
        return this.g;
    }

    @NotNull
    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.v;
    }

    @NotNull
    public final KotlinClassFinder getKotlinClassFinder() {
        return this.c;
    }

    @NotNull
    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.u;
    }

    @NotNull
    public final LookupTracker getLookupTracker() {
        return this.n;
    }

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.o;
    }

    @NotNull
    public final ModuleClassResolver getModuleClassResolver() {
        return this.k;
    }

    @NotNull
    public final PackagePartProvider getPackagePartProvider() {
        return this.l;
    }

    @NotNull
    public final ReflectionTypes getReflectionTypes() {
        return this.p;
    }

    @NotNull
    public final JavaResolverSettings getSettings() {
        return this.t;
    }

    @NotNull
    public final SignatureEnhancement getSignatureEnhancement() {
        return this.r;
    }

    @NotNull
    public final SignaturePropagator getSignaturePropagator() {
        return this.e;
    }

    @NotNull
    public final JavaSourceElementFactory getSourceElementFactory() {
        return this.j;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.a;
    }

    @NotNull
    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.m;
    }

    @NotNull
    public final JavaResolverComponents replace(@NotNull JavaResolverCache javaResolverCache) {
        Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new JavaResolverComponents(this.a, this.b, this.c, this.d, this.e, this.f, javaResolverCache, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v);
    }
}
