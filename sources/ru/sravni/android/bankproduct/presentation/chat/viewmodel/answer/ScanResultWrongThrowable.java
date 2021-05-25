package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.component.scan.passport.ScanResultStatus;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ScanResultWrongThrowable;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getScanMessage", "()Ljava/lang/String;", "scanMessage", "Lru/sravni/android/bankproduct/presentation/component/scan/passport/ScanResultStatus;", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/component/scan/passport/ScanResultStatus;", "getScanCode", "()Lru/sravni/android/bankproduct/presentation/component/scan/passport/ScanResultStatus;", "scanCode", "<init>", "(Lru/sravni/android/bankproduct/presentation/component/scan/passport/ScanResultStatus;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ScanResultWrongThrowable extends Throwable {
    @NotNull
    public final ScanResultStatus a;
    @Nullable
    public final String b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanResultWrongThrowable(ScanResultStatus scanResultStatus, String str, int i, j jVar) {
        this(scanResultStatus, (i & 2) != 0 ? null : str);
    }

    @NotNull
    public final ScanResultStatus getScanCode() {
        return this.a;
    }

    @Nullable
    public final String getScanMessage() {
        return this.b;
    }

    public ScanResultWrongThrowable(@NotNull ScanResultStatus scanResultStatus, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(scanResultStatus, "scanCode");
        this.a = scanResultStatus;
        this.b = str;
    }
}
