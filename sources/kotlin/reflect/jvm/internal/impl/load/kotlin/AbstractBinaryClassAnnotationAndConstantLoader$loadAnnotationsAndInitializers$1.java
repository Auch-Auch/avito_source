package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.avito.android.util.preferences.SessionContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 implements KotlinJvmBinaryClass.MemberVisitor {
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> a;
    public final /* synthetic */ HashMap<MemberSignature, List<A>> b;
    public final /* synthetic */ HashMap<MemberSignature, C> c;

    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements KotlinJvmBinaryClass.MethodAnnotationVisitor {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnnotationVisitorForMethod(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
            Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            Intrinsics.checkNotNullParameter(memberSignature, SessionContract.SIGNATURE);
            this.d = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, @NotNull ClassId classId, @NotNull SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            MemberSignature fromMethodSignatureAndParameterIndex = MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
            List<A> list = this.d.b.get(fromMethodSignatureAndParameterIndex);
            if (list == null) {
                list = new ArrayList<>();
                this.d.b.put(fromMethodSignatureAndParameterIndex, list);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.d.a, classId, sourceElement, list);
        }
    }

    public class MemberAnnotationVisitor implements KotlinJvmBinaryClass.AnnotationVisitor {
        @NotNull
        public final MemberSignature a;
        @NotNull
        public final ArrayList<A> b = new ArrayList<>();
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 c;

        public MemberAnnotationVisitor(@NotNull AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            Intrinsics.checkNotNullParameter(memberSignature, SessionContract.SIGNATURE);
            this.c = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            this.a = memberSignature;
        }

        @NotNull
        public final MemberSignature getSignature() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        @Nullable
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(@NotNull ClassId classId, @NotNull SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.c.a, classId, sourceElement, this.b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
        public void visitEnd() {
            if (!this.b.isEmpty()) {
                this.c.b.put(this.a, this.b);
            }
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> hashMap, HashMap<MemberSignature, C> hashMap2) {
        this.a = abstractBinaryClassAnnotationAndConstantLoader;
        this.b = hashMap;
        this.c = hashMap2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    @Nullable
    public KotlinJvmBinaryClass.AnnotationVisitor visitField(@NotNull Name name, @NotNull String str, @Nullable Object obj) {
        C loadConstant;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        MemberSignature fromFieldNameAndDesc = companion.fromFieldNameAndDesc(asString, str);
        if (!(obj == null || (loadConstant = this.a.loadConstant(str, obj)) == null)) {
            this.c.put(fromFieldNameAndDesc, loadConstant);
        }
        return new MemberAnnotationVisitor(this, fromFieldNameAndDesc);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
    @Nullable
    public KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(@NotNull Name name, @NotNull String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        MemberSignature.Companion companion = MemberSignature.Companion;
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        return new AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(asString, str));
    }
}
