package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001dB\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B+\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0015\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR0\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \r*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\b0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "value", "", "set", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "n", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "_setter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", SessionContract.SIGNATURE, "", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public final class KMutableProperty0Impl<V> extends KProperty0Impl<V> implements KMutableProperty0<V> {
    public final ReflectProperties.LazyVal<Setter<V>> n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "Lkotlin/reflect/KMutableProperty0$Setter;", "value", "", "invoke", "(Ljava/lang/Object;)V", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "h", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Setter<R> extends KPropertyImpl.Setter<R> implements KMutableProperty0.Setter<R> {
        @NotNull
        public final KMutableProperty0Impl<R> h;

        public Setter(@NotNull KMutableProperty0Impl<R> kMutableProperty0Impl) {
            Intrinsics.checkNotNullParameter(kMutableProperty0Impl, "property");
            this.h = kMutableProperty0Impl;
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        @NotNull
        public KMutableProperty0Impl<R> getProperty() {
            return this.h;
        }

        @Override // kotlin.jvm.functions.Function1
        public void invoke(R r) {
            getProperty().set(r);
        }
    }

    public static final class a extends Lambda implements Function0<Setter<V>> {
        public final /* synthetic */ KMutableProperty0Impl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KMutableProperty0Impl kMutableProperty0Impl) {
            super(0);
            this.a = kMutableProperty0Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return new Setter(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.LazyVal<Setter<V>> lazy = ReflectProperties.lazy(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Setter(this) }");
        this.n = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty0
    public void set(V v) {
        getSetter().call(v);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
        ReflectProperties.LazyVal<Setter<V>> lazy = ReflectProperties.lazy(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Setter(this) }");
        this.n = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty0
    @NotNull
    public Setter<V> getSetter() {
        Setter<V> invoke = this.n.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_setter()");
        return invoke;
    }
}
