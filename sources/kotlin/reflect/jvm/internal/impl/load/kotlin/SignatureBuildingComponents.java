package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
public final class SignatureBuildingComponents {
    @NotNull
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    public static final class a extends Lambda implements Function1<String, CharSequence> {
        public final /* synthetic */ SignatureBuildingComponents a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SignatureBuildingComponents signatureBuildingComponents) {
            super(1);
            this.a = signatureBuildingComponents;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            return this.a.a(str2);
        }
    }

    public final String a(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return Matrix.MATRIX_TYPE_RANDOM_LT + str + ';';
    }

    @NotNull
    public final String[] constructors(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    @NotNull
    public final Set<String> inClass(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + FormatterType.defaultDecimalSeparator + str2);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> inJavaLang(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        String javaLang = javaLang(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(javaLang, strArr2);
    }

    @NotNull
    public final Set<String> inJavaUtil(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        String javaUtil = javaUtil(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(javaUtil, strArr2);
    }

    @NotNull
    public final String javaFunction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return Intrinsics.stringPlus("java/util/function/", str);
    }

    @NotNull
    public final String javaLang(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return Intrinsics.stringPlus("java/lang/", str);
    }

    @NotNull
    public final String javaUtil(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return Intrinsics.stringPlus("java/util/", str);
    }

    @NotNull
    public final String jvmDescriptor(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        Intrinsics.checkNotNullParameter(str2, "ret");
        return str + '(' + CollectionsKt___CollectionsKt.joinToString$default(list, "", null, null, 0, null, new a(this), 30, null) + ')' + a(str2);
    }

    @NotNull
    public final String signature(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(str2, "jvmDescriptor");
        return str + FormatterType.defaultDecimalSeparator + str2;
    }
}
