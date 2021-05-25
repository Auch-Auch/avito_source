package kotlin.reflect.jvm.internal.impl.load.java;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class JavaDescriptorVisibilities {
    @NotNull
    public static final DescriptorVisibility PACKAGE_VISIBILITY;
    @NotNull
    public static final DescriptorVisibility PROTECTED_AND_PACKAGE;
    @NotNull
    public static final DescriptorVisibility PROTECTED_STATIC_VISIBILITY;
    @NotNull
    public static final Map<Visibility, DescriptorVisibility> a = new HashMap();

    public static class a extends DelegatedDescriptorVisibility {
        public a(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.c(declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class b extends DelegatedDescriptorVisibility {
        public b(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class c extends DelegatedDescriptorVisibility {
        public c(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return JavaDescriptorVisibilities.b(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                a(1);
                throw null;
            }
        }
    }

    static {
        a aVar = new a(JavaVisibilities.PackageVisibility.INSTANCE);
        PACKAGE_VISIBILITY = aVar;
        b bVar = new b(JavaVisibilities.ProtectedStaticVisibility.INSTANCE);
        PROTECTED_STATIC_VISIBILITY = bVar;
        c cVar = new c(JavaVisibilities.ProtectedAndPackage.INSTANCE);
        PROTECTED_AND_PACKAGE = cVar;
        d(aVar);
        d(bVar);
        d(cVar);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = InternalConstsKt.FIRST_IMAGE;
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY;
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (!(i == 5 || i == 6)) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i == 5 || i == 6) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    public static boolean b(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(0);
            throw null;
        } else if (declarationDescriptor == null) {
            a(1);
            throw null;
        } else if (c(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        } else {
            return DescriptorVisibilities.PROTECTED.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    public static boolean c(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(2);
            throw null;
        } else if (declarationDescriptor2 != null) {
            PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, PackageFragmentDescriptor.class, false);
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, PackageFragmentDescriptor.class, false);
            if (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) {
                return false;
            }
            return true;
        } else {
            a(3);
            throw null;
        }
    }

    public static void d(DescriptorVisibility descriptorVisibility) {
        a.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    @NotNull
    public static DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        if (visibility != null) {
            DescriptorVisibility descriptorVisibility = a.get(visibility);
            if (descriptorVisibility != null) {
                return descriptorVisibility;
            }
            DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.toDescriptorVisibility(visibility);
            if (descriptorVisibility2 != null) {
                return descriptorVisibility2;
            }
            a(5);
            throw null;
        }
        a(4);
        throw null;
    }
}
