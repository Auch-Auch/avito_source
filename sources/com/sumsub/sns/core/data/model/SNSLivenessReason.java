package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.NativeProtocol;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0011\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()¨\u0006*"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "Ljava/io/Serializable;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "CameraInitializationIssue", "CameraPermissionDenied", "CancelledByHostApplication", "CompletedUnsuccessfullyAllowContinue", "ContextSwitch", "InitializationError", "InvalideDeviceLicenseKeyIndetifier", "LicenseExpiredOrInvalid", "LockedOut", "MissingGuidanceImages", NativeProtocol.ERROR_NETWORK_ERROR, "PortraitRequired", "Timeout", "UnknownInternalError", "UserCancelled", "VeritifcationSuccessfully", "VersionDeprecated", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UserCancelled;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VeritifcationSuccessfully;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraPermissionDenied;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$PortraitRequired;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$Timeout;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$ContextSwitch;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraInitializationIssue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UnknownInternalError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LockedOut;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$MissingGuidanceImages;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CompletedUnsuccessfullyAllowContinue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CancelledByHostApplication;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VersionDeprecated;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LicenseExpiredOrInvalid;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InvalideDeviceLicenseKeyIndetifier;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InitializationError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason$NetworkError;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSLivenessReason implements Serializable {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraInitializationIssue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CameraInitializationIssue extends SNSLivenessReason {
        @NotNull
        public static final CameraInitializationIssue INSTANCE = new CameraInitializationIssue();

        public CameraInitializationIssue() {
            super("Session failed because of an unexpected camera error.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CameraPermissionDenied;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CameraPermissionDenied extends SNSLivenessReason {
        @NotNull
        public static final CameraPermissionDenied INSTANCE = new CameraPermissionDenied();

        public CameraPermissionDenied() {
            super("Camera is required but access prevented by user settings.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CancelledByHostApplication;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelledByHostApplication extends SNSLivenessReason {
        @NotNull
        public static final CancelledByHostApplication INSTANCE = new CancelledByHostApplication();

        public CancelledByHostApplication() {
            super("Canceled by host application", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$CompletedUnsuccessfullyAllowContinue;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class CompletedUnsuccessfullyAllowContinue extends SNSLivenessReason {
        @NotNull
        public static final CompletedUnsuccessfullyAllowContinue INSTANCE = new CompletedUnsuccessfullyAllowContinue();

        public CompletedUnsuccessfullyAllowContinue() {
            super("Session completed unsuccessfully but allows to continue", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$ContextSwitch;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ContextSwitch extends SNSLivenessReason {
        @NotNull
        public static final ContextSwitch INSTANCE = new ContextSwitch();

        public ContextSwitch() {
            super("Session cancelled because a Context Switch occurred during session.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InitializationError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "copy", "(Ljava/lang/Exception;)Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InitializationError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitializationError extends SNSLivenessReason {
        @NotNull
        public final Exception b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitializationError(@NotNull Exception exc) {
            super("Liveness initialization is failed", null);
            Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            this.b = exc;
        }

        public static /* synthetic */ InitializationError copy$default(InitializationError initializationError, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = initializationError.b;
            }
            return initializationError.copy(exc);
        }

        @NotNull
        public final Exception component1() {
            return this.b;
        }

        @NotNull
        public final InitializationError copy(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            return new InitializationError(exc);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InitializationError) && Intrinsics.areEqual(this.b, ((InitializationError) obj).b);
            }
            return true;
        }

        @NotNull
        public final Exception getException() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Exception exc = this.b;
            if (exc != null) {
                return exc.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("InitializationError(exception=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$InvalideDeviceLicenseKeyIndetifier;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class InvalideDeviceLicenseKeyIndetifier extends SNSLivenessReason {
        @NotNull
        public static final InvalideDeviceLicenseKeyIndetifier INSTANCE = new InvalideDeviceLicenseKeyIndetifier();

        public InvalideDeviceLicenseKeyIndetifier() {
            super("The Device License Key Identifier provided was invalid.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LicenseExpiredOrInvalid;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class LicenseExpiredOrInvalid extends SNSLivenessReason {
        @NotNull
        public static final LicenseExpiredOrInvalid INSTANCE = new LicenseExpiredOrInvalid();

        public LicenseExpiredOrInvalid() {
            super("License was expired, contained invalid text, or you are attempting to initialize in an App that is not specified in your license.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$LockedOut;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class LockedOut extends SNSLivenessReason {
        @NotNull
        public static final LockedOut INSTANCE = new LockedOut();

        public LockedOut() {
            super("ZoOm is in a lockout state.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$MissingGuidanceImages;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MissingGuidanceImages extends SNSLivenessReason {
        @NotNull
        public static final MissingGuidanceImages INSTANCE = new MissingGuidanceImages();

        public MissingGuidanceImages() {
            super("Session cancelled because guidance images were not provided.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u00020\u00002\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "component1", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "copy", "(Ljava/lang/Exception;)Lcom/sumsub/sns/core/data/model/SNSLivenessReason$NetworkError;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Exception;", "getException", "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkError extends SNSLivenessReason {
        @Nullable
        public final Exception b;

        public NetworkError() {
            this(null, 1, null);
        }

        public NetworkError(@Nullable Exception exc) {
            super("Network connectivity issue encountered.", null);
            this.b = exc;
        }

        public static /* synthetic */ NetworkError copy$default(NetworkError networkError, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = networkError.b;
            }
            return networkError.copy(exc);
        }

        @Nullable
        public final Exception component1() {
            return this.b;
        }

        @NotNull
        public final NetworkError copy(@Nullable Exception exc) {
            return new NetworkError(exc);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof NetworkError) && Intrinsics.areEqual(this.b, ((NetworkError) obj).b);
            }
            return true;
        }

        @Nullable
        public final Exception getException() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Exception exc = this.b;
            if (exc != null) {
                return exc.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("NetworkError(exception=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NetworkError(Exception exc, int i, j jVar) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$PortraitRequired;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class PortraitRequired extends SNSLivenessReason {
        @NotNull
        public static final PortraitRequired INSTANCE = new PortraitRequired();

        public PortraitRequired() {
            super("Portrait mode is required.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$Timeout;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Timeout extends SNSLivenessReason {
        @NotNull
        public static final Timeout INSTANCE = new Timeout();

        public Timeout() {
            super("Session cancelled due to timeout.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UnknownInternalError;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnknownInternalError extends SNSLivenessReason {
        @NotNull
        public static final UnknownInternalError INSTANCE = new UnknownInternalError();

        public UnknownInternalError() {
            super("Session failed because of an unhandled internal error.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$UserCancelled;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserCancelled extends SNSLivenessReason {
        @NotNull
        public static final UserCancelled INSTANCE = new UserCancelled();

        public UserCancelled() {
            super("User cancelled before completing session.", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VeritifcationSuccessfully;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class VeritifcationSuccessfully extends SNSLivenessReason {
        @NotNull
        public static final VeritifcationSuccessfully INSTANCE = new VeritifcationSuccessfully();

        public VeritifcationSuccessfully() {
            super("The Liveness session was performed successfully ", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessReason$VersionDeprecated;", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class VersionDeprecated extends SNSLivenessReason {
        @NotNull
        public static final VersionDeprecated INSTANCE = new VersionDeprecated();

        public VersionDeprecated() {
            super("Current version of SDK is deprecated.", null);
        }
    }

    public SNSLivenessReason(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getMessage() {
        return this.a;
    }
}
