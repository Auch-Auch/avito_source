package com.avito.android.remote.interceptor;

import com.avito.android.preferences.FingerprintStorage;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00048\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000f\u001a\u0004\u0018\u00010\u00048V@\u0016X\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u0013\u001a\u00020\u00108\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/interceptor/FingerprintHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "Lcom/avito/android/preferences/FingerprintStorage;", "fingerprintStorage", "", "getFingerprint", "(Lcom/avito/android/preferences/FingerprintStorage;)Ljava/lang/String;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", AuthSource.BOOKING_ORDER, "Lkotlin/Lazy;", "getValue", "value", "", "c", "Z", "isMandatory", "()Z", "<init>", "(Lcom/avito/android/preferences/FingerprintStorage;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class FingerprintHeaderProvider implements HeaderProvider {
    @NotNull
    public final String a = "f";
    @Nullable
    public final Lazy b;
    public final boolean c;

    public static final class a extends Lambda implements Function0<String> {
        public final /* synthetic */ FingerprintHeaderProvider a;
        public final /* synthetic */ FingerprintStorage b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FingerprintHeaderProvider fingerprintHeaderProvider, FingerprintStorage fingerprintStorage) {
            super(0);
            this.a = fingerprintHeaderProvider;
            this.b = fingerprintStorage;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public String invoke() {
            return this.a.getFingerprint(this.b);
        }
    }

    public FingerprintHeaderProvider(@NotNull FingerprintStorage fingerprintStorage) {
        Intrinsics.checkNotNullParameter(fingerprintStorage, "fingerprintStorage");
        this.b = c.lazy(new a(this, fingerprintStorage));
        this.c = true;
    }

    @NotNull
    public final String getFingerprint(@NotNull FingerprintStorage fingerprintStorage) {
        Intrinsics.checkNotNullParameter(fingerprintStorage, "fingerprintStorage");
        String fingerprint = fingerprintStorage.getFingerprint();
        if (fingerprint == null || fingerprint.length() == 0) {
            return "empty";
        }
        return fingerprint.toString();
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.a;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        return (String) this.b.getValue();
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return this.c;
    }
}
