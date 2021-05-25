package kotlin.reflect.jvm.internal.calls;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002+,BA\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\b\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020'\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\b¢\u0006\u0004\b)\u0010*J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR \u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u000bR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u000bR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020$0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u000b¨\u0006-"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "Ljava/lang/reflect/Type;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes", "Ljava/lang/Class;", "d", "Ljava/lang/Class;", "jClass", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "f", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "callMode", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "c", "defaultValues", "getMember", "()Ljava/lang/Void;", "member", AuthSource.BOOKING_ORDER, "erasedParameterTypes", "Ljava/lang/reflect/Method;", g.a, "methods", "", "e", "parameterNames", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "origin", "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class AnnotationConstructorCaller implements Caller {
    @NotNull
    public final List<Type> a;
    public final List<Class<?>> b;
    public final List<Object> c;
    public final Class<?> d;
    public final List<String> e;
    public final CallMode f;
    public final List<Method> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "<init>", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@NotNull Class<?> cls, @NotNull List<String> list, @NotNull CallMode callMode, @NotNull Origin origin, @NotNull List<Method> list2) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter(list, "parameterNames");
        Intrinsics.checkNotNullParameter(callMode, "callMode");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(list2, "methods");
        this.d = cls;
        this.e = list;
        this.f = callMode;
        this.g = list2;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.g;
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list3, 10));
        Iterator<T> it2 = list3.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = it2.next().getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType, "it");
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(returnType);
            if (wrapperByPrimitive != null) {
                returnType = wrapperByPrimitive;
            }
            arrayList2.add(returnType);
        }
        this.b = arrayList2;
        List<Method> list4 = this.g;
        ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(list4, 10));
        Iterator<T> it3 = list4.iterator();
        while (it3.hasNext()) {
            arrayList3.add(it3.next().getDefaultValue());
        }
        this.c = arrayList3;
        if (this.f == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (!CollectionsKt___CollectionsKt.minus(this.e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            int i3 = i2 + 1;
            if (obj2 == null && this.f == CallMode.CALL_BY_NAME) {
                obj = this.c.get(i2);
            } else {
                obj = AnnotationConstructorCallerKt.access$transformKotlinToJvm(obj2, this.b.get(i2));
            }
            if (obj != null) {
                arrayList.add(obj);
                i++;
                i2 = i3;
            } else {
                AnnotationConstructorCallerKt.access$throwIllegalArgumentType(i2, this.e.get(i2), this.b.get(i2));
                throw null;
            }
        }
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.d, r.toMap(CollectionsKt___CollectionsKt.zip(this.e, arrayList)), this.g);
    }

    public void checkArguments(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Void getMember() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, t6.r.a.j r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L_0x002a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = t6.n.e.collectionSizeOrDefault(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L_0x0013:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x002a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L_0x0013
        L_0x002a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, t6.r.a.j):void");
    }
}
