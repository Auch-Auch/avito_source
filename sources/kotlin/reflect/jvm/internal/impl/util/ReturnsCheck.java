package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public abstract class ReturnsCheck implements Check {
    @NotNull
    public final String a;
    @NotNull
    public final Function1<KotlinBuiltIns, KotlinType> b;
    @NotNull
    public final String c;

    public static final class ReturnsBoolean extends ReturnsCheck {
        @NotNull
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                KotlinBuiltIns kotlinBuiltIns2 = kotlinBuiltIns;
                Intrinsics.checkNotNullParameter(kotlinBuiltIns2, "<this>");
                SimpleType booleanType = kotlinBuiltIns2.getBooleanType();
                Intrinsics.checkNotNullExpressionValue(booleanType, "booleanType");
                return booleanType;
            }
        }

        public ReturnsBoolean() {
            super("Boolean", a.a, null);
        }
    }

    public static final class ReturnsInt extends ReturnsCheck {
        @NotNull
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                KotlinBuiltIns kotlinBuiltIns2 = kotlinBuiltIns;
                Intrinsics.checkNotNullParameter(kotlinBuiltIns2, "<this>");
                SimpleType intType = kotlinBuiltIns2.getIntType();
                Intrinsics.checkNotNullExpressionValue(intType, "intType");
                return intType;
            }
        }

        public ReturnsInt() {
            super("Int", a.a, null);
        }
    }

    public static final class ReturnsUnit extends ReturnsCheck {
        @NotNull
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        public static final class a extends Lambda implements Function1<KotlinBuiltIns, KotlinType> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public KotlinType invoke(KotlinBuiltIns kotlinBuiltIns) {
                KotlinBuiltIns kotlinBuiltIns2 = kotlinBuiltIns;
                Intrinsics.checkNotNullParameter(kotlinBuiltIns2, "<this>");
                SimpleType unitType = kotlinBuiltIns2.getUnitType();
                Intrinsics.checkNotNullExpressionValue(unitType, "unitType");
                return unitType;
            }
        }

        public ReturnsUnit() {
            super("Unit", a.a, null);
        }
    }

    public ReturnsCheck(String str, Function1 function1, j jVar) {
        this.a = str;
        this.b = function1;
        this.c = Intrinsics.stringPlus("must return ", str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.b.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @NotNull
    public String getDescription() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    @Nullable
    public String invoke(@NotNull FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
