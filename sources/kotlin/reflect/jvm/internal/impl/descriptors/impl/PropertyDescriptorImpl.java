package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    public final Modality f;
    public DescriptorVisibility g;
    public Collection<? extends PropertyDescriptor> h;
    public final PropertyDescriptor i;
    public final CallableMemberDescriptor.Kind j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public ReceiverParameterDescriptor q;
    public ReceiverParameterDescriptor r;
    public List<TypeParameterDescriptor> s;
    public PropertyGetterDescriptorImpl t;
    public PropertySetterDescriptor u;
    public boolean v;
    public FieldDescriptor w;
    public FieldDescriptor x;

    public class CopyConfiguration {
        public DeclarationDescriptor a;
        public Modality b;
        public DescriptorVisibility c;
        public PropertyDescriptor d = null;
        public CallableMemberDescriptor.Kind e;
        public TypeSubstitution f;
        public boolean g;
        public ReceiverParameterDescriptor h;
        public Name i;
        public KotlinType j;

        public CopyConfiguration() {
            this.a = PropertyDescriptorImpl.this.getContainingDeclaration();
            this.b = PropertyDescriptorImpl.this.getModality();
            this.c = PropertyDescriptorImpl.this.getVisibility();
            this.e = PropertyDescriptorImpl.this.getKind();
            this.f = TypeSubstitution.EMPTY;
            this.g = true;
            this.h = PropertyDescriptorImpl.this.q;
            this.i = PropertyDescriptorImpl.this.getName();
            this.j = PropertyDescriptorImpl.this.getType();
        }

        public static /* synthetic */ void a(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3)];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY;
                    break;
                case 10:
                    objArr[0] = MessageBody.Location.KIND;
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = UrlParams.OWNER;
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) {
                throw new IllegalStateException(format);
            }
            throw new IllegalArgumentException(format);
        }

        @Nullable
        public PropertyDescriptor build() {
            return PropertyDescriptorImpl.this.doSubstitute(this);
        }

        @NotNull
        public CopyConfiguration setCopyOverrides(boolean z) {
            this.g = z;
            return this;
        }

        @NotNull
        public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind != null) {
                this.e = kind;
                return this;
            }
            a(10);
            throw null;
        }

        @NotNull
        public CopyConfiguration setModality(@NotNull Modality modality) {
            if (modality != null) {
                this.b = modality;
                return this;
            }
            a(6);
            throw null;
        }

        @NotNull
        public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.d = (PropertyDescriptor) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public CopyConfiguration setOwner(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.a = declarationDescriptor;
                return this;
            }
            a(0);
            throw null;
        }

        @NotNull
        public CopyConfiguration setSubstitution(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution != null) {
                this.f = typeSubstitution;
                return this;
            }
            a(15);
            throw null;
        }

        @NotNull
        public CopyConfiguration setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility != null) {
                this.c = descriptorVisibility;
                return this;
            }
            a(8);
            throw null;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyDescriptorImpl(@NotNull DeclarationDescriptor declarationDescriptor, @Nullable PropertyDescriptor propertyDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8) {
        super(declarationDescriptor, annotations, name, null, z, sourceElement);
        if (declarationDescriptor == null) {
            a(0);
            throw null;
        } else if (annotations == null) {
            a(1);
            throw null;
        } else if (modality == null) {
            a(2);
            throw null;
        } else if (descriptorVisibility == null) {
            a(3);
            throw null;
        } else if (name == null) {
            a(4);
            throw null;
        } else if (kind == null) {
            a(5);
            throw null;
        } else if (sourceElement != null) {
            this.h = null;
            this.f = modality;
            this.g = descriptorVisibility;
            this.i = propertyDescriptor == null ? this : propertyDescriptor;
            this.j = kind;
            this.k = z2;
            this.l = z3;
            this.m = z4;
            this.n = z5;
            this.o = z7;
            this.p = z8;
        } else {
            a(6);
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(int r11) {
        /*
        // Method dump skipped, instructions count: 488
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.a(int):void");
    }

    public static FunctionDescriptor b(@NotNull TypeSubstitutor typeSubstitutor, @NotNull PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (propertyAccessorDescriptor == null) {
            a(26);
            throw null;
        } else if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().mo426substitute(typeSubstitutor);
        } else {
            return null;
        }
    }

    @NotNull
    public static PropertyDescriptorImpl create(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Annotations annotations, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, boolean z, @NotNull Name name, @NotNull CallableMemberDescriptor.Kind kind, @NotNull SourceElement sourceElement, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8) {
        if (declarationDescriptor == null) {
            a(7);
            throw null;
        } else if (annotations == null) {
            a(8);
            throw null;
        } else if (modality == null) {
            a(9);
            throw null;
        } else if (descriptorVisibility == null) {
            a(10);
            throw null;
        } else if (name == null) {
            a(11);
            throw null;
        } else if (kind == null) {
            a(12);
            throw null;
        } else if (sourceElement != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, null, annotations, modality, descriptorVisibility, z, name, kind, sourceElement, z2, z3, z4, z5, z7, z8);
        } else {
            a(13);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d);
    }

    @NotNull
    public PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull Modality modality, @NotNull DescriptorVisibility descriptorVisibility, @Nullable PropertyDescriptor propertyDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @NotNull Name name, @NotNull SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            a(27);
            throw null;
        } else if (modality == null) {
            a(28);
            throw null;
        } else if (descriptorVisibility == null) {
            a(29);
            throw null;
        } else if (kind == null) {
            a(30);
            throw null;
        } else if (name == null) {
            a(31);
            throw null;
        } else if (sourceElement != null) {
            return new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility, isVar(), name, kind, sourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
        } else {
            a(32);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public PropertyDescriptor doSubstitute(@NotNull CopyConfiguration copyConfiguration) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        NullableLazyValue<ConstantValue<?>> nullableLazyValue;
        FieldDescriptorImpl fieldDescriptorImpl = null;
        if (copyConfiguration != null) {
            DeclarationDescriptor declarationDescriptor = copyConfiguration.a;
            Modality modality = copyConfiguration.b;
            DescriptorVisibility descriptorVisibility = copyConfiguration.c;
            PropertyDescriptor propertyDescriptor = copyConfiguration.d;
            CallableMemberDescriptor.Kind kind = copyConfiguration.e;
            Name name = copyConfiguration.i;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            if (sourceElement != null) {
                PropertyDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(declarationDescriptor, modality, descriptorVisibility, propertyDescriptor, kind, name, sourceElement);
                List<TypeParameterDescriptor> typeParameters = getTypeParameters();
                ArrayList arrayList = new ArrayList(typeParameters.size());
                TypeSubstitutor substituteTypeParameters = DescriptorSubstitutor.substituteTypeParameters(typeParameters, copyConfiguration.f, createSubstitutedCopy, arrayList);
                KotlinType kotlinType = copyConfiguration.j;
                Variance variance = Variance.OUT_VARIANCE;
                KotlinType substitute = substituteTypeParameters.substitute(kotlinType, variance);
                if (substitute == null) {
                    return null;
                }
                ReceiverParameterDescriptor receiverParameterDescriptor2 = copyConfiguration.h;
                if (receiverParameterDescriptor2 != 0) {
                    receiverParameterDescriptor = receiverParameterDescriptor2.mo426substitute(substituteTypeParameters);
                    if (receiverParameterDescriptor == null) {
                        return null;
                    }
                } else {
                    receiverParameterDescriptor = null;
                }
                ReceiverParameterDescriptor receiverParameterDescriptor3 = this.r;
                if (receiverParameterDescriptor3 != null) {
                    KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
                    if (substitute2 == null) {
                        return null;
                    }
                    receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute2, this.r.getValue()), this.r.getAnnotations());
                } else {
                    receiverParameterDescriptorImpl = null;
                }
                createSubstitutedCopy.setType(substitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptorImpl);
                PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = this.t;
                if (propertyGetterDescriptorImpl2 == null) {
                    propertyGetterDescriptorImpl = null;
                } else {
                    Annotations annotations = propertyGetterDescriptorImpl2.getAnnotations();
                    Modality modality2 = copyConfiguration.b;
                    DescriptorVisibility visibility = this.t.getVisibility();
                    if (copyConfiguration.e == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(visibility.normalize())) {
                        visibility = DescriptorVisibilities.INVISIBLE_FAKE;
                    }
                    boolean isDefault = this.t.isDefault();
                    boolean isExternal = this.t.isExternal();
                    boolean isInline = this.t.isInline();
                    CallableMemberDescriptor.Kind kind2 = copyConfiguration.e;
                    PropertyDescriptor propertyDescriptor2 = copyConfiguration.d;
                    propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(createSubstitutedCopy, annotations, modality2, visibility, isDefault, isExternal, isInline, kind2, propertyDescriptor2 == null ? null : propertyDescriptor2.getGetter(), sourceElement);
                }
                if (propertyGetterDescriptorImpl != null) {
                    KotlinType returnType = this.t.getReturnType();
                    propertyGetterDescriptorImpl.setInitialSignatureDescriptor(b(substituteTypeParameters, this.t));
                    propertyGetterDescriptorImpl.initialize(returnType != null ? substituteTypeParameters.substitute(returnType, variance) : null);
                }
                PropertySetterDescriptor propertySetterDescriptor = this.u;
                if (propertySetterDescriptor == null) {
                    propertySetterDescriptorImpl = null;
                } else {
                    Annotations annotations2 = propertySetterDescriptor.getAnnotations();
                    Modality modality3 = copyConfiguration.b;
                    DescriptorVisibility visibility2 = this.u.getVisibility();
                    if (copyConfiguration.e == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(visibility2.normalize())) {
                        visibility2 = DescriptorVisibilities.INVISIBLE_FAKE;
                    }
                    boolean isDefault2 = this.u.isDefault();
                    boolean isExternal2 = this.u.isExternal();
                    boolean isInline2 = this.u.isInline();
                    CallableMemberDescriptor.Kind kind3 = copyConfiguration.e;
                    PropertyDescriptor propertyDescriptor3 = copyConfiguration.d;
                    propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(createSubstitutedCopy, annotations2, modality3, visibility2, isDefault2, isExternal2, isInline2, kind3, propertyDescriptor3 == null ? null : propertyDescriptor3.getSetter(), sourceElement);
                }
                if (propertySetterDescriptorImpl != null) {
                    List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, this.u.getValueParameters(), substituteTypeParameters, false, false, null);
                    if (substitutedValueParameters == null) {
                        createSubstitutedCopy.setSetterProjectedOut(true);
                        substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtilsKt.getBuiltIns(copyConfiguration.a).getNothingType(), this.u.getValueParameters().get(0).getAnnotations()));
                    }
                    if (substitutedValueParameters.size() == 1) {
                        propertySetterDescriptorImpl.setInitialSignatureDescriptor(b(substituteTypeParameters, this.u));
                        propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
                    } else {
                        throw new IllegalStateException();
                    }
                }
                FieldDescriptor fieldDescriptor = this.w;
                FieldDescriptorImpl fieldDescriptorImpl2 = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), createSubstitutedCopy);
                FieldDescriptor fieldDescriptor2 = this.x;
                if (fieldDescriptor2 != null) {
                    fieldDescriptorImpl = new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), createSubstitutedCopy);
                }
                createSubstitutedCopy.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl2, fieldDescriptorImpl);
                if (copyConfiguration.g) {
                    SmartSet create = SmartSet.create();
                    for (PropertyDescriptor propertyDescriptor4 : getOverriddenDescriptors()) {
                        create.add(propertyDescriptor4.mo426substitute(substituteTypeParameters));
                    }
                    createSubstitutedCopy.setOverriddenDescriptors(create);
                }
                if (isConst() && (nullableLazyValue = this.compileTimeInitializer) != null) {
                    createSubstitutedCopy.setCompileTimeInitializer(nullableLazyValue);
                }
                return createSubstitutedCopy;
            }
            a(23);
            throw null;
        }
        a(24);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @NotNull
    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.t;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.u;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getBackingField() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public FieldDescriptor getDelegateField() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind getKind() {
        CallableMemberDescriptor.Kind kind = this.j;
        if (kind != null) {
            return kind;
        }
        a(34);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public Modality getModality() {
        Modality modality = this.f;
        if (modality != null) {
            return modality;
        }
        a(19);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.h;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection != null) {
            return collection;
        }
        a(36);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type != null) {
            return type;
        }
        a(18);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertySetterDescriptor getSetter() {
        return this.u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.s;
        if (list != null) {
            return list;
        }
        StringBuilder L = a.L("typeParameters == null for ");
        L.append(toString());
        throw new IllegalStateException(L.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @Nullable
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.g;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        a(20);
        throw null;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor propertySetterDescriptor) {
        initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, null, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isConst() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors
    public boolean isDelegated() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return this.k;
    }

    public boolean isSetterProjectedOut() {
        return this.v;
    }

    @NotNull
    public CopyConfiguration newCopyBuilder() {
        return new CopyConfiguration();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != 0) {
            this.h = collection;
        } else {
            a(35);
            throw null;
        }
    }

    public void setSetterProjectedOut(boolean z) {
        this.v = z;
    }

    public void setType(@NotNull KotlinType kotlinType, @NotNull List<? extends TypeParameterDescriptor> list, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor, @Nullable ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            a(14);
            throw null;
        } else if (list != null) {
            setOutType(kotlinType);
            this.s = new ArrayList(list);
            this.r = receiverParameterDescriptor2;
            this.q = receiverParameterDescriptor;
        } else {
            a(15);
            throw null;
        }
    }

    public void setVisibility(@NotNull DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility != null) {
            this.g = descriptorVisibility;
        } else {
            a(16);
            throw null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public PropertyDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        PropertyDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setOriginal(null).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z).build();
        if (build != null) {
            return build;
        }
        a(37);
        throw null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor
    @Nullable
    public PropertyGetterDescriptorImpl getGetter() {
        return this.t;
    }

    public void initialize(@Nullable PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor propertySetterDescriptor, @Nullable FieldDescriptor fieldDescriptor, @Nullable FieldDescriptor fieldDescriptor2) {
        this.t = propertyGetterDescriptorImpl;
        this.u = propertySetterDescriptor;
        this.w = fieldDescriptor;
        this.x = fieldDescriptor2;
    }

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    /* renamed from: substitute */
    public CallableDescriptor mo426substitute(@NotNull TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            a(22);
            throw null;
        } else if (typeSubstitutor.isEmpty()) {
            return this;
        } else {
            return newCopyBuilder().setSubstitution(typeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.i;
        PropertyDescriptor original = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original != null) {
            return original;
        }
        a(33);
        throw null;
    }
}
