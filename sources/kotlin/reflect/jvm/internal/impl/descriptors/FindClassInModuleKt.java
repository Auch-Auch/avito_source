package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class FindClassInModuleKt {

    public static final class b extends Lambda implements Function1<ClassId, Integer> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Integer invoke(ClassId classId) {
            Intrinsics.checkNotNullParameter(classId, "it");
            return 0;
        }
    }

    @Nullable
    public static final ClassDescriptor findClassAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    @Nullable
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        ClassifierDescriptor contributedClassifier;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments);
            Intrinsics.checkNotNullExpressionValue(first, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((Name) first, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier == null) {
                return null;
            }
            for (Name name : pathSegments.subList(1, pathSegments.size())) {
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                ClassifierDescriptor contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                if (contributedClassifier2 instanceof ClassDescriptor) {
                    contributedClassifier = (ClassDescriptor) contributedClassifier2;
                    continue;
                } else {
                    contributedClassifier = null;
                    continue;
                }
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            Object first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments2);
            Intrinsics.checkNotNullExpressionValue(first2, "segments.first()");
            ClassifierDescriptor contributedClassifier3 = memberScope2.getContributedClassifier((Name) first2, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier3 != null) {
                Iterator<Name> it = pathSegments2.subList(1, pathSegments2.size()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Name next = it.next();
                    if (!(contributedClassifier3 instanceof ClassDescriptor)) {
                        break;
                    }
                    MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkNotNullExpressionValue(next, "name");
                    ClassifierDescriptor contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(next, NoLookupLocation.FROM_DESERIALIZATION);
                    if (contributedClassifier4 instanceof ClassDescriptor) {
                        contributedClassifier3 = (ClassDescriptor) contributedClassifier4;
                        continue;
                    } else {
                        contributedClassifier3 = null;
                        continue;
                    }
                    if (contributedClassifier3 == null) {
                        break;
                    }
                }
            }
            contributedClassifier3 = null;
            if (contributedClassifier3 != null) {
                return contributedClassifier3;
            }
            FqName packageFqName3 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(packageFqName3);
            List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments3, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
            Object first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) pathSegments3);
            Intrinsics.checkNotNullExpressionValue(first3, "segments.first()");
            contributedClassifier = memberScope3.getContributedClassifier((Name) first3, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier == null) {
                return null;
            }
            for (Name name2 : pathSegments3.subList(1, pathSegments3.size())) {
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(name2, "name");
                ClassifierDescriptor contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                if (contributedClassifier5 instanceof ClassDescriptor) {
                    contributedClassifier = (ClassDescriptor) contributedClassifier5;
                    continue;
                } else {
                    contributedClassifier = null;
                    continue;
                }
                if (contributedClassifier == null) {
                    return null;
                }
            }
        }
        return contributedClassifier;
    }

    @NotNull
    public static final ClassDescriptor findNonGenericClassAcrossDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt__SequencesKt.generateSequence(classId, a.a), b.a)));
    }

    @Nullable
    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(@NotNull ModuleDescriptor moduleDescriptor, @NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
