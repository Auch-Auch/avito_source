package ru.sravni.android.bankproduct.utils.svg.entity;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.utils.svg.ILogoLoadCallback;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getLogoUrl", "()Ljava/lang/String;", "logoUrl", "Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "getLogoLoadCallback", "()Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;", "logoLoadCallback", "<init>", "(Ljava/lang/String;Lru/sravni/android/bankproduct/utils/svg/ILogoLoadCallback;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class LogoInfo {
    @Nullable
    public final String a;
    @NotNull
    public final ILogoLoadCallback b;

    public LogoInfo(@Nullable String str, @NotNull ILogoLoadCallback iLogoLoadCallback) {
        Intrinsics.checkParameterIsNotNull(iLogoLoadCallback, "logoLoadCallback");
        this.a = str;
        this.b = iLogoLoadCallback;
    }

    @NotNull
    public final ILogoLoadCallback getLogoLoadCallback() {
        return this.b;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogoInfo(String str, ILogoLoadCallback iLogoLoadCallback, int i, j jVar) {
        this((i & 1) != 0 ? null : str, iLogoLoadCallback);
    }
}
