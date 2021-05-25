package com.avito.android.remote.model.category_parameters;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R,\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00070\u0006*\u00020\u00018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\u0002*\u00020\u000b8B@\u0002X\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/BaseParametersConverter;", "", "", "", "toFormValue", "(Z)Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "getFields", "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "fields", "Ljava/lang/reflect/Method;", "isPublicGetter", "api_release"}, k = 1, mv = {1, 4, 2})
public interface BaseParametersConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        @NotNull
        public static Sequence<Pair<String, Object>> getFields(@NotNull BaseParametersConverter baseParametersConverter, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "$this$fields");
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "this::class.java.declaredMethods");
            return SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filter(ArraysKt___ArraysKt.asSequence(declaredMethods), new BaseParametersConverter$fields$1(baseParametersConverter)), BaseParametersConverter$fields$2.INSTANCE), new BaseParametersConverter$fields$3(obj)), BaseParametersConverter$fields$4.INSTANCE);
        }

        /* access modifiers changed from: private */
        public static boolean isPublicGetter(BaseParametersConverter baseParametersConverter, Method method) {
            if (Modifier.isPublic(method.getModifiers())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
                if (parameterTypes.length == 0) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public static String toFormValue(@NotNull BaseParametersConverter baseParametersConverter, boolean z) {
            return z ? "1" : "";
        }
    }

    @NotNull
    Sequence<Pair<String, Object>> getFields(@NotNull Object obj);

    @NotNull
    String toFormValue(boolean z);
}
