package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    public final TypeConstructor g;
    public final MemberScope h;
    public final NotNullLazyValue<Set<Name>> i;
    public final Annotations j;

    public class a extends MemberScopeImpl {
        public final MemoizedFunctionToNotNull<Name, Collection<? extends SimpleFunctionDescriptor>> a;
        public final MemoizedFunctionToNotNull<Name, Collection<? extends PropertyDescriptor>> b;
        public final NotNullLazyValue<Collection<DeclarationDescriptor>> c;
        public final /* synthetic */ EnumEntrySyntheticClassDescriptor d;

        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor$a$a  reason: collision with other inner class name */
        public class C0507a implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public C0507a(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                Name name2 = name;
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name2 != null) {
                    return aVar.c(name2, aVar.b().getContributedFunctions(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                }
                a.a(8);
                throw null;
            }
        }

        public class b implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public b(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends PropertyDescriptor> invoke(Name name) {
                Name name2 = name;
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name2 != null) {
                    return aVar.c(name2, aVar.b().getContributedVariables(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                }
                a.a(4);
                throw null;
            }
        }

        public class c implements Function0<Collection<DeclarationDescriptor>> {
            public c(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Collection<DeclarationDescriptor> invoke() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                HashSet hashSet = new HashSet();
                for (Name name : (Set) aVar.d.i.invoke()) {
                    NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                    hashSet.addAll(aVar.getContributedFunctions(name, noLookupLocation));
                    hashSet.addAll(aVar.getContributedVariables(name, noLookupLocation));
                }
                return hashSet;
            }
        }

        public class d extends NonReportingOverrideStrategy {
            public final /* synthetic */ Set a;

            public d(a aVar, Set set) {
                this.a = set;
            }

            public static /* synthetic */ void a(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
            public void addFakeOverride(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor != null) {
                    OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                    this.a.add(callableMemberDescriptor);
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
        }

        public a(@NotNull EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager != null) {
                this.d = enumEntrySyntheticClassDescriptor;
                this.a = storageManager.createMemoizedFunction(new C0507a(enumEntrySyntheticClassDescriptor));
                this.b = storageManager.createMemoizedFunction(new b(enumEntrySyntheticClassDescriptor));
                this.c = storageManager.createLazyValue(new c(enumEntrySyntheticClassDescriptor));
                return;
            }
            a(0);
            throw null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009d  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00ad  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void a(int r13) {
            /*
            // Method dump skipped, instructions count: 346
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor.a.a(int):void");
        }

        @NotNull
        public final MemberScope b() {
            MemberScope memberScope = this.d.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope != null) {
                return memberScope;
            }
            a(9);
            throw null;
        }

        @NotNull
        public final <D extends CallableMemberDescriptor> Collection<? extends D> c(@NotNull Name name, @NotNull Collection<? extends D> collection) {
            if (name == null) {
                a(10);
                throw null;
            } else if (collection != null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                OverridingUtil.DEFAULT.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), this.d, new d(this, linkedHashSet));
                return linkedHashSet;
            } else {
                a(11);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getClassifierNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            a(18);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                a(13);
                throw null;
            } else if (function1 != null) {
                Collection<DeclarationDescriptor> collection = (Collection) this.c.invoke();
                if (collection != null) {
                    return collection;
                }
                a(15);
                throw null;
            } else {
                a(14);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(5);
                throw null;
            } else if (lookupLocation != null) {
                Collection<? extends SimpleFunctionDescriptor> invoke = this.a.invoke(name);
                if (invoke != null) {
                    return invoke;
                }
                a(7);
                throw null;
            } else {
                a(6);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(1);
                throw null;
            } else if (lookupLocation != null) {
                Collection<? extends PropertyDescriptor> invoke = this.b.invoke(name);
                if (invoke != null) {
                    return invoke;
                }
                a(3);
                throw null;
            } else {
                a(2);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getFunctionNames() {
            Set<Name> set = (Set) this.d.i.invoke();
            if (set != null) {
                return set;
            }
            a(17);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getVariableNames() {
            Set<Name> set = (Set) this.d.i.invoke();
            if (set != null) {
                return set;
            }
            a(19);
            throw null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumEntrySyntheticClassDescriptor(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull KotlinType kotlinType, @NotNull Name name, @NotNull NotNullLazyValue<Set<Name>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        super(storageManager, classDescriptor, name, sourceElement, false);
        if (storageManager == null) {
            a(6);
            throw null;
        } else if (kotlinType == null) {
            a(8);
            throw null;
        } else if (name == null) {
            a(9);
            throw null;
        } else if (notNullLazyValue == null) {
            a(10);
            throw null;
        } else if (annotations == null) {
            a(11);
            throw null;
        } else if (sourceElement != null) {
            this.j = annotations;
            this.g = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(kotlinType), storageManager);
            this.h = new a(this, storageManager);
            this.i = notNullLazyValue;
        } else {
            a(12);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    public static EnumEntrySyntheticClassDescriptor create(@NotNull StorageManager storageManager, @NotNull ClassDescriptor classDescriptor, @NotNull Name name, @NotNull NotNullLazyValue<Set<Name>> notNullLazyValue, @NotNull Annotations annotations, @NotNull SourceElement sourceElement) {
        if (storageManager == null) {
            a(0);
            throw null;
        } else if (classDescriptor == null) {
            a(1);
            throw null;
        } else if (name == null) {
            a(2);
            throw null;
        } else if (notNullLazyValue == null) {
            a(3);
            throw null;
        } else if (annotations == null) {
            a(4);
            throw null;
        } else if (sourceElement != null) {
            return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, notNullLazyValue, annotations, sourceElement);
        } else {
            a(5);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations = this.j;
        if (annotations != null) {
            return annotations;
        }
        a(21);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        a(16);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        a(22);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind != null) {
            return classKind;
        }
        a(18);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality != null) {
            return modality;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List emptyList = Collections.emptyList();
        if (emptyList != null) {
            return emptyList;
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty != null) {
            return empty;
        }
        a(15);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.g;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        a(17);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    @NotNull
    public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            MemberScope memberScope = this.h;
            if (memberScope != null) {
                return memberScope;
            }
            a(14);
            throw null;
        }
        a(13);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        a(20);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("enum entry ");
        L.append(getName());
        return L.toString();
    }
}
