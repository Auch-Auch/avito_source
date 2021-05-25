package com.google.android.gms.wallet;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.wallet.zzaa;
import com.google.android.gms.internal.wallet.zzab;
import com.google.android.gms.internal.wallet.zzh;
import com.google.android.gms.internal.wallet.zzs;
import com.google.android.gms.internal.wallet.zzv;
import com.google.android.gms.wallet.wobs.WalletObjects;
import java.util.Locale;
public final class Wallet {
    public static final Api<WalletOptions> API;
    private static final Api.ClientKey<zzv> CLIENT_KEY;
    private static final Api.AbstractClientBuilder<zzv, WalletOptions> zzeb;
    @Deprecated
    private static final zzz zzec = new zzs();
    private static final WalletObjects zzed = new zzaa();
    @ShowFirstParty
    private static final zzh zzee = new zzab();

    public static final class WalletOptions implements Api.ApiOptions.HasAccountOptions {
        @ShowFirstParty
        private final Account account;
        public final int environment;
        public final int theme;
        @VisibleForTesting
        public final boolean zzef;

        public static final class Builder {
            private int environment = 3;
            private int theme = 1;
            private boolean zzef = true;

            public final WalletOptions build() {
                return new WalletOptions(this, null);
            }

            public final Builder setEnvironment(int i) {
                if (i == 0 || i == 0 || i == 2 || i == 1 || i == 3) {
                    this.environment = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", Integer.valueOf(i)));
            }

            public final Builder setTheme(int i) {
                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    this.theme = i;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", Integer.valueOf(i)));
            }

            @Deprecated
            public final Builder useGoogleWallet() {
                this.zzef = false;
                return this;
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof WalletOptions)) {
                return false;
            }
            WalletOptions walletOptions = (WalletOptions) obj;
            if (!Objects.equal(Integer.valueOf(this.environment), Integer.valueOf(walletOptions.environment)) || !Objects.equal(Integer.valueOf(this.theme), Integer.valueOf(walletOptions.theme)) || !Objects.equal(null, null) || !Objects.equal(Boolean.valueOf(this.zzef), Boolean.valueOf(walletOptions.zzef))) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions
        public final Account getAccount() {
            return null;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.environment), Integer.valueOf(this.theme), null, Boolean.valueOf(this.zzef));
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.environment;
            this.theme = builder.theme;
            this.zzef = builder.zzef;
            this.account = null;
        }

        public /* synthetic */ WalletOptions(Builder builder, zzaj zzaj) {
            this(builder);
        }

        public /* synthetic */ WalletOptions(zzaj zzaj) {
            this();
        }
    }

    public static abstract class zza<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzv> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.API, googleApiClient);
        }

        @VisibleForTesting
        /* renamed from: zza */
        public abstract void doExecute(zzv zzv) throws RemoteException;
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.wallet.zzs, com.google.android.gms.wallet.zzz] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.internal.wallet.zzh, com.google.android.gms.internal.wallet.zzab] */
    static {
        Api.ClientKey<zzv> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zzaj zzaj = new zzaj();
        zzeb = zzaj;
        API = new Api<>("Wallet.API", zzaj, clientKey);
    }

    private Wallet() {
    }

    public static PaymentsClient getPaymentsClient(@NonNull Activity activity, @NonNull WalletOptions walletOptions) {
        return new PaymentsClient(activity, walletOptions);
    }

    public static WalletObjectsClient getWalletObjectsClient(@NonNull Activity activity, @Nullable WalletOptions walletOptions) {
        return new WalletObjectsClient(activity, walletOptions);
    }

    public static PaymentsClient getPaymentsClient(@NonNull Context context, @NonNull WalletOptions walletOptions) {
        return new PaymentsClient(context, walletOptions);
    }
}
