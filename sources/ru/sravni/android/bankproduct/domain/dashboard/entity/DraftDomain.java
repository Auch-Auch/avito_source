package ru.sravni.android.bankproduct.domain.dashboard.entity;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/entity/DraftDomain;", "", "", "c", "I", "getProgress", "()I", "progress", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getConversationID", "()Ljava/lang/String;", "conversationID", AuthSource.BOOKING_ORDER, "getProductName", AnalyticFieldsName.productName, "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DraftDomain {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;

    public DraftDomain(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, AnalyticFieldsName.productName);
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    @NotNull
    public final String getConversationID() {
        return this.a;
    }

    @NotNull
    public final String getProductName() {
        return this.b;
    }

    public final int getProgress() {
        return this.c;
    }
}
