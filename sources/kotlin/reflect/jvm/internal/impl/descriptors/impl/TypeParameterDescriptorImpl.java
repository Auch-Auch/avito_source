package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class TypeParameterDescriptorImpl extends AbstractTypeParameterDescriptor {
    @Nullable
    public final Function1<KotlinType, Void> k;
    public final List<KotlinType> l;
    public boolean m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TypeParameterDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull Name name, int i, @NotNull SourceElement sourceElement, @Nullable Function1<KotlinType, Void> function1, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull StorageManager storageManager) {
        super(storageManager, declarationDescriptor, annotations, name, variance, z, i, sourceElement, supertypeLoopChecker);
        if (declarationDescriptor == null) {
            a(19);
            throw null;
        } else if (annotations == null) {
            a(20);
            throw null;
        } else if (variance == null) {
            a(21);
            throw null;
        } else if (name == null) {
            a(22);
            throw null;
        } else if (sourceElement == null) {
            a(23);
            throw null;
        } else if (supertypeLoopChecker == null) {
            a(24);
            throw null;
        } else if (storageManager != null) {
            this.l = new ArrayList(1);
            this.m = false;
            this.k = function1;
        } else {
            a(25);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 28) ? 2 : 3)];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 5 || i == 28) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull Name name, int i, @NotNull SourceElement sourceElement, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(6);
            throw null;
        } else if (annotations == null) {
            a(7);
            throw null;
        } else if (variance == null) {
            a(8);
            throw null;
        } else if (name == null) {
            a(9);
            throw null;
        } else if (sourceElement == null) {
            a(10);
            throw null;
        } else if (storageManager != null) {
            return createForFurtherModification(declarationDescriptor, annotations, z, variance, name, i, sourceElement, null, SupertypeLoopChecker.EMPTY.INSTANCE, storageManager);
        } else {
            a(11);
            throw null;
        }
    }

    @NotNull
    public static TypeParameterDescriptor createWithDefaultBound(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull Name name, int i, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        } else if (annotations == null) {
            a(1);
            throw null;
        } else if (variance == null) {
            a(2);
            throw null;
        } else if (name == null) {
            a(3);
            throw null;
        } else if (storageManager != null) {
            TypeParameterDescriptorImpl createForFurtherModification = createForFurtherModification(declarationDescriptor, annotations, z, variance, name, i, SourceElement.NO_SOURCE, storageManager);
            createForFurtherModification.addUpperBound(DescriptorUtilsKt.getBuiltIns(declarationDescriptor).getDefaultBound());
            createForFurtherModification.setInitialized();
            return createForFurtherModification;
        } else {
            a(4);
            throw null;
        }
    }

    public void addUpperBound(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            b();
            if (!KotlinTypeKt.isError(kotlinType)) {
                this.l.add(kotlinType);
                return;
            }
            return;
        }
        a(26);
        throw null;
    }

    public final void b() {
        if (this.m) {
            StringBuilder L = a.L("Type parameter descriptor is already initialized: ");
            L.append(c());
            throw new IllegalStateException(L.toString());
        }
    }

    public final String c() {
        return getName() + " declared in " + DescriptorUtils.getFqName(getContainingDeclaration());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    public void reportSupertypeLoopError(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            Function1<KotlinType, Void> function1 = this.k;
            if (function1 != null) {
                function1.invoke(kotlinType);
                return;
            }
            return;
        }
        a(27);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
    @NotNull
    public List<KotlinType> resolveUpperBounds() {
        if (this.m) {
            List<KotlinType> list = this.l;
            if (list != null) {
                return list;
            }
            a(28);
            throw null;
        }
        StringBuilder L = a.L("Type parameter descriptor is not initialized: ");
        L.append(c());
        throw new IllegalStateException(L.toString());
    }

    public void setInitialized() {
        b();
        this.m = true;
    }

    public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, boolean z, @NotNull Variance variance, @NotNull Name name, int i, @NotNull SourceElement sourceElement, @Nullable Function1<KotlinType, Void> function1, @NotNull SupertypeLoopChecker supertypeLoopChecker, @NotNull StorageManager storageManager) {
        if (declarationDescriptor == null) {
            a(12);
            throw null;
        } else if (annotations == null) {
            a(13);
            throw null;
        } else if (variance == null) {
            a(14);
            throw null;
        } else if (name == null) {
            a(15);
            throw null;
        } else if (sourceElement == null) {
            a(16);
            throw null;
        } else if (supertypeLoopChecker == null) {
            a(17);
            throw null;
        } else if (storageManager != null) {
            return new TypeParameterDescriptorImpl(declarationDescriptor, annotations, z, variance, name, i, sourceElement, function1, supertypeLoopChecker, storageManager);
        } else {
            a(18);
            throw null;
        }
    }
}
