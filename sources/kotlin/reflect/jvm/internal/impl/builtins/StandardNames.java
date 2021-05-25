package kotlin.reflect.jvm.internal.impl.builtins;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
public final class StandardNames {
    @JvmField
    @NotNull
    public static final FqName ANNOTATION_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES;
    @JvmField
    @NotNull
    public static final Name BUILT_INS_PACKAGE_NAME;
    @JvmField
    @NotNull
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final FqName CONTINUATION_INTERFACE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL;
    @JvmField
    @NotNull
    public static final FqName COROUTINES_PACKAGE_FQ_NAME_RELEASE;
    @JvmField
    @NotNull
    public static final Name ENUM_VALUES;
    @JvmField
    @NotNull
    public static final Name ENUM_VALUE_OF;
    @NotNull
    public static final StandardNames INSTANCE = new StandardNames();
    @JvmField
    @NotNull
    public static final FqName KOTLIN_REFLECT_FQ_NAME;
    @JvmField
    @NotNull
    public static final List<String> PREFIXES = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"KProperty", "KMutableProperty", "KFunction", "KSuspendFunction"});
    @JvmField
    @NotNull
    public static final FqName RANGES_PACKAGE_FQ_NAME;
    @JvmField
    @NotNull
    public static final FqName RESULT_FQ_NAME = new FqName("kotlin.Result");
    @JvmField
    @NotNull
    public static final FqName TEXT_PACKAGE_FQ_NAME;

    public static final class FqNames {
        @NotNull
        public static final FqNames INSTANCE;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _boolean;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _byte;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _char;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _double;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _enum;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _float;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _int;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _long;
        @JvmField
        @NotNull
        public static final FqNameUnsafe _short;
        @JvmField
        @NotNull
        public static final FqName annotation;
        @JvmField
        @NotNull
        public static final FqName annotationRetention;
        @JvmField
        @NotNull
        public static final FqName annotationTarget;
        @JvmField
        @NotNull
        public static final FqNameUnsafe any;
        @JvmField
        @NotNull
        public static final FqNameUnsafe array;
        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final FqNameUnsafe charSequence;
        @JvmField
        @NotNull
        public static final FqNameUnsafe cloneable;
        @JvmField
        @NotNull
        public static final FqName collection;
        @JvmField
        @NotNull
        public static final FqName comparable;
        @JvmField
        @NotNull
        public static final FqName deprecated;
        @JvmField
        @NotNull
        public static final FqName deprecatedSinceKotlin;
        @JvmField
        @NotNull
        public static final FqName deprecationLevel;
        @JvmField
        @NotNull
        public static final FqName extensionFunctionType;
        @JvmField
        @NotNull
        public static final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType;
        @JvmField
        @NotNull
        public static final FqNameUnsafe functionSupertype;
        @JvmField
        @NotNull
        public static final FqNameUnsafe intRange;
        @JvmField
        @NotNull
        public static final FqName iterable;
        @JvmField
        @NotNull
        public static final FqName iterator;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kCallable = reflect("KCallable");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kClass = reflect("KClass");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kDeclarationContainer = reflect("KDeclarationContainer");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty0 = reflect("KMutableProperty0");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty1 = reflect("KMutableProperty1");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutableProperty2 = reflect("KMutableProperty2");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kMutablePropertyFqName = reflect("KMutableProperty");
        @JvmField
        @NotNull
        public static final ClassId kProperty;
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty0 = reflect("KProperty0");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty1 = reflect("KProperty1");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kProperty2 = reflect("KProperty2");
        @JvmField
        @NotNull
        public static final FqNameUnsafe kPropertyFqName;
        @JvmField
        @NotNull
        public static final FqName list;
        @JvmField
        @NotNull
        public static final FqName listIterator;
        @JvmField
        @NotNull
        public static final FqNameUnsafe longRange;
        @JvmField
        @NotNull
        public static final FqName map;
        @JvmField
        @NotNull
        public static final FqName mapEntry;
        @JvmField
        @NotNull
        public static final FqName mustBeDocumented;
        @JvmField
        @NotNull
        public static final FqName mutableCollection;
        @JvmField
        @NotNull
        public static final FqName mutableIterable;
        @JvmField
        @NotNull
        public static final FqName mutableIterator;
        @JvmField
        @NotNull
        public static final FqName mutableList;
        @JvmField
        @NotNull
        public static final FqName mutableListIterator;
        @JvmField
        @NotNull
        public static final FqName mutableMap;
        @JvmField
        @NotNull
        public static final FqName mutableMapEntry;
        @JvmField
        @NotNull
        public static final FqName mutableSet;
        @JvmField
        @NotNull
        public static final FqNameUnsafe nothing;
        @JvmField
        @NotNull
        public static final FqNameUnsafe number;
        @JvmField
        @NotNull
        public static final FqName parameterName;
        @JvmField
        @NotNull
        public static final Set<Name> primitiveArrayTypeShortNames;
        @JvmField
        @NotNull
        public static final Set<Name> primitiveTypeShortNames;
        @JvmField
        @NotNull
        public static final FqName publishedApi;
        @JvmField
        @NotNull
        public static final FqName repeatable;
        @JvmField
        @NotNull
        public static final FqName replaceWith;
        @JvmField
        @NotNull
        public static final FqName retention;
        @JvmField
        @NotNull
        public static final FqName set;
        @JvmField
        @NotNull
        public static final FqNameUnsafe string;
        @JvmField
        @NotNull
        public static final FqName suppress;
        @JvmField
        @NotNull
        public static final FqName target;
        @JvmField
        @NotNull
        public static final FqName throwable;
        @JvmField
        @NotNull
        public static final ClassId uByte;
        @JvmField
        @NotNull
        public static final FqName uByteArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uByteFqName;
        @JvmField
        @NotNull
        public static final ClassId uInt;
        @JvmField
        @NotNull
        public static final FqName uIntArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uIntFqName;
        @JvmField
        @NotNull
        public static final ClassId uLong;
        @JvmField
        @NotNull
        public static final FqName uLongArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uLongFqName;
        @JvmField
        @NotNull
        public static final ClassId uShort;
        @JvmField
        @NotNull
        public static final FqName uShortArrayFqName;
        @JvmField
        @NotNull
        public static final FqName uShortFqName;
        @JvmField
        @NotNull
        public static final FqNameUnsafe unit;
        @JvmField
        @NotNull
        public static final FqName unsafeVariance;

        static {
            FqNames fqNames = new FqNames();
            INSTANCE = fqNames;
            FqNameUnsafe unsafe = fqNames.c("Any").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            any = unsafe;
            FqNameUnsafe unsafe2 = fqNames.c("Nothing").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe2, "fqName(simpleName).toUnsafe()");
            nothing = unsafe2;
            FqNameUnsafe unsafe3 = fqNames.c("Cloneable").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe3, "fqName(simpleName).toUnsafe()");
            cloneable = unsafe3;
            suppress = fqNames.c("Suppress");
            FqNameUnsafe unsafe4 = fqNames.c("Unit").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe4, "fqName(simpleName).toUnsafe()");
            unit = unsafe4;
            FqNameUnsafe unsafe5 = fqNames.c("CharSequence").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe5, "fqName(simpleName).toUnsafe()");
            charSequence = unsafe5;
            FqNameUnsafe unsafe6 = fqNames.c("String").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe6, "fqName(simpleName).toUnsafe()");
            string = unsafe6;
            FqNameUnsafe unsafe7 = fqNames.c("Array").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe7, "fqName(simpleName).toUnsafe()");
            array = unsafe7;
            FqNameUnsafe unsafe8 = fqNames.c("Boolean").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe8, "fqName(simpleName).toUnsafe()");
            _boolean = unsafe8;
            FqNameUnsafe unsafe9 = fqNames.c("Char").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe9, "fqName(simpleName).toUnsafe()");
            _char = unsafe9;
            FqNameUnsafe unsafe10 = fqNames.c("Byte").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe10, "fqName(simpleName).toUnsafe()");
            _byte = unsafe10;
            FqNameUnsafe unsafe11 = fqNames.c("Short").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe11, "fqName(simpleName).toUnsafe()");
            _short = unsafe11;
            FqNameUnsafe unsafe12 = fqNames.c("Int").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe12, "fqName(simpleName).toUnsafe()");
            _int = unsafe12;
            FqNameUnsafe unsafe13 = fqNames.c("Long").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe13, "fqName(simpleName).toUnsafe()");
            _long = unsafe13;
            FqNameUnsafe unsafe14 = fqNames.c("Float").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe14, "fqName(simpleName).toUnsafe()");
            _float = unsafe14;
            FqNameUnsafe unsafe15 = fqNames.c("Double").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe15, "fqName(simpleName).toUnsafe()");
            _double = unsafe15;
            FqNameUnsafe unsafe16 = fqNames.c("Number").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe16, "fqName(simpleName).toUnsafe()");
            number = unsafe16;
            FqNameUnsafe unsafe17 = fqNames.c("Enum").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe17, "fqName(simpleName).toUnsafe()");
            _enum = unsafe17;
            FqNameUnsafe unsafe18 = fqNames.c("Function").toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe18, "fqName(simpleName).toUnsafe()");
            functionSupertype = unsafe18;
            throwable = fqNames.c("Throwable");
            comparable = fqNames.c("Comparable");
            FqName fqName = StandardNames.RANGES_PACKAGE_FQ_NAME;
            FqNameUnsafe unsafe19 = fqName.child(Name.identifier("IntRange")).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe19, "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            intRange = unsafe19;
            FqNameUnsafe unsafe20 = fqName.child(Name.identifier("LongRange")).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe20, "RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            longRange = unsafe20;
            deprecated = fqNames.c("Deprecated");
            deprecatedSinceKotlin = fqNames.c("DeprecatedSinceKotlin");
            deprecationLevel = fqNames.c("DeprecationLevel");
            replaceWith = fqNames.c("ReplaceWith");
            extensionFunctionType = fqNames.c("ExtensionFunctionType");
            parameterName = fqNames.c("ParameterName");
            annotation = fqNames.c("Annotation");
            target = fqNames.a("Target");
            annotationTarget = fqNames.a("AnnotationTarget");
            annotationRetention = fqNames.a("AnnotationRetention");
            retention = fqNames.a("Retention");
            repeatable = fqNames.a("Repeatable");
            mustBeDocumented = fqNames.a("MustBeDocumented");
            unsafeVariance = fqNames.c("UnsafeVariance");
            publishedApi = fqNames.c("PublishedApi");
            iterator = fqNames.b("Iterator");
            iterable = fqNames.b("Iterable");
            collection = fqNames.b("Collection");
            list = fqNames.b("List");
            listIterator = fqNames.b("ListIterator");
            set = fqNames.b("Set");
            FqName b = fqNames.b("Map");
            map = b;
            FqName child = b.child(Name.identifier("Entry"));
            Intrinsics.checkNotNullExpressionValue(child, "map.child(Name.identifier(\"Entry\"))");
            mapEntry = child;
            mutableIterator = fqNames.b("MutableIterator");
            mutableIterable = fqNames.b("MutableIterable");
            mutableCollection = fqNames.b("MutableCollection");
            FqNames fqNames2 = INSTANCE;
            mutableList = fqNames2.b("MutableList");
            mutableListIterator = fqNames2.b("MutableListIterator");
            mutableSet = fqNames2.b("MutableSet");
            FqName b2 = fqNames2.b("MutableMap");
            mutableMap = b2;
            FqName child2 = b2.child(Name.identifier("MutableEntry"));
            Intrinsics.checkNotNullExpressionValue(child2, "mutableMap.child(Name.identifier(\"MutableEntry\"))");
            mutableMapEntry = child2;
            FqNameUnsafe reflect = reflect("KProperty");
            kPropertyFqName = reflect;
            ClassId classId = ClassId.topLevel(reflect.toSafe());
            Intrinsics.checkNotNullExpressionValue(classId, "topLevel(kPropertyFqName.toSafe())");
            kProperty = classId;
            FqName c = fqNames2.c("UByte");
            uByteFqName = c;
            FqName c2 = fqNames2.c("UShort");
            uShortFqName = c2;
            FqName c3 = fqNames2.c("UInt");
            uIntFqName = c3;
            FqName c4 = fqNames2.c("ULong");
            uLongFqName = c4;
            ClassId classId2 = ClassId.topLevel(c);
            Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(uByteFqName)");
            uByte = classId2;
            ClassId classId3 = ClassId.topLevel(c2);
            Intrinsics.checkNotNullExpressionValue(classId3, "topLevel(uShortFqName)");
            uShort = classId3;
            ClassId classId4 = ClassId.topLevel(c3);
            Intrinsics.checkNotNullExpressionValue(classId4, "topLevel(uIntFqName)");
            uInt = classId4;
            ClassId classId5 = ClassId.topLevel(c4);
            Intrinsics.checkNotNullExpressionValue(classId5, "topLevel(uLongFqName)");
            uLong = classId5;
            uByteArrayFqName = fqNames2.c("UByteArray");
            uShortArrayFqName = fqNames2.c("UShortArray");
            uIntArrayFqName = fqNames2.c("UIntArray");
            uLongArrayFqName = fqNames2.c("ULongArray");
            PrimitiveType.values();
            HashSet newHashSetWithExpectedSize = CollectionsKt.newHashSetWithExpectedSize(8);
            PrimitiveType[] values = PrimitiveType.values();
            int i = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                newHashSetWithExpectedSize.add(values[i2].getTypeName());
            }
            primitiveTypeShortNames = newHashSetWithExpectedSize;
            PrimitiveType.values();
            HashSet newHashSetWithExpectedSize2 = CollectionsKt.newHashSetWithExpectedSize(8);
            PrimitiveType[] values2 = PrimitiveType.values();
            for (int i3 = 0; i3 < 8; i3++) {
                newHashSetWithExpectedSize2.add(values2[i3].getArrayTypeName());
            }
            primitiveArrayTypeShortNames = newHashSetWithExpectedSize2;
            PrimitiveType.values();
            HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(8);
            PrimitiveType[] values3 = PrimitiveType.values();
            int i4 = 0;
            while (i4 < 8) {
                PrimitiveType primitiveType = values3[i4];
                i4++;
                FqNames fqNames3 = INSTANCE;
                String asString = primitiveType.getTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "primitiveType.typeName.asString()");
                newHashMapWithExpectedSize.put(fqNames3.d(asString), primitiveType);
            }
            fqNameToPrimitiveType = newHashMapWithExpectedSize;
            PrimitiveType.values();
            HashMap newHashMapWithExpectedSize2 = CollectionsKt.newHashMapWithExpectedSize(8);
            PrimitiveType[] values4 = PrimitiveType.values();
            while (i < 8) {
                PrimitiveType primitiveType2 = values4[i];
                i++;
                FqNames fqNames4 = INSTANCE;
                String asString2 = primitiveType2.getArrayTypeName().asString();
                Intrinsics.checkNotNullExpressionValue(asString2, "primitiveType.arrayTypeName.asString()");
                newHashMapWithExpectedSize2.put(fqNames4.d(asString2), primitiveType2);
            }
            arrayClassFqNameToPrimitiveType = newHashMapWithExpectedSize2;
        }

        @JvmStatic
        @NotNull
        public static final FqNameUnsafe reflect(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "simpleName");
            FqNameUnsafe unsafe = StandardNames.KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(str)).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "KOTLIN_REFLECT_FQ_NAME.child(Name.identifier(simpleName)).toUnsafe()");
            return unsafe;
        }

        public final FqName a(String str) {
            FqName child = StandardNames.ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        public final FqName b(String str) {
            FqName child = StandardNames.COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        public final FqName c(String str) {
            FqName child = StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(str));
            Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName))");
            return child;
        }

        public final FqNameUnsafe d(String str) {
            FqNameUnsafe unsafe = c(str).toUnsafe();
            Intrinsics.checkNotNullExpressionValue(unsafe, "fqName(simpleName).toUnsafe()");
            return unsafe;
        }
    }

    static {
        Name identifier = Name.identifier(ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"values\")");
        ENUM_VALUES = identifier;
        Name identifier2 = Name.identifier("valueOf");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"valueOf\")");
        ENUM_VALUE_OF = identifier2;
        FqName fqName = new FqName("kotlin.coroutines");
        COROUTINES_PACKAGE_FQ_NAME_RELEASE = fqName;
        FqName child = fqName.child(Name.identifier(BitmapPoolType.EXPERIMENTAL));
        Intrinsics.checkNotNullExpressionValue(child, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"experimental\"))");
        COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL = child;
        FqName child2 = child.child(Name.identifier("intrinsics"));
        Intrinsics.checkNotNullExpressionValue(child2, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"intrinsics\"))");
        COROUTINES_INTRINSICS_PACKAGE_FQ_NAME_EXPERIMENTAL = child2;
        FqName child3 = child.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child3, "COROUTINES_PACKAGE_FQ_NAME_EXPERIMENTAL.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_EXPERIMENTAL = child3;
        FqName child4 = fqName.child(Name.identifier("Continuation"));
        Intrinsics.checkNotNullExpressionValue(child4, "COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(\"Continuation\"))");
        CONTINUATION_INTERFACE_FQ_NAME_RELEASE = child4;
        FqName fqName2 = new FqName("kotlin.reflect");
        KOTLIN_REFLECT_FQ_NAME = fqName2;
        Name identifier3 = Name.identifier("kotlin");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"kotlin\")");
        BUILT_INS_PACKAGE_NAME = identifier3;
        FqName fqName3 = FqName.topLevel(identifier3);
        Intrinsics.checkNotNullExpressionValue(fqName3, "topLevel(BUILT_INS_PACKAGE_NAME)");
        BUILT_INS_PACKAGE_FQ_NAME = fqName3;
        FqName child5 = fqName3.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child5, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"annotation\"))");
        ANNOTATION_PACKAGE_FQ_NAME = child5;
        FqName child6 = fqName3.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child6, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"collections\"))");
        COLLECTIONS_PACKAGE_FQ_NAME = child6;
        FqName child7 = fqName3.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child7, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"ranges\"))");
        RANGES_PACKAGE_FQ_NAME = child7;
        FqName child8 = fqName3.child(Name.identifier("text"));
        Intrinsics.checkNotNullExpressionValue(child8, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"text\"))");
        TEXT_PACKAGE_FQ_NAME = child8;
        FqName child9 = fqName3.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child9, "BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(\"internal\"))");
        BUILT_INS_PACKAGE_FQ_NAMES = y.setOf((Object[]) new FqName[]{fqName3, child6, child7, child5, fqName2, child9, fqName});
    }

    @JvmStatic
    @NotNull
    public static final ClassId getFunctionClassId(int i) {
        return new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(getFunctionName(i)));
    }

    @JvmStatic
    @NotNull
    public static final String getFunctionName(int i) {
        return Intrinsics.stringPlus("Function", Integer.valueOf(i));
    }

    @JvmStatic
    @NotNull
    public static final FqName getPrimitiveFqName(@NotNull PrimitiveType primitiveType) {
        Intrinsics.checkNotNullParameter(primitiveType, "primitiveType");
        FqName child = BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
        Intrinsics.checkNotNullExpressionValue(child, "BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.typeName)");
        return child;
    }

    @JvmStatic
    @NotNull
    public static final String getSuspendFunctionName(int i) {
        return Intrinsics.stringPlus(FunctionClassKind.SuspendFunction.getClassNamePrefix(), Integer.valueOf(i));
    }

    @JvmStatic
    public static final boolean isPrimitiveArray(@NotNull FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "arrayFqName");
        return FqNames.arrayClassFqNameToPrimitiveType.get(fqNameUnsafe) != null;
    }
}
