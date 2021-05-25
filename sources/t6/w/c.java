package t6.w;

import a2.b.a.a.a;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ExperimentalStdlibApi;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@ExperimentalStdlibApi
public final class c implements TypeVariable<GenericDeclaration>, Object {
    public final KTypeParameter a;

    public c(@NotNull KTypeParameter kTypeParameter) {
        Intrinsics.checkNotNullParameter(kTypeParameter, "typeParameter");
        this.a = kTypeParameter;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TypeVariable) || !Intrinsics.areEqual(getName(), ((TypeVariable) obj).getName())) {
            return false;
        }
        getGenericDeclaration();
        throw null;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public Type[] getBounds() {
        List<KType> upperBounds = this.a.getUpperBounds();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVMKt.access$computeJavaType(it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder L = a.L("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        L.append(this.a);
        throw new NotImplementedError(a.c3("An operation is not implemented: ", L.toString()));
    }

    @Override // java.lang.reflect.TypeVariable
    @NotNull
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.Type
    @NotNull
    public String getTypeName() {
        return getName();
    }

    @Override // java.lang.Object
    public int hashCode() {
        getName().hashCode();
        getGenericDeclaration();
        throw null;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getName();
    }
}
