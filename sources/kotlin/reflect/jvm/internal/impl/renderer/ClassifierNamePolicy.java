package kotlin.reflect.jvm.internal.impl.renderer;

import com.avito.android.lib.design.input.FormatterType;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;
import t6.n.i;
public interface ClassifierNamePolicy {

    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        @NotNull
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return descriptorRenderer.renderFqName(fqName);
        }
    }

    public static final class SHORT implements ClassifierNamePolicy {
        @NotNull
        public static final SHORT INSTANCE = new SHORT();

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            boolean z;
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
            do {
                arrayList.add(classifierDescriptor2.getName());
                DeclarationDescriptor containingDeclaration = classifierDescriptor2.getContainingDeclaration();
                z = containingDeclaration instanceof ClassDescriptor;
                classifierDescriptor2 = containingDeclaration;
            } while (z);
            return RenderingUtilsKt.renderFqName(i.asReversedMutable(arrayList));
        }
    }

    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        @NotNull
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        public final String a(ClassifierDescriptor classifierDescriptor) {
            String str;
            Name name = classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
            String render = RenderingUtilsKt.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                str = a((ClassifierDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) containingDeclaration).getFqName().toUnsafe();
                Intrinsics.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                str = RenderingUtilsKt.render(unsafe);
            } else {
                str = null;
            }
            if (str == null || Intrinsics.areEqual(str, "")) {
                return render;
            }
            return ((Object) str) + FormatterType.defaultDecimalSeparator + render;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            return a(classifierDescriptor);
        }
    }

    @NotNull
    String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer);
}
