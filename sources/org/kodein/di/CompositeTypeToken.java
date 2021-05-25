package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u001a\u0010'\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0017\"\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000fR%\u0010'\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019¨\u0006*"}, d2 = {"Lorg/kodein/di/CompositeTypeToken;", "T", "Lorg/kodein/di/TypeToken;", "", "simpleDispString", "()Ljava/lang/String;", "simpleErasedDispString", "fullDispString", "fullErasedDispString", "", "disp", "", "checkIsReified", "(Ljava/lang/Object;)V", "getRaw", "()Lorg/kodein/di/TypeToken;", "", "isGeneric", "()Z", "isWildcard", "", "getSuper", "()Ljava/util/List;", "", "getGenericParameters", "()[Lorg/kodein/di/TypeToken;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getMain", "main", AuthSource.BOOKING_ORDER, "[Lorg/kodein/di/TypeToken;", "getParams", "params", "<init>", "(Lorg/kodein/di/TypeToken;[Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class CompositeTypeToken<T> implements TypeToken<T> {
    @NotNull
    public final TypeToken<T> a;
    @NotNull
    public final TypeToken<?>[] b;

    public static final class a extends Lambda implements Function1<TypeToken<?>, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(TypeToken<?> typeToken) {
            TypeToken<?> typeToken2 = typeToken;
            Intrinsics.checkParameterIsNotNull(typeToken2, "it");
            return typeToken2.fullDispString();
        }
    }

    public static final class b extends Lambda implements Function1<TypeToken<?>, String> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(TypeToken<?> typeToken) {
            TypeToken<?> typeToken2 = typeToken;
            Intrinsics.checkParameterIsNotNull(typeToken2, "it");
            return typeToken2.simpleDispString();
        }
    }

    public CompositeTypeToken(@NotNull TypeToken<T> typeToken, @NotNull TypeToken<?>... typeTokenArr) {
        Intrinsics.checkParameterIsNotNull(typeToken, "main");
        Intrinsics.checkParameterIsNotNull(typeTokenArr, "params");
        this.a = typeToken;
        this.b = typeTokenArr;
        if (typeTokenArr.length == 0) {
            throw new IllegalStateException("CompositeTypeToken must be given at least one type parameter");
        }
    }

    @Override // org.kodein.di.TypeToken
    public void checkIsReified(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "disp");
        this.a.checkIsReified(obj);
        for (TypeToken<?> typeToken : this.b) {
            typeToken.checkIsReified(obj);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeTypeToken)) {
            return false;
        }
        CompositeTypeToken compositeTypeToken = (CompositeTypeToken) obj;
        if (!Intrinsics.areEqual(this.a, compositeTypeToken.a) || !Arrays.equals(this.b, compositeTypeToken.b)) {
            return false;
        }
        return true;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullDispString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.fullErasedDispString());
        sb.append(Typography.less);
        return a2.b.a.a.a.s(sb, ArraysKt___ArraysKt.joinToString$default(this.b, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, a.a, 30, (Object) null), Typography.greater);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String fullErasedDispString() {
        return this.a.fullErasedDispString();
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public TypeToken<?>[] getGenericParameters() {
        return this.b;
    }

    @NotNull
    public final TypeToken<T> getMain() {
        return this.a;
    }

    @NotNull
    public final TypeToken<?>[] getParams() {
        return this.b;
    }

    @Override // org.kodein.di.TypeToken
    @Nullable
    public TypeToken<T> getRaw() {
        return this.a.getRaw();
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public List<TypeToken<?>> getSuper() {
        return this.a.getSuper();
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Arrays.hashCode(this.b);
    }

    @Override // org.kodein.di.TypeToken
    public boolean isAssignableFrom(@NotNull TypeToken<?> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "typeToken");
        return TypeToken.DefaultImpls.isAssignableFrom(this, typeToken);
    }

    @Override // org.kodein.di.TypeToken
    public boolean isGeneric() {
        return true;
    }

    @Override // org.kodein.di.TypeToken
    public boolean isWildcard() {
        return false;
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String simpleDispString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.simpleErasedDispString());
        sb.append(Typography.less);
        return a2.b.a.a.a.s(sb, ArraysKt___ArraysKt.joinToString$default(this.b, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.a, 30, (Object) null), Typography.greater);
    }

    @Override // org.kodein.di.TypeToken
    @NotNull
    public String simpleErasedDispString() {
        return this.a.simpleErasedDispString();
    }
}
