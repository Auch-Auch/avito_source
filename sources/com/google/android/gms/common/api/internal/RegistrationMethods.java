package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @RecentlyNonNull
    public final RegisterListenerMethod<A, L> zaa;
    @RecentlyNonNull
    public final UnregisterListenerMethod<A, L> zab;
    @RecentlyNonNull
    public final Runnable zac;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        private RemoteCall<A, TaskCompletionSource<Void>> zaa;
        private RemoteCall<A, TaskCompletionSource<Boolean>> zab;
        private Runnable zac;
        private ListenerHolder<L> zad;
        private Feature[] zae;
        private boolean zaf;

        private Builder() {
            this.zac = zabv.zaa;
            this.zaf = true;
        }

        @RecentlyNonNull
        @KeepForSdk
        public RegistrationMethods<A, L> build() {
            boolean z = true;
            Preconditions.checkArgument(this.zaa != null, "Must set register function");
            Preconditions.checkArgument(this.zab != null, "Must set unregister function");
            if (this.zad == null) {
                z = false;
            }
            Preconditions.checkArgument(z, "Must set holder");
            return new RegistrationMethods<>(new zabw(this, this.zad, this.zae, this.zaf), new zaby(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(this.zad.getListenerKey(), "Key must not be null")), this.zac);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> onConnectionSuspended(@RecentlyNonNull Runnable runnable) {
            this.zac = runnable;
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        @KeepForSdk
        public Builder<A, L> register(@RecentlyNonNull BiConsumer<A, TaskCompletionSource<Void>> biConsumer) {
            this.zaa = new zabu(biConsumer);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> setAutoResolveMissingFeatures(@RecentlyNonNull boolean z) {
            this.zaf = z;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> setFeatures(@RecentlyNonNull Feature... featureArr) {
            this.zae = featureArr;
            return this;
        }

        @RecentlyNonNull
        @Deprecated
        @KeepForSdk
        public Builder<A, L> unregister(@RecentlyNonNull BiConsumer<A, TaskCompletionSource<Boolean>> biConsumer) {
            this.zaa = new zabx(this);
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> withHolder(@RecentlyNonNull ListenerHolder<L> listenerHolder) {
            this.zad = listenerHolder;
            return this;
        }

        public final /* synthetic */ void zaa(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
            this.zaa.accept(anyClient, taskCompletionSource);
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> register(@RecentlyNonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.zaa = remoteCall;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder<A, L> unregister(@RecentlyNonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.zab = remoteCall;
            return this;
        }
    }

    private RegistrationMethods(RegisterListenerMethod<A, L> registerListenerMethod, UnregisterListenerMethod<A, L> unregisterListenerMethod, Runnable runnable) {
        this.zaa = registerListenerMethod;
        this.zab = unregisterListenerMethod;
        this.zac = runnable;
    }

    @RecentlyNonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> builder() {
        return new Builder<>();
    }
}
