package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.r;
public final class AnnotationUtilKt {
    @NotNull
    public static final Name a;
    @NotNull
    public static final Name b;
    @NotNull
    public static final Name c;
    @NotNull
    public static final Name d;
    @NotNull
    public static final Name e;

    public static final class a extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
        public final /* synthetic */ KotlinBuiltIns a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KotlinBuiltIns kotlinBuiltIns) {
            super(1);
            this.a = kotlinBuiltIns;
        }

        @Override // kotlin.jvm.functions.Function1
        public KotlinType invoke(ModuleDescriptor moduleDescriptor) {
            ModuleDescriptor moduleDescriptor2 = moduleDescriptor;
            Intrinsics.checkNotNullParameter(moduleDescriptor2, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
            SimpleType arrayType = moduleDescriptor2.getBuiltIns().getArrayType(Variance.INVARIANT, this.a.getStringType());
            Intrinsics.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
            return arrayType;
        }
    }

    static {
        Name identifier = Name.identifier("message");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"message\")");
        a = identifier;
        Name identifier2 = Name.identifier("replaceWith");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"replaceWith\")");
        b = identifier2;
        Name identifier3 = Name.identifier(FirebaseAnalytics.Param.LEVEL);
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"level\")");
        c = identifier3;
        Name identifier4 = Name.identifier("expression");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"expression\")");
        d = identifier4;
        Name identifier5 = Name.identifier("imports");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"imports\")");
        e = identifier5;
    }

    @NotNull
    public static final AnnotationDescriptor createDeprecatedAnnotation(@NotNull KotlinBuiltIns kotlinBuiltIns, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(str2, "replaceWith");
        Intrinsics.checkNotNullParameter(str3, FirebaseAnalytics.Param.LEVEL);
        BuiltInAnnotationDescriptor builtInAnnotationDescriptor = new BuiltInAnnotationDescriptor(kotlinBuiltIns, StandardNames.FqNames.replaceWith, r.mapOf(TuplesKt.to(d, new StringValue(str2)), TuplesKt.to(e, new ArrayValue(CollectionsKt__CollectionsKt.emptyList(), new a(kotlinBuiltIns)))));
        FqName fqName = StandardNames.FqNames.deprecated;
        Name name = c;
        ClassId classId = ClassId.topLevel(StandardNames.FqNames.deprecationLevel);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(StandardNames.FqNames.deprecationLevel)");
        Name identifier = Name.identifier(str3);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(level)");
        return new BuiltInAnnotationDescriptor(kotlinBuiltIns, fqName, r.mapOf(TuplesKt.to(a, new StringValue(str)), TuplesKt.to(b, new AnnotationValue(builtInAnnotationDescriptor)), TuplesKt.to(name, new EnumValue(classId, identifier))));
    }

    public static /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "WARNING";
        }
        return createDeprecatedAnnotation(kotlinBuiltIns, str, str2, str3);
    }
}
