package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0001\t\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", AuthSource.BOOKING_ORDER, "getMessage", "message", "ActionCompleted", "Approved", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "FinallyRejected", "Incomplete", "Initial", "Pending", "Ready", "TemporarilyDeclined", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Ready;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Initial;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Incomplete;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Pending;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$TemporarilyDeclined;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$FinallyRejected;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Approved;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$ActionCompleted;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSSDKState {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0004R%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000e¨\u0006+"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$ActionCompleted;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "", "component1", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component2", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "Lcom/sumsub/sns/core/data/model/AnswerType;", "component3", "()Lcom/sumsub/sns/core/data/model/AnswerType;", "", "", "component4", "()Ljava/util/Map;", "actionId", "type", "answer", "payload", "copy", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Lcom/sumsub/sns/core/data/model/AnswerType;Ljava/util/Map;)Lcom/sumsub/sns/core/data/model/SNSSDKState$ActionCompleted;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getType", "e", "Lcom/sumsub/sns/core/data/model/AnswerType;", "getAnswer", "c", "Ljava/lang/String;", "getActionId", "f", "Ljava/util/Map;", "getPayload", "<init>", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Lcom/sumsub/sns/core/data/model/AnswerType;Ljava/util/Map;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActionCompleted extends SNSSDKState {
        @NotNull
        public final String c;
        @NotNull
        public final FlowActionType d;
        @Nullable
        public final AnswerType e;
        @NotNull
        public final Map<String, Object> f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActionCompleted(@NotNull String str, @NotNull FlowActionType flowActionType, @Nullable AnswerType answerType, @NotNull Map<String, ? extends Object> map) {
            super("Flow Action", null);
            Intrinsics.checkNotNullParameter(str, "actionId");
            Intrinsics.checkNotNullParameter(flowActionType, "type");
            Intrinsics.checkNotNullParameter(map, "payload");
            this.c = str;
            this.d = flowActionType;
            this.e = answerType;
            this.f = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.SNSSDKState$ActionCompleted */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ActionCompleted copy$default(ActionCompleted actionCompleted, String str, FlowActionType flowActionType, AnswerType answerType, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = actionCompleted.c;
            }
            if ((i & 2) != 0) {
                flowActionType = actionCompleted.d;
            }
            if ((i & 4) != 0) {
                answerType = actionCompleted.e;
            }
            if ((i & 8) != 0) {
                map = actionCompleted.f;
            }
            return actionCompleted.copy(str, flowActionType, answerType, map);
        }

        @NotNull
        public final String component1() {
            return this.c;
        }

        @NotNull
        public final FlowActionType component2() {
            return this.d;
        }

        @Nullable
        public final AnswerType component3() {
            return this.e;
        }

        @NotNull
        public final Map<String, Object> component4() {
            return this.f;
        }

        @NotNull
        public final ActionCompleted copy(@NotNull String str, @NotNull FlowActionType flowActionType, @Nullable AnswerType answerType, @NotNull Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "actionId");
            Intrinsics.checkNotNullParameter(flowActionType, "type");
            Intrinsics.checkNotNullParameter(map, "payload");
            return new ActionCompleted(str, flowActionType, answerType, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCompleted)) {
                return false;
            }
            ActionCompleted actionCompleted = (ActionCompleted) obj;
            return Intrinsics.areEqual(this.c, actionCompleted.c) && Intrinsics.areEqual(this.d, actionCompleted.d) && Intrinsics.areEqual(this.e, actionCompleted.e) && Intrinsics.areEqual(this.f, actionCompleted.f);
        }

        @NotNull
        public final String getActionId() {
            return this.c;
        }

        @Nullable
        public final AnswerType getAnswer() {
            return this.e;
        }

        @NotNull
        public final Map<String, Object> getPayload() {
            return this.f;
        }

        @NotNull
        public final FlowActionType getType() {
            return this.d;
        }

        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            FlowActionType flowActionType = this.d;
            int hashCode2 = (hashCode + (flowActionType != null ? flowActionType.hashCode() : 0)) * 31;
            AnswerType answerType = this.e;
            int hashCode3 = (hashCode2 + (answerType != null ? answerType.hashCode() : 0)) * 31;
            Map<String, Object> map = this.f;
            if (map != null) {
                i = map.hashCode();
            }
            return hashCode3 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("ActionCompleted(actionId=");
            L.append(this.c);
            L.append(", type=");
            L.append(this.d);
            L.append(", answer=");
            L.append(this.e);
            L.append(", payload=");
            return a.x(L, this.f, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionCompleted(String str, FlowActionType flowActionType, AnswerType answerType, Map map, int i, j jVar) {
            this(str, flowActionType, (i & 4) != 0 ? null : answerType, (i & 8) != 0 ? r.emptyMap() : map);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Approved;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Approved extends SNSSDKState {
        @NotNull
        public static final Approved INSTANCE = new Approved();

        public Approved() {
            super("Applicant has been approved", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\t\n\u000b\f\r\u000e\u000fR!\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "c", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "ApplicantMisconfigured", "ApplicantNotFound", "InitialLoadingFailed", "InvalidParameters", NativeProtocol.ERROR_NETWORK_ERROR, "Unauthorized", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantNotFound;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantMisconfigured;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InitialLoadingFailed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InvalidParameters;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unauthorized;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unknown;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Failed extends SNSSDKState {
        @Nullable
        public final Exception c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantMisconfigured;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class ApplicantMisconfigured extends Failed {
            @NotNull
            public static final ApplicantMisconfigured INSTANCE = new ApplicantMisconfigured();

            public ApplicantMisconfigured() {
                super("Applicant is found, but is misconfigured (most likely lacks of idDocs)", (Exception) null, 2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$ApplicantNotFound;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class ApplicantNotFound extends Failed {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ApplicantNotFound(@NotNull Exception exc) {
                super("No applicant is found for the given parameters", exc, (j) null);
                Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InitialLoadingFailed;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class InitialLoadingFailed extends Failed {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InitialLoadingFailed(@NotNull Exception exc) {
                super("An error while initial loading the SDK", exc, (j) null);
                Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$InvalidParameters;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "", "", "messages", "<init>", "(Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class InvalidParameters extends Failed {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InvalidParameters(@NotNull List<String> list) {
                super("An attempt to setup with invalid parameters.\n" + CollectionsKt___CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, null, 62, null), (Exception) null, 2);
                Intrinsics.checkNotNullParameter(list, "messages");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$NetworkError;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class NetworkError extends Failed {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NetworkError(@NotNull Exception exc) {
                super("A network error occured (the user will be presented with Network Oops screen)", exc, (j) null);
                Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unauthorized;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unauthorized extends Failed {
            @NotNull
            public static final Unauthorized INSTANCE = new Unauthorized();

            public Unauthorized() {
                super("Your token isn't valid or the SDK can't refresh your token. Do you have a valid token updater?", (Exception) null, 2);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed$Unknown;", "Lcom/sumsub/sns/core/data/model/SNSSDKState$Failed;", "Ljava/lang/Exception;", "Lkotlin/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Unknown extends Failed {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Unknown(@NotNull Exception exc) {
                super("Unknown error", exc, (j) null);
                Intrinsics.checkNotNullParameter(exc, OkListener.KEY_EXCEPTION);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(String str, Exception exc, int i) {
            super(str, null);
            int i2 = i & 2;
            this.c = null;
        }

        @Nullable
        public final Exception getException() {
            return this.c;
        }

        public Failed(String str, Exception exc, j jVar) {
            super(str, null);
            this.c = exc;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$FinallyRejected;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FinallyRejected extends SNSSDKState {
        @NotNull
        public static final FinallyRejected INSTANCE = new FinallyRejected();

        public FinallyRejected() {
            super("Applicant has been finally rejected", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Incomplete;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Incomplete extends SNSSDKState {
        @NotNull
        public static final Incomplete INSTANCE = new Incomplete();

        public Incomplete() {
            super("Some but not all verification steps are passed over", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Initial;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Initial extends SNSSDKState {
        @NotNull
        public static final Initial INSTANCE = new Initial();

        public Initial() {
            super("No verification steps are passed yet", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Pending;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Pending extends SNSSDKState {
        @NotNull
        public static final Pending INSTANCE = new Pending();

        public Pending() {
            super("Verification is in pending state", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$Ready;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Ready extends SNSSDKState {
        @NotNull
        public static final Ready INSTANCE = new Ready();

        public Ready() {
            super("SDK is ready", null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSDKState$TemporarilyDeclined;", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class TemporarilyDeclined extends SNSSDKState {
        @NotNull
        public static final TemporarilyDeclined INSTANCE = new TemporarilyDeclined();

        public TemporarilyDeclined() {
            super("Applicant has been declined temporarily", null);
        }
    }

    public SNSSDKState(String str, j jVar) {
        this.b = str;
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        this.a = simpleName == null ? "" : simpleName;
    }

    @NotNull
    public final String getMessage() {
        return this.b;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }
}
