package com.avito.android.enabler;

import com.avito.android.toggle.Feature;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B/\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00028\u00008V@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R(\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0004\u0012\u00020\t0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00028\u00008\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0018\u001a\u00020\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/enabler/AnalyticFeature;", "T", "Lcom/avito/android/toggle/Feature;", "invoke", "()Ljava/lang/Object;", "getOriginalValue", "originalValue", "Lkotlin/Function1;", "Lcom/avito/android/enabler/RemoteFeature;", "", "reportCallback", "Lkotlin/jvm/functions/Function1;", "", "getApiToggleId", "()Ljava/lang/String;", "apiToggleId", "", "isRemote", "()Z", "getValue", "value", "getDescription", "description", "getKey", "key", "delegate", "Lcom/avito/android/enabler/RemoteFeature;", "<init>", "(Lcom/avito/android/enabler/RemoteFeature;Lkotlin/jvm/functions/Function1;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticFeature<T> implements Feature<T> {
    private final RemoteFeature<T> delegate;
    private final Function1<RemoteFeature<T>, Unit> reportCallback;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.enabler.RemoteFeature<T>, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public AnalyticFeature(@NotNull RemoteFeature<T> remoteFeature, @NotNull Function1<? super RemoteFeature<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(remoteFeature, "delegate");
        Intrinsics.checkNotNullParameter(function1, "reportCallback");
        this.delegate = remoteFeature;
        this.reportCallback = function1;
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
        return this.delegate.getOriginalValue();
    }

    @Override // com.avito.android.toggle.Feature
    public T getValue() {
        return this.delegate.getValue();
    }

    @Override // com.avito.android.toggle.Feature
    public T invoke() {
        boolean z = true;
        if (!(!this.delegate.touched()) || !this.delegate.isRemote()) {
            z = false;
        }
        if (z) {
            this.reportCallback.invoke(this.delegate);
        }
        return getValue();
    }

    @Override // com.avito.android.toggle.Feature
    public boolean isRemote() {
        return this.delegate.isRemote();
    }
}
