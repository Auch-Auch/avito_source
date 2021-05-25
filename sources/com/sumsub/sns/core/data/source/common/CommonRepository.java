package com.sumsub.sns.core.data.source.common;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.core.data.model.Action;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.Applicant;
import com.sumsub.sns.core.data.model.SNSSDKState;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ%\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\bJ'\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000eJ\u001b\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H¦@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0018H¦@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001f\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ!\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H¦@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/sumsub/sns/core/data/source/common/CommonRepository;", "", "", "id", "", "force", "Lcom/sumsub/sns/core/data/model/Applicant;", "getApplicantById", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/sumsub/sns/core/data/model/Action;", "getActionById", "applicantId", ChannelContext.Item.USER_ID, "getAccessToken", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flowName", "Lcom/sumsub/sns/core/data/model/AppConfig;", "getConfig", "language", "", "getStringResources", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "setApplicantLanguage", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "state", "setSDKState", "(Lcom/sumsub/sns/core/data/model/SNSSDKState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSDKState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/Locale;", "getLocale", "getClientIntegrationSettings", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface CommonRepository {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Object getActionById$default(CommonRepository commonRepository, String str, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return commonRepository.getActionById(str, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActionById");
        }

        public static /* synthetic */ Object getApplicantById$default(CommonRepository commonRepository, String str, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return commonRepository.getApplicantById(str, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getApplicantById");
        }

        public static /* synthetic */ Object getConfig$default(CommonRepository commonRepository, String str, boolean z, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return commonRepository.getConfig(str, z, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfig");
        }

        @Nullable
        public static Object getLocale(@NotNull CommonRepository commonRepository, @NotNull Continuation<? super Locale> continuation) {
            return SNSMobileSDK.INSTANCE.getLocale();
        }
    }

    @Nullable
    Object getAccessToken(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super String> continuation);

    @Nullable
    Object getActionById(@NotNull String str, boolean z, @NotNull Continuation<? super Action> continuation);

    @Nullable
    Object getApplicantById(@NotNull String str, boolean z, @NotNull Continuation<? super Applicant> continuation);

    @Nullable
    Object getClientIntegrationSettings(@NotNull Continuation<? super Map<String, ? extends Object>> continuation);

    @Nullable
    Object getConfig(@NotNull String str, boolean z, @NotNull Continuation<? super AppConfig> continuation);

    @Nullable
    Object getLocale(@NotNull Continuation<? super Locale> continuation);

    @Nullable
    Object getSDKState(@NotNull Continuation<? super SNSSDKState> continuation);

    @Nullable
    Object getStringResources(@NotNull String str, @NotNull Continuation<? super Map<String, ? extends Object>> continuation);

    @Nullable
    Object setApplicantLanguage(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object setSDKState(@NotNull SNSSDKState sNSSDKState, @NotNull Continuation<? super Unit> continuation);
}
