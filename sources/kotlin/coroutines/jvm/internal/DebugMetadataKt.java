package kotlin.coroutines.jvm.internal;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.p.b.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r*\u00020\u0000H\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)Ljava/lang/StackTraceElement;", "getStackTraceElementImpl", "", AuthSource.BOOKING_ORDER, "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)I", "expected", "actual", "", AuthSource.SEND_ABUSE, "(II)V", "", "", "getSpilledVariableFieldMapping", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class DebugMetadataKt {
    public static final void a(int i, int i2) {
        if (i2 > i) {
            throw new IllegalStateException(a.S2("Debug metadata version mismatch. Expected: ", i, ", got ", i2, ". Please update the Kotlin standard library.").toString());
        }
    }

    public static final int b(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            Intrinsics.checkNotNullExpressionValue(declaredField, AnalyticFieldsName.field);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getSpilledVariableFieldMapping")
    @Nullable
    public static final String[] getSpilledVariableFieldMapping(@NotNull BaseContinuationImpl baseContinuationImpl) {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getSpilledVariableFieldMapping");
        DebugMetadata debugMetadata = (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
        if (debugMetadata == null) {
            return null;
        }
        a(1, debugMetadata.v());
        ArrayList arrayList = new ArrayList();
        int b = b(baseContinuationImpl);
        int[] i = debugMetadata.i();
        int length = i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i[i2] == b) {
                arrayList.add(debugMetadata.s()[i2]);
                arrayList.add(debugMetadata.n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @SinceKotlin(version = "1.3")
    @JvmName(name = "getStackTraceElement")
    @Nullable
    public static final StackTraceElement getStackTraceElement(@NotNull BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata debugMetadata = (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
        String str2 = null;
        if (debugMetadata == null) {
            return null;
        }
        a(1, debugMetadata.v());
        int b = b(baseContinuationImpl);
        if (b < 0) {
            i = -1;
        } else {
            i = debugMetadata.l()[b];
        }
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "continuation");
        a.C0681a aVar = t6.p.b.a.a.b;
        if (aVar == null) {
            try {
                a.C0681a aVar2 = new a.C0681a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
                t6.p.b.a.a.b = aVar2;
                aVar = aVar2;
            } catch (Exception unused) {
                aVar = t6.p.b.a.a.a;
                t6.p.b.a.a.b = aVar;
            }
        }
        if (!(aVar == t6.p.b.a.a.a || (method = aVar.a) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null)) {
            Method method3 = aVar.c;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
            if (invoke3 instanceof String) {
                str2 = invoke3;
            }
            str2 = str2;
        }
        if (str2 == null) {
            str = debugMetadata.c();
        } else {
            str = str2 + '/' + debugMetadata.c();
        }
        return new StackTraceElement(str, debugMetadata.m(), debugMetadata.f(), i);
    }
}
