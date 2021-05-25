package org.kodein.di;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00000\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH&¢\u0006\u0004\b\u0015\u0010\u0011J\u0019\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001a\u001a\u00020\u000f2\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lorg/kodein/di/TypeToken;", "T", "", "", "simpleDispString", "()Ljava/lang/String;", "simpleErasedDispString", "fullDispString", "fullErasedDispString", "disp", "", "checkIsReified", "(Ljava/lang/Object;)V", "getRaw", "()Lorg/kodein/di/TypeToken;", "", "isGeneric", "()Z", "", "getGenericParameters", "()[Lorg/kodein/di/TypeToken;", "isWildcard", "", "getSuper", "()Ljava/util/List;", "typeToken", "isAssignableFrom", "(Lorg/kodein/di/TypeToken;)Z", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface TypeToken<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static <T> boolean isAssignableFrom(TypeToken<T> typeToken, @NotNull TypeToken<?> typeToken2) {
            Intrinsics.checkParameterIsNotNull(typeToken2, "typeToken");
            if (Intrinsics.areEqual(typeToken, typeToken2) || Intrinsics.areEqual(typeToken, TypeTokenKt.getAnyToken())) {
                return true;
            }
            TypeToken<T> raw = typeToken.getRaw();
            if (raw == null || !Intrinsics.areEqual(raw, typeToken2.getRaw())) {
                List<TypeToken<?>> list = typeToken2.getSuper();
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (typeToken.isAssignableFrom(it.next())) {
                            return true;
                        }
                    }
                }
                return false;
            }
            TypeToken<?>[] genericParameters = typeToken.getGenericParameters();
            if (genericParameters.length == 0) {
                return true;
            }
            TypeToken<?>[] genericParameters2 = typeToken2.getGenericParameters();
            int length = genericParameters.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                if (!genericParameters[i].isAssignableFrom(genericParameters2[i2])) {
                    return false;
                }
                i++;
                i2 = i3;
            }
            return true;
        }
    }

    void checkIsReified(@NotNull Object obj);

    @NotNull
    String fullDispString();

    @NotNull
    String fullErasedDispString();

    @NotNull
    TypeToken<?>[] getGenericParameters();

    @Nullable
    TypeToken<T> getRaw();

    @NotNull
    List<TypeToken<?>> getSuper();

    boolean isAssignableFrom(@NotNull TypeToken<?> typeToken);

    boolean isGeneric();

    boolean isWildcard();

    @NotNull
    String simpleDispString();

    @NotNull
    String simpleErasedDispString();
}
