package com.avito.android.beduin.core.registry;

import android.annotation.SuppressLint;
import android.view.View;
import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.beduin.core.action.BeduinActionHandler;
import com.avito.android.beduin.core.common.BeduinApiTypeName;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.container.BeduinContainer;
import com.avito.android.beduin.core.exception.BeduinActionAlreadyRegisteredException;
import com.avito.android.beduin.core.exception.BeduinActionWithoutTypeAnnotation;
import com.avito.android.beduin.core.exception.BeduinComponentAlreadyRegisteredException;
import com.avito.android.beduin.core.exception.BeduinComponentConstructorIsMission;
import com.avito.android.beduin.core.exception.BeduinComponentNotRegistered;
import com.avito.android.beduin.core.exception.BeduinComponentWithoutTypeAnnotation;
import com.avito.android.beduin.core.exception.BeduinContainerConstructorIsMission;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.auth.AuthSource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.ReflectJvmMapping;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J%\u0010\u0005\u001a\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00002\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002¢\u0006\u0004\b\t\u0010\u0006J)\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u0016\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00112\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002¢\u0006\u0004\b\u0015\u0010\u0014J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0016\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018R/\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00030\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR'\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u001d¨\u0006$"}, d2 = {"Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "", "Lkotlin/reflect/KClass;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "component", "registerComponent", "(Lkotlin/reflect/KClass;)Lcom/avito/android/beduin/core/registry/BeduinRegistry;", "Lcom/avito/android/beduin/core/action/BeduinAction;", "action", "registerAction", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "Lcom/avito/android/beduin/core/action/BeduinActionHandler;", "beduinActionHandler", "Landroid/view/View;", "getComponentByModel", "(Lcom/avito/android/beduin/core/model/container/component/BeduinModel;Lcom/avito/android/beduin/core/action/BeduinActionHandler;)Lcom/avito/android/beduin/core/component/BeduinComponent;", "", "", "getTypeNameByComponent", "(Lkotlin/reflect/KClass;)[Ljava/lang/String;", "getTypeNameByAction", "Ljava/lang/Class;", "getModelTypeByComponent", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getRegisteredComponents", "()Ljava/util/List;", "registeredComponents", AuthSource.BOOKING_ORDER, "getRegisteredActions", "registeredActions", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"KotlinReflection"})
public final class BeduinRegistry {
    @NotNull
    public final List<KClass<? extends BeduinComponent<?, ?>>> a = new ArrayList();
    @NotNull
    public final List<KClass<? extends BeduinAction>> b = new ArrayList();

    @NotNull
    public final BeduinComponent<BeduinModel, View> getComponentByModel(@NotNull BeduinModel beduinModel, @NotNull BeduinActionHandler beduinActionHandler) throws BeduinComponentNotRegistered {
        Type type;
        T t;
        KType returnType;
        Intrinsics.checkNotNullParameter(beduinModel, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Intrinsics.checkNotNullParameter(beduinActionHandler, "beduinActionHandler");
        Iterator<T> it = this.a.iterator();
        while (true) {
            type = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            Iterator<T> it2 = next.getMembers().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (Intrinsics.areEqual(t.getName(), VerticalFilterCloseDialogEventKt.MODEL_DIALOG)) {
                    break;
                }
            }
            T t2 = t;
            if (!(t2 == null || (returnType = t2.getReturnType()) == null)) {
                type = ReflectJvmMapping.getJavaType(returnType);
            }
            if (Intrinsics.areEqual(type, beduinModel.getClass())) {
                type = next;
                break;
            }
        }
        KClass kClass = (KClass) type;
        if (kClass == null) {
            throw new BeduinComponentNotRegistered(String.valueOf(Reflection.getOrCreateKotlinClass(beduinModel.getClass()).getSimpleName()));
        } else if (BeduinContainer.class.isAssignableFrom(JvmClassMappingKt.getJavaClass(kClass))) {
            try {
                Object call = ((KFunction) CollectionsKt___CollectionsKt.first(kClass.getConstructors())).call(beduinModel, new Function2<BeduinModel, BeduinActionHandler, BeduinComponent<BeduinModel, View>>(this) { // from class: com.avito.android.beduin.core.registry.BeduinRegistry.a
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function2
                    public BeduinComponent<BeduinModel, View> invoke(BeduinModel beduinModel2, BeduinActionHandler beduinActionHandler2) {
                        BeduinModel beduinModel3 = beduinModel2;
                        BeduinActionHandler beduinActionHandler3 = beduinActionHandler2;
                        Intrinsics.checkNotNullParameter(beduinModel3, "p1");
                        Intrinsics.checkNotNullParameter(beduinActionHandler3, "p2");
                        return ((BeduinRegistry) this.receiver).getComponentByModel(beduinModel3, beduinActionHandler3);
                    }
                }, beduinActionHandler);
                if (call != null) {
                    return (BeduinComponent) call;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>");
            } catch (Exception unused) {
                throw new BeduinContainerConstructorIsMission(String.valueOf(kClass.getSimpleName()));
            }
        } else {
            try {
                Object call2 = ((KFunction) CollectionsKt___CollectionsKt.first(kClass.getConstructors())).call(beduinModel, beduinActionHandler);
                if (call2 != null) {
                    return (BeduinComponent) call2;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.avito.android.beduin.core.component.BeduinComponent<com.avito.android.beduin.core.model.container.component.BeduinModel, android.view.View>");
            } catch (Exception unused2) {
                throw new BeduinComponentConstructorIsMission(String.valueOf(kClass.getSimpleName()));
            }
        }
    }

    @NotNull
    public final Class<BeduinModel> getModelTypeByComponent(@NotNull KClass<? extends BeduinComponent<?, ?>> kClass) {
        Type type;
        T t;
        KType returnType;
        Intrinsics.checkNotNullParameter(kClass, "component");
        Iterator<T> it = kClass.getMembers().iterator();
        while (true) {
            type = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getName(), VerticalFilterCloseDialogEventKt.MODEL_DIALOG)) {
                break;
            }
        }
        T t2 = t;
        if (!(t2 == null || (returnType = t2.getReturnType()) == null)) {
            type = ReflectJvmMapping.getJavaType(returnType);
        }
        Intrinsics.checkNotNull(type);
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<com.avito.android.beduin.core.model.container.component.BeduinModel>");
        return (Class) type;
    }

    @NotNull
    public final List<KClass<? extends BeduinAction>> getRegisteredActions() {
        return this.b;
    }

    @NotNull
    public final List<KClass<? extends BeduinComponent<?, ?>>> getRegisteredComponents() {
        return this.a;
    }

    @NotNull
    public final String[] getTypeNameByAction(@NotNull KClass<? extends BeduinAction> kClass) {
        T t;
        Intrinsics.checkNotNullParameter(kClass, "action");
        Iterator<T> it = kClass.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof BeduinApiTypeName) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.types();
        }
        throw new BeduinActionWithoutTypeAnnotation(String.valueOf(kClass.getSimpleName()));
    }

    @NotNull
    public final String[] getTypeNameByComponent(@NotNull KClass<? extends BeduinComponent<?, ?>> kClass) {
        T t;
        Intrinsics.checkNotNullParameter(kClass, "component");
        Iterator<T> it = kClass.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t instanceof BeduinApiTypeName) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.types();
        }
        throw new BeduinComponentWithoutTypeAnnotation(String.valueOf(kClass.getSimpleName()));
    }

    @NotNull
    public final BeduinRegistry registerAction(@NotNull KClass<? extends BeduinAction> kClass) throws BeduinActionAlreadyRegisteredException {
        Intrinsics.checkNotNullParameter(kClass, "action");
        if (!this.b.contains(kClass)) {
            this.b.add(kClass);
            return this;
        }
        String simpleName = kClass.getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        throw new BeduinActionAlreadyRegisteredException(simpleName);
    }

    @NotNull
    public final BeduinRegistry registerComponent(@NotNull KClass<? extends BeduinComponent<?, ?>> kClass) throws BeduinComponentAlreadyRegisteredException {
        Intrinsics.checkNotNullParameter(kClass, "component");
        if (!this.a.contains(kClass)) {
            this.a.add(kClass);
            return this;
        }
        String simpleName = kClass.getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        throw new BeduinComponentAlreadyRegisteredException(simpleName);
    }
}
