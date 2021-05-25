package com.avito.konveyor;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.validation.ValidationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/konveyor/konveyorConfiguration;", "", "Lcom/avito/konveyor/validation/ValidationPolicy;", "policy", "", "setConfigurationPolicy", "(Lcom/avito/konveyor/validation/ValidationPolicy;)V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/validation/ValidationPolicy;", "getPolicy$konveyor_release", "()Lcom/avito/konveyor/validation/ValidationPolicy;", "setPolicy$konveyor_release", "<init>", "()V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class konveyorConfiguration {
    @NotNull
    public static final konveyorConfiguration INSTANCE = new konveyorConfiguration();
    @NotNull
    public static ValidationPolicy a = new a();

    public static final class a implements ValidationPolicy {
        public boolean a;

        @Override // com.avito.konveyor.validation.ValidationPolicy
        public boolean getValidateEagerly() {
            return this.a;
        }

        @Override // com.avito.konveyor.validation.ValidationPolicy
        public void setValidateEagerly(boolean z) {
            this.a = z;
        }
    }

    @NotNull
    public final ValidationPolicy getPolicy$konveyor_release() {
        return a;
    }

    public final void setConfigurationPolicy(@NotNull ValidationPolicy validationPolicy) {
        Intrinsics.checkNotNullParameter(validationPolicy, "policy");
        a = validationPolicy;
    }

    public final void setPolicy$konveyor_release(@NotNull ValidationPolicy validationPolicy) {
        Intrinsics.checkNotNullParameter(validationPolicy, "<set-?>");
        a = validationPolicy;
    }
}
