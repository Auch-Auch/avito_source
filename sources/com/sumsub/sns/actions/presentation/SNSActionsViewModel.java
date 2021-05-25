package com.sumsub.sns.actions.presentation;

import a2.g.r.g;
import android.content.Intent;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.actions.R;
import com.sumsub.sns.actions.domain.GetActionByIdUseCase;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.SNSModule;
import com.sumsub.sns.core.common.SNSConstants;
import com.sumsub.sns.core.data.model.Action;
import com.sumsub.sns.core.data.model.AnswerType;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.data.model.SNSLivenessResult;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.model.VideoRequiredType;
import com.sumsub.sns.core.domain.GetConfigUseCase;
import com.sumsub.sns.core.domain.SetSdkStateUseCase;
import com.sumsub.sns.core.domain.model.Either;
import com.sumsub.sns.core.presentation.base.ActionLiveData;
import com.sumsub.sns.core.presentation.base.Event;
import com.sumsub.sns.core.presentation.base.SNSBaseViewModel;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.q;
import t6.r.a.j;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003JKLB'\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\bH\u0010IJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010$R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0019\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b;\u0010\u0016R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010$R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010$R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0019\u0010G\u001a\b\u0012\u0004\u0012\u00020?0\u00128F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010\u0016¨\u0006M"}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel;", "Lcom/sumsub/sns/core/presentation/base/SNSBaseViewModel;", "", "onLoad", "()V", "", "resultCode", "Landroid/content/Intent;", "data", "onHandleActionResult", "(ILandroid/content/Intent;)V", "Lcom/sumsub/sns/core/data/model/Action;", "action", "Lcom/sumsub/sns/core/data/model/Action;", "getAction", "()Lcom/sumsub/sns/core/data/model/Action;", "setAction", "(Lcom/sumsub/sns/core/data/model/Action;)V", "Landroidx/lifecycle/LiveData;", "Lcom/sumsub/sns/core/presentation/base/Event;", "Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$LivenessParams;", "getShowPassiveLiveness3d", "()Landroidx/lifecycle/LiveData;", "showPassiveLiveness3d", "Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Error;", "getError", "error", "", "getShowResult", "showResult", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "k", "Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "_showPassiveLiveness3dActionLiveData", "Landroidx/lifecycle/MutableLiveData;", "j", "Landroidx/lifecycle/MutableLiveData;", "_showResultLiveData", "Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase;", "getActionByIdUseCase", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "n", "Lcom/sumsub/sns/core/domain/GetConfigUseCase;", "getConfigUseCase", "Lcom/sumsub/sns/core/data/model/AppConfig;", Navigation.CONFIG, "Lcom/sumsub/sns/core/data/model/AppConfig;", "getConfig", "()Lcom/sumsub/sns/core/data/model/AppConfig;", "setConfig", "(Lcom/sumsub/sns/core/data/model/AppConfig;)V", "i", "_showErrorLiveData", "Lcom/sumsub/sns/core/domain/SetSdkStateUseCase;", "o", "Lcom/sumsub/sns/core/domain/SetSdkStateUseCase;", "setSdkStateUseCase", "getShowError", "showError", g.a, "_errorLiveData", "Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Result;", "h", "_resultLiveData", "Landroidx/lifecycle/SavedStateHandle;", "l", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "getResult", "result", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Lcom/sumsub/sns/actions/domain/GetActionByIdUseCase;Lcom/sumsub/sns/core/domain/GetConfigUseCase;Lcom/sumsub/sns/core/domain/SetSdkStateUseCase;)V", "Error", "LivenessParams", "Result", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
public final class SNSActionsViewModel extends SNSBaseViewModel {
    public Action action;
    public AppConfig config;
    public final MutableLiveData<Error> g = new MutableLiveData<>();
    public final MutableLiveData<Result> h = new MutableLiveData<>();
    public final MutableLiveData<Boolean> i = new MutableLiveData<>();
    public final MutableLiveData<Boolean> j = new MutableLiveData<>();
    public final ActionLiveData<Event<LivenessParams>> k = new ActionLiveData<>();
    public final SavedStateHandle l;
    public final GetActionByIdUseCase m;
    public final GetConfigUseCase n;
    public final SetSdkStateUseCase o;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Error;", "", "", "component1", "()I", "component2", "title", MessengerShareContentUtility.SUBTITLE, "copy", "(II)Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Error;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getSubtitle", AuthSource.SEND_ABUSE, "getTitle", "<init>", "(II)V", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error {
        public final int a;
        public final int b;

        public Error(@StringRes int i, @StringRes int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ Error copy$default(Error error, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = error.a;
            }
            if ((i3 & 2) != 0) {
                i2 = error.b;
            }
            return error.copy(i, i2);
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final Error copy(@StringRes int i, @StringRes int i2) {
            return new Error(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return this.a == error.a && this.b == error.b;
        }

        public final int getSubtitle() {
            return this.b;
        }

        public final int getTitle() {
            return this.a;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Error(title=");
            L.append(this.a);
            L.append(", subtitle=");
            return a2.b.a.a.a.j(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$LivenessParams;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component3", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "idDocSetType", "actionId", "actionType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;)Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$LivenessParams;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getActionType", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getActionId", AuthSource.SEND_ABUSE, "getIdDocSetType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;)V", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
    public static final class LivenessParams {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final FlowActionType c;

        public LivenessParams(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType) {
            Intrinsics.checkNotNullParameter(str, "idDocSetType");
            Intrinsics.checkNotNullParameter(str2, "actionId");
            Intrinsics.checkNotNullParameter(flowActionType, "actionType");
            this.a = str;
            this.b = str2;
            this.c = flowActionType;
        }

        public static /* synthetic */ LivenessParams copy$default(LivenessParams livenessParams, String str, String str2, FlowActionType flowActionType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = livenessParams.a;
            }
            if ((i & 2) != 0) {
                str2 = livenessParams.b;
            }
            if ((i & 4) != 0) {
                flowActionType = livenessParams.c;
            }
            return livenessParams.copy(str, str2, flowActionType);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final FlowActionType component3() {
            return this.c;
        }

        @NotNull
        public final LivenessParams copy(@NotNull String str, @NotNull String str2, @NotNull FlowActionType flowActionType) {
            Intrinsics.checkNotNullParameter(str, "idDocSetType");
            Intrinsics.checkNotNullParameter(str2, "actionId");
            Intrinsics.checkNotNullParameter(flowActionType, "actionType");
            return new LivenessParams(str, str2, flowActionType);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LivenessParams)) {
                return false;
            }
            LivenessParams livenessParams = (LivenessParams) obj;
            return Intrinsics.areEqual(this.a, livenessParams.a) && Intrinsics.areEqual(this.b, livenessParams.b) && Intrinsics.areEqual(this.c, livenessParams.c);
        }

        @NotNull
        public final String getActionId() {
            return this.b;
        }

        @NotNull
        public final FlowActionType getActionType() {
            return this.c;
        }

        @NotNull
        public final String getIdDocSetType() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            FlowActionType flowActionType = this.c;
            if (flowActionType != null) {
                i = flowActionType.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("LivenessParams(idDocSetType=");
            L.append(this.a);
            L.append(", actionId=");
            L.append(this.b);
            L.append(", actionType=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0006\u001a\u00020\u00022\b\b\u0003\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Result;", "", "", "component1", "()I", "component2", "iconId", "message", "copy", "(II)Lcom/sumsub/sns/actions/presentation/SNSActionsViewModel$Result;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getIconId", AuthSource.BOOKING_ORDER, "getMessage", "<init>", "(II)V", "idensic-mobile-sdk-actions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Result {
        public final int a;
        public final int b;

        public Result(@DrawableRes int i, @StringRes int i2) {
            this.a = i;
            this.b = i2;
        }

        public static /* synthetic */ Result copy$default(Result result, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = result.a;
            }
            if ((i3 & 2) != 0) {
                i2 = result.b;
            }
            return result.copy(i, i2);
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final Result copy(@DrawableRes int i, @StringRes int i2) {
            return new Result(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Result)) {
                return false;
            }
            Result result = (Result) obj;
            return this.a == result.a && this.b == result.b;
        }

        public final int getIconId() {
            return this.a;
        }

        public final int getMessage() {
            return this.b;
        }

        public int hashCode() {
            return (this.a * 31) + this.b;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Result(iconId=");
            L.append(this.a);
            L.append(", message=");
            return a2.b.a.a.a.j(L, this.b, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Result(int i, int i2, int i3, j jVar) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FlowActionType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            FlowActionType flowActionType = FlowActionType.FaceEnrollment;
            iArr[1] = 1;
            FlowActionType.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[1] = 1;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.actions.presentation.SNSActionsViewModel$onHandleActionResult$1", f = "SNSActionsViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int b;
        public final /* synthetic */ SNSActionsViewModel c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Intent e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSActionsViewModel sNSActionsViewModel, int i, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.c = sNSActionsViewModel;
            this.d = i;
            this.e = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new a(this.c, this.d, this.e, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new a(this.c, this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.c.l.get(SNSConstants.Arguments.ARGS_ACTION_ID);
                if (str == null) {
                    str = "<unknown>";
                }
                Intrinsics.checkNotNullExpressionValue(str, "savedStateHandle.get<Str…ACTION_ID) ?: \"<unknown>\"");
                GetActionByIdUseCase getActionByIdUseCase = this.c.m;
                GetActionByIdUseCase.Params params = new GetActionByIdUseCase.Params(str, false, 2, null);
                this.b = 1;
                obj = getActionByIdUseCase.run(params, (Continuation<? super Either<? extends Exception, Action>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Either either = (Either) obj;
            if (either instanceof Either.Left) {
                SNSActionsViewModel.access$onDataLoadedError(this.c, (Exception) ((Either.Left) either).getA());
            } else if (either instanceof Either.Right) {
                this.c.setAction((Action) ((Either.Right) either).getB());
                SNSActionsViewModel sNSActionsViewModel = this.c;
                SNSActionsViewModel.access$handleResult(sNSActionsViewModel, sNSActionsViewModel.getAction(), this.d, this.e);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.actions.presentation.SNSActionsViewModel$onLoad$1", f = "SNSActionsViewModel.kt", i = {}, l = {75, 76}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object b;
        public int c;
        public final /* synthetic */ SNSActionsViewModel d;
        public final /* synthetic */ String e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SNSActionsViewModel sNSActionsViewModel, String str, Continuation continuation) {
            super(2, continuation);
            this.d = sNSActionsViewModel;
            this.e = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new b(this.d, this.e, continuation);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            return new b(this.d, this.e, continuation2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x007b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r6.c
                r2 = 1
                r3 = 2
                if (r1 == 0) goto L_0x0022
                if (r1 == r2) goto L_0x001a
                if (r1 != r3) goto L_0x0012
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x0065
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                java.lang.Object r1 = r6.b
                com.sumsub.sns.actions.presentation.SNSActionsViewModel r1 = (com.sumsub.sns.actions.presentation.SNSActionsViewModel) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x003b
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r7)
                com.sumsub.sns.actions.presentation.SNSActionsViewModel r1 = r6.d
                com.sumsub.sns.core.domain.GetConfigUseCase r7 = com.sumsub.sns.actions.presentation.SNSActionsViewModel.access$getGetConfigUseCase$p(r1)
                com.sumsub.sns.core.domain.GetConfigUseCase$Params r4 = new com.sumsub.sns.core.domain.GetConfigUseCase$Params
                r4.<init>()
                r6.b = r1
                r6.c = r2
                java.lang.Object r7 = r7.run(r4, r6)
                if (r7 != r0) goto L_0x003b
                return r0
            L_0x003b:
                java.lang.String r2 = "null cannot be cast to non-null type com.sumsub.sns.core.domain.model.Either.Right<com.sumsub.sns.core.data.model.AppConfig>"
                java.util.Objects.requireNonNull(r7, r2)
                com.sumsub.sns.core.domain.model.Either$Right r7 = (com.sumsub.sns.core.domain.model.Either.Right) r7
                java.lang.Object r7 = r7.getB()
                com.sumsub.sns.core.data.model.AppConfig r7 = (com.sumsub.sns.core.data.model.AppConfig) r7
                r1.setConfig(r7)
                com.sumsub.sns.actions.presentation.SNSActionsViewModel r7 = r6.d
                com.sumsub.sns.actions.domain.GetActionByIdUseCase r7 = com.sumsub.sns.actions.presentation.SNSActionsViewModel.access$getGetActionByIdUseCase$p(r7)
                com.sumsub.sns.actions.domain.GetActionByIdUseCase$Params r1 = new com.sumsub.sns.actions.domain.GetActionByIdUseCase$Params
                java.lang.String r2 = r6.e
                r4 = 0
                r5 = 0
                r1.<init>(r2, r4, r3, r5)
                r6.b = r5
                r6.c = r3
                java.lang.Object r7 = r7.run(r1, r6)
                if (r7 != r0) goto L_0x0065
                return r0
            L_0x0065:
                com.sumsub.sns.core.domain.model.Either r7 = (com.sumsub.sns.core.domain.model.Either) r7
                com.sumsub.sns.actions.presentation.SNSActionsViewModel r0 = r6.d
                boolean r1 = r7.isRight()
                if (r1 == 0) goto L_0x007b
                com.sumsub.sns.core.domain.model.Either$Right r7 = (com.sumsub.sns.core.domain.model.Either.Right) r7
                java.lang.Object r7 = r7.getB()
                com.sumsub.sns.core.data.model.Action r7 = (com.sumsub.sns.core.data.model.Action) r7
                com.sumsub.sns.actions.presentation.SNSActionsViewModel.access$onDataLoadedSuccess(r0, r7)
                goto L_0x008c
            L_0x007b:
                boolean r1 = r7.isLeft()
                if (r1 == 0) goto L_0x008c
                com.sumsub.sns.core.domain.model.Either$Left r7 = (com.sumsub.sns.core.domain.model.Either.Left) r7
                java.lang.Object r7 = r7.getA()
                java.lang.Exception r7 = (java.lang.Exception) r7
                com.sumsub.sns.actions.presentation.SNSActionsViewModel.access$onDataLoadedError(r0, r7)
            L_0x008c:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.actions.presentation.SNSActionsViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SNSActionsViewModel(@NotNull SavedStateHandle savedStateHandle, @NotNull GetActionByIdUseCase getActionByIdUseCase, @NotNull GetConfigUseCase getConfigUseCase, @NotNull SetSdkStateUseCase setSdkStateUseCase) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(getActionByIdUseCase, "getActionByIdUseCase");
        Intrinsics.checkNotNullParameter(getConfigUseCase, "getConfigUseCase");
        Intrinsics.checkNotNullParameter(setSdkStateUseCase, "setSdkStateUseCase");
        this.l = savedStateHandle;
        this.m = getActionByIdUseCase;
        this.n = getConfigUseCase;
        this.o = setSdkStateUseCase;
        Timber.i("Actions is created", new Object[0]);
    }

    public static final void access$handleResult(SNSActionsViewModel sNSActionsViewModel, Action action2, int i2, Intent intent) {
        Objects.requireNonNull(sNSActionsViewModel);
        AnswerType answerType = null;
        if (i2 == 0) {
            SNSLivenessResult sNSLivenessResult = intent != null ? (SNSLivenessResult) intent.getParcelableExtra("EXTRA_RESULT") : null;
            if (!(sNSLivenessResult instanceof SNSLivenessResult.FaceDetection) && (sNSLivenessResult instanceof SNSLivenessResult.FaceAuth)) {
                answerType = ((SNSLivenessResult.FaceAuth) sNSLivenessResult).getAnswer();
            }
            c(sNSActionsViewModel, new SNSSDKState.ActionCompleted(action2.getId(), action2.getType(), answerType, null, 8, null), SNSCompletionResult.SuccessTermination.INSTANCE, 0, 4);
        } else if (action2.getType().ordinal() != 1) {
            StringBuilder L = a2.b.a.a.a.L("Unknown flow type(");
            L.append(action2.getType());
            c(sNSActionsViewModel, new SNSSDKState.Failed.Unknown(new UnsupportedOperationException(L.toString())), new SNSCompletionResult.AbnormalTermination(null, 1, null), 0, 4);
        } else {
            SNSLivenessResult sNSLivenessResult2 = intent != null ? (SNSLivenessResult) intent.getParcelableExtra("EXTRA_RESULT") : null;
            if (!(sNSLivenessResult2 instanceof SNSLivenessResult.FaceAuth)) {
                sNSLivenessResult2 = null;
            }
            SNSLivenessResult.FaceAuth faceAuth = (SNSLivenessResult.FaceAuth) sNSLivenessResult2;
            if (faceAuth == null) {
                c(sNSActionsViewModel, new SNSSDKState.Failed.Unknown(new IllegalArgumentException("The result from the Passive Liveness is nullable")), new SNSCompletionResult.AbnormalTermination(null, 1, null), 0, 4);
                return;
            }
            SNSLivenessReason reason = faceAuth.getReason();
            if (!(reason instanceof SNSLivenessReason.VeritifcationSuccessfully) && !(reason instanceof SNSLivenessReason.CompletedUnsuccessfullyAllowContinue)) {
                Action action3 = sNSActionsViewModel.action;
                if (action3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("action");
                }
                String id = action3.getId();
                Action action4 = sNSActionsViewModel.action;
                if (action4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("action");
                }
                c(sNSActionsViewModel, new SNSSDKState.ActionCompleted(id, action4.getType(), null, q.mapOf(TuplesKt.to("reason", reason)), 4, null), new SNSCompletionResult.AbnormalTermination(null, 1, null), 0, 4);
                return;
            }
            Action action5 = sNSActionsViewModel.action;
            if (action5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
            }
            String id2 = action5.getId();
            Action action6 = sNSActionsViewModel.action;
            if (action6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
            }
            c(sNSActionsViewModel, new SNSSDKState.ActionCompleted(id2, action6.getType(), faceAuth.getAnswer(), q.mapOf(TuplesKt.to("reason", reason))), SNSCompletionResult.SuccessTermination.INSTANCE, 0, 4);
        }
    }

    public static final void access$onDataLoadedError(SNSActionsViewModel sNSActionsViewModel, Exception exc) {
        Error error;
        sNSActionsViewModel.get_showProgressLiveData().setValue(Boolean.FALSE);
        if (exc instanceof SNSException.Network) {
            error = new Error(R.string.sns_oops_network_title, R.string.sns_oops_network_html);
        } else {
            error = new Error(R.string.sns_oops_fatal_title, R.string.sns_oops_fatal_html);
        }
        sNSActionsViewModel.i.setValue(Boolean.TRUE);
        sNSActionsViewModel.g.setValue(error);
    }

    public static final void access$onDataLoadedSuccess(SNSActionsViewModel sNSActionsViewModel, Action action2) {
        T t;
        sNSActionsViewModel.get_showProgressLiveData().setValue(Boolean.FALSE);
        sNSActionsViewModel.action = action2;
        if (action2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        if (action2.getType().ordinal() != 1) {
            StringBuilder L = a2.b.a.a.a.L("Unknown flow type(");
            Action action3 = sNSActionsViewModel.action;
            if (action3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("action");
            }
            L.append(action3.getType());
            c(sNSActionsViewModel, new SNSSDKState.Failed.Unknown(new UnsupportedOperationException(L.toString())), new SNSCompletionResult.AbnormalTermination(null, 1, null), 0, 4);
            return;
        }
        Action action4 = sNSActionsViewModel.action;
        if (action4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        Iterator<T> it = action4.getDocSets().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (t.getIdDocSetType().isSelfie()) {
                break;
            }
        }
        T t2 = t;
        if (t2 == null) {
            c(sNSActionsViewModel, new SNSSDKState.Failed.InvalidParameters(d.listOf("Invalid document set type")), new SNSCompletionResult.AbnormalTermination(null, 1, null), 0, 4);
            return;
        }
        boolean isModuleAvailable = SNSMobileSDK.INSTANCE.isModuleAvailable(SNSModule.SNSProoface);
        if (!VideoRequiredType.m225equalsimpl0(t2.m194getVideoRequiredu2aduso(), VideoRequiredType.Companion.m232getPassiveLivenessu2aduso()) || !isModuleAvailable) {
            StringBuilder Q = a2.b.a.a.a.Q("Do you enable liveness module? ", "\nVideoRequired: ");
            Q.append(VideoRequiredType.m227toStringimpl(t2.m194getVideoRequiredu2aduso()));
            Q.append(", ");
            Q.append("\nPassive Liveness3d: ");
            Q.append(isModuleAvailable);
            String sb = Q.toString();
            c(sNSActionsViewModel, new SNSSDKState.Failed.InvalidParameters(d.listOf(sb)), new SNSCompletionResult.AbnormalTermination(new IllegalArgumentException(sb)), 0, 4);
            return;
        }
        ActionLiveData<Event<LivenessParams>> actionLiveData = sNSActionsViewModel.k;
        String value = t2.getIdDocSetType().getValue();
        Action action5 = sNSActionsViewModel.action;
        if (action5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        String id = action5.getId();
        Action action6 = sNSActionsViewModel.action;
        if (action6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        actionLiveData.setValue(new Event<>(new LivenessParams(value, id, action6.getType())));
    }

    public static void c(SNSActionsViewModel sNSActionsViewModel, SNSSDKState sNSSDKState, SNSCompletionResult sNSCompletionResult, long j2, int i2) {
        if ((i2 & 2) != 0) {
            sNSCompletionResult = SNSCompletionResult.SuccessTermination.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(sNSActionsViewModel), null, null, new a2.q.a.a.a.a(sNSActionsViewModel, sNSSDKState, j2, sNSCompletionResult, null), 3, null);
    }

    @NotNull
    public final Action getAction() {
        Action action2 = this.action;
        if (action2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
        }
        return action2;
    }

    @NotNull
    public final AppConfig getConfig() {
        AppConfig appConfig = this.config;
        if (appConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Navigation.CONFIG);
        }
        return appConfig;
    }

    @NotNull
    public final LiveData<Error> getError() {
        return this.g;
    }

    @NotNull
    public final LiveData<Result> getResult() {
        return this.h;
    }

    @NotNull
    public final LiveData<Boolean> getShowError() {
        return this.i;
    }

    @NotNull
    public final LiveData<Event<LivenessParams>> getShowPassiveLiveness3d() {
        return this.k;
    }

    @NotNull
    public final LiveData<Boolean> getShowResult() {
        return this.j;
    }

    public final void onHandleActionResult(int i2, @Nullable Intent intent) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new a(this, i2, intent, null), 3, null);
    }

    public final void onLoad() {
        get_showProgressLiveData().setValue(Boolean.TRUE);
        MutableLiveData<Boolean> mutableLiveData = this.i;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(bool);
        this.j.setValue(bool);
        String str = (String) this.l.get(SNSConstants.Arguments.ARGS_ACTION_ID);
        if (str == null) {
            str = "<unknown>";
        }
        Intrinsics.checkNotNullExpressionValue(str, "savedStateHandle.get<Str…ACTION_ID) ?: \"<unknown>\"");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new b(this, str, null), 3, null);
    }

    public final void setAction(@NotNull Action action2) {
        Intrinsics.checkNotNullParameter(action2, "<set-?>");
        this.action = action2;
    }

    public final void setConfig(@NotNull AppConfig appConfig) {
        Intrinsics.checkNotNullParameter(appConfig, "<set-?>");
        this.config = appConfig;
    }
}
