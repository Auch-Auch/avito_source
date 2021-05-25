package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
import t6.w.f.a.m.b.b;
public final class ScopesHolderForClass<T extends MemberScope> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty<Object>[] e = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    @NotNull
    public final ClassDescriptor a;
    @NotNull
    public final Function1<KotlinTypeRefiner, T> b;
    @NotNull
    public final KotlinTypeRefiner c;
    @NotNull
    public final NotNullLazyValue d;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final <T extends MemberScope> ScopesHolderForClass<T> create(@NotNull ClassDescriptor classDescriptor, @NotNull StorageManager storageManager, @NotNull KotlinTypeRefiner kotlinTypeRefiner, @NotNull Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(function1, "scopeFactory");
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, kotlinTypeRefiner, null);
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<T> {
        public final /* synthetic */ ScopesHolderForClass<T> a;
        public final /* synthetic */ KotlinTypeRefiner b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ScopesHolderForClass<T> scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
            super(0);
            this.a = scopesHolderForClass;
            this.b = kotlinTypeRefiner;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (MemberScope) this.a.b.invoke(this.b);
        }
    }

    public ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, j jVar) {
        this.a = classDescriptor;
        this.b = function1;
        this.c = kotlinTypeRefiner;
        this.d = storageManager.createLazyValue(new b(this));
    }

    @NotNull
    public final T getScope(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.a))) {
            return (T) ((MemberScope) StorageKt.getValue(this.d, this, e[0]));
        }
        TypeConstructor typeConstructor = this.a.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        return !kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor) ? (T) ((MemberScope) StorageKt.getValue(this.d, this, e[0])) : (T) kotlinTypeRefiner.getOrPutScopeForClass(this.a, new a(this, kotlinTypeRefiner));
    }
}
