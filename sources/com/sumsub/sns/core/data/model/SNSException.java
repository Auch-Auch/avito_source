package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\t\n\u000bR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getWrap", "()Ljava/lang/Throwable;", "wrap", "Api", "Network", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/sumsub/sns/core/data/model/SNSException$Api;", "Lcom/sumsub/sns/core/data/model/SNSException$Network;", "Lcom/sumsub/sns/core/data/model/SNSException$Unknown;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSException extends Exception {
    @Nullable
    public final Throwable a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u0007¨\u0006("}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Api;", "Lcom/sumsub/sns/core/data/model/SNSException;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "description", "code", "correlationId", CommonKt.TAG_ERROR_CODE, "errorName", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/SNSException$Api;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getCorrelationId", "e", "Ljava/lang/Integer;", "getErrorCode", AuthSource.BOOKING_ORDER, "getDescription", "f", "getErrorName", "c", "getCode", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Api extends SNSException {
        @Nullable
        public final String b;
        @Nullable
        public final Integer c;
        @Nullable
        public final String d;
        @Nullable
        public final Integer e;
        @Nullable
        public final String f;

        public Api(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
            super(new Exception(str), null);
            this.b = str;
            this.c = num;
            this.d = str2;
            this.e = num2;
            this.f = str3;
        }

        public static /* synthetic */ Api copy$default(Api api, String str, Integer num, String str2, Integer num2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = api.b;
            }
            if ((i & 2) != 0) {
                num = api.c;
            }
            if ((i & 4) != 0) {
                str2 = api.d;
            }
            if ((i & 8) != 0) {
                num2 = api.e;
            }
            if ((i & 16) != 0) {
                str3 = api.f;
            }
            return api.copy(str, num, str2, num2, str3);
        }

        @Nullable
        public final String component1() {
            return this.b;
        }

        @Nullable
        public final Integer component2() {
            return this.c;
        }

        @Nullable
        public final String component3() {
            return this.d;
        }

        @Nullable
        public final Integer component4() {
            return this.e;
        }

        @Nullable
        public final String component5() {
            return this.f;
        }

        @NotNull
        public final Api copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Integer num2, @Nullable String str3) {
            return new Api(str, num, str2, num2, str3);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Api)) {
                return false;
            }
            Api api = (Api) obj;
            return Intrinsics.areEqual(this.b, api.b) && Intrinsics.areEqual(this.c, api.c) && Intrinsics.areEqual(this.d, api.d) && Intrinsics.areEqual(this.e, api.e) && Intrinsics.areEqual(this.f, api.f);
        }

        @Nullable
        public final Integer getCode() {
            return this.c;
        }

        @Nullable
        public final String getCorrelationId() {
            return this.d;
        }

        @Nullable
        public final String getDescription() {
            return this.b;
        }

        @Nullable
        public final Integer getErrorCode() {
            return this.e;
        }

        @Nullable
        public final String getErrorName() {
            return this.f;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.b;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.c;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str2 = this.d;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Integer num2 = this.e;
            int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str3 = this.f;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Api(description=");
            L.append(this.b);
            L.append(", code=");
            L.append(this.c);
            L.append(", correlationId=");
            L.append(this.d);
            L.append(", errorCode=");
            L.append(this.e);
            L.append(", errorName=");
            return a.t(L, this.f, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Network;", "Lcom/sumsub/sns/core/data/model/SNSException;", "", "wrap", "<init>", "(Ljava/lang/Throwable;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Network extends SNSException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Network(@NotNull Throwable th) {
            super(th, null);
            Intrinsics.checkNotNullParameter(th, "wrap");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSException$Unknown;", "Lcom/sumsub/sns/core/data/model/SNSException;", "", "wrap", "<init>", "(Ljava/lang/Throwable;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends SNSException {
        public Unknown() {
            this(null, 1, null);
        }

        public Unknown(@Nullable Throwable th) {
            super(th, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Unknown(Throwable th, int i, j jVar) {
            this((i & 1) != 0 ? null : th);
        }
    }

    public SNSException(Throwable th, j jVar) {
        super(th);
        this.a = th;
    }

    @Nullable
    public final Throwable getWrap() {
        return this.a;
    }
}
