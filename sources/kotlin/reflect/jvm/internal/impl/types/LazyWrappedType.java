package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
public final class LazyWrappedType extends WrappedType {
    @NotNull
    public final StorageManager b;
    @NotNull
    public final Function0<KotlinType> c;
    @NotNull
    public final NotNullLazyValue<KotlinType> d;

    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ KotlinTypeRefiner a;
        public final /* synthetic */ LazyWrappedType b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
            super(0);
            this.a = kotlinTypeRefiner;
            this.b = lazyWrappedType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KotlinType invoke() {
            return this.a.refineType((KotlinType) this.b.c.invoke());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "computation");
        this.b = storageManager;
        this.c = function0;
        this.d = storageManager.createLazyValue(function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    @NotNull
    public KotlinType getDelegate() {
        return (KotlinType) this.d.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.d.isComputed();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    @NotNull
    /* renamed from: refine */
    public LazyWrappedType mo988refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new LazyWrappedType(this.b, new a(kotlinTypeRefiner, this));
    }
}
