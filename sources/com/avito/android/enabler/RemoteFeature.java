package com.avito.android.enabler;

import com.avito.android.toggle.Feature;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B:\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012#\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR6\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0006\u0012\u0004\u0018\u00018\u00000\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0018\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00058\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R\u001d\u0010!\u001a\u00028\u00008V@\u0016X\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/enabler/RemoteFeature;", "T", "Lcom/avito/android/toggle/Feature;", "invoke", "()Ljava/lang/Object;", "", "touched", "()Z", "delegate", "Lcom/avito/android/toggle/Feature;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "key", "remoteValue", "Lkotlin/jvm/functions/Function1;", "getRemoteValue", "()Lkotlin/jvm/functions/Function1;", "getApiToggleId", "()Ljava/lang/String;", "apiToggleId", "getKey", "getOriginalValue", "originalValue", "getDescription", "description", "Lkotlin/Lazy;", "lazyValue", "Lkotlin/Lazy;", "isRemote", "value$delegate", "getValue", "value", "<init>", "(Lcom/avito/android/toggle/Feature;Lkotlin/jvm/functions/Function1;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public class RemoteFeature<T> implements Feature<T> {
    private final Feature<T> delegate;
    private final Lazy<T> lazyValue;
    @NotNull
    private final Function1<String, T> remoteValue;
    private final Lazy value$delegate;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.toggle.Feature<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public RemoteFeature(@NotNull Feature<? extends T> feature, @NotNull Function1<? super String, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(feature, "delegate");
        Intrinsics.checkNotNullParameter(function1, "remoteValue");
        this.delegate = feature;
        this.remoteValue = function1;
        Lazy<T> lazy = c.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<T>(this) { // from class: com.avito.android.enabler.RemoteFeature$lazyValue$1
            public final /* synthetic */ RemoteFeature this$0;

            {
                this.this$0 = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                T t = (T) this.this$0.getRemoteValue().invoke(this.this$0.getKey());
                return t != null ? t : (T) this.this$0.delegate.getValue();
            }
        });
        this.lazyValue = lazy;
        this.value$delegate = lazy;
    }

    @Override // com.avito.android.toggle.Feature
    @Nullable
    public String getApiToggleId() {
        return this.delegate.getApiToggleId();
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getDescription() {
        return this.delegate.getDescription();
    }

    @Override // com.avito.android.toggle.Feature
    @NotNull
    public String getKey() {
        return this.delegate.getKey();
    }

    @Override // com.avito.android.toggle.Feature
    public T getOriginalValue() {
        return this.delegate.getValue();
    }

    @NotNull
    public final Function1<String, T> getRemoteValue() {
        return this.remoteValue;
    }

    @Override // com.avito.android.toggle.Feature
    public T getValue() {
        return (T) this.value$delegate.getValue();
    }

    @Override // com.avito.android.toggle.Feature
    public T invoke() {
        return getValue();
    }

    @Override // com.avito.android.toggle.Feature
    public boolean isRemote() {
        return this.delegate.isRemote();
    }

    public final boolean touched() {
        return this.lazyValue.isInitialized();
    }
}
