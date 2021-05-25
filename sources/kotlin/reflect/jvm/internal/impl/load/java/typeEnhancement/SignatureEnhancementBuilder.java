package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.q;
public final class SignatureEnhancementBuilder {
    @NotNull
    public final Map<String, PredefinedFunctionEnhancementInfo> a = new LinkedHashMap();

    public final class ClassEnhancementBuilder {
        @NotNull
        public final String a;
        public final /* synthetic */ SignatureEnhancementBuilder b;

        public ClassEnhancementBuilder(@NotNull SignatureEnhancementBuilder signatureEnhancementBuilder, String str) {
            Intrinsics.checkNotNullParameter(signatureEnhancementBuilder, "this$0");
            Intrinsics.checkNotNullParameter(str, "className");
            this.b = signatureEnhancementBuilder;
            this.a = str;
        }

        public final void function(@NotNull String str, @NotNull Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(function1, "block");
            Map<String, PredefinedFunctionEnhancementInfo> map = this.b.a;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, str);
            function1.invoke(functionEnhancementBuilder);
            Pair<String, PredefinedFunctionEnhancementInfo> build = functionEnhancementBuilder.build();
            map.put(build.getFirst(), build.getSecond());
        }

        @NotNull
        public final String getClassName() {
            return this.a;
        }

        public final class FunctionEnhancementBuilder {
            @NotNull
            public final String a;
            @NotNull
            public final List<Pair<String, TypeEnhancementInfo>> b = new ArrayList();
            @NotNull
            public Pair<String, TypeEnhancementInfo> c = TuplesKt.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            public final /* synthetic */ ClassEnhancementBuilder d;

            public FunctionEnhancementBuilder(@NotNull ClassEnhancementBuilder classEnhancementBuilder, String str) {
                Intrinsics.checkNotNullParameter(classEnhancementBuilder, "this$0");
                Intrinsics.checkNotNullParameter(str, "functionName");
                this.d = classEnhancementBuilder;
                this.a = str;
            }

            @NotNull
            public final Pair<String, PredefinedFunctionEnhancementInfo> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
                String className = this.d.getClassName();
                String functionName = getFunctionName();
                List<Pair<String, TypeEnhancementInfo>> list = this.b;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next().getFirst());
                }
                String signature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(functionName, arrayList, this.c.getFirst()));
                TypeEnhancementInfo second = this.c.getSecond();
                List<Pair<String, TypeEnhancementInfo>> list2 = this.b;
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((TypeEnhancementInfo) it2.next().getSecond());
                }
                return TuplesKt.to(signature, new PredefinedFunctionEnhancementInfo(second, arrayList2));
            }

            @NotNull
            public final String getFunctionName() {
                return this.a;
            }

            public final void parameter(@NotNull String str, @NotNull JavaTypeQualifiers... javaTypeQualifiersArr) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> list = this.b;
                if (javaTypeQualifiersArr.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex(javaTypeQualifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(withIndex, 10)), 16));
                    for (IndexedValue indexedValue : withIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                list.add(TuplesKt.to(str, typeEnhancementInfo));
            }

            public final void returns(@NotNull String str, @NotNull JavaTypeQualifiers... javaTypeQualifiersArr) {
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                Iterable<IndexedValue> withIndex = ArraysKt___ArraysKt.withIndex(javaTypeQualifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(e.collectionSizeOrDefault(withIndex, 10)), 16));
                for (IndexedValue indexedValue : withIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (JavaTypeQualifiers) indexedValue.getValue());
                }
                this.c = TuplesKt.to(str, new TypeEnhancementInfo(linkedHashMap));
            }

            public final void returns(@NotNull JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics.checkNotNullParameter(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "type.desc");
                this.c = TuplesKt.to(desc, null);
            }
        }
    }
}
