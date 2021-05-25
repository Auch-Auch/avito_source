package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public class zai extends zak {
    private final SparseArray<zaa> zad = new SparseArray<>();

    public class zaa implements GoogleApiClient.OnConnectionFailedListener {
        public final int zaa;
        public final GoogleApiClient zab;
        @Nullable
        public final GoogleApiClient.OnConnectionFailedListener zac;

        public zaa(int i, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zaa = i;
            this.zab = googleApiClient;
            this.zac = onConnectionFailedListener;
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String.valueOf(connectionResult).length();
            zai.this.zab(connectionResult, this.zaa);
        }
    }

    private zai(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zai zaa(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(lifecycleActivity);
        zai zai = (zai) fragment.getCallbackOrNull("AutoManageHelper", zai.class);
        if (zai != null) {
            return zai;
        }
        return new zai(fragment);
    }

    @Nullable
    private final zaa zab(int i) {
        if (this.zad.size() <= i) {
            return null;
        }
        SparseArray<zaa> sparseArray = this.zad;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(zab.zaa);
                printWriter.println(":");
                zab.zab.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zak, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        String.valueOf(this.zad).length();
        if (this.zab.get() == null) {
            for (int i = 0; i < this.zad.size(); i++) {
                zaa zab = zab(i);
                if (zab != null) {
                    zab.zab.connect();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zak, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                zab.zab.disconnect();
            }
        }
    }

    public final void zaa(int i, GoogleApiClient googleApiClient, @Nullable GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.zad.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        Preconditions.checkState(z, sb.toString());
        zam zam = this.zab.get();
        String.valueOf(zam).length();
        zaa zaa2 = new zaa(i, googleApiClient, onConnectionFailedListener);
        googleApiClient.registerConnectionFailedListener(zaa2);
        this.zad.put(i, zaa2);
        if (this.zaa && zam == null) {
            String.valueOf(googleApiClient).length();
            googleApiClient.connect();
        }
    }

    public final void zaa(int i) {
        zaa zaa2 = this.zad.get(i);
        this.zad.remove(i);
        if (zaa2 != null) {
            zaa2.zab.unregisterConnectionFailedListener(zaa2);
            zaa2.zab.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zak
    public final void zaa(ConnectionResult connectionResult, int i) {
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zaa zaa2 = this.zad.get(i);
        if (zaa2 != null) {
            zaa(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zaa2.zac;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zak
    public final void zaa() {
        for (int i = 0; i < this.zad.size(); i++) {
            zaa zab = zab(i);
            if (zab != null) {
                zab.zab.connect();
            }
        }
    }
}
