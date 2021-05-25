package kotlin.reflect.jvm.internal.impl.resolve;

import com.avito.android.analytics.screens.InternalConstsKt;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class DescriptorUtils {
    public static final FqName JVM_NAME = new FqName("kotlin.jvm.JvmName");

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 21:
            case 22:
            case 32:
            case 33:
            case 34:
            case 55:
            case 56:
            case 57:
            case 59:
            case 77:
            case 90:
            case 92:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 14:
                objArr[0] = InternalConstsKt.FIRST_IMAGE;
                break;
            case 15:
                objArr[0] = "second";
                break;
            case 16:
            case 17:
                objArr[0] = "aClass";
                break;
            case 18:
                objArr[0] = "kotlinType";
                break;
            case 23:
                objArr[0] = "declarationDescriptor";
                break;
            case 24:
            case 26:
                objArr[0] = "subClass";
                break;
            case 25:
            case 27:
            case 31:
                objArr[0] = "superClass";
                break;
            case 28:
            case 30:
            case 43:
            case 62:
                objArr[0] = "type";
                break;
            case 29:
                objArr[0] = "other";
                break;
            case 35:
                objArr[0] = "classKind";
                break;
            case 36:
            case 37:
            case 39:
            case 42:
            case 46:
            case 52:
            case 63:
            case 64:
            case 65:
            case 72:
            case 73:
                objArr[0] = "classDescriptor";
                break;
            case 44:
                objArr[0] = "typeConstructor";
                break;
            case 53:
                objArr[0] = "innerClassName";
                break;
            case 54:
                objArr[0] = "location";
                break;
            case 61:
                objArr[0] = "variable";
                break;
            case 66:
                objArr[0] = "f";
                break;
            case 68:
                objArr[0] = "current";
                break;
            case 69:
                objArr[0] = "result";
                break;
            case 70:
                objArr[0] = "memberDescriptor";
                break;
            case 74:
            case 75:
            case 76:
                objArr[0] = "annotated";
                break;
            case 80:
            case 82:
            case 85:
            case 87:
                objArr[0] = "scope";
                break;
            case 83:
            case 86:
            case 88:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 20:
                objArr[1] = "getContainingModule";
                break;
            case 38:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 40:
            case 41:
                objArr[1] = "getSuperClassType";
                break;
            case 45:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 58:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 67:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 71:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 78:
            case 79:
                objArr[1] = "getContainingSourceFile";
                break;
            case 81:
                objArr[1] = "getAllDescriptors";
                break;
            case 84:
                objArr[1] = "getFunctionByName";
                break;
            case 89:
                objArr[1] = "getPropertyByName";
                break;
            case 91:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "isExtension";
                break;
            case 12:
                objArr[2] = "isOverride";
                break;
            case 13:
                objArr[2] = "isStaticDeclaration";
                break;
            case 14:
            case 15:
                objArr[2] = "areInSameModule";
                break;
            case 16:
            case 17:
                objArr[2] = "getParentOfType";
                break;
            case 18:
            case 21:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 19:
                objArr[2] = "getContainingModule";
                break;
            case 22:
                objArr[2] = "getContainingClass";
                break;
            case 23:
                objArr[2] = "isAncestor";
                break;
            case 24:
            case 25:
                objArr[2] = "isDirectSubclass";
                break;
            case 26:
            case 27:
                objArr[2] = "isSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSameClass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 32:
                objArr[2] = "isAnonymousObject";
                break;
            case 33:
                objArr[2] = "isAnonymousFunction";
                break;
            case 34:
                objArr[2] = "isEnumEntry";
                break;
            case 35:
                objArr[2] = "isKindOf";
                break;
            case 36:
                objArr[2] = "hasAbstractMembers";
                break;
            case 37:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 39:
                objArr[2] = "getSuperClassType";
                break;
            case 42:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 43:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 44:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 46:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 52:
            case 53:
            case 54:
                objArr[2] = "getInnerClassByName";
                break;
            case 55:
                objArr[2] = "isStaticNestedClass";
                break;
            case 56:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 57:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 61:
            case 62:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 63:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 64:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 65:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 66:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 68:
            case 69:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 70:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 72:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 73:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 74:
                objArr[2] = "getJvmName";
                break;
            case 75:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 76:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 77:
                objArr[2] = "getContainingSourceFile";
                break;
            case 80:
                objArr[2] = "getAllDescriptors";
                break;
            case 82:
            case 83:
                objArr[2] = "getFunctionByName";
                break;
            case 85:
            case 86:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 87:
            case 88:
                objArr[2] = "getPropertyByName";
                break;
            case 90:
                objArr[2] = "getDirectMember";
                break;
            case 92:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 20:
            case 38:
            case 40:
            case 41:
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 58:
            case 60:
            case 67:
            case 71:
            case 78:
            case 79:
            case 81:
            case 84:
            case 89:
            case 91:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static boolean areInSameModule(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(14);
            throw null;
        } else if (declarationDescriptor2 != null) {
            return getContainingModule(declarationDescriptor).equals(getContainingModule(declarationDescriptor2));
        } else {
            a(15);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <D extends CallableDescriptor> void b(@NotNull D d, @NotNull Set<D> set) {
        if (d == null) {
            a(68);
            throw null;
        } else if (!set.contains(d)) {
            for (CallableDescriptor callableDescriptor : d.getOriginal().getOverriddenDescriptors()) {
                CallableDescriptor original = callableDescriptor.getOriginal();
                b(original, set);
                set.add(original);
            }
        }
    }

    @Nullable
    public static FqName c(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(5);
            throw null;
        } else if ((declarationDescriptor instanceof ModuleDescriptor) || ErrorUtils.isError(declarationDescriptor)) {
            return FqName.ROOT;
        } else {
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).getFqName();
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                return ((PackageFragmentDescriptor) declarationDescriptor).getFqName();
            }
            return null;
        }
    }

    @NotNull
    public static FqNameUnsafe d(@NotNull DeclarationDescriptor declarationDescriptor) {
        FqNameUnsafe child = getFqName(declarationDescriptor.getContainingDeclaration()).child(declarationDescriptor.getName());
        if (child != null) {
            return child;
        }
        a(7);
        throw null;
    }

    public static boolean e(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull ClassKind classKind) {
        if (classKind != null) {
            return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).getKind() == classKind;
        }
        a(35);
        throw null;
    }

    public static boolean f(@NotNull KotlinType kotlinType, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            a(28);
            throw null;
        } else if (declarationDescriptor != null) {
            ClassifierDescriptor declarationDescriptor2 = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            if (declarationDescriptor2 == null) {
                return false;
            }
            DeclarationDescriptor original = declarationDescriptor2.getOriginal();
            return (original instanceof ClassifierDescriptor) && (declarationDescriptor instanceof ClassifierDescriptor) && ((ClassifierDescriptor) declarationDescriptor).getTypeConstructor().equals(((ClassifierDescriptor) original).getTypeConstructor());
        } else {
            a(29);
            throw null;
        }
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> getAllOverriddenDescriptors(@NotNull D d) {
        if (d != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            b(d.getOriginal(), linkedHashSet);
            return linkedHashSet;
        }
        a(66);
        throw null;
    }

    @NotNull
    public static ClassDescriptor getClassDescriptorForType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            return getClassDescriptorForTypeConstructor(kotlinType.getConstructor());
        }
        a(43);
        throw null;
    }

    @NotNull
    public static ClassDescriptor getClassDescriptorForTypeConstructor(@NotNull TypeConstructor typeConstructor) {
        if (typeConstructor != null) {
            ClassDescriptor classDescriptor = (ClassDescriptor) typeConstructor.mo425getDeclarationDescriptor();
            if (classDescriptor != null) {
                return classDescriptor;
            }
            a(45);
            throw null;
        }
        a(44);
        throw null;
    }

    @NotNull
    public static ModuleDescriptor getContainingModule(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            ModuleDescriptor containingModuleOrNull = getContainingModuleOrNull(declarationDescriptor);
            if (containingModuleOrNull != null) {
                return containingModuleOrNull;
            }
            a(20);
            throw null;
        }
        a(19);
        throw null;
    }

    @Nullable
    public static ModuleDescriptor getContainingModuleOrNull(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().mo425getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return null;
            }
            return getContainingModuleOrNull(declarationDescriptor);
        }
        a(18);
        throw null;
    }

    @NotNull
    public static SourceFile getContainingSourceFile(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            if (declarationDescriptor instanceof PropertySetterDescriptor) {
                declarationDescriptor = ((PropertySetterDescriptor) declarationDescriptor).getCorrespondingProperty();
            }
            if (declarationDescriptor instanceof DeclarationDescriptorWithSource) {
                SourceFile containingFile = ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile();
                if (containingFile != null) {
                    return containingFile;
                }
                a(78);
                throw null;
            }
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            if (sourceFile != null) {
                return sourceFile;
            }
            a(79);
            throw null;
        }
        a(77);
        throw null;
    }

    @NotNull
    public static DescriptorVisibility getDefaultConstructorVisibility(@NotNull ClassDescriptor classDescriptor, boolean z) {
        if (classDescriptor != null) {
            ClassKind kind = classDescriptor.getKind();
            if (kind == ClassKind.ENUM_CLASS || kind.isSingleton()) {
                DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PRIVATE;
                if (descriptorVisibility != null) {
                    return descriptorVisibility;
                }
                a(47);
                throw null;
            } else if (isSealedClass(classDescriptor)) {
                if (z) {
                    DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.INTERNAL;
                    if (descriptorVisibility2 != null) {
                        return descriptorVisibility2;
                    }
                    a(48);
                    throw null;
                }
                DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE;
                if (descriptorVisibility3 != null) {
                    return descriptorVisibility3;
                }
                a(49);
                throw null;
            } else if (isAnonymousObject(classDescriptor)) {
                DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.DEFAULT_VISIBILITY;
                if (descriptorVisibility4 != null) {
                    return descriptorVisibility4;
                }
                a(50);
                throw null;
            } else {
                DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PUBLIC;
                if (descriptorVisibility5 != null) {
                    return descriptorVisibility5;
                }
                a(51);
                throw null;
            }
        } else {
            a(46);
            throw null;
        }
    }

    @Nullable
    public static ReceiverParameterDescriptor getDispatchReceiverParameterIfNeeded(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        } else if (declarationDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) declarationDescriptor).getThisAsReceiverParameter();
        } else {
            return null;
        }
    }

    @NotNull
    public static FqNameUnsafe getFqName(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            FqName c = c(declarationDescriptor);
            return c != null ? c.toUnsafe() : d(declarationDescriptor);
        }
        a(2);
        throw null;
    }

    @NotNull
    public static FqName getFqNameSafe(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            FqName c = c(declarationDescriptor);
            if (c == null) {
                c = d(declarationDescriptor).toSafe();
            }
            if (c != null) {
                return c;
            }
            a(4);
            throw null;
        }
        a(3);
        throw null;
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull Class<D> cls) {
        if (cls != null) {
            return (D) getParentOfType(declarationDescriptor, cls, true);
        }
        a(16);
        throw null;
    }

    @Nullable
    public static ClassDescriptor getSuperClassDescriptor(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor != null) {
            for (KotlinType kotlinType : classDescriptor.getTypeConstructor().getSupertypes()) {
                ClassDescriptor classDescriptorForType = getClassDescriptorForType(kotlinType);
                if (classDescriptorForType.getKind() != ClassKind.INTERFACE) {
                    return classDescriptorForType;
                }
            }
            return null;
        }
        a(42);
        throw null;
    }

    public static boolean isAnnotationClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        return e(declarationDescriptor, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean isAnonymousObject(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return isClass(declarationDescriptor) && declarationDescriptor.getName().equals(SpecialNames.NO_NAME_PROVIDED);
        }
        a(32);
        throw null;
    }

    public static boolean isClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        return e(declarationDescriptor, ClassKind.CLASS);
    }

    public static boolean isClassOrEnumClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        return isClass(declarationDescriptor) || isEnumClass(declarationDescriptor);
    }

    public static boolean isCompanionObject(@Nullable DeclarationDescriptor declarationDescriptor) {
        return e(declarationDescriptor, ClassKind.OBJECT) && ((ClassDescriptor) declarationDescriptor).isCompanionObject();
    }

    public static boolean isDescriptorWithLocalVisibility(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor instanceof DeclarationDescriptorWithVisibility) && ((DeclarationDescriptorWithVisibility) declarationDescriptor).getVisibility() == DescriptorVisibilities.LOCAL;
    }

    public static boolean isDirectSubclass(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            a(24);
            throw null;
        } else if (classDescriptor2 != null) {
            for (KotlinType kotlinType : classDescriptor.getTypeConstructor().getSupertypes()) {
                if (f(kotlinType, classDescriptor2.getOriginal())) {
                    return true;
                }
            }
            return false;
        } else {
            a(25);
            throw null;
        }
    }

    public static boolean isEnumClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        return e(declarationDescriptor, ClassKind.ENUM_CLASS);
    }

    public static boolean isEnumEntry(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return e(declarationDescriptor, ClassKind.ENUM_ENTRY);
        }
        a(34);
        throw null;
    }

    public static boolean isInterface(@Nullable DeclarationDescriptor declarationDescriptor) {
        return e(declarationDescriptor, ClassKind.INTERFACE);
    }

    public static boolean isLocal(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            while (declarationDescriptor != null) {
                if (isAnonymousObject(declarationDescriptor) || isDescriptorWithLocalVisibility(declarationDescriptor)) {
                    return true;
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
        a(1);
        throw null;
    }

    public static boolean isSealedClass(@Nullable DeclarationDescriptor declarationDescriptor) {
        return (e(declarationDescriptor, ClassKind.CLASS) || e(declarationDescriptor, ClassKind.INTERFACE)) && ((ClassDescriptor) declarationDescriptor).getModality() == Modality.SEALED;
    }

    public static boolean isSubclass(@NotNull ClassDescriptor classDescriptor, @NotNull ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            a(26);
            throw null;
        } else if (classDescriptor2 != null) {
            return isSubtypeOfClass(classDescriptor.getDefaultType(), classDescriptor2.getOriginal());
        } else {
            a(27);
            throw null;
        }
    }

    public static boolean isSubtypeOfClass(@NotNull KotlinType kotlinType, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            a(30);
            throw null;
        } else if (declarationDescriptor == null) {
            a(31);
            throw null;
        } else if (f(kotlinType, declarationDescriptor)) {
            return true;
        } else {
            for (KotlinType kotlinType2 : kotlinType.getConstructor().getSupertypes()) {
                if (isSubtypeOfClass(kotlinType2, declarationDescriptor)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean isTopLevelDeclaration(@Nullable DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor != null && (declarationDescriptor.getContainingDeclaration() instanceof PackageFragmentDescriptor);
    }

    public static boolean shouldRecordInitializerForProperty(@NotNull VariableDescriptor variableDescriptor, @NotNull KotlinType kotlinType) {
        if (variableDescriptor == null) {
            a(61);
            throw null;
        } else if (kotlinType == null) {
            a(62);
            throw null;
        } else if (variableDescriptor.isVar() || KotlinTypeKt.isError(kotlinType)) {
            return false;
        } else {
            if (TypeUtils.acceptsNullable(kotlinType)) {
                return true;
            }
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(variableDescriptor);
            if (!KotlinBuiltIns.isPrimitiveType(kotlinType)) {
                KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.DEFAULT;
                if (!kotlinTypeChecker.equalTypes(builtIns.getStringType(), kotlinType) && !kotlinTypeChecker.equalTypes(builtIns.getNumber().getDefaultType(), kotlinType) && !kotlinTypeChecker.equalTypes(builtIns.getAnyType(), kotlinType)) {
                    UnsignedTypes unsignedTypes = UnsignedTypes.INSTANCE;
                    if (!UnsignedTypes.isUnsignedType(kotlinType)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> D unwrapFakeOverride(@NotNull D d) {
        if (d != null) {
            while (d.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                Collection<? extends CallableMemberDescriptor> overriddenDescriptors = d.getOverriddenDescriptors();
                if (!overriddenDescriptors.isEmpty()) {
                    d = (D) ((CallableMemberDescriptor) overriddenDescriptors.iterator().next());
                } else {
                    throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d);
                }
            }
            return d;
        }
        a(57);
        throw null;
    }

    @NotNull
    public static <D extends DeclarationDescriptorWithVisibility> D unwrapFakeOverrideToAnyDeclaration(@NotNull D d) {
        if (d == null) {
            a(59);
            throw null;
        } else if (d instanceof CallableMemberDescriptor) {
            return unwrapFakeOverride((CallableMemberDescriptor) d);
        } else {
            if (d != null) {
                return d;
            }
            a(60);
            throw null;
        }
    }

    @Nullable
    public static <D extends DeclarationDescriptor> D getParentOfType(@Nullable DeclarationDescriptor declarationDescriptor, @NotNull Class<D> cls, boolean z) {
        if (cls == null) {
            a(17);
            throw null;
        } else if (declarationDescriptor == null) {
            return null;
        } else {
            if (z) {
                declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
            }
            while (declarationDescriptor != null) {
                if (cls.isInstance(declarationDescriptor)) {
                    return (D) declarationDescriptor;
                }
                declarationDescriptor = (D) declarationDescriptor.getContainingDeclaration();
            }
            return null;
        }
    }

    @Nullable
    public static ModuleDescriptor getContainingModuleOrNull(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            while (declarationDescriptor != null) {
                if (declarationDescriptor instanceof ModuleDescriptor) {
                    return (ModuleDescriptor) declarationDescriptor;
                }
                if (declarationDescriptor instanceof PackageViewDescriptor) {
                    return ((PackageViewDescriptor) declarationDescriptor).getModule();
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return null;
        }
        a(21);
        throw null;
    }
}
