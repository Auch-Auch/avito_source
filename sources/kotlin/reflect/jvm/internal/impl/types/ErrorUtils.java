package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class ErrorUtils {
    public static final SimpleType ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = createErrorType("<LOOP IN SUPERTYPES>");
    public static final ModuleDescriptor a = new a();
    public static final c b;
    public static final KotlinType c;
    public static final PropertyDescriptor d;
    public static final Set<PropertyDescriptor> e;

    public static class ErrorScope implements MemberScope {
        public final String a;

        public ErrorScope(String str, a aVar) {
            if (str != null) {
                this.a = str;
            } else {
                a(0);
                throw null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void a(int r10) {
            /*
            // Method dump skipped, instructions count: 306
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getClassifierNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            a(13);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(1);
                throw null;
            } else if (lookupLocation != null) {
                return ErrorUtils.createErrorClass(name.asString());
            } else {
                a(2);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                a(16);
                throw null;
            } else if (function1 != null) {
                List emptyList = Collections.emptyList();
                if (emptyList != null) {
                    return emptyList;
                }
                a(18);
                throw null;
            } else {
                a(17);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(5);
                throw null;
            } else if (lookupLocation != null) {
                Set<PropertyDescriptor> set = ErrorUtils.e;
                if (set != null) {
                    return set;
                }
                a(7);
                throw null;
            } else {
                a(6);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getFunctionNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            a(11);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getVariableNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            a(12);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(14);
                throw null;
            } else if (lookupLocation == null) {
                a(15);
                throw null;
            }
        }

        public String toString() {
            return a2.b.a.a.a.s(a2.b.a.a.a.L("ErrorScope{"), this.a, '}');
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(8);
                throw null;
            } else if (lookupLocation != null) {
                ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = new ErrorSimpleFunctionDescriptorImpl(ErrorUtils.b, this);
                errorSimpleFunctionDescriptorImpl.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) ErrorUtils.createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, DescriptorVisibilities.PUBLIC);
                Set<? extends SimpleFunctionDescriptor> singleton = Collections.singleton(errorSimpleFunctionDescriptorImpl);
                if (singleton != null) {
                    return singleton;
                }
                a(10);
                throw null;
            } else {
                a(9);
                throw null;
            }
        }
    }

    public static class UninferredParameterTypeConstructor implements TypeConstructor {
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(null);
            if (builtIns != null) {
                return builtIns;
            }
            a(4);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo425getDeclarationDescriptor() {
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<KotlinType> getSupertypes() {
            throw null;
        }

        @NotNull
        public TypeParameterDescriptor getTypeParameterDescriptor() {
            a(1);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(5);
            throw null;
        }
    }

    public static class a implements ModuleDescriptor {
        /* JADX WARNING: Removed duplicated region for block: B:18:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x009f  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00be  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void a(int r12) {
            /*
            // Method dump skipped, instructions count: 306
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.ErrorUtils.a.a(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            a(11);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
        @NotNull
        public Annotations getAnnotations() {
            Annotations empty = Annotations.Companion.getEMPTY();
            if (empty != null) {
                return empty;
            }
            a(1);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns instance = DefaultBuiltIns.getInstance();
            if (instance != null) {
                return instance;
            }
            a(14);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @Nullable
        public <T> T getCapability(@NotNull ModuleCapability<T> moduleCapability) {
            if (moduleCapability != null) {
                return null;
            }
            a(0);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @Nullable
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public List<ModuleDescriptor> getExpectedByModules() {
            List<ModuleDescriptor> emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            a(9);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
        @NotNull
        public Name getName() {
            Name special = Name.special("<ERROR MODULE>");
            if (special != null) {
                return special;
            }
            a(5);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
        @NotNull
        public DeclarationDescriptor getOriginal() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public PackageViewDescriptor getPackage(@NotNull FqName fqName) {
            if (fqName == null) {
                a(7);
                throw null;
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        @NotNull
        public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName, @NotNull Function1<? super Name, Boolean> function1) {
            if (fqName == null) {
                a(2);
                throw null;
            } else if (function1 != null) {
                List emptyList = CollectionsKt__CollectionsKt.emptyList();
                if (emptyList != null) {
                    return emptyList;
                }
                a(4);
                throw null;
            } else {
                a(3);
                throw null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
        public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor != null) {
                return false;
            }
            a(12);
            throw null;
        }
    }

    public static class b implements TypeConstructor {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;

        public b(c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i != 3 ? 2 : 3)];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String format = String.format(str, objArr);
            if (i != 3) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns instance = DefaultBuiltIns.getInstance();
            if (instance != null) {
                return instance;
            }
            a(2);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @Nullable
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo425getDeclarationDescriptor() {
            return this.a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            a(0);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public Collection<KotlinType> getSupertypes() {
            List emptyList = CollectionsKt__CollectionsKt.emptyList();
            if (emptyList != null) {
                return emptyList;
            }
            a(1);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        @NotNull
        public TypeConstructor refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(3);
            throw null;
        }

        public String toString() {
            return this.b;
        }
    }

    public static class c extends ClassDescriptorImpl {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.Name r11) {
            /*
                r10 = this;
                if (r11 == 0) goto L_0x004f
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r1 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.getErrorModule()
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r3 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
                kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
                java.util.List r5 = java.util.Collections.emptyList()
                kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
                r7 = 0
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.NO_LOCKS
                r0 = r10
                r2 = r11
                r6 = r9
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r11 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
                kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r11.getEMPTY()
                r0 = 1
                kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl r11 = kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl.create(r10, r11, r0, r9)
                java.util.List r0 = java.util.Collections.emptyList()
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INTERNAL
                r11.initialize(r0, r1)
                kotlin.reflect.jvm.internal.impl.name.Name r0 = r10.getName()
                java.lang.String r0 = r0.asString()
                kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.createErrorScope(r0)
                kotlin.reflect.jvm.internal.impl.types.ErrorType r1 = new kotlin.reflect.jvm.internal.impl.types.ErrorType
                java.lang.String r2 = "<ERROR>"
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r2 = kotlin.reflect.jvm.internal.impl.types.ErrorUtils.b(r2, r10)
                r1.<init>(r2, r0)
                r11.setReturnType(r1)
                java.util.Set r1 = java.util.Collections.singleton(r11)
                r10.initialize(r0, r1, r11)
                return
            L_0x004f:
                r11 = 0
                a(r11)
                r11 = 0
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.ErrorUtils.c.<init>(kotlin.reflect.jvm.internal.impl.name.Name):void");
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i == 2 || i == 5 || i == 8) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
        @NotNull
        public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
            if (typeSubstitution == null) {
                a(6);
                throw null;
            } else if (kotlinTypeRefiner != null) {
                StringBuilder L = a2.b.a.a.a.L("Error scope for class ");
                L.append(getName());
                L.append(" with arguments: ");
                L.append(typeSubstitution);
                MemberScope createErrorScope = ErrorUtils.createErrorScope(L.toString());
                if (createErrorScope != null) {
                    return createErrorScope;
                }
                a(8);
                throw null;
            } else {
                a(7);
                throw null;
            }
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
        @NotNull
        /* renamed from: substitute */
        public ClassifierDescriptorWithTypeParameters mo426substitute(@NotNull TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor != null) {
                return this;
            }
            a(1);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
        /* renamed from: substitute  reason: collision with other method in class */
        public ClassifierDescriptorWithTypeParameters mo426substitute(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor != null) {
                return this;
            }
            a(1);
            throw null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
        public String toString() {
            return getName().asString();
        }
    }

    public static class d implements MemberScope {
        public final String a;

        public d(String str, a aVar) {
            if (str != null) {
                this.a = str;
            } else {
                a(0);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(1);
                throw null;
            } else if (lookupLocation == null) {
                a(2);
                throw null;
            } else {
                throw new IllegalStateException(this.a + ", required name: " + name);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                a(9);
                throw null;
            } else if (function1 == null) {
                a(10);
                throw null;
            } else {
                throw new IllegalStateException(this.a);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        @NotNull
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(7);
                throw null;
            } else if (lookupLocation == null) {
                a(8);
                throw null;
            } else {
                throw new IllegalStateException(this.a + ", required name: " + name);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(5);
                throw null;
            } else if (lookupLocation == null) {
                a(6);
                throw null;
            } else {
                throw new IllegalStateException(this.a + ", required name: " + name);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @NotNull
        public Set<Name> getVariableNames() {
            throw new IllegalStateException();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
        public void recordLookup(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
            if (name == null) {
                a(11);
                throw null;
            } else if (lookupLocation == null) {
                a(12);
                throw null;
            } else {
                throw new IllegalStateException();
            }
        }

        public String toString() {
            return a2.b.a.a.a.s(a2.b.a.a.a.L("ThrowingScope{"), this.a, '}');
        }
    }

    static {
        c cVar = new c(Name.special("<ERROR CLASS>"));
        b = cVar;
        SimpleType createErrorType = createErrorType("<ERROR PROPERTY TYPE>");
        c = createErrorType;
        PropertyDescriptorImpl create = PropertyDescriptorImpl.create(cVar, Annotations.Companion.getEMPTY(), Modality.OPEN, DescriptorVisibilities.PUBLIC, true, Name.special("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        create.setType(createErrorType, Collections.emptyList(), null, null);
        d = create;
        e = Collections.singleton(create);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 6 || i == 19) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 4 || i == 6 || i == 19) {
            throw new IllegalStateException(format);
        }
        throw new IllegalArgumentException(format);
    }

    @NotNull
    public static TypeConstructor b(@NotNull String str, @NotNull c cVar) {
        if (str == null) {
            a(17);
            throw null;
        } else if (cVar != null) {
            return new b(cVar, str);
        } else {
            a(18);
            throw null;
        }
    }

    @NotNull
    public static ClassDescriptor createErrorClass(@NotNull String str) {
        if (str != null) {
            return new c(Name.special("<ERROR CLASS: " + str + ">"));
        }
        a(1);
        throw null;
    }

    @NotNull
    public static MemberScope createErrorScope(@NotNull String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        a(2);
        throw null;
    }

    @NotNull
    public static SimpleType createErrorType(@NotNull String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        a(7);
        throw null;
    }

    @NotNull
    public static TypeConstructor createErrorTypeConstructor(@NotNull String str) {
        if (str != null) {
            return b(a2.b.a.a.a.e3("[ERROR : ", str, "]"), b);
        }
        a(15);
        throw null;
    }

    @NotNull
    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(@NotNull String str) {
        if (str != null) {
            return b(str, b);
        }
        a(16);
        throw null;
    }

    @NotNull
    public static SimpleType createErrorTypeWithArguments(@NotNull String str, @NotNull List<TypeProjection> list) {
        if (str == null) {
            a(11);
            throw null;
        } else if (list != null) {
            return new ErrorType(createErrorTypeConstructor(str), createErrorScope(str), list, false);
        } else {
            a(12);
            throw null;
        }
    }

    @NotNull
    public static SimpleType createErrorTypeWithCustomConstructor(@NotNull String str, @NotNull TypeConstructor typeConstructor) {
        if (str == null) {
            a(9);
            throw null;
        } else if (typeConstructor != null) {
            return new ErrorType(typeConstructor, createErrorScope(str));
        } else {
            a(10);
            throw null;
        }
    }

    @NotNull
    public static SimpleType createErrorTypeWithCustomDebugName(@NotNull String str) {
        if (str != null) {
            return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
        }
        a(8);
        throw null;
    }

    @NotNull
    public static ModuleDescriptor getErrorModule() {
        return a;
    }

    public static boolean isError(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        if ((declarationDescriptor instanceof c) || (declarationDescriptor.getContainingDeclaration() instanceof c) || declarationDescriptor == a) {
            return true;
        }
        return false;
    }

    public static boolean isUninferredParameter(@Nullable KotlinType kotlinType) {
        return kotlinType != null && (kotlinType.getConstructor() instanceof UninferredParameterTypeConstructor);
    }

    @NotNull
    public static MemberScope createErrorScope(@NotNull String str, boolean z) {
        if (str == null) {
            a(3);
            throw null;
        } else if (z) {
            return new d(str, null);
        } else {
            return new ErrorScope(str, null);
        }
    }
}
