package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    public final CallableMemberDescriptor.Kind A;
    @Nullable
    public FunctionDescriptor B;
    public List<TypeParameterDescriptor> e;
    public List<ValueParameterDescriptor> f;
    public KotlinType g;
    public ReceiverParameterDescriptor h;
    public ReceiverParameterDescriptor i;
    public Modality j;
    public DescriptorVisibility k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap;
    public boolean v;
    public boolean w;
    public Collection<? extends FunctionDescriptor> x;
    public volatile Function0<Collection<FunctionDescriptor>> y;
    public final FunctionDescriptor z;

    public class CopyConfiguration implements FunctionDescriptor.CopyBuilder<FunctionDescriptor> {
        public boolean a;
        public List<TypeParameterDescriptor> b;
        public Annotations c;
        public boolean copyOverrides;
        public boolean d;
        @Nullable
        public ReceiverParameterDescriptor dispatchReceiverParameter;
        public boolean dropOriginalInContainingParts;
        public Map<CallableDescriptor.UserDataKey<?>, Object> e;
        public Boolean f;
        public final /* synthetic */ FunctionDescriptorImpl g;
        public boolean justForTypeSubstitution;
        @NotNull
        public CallableMemberDescriptor.Kind kind;
        @Nullable
        public Name name;
        @Nullable
        public ReceiverParameterDescriptor newExtensionReceiverParameter;
        @NotNull
        public Modality newModality;
        @NotNull
        public DeclarationDescriptor newOwner;
        @NotNull
        public KotlinType newReturnType;
        @NotNull
        public List<ValueParameterDescriptor> newValueParameterDescriptors;
        @NotNull
        public DescriptorVisibility newVisibility;
        @Nullable
        public FunctionDescriptor original;
        public boolean preserveSourceElement;
        public boolean signatureChange;
        @NotNull
        public TypeSubstitution substitution;

        public CopyConfiguration(@NotNull FunctionDescriptorImpl functionDescriptorImpl, @NotNull TypeSubstitution typeSubstitution, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @NotNull CallableMemberDescriptor.Kind kind2, @Nullable List<ValueParameterDescriptor> list, @NotNull ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable KotlinType kotlinType, Name name2) {
            if (typeSubstitution == null) {
                a(0);
                throw null;
            } else if (declarationDescriptor == null) {
                a(1);
                throw null;
            } else if (modality == null) {
                a(2);
                throw null;
            } else if (descriptorVisibility == null) {
                a(3);
                throw null;
            } else if (kind2 == null) {
                a(4);
                throw null;
            } else if (list == null) {
                a(5);
                throw null;
            } else if (kotlinType != null) {
                this.g = functionDescriptorImpl;
                this.original = null;
                this.dispatchReceiverParameter = functionDescriptorImpl.i;
                this.copyOverrides = true;
                this.signatureChange = false;
                this.preserveSourceElement = false;
                this.dropOriginalInContainingParts = false;
                this.a = functionDescriptorImpl.isHiddenToOvercomeSignatureClash();
                this.b = null;
                this.c = null;
                this.d = functionDescriptorImpl.isHiddenForResolutionEverywhereBesideSupercalls();
                this.e = new LinkedHashMap();
                this.f = null;
                this.justForTypeSubstitution = false;
                this.substitution = typeSubstitution;
                this.newOwner = declarationDescriptor;
                this.newModality = modality;
                this.newVisibility = descriptorVisibility;
                this.kind = kind2;
                this.newValueParameterDescriptors = list;
                this.newExtensionReceiverParameter = receiverParameterDescriptor;
                this.newReturnType = kotlinType;
                this.name = name2;
            } else {
                a(6);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = MessageBody.Location.KIND;
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = UrlParams.OWNER;
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY;
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT;
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @Nullable
        public FunctionDescriptor build() {
            return this.g.doSubstitute(this);
        }

        public CopyConfiguration setHasSynthesizedParameterNames(boolean z) {
            this.f = Boolean.valueOf(z);
            return this;
        }

        @NotNull
        public CopyConfiguration setJustForTypeSubstitution(boolean z) {
            this.justForTypeSubstitution = z;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setAdditionalAnnotations(@NotNull Annotations annotations) {
            if (annotations != null) {
                this.c = annotations;
                return this;
            }
            a(32);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDispatchReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.dispatchReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setDropOriginalInContainingParts() {
            this.dropOriginalInContainingParts = true;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setExtensionReceiverParameter(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.newExtensionReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
            this.d = true;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setHiddenToOvercomeSignatureClash() {
            this.a = true;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setKind(@NotNull CallableMemberDescriptor.Kind kind2) {
            if (kind2 != null) {
                this.kind = kind2;
                return this;
            }
            a(13);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setModality(@NotNull Modality modality) {
            if (modality != null) {
                this.newModality = modality;
                return this;
            }
            a(9);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setName(@NotNull Name name2) {
            if (name2 != null) {
                this.name = name2;
                return this;
            }
            a(16);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.newOwner = declarationDescriptor;
                return this;
            }
            a(7);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setReturnType(@NotNull KotlinType kotlinType) {
            if (kotlinType != null) {
                this.newReturnType = kotlinType;
                return this;
            }
            a(22);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution != null) {
                this.substitution = typeSubstitution;
                return this;
            }
            a(34);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setTypeParameters(@NotNull List<TypeParameterDescriptor> list) {
            if (list != null) {
                this.b = list;
                return this;
            }
            a(20);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setValueParameters(@NotNull List<ValueParameterDescriptor> list) {
            if (list != null) {
                this.newValueParameterDescriptors = list;
                return this;
            }
            a(18);
            throw null;
        }

        /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration' to match base method */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder
        @NotNull
        public FunctionDescriptor.CopyBuilder<FunctionDescriptor> setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility != null) {
                this.newVisibility = descriptorVisibility;
                return this;
            }
            a(11);
            throw null;
        }
    }

    public class a implements Function0<Collection<FunctionDescriptor>> {
        public final /* synthetic */ TypeSubstitutor a;

        public a(TypeSubstitutor typeSubstitutor) {
            this.a = typeSubstitutor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Collection<FunctionDescriptor> invoke() {
            SmartList smartList = new SmartList();
            for (FunctionDescriptor functionDescriptor : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                smartList.add(functionDescriptor.mo426substitute(this.a));
            }
            return smartList;
        }
    }

    public static class b implements Function0<List<VariableDescriptor>> {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<VariableDescriptor> invoke() {
            return this.a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull Annotations annotations, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement) {
        super(declarationDescriptor, annotations, name, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        } else if (annotations == null) {
            a(1);
            throw null;
        } else if (name == null) {
            a(2);
            throw null;
        } else if (kind == null) {
            a(3);
            throw null;
        } else if (sourceElement != null) {
            this.k = DescriptorVisibilities.UNKNOWN;
            this.l = false;
            this.m = false;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            this.v = true;
            this.w = false;
            this.x = null;
            this.y = null;
            this.B = null;
            this.userDataMap = null;
            this.z = functionDescriptor == null ? this : functionDescriptor;
            this.A = kind;
        } else {
            a(4);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = MessageBody.Location.KIND;
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY;
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            a(26);
            throw null;
        } else if (typeSubstitutor != null) {
            return getSubstitutedValueParameters(functionDescriptor, list, typeSubstitutor, false, false, null);
        } else {
            a(27);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d);
    }

    @NotNull
    public abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement sourceElement);

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public FunctionDescriptor doSubstitute(@NotNull CopyConfiguration copyConfiguration) {
        SourceElement sourceElement;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        KotlinType substitute;
        FunctionDescriptor functionDescriptor;
        if (copyConfiguration != null) {
            boolean[] zArr = new boolean[1];
            Annotations composeAnnotations = copyConfiguration.c != null ? AnnotationsKt.composeAnnotations(getAnnotations(), copyConfiguration.c) : getAnnotations();
            DeclarationDescriptor declarationDescriptor = copyConfiguration.newOwner;
            FunctionDescriptor functionDescriptor2 = copyConfiguration.original;
            CallableMemberDescriptor.Kind kind = copyConfiguration.kind;
            Name name = copyConfiguration.name;
            if (copyConfiguration.preserveSourceElement) {
                if (functionDescriptor2 != null) {
                    functionDescriptor = functionDescriptor2;
                } else {
                    functionDescriptor = getOriginal();
                }
                sourceElement = functionDescriptor.getSource();
            } else {
                sourceElement = SourceElement.NO_SOURCE;
            }
            if (sourceElement != null) {
                FunctionDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(declarationDescriptor, functionDescriptor2, kind, name, composeAnnotations, sourceElement);
                List<TypeParameterDescriptor> list = copyConfiguration.b;
                if (list == null) {
                    list = getTypeParameters();
                }
                zArr[0] = zArr[0] | (!list.isEmpty());
                ArrayList arrayList = new ArrayList(list.size());
                TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(list, copyConfiguration.substitution, createSubstitutedCopy, arrayList, zArr);
                if (substituteTypeParameters == null) {
                    return null;
                }
                ReceiverParameterDescriptor receiverParameterDescriptor2 = copyConfiguration.newExtensionReceiverParameter;
                if (receiverParameterDescriptor2 != null) {
                    KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor2.getType(), Variance.IN_VARIANCE);
                    if (substitute2 == null) {
                        return null;
                    }
                    ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl2 = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute2, copyConfiguration.newExtensionReceiverParameter.getValue()), copyConfiguration.newExtensionReceiverParameter.getAnnotations());
                    zArr[0] = (substitute2 != copyConfiguration.newExtensionReceiverParameter.getType()) | zArr[0];
                    receiverParameterDescriptorImpl = receiverParameterDescriptorImpl2;
                } else {
                    receiverParameterDescriptorImpl = null;
                }
                ReceiverParameterDescriptor receiverParameterDescriptor3 = copyConfiguration.dispatchReceiverParameter;
                if (receiverParameterDescriptor3 != 0) {
                    ReceiverParameterDescriptor substitute3 = receiverParameterDescriptor3.mo426substitute(substituteTypeParameters);
                    if (substitute3 == null) {
                        return null;
                    }
                    zArr[0] = zArr[0] | (substitute3 != copyConfiguration.dispatchReceiverParameter);
                    receiverParameterDescriptor = substitute3;
                } else {
                    receiverParameterDescriptor = null;
                }
                List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(createSubstitutedCopy, copyConfiguration.newValueParameterDescriptors, substituteTypeParameters, copyConfiguration.dropOriginalInContainingParts, copyConfiguration.preserveSourceElement, zArr);
                if (substitutedValueParameters == null || (substitute = substituteTypeParameters.substitute(copyConfiguration.newReturnType, Variance.OUT_VARIANCE)) == null) {
                    return null;
                }
                zArr[0] = zArr[0] | (substitute != copyConfiguration.newReturnType);
                if (!zArr[0] && copyConfiguration.justForTypeSubstitution) {
                    return this;
                }
                createSubstitutedCopy.initialize(receiverParameterDescriptorImpl, receiverParameterDescriptor, arrayList, substitutedValueParameters, substitute, copyConfiguration.newModality, copyConfiguration.newVisibility);
                createSubstitutedCopy.setOperator(this.l);
                createSubstitutedCopy.setInfix(this.m);
                createSubstitutedCopy.setExternal(this.n);
                createSubstitutedCopy.setInline(this.o);
                createSubstitutedCopy.setTailrec(this.p);
                createSubstitutedCopy.setSuspend(this.u);
                createSubstitutedCopy.setExpect(this.q);
                createSubstitutedCopy.setActual(this.r);
                createSubstitutedCopy.setHasStableParameterNames(this.v);
                createSubstitutedCopy.s = copyConfiguration.a;
                createSubstitutedCopy.t = copyConfiguration.d;
                Boolean bool = copyConfiguration.f;
                createSubstitutedCopy.setHasSynthesizedParameterNames(bool != null ? bool.booleanValue() : this.w);
                if (!copyConfiguration.e.isEmpty() || this.userDataMap != null) {
                    Map<CallableDescriptor.UserDataKey<?>, Object> map = copyConfiguration.e;
                    Map<CallableDescriptor.UserDataKey<?>, Object> map2 = this.userDataMap;
                    if (map2 != null) {
                        for (Map.Entry<CallableDescriptor.UserDataKey<?>, Object> entry : map2.entrySet()) {
                            if (!map.containsKey(entry.getKey())) {
                                map.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    if (map.size() == 1) {
                        createSubstitutedCopy.userDataMap = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
                    } else {
                        createSubstitutedCopy.userDataMap = map;
                    }
                }
                if (copyConfiguration.signatureChange || getInitialSignatureDescriptor() != null) {
                    createSubstitutedCopy.B = (getInitialSignatureDescriptor() != null ? getInitialSignatureDescriptor() : this).mo426substitute(substituteTypeParameters);
                }
                if (copyConfiguration.copyOverrides && !getOriginal().getOverriddenDescriptors().isEmpty()) {
                    if (copyConfiguration.substitution.isEmpty()) {
                        Function0<Collection<FunctionDescriptor>> function0 = this.y;
                        if (function0 != null) {
                            createSubstitutedCopy.y = function0;
                        } else {
                            createSubstitutedCopy.setOverriddenDescriptors(getOverriddenDescriptors());
                        }
                    } else {
                        createSubstitutedCopy.y = new a(substituteTypeParameters);
                    }
                }
                return createSubstitutedCopy;
            }
            a(25);
            throw null;
        }
        a(23);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @Nullable
    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.A;
        if (kind != null) {
            return kind;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.j;
        if (modality != null) {
            return modality;
        }
        a(13);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Function0<Collection<FunctionDescriptor>> function0 = this.y;
        if (function0 != null) {
            this.x = function0.invoke();
            this.y = null;
        }
        Collection<? extends FunctionDescriptor> collection = this.x;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection != null) {
            return collection;
        }
        a(12);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public KotlinType getReturnType() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Map<CallableDescriptor.UserDataKey<?>, Object> map = this.userDataMap;
        if (map == null) {
            return null;
        }
        return (V) map.get(userDataKey);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.f;
        if (list != null) {
            return list;
        }
        a(17);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.k;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        a(14);
        throw null;
    }

    public boolean hasStableParameterNames() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public boolean hasSynthesizedParameterNames() {
        return this.w;
    }

    @NotNull
    public FunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> list, @NotNull List<ValueParameterDescriptor> list2, @Nullable KotlinType kotlinType, @Nullable Modality modality, @NotNull DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            a(5);
            throw null;
        } else if (list2 == null) {
            a(6);
            throw null;
        } else if (descriptorVisibility != null) {
            this.e = CollectionsKt___CollectionsKt.toList(list);
            this.f = CollectionsKt___CollectionsKt.toList(list2);
            this.g = kotlinType;
            this.j = modality;
            this.k = descriptorVisibility;
            this.h = receiverParameterDescriptor;
            this.i = receiverParameterDescriptor2;
            for (int i2 = 0; i2 < list.size(); i2++) {
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list.get(i2);
                if (typeParameterDescriptor.getIndex() != i2) {
                    throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i2);
                }
            }
            for (int i3 = 0; i3 < list2.size(); i3++) {
                ValueParameterDescriptor valueParameterDescriptor = list2.get(i3);
                if (valueParameterDescriptor.getIndex() != i3 + 0) {
                    throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i3);
                }
            }
            return this;
        } else {
            a(7);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isHiddenToOvercomeSignatureClash() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInfix() {
        if (this.m) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isInfix()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isOperator() {
        if (this.l) {
            return true;
        }
        for (FunctionDescriptor functionDescriptor : getOriginal().getOverriddenDescriptors()) {
            if (functionDescriptor.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isSuspend() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        if (newCopyBuilder != null) {
            return newCopyBuilder;
        }
        a(21);
        throw null;
    }

    public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> userDataKey, Object obj) {
        if (this.userDataMap == null) {
            this.userDataMap = new LinkedHashMap();
        }
        this.userDataMap.put(userDataKey, obj);
    }

    public void setActual(boolean z2) {
        this.r = z2;
    }

    public void setExpect(boolean z2) {
        this.q = z2;
    }

    public void setExternal(boolean z2) {
        this.n = z2;
    }

    public void setHasStableParameterNames(boolean z2) {
        this.v = z2;
    }

    public void setHasSynthesizedParameterNames(boolean z2) {
        this.w = z2;
    }

    public void setInfix(boolean z2) {
        this.m = z2;
    }

    public void setInline(boolean z2) {
        this.o = z2;
    }

    public void setOperator(boolean z2) {
        this.l = z2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != 0) {
            this.x = collection;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                    this.t = true;
                    return;
                }
            }
            return;
        }
        a(15);
        throw null;
    }

    public void setReturnType(@NotNull KotlinType kotlinType) {
        if (kotlinType != null) {
            this.g = kotlinType;
        } else {
            a(10);
            throw null;
        }
    }

    public void setSuspend(boolean z2) {
        this.u = z2;
    }

    public void setTailrec(boolean z2) {
        this.p = z2;
    }

    public void setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility != null) {
            this.k = descriptorVisibility;
        } else {
            a(9);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z2) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z2).build();
        if (build != null) {
            return build;
        }
        a(24);
        throw null;
    }

    @NotNull
    public CopyConfiguration newCopyBuilder(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor != null) {
            return new CopyConfiguration(this, typeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
        }
        a(22);
        throw null;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor' to match base method */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    /* renamed from: substitute */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor mo426substitute(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0023
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r2 = r1.newCopyBuilder(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = r1.getOriginal()
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r2 = r2.setOriginal(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r2 = r2.setPreserveSourceElement()
            r0 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r2 = r2.setJustForTypeSubstitution(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r2.build()
            return r2
        L_0x0023:
            r2 = 20
            a(r2)
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.mo426substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor");
    }

    @Nullable
    public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor functionDescriptor, @NotNull List<ValueParameterDescriptor> list, @NotNull TypeSubstitutor typeSubstitutor, boolean z2, boolean z3, @Nullable boolean[] zArr) {
        if (list == null) {
            a(28);
            throw null;
        } else if (typeSubstitutor != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ValueParameterDescriptor valueParameterDescriptor : list) {
                KotlinType type = valueParameterDescriptor.getType();
                Variance variance = Variance.IN_VARIANCE;
                KotlinType substitute = typeSubstitutor.substitute(type, variance);
                KotlinType varargElementType = valueParameterDescriptor.getVarargElementType();
                KotlinType substitute2 = varargElementType == null ? null : typeSubstitutor.substitute(varargElementType, variance);
                if (substitute == null) {
                    return null;
                }
                if (!((substitute == valueParameterDescriptor.getType() && varargElementType == substitute2) || zArr == null)) {
                    zArr[0] = true;
                }
                arrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(functionDescriptor, z2 ? null : valueParameterDescriptor, valueParameterDescriptor.getIndex(), valueParameterDescriptor.getAnnotations(), valueParameterDescriptor.getName(), substitute, valueParameterDescriptor.declaresDefaultValue(), valueParameterDescriptor.isCrossinline(), valueParameterDescriptor.isNoinline(), substitute2, z3 ? valueParameterDescriptor.getSource() : SourceElement.NO_SOURCE, valueParameterDescriptor instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration ? new b(((ValueParameterDescriptorImpl.WithDestructuringDeclaration) valueParameterDescriptor).getDestructuringVariables()) : null));
            }
            return arrayList;
        } else {
            a(29);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.z;
        FunctionDescriptor original = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(18);
        throw null;
    }
}
