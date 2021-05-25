package com.sumsub.sns.core.data.model.remote;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.data.model.FlowActionType;
import com.sumsub.sns.core.data.model.FlowType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002¢\u0006\u0004\b9\u0010:J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0005J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0005J´\u0001\u0010 \u001a\u00020\u00002\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\"\u0010\u0007J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b+\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010*\u001a\u0004\b,\u0010\u0007R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010*\u001a\u0004\b-\u0010\u0007R*\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010.\u001a\u0004\b/\u0010\u0005R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b0\u0010\u0007R\u001c\u0010\u0016\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b1\u0010\u0007R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b2\u0010\u0007R*\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b3\u0010\u0005R(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b4\u0010\u0005R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00105\u001a\u0004\b6\u0010\u000bR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\b8\u0010\u0010¨\u0006;"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/RemoteConfig;", "", "", "", "component1", "()Ljava/util/Map;", "component2", "()Ljava/lang/String;", "component3", "Lcom/sumsub/sns/core/data/model/FlowType;", "component4", "()Lcom/sumsub/sns/core/data/model/FlowType;", "component5", "component6", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "component7", "()Lcom/sumsub/sns/core/data/model/FlowActionType;", "component8", "component9", "component10", "component11", "uiConf", "applicantId", "flowName", "flowType", "idDocSetType", "actionId", "actionType", "faceLivenessLic", "facemapPublicKey", "sdkDict", "documentsByCountries", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lcom/sumsub/sns/core/data/model/remote/RemoteConfig;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFaceLivenessLic", "getActionId", "getFacemapPublicKey", "Ljava/util/Map;", "getDocumentsByCountries", "getFlowName", "getApplicantId", "getIdDocSetType", "getUiConf", "getSdkDict", "Lcom/sumsub/sns/core/data/model/FlowType;", "getFlowType", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "getActionType", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowType;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/FlowActionType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteConfig {
    @SerializedName("actionId")
    @Nullable
    private final String actionId;
    @SerializedName("actionType")
    @Nullable
    private final FlowActionType actionType;
    @SerializedName("applicantId")
    @NotNull
    private final String applicantId;
    @SerializedName("documentsByCountries")
    @Nullable
    private final Map<String, Object> documentsByCountries;
    @SerializedName("faceLivenessLic")
    @Nullable
    private final String faceLivenessLic;
    @SerializedName("facemapPublicKey")
    @Nullable
    private final String facemapPublicKey;
    @SerializedName("flowName")
    @Nullable
    private final String flowName;
    @SerializedName("flowType")
    @Nullable
    private final FlowType flowType;
    @SerializedName("idDocSetType")
    @Nullable
    private final String idDocSetType;
    @SerializedName("sdkDict")
    @NotNull
    private final Map<String, Object> sdkDict;
    @SerializedName("uiConf")
    @Nullable
    private final Map<String, Object> uiConf;

    public RemoteConfig(@Nullable Map<String, ? extends Object> map, @NotNull String str, @Nullable String str2, @Nullable FlowType flowType2, @Nullable String str3, @Nullable String str4, @Nullable FlowActionType flowActionType, @Nullable String str5, @Nullable String str6, @NotNull Map<String, ? extends Object> map2, @Nullable Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(str, "applicantId");
        Intrinsics.checkNotNullParameter(map2, "sdkDict");
        this.uiConf = map;
        this.applicantId = str;
        this.flowName = str2;
        this.flowType = flowType2;
        this.idDocSetType = str3;
        this.actionId = str4;
        this.actionType = flowActionType;
        this.faceLivenessLic = str5;
        this.facemapPublicKey = str6;
        this.sdkDict = map2;
        this.documentsByCountries = map3;
    }

    public static /* synthetic */ RemoteConfig copy$default(RemoteConfig remoteConfig, Map map, String str, String str2, FlowType flowType2, String str3, String str4, FlowActionType flowActionType, String str5, String str6, Map map2, Map map3, int i, Object obj) {
        return remoteConfig.copy((i & 1) != 0 ? remoteConfig.uiConf : map, (i & 2) != 0 ? remoteConfig.applicantId : str, (i & 4) != 0 ? remoteConfig.flowName : str2, (i & 8) != 0 ? remoteConfig.flowType : flowType2, (i & 16) != 0 ? remoteConfig.idDocSetType : str3, (i & 32) != 0 ? remoteConfig.actionId : str4, (i & 64) != 0 ? remoteConfig.actionType : flowActionType, (i & 128) != 0 ? remoteConfig.faceLivenessLic : str5, (i & 256) != 0 ? remoteConfig.facemapPublicKey : str6, (i & 512) != 0 ? remoteConfig.sdkDict : map2, (i & 1024) != 0 ? remoteConfig.documentsByCountries : map3);
    }

    @Nullable
    public final Map<String, Object> component1() {
        return this.uiConf;
    }

    @NotNull
    public final Map<String, Object> component10() {
        return this.sdkDict;
    }

    @Nullable
    public final Map<String, Object> component11() {
        return this.documentsByCountries;
    }

    @NotNull
    public final String component2() {
        return this.applicantId;
    }

    @Nullable
    public final String component3() {
        return this.flowName;
    }

    @Nullable
    public final FlowType component4() {
        return this.flowType;
    }

    @Nullable
    public final String component5() {
        return this.idDocSetType;
    }

    @Nullable
    public final String component6() {
        return this.actionId;
    }

    @Nullable
    public final FlowActionType component7() {
        return this.actionType;
    }

    @Nullable
    public final String component8() {
        return this.faceLivenessLic;
    }

    @Nullable
    public final String component9() {
        return this.facemapPublicKey;
    }

    @NotNull
    public final RemoteConfig copy(@Nullable Map<String, ? extends Object> map, @NotNull String str, @Nullable String str2, @Nullable FlowType flowType2, @Nullable String str3, @Nullable String str4, @Nullable FlowActionType flowActionType, @Nullable String str5, @Nullable String str6, @NotNull Map<String, ? extends Object> map2, @Nullable Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(str, "applicantId");
        Intrinsics.checkNotNullParameter(map2, "sdkDict");
        return new RemoteConfig(map, str, str2, flowType2, str3, str4, flowActionType, str5, str6, map2, map3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfig)) {
            return false;
        }
        RemoteConfig remoteConfig = (RemoteConfig) obj;
        return Intrinsics.areEqual(this.uiConf, remoteConfig.uiConf) && Intrinsics.areEqual(this.applicantId, remoteConfig.applicantId) && Intrinsics.areEqual(this.flowName, remoteConfig.flowName) && Intrinsics.areEqual(this.flowType, remoteConfig.flowType) && Intrinsics.areEqual(this.idDocSetType, remoteConfig.idDocSetType) && Intrinsics.areEqual(this.actionId, remoteConfig.actionId) && Intrinsics.areEqual(this.actionType, remoteConfig.actionType) && Intrinsics.areEqual(this.faceLivenessLic, remoteConfig.faceLivenessLic) && Intrinsics.areEqual(this.facemapPublicKey, remoteConfig.facemapPublicKey) && Intrinsics.areEqual(this.sdkDict, remoteConfig.sdkDict) && Intrinsics.areEqual(this.documentsByCountries, remoteConfig.documentsByCountries);
    }

    @Nullable
    public final String getActionId() {
        return this.actionId;
    }

    @Nullable
    public final FlowActionType getActionType() {
        return this.actionType;
    }

    @NotNull
    public final String getApplicantId() {
        return this.applicantId;
    }

    @Nullable
    public final Map<String, Object> getDocumentsByCountries() {
        return this.documentsByCountries;
    }

    @Nullable
    public final String getFaceLivenessLic() {
        return this.faceLivenessLic;
    }

    @Nullable
    public final String getFacemapPublicKey() {
        return this.facemapPublicKey;
    }

    @Nullable
    public final String getFlowName() {
        return this.flowName;
    }

    @Nullable
    public final FlowType getFlowType() {
        return this.flowType;
    }

    @Nullable
    public final String getIdDocSetType() {
        return this.idDocSetType;
    }

    @NotNull
    public final Map<String, Object> getSdkDict() {
        return this.sdkDict;
    }

    @Nullable
    public final Map<String, Object> getUiConf() {
        return this.uiConf;
    }

    public int hashCode() {
        Map<String, Object> map = this.uiConf;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        String str = this.applicantId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.flowName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        FlowType flowType2 = this.flowType;
        int hashCode4 = (hashCode3 + (flowType2 != null ? flowType2.hashCode() : 0)) * 31;
        String str3 = this.idDocSetType;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.actionId;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        FlowActionType flowActionType = this.actionType;
        int hashCode7 = (hashCode6 + (flowActionType != null ? flowActionType.hashCode() : 0)) * 31;
        String str5 = this.faceLivenessLic;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.facemapPublicKey;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Map<String, Object> map2 = this.sdkDict;
        int hashCode10 = (hashCode9 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<String, Object> map3 = this.documentsByCountries;
        if (map3 != null) {
            i = map3.hashCode();
        }
        return hashCode10 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RemoteConfig(uiConf=");
        L.append(this.uiConf);
        L.append(", applicantId=");
        L.append(this.applicantId);
        L.append(", flowName=");
        L.append(this.flowName);
        L.append(", flowType=");
        L.append(this.flowType);
        L.append(", idDocSetType=");
        L.append(this.idDocSetType);
        L.append(", actionId=");
        L.append(this.actionId);
        L.append(", actionType=");
        L.append(this.actionType);
        L.append(", faceLivenessLic=");
        L.append(this.faceLivenessLic);
        L.append(", facemapPublicKey=");
        L.append(this.facemapPublicKey);
        L.append(", sdkDict=");
        L.append(this.sdkDict);
        L.append(", documentsByCountries=");
        return a.x(L, this.documentsByCountries, ")");
    }
}
