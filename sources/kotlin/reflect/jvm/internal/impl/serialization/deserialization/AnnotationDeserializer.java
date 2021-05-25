package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.e;
public final class AnnotationDeserializer {
    @NotNull
    public final ModuleDescriptor a;
    @NotNull
    public final NotFoundClasses b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        static {
            ProtoBuf.Annotation.Argument.Value.Type.values();
        }
    }

    public AnnotationDeserializer(@NotNull ModuleDescriptor moduleDescriptor, @NotNull NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, BaseAnalyticKt.ANALYTIC_FAIL_MODULE);
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.a = moduleDescriptor;
        this.b = notFoundClasses;
    }

    public final boolean a(ConstantValue<?> constantValue, KotlinType kotlinType, ProtoBuf.Annotation.Argument.Value value) {
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 10) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
            if (classDescriptor == null || KotlinBuiltIns.isKClass(classDescriptor)) {
                return true;
            }
        } else if (i != 13) {
            return Intrinsics.areEqual(constantValue.getType(this.a), kotlinType);
        } else {
            if ((constantValue instanceof ArrayValue) && ((List) ((ArrayValue) constantValue).getValue()).size() == value.getArrayElementList().size()) {
                KotlinType arrayElementType = this.a.getBuiltIns().getArrayElementType(kotlinType);
                Intrinsics.checkNotNullExpressionValue(arrayElementType, "builtIns.getArrayElementType(expectedType)");
                ArrayValue arrayValue = (ArrayValue) constantValue;
                IntRange indices = CollectionsKt__CollectionsKt.getIndices((Collection) arrayValue.getValue());
                if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
                    return true;
                }
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                    Intrinsics.checkNotNullExpressionValue(arrayElement, "value.getArrayElement(i)");
                    if (!a((ConstantValue) ((List) arrayValue.getValue()).get(nextInt), arrayElementType, arrayElement)) {
                    }
                }
                return true;
            }
            throw new IllegalStateException(Intrinsics.stringPlus("Deserialized ArrayValue should have the same number of elements as the original array value: ", constantValue).toString());
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.Pair] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor deserializeAnnotation(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r12) {
        /*
            r10 = this;
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            int r0 = r11.getId()
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getClassId(r12, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r1 = r10.a
            kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r2 = r10.b
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies(r1, r0, r2)
            java.util.Map r1 = t6.n.r.emptyMap()
            int r2 = r11.getArgumentCount()
            if (r2 == 0) goto L_0x0103
            boolean r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.isError(r0)
            if (r2 != 0) goto L_0x0103
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isAnnotationClass(r0)
            if (r2 == 0) goto L_0x0103
            java.util.Collection r2 = r0.getConstructors()
            java.lang.String r3 = "annotationClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r2
            if (r2 == 0) goto L_0x0103
            java.util.List r1 = r2.getValueParameters()
            java.lang.String r2 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = 10
            int r2 = t6.n.e.collectionSizeOrDefault(r1, r2)
            int r2 = t6.n.q.mapCapacity(r2)
            r3 = 16
            int r2 = t6.v.e.coerceAtLeast(r2, r3)
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>(r2)
            java.util.Iterator r1 = r1.iterator()
        L_0x0063:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0078
            java.lang.Object r2 = r1.next()
            r4 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r4.getName()
            r3.put(r4, r2)
            goto L_0x0063
        L_0x0078:
            java.util.List r11 = r11.getArgumentList()
            java.lang.String r1 = "proto.argumentList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x008a:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00ff
            java.lang.Object r2 = r11.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r2
            java.lang.String r4 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            int r4 = r2.getNameId()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r12, r4)
            java.lang.Object r4 = r3.get(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            r5 = 0
            if (r4 != 0) goto L_0x00ad
            goto L_0x00f9
        L_0x00ad:
            kotlin.Pair r6 = new kotlin.Pair
            int r7 = r2.getNameId()
            kotlin.reflect.jvm.internal.impl.name.Name r7 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r12, r7)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r4.getType()
            java.lang.String r8 = "parameter.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r2 = r2.getValue()
            java.lang.String r8 = "proto.value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r8)
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r8 = r10.resolveValue(r4, r2, r12)
            boolean r9 = r10.a(r8, r4, r2)
            if (r9 == 0) goto L_0x00d4
            r5 = r8
        L_0x00d4:
            if (r5 != 0) goto L_0x00f5
            kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue$Companion r5 = kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion
            java.lang.String r8 = "Unexpected argument value: actual type "
            java.lang.StringBuilder r8 = a2.b.a.a.a.L(r8)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value$Type r2 = r2.getType()
            r8.append(r2)
            java.lang.String r2 = " != expected type "
            r8.append(r2)
            r8.append(r4)
            java.lang.String r2 = r8.toString()
            kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue r5 = r5.create(r2)
        L_0x00f5:
            r6.<init>(r7, r5)
            r5 = r6
        L_0x00f9:
            if (r5 == 0) goto L_0x008a
            r1.add(r5)
            goto L_0x008a
        L_0x00ff:
            java.util.Map r1 = t6.n.r.toMap(r1)
        L_0x0103:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl r11 = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r0.getDefaultType()
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r0 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r11.<init>(r12, r1, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer.deserializeAnnotation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver):kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor");
    }

    @NotNull
    public final ConstantValue<?> resolveValue(@NotNull KotlinType kotlinType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull NameResolver nameResolver) {
        ConstantValue<?> constantValue;
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Boolean bool = Flags.IS_UNSIGNED.get(value.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = bool.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                byte intValue = (byte) ((int) value.getIntValue());
                if (booleanValue) {
                    constantValue = new UByteValue(intValue);
                    break;
                } else {
                    constantValue = new ByteValue(intValue);
                    break;
                }
            case 2:
                return new CharValue((char) ((int) value.getIntValue()));
            case 3:
                short intValue2 = (short) ((int) value.getIntValue());
                if (booleanValue) {
                    constantValue = new UShortValue(intValue2);
                    break;
                } else {
                    constantValue = new ShortValue(intValue2);
                    break;
                }
            case 4:
                int intValue3 = (int) value.getIntValue();
                return booleanValue ? new UIntValue(intValue3) : new IntValue(intValue3);
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new ULongValue(intValue4) : new LongValue(intValue4);
            case 6:
                return new FloatValue(value.getFloatValue());
            case 7:
                return new DoubleValue(value.getDoubleValue());
            case 8:
                return new BooleanValue(value.getIntValue() != 0);
            case 9:
                return new StringValue(nameResolver.getString(value.getStringValue()));
            case 10:
                return new KClassValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), value.getArrayDimensionCount());
            case 11:
                return new EnumValue(NameResolverUtilKt.getClassId(nameResolver, value.getClassId()), NameResolverUtilKt.getName(nameResolver, value.getEnumValueId()));
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                Intrinsics.checkNotNullExpressionValue(annotation, "value.annotation");
                return new AnnotationValue(deserializeAnnotation(annotation, nameResolver));
            case 13:
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                Intrinsics.checkNotNullExpressionValue(arrayElementList, "value.arrayElementList");
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(arrayElementList, 10));
                for (T t : arrayElementList) {
                    SimpleType anyType = this.a.getBuiltIns().getAnyType();
                    Intrinsics.checkNotNullExpressionValue(anyType, "builtIns.anyType");
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    arrayList.add(resolveValue(anyType, t, nameResolver));
                }
                return constantValueFactory.createArrayValue(arrayList, kotlinType);
            default:
                StringBuilder L = a.L("Unsupported annotation argument type: ");
                L.append(value.getType());
                L.append(" (expected ");
                L.append(kotlinType);
                L.append(')');
                throw new IllegalStateException(L.toString().toString());
        }
        return constantValue;
    }
}
