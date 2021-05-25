package com.sumsub.sns.core.data.model.remote;

import com.google.gson.Gson;
import com.sumsub.sns.core.data.model.AppConfig;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.FlowType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteConfig;", "Lcom/sumsub/sns/core/data/model/AppConfig;", "toConfig", "(Lcom/sumsub/sns/core/data/model/remote/RemoteConfig;)Lcom/sumsub/sns/core/data/model/AppConfig;", "sns-core_release"}, k = 2, mv = {1, 4, 2})
public final class RemoteConfigKt {
    @NotNull
    public static final AppConfig toConfig(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "$this$toConfig");
        String applicantId = remoteConfig.getApplicantId();
        String actionId = remoteConfig.getActionId();
        FlowActionType actionType = remoteConfig.getActionType();
        if (actionType == null) {
            actionType = FlowActionType.None;
        }
        FlowType flowType = remoteConfig.getFlowType();
        if (flowType == null) {
            flowType = FlowType.Standalone;
        }
        String flowName = remoteConfig.getFlowName();
        String idDocSetType = remoteConfig.getIdDocSetType();
        String faceLivenessLic = remoteConfig.getFaceLivenessLic();
        String str = faceLivenessLic != null ? faceLivenessLic : "";
        String facemapPublicKey = remoteConfig.getFacemapPublicKey();
        String str2 = facemapPublicKey != null ? facemapPublicKey : "";
        Map<String, Object> sdkDict = remoteConfig.getSdkDict();
        if (!(sdkDict instanceof Map)) {
            sdkDict = null;
        }
        Map<String, Object> documentsByCountries = remoteConfig.getDocumentsByCountries();
        String json = documentsByCountries != null ? new Gson().toJson(documentsByCountries) : null;
        Map<String, Object> uiConf = remoteConfig.getUiConf();
        return new AppConfig(applicantId, false, false, flowType, flowName, idDocSetType, actionId, actionType, str, str2, sdkDict, json, uiConf != null ? new Gson().toJson(uiConf) : null);
    }
}
