package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004:\u0001$B\u0019\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eB+\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010#J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0018\u0010\n\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\n\u0010\u0007R\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00108V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R<\u0010\u0018\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001 \u0015*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00100\u00100\u00148\b@\bX\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "receiver", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "getDelegate", "invoke", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", AuthSource.OPEN_CHANNEL_LIST, "Lkotlin/Lazy;", "delegateField", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "kotlin.jvm.PlatformType", "l", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "_getter", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "", "name", SessionContract.SIGNATURE, "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Getter", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    public final ReflectProperties.LazyVal<Getter<T, V>> l;
    public final Lazy<Field> m = c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new b(this));

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0006\b\u0003\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00028\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R(\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "T", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "Lkotlin/reflect/KProperty1$Getter;", "receiver", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "h", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KProperty1Impl;", "property", "<init>", "(Lkotlin/reflect/jvm/internal/KProperty1Impl;)V", "kotlin-reflection"}, k = 1, mv = {1, 4, 1})
    public static final class Getter<T, V> extends KPropertyImpl.Getter<V> implements KProperty1.Getter<T, V> {
        @NotNull
        public final KProperty1Impl<T, V> h;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.KProperty1Impl<T, ? extends V> */
        /* JADX WARN: Multi-variable type inference failed */
        public Getter(@NotNull KProperty1Impl<T, ? extends V> kProperty1Impl) {
            Intrinsics.checkNotNullParameter(kProperty1Impl, "property");
            this.h = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return getProperty().get(t);
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        @NotNull
        public KProperty1Impl<T, V> getProperty() {
            return this.h;
        }
    }

    public static final class a extends Lambda implements Function0<Getter<T, ? extends V>> {
        public final /* synthetic */ KProperty1Impl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KProperty1Impl kProperty1Impl) {
            super(0);
            this.a = kProperty1Impl;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return new Getter(this.a);
        }
    }

    public static final class b extends Lambda implements Function0<Field> {
        public final /* synthetic */ KProperty1Impl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KProperty1Impl kProperty1Impl) {
            super(0);
            this.a = kProperty1Impl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Field invoke() {
            return this.a.computeDelegateField();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, SessionContract.SIGNATURE);
        ReflectProperties.LazyVal<Getter<T, V>> lazy = ReflectProperties.lazy(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Getter(this) }");
        this.l = lazy;
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T t) {
        return (V) getGetter().call(t);
    }

    @Override // kotlin.reflect.KProperty1
    @Nullable
    public Object getDelegate(T t) {
        return getDelegate(this.m.getValue(), t);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.LazyVal<Getter<T, V>> lazy = ReflectProperties.lazy(new a(this));
        Intrinsics.checkNotNullExpressionValue(lazy, "ReflectProperties.lazy { Getter(this) }");
        this.l = lazy;
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl, kotlin.reflect.KProperty, kotlin.reflect.KProperty0
    @NotNull
    public Getter<T, V> getGetter() {
        Getter<T, V> invoke = this.l.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_getter()");
        return invoke;
    }
}
