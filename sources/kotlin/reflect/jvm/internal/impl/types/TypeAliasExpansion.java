package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
import t6.r.a.j;
public final class TypeAliasExpansion {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public final TypeAliasExpansion a;
    @NotNull
    public final TypeAliasDescriptor b;
    @NotNull
    public final List<TypeProjection> c;
    @NotNull
    public final Map<TypeParameterDescriptor, TypeProjection> d;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final TypeAliasExpansion create(@Nullable TypeAliasExpansion typeAliasExpansion, @NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, r.toMap(CollectionsKt___CollectionsKt.zip(arrayList, list)), null);
        }

        public Companion(j jVar) {
        }
    }

    public TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, j jVar) {
        this.a = typeAliasExpansion;
        this.b = typeAliasDescriptor;
        this.c = list;
        this.d = map;
    }

    @NotNull
    public final List<TypeProjection> getArguments() {
        return this.c;
    }

    @NotNull
    public final TypeAliasDescriptor getDescriptor() {
        return this.b;
    }

    @Nullable
    public final TypeProjection getReplacement(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.d.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(@NotNull TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics.areEqual(this.b, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.a;
            if (!(typeAliasExpansion == null ? false : typeAliasExpansion.isRecursion(typeAliasDescriptor))) {
                return false;
            }
        }
        return true;
    }
}
