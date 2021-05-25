package com.sumsub.sns.core.data.model.remote.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.common.SNSConstants;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;", "component3", "()Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;", "type", VKApiConst.LANG, "conf", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;)Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLang", "Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;", "getConf", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;)V", "Conf", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class StringResourcesResponse {
    @SerializedName("conf")
    @NotNull
    private final Conf conf;
    @SerializedName(VKApiConst.LANG)
    @NotNull
    private final String lang;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;", "", "", "component1", "()Ljava/lang/String;", "component2", SNSConstants.LinkType.GTC, SNSConstants.LinkType.PP, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/remote/response/StringResourcesResponse$Conf;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPp", "getGtc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Conf {
        @SerializedName(SNSConstants.LinkType.GTC)
        @NotNull
        private final String gtc;
        @SerializedName(SNSConstants.LinkType.PP)
        @NotNull
        private final String pp;

        public Conf(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, SNSConstants.LinkType.GTC);
            Intrinsics.checkNotNullParameter(str2, SNSConstants.LinkType.PP);
            this.gtc = str;
            this.pp = str2;
        }

        public static /* synthetic */ Conf copy$default(Conf conf, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = conf.gtc;
            }
            if ((i & 2) != 0) {
                str2 = conf.pp;
            }
            return conf.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.gtc;
        }

        @NotNull
        public final String component2() {
            return this.pp;
        }

        @NotNull
        public final Conf copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, SNSConstants.LinkType.GTC);
            Intrinsics.checkNotNullParameter(str2, SNSConstants.LinkType.PP);
            return new Conf(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Conf)) {
                return false;
            }
            Conf conf = (Conf) obj;
            return Intrinsics.areEqual(this.gtc, conf.gtc) && Intrinsics.areEqual(this.pp, conf.pp);
        }

        @NotNull
        public final String getGtc() {
            return this.gtc;
        }

        @NotNull
        public final String getPp() {
            return this.pp;
        }

        public int hashCode() {
            String str = this.gtc;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.pp;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Conf(gtc=");
            L.append(this.gtc);
            L.append(", pp=");
            return a.t(L, this.pp, ")");
        }
    }

    public StringResourcesResponse(@NotNull String str, @NotNull String str2, @NotNull Conf conf2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, VKApiConst.LANG);
        Intrinsics.checkNotNullParameter(conf2, "conf");
        this.type = str;
        this.lang = str2;
        this.conf = conf2;
    }

    public static /* synthetic */ StringResourcesResponse copy$default(StringResourcesResponse stringResourcesResponse, String str, String str2, Conf conf2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stringResourcesResponse.type;
        }
        if ((i & 2) != 0) {
            str2 = stringResourcesResponse.lang;
        }
        if ((i & 4) != 0) {
            conf2 = stringResourcesResponse.conf;
        }
        return stringResourcesResponse.copy(str, str2, conf2);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.lang;
    }

    @NotNull
    public final Conf component3() {
        return this.conf;
    }

    @NotNull
    public final StringResourcesResponse copy(@NotNull String str, @NotNull String str2, @NotNull Conf conf2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, VKApiConst.LANG);
        Intrinsics.checkNotNullParameter(conf2, "conf");
        return new StringResourcesResponse(str, str2, conf2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StringResourcesResponse)) {
            return false;
        }
        StringResourcesResponse stringResourcesResponse = (StringResourcesResponse) obj;
        return Intrinsics.areEqual(this.type, stringResourcesResponse.type) && Intrinsics.areEqual(this.lang, stringResourcesResponse.lang) && Intrinsics.areEqual(this.conf, stringResourcesResponse.conf);
    }

    @NotNull
    public final Conf getConf() {
        return this.conf;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lang;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Conf conf2 = this.conf;
        if (conf2 != null) {
            i = conf2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("StringResourcesResponse(type=");
        L.append(this.type);
        L.append(", lang=");
        L.append(this.lang);
        L.append(", conf=");
        L.append(this.conf);
        L.append(")");
        return L.toString();
    }
}
