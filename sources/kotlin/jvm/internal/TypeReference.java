package kotlin.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@SinceKotlin(version = "1.4")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fR\u001c\u0010\u0012\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00138V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", AuthSource.SEND_ABUSE, "Lkotlin/reflect/KClassifier;", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier", "", "Lkotlin/reflect/KTypeProjection;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "arguments", "", "getAnnotations", "annotations", "c", "Z", "isMarkedNullable", "()Z", "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class TypeReference implements KType {
    @NotNull
    public final KClassifier a;
    @NotNull
    public final List<KTypeProjection> b;
    public final boolean c;

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

    public static final class a extends Lambda implements Function1<KTypeProjection, CharSequence> {
        public final /* synthetic */ TypeReference a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TypeReference typeReference) {
            super(1);
            this.a = typeReference;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(KTypeProjection kTypeProjection) {
            KTypeProjection kTypeProjection2 = kTypeProjection;
            Intrinsics.checkNotNullParameter(kTypeProjection2, "it");
            return TypeReference.access$asString(this.a, kTypeProjection2);
        }
    }

    public TypeReference(@NotNull KClassifier kClassifier, @NotNull List<KTypeProjection> list, boolean z) {
        Intrinsics.checkNotNullParameter(kClassifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.a = kClassifier;
        this.b = list;
        this.c = z;
    }

    public static final String access$asString(TypeReference typeReference, KTypeProjection kTypeProjection) {
        String str;
        Objects.requireNonNull(typeReference);
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        KType type = kTypeProjection.getType();
        if (!(type instanceof TypeReference)) {
            type = null;
        }
        TypeReference typeReference2 = (TypeReference) type;
        if (typeReference2 == null || (str = typeReference2.a()) == null) {
            str = String.valueOf(kTypeProjection.getType());
        }
        KVariance variance = kTypeProjection.getVariance();
        if (variance != null) {
            int ordinal = variance.ordinal();
            if (ordinal == 0) {
                return str;
            }
            if (ordinal == 1) {
                return a2.b.a.a.a.c3("in ", str);
            }
            if (ordinal == 2) {
                return a2.b.a.a.a.c3("out ", str);
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String a() {
        String str;
        String str2;
        KClassifier classifier = getClassifier();
        Class cls = null;
        if (!(classifier instanceof KClass)) {
            classifier = null;
        }
        KClass kClass = (KClass) classifier;
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        if (cls == null) {
            str = getClassifier().toString();
        } else if (!cls.isArray()) {
            str = cls.getName();
        } else if (Intrinsics.areEqual(cls, boolean[].class)) {
            str = "kotlin.BooleanArray";
        } else if (Intrinsics.areEqual(cls, char[].class)) {
            str = "kotlin.CharArray";
        } else if (Intrinsics.areEqual(cls, byte[].class)) {
            str = "kotlin.ByteArray";
        } else if (Intrinsics.areEqual(cls, short[].class)) {
            str = "kotlin.ShortArray";
        } else if (Intrinsics.areEqual(cls, int[].class)) {
            str = "kotlin.IntArray";
        } else if (Intrinsics.areEqual(cls, float[].class)) {
            str = "kotlin.FloatArray";
        } else if (Intrinsics.areEqual(cls, long[].class)) {
            str = "kotlin.LongArray";
        } else {
            str = Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
        }
        String str3 = "";
        if (getArguments().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new a(this), 24, null);
        }
        if (isMarkedNullable()) {
            str3 = "?";
        }
        return a2.b.a.a.a.e3(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && isMarkedNullable() == typeReference.isMarkedNullable()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.b;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public KClassifier getClassifier() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = getArguments().hashCode();
        return Boolean.valueOf(isMarkedNullable()).hashCode() + ((hashCode + (getClassifier().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.c;
    }

    @NotNull
    public String toString() {
        return a() + " (Kotlin reflection is not available)";
    }
}
