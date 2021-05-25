package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0004\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\n\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000f\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00022\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\r\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"T", "", "", AnalyticFieldsName.field, "getFieldValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "Lkotlin/Function1;", "Ljava/lang/reflect/Field;", "", "mutator", "setFieldValue", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "method", "", "arguments", "executeMethod", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "Ljava/lang/reflect/Type;", "firstRawArgumentType", "(Ljava/lang/reflect/Type;)Ljava/lang/reflect/Type;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class ReflectionKt {
    public static final void executeMethod(@NotNull Object obj, @NotNull String str, @NotNull Object... objArr) {
        Method method;
        Intrinsics.checkNotNullParameter(obj, "$this$executeMethod");
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(objArr, "arguments");
        Method[] methods = obj.getClass().getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "javaClass.methods");
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            method = methods[i];
            Intrinsics.checkNotNullExpressionValue(method, "it");
            if (Intrinsics.areEqual(method.getName(), str)) {
                break;
            }
            i++;
        }
        Intrinsics.checkNotNull(method);
        method.setAccessible(true);
        method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    @Nullable
    public static final Type firstRawArgumentType(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "$this$firstRawArgumentType");
        if (!(type instanceof ParameterizedType)) {
            return null;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Type) {
            return type2;
        }
        return null;
    }

    public static final /* synthetic */ <T> T getFieldValue(Object obj, String str) {
        Intrinsics.checkNotNullParameter(obj, "$this$getFieldValue");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.field);
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        T t = (T) declaredField.get(obj);
        Intrinsics.reifiedOperationMarker(1, "T");
        return t;
    }

    public static final void setFieldValue(@NotNull Object obj, @NotNull String str, @NotNull Function1<? super Field, Unit> function1) {
        Intrinsics.checkNotNullParameter(obj, "$this$setFieldValue");
        Intrinsics.checkNotNullParameter(str, AnalyticFieldsName.field);
        Intrinsics.checkNotNullParameter(function1, "mutator");
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        function1.invoke(declaredField);
    }
}
