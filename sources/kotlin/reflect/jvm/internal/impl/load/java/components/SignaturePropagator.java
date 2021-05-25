package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.avito.android.util.UrlParams;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = new a();

    public static class PropagatedSignature {
        public final KotlinType a;
        public final KotlinType b;
        public final List<ValueParameterDescriptor> c;
        public final List<TypeParameterDescriptor> d;
        public final List<String> e;
        public final boolean f;

        public PropagatedSignature(@NotNull KotlinType kotlinType, @Nullable KotlinType kotlinType2, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2, @NotNull List<String> list3, boolean z) {
            if (kotlinType == null) {
                a(0);
                throw null;
            } else if (list == null) {
                a(1);
                throw null;
            } else if (list2 == null) {
                a(2);
                throw null;
            } else if (list3 != null) {
                this.a = kotlinType;
                this.b = kotlinType2;
                this.c = list;
                this.d = list2;
                this.e = list3;
                this.f = z;
            } else {
                a(3);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i == 4) {
                objArr[1] = "getReturnType";
            } else if (i == 5) {
                objArr[1] = "getValueParameters";
            } else if (i == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (!(i == 4 || i == 5 || i == 6 || i == 7)) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 4 || i == 5 || i == 6 || i == 7) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @NotNull
        public List<String> getErrors() {
            List<String> list = this.e;
            if (list != null) {
                return list;
            }
            a(7);
            throw null;
        }

        @Nullable
        public KotlinType getReceiverType() {
            return this.b;
        }

        @NotNull
        public KotlinType getReturnType() {
            KotlinType kotlinType = this.a;
            if (kotlinType != null) {
                return kotlinType;
            }
            a(4);
            throw null;
        }

        @NotNull
        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> list = this.d;
            if (list != null) {
                return list;
            }
            a(6);
            throw null;
        }

        @NotNull
        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> list = this.c;
            if (list != null) {
                return list;
            }
            a(5);
            throw null;
        }

        public boolean hasStableParameterNames() {
            return this.f;
        }
    }

    public static class a implements SignaturePropagator {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = UrlParams.OWNER;
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i == 5 || i == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        public void reportSignatureErrors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list) {
            if (list == null) {
                a(6);
                throw null;
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator
        @NotNull
        public PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod javaMethod, @NotNull ClassDescriptor classDescriptor, @NotNull KotlinType kotlinType, @Nullable KotlinType kotlinType2, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
            if (javaMethod == null) {
                a(0);
                throw null;
            } else if (classDescriptor == null) {
                a(1);
                throw null;
            } else if (kotlinType == null) {
                a(2);
                throw null;
            } else if (list == null) {
                a(3);
                throw null;
            } else if (list2 != null) {
                return new PropagatedSignature(kotlinType, null, list, list2, Collections.emptyList(), false);
            } else {
                a(4);
                throw null;
            }
        }
    }

    void reportSignatureErrors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list);

    @NotNull
    PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod javaMethod, @NotNull ClassDescriptor classDescriptor, @NotNull KotlinType kotlinType, @Nullable KotlinType kotlinType2, @NotNull List<ValueParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2);
}
