package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
public final class UnsignedTypes {
    @NotNull
    public static final UnsignedTypes INSTANCE = new UnsignedTypes();
    @NotNull
    public static final Set<Name> a;
    @NotNull
    public static final HashMap<ClassId, ClassId> b = new HashMap<>();
    @NotNull
    public static final HashMap<ClassId, ClassId> c = new HashMap<>();
    @NotNull
    public static final Set<Name> d;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.getTypeName());
        }
        a = CollectionsKt___CollectionsKt.toSet(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(4);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.getTypeName());
        }
        CollectionsKt___CollectionsKt.toSet(arrayList2);
        r.hashMapOf(TuplesKt.to(UnsignedArrayType.UBYTEARRAY, Name.identifier("ubyteArrayOf")), TuplesKt.to(UnsignedArrayType.USHORTARRAY, Name.identifier("ushortArrayOf")), TuplesKt.to(UnsignedArrayType.UINTARRAY, Name.identifier("uintArrayOf")), TuplesKt.to(UnsignedArrayType.ULONGARRAY, Name.identifier("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i2 = 0; i2 < 4; i2++) {
            linkedHashSet.add(values3[i2].getArrayClassId().getShortClassName());
        }
        d = linkedHashSet;
        UnsignedType[] values4 = UnsignedType.values();
        while (i < 4) {
            UnsignedType unsignedType2 = values4[i];
            i++;
            b.put(unsignedType2.getArrayClassId(), unsignedType2.getClassId());
            c.put(unsignedType2.getClassId(), unsignedType2.getArrayClassId());
        }
    }

    @JvmStatic
    public static final boolean isUnsignedType(@NotNull KotlinType kotlinType) {
        ClassifierDescriptor declarationDescriptor;
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        if (!TypeUtils.noExpectedType(kotlinType) && (declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor()) != null) {
            return INSTANCE.isUnsignedClass(declarationDescriptor);
        }
        return false;
    }

    @Nullable
    public final ClassId getUnsignedClassIdByArrayClassId(@NotNull ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "arrayClassId");
        return b.get(classId);
    }

    public final boolean isShortNameOfUnsignedArray(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return d.contains(name);
    }

    public final boolean isUnsignedClass(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        return (containingDeclaration instanceof PackageFragmentDescriptor) && Intrinsics.areEqual(((PackageFragmentDescriptor) containingDeclaration).getFqName(), StandardNames.BUILT_INS_PACKAGE_FQ_NAME) && a.contains(declarationDescriptor.getName());
    }
}
