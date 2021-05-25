package com.avito.android.deep_linking.links;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/UTMLink;", "", "", "getUtmSource", "()Ljava/lang/String;", "utmSource", "getUtmCampaign", "utmCampaign", "getUtmMedium", "utmMedium", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public interface UTMLink {
    @NotNull
    public static final Companion Companion = Companion.a;
    @NotNull
    public static final String UTM_CAMPAIGN_KEY = "utm_campaign";
    @NotNull
    public static final String UTM_MEDIUM_KEY = "utm_medium";
    @NotNull
    public static final String UTM_SOURCE_KEY = "utm_source";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/deep_linking/links/UTMLink$Companion;", "", "", "UTM_CAMPAIGN_KEY", "Ljava/lang/String;", "UTM_SOURCE_KEY", "UTM_MEDIUM_KEY", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        @NotNull
        public static final String UTM_CAMPAIGN_KEY = "utm_campaign";
        @NotNull
        public static final String UTM_MEDIUM_KEY = "utm_medium";
        @NotNull
        public static final String UTM_SOURCE_KEY = "utm_source";
        public static final /* synthetic */ Companion a = new Companion();
    }

    @Nullable
    String getUtmCampaign();

    @Nullable
    String getUtmMedium();

    @Nullable
    String getUtmSource();
}
