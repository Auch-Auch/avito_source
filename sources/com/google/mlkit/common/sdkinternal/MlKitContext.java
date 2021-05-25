package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.concurrent.atomic.AtomicReference;
@KeepForSdk
public class MlKitContext {
    public static final AtomicReference<MlKitContext> b = new AtomicReference<>();
    public final ComponentRuntime a;

    public MlKitContext(Context context) {
        ComponentRuntime componentRuntime = new ComponentRuntime(TaskExecutors.MAIN_THREAD, ComponentDiscovery.forContext(context, MlKitComponentDiscoveryService.class).discover(), Component.of(context, Context.class, new Class[0]), Component.of(this, MlKitContext.class, new Class[0]));
        this.a = componentRuntime;
        componentRuntime.initializeEagerComponents(true);
    }

    @KeepForSdk
    public static MlKitContext getInstance() {
        MlKitContext mlKitContext = b.get();
        Preconditions.checkState(mlKitContext != null, "MlKitContext has not been initialized");
        return mlKitContext;
    }

    public static MlKitContext zza(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        MlKitContext mlKitContext = new MlKitContext(context);
        Preconditions.checkState(b.getAndSet(mlKitContext) == null, "MlKitContext is already initialized");
        return mlKitContext;
    }

    @KeepForSdk
    public <T> T get(Class<T> cls) {
        Preconditions.checkState(b.get() == this, "MlKitContext has been deleted");
        return (T) this.a.get(cls);
    }

    @KeepForSdk
    public Context getApplicationContext() {
        return (Context) get(Context.class);
    }
}
