package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class KotlinType implements Annotated, KotlinTypeMarker {
    public int a;

    public KotlinType() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KotlinType)) {
            return false;
        }
        KotlinType kotlinType = (KotlinType) obj;
        if (isMarkedNullable() != kotlinType.isMarkedNullable() || !StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(unwrap(), kotlinType.unwrap())) {
            return false;
        }
        return true;
    }

    @NotNull
    public abstract List<TypeProjection> getArguments();

    @NotNull
    public abstract TypeConstructor getConstructor();

    @NotNull
    public abstract MemberScope getMemberScope();

    public final int hashCode() {
        int i;
        int i2 = this.a;
        if (i2 != 0) {
            return i2;
        }
        if (KotlinTypeKt.isError(this)) {
            i = super.hashCode();
        } else {
            int hashCode = getArguments().hashCode();
            i = (isMarkedNullable() ? 1 : 0) + ((hashCode + (getConstructor().hashCode() * 31)) * 31);
        }
        this.a = i;
        return i;
    }

    public abstract boolean isMarkedNullable();

    @NotNull
    /* renamed from: refine */
    public abstract KotlinType mo988refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner);

    @NotNull
    public abstract UnwrappedType unwrap();

    public KotlinType(j jVar) {
    }
}
