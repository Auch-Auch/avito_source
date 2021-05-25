package kotlin.reflect.jvm.internal;

import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.SessionContract;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.JvmPropertySignature;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.DescriptorsJvmAbiUtil;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\b \u0018\u0000 L*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004MLNOB\u0019\b\u0016\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010F\u001a\u00020\u001a¢\u0006\u0004\bG\u0010HB5\b\u0002\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010C\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020\u0013\u0012\b\u0010I\u001a\u0004\u0018\u00010\u001a\u0012\b\u00100\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bG\u0010JB+\b\u0016\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010C\u001a\u00020\u0013\u0012\u0006\u0010*\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bG\u0010KJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0015\u0010 \u001a\u0004\u0018\u00010\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010&\u001a\u00020!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010*\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0015R\u0016\u0010+\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001a\u00104\u001a\u0006\u0012\u0002\b\u0003018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00105\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b5\u0010,R\u0016\u00106\u001a\u00020\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b6\u0010,R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010<\u001a\b\u0012\u0002\b\u0003\u0018\u0001018V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b;\u00103R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000=8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001c\u0010C\u001a\u00020\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bA\u0010(\u001a\u0004\bB\u0010\u0015R\u0016\u0010F\u001a\u00020\u001a8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "Ljava/lang/reflect/Field;", "computeDelegateField", "()Ljava/lang/reflect/Field;", AnalyticFieldsName.field, "", "receiver", "getDelegate", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getBoundReceiver", "()Ljava/lang/Object;", "boundReceiver", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "f", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "_descriptor", "getJavaField", "javaField", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", g.a, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "i", "Ljava/lang/String;", "getSignature", SessionContract.SIGNATURE, "isConst", "()Z", "isBound", "j", "Ljava/lang/Object;", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "isSuspend", "isLateinit", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "e", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "_javaField", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getter", "h", "getName", "name", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Companion", "Accessor", "Getter", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Object k = new Object();
    public final ReflectProperties.LazyVal<Field> e;
    public final ReflectProperties.LazySoftVal<PropertyDescriptor> f;
    @NotNull
    public final KDeclarationContainerImpl g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    public final Object j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u001c\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00118&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\bR\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "", "isExternal", "()Z", "isBound", "isSuspend", "isOperator", "isInline", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "defaultCaller", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "property", "isInfix", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static abstract class Accessor<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public KDeclarationContainerImpl getContainer() {
            return getProperty().getContainer();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @Nullable
        public Caller<?> getDefaultCaller() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public abstract PropertyAccessorDescriptor getDescriptor();

        @Override // kotlin.reflect.KProperty.Accessor
        @NotNull
        public abstract KPropertyImpl<PropertyType> getProperty();

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean isBound() {
            return getProperty().isBound();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return getDescriptor().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return getDescriptor().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return getDescriptor().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return getDescriptor().isOperator();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return getDescriptor().isSuspend();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Companion;", "", "EXTENSION_PROPERTY_DELEGATE", "Ljava/lang/Object;", "getEXTENSION_PROPERTY_DELEGATE", "()Ljava/lang/Object;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Object getEXTENSION_PROPERTY_DELEGATE() {
            return KPropertyImpl.k;
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u00020\u00048V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\n8V@\u0016X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "Lkotlin/reflect/KProperty$Getter;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "e", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "f", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static abstract class Getter<V> extends Accessor<V, V> implements KProperty.Getter<V> {
        public static final /* synthetic */ KProperty[] g = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        public final ReflectProperties.LazySoftVal e = ReflectProperties.lazySoft(new b(this));
        @NotNull
        public final ReflectProperties.LazyVal f = ReflectProperties.lazy(new a(this));

        public static final class a extends Lambda implements Function0<Caller<?>> {
            public final /* synthetic */ Getter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Getter getter) {
                super(0);
                this.a = getter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Caller<?> invoke() {
                return KPropertyImplKt.access$computeCallerForAccessor(this.a, true);
            }
        }

        public static final class b extends Lambda implements Function0<PropertyGetterDescriptor> {
            public final /* synthetic */ Getter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Getter getter) {
                super(0);
                this.a = getter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor getter = this.a.getProperty().getDescriptor().getGetter();
                return getter != null ? getter : DescriptorFactory.createDefaultGetter(this.a.getProperty().getDescriptor(), Annotations.Companion.getEMPTY());
            }
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> getCaller() {
            return (Caller) this.f.getValue(this, g[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public PropertyGetterDescriptor getDescriptor() {
            return (PropertyGetterDescriptor) this.e.getValue(this, g[0]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            StringBuilder L = a2.b.a.a.a.L("<get-");
            L.append(getProperty().getName());
            L.append(Typography.greater);
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\n\u001a\u00020\u00058V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f8V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "e", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor", "", "getName", "()Ljava/lang/String;", "name", "Lkotlin/reflect/jvm/internal/calls/Caller;", "f", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static abstract class Setter<V> extends Accessor<V, Unit> implements KMutableProperty.Setter<V> {
        public static final /* synthetic */ KProperty[] g = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        public final ReflectProperties.LazySoftVal e = ReflectProperties.lazySoft(new b(this));
        @NotNull
        public final ReflectProperties.LazyVal f = ReflectProperties.lazy(new a(this));

        public static final class a extends Lambda implements Function0<Caller<?>> {
            public final /* synthetic */ Setter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Setter setter) {
                super(0);
                this.a = setter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Caller<?> invoke() {
                return KPropertyImplKt.access$computeCallerForAccessor(this.a, false);
            }
        }

        public static final class b extends Lambda implements Function0<PropertySetterDescriptor> {
            public final /* synthetic */ Setter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Setter setter) {
                super(0);
                this.a = setter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public PropertySetterDescriptor invoke() {
                PropertySetterDescriptor setter = this.a.getProperty().getDescriptor().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor descriptor = this.a.getProperty().getDescriptor();
                Annotations.Companion companion = Annotations.Companion;
                return DescriptorFactory.createDefaultSetter(descriptor, companion.getEMPTY(), companion.getEMPTY());
            }
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> getCaller() {
            return (Caller) this.f.getValue(this, g[1]);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public PropertySetterDescriptor getDescriptor() {
            return (PropertySetterDescriptor) this.e.getValue(this, g[0]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            StringBuilder L = a2.b.a.a.a.L("<set-");
            L.append(getProperty().getName());
            L.append(Typography.greater);
            return L.toString();
        }
    }

    public static final class a extends Lambda implements Function0<PropertyDescriptor> {
        public final /* synthetic */ KPropertyImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KPropertyImpl kPropertyImpl) {
            super(0);
            this.a = kPropertyImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PropertyDescriptor invoke() {
            return this.a.getContainer().findPropertyDescriptor(this.a.getName(), this.a.getSignature());
        }
    }

    public static final class b extends Lambda implements Function0<Field> {
        public final /* synthetic */ KPropertyImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KPropertyImpl kPropertyImpl) {
            super(0);
            this.a = kPropertyImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Field invoke() {
            Class<?> cls;
            JvmPropertySignature mapPropertySignature = RuntimeTypeMapper.INSTANCE.mapPropertySignature(this.a.getDescriptor());
            if (mapPropertySignature instanceof JvmPropertySignature.KotlinProperty) {
                JvmPropertySignature.KotlinProperty kotlinProperty = (JvmPropertySignature.KotlinProperty) mapPropertySignature;
                PropertyDescriptor descriptor = kotlinProperty.getDescriptor();
                JvmMemberSignature.Field jvmFieldSignature$default = JvmProtoBufUtil.getJvmFieldSignature$default(JvmProtoBufUtil.INSTANCE, kotlinProperty.getProto(), kotlinProperty.getNameResolver(), kotlinProperty.getTypeTable(), false, 8, null);
                if (jvmFieldSignature$default == null) {
                    return null;
                }
                if (DescriptorsJvmAbiUtil.isPropertyWithBackingFieldInOuterClass(descriptor) || JvmProtoBufUtil.isMovedFromInterfaceCompanion(kotlinProperty.getProto())) {
                    cls = this.a.getContainer().getJClass().getEnclosingClass();
                } else {
                    DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                    if (containingDeclaration instanceof ClassDescriptor) {
                        cls = UtilKt.toJavaClass((ClassDescriptor) containingDeclaration);
                    } else {
                        cls = this.a.getContainer().getJClass();
                    }
                }
                if (cls == null) {
                    return null;
                }
                try {
                    return cls.getDeclaredField(jvmFieldSignature$default.getName());
                } catch (NoSuchFieldException unused) {
                    return null;
                }
            } else if (mapPropertySignature instanceof JvmPropertySignature.JavaField) {
                return ((JvmPropertySignature.JavaField) mapPropertySignature).getField();
            } else {
                if ((mapPropertySignature instanceof JvmPropertySignature.JavaMethodProperty) || (mapPropertySignature instanceof JvmPropertySignature.MappedKotlinProperty)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.g = kDeclarationContainerImpl;
        this.h = str;
        this.i = str2;
        this.j = obj;
        ReflectProperties.LazyVal<Field> lazy = ReflectProperties.lazy(new b(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.e = lazy;
        ReflectProperties.LazySoftVal<PropertyDescriptor> lazySoft = ReflectProperties.lazySoft(propertyDescriptor, new a(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f = lazySoft;
    }

    @Nullable
    public final Field computeDelegateField() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        KPropertyImpl<?> asKPropertyImpl = UtilKt.asKPropertyImpl(obj);
        if (asKPropertyImpl == null || !Intrinsics.areEqual(getContainer(), asKPropertyImpl.getContainer()) || !Intrinsics.areEqual(getName(), asKPropertyImpl.getName()) || !Intrinsics.areEqual(this.i, asKPropertyImpl.i) || !Intrinsics.areEqual(this.j, asKPropertyImpl.j)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Object getBoundReceiver() {
        return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.j, getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> getCaller() {
        return getGetter().getCaller();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl getContainer() {
        return this.g;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> getDefaultCaller() {
        return getGetter().getDefaultCaller();
    }

    @Nullable
    public final Object getDelegate(@Nullable Field field, @Nullable Object obj) {
        try {
            if (obj == k) {
                if (getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                }
            }
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
    }

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty0
    @NotNull
    public abstract Getter<V> getGetter();

    @Nullable
    public final Field getJavaField() {
        return this.e.invoke();
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        return this.h;
    }

    @NotNull
    public final String getSignature() {
        return this.i;
    }

    public int hashCode() {
        int hashCode = getName().hashCode();
        return this.i.hashCode() + ((hashCode + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean isBound() {
        return !Intrinsics.areEqual(this.j, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public PropertyDescriptor getDescriptor() {
        PropertyDescriptor invoke = this.f.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_descriptor()");
        return invoke;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KPropertyImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r9.getName()
            java.lang.String r3 = r0.asString()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            kotlin.reflect.jvm.internal.RuntimeTypeMapper r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE
            kotlin.reflect.jvm.internal.JvmPropertySignature r0 = r0.mapPropertySignature(r9)
            java.lang.String r4 = r0.asString()
            java.lang.Object r6 = kotlin.jvm.internal.CallableReference.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):void");
    }
}
