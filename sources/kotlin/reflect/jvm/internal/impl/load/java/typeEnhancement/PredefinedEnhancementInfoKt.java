package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
public final class PredefinedEnhancementInfoKt {
    @NotNull
    public static final JavaTypeQualifiers a = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    @NotNull
    public static final JavaTypeQualifiers b;
    @NotNull
    public static final JavaTypeQualifiers c;
    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> d;

    public static final class a extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class a0 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a0(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(JvmPrimitiveType.BOOLEAN);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b0 extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(JvmPrimitiveType.BOOLEAN);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ SignatureBuildingComponents a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(SignatureBuildingComponents signatureBuildingComponents) {
            super(1);
            this.a = signatureBuildingComponents;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a.javaUtil("Spliterator"), PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(JvmPrimitiveType.BOOLEAN);
            return Unit.INSTANCE;
        }
    }

    public static final class i extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class l extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class m extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(JvmPrimitiveType.BOOLEAN);
            return Unit.INSTANCE;
        }
    }

    public static final class p extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.a, PredefinedEnhancementInfoKt.a);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b);
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c, PredefinedEnhancementInfoKt.a);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    public static final class t extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b);
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.c);
            functionEnhancementBuilder2.parameter(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c, PredefinedEnhancementInfoKt.c, PredefinedEnhancementInfoKt.a);
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    public static final class u extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public u(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c);
            return Unit.INSTANCE;
        }
    }

    public static final class v extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public v(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.c);
            functionEnhancementBuilder2.returns(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c);
            return Unit.INSTANCE;
        }
    }

    public static final class w extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(String str, String str2) {
            super(1);
            this.a = str;
            this.b = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.a);
            functionEnhancementBuilder2.returns(this.b, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c);
            return Unit.INSTANCE;
        }
    }

    public static final class x extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public x(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.c);
            return Unit.INSTANCE;
        }
    }

    public static final class y extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.parameter(this.a, PredefinedEnhancementInfoKt.b, PredefinedEnhancementInfoKt.c);
            return Unit.INSTANCE;
        }
    }

    public static final class z extends Lambda implements Function1<SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder, Unit> {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public z(String str) {
            super(1);
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder) {
            SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder functionEnhancementBuilder2 = functionEnhancementBuilder;
            Intrinsics.checkNotNullParameter(functionEnhancementBuilder2, "<this>");
            functionEnhancementBuilder2.returns(this.a, PredefinedEnhancementInfoKt.a);
            return Unit.INSTANCE;
        }
    }

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        b = new JavaTypeQualifiers(nullabilityQualifier, null, false, false, 8, null);
        c = new JavaTypeQualifiers(nullabilityQualifier, null, true, false, 8, null);
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")).function("forEachRemaining", new a(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new g(signatureBuildingComponents));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder.function("removeIf", new h(javaFunction));
        classEnhancementBuilder.function("stream", new i(javaUtil));
        classEnhancementBuilder.function("parallelStream", new j(javaUtil));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new k(javaFunction6));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder2.function("forEach", new l(javaFunction5));
        classEnhancementBuilder2.function("putIfAbsent", new m(javaLang));
        classEnhancementBuilder2.function("replace", new n(javaLang));
        classEnhancementBuilder2.function("replace", new o(javaLang));
        classEnhancementBuilder2.function("replaceAll", new p(javaFunction4));
        classEnhancementBuilder2.function("compute", new q(javaLang, javaFunction4));
        classEnhancementBuilder2.function("computeIfAbsent", new r(javaLang, javaFunction2));
        classEnhancementBuilder2.function("computeIfPresent", new s(javaLang, javaFunction4));
        classEnhancementBuilder2.function("merge", new t(javaLang, javaFunction4));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaUtil2);
        classEnhancementBuilder3.function("empty", new u(javaUtil2));
        classEnhancementBuilder3.function("of", new v(javaLang, javaUtil2));
        classEnhancementBuilder3.function("ofNullable", new w(javaLang, javaUtil2));
        classEnhancementBuilder3.function("get", new x(javaLang));
        classEnhancementBuilder3.function("ifPresent", new y(javaFunction3));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new z(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction).function("test", new a0(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new b0(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction3).function("accept", new b(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction5).function("accept", new c(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction2).function("apply", new d(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, javaFunction4).function("apply", new e(javaLang));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")).function("get", new f(javaLang));
        d = signatureEnhancementBuilder.a;
    }

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return d;
    }
}
