package com.avito.android.passport_verification;

import androidx.annotation.WorkerThread;
import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.SNSSDKState;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\u0001\u0019J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00112\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u000bH&¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\rH&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModel;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/passport_verification/SnsSdkNavigation;", "sdkLaunchData", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "navigationEvents", "", "onTokenExpired", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "newState", "", "onSdkStateChange", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "state", "onSdkError", "(Ljava/lang/Exception;Lcom/sumsub/sns/core/data/model/SNSSDKState;)V", "onSdkSuccess", "clear", "()V", "Navigation", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
public interface PassportVerificationModel {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "", "<init>", "()V", "FinishWithChanges", "FinishWithError", "FinishWithNoChanges", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithNoChanges;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithError;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithChanges;", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Navigation {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithChanges;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "", AuthSource.SEND_ABUSE, "Z", "getWithSuccessMessage", "()Z", "withSuccessMessage", "<init>", "(Z)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishWithChanges extends Navigation {
            public final boolean a;

            public FinishWithChanges(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getWithSuccessMessage() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithError;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "", AuthSource.SEND_ABUSE, "Z", "getWithChanges", "()Z", "withChanges", "<init>", "(Z)V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishWithError extends Navigation {
            public final boolean a;

            public FinishWithError(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean getWithChanges() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation$FinishWithNoChanges;", "Lcom/avito/android/passport_verification/PassportVerificationModel$Navigation;", "<init>", "()V", "passport-verification_release"}, k = 1, mv = {1, 4, 2})
        public static final class FinishWithNoChanges extends Navigation {
            @NotNull
            public static final FinishWithNoChanges INSTANCE = new FinishWithNoChanges();

            public FinishWithNoChanges() {
                super(null);
            }
        }

        public Navigation() {
        }

        public Navigation(j jVar) {
        }
    }

    void clear();

    @NotNull
    Observable<Navigation> navigationEvents();

    void onSdkError(@Nullable Exception exc, @NotNull SNSSDKState sNSSDKState);

    void onSdkStateChange(@NotNull SNSSDKState sNSSDKState);

    void onSdkSuccess(@NotNull SNSSDKState sNSSDKState);

    @WorkerThread
    @NotNull
    String onTokenExpired();

    @NotNull
    Observable<SnsSdkNavigation> sdkLaunchData();
}
