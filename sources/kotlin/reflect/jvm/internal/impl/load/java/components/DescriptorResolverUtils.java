package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class DescriptorResolverUtils {

    public static class a extends NonReportingOverrideStrategy {
        public final /* synthetic */ ErrorReporter a;
        public final /* synthetic */ Set b;
        public final /* synthetic */ boolean c;

        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils$a$a  reason: collision with other inner class name */
        public class C0508a implements Function1<CallableMemberDescriptor, Unit> {
            public C0508a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
                if (callableMemberDescriptor2 != null) {
                    a.this.a.reportCannotInferVisibility(callableMemberDescriptor2);
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }
        }

        public a(ErrorReporter errorReporter, Set set, boolean z) {
            this.a = errorReporter;
            this.b = set;
            this.c = z;
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "fromSuper";
            } else if (i == 2) {
                objArr[0] = "fromCurrent";
            } else if (i == 3) {
                objArr[0] = "member";
            } else if (i != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i == 1 || i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
        public void addFakeOverride(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor != null) {
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, new C0508a());
                this.b.add(callableMemberDescriptor);
                return;
            }
            a(0);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
        public void conflict(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
            if (callableMemberDescriptor == null) {
                a(1);
                throw null;
            } else if (callableMemberDescriptor2 == null) {
                a(2);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
        public void setOverriddenDescriptors(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection) {
            if (callableMemberDescriptor == null) {
                a(3);
                throw null;
            } else if (collection == null) {
                a(4);
                throw null;
            } else if (!this.c || callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                super.setOverriddenDescriptors(callableMemberDescriptor, collection);
            }
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 18 ? 3 : 2)];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> b(@NotNull Name name, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil, boolean z) {
        if (name == null) {
            a(12);
            throw null;
        } else if (collection == null) {
            a(13);
            throw null;
        } else if (collection2 == null) {
            a(14);
            throw null;
        } else if (classDescriptor == null) {
            a(15);
            throw null;
        } else if (errorReporter == null) {
            a(16);
            throw null;
        } else if (overridingUtil != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            overridingUtil.generateOverridesInFunctionGroup(name, collection, collection2, classDescriptor, new a(errorReporter, linkedHashSet, z));
            return linkedHashSet;
        } else {
            a(17);
            throw null;
        }
    }

    @Nullable
    public static ValueParameterDescriptor getAnnotationParameterByName(@NotNull Name name, @NotNull ClassDescriptor classDescriptor) {
        if (name == null) {
            a(19);
            throw null;
        } else if (classDescriptor != null) {
            Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
            if (constructors.size() != 1) {
                return null;
            }
            for (ValueParameterDescriptor valueParameterDescriptor : constructors.iterator().next().getValueParameters()) {
                if (valueParameterDescriptor.getName().equals(name)) {
                    return valueParameterDescriptor;
                }
            }
            return null;
        } else {
            a(20);
            throw null;
        }
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(@NotNull Name name, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil) {
        if (name == null) {
            a(0);
            throw null;
        } else if (collection == null) {
            a(1);
            throw null;
        } else if (collection2 == null) {
            a(2);
            throw null;
        } else if (classDescriptor == null) {
            a(3);
            throw null;
        } else if (errorReporter == null) {
            a(4);
            throw null;
        } else if (overridingUtil != null) {
            return b(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, false);
        } else {
            a(5);
            throw null;
        }
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(@NotNull Name name, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull ErrorReporter errorReporter, @NotNull OverridingUtil overridingUtil) {
        if (name == null) {
            a(6);
            throw null;
        } else if (collection == null) {
            a(7);
            throw null;
        } else if (collection2 == null) {
            a(8);
            throw null;
        } else if (classDescriptor == null) {
            a(9);
            throw null;
        } else if (errorReporter == null) {
            a(10);
            throw null;
        } else if (overridingUtil != null) {
            return b(name, collection, collection2, classDescriptor, errorReporter, overridingUtil, true);
        } else {
            a(11);
            throw null;
        }
    }
}
