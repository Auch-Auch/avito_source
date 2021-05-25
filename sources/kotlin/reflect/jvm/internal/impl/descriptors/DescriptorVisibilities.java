package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = new b();
    public static final DescriptorVisibility DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = new c();
    @NotNull
    public static final DescriptorVisibility INHERITED;
    @NotNull
    public static final DescriptorVisibility INTERNAL;
    @NotNull
    public static final DescriptorVisibility INVISIBLE_FAKE;
    public static final Set<DescriptorVisibility> INVISIBLE_FROM_OTHER_MODULES;
    @NotNull
    public static final DescriptorVisibility LOCAL;
    @NotNull
    public static final DescriptorVisibility PRIVATE;
    @NotNull
    public static final DescriptorVisibility PRIVATE_TO_THIS;
    @NotNull
    public static final DescriptorVisibility PROTECTED;
    @NotNull
    public static final DescriptorVisibility PUBLIC;
    @NotNull
    public static final DescriptorVisibility UNKNOWN;
    public static final Map<DescriptorVisibility, Integer> a;
    public static final ReceiverValue b = new a();
    @NotNull
    public static final ModuleVisibilityHelper c;
    @NotNull
    public static final Map<Visibility, DescriptorVisibility> d = new HashMap();

    public static class a implements ReceiverValue {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class b implements ReceiverValue {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class c implements ReceiverValue {
        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    public static class d extends DelegatedDescriptorVisibility {
        public d(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x0051 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0065 */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility */
        /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                a(1);
                throw null;
            } else if (declarationDescriptor != null) {
                if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility)) {
                    if (declarationDescriptor != null) {
                        if (DescriptorUtils.getContainingSourceFile(declarationDescriptor) != SourceFile.NO_SOURCE_FILE) {
                            return DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
                        }
                    } else {
                        a(0);
                        throw null;
                    }
                }
                if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                    ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                    if (DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && DescriptorVisibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                        return true;
                    }
                }
                while (declarationDescriptorWithVisibility != 0) {
                    declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                    if (declarationDescriptorWithVisibility instanceof ClassDescriptor) {
                        if (!DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) {
                            break;
                        }
                    }
                    if (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) {
                        break;
                    }
                }
                if (declarationDescriptorWithVisibility == 0) {
                    return false;
                }
                while (declarationDescriptor != null) {
                    if (declarationDescriptorWithVisibility == declarationDescriptor) {
                        return true;
                    }
                    if (!(declarationDescriptor instanceof PackageFragmentDescriptor)) {
                        declarationDescriptor = declarationDescriptor.getContainingDeclaration();
                    } else if (!(declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) || !((PackageFragmentDescriptor) declarationDescriptorWithVisibility).getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) || !DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility)) {
                        return false;
                    } else {
                        return true;
                    }
                }
                return false;
            } else {
                a(2);
                throw null;
            }
        }
    }

    public static class e extends DelegatedDescriptorVisibility {
        public e(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor parentOfType;
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                if (DescriptorVisibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                    if (receiverValue == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                        return true;
                    }
                    if (!(receiverValue == DescriptorVisibilities.b || (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) == null || !(receiverValue instanceof ThisClassReceiver))) {
                        return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                    }
                }
                return false;
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class f extends DelegatedDescriptorVisibility {
        public f(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
            if (kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(r0) == false) goto L_0x007c;
         */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isVisible(@org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r7, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9) {
            /*
                r6 = this;
                java.lang.Class<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class
                r1 = 0
                r2 = 0
                if (r8 == 0) goto L_0x0091
                r3 = 1
                if (r9 == 0) goto L_0x008d
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r8, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r9, r0, r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r9
                if (r9 != 0) goto L_0x0018
                return r2
            L_0x0018:
                if (r4 == 0) goto L_0x002f
                boolean r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r4)
                if (r5 == 0) goto L_0x002f
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r4, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                if (r4 == 0) goto L_0x002f
                boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(r9, r4)
                if (r4 == 0) goto L_0x002f
                return r3
            L_0x002f:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r8)
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r4, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
                if (r0 != 0) goto L_0x003c
                return r2
            L_0x003c:
                boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(r9, r0)
                if (r0 == 0) goto L_0x0084
                if (r4 == 0) goto L_0x007f
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.FALSE_IF_PROTECTED
                if (r7 != r0) goto L_0x0049
                goto L_0x007c
            L_0x0049:
                boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
                if (r0 != 0) goto L_0x004e
                goto L_0x007b
            L_0x004e:
                boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
                if (r0 == 0) goto L_0x0053
                goto L_0x007b
            L_0x0053:
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER
                if (r7 != r0) goto L_0x0058
                goto L_0x007b
            L_0x0058:
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.b
                if (r7 == r0) goto L_0x007c
                if (r7 != 0) goto L_0x005f
                goto L_0x007c
            L_0x005f:
                boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue
                if (r0 == 0) goto L_0x006b
                r0 = r7
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue r0 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue) r0
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getThisType()
                goto L_0x006f
            L_0x006b:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r7.getType()
            L_0x006f:
                boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubtypeOfClass(r0, r9)
                if (r1 != 0) goto L_0x007b
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt.isDynamic(r0)
                if (r0 == 0) goto L_0x007c
            L_0x007b:
                r2 = 1
            L_0x007c:
                if (r2 == 0) goto L_0x0084
                return r3
            L_0x007f:
                r7 = 2
                a(r7)
                throw r1
            L_0x0084:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = r9.getContainingDeclaration()
                boolean r7 = r6.isVisible(r7, r8, r9)
                return r7
            L_0x008d:
                a(r3)
                throw r1
            L_0x0091:
                a(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.f.isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):boolean");
        }
    }

    public static class g extends DelegatedDescriptorVisibility {
        public g(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                if (!DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                    return false;
                }
                return DescriptorVisibilities.c.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class h extends DelegatedDescriptorVisibility {
        public h(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return true;
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class i extends DelegatedDescriptorVisibility {
        public i(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor == null) {
                a(1);
                throw null;
            } else {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        }
    }

    public static class j extends DelegatedDescriptorVisibility {
        public j(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor == null) {
                a(1);
                throw null;
            } else {
                throw new IllegalStateException("Visibility is unknown yet");
            }
        }
    }

    public static class k extends DelegatedDescriptorVisibility {
        public k(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class l extends DelegatedDescriptorVisibility {
        public l(Visibility visibility) {
            super(visibility);
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility
        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                a(1);
                throw null;
            }
        }
    }

    static {
        d dVar = new d(Visibilities.Private.INSTANCE);
        PRIVATE = dVar;
        e eVar = new e(Visibilities.PrivateToThis.INSTANCE);
        PRIVATE_TO_THIS = eVar;
        f fVar = new f(Visibilities.Protected.INSTANCE);
        PROTECTED = fVar;
        g gVar = new g(Visibilities.Internal.INSTANCE);
        INTERNAL = gVar;
        h hVar = new h(Visibilities.Public.INSTANCE);
        PUBLIC = hVar;
        i iVar = new i(Visibilities.Local.INSTANCE);
        LOCAL = iVar;
        j jVar = new j(Visibilities.Inherited.INSTANCE);
        INHERITED = jVar;
        k kVar = new k(Visibilities.InvisibleFake.INSTANCE);
        INVISIBLE_FAKE = kVar;
        l lVar = new l(Visibilities.Unknown.INSTANCE);
        UNKNOWN = lVar;
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(y.setOf((Object[]) new DescriptorVisibility[]{dVar, eVar, gVar, iVar}));
        HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(4);
        newHashMapWithExpectedSize.put(eVar, 0);
        newHashMapWithExpectedSize.put(dVar, 0);
        newHashMapWithExpectedSize.put(gVar, 1);
        newHashMapWithExpectedSize.put(fVar, 1);
        newHashMapWithExpectedSize.put(hVar, 2);
        a = Collections.unmodifiableMap(newHashMapWithExpectedSize);
        DEFAULT_VISIBILITY = hVar;
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        c = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.EMPTY.INSTANCE;
        b(dVar);
        b(eVar);
        b(fVar);
        b(gVar);
        b(hVar);
        b(iVar);
        b(jVar);
        b(kVar);
        b(lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L_0x0007
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L_0x0009
        L_0x0007:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L_0x0009:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto L_0x000f
            r4 = 3
            goto L_0x0010
        L_0x000f:
            r4 = 2
        L_0x0010:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L_0x003a
            if (r8 == r2) goto L_0x003a
            r2 = 5
            if (r8 == r2) goto L_0x003a
            r2 = 7
            if (r8 == r2) goto L_0x003a
            switch(r8) {
                case 9: goto L_0x003a;
                case 10: goto L_0x0035;
                case 11: goto L_0x0030;
                case 12: goto L_0x0035;
                case 13: goto L_0x0030;
                case 14: goto L_0x002b;
                case 15: goto L_0x002b;
                case 16: goto L_0x0028;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L_0x003e
        L_0x0028:
            r4[r7] = r5
            goto L_0x003e
        L_0x002b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L_0x003e
        L_0x0030:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L_0x003e
        L_0x0035:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L_0x003e
        L_0x003a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L_0x003e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L_0x0045
            r4[r6] = r5
            goto L_0x0047
        L_0x0045:
            r4[r6] = r2
        L_0x0047:
            switch(r8) {
                case 2: goto L_0x0070;
                case 3: goto L_0x0070;
                case 4: goto L_0x006b;
                case 5: goto L_0x006b;
                case 6: goto L_0x0066;
                case 7: goto L_0x0066;
                case 8: goto L_0x0061;
                case 9: goto L_0x0061;
                case 10: goto L_0x005c;
                case 11: goto L_0x005c;
                case 12: goto L_0x0057;
                case 13: goto L_0x0057;
                case 14: goto L_0x0052;
                case 15: goto L_0x004f;
                case 16: goto L_0x0074;
                default: goto L_0x004a;
            }
        L_0x004a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L_0x0074
        L_0x004f:
            r4[r3] = r2
            goto L_0x0074
        L_0x0052:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L_0x0074
        L_0x0057:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L_0x0074
        L_0x005c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L_0x0074
        L_0x0061:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L_0x0074
        L_0x0066:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L_0x0074
        L_0x006b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L_0x0074
        L_0x0070:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L_0x0074:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L_0x0080
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L_0x0085
        L_0x0080:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L_0x0085:
            throw r8
            switch-data {9->0x003a, 10->0x0035, 11->0x0030, 12->0x0035, 13->0x0030, 14->0x002b, 15->0x002b, 16->0x0028, }
            switch-data {2->0x0070, 3->0x0070, 4->0x006b, 5->0x006b, 6->0x0066, 7->0x0066, 8->0x0061, 9->0x0061, 10->0x005c, 11->0x005c, 12->0x0057, 13->0x0057, 14->0x0052, 15->0x004f, 16->0x0074, }
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.a(int):void");
    }

    public static void b(DescriptorVisibility descriptorVisibility) {
        d.put(descriptorVisibility.getDelegate(), descriptorVisibility);
    }

    @Nullable
    public static Integer compare(@NotNull DescriptorVisibility descriptorVisibility, @NotNull DescriptorVisibility descriptorVisibility2) {
        if (descriptorVisibility == null) {
            a(12);
            throw null;
        } else if (descriptorVisibility2 != null) {
            Integer compareTo = descriptorVisibility.compareTo(descriptorVisibility2);
            if (compareTo != null) {
                return compareTo;
            }
            Integer compareTo2 = descriptorVisibility2.compareTo(descriptorVisibility);
            if (compareTo2 != null) {
                return Integer.valueOf(-compareTo2.intValue());
            }
            return null;
        } else {
            a(13);
            throw null;
        }
    }

    @Nullable
    public static DeclarationDescriptorWithVisibility findInvisibleMember(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility findInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            a(8);
            throw null;
        } else if (declarationDescriptor != null) {
            DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal();
            while (declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL) {
                if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                    return declarationDescriptorWithVisibility2;
                }
                declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class);
            }
            if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (findInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
                return null;
            }
            return findInvisibleMember;
        } else {
            a(9);
            throw null;
        }
    }

    public static boolean inSameFile(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(6);
            throw null;
        } else if (declarationDescriptor2 != null) {
            SourceFile containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
            if (containingSourceFile != SourceFile.NO_SOURCE_FILE) {
                return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
            }
            return false;
        } else {
            a(7);
            throw null;
        }
    }

    public static boolean isPrivate(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility != null) {
            return descriptorVisibility == PRIVATE || descriptorVisibility == PRIVATE_TO_THIS;
        }
        a(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(2);
            throw null;
        } else if (declarationDescriptor != null) {
            return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null;
        } else {
            a(3);
            throw null;
        }
    }

    @NotNull
    public static DescriptorVisibility toDescriptorVisibility(@NotNull Visibility visibility) {
        if (visibility != null) {
            DescriptorVisibility descriptorVisibility = d.get(visibility);
            if (descriptorVisibility != null) {
                return descriptorVisibility;
            }
            throw new IllegalArgumentException("Inapplicable visibility: " + visibility);
        }
        a(15);
        throw null;
    }
}
