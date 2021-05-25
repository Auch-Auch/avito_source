package com.avito.android.recycler.base;

import com.avito.android.component.search.ItemListener;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Use Lazy initialization instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/recycler/base/BaseItemListenerProxy;", "T", "Lcom/avito/android/component/search/ItemListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "attachListener", "(Ljava/lang/Object;)V", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getListener", "()Ljava/lang/Object;", "setListener", "<init>", "()V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseItemListenerProxy<T> implements ItemListener<T> {
    @Nullable
    public T a;

    @Override // com.avito.android.component.search.ItemListener
    public void attachListener(T t) {
        this.a = t;
    }

    @Nullable
    public final T getListener() {
        return this.a;
    }

    public final void setListener(@Nullable T t) {
        this.a = t;
    }
}
