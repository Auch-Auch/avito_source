package kotlin.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B)\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010\u001c\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\u00020\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012R\u001c\u0010\u001c\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028V@\u0016X\u0004¢\u0006\f\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "", "Lkotlin/reflect/KType;", "upperBounds", "", "setUpperBounds", "(Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "container", "c", "Ljava/lang/String;", "getName", "name", "e", "Z", "isReified", "()Z", "Lkotlin/reflect/KVariance;", "d", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "variance", AuthSource.SEND_ABUSE, "Ljava/util/List;", "bounds", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class TypeParameterReference implements KTypeParameter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public volatile List<? extends KType> a;
    public final Object b;
    @NotNull
    public final String c;
    @NotNull
    public final KVariance d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "Lkotlin/reflect/KTypeParameter;", "typeParameter", "", "toString", "(Lkotlin/reflect/KTypeParameter;)Ljava/lang/String;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                KVariance.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
                iArr[2] = 3;
            }
        }

        public Companion() {
        }

        @NotNull
        public final String toString(@NotNull KTypeParameter kTypeParameter) {
            Intrinsics.checkNotNullParameter(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int ordinal = kTypeParameter.getVariance().ordinal();
            if (ordinal == 1) {
                sb.append("in ");
            } else if (ordinal == 2) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public Companion(j jVar) {
        }
    }

    public TypeParameterReference(@Nullable Object obj, @NotNull String str, @NotNull KVariance kVariance, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kVariance, "variance");
        this.b = obj;
        this.c = str;
        this.d = kVariance;
        this.e = z;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) obj;
            if (Intrinsics.areEqual(this.b, typeParameterReference.b) && Intrinsics.areEqual(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        return this.c;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.reflect.KType>, java.util.List<kotlin.reflect.KType> */
    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        List list = this.a;
        if (list != null) {
            return list;
        }
        List<KType> listOf = d.listOf(Reflection.nullableTypeOf(Object.class));
        this.a = listOf;
        return listOf;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public KVariance getVariance() {
        return this.d;
    }

    public int hashCode() {
        Object obj = this.b;
        return getName().hashCode() + ((obj != null ? obj.hashCode() : 0) * 31);
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return this.e;
    }

    public final void setUpperBounds(@NotNull List<? extends KType> list) {
        Intrinsics.checkNotNullParameter(list, "upperBounds");
        if (this.a == null) {
            this.a = list;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @NotNull
    public String toString() {
        return Companion.toString(this);
    }
}
