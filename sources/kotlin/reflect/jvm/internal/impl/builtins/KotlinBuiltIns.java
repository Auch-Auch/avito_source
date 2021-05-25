package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public abstract class KotlinBuiltIns {
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");
    public ModuleDescriptorImpl a;
    public final NotNullLazyValue<e> b;
    public final NotNullLazyValue<Collection<PackageViewDescriptor>> c;
    public final MemoizedFunctionToNotNull<Name, ClassDescriptor> d;
    public final StorageManager e;

    public class a implements Function0<Collection<PackageViewDescriptor>> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<PackageViewDescriptor> invoke() {
            return Arrays.asList(KotlinBuiltIns.this.a.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.a.getPackage(StandardNames.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.this.a.getPackage(StandardNames.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.this.a.getPackage(StandardNames.ANNOTATION_PACKAGE_FQ_NAME));
        }
    }

    public class b implements Function0<e> {
        public b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public e invoke() {
            EnumMap enumMap = new EnumMap(PrimitiveType.class);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            PrimitiveType[] values = PrimitiveType.values();
            for (int i = 0; i < 8; i++) {
                PrimitiveType primitiveType = values[i];
                SimpleType b = KotlinBuiltIns.b(KotlinBuiltIns.this, primitiveType.getTypeName().asString());
                SimpleType b2 = KotlinBuiltIns.b(KotlinBuiltIns.this, primitiveType.getArrayTypeName().asString());
                enumMap.put((EnumMap) primitiveType, (PrimitiveType) b2);
                hashMap.put(b, b2);
                hashMap2.put(b2, b);
            }
            return new e(enumMap, hashMap, hashMap2, null);
        }
    }

    public class c implements Function1<Name, ClassDescriptor> {
        public c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ClassDescriptor invoke(Name name) {
            Name name2 = name;
            ClassifierDescriptor contributedClassifier = KotlinBuiltIns.this.getBuiltInsPackageScope().getContributedClassifier(name2, NoLookupLocation.FROM_BUILTINS);
            if (contributedClassifier == null) {
                StringBuilder L = a2.b.a.a.a.L("Built-in class ");
                L.append(StandardNames.BUILT_INS_PACKAGE_FQ_NAME.child(name2));
                L.append(" is not found");
                throw new AssertionError(L.toString());
            } else if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            } else {
                throw new AssertionError("Must be a class descriptor " + name2 + ", but was " + contributedClassifier);
            }
        }
    }

    public class d implements Function0<Void> {
        public final /* synthetic */ ModuleDescriptorImpl a;

        public d(ModuleDescriptorImpl moduleDescriptorImpl) {
            this.a = moduleDescriptorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Void invoke() {
            KotlinBuiltIns kotlinBuiltIns = KotlinBuiltIns.this;
            if (kotlinBuiltIns.a == null) {
                kotlinBuiltIns.a = this.a;
                return null;
            }
            StringBuilder L = a2.b.a.a.a.L("Built-ins module is already set: ");
            L.append(KotlinBuiltIns.this.a);
            L.append(" (attempting to reset to ");
            L.append(this.a);
            L.append(")");
            throw new AssertionError(L.toString());
        }
    }

    public static class e {
        public final Map<PrimitiveType, SimpleType> a;
        public final Map<KotlinType, SimpleType> b;
        public final Map<SimpleType, SimpleType> c;

        public e(Map map, Map map2, Map map3, a aVar) {
            this.a = map;
            this.b = map2;
            this.c = map3;
        }
    }

    public KotlinBuiltIns(@NotNull StorageManager storageManager) {
        if (storageManager != null) {
            this.e = storageManager;
            this.c = storageManager.createLazyValue(new a());
            this.b = storageManager.createLazyValue(new b());
            this.d = storageManager.createMemoizedFunction(new c());
            return;
        }
        a(0);
        throw null;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                i2 = 2;
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 71:
                objArr[0] = BaseAnalyticKt.ANALYTIC_FAIL_MODULE;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 8:
            case 9:
            case 75:
            case 76:
            case 88:
            case 95:
            case 102:
            case 106:
            case 107:
            case 144:
            case 145:
            case 147:
            case 155:
            case 156:
            case 157:
                objArr[0] = "descriptor";
                break;
            case 11:
            case 97:
            case 99:
            case 101:
            case 103:
            case 105:
            case 134:
                objArr[0] = "fqName";
                break;
            case 13:
                objArr[0] = "simpleName";
                break;
            case 15:
            case 16:
            case 52:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 96:
            case 98:
            case 104:
            case 108:
            case 109:
            case 110:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 146:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 159:
                objArr[0] = "type";
                break;
            case 45:
                objArr[0] = "classSimpleName";
                break;
            case 66:
                objArr[0] = "arrayType";
                break;
            case 70:
                objArr[0] = "notNullArrayType";
                break;
            case 72:
                objArr[0] = "primitiveType";
                break;
            case 74:
                objArr[0] = "kotlinType";
                break;
            case 77:
            case 81:
                objArr[0] = "projectionType";
                break;
            case 78:
            case 82:
            case 84:
                objArr[0] = "argument";
                break;
            case 79:
                objArr[0] = "annotations";
                break;
            case 100:
                objArr[0] = "typeConstructor";
                break;
            case 111:
                objArr[0] = "classDescriptor";
                break;
            case 158:
                objArr[0] = "declarationDescriptor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 2:
                objArr[1] = "getAdditionalClassPartsProvider";
                break;
            case 3:
                objArr[1] = "getPlatformDependentDeclarationFilter";
                break;
            case 4:
                objArr[1] = "getClassDescriptorFactories";
                break;
            case 5:
                objArr[1] = "getStorageManager";
                break;
            case 6:
                objArr[1] = "getBuiltInsModule";
                break;
            case 7:
                objArr[1] = "getBuiltInPackagesImportedByDefault";
                break;
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
                break;
            case 10:
                objArr[1] = "getBuiltInsPackageScope";
                break;
            case 12:
                objArr[1] = "getBuiltInClassByFqName";
                break;
            case 14:
                objArr[1] = "getBuiltInClassByName";
                break;
            case 17:
                objArr[1] = "getSuspendFunction";
                break;
            case 18:
                objArr[1] = "getKFunction";
                break;
            case 19:
                objArr[1] = "getKSuspendFunction";
                break;
            case 20:
                objArr[1] = "getKClass";
                break;
            case 21:
                objArr[1] = "getKCallable";
                break;
            case 22:
                objArr[1] = "getKProperty";
                break;
            case 23:
                objArr[1] = "getKProperty0";
                break;
            case 24:
                objArr[1] = "getKProperty1";
                break;
            case 25:
                objArr[1] = "getKProperty2";
                break;
            case 26:
                objArr[1] = "getKMutableProperty0";
                break;
            case 27:
                objArr[1] = "getKMutableProperty1";
                break;
            case 28:
                objArr[1] = "getKMutableProperty2";
                break;
            case 29:
                objArr[1] = "getIterator";
                break;
            case 30:
                objArr[1] = "getIterable";
                break;
            case 31:
                objArr[1] = "getMutableIterable";
                break;
            case 32:
                objArr[1] = "getMutableIterator";
                break;
            case 33:
                objArr[1] = "getCollection";
                break;
            case 34:
                objArr[1] = "getMutableCollection";
                break;
            case 35:
                objArr[1] = "getList";
                break;
            case 36:
                objArr[1] = "getMutableList";
                break;
            case 37:
                objArr[1] = "getSet";
                break;
            case 38:
                objArr[1] = "getMutableSet";
                break;
            case 39:
                objArr[1] = "getMap";
                break;
            case 40:
                objArr[1] = "getMutableMap";
                break;
            case 41:
                objArr[1] = "getMapEntry";
                break;
            case 42:
                objArr[1] = "getMutableMapEntry";
                break;
            case 43:
                objArr[1] = "getListIterator";
                break;
            case 44:
                objArr[1] = "getMutableListIterator";
                break;
            case 46:
                objArr[1] = "getBuiltInTypeByClassName";
                break;
            case 47:
                objArr[1] = "getNothingType";
                break;
            case 48:
                objArr[1] = "getNullableNothingType";
                break;
            case 49:
                objArr[1] = "getAnyType";
                break;
            case 50:
                objArr[1] = "getNullableAnyType";
                break;
            case 51:
                objArr[1] = "getDefaultBound";
                break;
            case 53:
                objArr[1] = "getPrimitiveKotlinType";
                break;
            case 54:
                objArr[1] = "getNumberType";
                break;
            case 55:
                objArr[1] = "getByteType";
                break;
            case 56:
                objArr[1] = "getShortType";
                break;
            case 57:
                objArr[1] = "getIntType";
                break;
            case 58:
                objArr[1] = "getLongType";
                break;
            case 59:
                objArr[1] = "getFloatType";
                break;
            case 60:
                objArr[1] = "getDoubleType";
                break;
            case 61:
                objArr[1] = "getCharType";
                break;
            case 62:
                objArr[1] = "getBooleanType";
                break;
            case 63:
                objArr[1] = "getUnitType";
                break;
            case 64:
                objArr[1] = "getStringType";
                break;
            case 65:
                objArr[1] = "getIterableType";
                break;
            case 67:
            case 68:
            case 69:
                objArr[1] = "getArrayElementType";
                break;
            case 73:
                objArr[1] = "getPrimitiveArrayKotlinType";
                break;
            case 80:
            case 83:
                objArr[1] = "getArrayType";
                break;
            case 85:
                objArr[1] = "getEnumType";
                break;
            case 86:
                objArr[1] = "getAnnotationType";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "setBuiltInsModule";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                break;
            case 8:
                objArr[2] = "isBuiltIn";
                break;
            case 9:
                objArr[2] = "isUnderKotlinPackage";
                break;
            case 11:
                objArr[2] = "getBuiltInClassByFqName";
                break;
            case 13:
                objArr[2] = "getBuiltInClassByName";
                break;
            case 15:
                objArr[2] = "getPrimitiveClassDescriptor";
                break;
            case 16:
                objArr[2] = "getPrimitiveArrayClassDescriptor";
                break;
            case 45:
                objArr[2] = "getBuiltInTypeByClassName";
                break;
            case 52:
                objArr[2] = "getPrimitiveKotlinType";
                break;
            case 66:
                objArr[2] = "getArrayElementType";
                break;
            case 70:
            case 71:
                objArr[2] = "getElementTypeForUnsignedArray";
                break;
            case 72:
                objArr[2] = "getPrimitiveArrayKotlinType";
                break;
            case 74:
                objArr[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
                break;
            case 75:
            case 92:
                objArr[2] = "getPrimitiveType";
                break;
            case 76:
                objArr[2] = "getPrimitiveArrayType";
                break;
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
                objArr[2] = "getArrayType";
                break;
            case 84:
                objArr[2] = "getEnumType";
                break;
            case 87:
                objArr[2] = "isArray";
                break;
            case 88:
            case 89:
                objArr[2] = "isArrayOrPrimitiveArray";
                break;
            case 90:
                objArr[2] = "isPrimitiveArray";
                break;
            case 91:
                objArr[2] = "getPrimitiveArrayElementType";
                break;
            case 93:
                objArr[2] = "isPrimitiveType";
                break;
            case 94:
                objArr[2] = "isPrimitiveTypeOrNullablePrimitiveType";
                break;
            case 95:
                objArr[2] = "isPrimitiveClass";
                break;
            case 96:
            case 97:
            case 98:
            case 99:
                objArr[2] = "isConstructedFromGivenClass";
                break;
            case 100:
            case 101:
                objArr[2] = "isTypeConstructorForGivenClass";
                break;
            case 102:
            case 103:
                objArr[2] = "classFqNameEquals";
                break;
            case 104:
            case 105:
                objArr[2] = "isNotNullConstructedFromGivenClass";
                break;
            case 106:
                objArr[2] = "isSpecialClassWithNoSupertypes";
                break;
            case 107:
            case 108:
                objArr[2] = "isAny";
                break;
            case 109:
            case 111:
                objArr[2] = "isBoolean";
                break;
            case 110:
                objArr[2] = "isBooleanOrNullableBoolean";
                break;
            case 112:
                objArr[2] = "isNumber";
                break;
            case 113:
                objArr[2] = "isChar";
                break;
            case 114:
                objArr[2] = "isCharOrNullableChar";
                break;
            case 115:
                objArr[2] = "isInt";
                break;
            case 116:
                objArr[2] = "isByte";
                break;
            case 117:
                objArr[2] = "isLong";
                break;
            case 118:
                objArr[2] = "isLongOrNullableLong";
                break;
            case 119:
                objArr[2] = "isShort";
                break;
            case 120:
                objArr[2] = "isFloat";
                break;
            case 121:
                objArr[2] = "isFloatOrNullableFloat";
                break;
            case 122:
                objArr[2] = "isDouble";
                break;
            case 123:
                objArr[2] = "isUByte";
                break;
            case 124:
                objArr[2] = "isUShort";
                break;
            case 125:
                objArr[2] = "isUInt";
                break;
            case 126:
                objArr[2] = "isULong";
                break;
            case 127:
                objArr[2] = "isUByteArray";
                break;
            case 128:
                objArr[2] = "isUShortArray";
                break;
            case 129:
                objArr[2] = "isUIntArray";
                break;
            case 130:
                objArr[2] = "isULongArray";
                break;
            case 131:
                objArr[2] = "isUnsignedArrayType";
                break;
            case 132:
                objArr[2] = "isDoubleOrNullableDouble";
                break;
            case 133:
            case 134:
                objArr[2] = "isConstructedFromGivenClassAndNotNullable";
                break;
            case 135:
                objArr[2] = "isNothing";
                break;
            case 136:
                objArr[2] = "isNullableNothing";
                break;
            case 137:
                objArr[2] = "isNothingOrNullableNothing";
                break;
            case 138:
                objArr[2] = "isAnyOrNullableAny";
                break;
            case 139:
                objArr[2] = "isNullableAny";
                break;
            case 140:
                objArr[2] = "isDefaultBound";
                break;
            case 141:
                objArr[2] = "isUnit";
                break;
            case 142:
                objArr[2] = "isUnitOrNullableUnit";
                break;
            case 143:
                objArr[2] = "isBooleanOrSubtype";
                break;
            case 144:
                objArr[2] = "isMemberOfAny";
                break;
            case 145:
            case 146:
                objArr[2] = "isEnum";
                break;
            case 147:
            case 148:
                objArr[2] = "isComparable";
                break;
            case 149:
                objArr[2] = "isCollectionOrNullableCollection";
                break;
            case 150:
                objArr[2] = "isListOrNullableList";
                break;
            case 151:
                objArr[2] = "isSetOrNullableSet";
                break;
            case 152:
                objArr[2] = "isMapOrNullableMap";
                break;
            case 153:
                objArr[2] = "isIterableOrNullableIterable";
                break;
            case 154:
                objArr[2] = "isThrowableOrNullableThrowable";
                break;
            case 155:
                objArr[2] = "isKClass";
                break;
            case 156:
                objArr[2] = "isNonPrimitiveArray";
                break;
            case 157:
                objArr[2] = "isCloneable";
                break;
            case 158:
                objArr[2] = "isDeprecated";
                break;
            case 159:
                objArr[2] = "isNotNullOrNullableFunctionSupertype";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 10:
            case 12:
            case 14:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 73:
            case 80:
            case 83:
            case 85:
            case 86:
                throw new IllegalStateException(format);
            case 8:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            case 45:
            case 52:
            case 66:
            case 70:
            case 71:
            case 72:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 81:
            case 82:
            case 84:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static SimpleType b(KotlinBuiltIns kotlinBuiltIns, String str) {
        Objects.requireNonNull(kotlinBuiltIns);
        if (str != null) {
            SimpleType defaultType = kotlinBuiltIns.d(str).getDefaultType();
            if (defaultType != null) {
                return defaultType;
            }
            a(46);
            throw null;
        }
        a(45);
        throw null;
    }

    public static boolean c(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull FqNameUnsafe fqNameUnsafe) {
        if (classifierDescriptor == null) {
            a(102);
            throw null;
        } else if (fqNameUnsafe != null) {
            return classifierDescriptor.getName().equals(fqNameUnsafe.shortName()) && fqNameUnsafe.equals(DescriptorUtils.getFqName(classifierDescriptor));
        } else {
            a(103);
            throw null;
        }
    }

    public static boolean e(@NotNull KotlinType kotlinType, @NotNull FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(96);
            throw null;
        } else if (fqNameUnsafe != null) {
            return isTypeConstructorForGivenClass(kotlinType.getConstructor(), fqNameUnsafe);
        } else {
            a(97);
            throw null;
        }
    }

    public static boolean f(@NotNull KotlinType kotlinType, @NotNull FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(133);
            throw null;
        } else if (fqNameUnsafe != null) {
            return e(kotlinType, fqNameUnsafe) && !kotlinType.isMarkedNullable();
        } else {
            a(134);
            throw null;
        }
    }

    public static boolean g(@NotNull KotlinType kotlinType, @NotNull FqNameUnsafe fqNameUnsafe) {
        if (kotlinType == null) {
            a(104);
            throw null;
        } else if (fqNameUnsafe != null) {
            return !kotlinType.isMarkedNullable() && e(kotlinType, fqNameUnsafe);
        } else {
            a(105);
            throw null;
        }
    }

    @Nullable
    public static PrimitiveType getPrimitiveArrayType(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(76);
            throw null;
        } else if (StandardNames.FqNames.primitiveArrayTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.arrayClassFqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        } else {
            return null;
        }
    }

    @Nullable
    public static PrimitiveType getPrimitiveType(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(75);
            throw null;
        } else if (StandardNames.FqNames.primitiveTypeShortNames.contains(declarationDescriptor.getName())) {
            return StandardNames.FqNames.fqNameToPrimitiveType.get(DescriptorUtils.getFqName(declarationDescriptor));
        } else {
            return null;
        }
    }

    public static boolean isAny(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.FqNames.any);
        }
        a(107);
        throw null;
    }

    public static boolean isAnyOrNullableAny(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return e(kotlinType, StandardNames.FqNames.any);
        }
        a(138);
        throw null;
    }

    public static boolean isArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return e(kotlinType, StandardNames.FqNames.array);
        }
        a(87);
        throw null;
    }

    public static boolean isArrayOrPrimitiveArray(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.FqNames.array) || getPrimitiveArrayType(classDescriptor) != null;
        }
        a(88);
        throw null;
    }

    public static boolean isBoolean(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._boolean);
        }
        a(109);
        throw null;
    }

    public static boolean isBuiltIn(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return DescriptorUtils.getParentOfType(declarationDescriptor, BuiltInsPackageFragment.class, false) != null;
        }
        a(8);
        throw null;
    }

    public static boolean isByte(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._byte);
        }
        a(116);
        throw null;
    }

    public static boolean isChar(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._char);
        }
        a(113);
        throw null;
    }

    public static boolean isDefaultBound(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isNullableAny(kotlinType);
        }
        a(140);
        throw null;
    }

    public static boolean isDeprecated(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(158);
            throw null;
        } else if (declarationDescriptor.getOriginal().getAnnotations().hasAnnotation(StandardNames.FqNames.deprecated)) {
            return true;
        } else {
            if (!(declarationDescriptor instanceof PropertyDescriptor)) {
                return false;
            }
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) declarationDescriptor;
            boolean isVar = propertyDescriptor.isVar();
            PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
            PropertySetterDescriptor setter = propertyDescriptor.getSetter();
            if (getter != null && isDeprecated(getter)) {
                if (!isVar) {
                    return true;
                }
                if (setter != null && isDeprecated(setter)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isDouble(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isDoubleOrNullableDouble(kotlinType) && !kotlinType.isMarkedNullable();
        }
        a(122);
        throw null;
    }

    public static boolean isDoubleOrNullableDouble(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return e(kotlinType, StandardNames.FqNames._double);
        }
        a(132);
        throw null;
    }

    public static boolean isFloat(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isFloatOrNullableFloat(kotlinType) && !kotlinType.isMarkedNullable();
        }
        a(120);
        throw null;
    }

    public static boolean isFloatOrNullableFloat(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return e(kotlinType, StandardNames.FqNames._float);
        }
        a(121);
        throw null;
    }

    public static boolean isInt(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._int);
        }
        a(115);
        throw null;
    }

    public static boolean isKClass(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.FqNames.kClass);
        }
        a(155);
        throw null;
    }

    public static boolean isLong(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._long);
        }
        a(117);
        throw null;
    }

    public static boolean isNothing(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isNothingOrNullableNothing(kotlinType) && !TypeUtils.isNullableType(kotlinType);
        }
        a(135);
        throw null;
    }

    public static boolean isNothingOrNullableNothing(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return e(kotlinType, StandardNames.FqNames.nothing);
        }
        a(137);
        throw null;
    }

    public static boolean isNullableAny(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isAnyOrNullableAny(kotlinType) && kotlinType.isMarkedNullable();
        }
        a(139);
        throw null;
    }

    public static boolean isPrimitiveArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            return (declarationDescriptor == null || getPrimitiveArrayType(declarationDescriptor) == null) ? false : true;
        }
        a(90);
        throw null;
    }

    public static boolean isPrimitiveClass(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return getPrimitiveType(classDescriptor) != null;
        }
        a(95);
        throw null;
    }

    public static boolean isPrimitiveType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return !kotlinType.isMarkedNullable() && isPrimitiveTypeOrNullablePrimitiveType(kotlinType);
        }
        a(93);
        throw null;
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && isPrimitiveClass((ClassDescriptor) declarationDescriptor);
        }
        a(94);
        throw null;
    }

    public static boolean isShort(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames._short);
        }
        a(119);
        throw null;
    }

    public static boolean isSpecialClassWithNoSupertypes(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            return c(classDescriptor, StandardNames.FqNames.any) || c(classDescriptor, StandardNames.FqNames.nothing);
        }
        a(106);
        throw null;
    }

    public static boolean isString(@Nullable KotlinType kotlinType) {
        return kotlinType != null && g(kotlinType, StandardNames.FqNames.string);
    }

    public static boolean isTypeConstructorForGivenClass(@NotNull TypeConstructor typeConstructor, @NotNull FqNameUnsafe fqNameUnsafe) {
        if (typeConstructor == null) {
            a(100);
            throw null;
        } else if (fqNameUnsafe != null) {
            ClassifierDescriptor declarationDescriptor = typeConstructor.mo425getDeclarationDescriptor();
            return (declarationDescriptor instanceof ClassDescriptor) && c(declarationDescriptor, fqNameUnsafe);
        } else {
            a(101);
            throw null;
        }
    }

    public static boolean isUByteArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames.uByteArrayFqName.toUnsafe());
        }
        a(127);
        throw null;
    }

    public static boolean isUIntArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames.uIntArrayFqName.toUnsafe());
        }
        a(129);
        throw null;
    }

    public static boolean isULongArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames.uLongArrayFqName.toUnsafe());
        }
        a(130);
        throw null;
    }

    public static boolean isUShortArray(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return f(kotlinType, StandardNames.FqNames.uShortArrayFqName.toUnsafe());
        }
        a(128);
        throw null;
    }

    public static boolean isUnderKotlinPackage(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            while (declarationDescriptor != null) {
                if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                    return ((PackageFragmentDescriptor) declarationDescriptor).getFqName().startsWith(StandardNames.BUILT_INS_PACKAGE_NAME);
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
        a(9);
        throw null;
    }

    public static boolean isUnit(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return g(kotlinType, StandardNames.FqNames.unit);
        }
        a(141);
        throw null;
    }

    public static boolean isUnsignedArrayType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return isUByteArray(kotlinType) || isUShortArray(kotlinType) || isUIntArray(kotlinType) || isULongArray(kotlinType);
        }
        a(131);
        throw null;
    }

    public void createBuiltInsModule(boolean z) {
        ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.e, this, null);
        this.a = moduleDescriptorImpl;
        moduleDescriptorImpl.initialize(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.e, this.a, getClassDescriptorFactories(), getPlatformDependentDeclarationFilter(), getAdditionalClassPartsProvider(), z));
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.a;
        moduleDescriptorImpl2.setDependencies(moduleDescriptorImpl2);
    }

    @NotNull
    public final ClassDescriptor d(@NotNull String str) {
        if (str != null) {
            ClassDescriptor invoke = this.d.invoke(Name.identifier(str));
            if (invoke != null) {
                return invoke;
            }
            a(14);
            throw null;
        }
        a(13);
        throw null;
    }

    @NotNull
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none != null) {
            return none;
        }
        a(2);
        throw null;
    }

    @NotNull
    public ClassDescriptor getAny() {
        return d("Any");
    }

    @NotNull
    public SimpleType getAnyType() {
        SimpleType defaultType = getAny().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(49);
        throw null;
    }

    @NotNull
    public ClassDescriptor getArray() {
        return d("Array");
    }

    @NotNull
    public KotlinType getArrayElementType(@NotNull KotlinType kotlinType) {
        ClassId classId;
        ClassId unsignedClassIdByArrayClassId;
        ClassDescriptor findClassAcrossModuleDependencies;
        SimpleType simpleType = null;
        if (kotlinType == null) {
            a(66);
            throw null;
        } else if (!isArray(kotlinType)) {
            KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
            SimpleType simpleType2 = ((e) this.b.invoke()).c.get(makeNotNullable);
            if (simpleType2 != null) {
                return simpleType2;
            }
            ModuleDescriptor containingModuleOrNull = DescriptorUtils.getContainingModuleOrNull(makeNotNullable);
            if (containingModuleOrNull != null) {
                if (makeNotNullable != null) {
                    ClassifierDescriptor declarationDescriptor = makeNotNullable.getConstructor().mo425getDeclarationDescriptor();
                    if (declarationDescriptor != null) {
                        UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
                        if (!(!unsignedTypes.isShortNameOfUnsignedArray(declarationDescriptor.getName()) || (classId = DescriptorUtilsKt.getClassId(declarationDescriptor)) == null || (unsignedClassIdByArrayClassId = unsignedTypes.getUnsignedClassIdByArrayClassId(classId)) == null || (findClassAcrossModuleDependencies = FindClassInModuleKt.findClassAcrossModuleDependencies(containingModuleOrNull, unsignedClassIdByArrayClassId)) == null)) {
                            simpleType = findClassAcrossModuleDependencies.getDefaultType();
                        }
                    }
                    if (simpleType != null) {
                        return simpleType;
                    }
                } else {
                    a(70);
                    throw null;
                }
            }
            throw new IllegalStateException("not array: " + kotlinType);
        } else if (kotlinType.getArguments().size() == 1) {
            KotlinType type = kotlinType.getArguments().get(0).getType();
            if (type != null) {
                return type;
            }
            a(67);
            throw null;
        } else {
            throw new IllegalStateException();
        }
    }

    @NotNull
    public SimpleType getArrayType(@NotNull Variance variance, @NotNull KotlinType kotlinType, @NotNull Annotations annotations) {
        if (variance == null) {
            a(77);
            throw null;
        } else if (kotlinType == null) {
            a(78);
            throw null;
        } else if (annotations != null) {
            SimpleType simpleNotNullType = KotlinTypeFactory.simpleNotNullType(annotations, getArray(), Collections.singletonList(new TypeProjectionImpl(variance, kotlinType)));
            if (simpleNotNullType != null) {
                return simpleNotNullType;
            }
            a(80);
            throw null;
        } else {
            a(79);
            throw null;
        }
    }

    @NotNull
    public SimpleType getBooleanType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(62);
        throw null;
    }

    @NotNull
    public ClassDescriptor getBuiltInClassByFqName(@NotNull FqName fqName) {
        if (fqName != null) {
            ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(this.a, fqName, NoLookupLocation.FROM_BUILTINS);
            if (resolveClassByFqName != null) {
                return resolveClassByFqName;
            }
            a(12);
            throw null;
        }
        a(11);
        throw null;
    }

    @NotNull
    public ModuleDescriptorImpl getBuiltInsModule() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.a;
        if (moduleDescriptorImpl != null) {
            return moduleDescriptorImpl;
        }
        a(6);
        throw null;
    }

    @NotNull
    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope = this.a.getPackage(StandardNames.BUILT_INS_PACKAGE_FQ_NAME).getMemberScope();
        if (memberScope != null) {
            return memberScope;
        }
        a(10);
        throw null;
    }

    @NotNull
    public SimpleType getByteType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(55);
        throw null;
    }

    @NotNull
    public SimpleType getCharType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(61);
        throw null;
    }

    @NotNull
    public Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List singletonList = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.e, this.a));
        if (singletonList != null) {
            return singletonList;
        }
        a(4);
        throw null;
    }

    @NotNull
    public ClassDescriptor getCollection() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.collection);
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(33);
        throw null;
    }

    @NotNull
    public ClassDescriptor getComparable() {
        return d("Comparable");
    }

    @NotNull
    public SimpleType getDefaultBound() {
        SimpleType nullableAnyType = getNullableAnyType();
        if (nullableAnyType != null) {
            return nullableAnyType;
        }
        a(51);
        throw null;
    }

    @NotNull
    public SimpleType getDoubleType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(60);
        throw null;
    }

    @NotNull
    public SimpleType getFloatType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(59);
        throw null;
    }

    @NotNull
    public ClassDescriptor getFunction(int i) {
        return d(StandardNames.getFunctionName(i));
    }

    @NotNull
    public SimpleType getIntType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.INT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(57);
        throw null;
    }

    @NotNull
    public ClassDescriptor getKClass() {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.FqNames.kClass.toSafe());
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(20);
        throw null;
    }

    @NotNull
    public SimpleType getLongType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.LONG);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(58);
        throw null;
    }

    @NotNull
    public ClassDescriptor getNothing() {
        return d("Nothing");
    }

    @NotNull
    public SimpleType getNothingType() {
        SimpleType defaultType = getNothing().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(47);
        throw null;
    }

    @NotNull
    public SimpleType getNullableAnyType() {
        SimpleType makeNullableAsSpecified = getAnyType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified != null) {
            return makeNullableAsSpecified;
        }
        a(50);
        throw null;
    }

    @NotNull
    public SimpleType getNullableNothingType() {
        SimpleType makeNullableAsSpecified = getNothingType().makeNullableAsSpecified(true);
        if (makeNullableAsSpecified != null) {
            return makeNullableAsSpecified;
        }
        a(48);
        throw null;
    }

    @NotNull
    public ClassDescriptor getNumber() {
        return d("Number");
    }

    @NotNull
    public SimpleType getNumberType() {
        SimpleType defaultType = getNumber().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(54);
        throw null;
    }

    @NotNull
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent != null) {
            return noPlatformDependent;
        }
        a(3);
        throw null;
    }

    @NotNull
    public SimpleType getPrimitiveArrayKotlinType(@NotNull PrimitiveType primitiveType) {
        if (primitiveType != null) {
            SimpleType simpleType = ((e) this.b.invoke()).a.get(primitiveType);
            if (simpleType != null) {
                return simpleType;
            }
            a(73);
            throw null;
        }
        a(72);
        throw null;
    }

    @NotNull
    public SimpleType getPrimitiveKotlinType(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            a(52);
            throw null;
        } else if (primitiveType != null) {
            SimpleType defaultType = d(primitiveType.getTypeName().asString()).getDefaultType();
            if (defaultType != null) {
                return defaultType;
            }
            a(53);
            throw null;
        } else {
            a(15);
            throw null;
        }
    }

    @NotNull
    public SimpleType getShortType() {
        SimpleType primitiveKotlinType = getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (primitiveKotlinType != null) {
            return primitiveKotlinType;
        }
        a(56);
        throw null;
    }

    @NotNull
    public StorageManager getStorageManager() {
        StorageManager storageManager = this.e;
        if (storageManager != null) {
            return storageManager;
        }
        a(5);
        throw null;
    }

    @NotNull
    public ClassDescriptor getString() {
        return d("String");
    }

    @NotNull
    public SimpleType getStringType() {
        SimpleType defaultType = getString().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(64);
        throw null;
    }

    @NotNull
    public ClassDescriptor getSuspendFunction(int i) {
        ClassDescriptor builtInClassByFqName = getBuiltInClassByFqName(StandardNames.COROUTINES_PACKAGE_FQ_NAME_RELEASE.child(Name.identifier(StandardNames.getSuspendFunctionName(i))));
        if (builtInClassByFqName != null) {
            return builtInClassByFqName;
        }
        a(17);
        throw null;
    }

    @NotNull
    public ClassDescriptor getUnit() {
        return d("Unit");
    }

    @NotNull
    public SimpleType getUnitType() {
        SimpleType defaultType = getUnit().getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        a(63);
        throw null;
    }

    public void setBuiltInsModule(@NotNull ModuleDescriptorImpl moduleDescriptorImpl) {
        if (moduleDescriptorImpl != null) {
            this.e.compute(new d(moduleDescriptorImpl));
        } else {
            a(1);
            throw null;
        }
    }

    @NotNull
    public SimpleType getArrayType(@NotNull Variance variance, @NotNull KotlinType kotlinType) {
        if (variance == null) {
            a(81);
            throw null;
        } else if (kotlinType != null) {
            SimpleType arrayType = getArrayType(variance, kotlinType, Annotations.Companion.getEMPTY());
            if (arrayType != null) {
                return arrayType;
            }
            a(83);
            throw null;
        } else {
            a(82);
            throw null;
        }
    }
}
