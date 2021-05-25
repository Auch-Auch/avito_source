package kotlin.reflect.jvm.internal;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0019\u001a\u00020\u0018*\u00060\u0014j\u0002`\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u0018*\u00060\u0014j\u0002`\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010 ¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "", "renderProperty", "(Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "renderFunction", "(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Ljava/lang/String;", "invoke", "renderLambda", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "parameter", "renderParameter", "(Lkotlin/reflect/jvm/internal/KParameterImpl;)Ljava/lang/String;", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "type", "renderType", "(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "receiver", "", AuthSource.SEND_ABUSE, "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "callable", AuthSource.BOOKING_ORDER, "(Ljava/lang/StringBuilder;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;)V", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "Lkotlin/reflect/jvm/internal/impl/renderer/DescriptorRenderer;", "renderer", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class ReflectionObjectRenderer {
    @NotNull
    public static final ReflectionObjectRenderer INSTANCE = new ReflectionObjectRenderer();
    public static final DescriptorRenderer a = DescriptorRenderer.FQ_NAMES_IN_TYPES;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            KParameter.Kind.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor2, "it");
            KotlinType type = valueParameterDescriptor2.getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    public static final class b extends Lambda implements Function1<ValueParameterDescriptor, CharSequence> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CharSequence invoke(ValueParameterDescriptor valueParameterDescriptor) {
            ValueParameterDescriptor valueParameterDescriptor2 = valueParameterDescriptor;
            ReflectionObjectRenderer reflectionObjectRenderer = ReflectionObjectRenderer.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor2, "it");
            KotlinType type = valueParameterDescriptor2.getType();
            Intrinsics.checkNotNullExpressionValue(type, "it.type");
            return reflectionObjectRenderer.renderType(type);
        }
    }

    public final void a(StringBuilder sb, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType type = receiverParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            sb.append(renderType(type));
            sb.append(".");
        }
    }

    public final void b(StringBuilder sb, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor instanceReceiverParameter = UtilKt.getInstanceReceiverParameter(callableDescriptor);
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        a(sb, instanceReceiverParameter);
        boolean z = (instanceReceiverParameter == null || extensionReceiverParameter == null) ? false : true;
        if (z) {
            sb.append("(");
        }
        a(sb, extensionReceiverParameter);
        if (z) {
            sb.append(")");
        }
    }

    @NotNull
    public final String renderFunction(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
        CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, a.a, 48, null);
        sb.append(": ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        Intrinsics.checkNotNullExpressionValue(returnType, "descriptor.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String renderLambda(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "invoke");
        StringBuilder sb = new StringBuilder();
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, functionDescriptor);
        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "invoke.valueParameters");
        CollectionsKt___CollectionsKt.joinTo$default(valueParameters, sb, ", ", "(", ")", 0, null, b.a, 48, null);
        sb.append(" -> ");
        KotlinType returnType = functionDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        Intrinsics.checkNotNullExpressionValue(returnType, "invoke.returnType!!");
        sb.append(reflectionObjectRenderer.renderType(returnType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String renderParameter(@NotNull KParameterImpl kParameterImpl) {
        String str;
        Intrinsics.checkNotNullParameter(kParameterImpl, "parameter");
        StringBuilder sb = new StringBuilder();
        int ordinal = kParameterImpl.getKind().ordinal();
        if (ordinal == 0) {
            sb.append("instance parameter");
        } else if (ordinal == 1) {
            sb.append("extension receiver parameter");
        } else if (ordinal == 2) {
            StringBuilder L = a2.b.a.a.a.L("parameter #");
            L.append(kParameterImpl.getIndex());
            L.append(' ');
            L.append(kParameterImpl.getName());
            sb.append(L.toString());
        }
        sb.append(" of ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        CallableMemberDescriptor descriptor = kParameterImpl.getCallable().getDescriptor();
        Objects.requireNonNull(reflectionObjectRenderer);
        if (descriptor instanceof PropertyDescriptor) {
            str = reflectionObjectRenderer.renderProperty((PropertyDescriptor) descriptor);
        } else if (descriptor instanceof FunctionDescriptor) {
            str = reflectionObjectRenderer.renderFunction((FunctionDescriptor) descriptor);
        } else {
            throw new IllegalStateException(("Illegal callable: " + descriptor).toString());
        }
        sb.append(str);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String renderProperty(@NotNull PropertyDescriptor propertyDescriptor) {
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(propertyDescriptor.isVar() ? "var " : "val ");
        ReflectionObjectRenderer reflectionObjectRenderer = INSTANCE;
        reflectionObjectRenderer.b(sb, propertyDescriptor);
        DescriptorRenderer descriptorRenderer = a;
        Name name = propertyDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(descriptorRenderer.renderName(name, true));
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "descriptor.type");
        sb.append(reflectionObjectRenderer.renderType(type));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String renderType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return a.renderType(kotlinType);
    }
}
