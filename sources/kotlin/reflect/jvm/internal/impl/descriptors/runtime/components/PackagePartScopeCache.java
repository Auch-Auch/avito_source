package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
public final class PackagePartScopeCache {
    @NotNull
    public final DeserializedDescriptorResolver a;
    @NotNull
    public final ReflectKotlinClassFinder b;
    @NotNull
    public final ConcurrentHashMap<ClassId, MemberScope> c = new ConcurrentHashMap<>();

    public PackagePartScopeCache(@NotNull DeserializedDescriptorResolver deserializedDescriptorResolver, @NotNull ReflectKotlinClassFinder reflectKotlinClassFinder) {
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "resolver");
        Intrinsics.checkNotNullParameter(reflectKotlinClassFinder, "kotlinClassFinder");
        this.a = deserializedDescriptorResolver;
        this.b = reflectKotlinClassFinder;
    }

    @NotNull
    public final MemberScope getPackagePartScope(@NotNull ReflectKotlinClass reflectKotlinClass) {
        Collection<KotlinJvmBinaryClass> collection;
        Intrinsics.checkNotNullParameter(reflectKotlinClass, "fileClass");
        ConcurrentHashMap<ClassId, MemberScope> concurrentHashMap = this.c;
        ClassId classId = reflectKotlinClass.getClassId();
        MemberScope memberScope = concurrentHashMap.get(classId);
        if (memberScope == null) {
            FqName packageFqName = reflectKotlinClass.getClassId().getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> multifilePartNames = reflectKotlinClass.getClassHeader().getMultifilePartNames();
                collection = new ArrayList();
                Iterator<T> it = multifilePartNames.iterator();
                while (it.hasNext()) {
                    ClassId classId2 = ClassId.topLevel(JvmClassName.byInternalName(it.next()).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(this.b, classId2);
                    if (findKotlinClass != null) {
                        collection.add(findKotlinClass);
                    }
                }
            } else {
                collection = d.listOf(reflectKotlinClass);
            }
            EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(this.a.getComponents().getModuleDescriptor(), packageFqName);
            ArrayList arrayList = new ArrayList();
            for (KotlinJvmBinaryClass kotlinJvmBinaryClass : collection) {
                MemberScope createKotlinPackagePartScope = this.a.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, kotlinJvmBinaryClass);
                if (createKotlinPackagePartScope != null) {
                    arrayList.add(createKotlinPackagePartScope);
                }
            }
            List list = CollectionsKt___CollectionsKt.toList(arrayList);
            ChainedMemberScope.Companion companion = ChainedMemberScope.Companion;
            MemberScope create = companion.create("package " + packageFqName + " (" + reflectKotlinClass + ')', list);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(classId, create);
            memberScope = putIfAbsent != null ? putIfAbsent : create;
        }
        Intrinsics.checkNotNullExpressionValue(memberScope, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
        return memberScope;
    }
}
