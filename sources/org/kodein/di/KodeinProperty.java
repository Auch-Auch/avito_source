package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.KodeinContext;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u000b\u0012\u001c\u0010\u000f\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR,\u0010\u000f\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lorg/kodein/di/KodeinProperty;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lorg/kodein/di/LazyDelegate;", "", "receiver", "Lkotlin/reflect/KProperty;", "prop", "Lkotlin/Lazy;", "provideDelegate", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;", "Lkotlin/Function2;", "Lorg/kodein/di/KodeinContext;", "", "c", "Lkotlin/jvm/functions/Function2;", "get", "Lorg/kodein/di/KodeinTrigger;", AuthSource.SEND_ABUSE, "Lorg/kodein/di/KodeinTrigger;", "getTrigger$kodein_di_core", "()Lorg/kodein/di/KodeinTrigger;", "trigger", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/KodeinContext;", "getOriginalContext", "()Lorg/kodein/di/KodeinContext;", "originalContext", "<init>", "(Lorg/kodein/di/KodeinTrigger;Lorg/kodein/di/KodeinContext;Lkotlin/jvm/functions/Function2;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class KodeinProperty<V> implements LazyDelegate<V> {
    @Nullable
    public final KodeinTrigger a;
    @NotNull
    public final KodeinContext<?> b;
    public final Function2<KodeinContext<?>, String, V> c;

    public static final class a extends Lambda implements Function0<V> {
        public final /* synthetic */ KodeinProperty a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ KProperty c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KodeinProperty kodeinProperty, Object obj, KProperty kProperty) {
            super(0);
            this.a = kodeinProperty;
            this.b = obj;
            this.c = kProperty;
        }

        @Override // kotlin.jvm.functions.Function0
        public final V invoke() {
            KodeinContext<?> kodeinContext;
            if (this.b == null || this.a.getOriginalContext() != KodeinAwareKt.getAnyKodeinContext()) {
                kodeinContext = this.a.getOriginalContext();
            } else {
                KodeinContext.Companion companion = KodeinContext.Companion;
                TypeToken TTOf = TypesKt.TTOf(this.b);
                if (TTOf != null) {
                    kodeinContext = companion.invoke((TypeToken<? super TypeToken>) TTOf, (TypeToken) this.b);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.kodein.di.TypeToken<in kotlin.Any>");
                }
            }
            return (V) this.a.c.invoke(kodeinContext, this.c.getName());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function2<? super org.kodein.di.KodeinContext<?>, ? super java.lang.String, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public KodeinProperty(@Nullable KodeinTrigger kodeinTrigger, @NotNull KodeinContext<?> kodeinContext, @NotNull Function2<? super KodeinContext<?>, ? super String, ? extends V> function2) {
        Intrinsics.checkParameterIsNotNull(kodeinContext, "originalContext");
        Intrinsics.checkParameterIsNotNull(function2, "get");
        this.a = kodeinTrigger;
        this.b = kodeinContext;
        this.c = function2;
    }

    @NotNull
    public final KodeinContext<?> getOriginalContext() {
        return this.b;
    }

    @Nullable
    public final KodeinTrigger getTrigger$kodein_di_core() {
        return this.a;
    }

    @Override // org.kodein.di.LazyDelegate
    @NotNull
    public Lazy<V> provideDelegate(@Nullable Object obj, @NotNull KProperty<? extends Object> kProperty) {
        List<Lazy<?>> properties;
        Intrinsics.checkParameterIsNotNull(kProperty, "prop");
        Lazy<V> lazy = c.lazy(new a(this, obj, kProperty));
        KodeinTrigger kodeinTrigger = this.a;
        if (!(kodeinTrigger == null || (properties = kodeinTrigger.getProperties()) == null)) {
            properties.add(lazy);
        }
        return lazy;
    }
}
