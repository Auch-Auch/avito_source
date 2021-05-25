package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class Checks {
    @Nullable
    public final Name a;
    @Nullable
    public final Regex b;
    @Nullable
    public final Collection<Name> c;
    @NotNull
    public final Function1<FunctionDescriptor, String> d;
    @NotNull
    public final Check[] e;

    public static final class a extends Lambda implements Function1 {
        public static final a a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter((FunctionDescriptor) obj, "<this>");
            return null;
        }
    }

    public static final class b extends Lambda implements Function1 {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter((FunctionDescriptor) obj, "<this>");
            return null;
        }
    }

    public static final class c extends Lambda implements Function1 {
        public static final c a = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            Intrinsics.checkNotNullParameter((FunctionDescriptor) obj, "<this>");
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public Checks(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.a = null;
        this.b = regex;
        this.c = collection;
        this.d = function1;
        this.e = checkArr;
    }

    @NotNull
    public final CheckResult checkAll(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        Check[] checkArr = this.e;
        int length = checkArr.length;
        int i = 0;
        while (i < length) {
            Check check = checkArr[i];
            i++;
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String invoke2 = this.d.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new CheckResult.IllegalSignature(invoke2);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    public final boolean isApplicable(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.a != null && !Intrinsics.areEqual(functionDescriptor.getName(), this.a)) {
            return false;
        }
        if (this.b != null) {
            String asString = functionDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "functionDescriptor.name.asString()");
            if (!this.b.matches(asString)) {
                return false;
            }
        }
        Collection<Name> collection = this.c;
        if (collection == null || collection.contains(functionDescriptor.getName())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Name name, Check[] checkArr, Function1 function1, int i, j jVar) {
        this(name, checkArr, (i & 4) != 0 ? a.a : function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public Checks(@NotNull Name name, @NotNull Check[] checkArr, @NotNull Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(checkArr, "checks");
        Intrinsics.checkNotNullParameter(function1, "additionalChecks");
        Check[] checkArr2 = new Check[checkArr.length];
        System.arraycopy(checkArr, 0, checkArr2, 0, checkArr.length);
        this.a = name;
        this.b = null;
        this.c = null;
        this.d = function1;
        this.e = checkArr2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Regex regex, Check[] checkArr, Function1 function1, int i, j jVar) {
        this(regex, checkArr, (i & 4) != 0 ? b.a : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Checks(@org.jetbrains.annotations.NotNull kotlin.text.Regex r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.util.Check[] r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "regex"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r4 = 0
            r1 = r7
            r3 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(kotlin.text.Regex, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i, j jVar) {
        this(collection, checkArr, (i & 4) != 0 ? c.a : function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Checks(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name> r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.util.Check[] r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "nameList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(java.util.Collection, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.jvm.functions.Function1):void");
    }
}
