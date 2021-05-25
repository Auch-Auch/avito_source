package kotlin.reflect.jvm.internal.impl.builtins.functions;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
/* JADX WARN: Init of enum KFunction can be incorrect */
/* JADX WARN: Init of enum KSuspendFunction can be incorrect */
public enum FunctionClassKind {
    Function(StandardNames.BUILT_INS_PACKAGE_FQ_NAME, "Function"),
    SuspendFunction(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE, "SuspendFunction"),
    KFunction(r4, "KFunction"),
    KSuspendFunction(r4, "KSuspendFunction");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final FqName a;
    @NotNull
    public final String b;

    public static final class Companion {

        public static final class KindWithArity {
            @NotNull
            public final FunctionClassKind a;
            public final int b;

            public KindWithArity(@NotNull FunctionClassKind functionClassKind, int i) {
                Intrinsics.checkNotNullParameter(functionClassKind, MessageBody.Location.KIND);
                this.a = functionClassKind;
                this.b = i;
            }

            @NotNull
            public final FunctionClassKind component1() {
                return this.a;
            }

            public final int component2() {
                return this.b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof KindWithArity)) {
                    return false;
                }
                KindWithArity kindWithArity = (KindWithArity) obj;
                return this.a == kindWithArity.a && this.b == kindWithArity.b;
            }

            @NotNull
            public final FunctionClassKind getKind() {
                return this.a;
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("KindWithArity(kind=");
                L.append(this.a);
                L.append(", arity=");
                return a.i(L, this.b, ')');
            }
        }

        public Companion() {
        }

        @Nullable
        public final FunctionClassKind byClassNamePrefix(@NotNull FqName fqName, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            Intrinsics.checkNotNullParameter(str, "className");
            FunctionClassKind[] values = FunctionClassKind.values();
            for (int i = 0; i < 4; i++) {
                FunctionClassKind functionClassKind = values[i];
                if (Intrinsics.areEqual(functionClassKind.getPackageFqName(), fqName) && m.startsWith$default(str, functionClassKind.getClassNamePrefix(), false, 2, null)) {
                    return functionClassKind;
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind getFunctionalClassKind(@NotNull String str, @NotNull FqName fqName) {
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            KindWithArity parseClassName = parseClassName(str, fqName);
            if (parseClassName == null) {
                return null;
            }
            return parseClassName.getKind();
        }

        @Nullable
        public final KindWithArity parseClassName(@NotNull String str, @NotNull FqName fqName) {
            Integer num;
            Intrinsics.checkNotNullParameter(str, "className");
            Intrinsics.checkNotNullParameter(fqName, "packageFqName");
            FunctionClassKind byClassNamePrefix = byClassNamePrefix(fqName, str);
            if (byClassNamePrefix == null) {
                return null;
            }
            String substring = str.substring(byClassNamePrefix.getClassNamePrefix().length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            if (!(substring.length() == 0)) {
                int length = substring.length();
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= length) {
                        num = Integer.valueOf(i2);
                        break;
                    }
                    char charAt = substring.charAt(i);
                    i++;
                    int i3 = charAt - '0';
                    if (!(i3 >= 0 && i3 <= 9)) {
                        break;
                    }
                    i2 = (i2 * 10) + i3;
                }
            }
            num = null;
            if (num == null) {
                return null;
            }
            return new KindWithArity(byClassNamePrefix, num.intValue());
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    static {
        FqName fqName = StandardNames.KOTLIN_REFLECT_FQ_NAME;
    }

    /* access modifiers changed from: public */
    FunctionClassKind(FqName fqName, String str) {
        this.a = fqName;
        this.b = str;
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.b;
    }

    @NotNull
    public final FqName getPackageFqName() {
        return this.a;
    }

    @NotNull
    public final Name numberedClassName(int i) {
        Name identifier = Name.identifier(Intrinsics.stringPlus(this.b, Integer.valueOf(i)));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"$classNamePrefix$arity\")");
        return identifier;
    }
}
