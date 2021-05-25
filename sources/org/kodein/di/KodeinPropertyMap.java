package org.kodein.di;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0003B)\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\b@\bX\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lorg/kodein/di/KodeinPropertyMap;", "I", "O", "Lorg/kodein/di/LazyDelegate;", "", "receiver", "Lkotlin/reflect/KProperty;", "prop", "Lkotlin/Lazy;", "provideDelegate", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;", "Lkotlin/Function1;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "map", "Lorg/kodein/di/KodeinProperty;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/KodeinProperty;", "base", "<init>", "(Lorg/kodein/di/KodeinProperty;Lkotlin/jvm/functions/Function1;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinPropertyMap<I, O> implements LazyDelegate<O> {
    public final KodeinProperty<I> a;
    public final Function1<I, O> b;

    public static final class a extends Lambda implements Function0<O> {
        public final /* synthetic */ KodeinPropertyMap a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ KProperty c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KodeinPropertyMap kodeinPropertyMap, Object obj, KProperty kProperty) {
            super(0);
            this.a = kodeinPropertyMap;
            this.b = obj;
            this.c = kProperty;
        }

        @Override // kotlin.jvm.functions.Function0
        public final O invoke() {
            return (O) this.a.b.invoke(this.a.a.provideDelegate(this.b, this.c).getValue());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: org.kodein.di.KodeinProperty<? extends I> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super I, ? extends O> */
    /* JADX WARN: Multi-variable type inference failed */
    public KodeinPropertyMap(@NotNull KodeinProperty<? extends I> kodeinProperty, @NotNull Function1<? super I, ? extends O> function1) {
        Intrinsics.checkParameterIsNotNull(kodeinProperty, "base");
        Intrinsics.checkParameterIsNotNull(function1, "map");
        this.a = kodeinProperty;
        this.b = function1;
    }

    @Override // org.kodein.di.LazyDelegate
    @NotNull
    public Lazy<O> provideDelegate(@Nullable Object obj, @NotNull KProperty<? extends Object> kProperty) {
        List<Lazy<?>> properties;
        Intrinsics.checkParameterIsNotNull(kProperty, "prop");
        Lazy<O> lazy = c.lazy(new a(this, obj, kProperty));
        KodeinTrigger trigger$kodein_di_core = this.a.getTrigger$kodein_di_core();
        if (!(trigger$kodein_di_core == null || (properties = trigger$kodein_di_core.getProperties()) == null)) {
            properties.add(lazy);
        }
        return lazy;
    }
}
