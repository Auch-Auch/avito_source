package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a+\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a,\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\r\u001a\u00020\f*\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\f¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\f*\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\f¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u001e\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\bH\b¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"T", "Ljava/lang/Class;", "", "fieldName", "value", "", "updateField", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V", "", "safeCast", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "other", "", "classEquals", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "classDoesNotEqual", "cast", "(Ljava/lang/Object;)Ljava/lang/Object;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class ClassesKt {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> T cast(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "$this$cast");
        Intrinsics.reifiedOperationMarker(2, "T");
        return obj;
    }

    public static final boolean classDoesNotEqual(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "$this$classDoesNotEqual");
        Intrinsics.checkNotNullParameter(obj2, "other");
        return !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(obj.getClass()), Reflection.getOrCreateKotlinClass(obj2.getClass()));
    }

    public static final boolean classEquals(@NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "$this$classEquals");
        Intrinsics.checkNotNullParameter(obj2, "other");
        return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(obj.getClass()), Reflection.getOrCreateKotlinClass(obj2.getClass()));
    }

    @Nullable
    public static final <T> T safeCast(@NotNull Class<T> cls, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(cls, "$this$safeCast");
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static final <T> void updateField(@NotNull Class<?> cls, @NotNull String str, T t) {
        Intrinsics.checkNotNullParameter(cls, "$this$updateField");
        Intrinsics.checkNotNullParameter(str, "fieldName");
        try {
            Field declaredField = cls.getDeclaredField(str);
            Intrinsics.checkNotNullExpressionValue(declaredField, AnalyticFieldsName.field);
            declaredField.setAccessible(true);
            declaredField.set(null, t);
        } catch (NoSuchFieldException unused) {
        }
    }
}
