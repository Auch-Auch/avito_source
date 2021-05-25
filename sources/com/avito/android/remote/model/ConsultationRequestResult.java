package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/ConsultationRequestResult;", "", "<init>", "()V", "Failure", "Ok", "PhoneNeedVerification", "Lcom/avito/android/remote/model/ConsultationRequestResult$Ok;", "Lcom/avito/android/remote/model/ConsultationRequestResult$Failure;", "Lcom/avito/android/remote/model/ConsultationRequestResult$PhoneNeedVerification;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class ConsultationRequestResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/ConsultationRequestResult$Failure;", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends ConsultationRequestResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/ConsultationRequestResult$Ok;", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "", "successToastMessage", "Ljava/lang/String;", "getSuccessToastMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ok extends ConsultationRequestResult {
        @Nullable
        private final String successToastMessage;

        public Ok() {
            this(null, 1, null);
        }

        public Ok(@Nullable String str) {
            super(null);
            this.successToastMessage = str;
        }

        @Nullable
        public final String getSuccessToastMessage() {
            return this.successToastMessage;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Ok(String str, int i, j jVar) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/ConsultationRequestResult$PhoneNeedVerification;", "Lcom/avito/android/remote/model/ConsultationRequestResult;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneNeedVerification extends ConsultationRequestResult {
        @SerializedName("message")
        @NotNull
        private final String message;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhoneNeedVerification(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }
    }

    private ConsultationRequestResult() {
    }

    public /* synthetic */ ConsultationRequestResult(j jVar) {
        this();
    }
}
