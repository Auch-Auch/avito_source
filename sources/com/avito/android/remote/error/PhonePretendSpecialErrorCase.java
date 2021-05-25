package com.avito.android.remote.error;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Error;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0019\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010R4\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase;", "Lcom/avito/android/remote/error/SpecialCase;", "", "", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/Error;", "Lcom/avito/android/remote/error/TypedError;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getSpecialCases", "()Ljava/util/Map;", "specialCases", "Lkotlin/Function0;", "Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;", "verificationDataProvider", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "PhoneVerificationData", "api_release"}, k = 1, mv = {1, 4, 2})
public final class PhonePretendSpecialErrorCase implements SpecialCase {
    @NotNull
    public final Map<Integer, Function1<Error, TypedError>> a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/error/PhonePretendSpecialErrorCase$PhoneVerificationData;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "", AuthSource.BOOKING_ORDER, "Z", "isCompany", "()Z", "<init>", "(Ljava/lang/String;Z)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneVerificationData {
        @NotNull
        public final String a;
        public final boolean b;

        public PhoneVerificationData(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
            this.b = z;
        }

        @NotNull
        public final String getPhone() {
            return this.a;
        }

        public final boolean isCompany() {
            return this.b;
        }
    }

    public static final class a extends Lambda implements Function1<Error, PhoneVerificationError> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(1);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public PhoneVerificationError invoke(Error error) {
            Intrinsics.checkNotNullParameter(error, "<anonymous parameter 0>");
            Function0 function0 = this.a;
            return new PhoneVerificationError(function0 != null ? (PhoneVerificationData) function0.invoke() : null);
        }
    }

    public PhonePretendSpecialErrorCase() {
        this(null, 1, null);
    }

    public PhonePretendSpecialErrorCase(@Nullable Function0<PhoneVerificationData> function0) {
        this.a = q.mapOf(TuplesKt.to(404, new a(function0)));
    }

    @Override // com.avito.android.remote.error.SpecialCase
    @NotNull
    public Map<Integer, Function1<Error, TypedError>> getSpecialCases() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhonePretendSpecialErrorCase(Function0 function0, int i, j jVar) {
        this((i & 1) != 0 ? null : function0);
    }
}
