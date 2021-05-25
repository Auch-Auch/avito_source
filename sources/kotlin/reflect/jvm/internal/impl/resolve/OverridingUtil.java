package kotlin.reflect.jvm.internal.impl.resolve;

import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.w.f.a.m.g.e;
public class OverridingUtil {
    public static final OverridingUtil DEFAULT;
    public static final List<ExternalOverridabilityCondition> c = CollectionsKt___CollectionsKt.toList(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
    public static final KotlinTypeChecker.TypeConstructorEquality d;
    public final KotlinTypeRefiner a;
    public final KotlinTypeChecker.TypeConstructorEquality b;

    public static class OverrideCompatibilityInfo {
        public static final OverrideCompatibilityInfo b = new OverrideCompatibilityInfo(Result.OVERRIDABLE, SberbankOnlineKt.RESULT_SUCCESS);
        public final Result a;

        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                a(3);
                throw null;
            } else if (str != null) {
                this.a = result;
            } else {
                a(4);
                throw null;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0038  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0045  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto L_0x000f
                if (r10 == r2) goto L_0x000f
                if (r10 == r1) goto L_0x000f
                if (r10 == r0) goto L_0x000f
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L_0x0011
            L_0x000f:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L_0x0011:
                if (r10 == r3) goto L_0x001b
                if (r10 == r2) goto L_0x001b
                if (r10 == r1) goto L_0x001b
                if (r10 == r0) goto L_0x001b
                r5 = 2
                goto L_0x001c
            L_0x001b:
                r5 = 3
            L_0x001c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L_0x0031
                if (r10 == r2) goto L_0x0031
                if (r10 == r1) goto L_0x002e
                if (r10 == r0) goto L_0x0031
                r5[r8] = r7
                goto L_0x0035
            L_0x002e:
                r5[r8] = r6
                goto L_0x0035
            L_0x0031:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L_0x0035:
                switch(r10) {
                    case 1: goto L_0x0045;
                    case 2: goto L_0x0045;
                    case 3: goto L_0x0045;
                    case 4: goto L_0x0045;
                    case 5: goto L_0x0040;
                    case 6: goto L_0x003b;
                    default: goto L_0x0038;
                }
            L_0x0038:
                r5[r3] = r6
                goto L_0x0047
            L_0x003b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L_0x0047
            L_0x0040:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L_0x0047
            L_0x0045:
                r5[r3] = r7
            L_0x0047:
                if (r10 == r3) goto L_0x005a
                if (r10 == r2) goto L_0x0055
                if (r10 == r1) goto L_0x0050
                if (r10 == r0) goto L_0x0050
                goto L_0x005e
            L_0x0050:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L_0x005e
            L_0x0055:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L_0x005e
            L_0x005a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L_0x005e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L_0x0070
                if (r10 == r2) goto L_0x0070
                if (r10 == r1) goto L_0x0070
                if (r10 == r0) goto L_0x0070
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L_0x0075
            L_0x0070:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L_0x0075:
                throw r10
                switch-data {1->0x0045, 2->0x0045, 3->0x0045, 4->0x0045, 5->0x0040, 6->0x003b, }
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        @NotNull
        public static OverrideCompatibilityInfo conflict(@NotNull String str) {
            if (str != null) {
                return new OverrideCompatibilityInfo(Result.CONFLICT, str);
            }
            a(2);
            throw null;
        }

        @NotNull
        public static OverrideCompatibilityInfo incompatible(@NotNull String str) {
            if (str != null) {
                return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
            }
            a(1);
            throw null;
        }

        @NotNull
        public static OverrideCompatibilityInfo success() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = b;
            if (overrideCompatibilityInfo != null) {
                return overrideCompatibilityInfo;
            }
            a(0);
            throw null;
        }

        @NotNull
        public Result getResult() {
            Result result = this.a;
            if (result != null) {
                return result;
            }
            a(5);
            throw null;
        }
    }

    public static class a implements KotlinTypeChecker.TypeConstructorEquality {
        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = AuthSource.SEND_ABUSE;
            } else {
                objArr[0] = AuthSource.BOOKING_ORDER;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
        public boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                a(0);
                throw null;
            } else if (typeConstructor2 != null) {
                return typeConstructor.equals(typeConstructor2);
            } else {
                a(1);
                throw null;
            }
        }
    }

    public static class b implements Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function2
        public Pair<CallableDescriptor, CallableDescriptor> invoke(Object obj, Object obj2) {
            return new Pair<>((CallableDescriptor) obj, (CallableDescriptor) obj2);
        }
    }

    public static class c implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    public class d extends ClassicTypeCheckerContext {
        @Nullable
        public final Map<TypeConstructor, TypeConstructor> i;

        public d(@Nullable Map<TypeConstructor, TypeConstructor> map) {
            super(true, true, true, OverridingUtil.this.a);
            this.i = map;
        }

        public static /* synthetic */ void a(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1 || i2 == 3) {
                objArr[0] = AuthSource.BOOKING_ORDER;
            } else {
                objArr[0] = AuthSource.SEND_ABUSE;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverridingUtilTypeCheckerContext";
            if (i2 == 2 || i2 == 3) {
                objArr[2] = "areEqualTypeConstructorsByAxioms";
            } else {
                objArr[2] = "areEqualTypeConstructors";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
            if (r0.equals(r6) != false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
            if (r3.equals(r5) != false) goto L_0x003f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean areEqualTypeConstructors(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.TypeConstructor r6) {
            /*
                r4 = this;
                r0 = 0
                r1 = 0
                if (r5 == 0) goto L_0x0055
                r2 = 1
                if (r6 == 0) goto L_0x0051
                boolean r3 = super.areEqualTypeConstructors(r5, r6)
                if (r3 != 0) goto L_0x004f
                if (r5 == 0) goto L_0x004a
                if (r6 == 0) goto L_0x0045
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r0 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.this
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker$TypeConstructorEquality r0 = r0.b
                boolean r0 = r0.equals(r5, r6)
                if (r0 == 0) goto L_0x001c
                goto L_0x003f
            L_0x001c:
                java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor> r0 = r4.i
                if (r0 != 0) goto L_0x0021
                goto L_0x0041
            L_0x0021:
                java.lang.Object r0 = r0.get(r5)
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r0 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r0
                java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor> r3 = r4.i
                java.lang.Object r3 = r3.get(r6)
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) r3
                if (r0 == 0) goto L_0x0037
                boolean r6 = r0.equals(r6)
                if (r6 != 0) goto L_0x003f
            L_0x0037:
                if (r3 == 0) goto L_0x0041
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L_0x0041
            L_0x003f:
                r5 = 1
                goto L_0x0042
            L_0x0041:
                r5 = 0
            L_0x0042:
                if (r5 == 0) goto L_0x0050
                goto L_0x004f
            L_0x0045:
                r5 = 3
                a(r5)
                throw r0
            L_0x004a:
                r5 = 2
                a(r5)
                throw r0
            L_0x004f:
                r1 = 1
            L_0x0050:
                return r1
            L_0x0051:
                a(r2)
                throw r0
            L_0x0055:
                a(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.d.areEqualTypeConstructors(kotlin.reflect.jvm.internal.impl.types.TypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):boolean");
        }
    }

    static {
        a aVar = new a();
        d = aVar;
        DEFAULT = new OverridingUtil(aVar, KotlinTypeRefiner.Default.INSTANCE);
    }

    public OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, @NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeConstructorEquality == null) {
            a(4);
            throw null;
        } else if (kotlinTypeRefiner != null) {
            this.b = typeConstructorEquality;
            this.a = kotlinTypeRefiner;
        } else {
            a(5);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01de  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0249  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r22) {
        /*
        // Method dump skipped, instructions count: 1282
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    public static void c(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
            throw null;
        } else if (set == null) {
            a(16);
            throw null;
        } else if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
                c(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    @NotNull
    public static OverridingUtil create(@NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (kotlinTypeRefiner == null) {
            a(2);
            throw null;
        } else if (typeConstructorEquality != null) {
            return new OverridingUtil(typeConstructorEquality, kotlinTypeRefiner);
        } else {
            a(3);
            throw null;
        }
    }

    @NotNull
    public static OverridingUtil createWithTypeRefiner(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner != null) {
            return new OverridingUtil(d, kotlinTypeRefiner);
        }
        a(1);
        throw null;
    }

    public static List<KotlinType> d(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        return arrayList;
    }

    public static void e(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull OverridingStrategy overridingStrategy) {
        Modality modality;
        Modality modality2;
        if (collection == null) {
            a(83);
            throw null;
        } else if (classDescriptor == null) {
            a(84);
            throw null;
        } else if (overridingStrategy == null) {
            a(85);
            throw null;
        } else if (classDescriptor == null) {
            a(94);
            throw null;
        } else if (collection != null) {
            List filter = CollectionsKt___CollectionsKt.filter(collection, new t6.w.f.a.m.g.c(classDescriptor));
            if (filter != null) {
                boolean isEmpty = filter.isEmpty();
                List list = isEmpty ? collection : filter;
                Iterator<? extends CallableMemberDescriptor> it = list.iterator();
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    if (it.hasNext()) {
                        CallableMemberDescriptor next = it.next();
                        int ordinal = next.getModality().ordinal();
                        if (ordinal == 0) {
                            modality2 = Modality.FINAL;
                            if (modality2 == null) {
                                a(88);
                                throw null;
                            }
                        } else if (ordinal == 1) {
                            throw new IllegalStateException("Member cannot have SEALED modality: " + next);
                        } else if (ordinal == 2) {
                            z2 = true;
                        } else if (ordinal == 3) {
                            z3 = true;
                        }
                    } else {
                        if (!(!classDescriptor.isExpect() || classDescriptor.getModality() == Modality.ABSTRACT || classDescriptor.getModality() == Modality.SEALED)) {
                            z = true;
                        }
                        if (z2 && !z3) {
                            modality2 = Modality.OPEN;
                            if (modality2 == null) {
                                a(89);
                                throw null;
                            }
                        } else if (z2 || !z3) {
                            HashSet hashSet = new HashSet();
                            for (CallableMemberDescriptor callableMemberDescriptor : list) {
                                hashSet.addAll(getOverriddenDeclarations(callableMemberDescriptor));
                            }
                            Set<CallableMemberDescriptor> filterOutOverridden = filterOutOverridden(hashSet);
                            Modality modality3 = classDescriptor.getModality();
                            if (filterOutOverridden == null) {
                                a(91);
                                throw null;
                            } else if (modality3 != null) {
                                Modality modality4 = Modality.ABSTRACT;
                                for (CallableMemberDescriptor callableMemberDescriptor2 : filterOutOverridden) {
                                    Modality modality5 = (!z || callableMemberDescriptor2.getModality() != Modality.ABSTRACT) ? callableMemberDescriptor2.getModality() : modality3;
                                    if (modality5.compareTo(modality4) < 0) {
                                        modality4 = modality5;
                                    }
                                }
                                if (modality4 != null) {
                                    modality = modality4;
                                } else {
                                    a(93);
                                    throw null;
                                }
                            } else {
                                a(92);
                                throw null;
                            }
                        } else {
                            modality2 = z ? classDescriptor.getModality() : Modality.ABSTRACT;
                            if (modality2 == null) {
                                a(90);
                                throw null;
                            }
                        }
                    }
                }
                modality = modality2;
                CallableMemberDescriptor copy = ((CallableMemberDescriptor) selectMostSpecificMember(list, new c())).copy(classDescriptor, modality, isEmpty ? DescriptorVisibilities.INVISIBLE_FAKE : DescriptorVisibilities.INHERITED, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
                overridingStrategy.setOverriddenDescriptors(copy, list);
                overridingStrategy.addFakeOverride(copy);
                return;
            }
            a(96);
            throw null;
        } else {
            a(95);
            throw null;
        }
    }

    @NotNull
    public static <H> Collection<H> extractMembersOverridableInBothWays(@NotNull H h, @NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1, @NotNull Function1<H, Unit> function12) {
        if (h == null) {
            a(97);
            throw null;
        } else if (collection == null) {
            a(98);
            throw null;
        } else if (function1 == null) {
            a(99);
            throw null;
        } else if (function12 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(h);
            CallableDescriptor invoke = function1.invoke(h);
            Iterator<H> it = collection.iterator();
            while (it.hasNext()) {
                H next = it.next();
                CallableDescriptor invoke2 = function1.invoke(next);
                if (h == next) {
                    it.remove();
                } else {
                    OverrideCompatibilityInfo.Result bothWaysOverridability = getBothWaysOverridability(invoke, invoke2);
                    if (bothWaysOverridability == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                        arrayList.add(next);
                        it.remove();
                    } else if (bothWaysOverridability == OverrideCompatibilityInfo.Result.CONFLICT) {
                        function12.invoke(next);
                        it.remove();
                    }
                }
            }
            return arrayList;
        } else {
            a(100);
            throw null;
        }
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> filterOutOverridden(@NotNull Set<D> set) {
        if (set != null) {
            return filterOverrides(set, !set.isEmpty() && DescriptorUtilsKt.isTypeRefinementEnabled(DescriptorUtilsKt.getModule(set.iterator().next())), null, new b());
        }
        a(6);
        throw null;
    }

    @NotNull
    public static <D> Set<D> filterOverrides(@NotNull Set<D> set, boolean z, @Nullable Function0<?> function0, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            a(7);
            throw null;
        } else if (function2 == null) {
            a(8);
            throw null;
        } else if (set.size() <= 1) {
            return set;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (D d2 : set) {
                if (function0 != null) {
                    function0.invoke();
                }
                Iterator it = linkedHashSet.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        linkedHashSet.add(d2);
                        break;
                    }
                    Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(d2, (Object) it.next());
                    CallableDescriptor component1 = invoke.component1();
                    CallableDescriptor component2 = invoke.component2();
                    if (overrides(component1, component2, z, true)) {
                        it.remove();
                    } else if (overrides(component2, component1, z, true)) {
                        break;
                    }
                }
            }
            return linkedHashSet;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility findMaxVisibility(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r5) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0058
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x000c
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r5 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.DEFAULT_VISIBILITY
            return r5
        L_0x000c:
            java.util.Iterator r1 = r5.iterator()
        L_0x0010:
            r2 = r0
        L_0x0011:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = r3.getVisibility()
            if (r2 != 0) goto L_0x0025
        L_0x0023:
            r2 = r3
            goto L_0x0011
        L_0x0025:
            java.lang.Integer r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(r3, r2)
            if (r4 != 0) goto L_0x002c
            goto L_0x0010
        L_0x002c:
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x0011
            goto L_0x0023
        L_0x0033:
            if (r2 != 0) goto L_0x0036
            return r0
        L_0x0036:
            java.util.Iterator r5 = r5.iterator()
        L_0x003a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0057
            java.lang.Object r1 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r1
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = r1.getVisibility()
            java.lang.Integer r1 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(r2, r1)
            if (r1 == 0) goto L_0x0056
            int r1 = r1.intValue()
            if (r1 >= 0) goto L_0x003a
        L_0x0056:
            return r0
        L_0x0057:
            return r2
        L_0x0058:
            r5 = 107(0x6b, float:1.5E-43)
            a(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.findMaxVisibility(java.util.Collection):kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility");
    }

    public static boolean g(@NotNull CallableDescriptor callableDescriptor, @NotNull KotlinType kotlinType, @NotNull CallableDescriptor callableDescriptor2, @NotNull KotlinType kotlinType2, @NotNull Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> pair) {
        if (kotlinType == null) {
            a(72);
            throw null;
        } else if (kotlinType2 != null) {
            return pair.getFirst().isSubtypeOf(pair.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
        } else {
            a(74);
            throw null;
        }
    }

    @Nullable
    public static OverrideCompatibilityInfo getBasicOverridabilityProblem(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        boolean z;
        OverrideCompatibilityInfo overrideCompatibilityInfo;
        if (callableDescriptor == null) {
            a(38);
            throw null;
        } else if (callableDescriptor2 != null) {
            boolean z2 = callableDescriptor instanceof FunctionDescriptor;
            if ((z2 && !(callableDescriptor2 instanceof FunctionDescriptor)) || (((z = callableDescriptor instanceof PropertyDescriptor)) && !(callableDescriptor2 instanceof PropertyDescriptor))) {
                return OverrideCompatibilityInfo.incompatible("Member kind mismatch");
            }
            if (!z2 && !z) {
                throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
            } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
                return OverrideCompatibilityInfo.incompatible("Name mismatch");
            } else {
                boolean z3 = false;
                boolean z4 = callableDescriptor.getExtensionReceiverParameter() == null;
                if (callableDescriptor2.getExtensionReceiverParameter() == null) {
                    z3 = true;
                }
                if (z4 != z3) {
                    overrideCompatibilityInfo = OverrideCompatibilityInfo.incompatible("Receiver presence mismatch");
                } else {
                    overrideCompatibilityInfo = callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size() ? OverrideCompatibilityInfo.incompatible("Value parameter number mismatch") : null;
                }
                if (overrideCompatibilityInfo != null) {
                    return overrideCompatibilityInfo;
                }
                return null;
            }
        } else {
            a(39);
            throw null;
        }
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result getBothWaysOverridability(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = DEFAULT;
        OverrideCompatibilityInfo.Result result = overridingUtil.isOverridableBy(callableDescriptor2, callableDescriptor, null).getResult();
        OverrideCompatibilityInfo.Result result2 = overridingUtil.isOverridableBy(callableDescriptor, callableDescriptor2, null).getResult();
        OverrideCompatibilityInfo.Result result3 = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (result == result3 && result2 == result3) {
            return result3;
        }
        OverrideCompatibilityInfo.Result result4 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (result == result4 || result2 == result4) ? result4 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> getOverriddenDeclarations(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            c(callableMemberDescriptor, linkedHashSet);
            return linkedHashSet;
        }
        a(13);
        throw null;
    }

    public static boolean h(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        Integer compare = DescriptorVisibilities.compare(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return compare == null || compare.intValue() >= 0;
    }

    public static boolean isMoreSpecific(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(65);
            throw null;
        } else if (callableDescriptor2 != null) {
            KotlinType returnType = callableDescriptor.getReturnType();
            KotlinType returnType2 = callableDescriptor2.getReturnType();
            if (!h(callableDescriptor, callableDescriptor2)) {
                return false;
            }
            Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> f = DEFAULT.f(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
            if (callableDescriptor instanceof FunctionDescriptor) {
                return g(callableDescriptor, returnType, callableDescriptor2, returnType2, f);
            }
            if (callableDescriptor instanceof PropertyDescriptor) {
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
                PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
                PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                PropertySetterDescriptor setter2 = propertyDescriptor2.getSetter();
                if (!((setter == null || setter2 == null) ? true : h(setter, setter2))) {
                    return false;
                }
                if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                    return f.getFirst().equalTypes(f.getSecond(), returnType.unwrap(), returnType2.unwrap());
                }
                if ((propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && g(callableDescriptor, returnType, callableDescriptor2, returnType2, f)) {
                    return true;
                }
                return false;
            }
            StringBuilder L = a2.b.a.a.a.L("Unexpected callable: ");
            L.append(callableDescriptor.getClass());
            throw new IllegalArgumentException(L.toString());
        } else {
            a(66);
            throw null;
        }
    }

    public static boolean isVisibleForOverride(@NotNull MemberDescriptor memberDescriptor, @NotNull MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            a(55);
            throw null;
        } else if (memberDescriptor2 != null) {
            return !DescriptorVisibilities.isPrivate(memberDescriptor2.getVisibility()) && DescriptorVisibilities.isVisibleIgnoringReceiver(memberDescriptor2, memberDescriptor);
        } else {
            a(56);
            throw null;
        }
    }

    public static <D extends CallableDescriptor> boolean overrides(@NotNull D d2, @NotNull D d3, boolean z, boolean z2) {
        if (d2 == null) {
            a(11);
            throw null;
        } else if (d3 == null) {
            a(12);
            throw null;
        } else if (!d2.equals(d3) && DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(d2.getOriginal(), d3.getOriginal(), z, z2)) {
            return true;
        } else {
            CallableDescriptor original = d3.getOriginal();
            for (CallableDescriptor callableDescriptor : DescriptorUtils.getAllOverriddenDescriptors(d2)) {
                if (DescriptorEquivalenceForOverrides.INSTANCE.areEquivalent(original, callableDescriptor, z, z2)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void resolveUnknownVisibilityForMember(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.Unit> r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x00b9
            java.util.Collection r1 = r6.getOverriddenDescriptors()
            java.util.Iterator r1 = r1.iterator()
        L_0x000b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0023
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = r2.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED
            if (r3 != r4) goto L_0x000b
            resolveUnknownVisibilityForMember(r2, r7)
            goto L_0x000b
        L_0x0023:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = r6.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INHERITED
            if (r1 == r2) goto L_0x002c
            return
        L_0x002c:
            java.util.Collection r1 = r6.getOverriddenDescriptors()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = findMaxVisibility(r1)
            if (r2 != 0) goto L_0x0038
        L_0x0036:
            r2 = r0
            goto L_0x0067
        L_0x0038:
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r3 = r6.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.FAKE_OVERRIDE
            if (r3 != r4) goto L_0x0063
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0067
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = r3.getModality()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r5 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT
            if (r4 == r5) goto L_0x0044
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r3 = r3.getVisibility()
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0044
            goto L_0x0036
        L_0x0063:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r2 = r2.normalize()
        L_0x0067:
            if (r2 != 0) goto L_0x0071
            if (r7 == 0) goto L_0x006e
            r7.invoke(r6)
        L_0x006e:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC
            goto L_0x0072
        L_0x0071:
            r1 = r2
        L_0x0072:
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
            if (r3 == 0) goto L_0x009b
            r3 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl r3 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl) r3
            r3.setVisibility(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r6
            java.util.List r6 = r6.getAccessors()
            java.util.Iterator r6 = r6.iterator()
        L_0x0086:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x00b8
            java.lang.Object r1 = r6.next()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor) r1
            if (r2 != 0) goto L_0x0096
            r3 = r0
            goto L_0x0097
        L_0x0096:
            r3 = r7
        L_0x0097:
            resolveUnknownVisibilityForMember(r1, r3)
            goto L_0x0086
        L_0x009b:
            boolean r7 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
            if (r7 == 0) goto L_0x00a5
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl r6 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl) r6
            r6.setVisibility(r1)
            goto L_0x00b8
        L_0x00a5:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl r6 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyAccessorDescriptorImpl) r6
            r6.setVisibility(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r7 = r6.getCorrespondingProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r7 = r7.getVisibility()
            if (r1 == r7) goto L_0x00b8
            r7 = 0
            r6.setDefault(r7)
        L_0x00b8:
            return
        L_0x00b9:
            r6 = 105(0x69, float:1.47E-43)
            a(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.resolveUnknownVisibilityForMember(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.jvm.functions.Function1):void");
    }

    @NotNull
    public static <H> H selectMostSpecificMember(@NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1) {
        H h;
        boolean z;
        if (collection == null) {
            a(76);
            throw null;
        } else if (function1 == null) {
            a(77);
            throw null;
        } else if (collection.size() == 1) {
            H h2 = (H) CollectionsKt___CollectionsKt.first(collection);
            if (h2 != null) {
                return h2;
            }
            a(78);
            throw null;
        } else {
            ArrayList arrayList = new ArrayList(2);
            List map = CollectionsKt___CollectionsKt.map(collection, function1);
            H h3 = (H) CollectionsKt___CollectionsKt.first(collection);
            CallableDescriptor invoke = function1.invoke(h3);
            for (H h4 : collection) {
                CallableDescriptor invoke2 = function1.invoke(h4);
                if (invoke2 == null) {
                    a(69);
                    throw null;
                } else if (map != null) {
                    Iterator it = map.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!isMoreSpecific(invoke2, (CallableDescriptor) it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        arrayList.add(h4);
                    }
                    if (isMoreSpecific(invoke2, invoke) && !isMoreSpecific(invoke, invoke2)) {
                        h3 = h4;
                    }
                } else {
                    a(70);
                    throw null;
                }
            }
            if (arrayList.isEmpty()) {
                if (h3 != null) {
                    return h3;
                }
                a(79);
                throw null;
            } else if (arrayList.size() == 1) {
                H h5 = (H) CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
                if (h5 != null) {
                    return h5;
                }
                a(80);
                throw null;
            } else {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        h = null;
                        break;
                    }
                    h = (H) it2.next();
                    if (!FlexibleTypesKt.isFlexible(function1.invoke(h).getReturnType())) {
                        break;
                    }
                }
                if (h != null) {
                    return h;
                }
                H h6 = (H) CollectionsKt___CollectionsKt.first((Iterable<? extends Object>) arrayList);
                if (h6 != null) {
                    return h6;
                }
                a(82);
                throw null;
            }
        }
    }

    public final boolean b(@NotNull KotlinType kotlinType, @NotNull KotlinType kotlinType2, @NotNull Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> pair) {
        if (kotlinType == null) {
            a(44);
            throw null;
        } else if (kotlinType2 == null) {
            a(45);
            throw null;
        } else if (pair != null) {
            if (KotlinTypeKt.isError(kotlinType) && KotlinTypeKt.isError(kotlinType2)) {
                return true;
            }
            return pair.getFirst().equalTypes(pair.getSecond(), kotlinType.unwrap(), kotlinType2.unwrap());
        } else {
            a(46);
            throw null;
        }
    }

    @NotNull
    public final Pair<NewKotlinTypeCheckerImpl, ClassicTypeCheckerContext> f(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        d dVar;
        if (list == null) {
            a(40);
            throw null;
        } else if (list2 != null) {
            NewKotlinTypeCheckerImpl newKotlinTypeCheckerImpl = new NewKotlinTypeCheckerImpl(this.a);
            if (list == null) {
                a(42);
                throw null;
            } else if (list2 != null) {
                if (list.isEmpty()) {
                    dVar = new d(null);
                } else {
                    HashMap hashMap = new HashMap();
                    for (int i = 0; i < list.size(); i++) {
                        hashMap.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
                    }
                    dVar = new d(hashMap);
                }
                return new Pair<>(newKotlinTypeCheckerImpl, dVar);
            } else {
                a(43);
                throw null;
            }
        } else {
            a(41);
            throw null;
        }
    }

    public void generateOverridesInFunctionGroup(@NotNull Name name, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull OverridingStrategy overridingStrategy) {
        boolean z;
        if (name == null) {
            a(50);
            throw null;
        } else if (collection == null) {
            a(51);
            throw null;
        } else if (collection2 == null) {
            a(52);
            throw null;
        } else if (classDescriptor == null) {
            a(53);
            throw null;
        } else if (overridingStrategy != null) {
            LinkedHashSet<CallableMemberDescriptor> linkedHashSet = new LinkedHashSet(collection);
            for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
                if (callableMemberDescriptor == null) {
                    a(57);
                    throw null;
                } else if (collection == null) {
                    a(58);
                    throw null;
                } else if (classDescriptor == null) {
                    a(59);
                    throw null;
                } else if (overridingStrategy != null) {
                    ArrayList arrayList = new ArrayList(collection.size());
                    SmartSet create = SmartSet.create();
                    for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                        OverrideCompatibilityInfo.Result result = isOverridableBy(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).getResult();
                        boolean isVisibleForOverride = isVisibleForOverride(callableMemberDescriptor, callableMemberDescriptor2);
                        int ordinal = result.ordinal();
                        if (ordinal == 0) {
                            if (isVisibleForOverride) {
                                create.add(callableMemberDescriptor2);
                            }
                            arrayList.add(callableMemberDescriptor2);
                        } else if (ordinal == 2) {
                            if (isVisibleForOverride) {
                                overridingStrategy.overrideConflict(callableMemberDescriptor2, callableMemberDescriptor);
                            }
                            arrayList.add(callableMemberDescriptor2);
                        }
                    }
                    overridingStrategy.setOverriddenDescriptors(callableMemberDescriptor, create);
                    linkedHashSet.removeAll(arrayList);
                } else {
                    a(60);
                    throw null;
                }
            }
            if (classDescriptor == null) {
                a(62);
                throw null;
            } else if (overridingStrategy != null) {
                if (linkedHashSet.size() < 2) {
                    z = true;
                } else {
                    z = CollectionsKt___CollectionsKt.all(linkedHashSet, new t6.w.f.a.m.g.b(((CallableMemberDescriptor) linkedHashSet.iterator().next()).getContainingDeclaration()));
                }
                if (z) {
                    for (CallableMemberDescriptor callableMemberDescriptor3 : linkedHashSet) {
                        e(Collections.singleton(callableMemberDescriptor3), classDescriptor, overridingStrategy);
                    }
                    return;
                }
                LinkedList linkedList = new LinkedList(linkedHashSet);
                while (!linkedList.isEmpty()) {
                    CallableMemberDescriptor findMemberWithMaxVisibility = VisibilityUtilKt.findMemberWithMaxVisibility(linkedList);
                    if (findMemberWithMaxVisibility != null) {
                        e(extractMembersOverridableInBothWays(findMemberWithMaxVisibility, linkedList, new t6.w.f.a.m.g.d(), new e(overridingStrategy, findMemberWithMaxVisibility)), classDescriptor, overridingStrategy);
                    } else {
                        a(102);
                        throw null;
                    }
                }
            } else {
                a(64);
                throw null;
            }
        } else {
            a(54);
            throw null;
        }
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            a(17);
            throw null;
        } else if (callableDescriptor2 != null) {
            OverrideCompatibilityInfo isOverridableBy = isOverridableBy(callableDescriptor, callableDescriptor2, classDescriptor, false);
            if (isOverridableBy != null) {
                return isOverridableBy;
            }
            a(19);
            throw null;
        } else {
            a(18);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x00cf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00de A[LOOP:1: B:25:0x0071->B:48:0x00de, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo isOverridableByWithoutExternalConditions(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r18, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r19, boolean r20) {
        /*
        // Method dump skipped, instructions count: 422
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.isOverridableByWithoutExternalConditions(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, boolean):kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$OverrideCompatibilityInfo");
    }

    @NotNull
    public OverrideCompatibilityInfo isOverridableBy(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            a(20);
            throw null;
        } else if (callableDescriptor2 != null) {
            OverrideCompatibilityInfo isOverridableByWithoutExternalConditions = isOverridableByWithoutExternalConditions(callableDescriptor, callableDescriptor2, z);
            boolean z2 = isOverridableByWithoutExternalConditions.getResult() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
            for (ExternalOverridabilityCondition externalOverridabilityCondition : c) {
                if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                    int ordinal = externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (ordinal == 0) {
                        z2 = true;
                    } else if (ordinal == 1) {
                        OverrideCompatibilityInfo conflict = OverrideCompatibilityInfo.conflict("External condition failed");
                        if (conflict != null) {
                            return conflict;
                        }
                        a(22);
                        throw null;
                    } else if (ordinal == 2) {
                        OverrideCompatibilityInfo incompatible = OverrideCompatibilityInfo.incompatible("External condition");
                        if (incompatible != null) {
                            return incompatible;
                        }
                        a(23);
                        throw null;
                    }
                }
            }
            if (!z2) {
                return isOverridableByWithoutExternalConditions;
            }
            for (ExternalOverridabilityCondition externalOverridabilityCondition2 : c) {
                if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                    int ordinal2 = externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal();
                    if (ordinal2 == 0) {
                        StringBuilder L = a2.b.a.a.a.L("Contract violation in ");
                        L.append(externalOverridabilityCondition2.getClass().getName());
                        L.append(" condition. It's not supposed to end with success");
                        throw new IllegalStateException(L.toString());
                    } else if (ordinal2 == 1) {
                        OverrideCompatibilityInfo conflict2 = OverrideCompatibilityInfo.conflict("External condition failed");
                        if (conflict2 != null) {
                            return conflict2;
                        }
                        a(25);
                        throw null;
                    } else if (ordinal2 == 2) {
                        OverrideCompatibilityInfo incompatible2 = OverrideCompatibilityInfo.incompatible("External condition");
                        if (incompatible2 != null) {
                            return incompatible2;
                        }
                        a(26);
                        throw null;
                    }
                }
            }
            OverrideCompatibilityInfo success = OverrideCompatibilityInfo.success();
            if (success != null) {
                return success;
            }
            a(27);
            throw null;
        } else {
            a(21);
            throw null;
        }
    }
}
