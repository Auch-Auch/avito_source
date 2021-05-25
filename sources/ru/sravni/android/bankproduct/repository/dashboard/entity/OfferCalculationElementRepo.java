package ru.sravni.android.bankproduct.repository.dashboard.entity;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u0019\u0010%\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006¨\u0006("}, d2 = {"Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "", "", "c", "Ljava/lang/String;", "getCreditName", "()Ljava/lang/String;", "creditName", "e", "getCreditTitle", "creditTitle", AuthSource.BOOKING_ORDER, "getDate", Sort.DATE, "", "f", "I", "getOfferCount", "()I", "offerCount", g.a, "getRequestSend", "requestSend", "i", "getRequestCountTitle", "requestCountTitle", "d", "getProductName", AnalyticFieldsName.productName, AuthSource.SEND_ABUSE, "getConversationId", AnalyticFieldsName.conversationID, "j", "getSavedSearchID", "savedSearchID", "h", "getOfferCountTitle", "offerCountTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferCalculationElementRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @NotNull
    public final String e;
    public final int f;
    public final int g;
    @NotNull
    public final String h;
    @NotNull
    public final String i;
    @NotNull
    public final String j;

    public OfferCalculationElementRepo(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull String str5, int i2, int i3, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        Intrinsics.checkParameterIsNotNull(str2, Sort.DATE);
        Intrinsics.checkParameterIsNotNull(str3, "creditName");
        Intrinsics.checkParameterIsNotNull(str5, "creditTitle");
        Intrinsics.checkParameterIsNotNull(str6, "offerCountTitle");
        Intrinsics.checkParameterIsNotNull(str7, "requestCountTitle");
        Intrinsics.checkParameterIsNotNull(str8, "savedSearchID");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i2;
        this.g = i3;
        this.h = str6;
        this.i = str7;
        this.j = str8;
    }

    @NotNull
    public final String getConversationId() {
        return this.a;
    }

    @NotNull
    public final String getCreditName() {
        return this.c;
    }

    @NotNull
    public final String getCreditTitle() {
        return this.e;
    }

    @NotNull
    public final String getDate() {
        return this.b;
    }

    public final int getOfferCount() {
        return this.f;
    }

    @NotNull
    public final String getOfferCountTitle() {
        return this.h;
    }

    @Nullable
    public final String getProductName() {
        return this.d;
    }

    @NotNull
    public final String getRequestCountTitle() {
        return this.i;
    }

    public final int getRequestSend() {
        return this.g;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.j;
    }
}
