package com.avito.android.remote.model;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u0011\u0010\u0001\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0005\"\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0005\"\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0005¨\u0006\u000b"}, d2 = {"Landroid/net/Uri;", "appendAutotekaUtmQueryParams", "(Landroid/net/Uri;)Landroid/net/Uri;", "", "UTM_CAMPAIGN_VALUE", "Ljava/lang/String;", "UTM_SOURCE_VALUE", "UTM_CAMPAIGN_KEY", "UTM_SOURCE_KEY", "UTM_MEDIUM_VALUE", "UTM_MEDIUM_KEY", "models_release"}, k = 2, mv = {1, 4, 2})
public final class AutotekaTeaserItemResponseKt {
    private static final String UTM_CAMPAIGN_KEY = "utm_campaign";
    private static final String UTM_CAMPAIGN_VALUE = "teaser";
    private static final String UTM_MEDIUM_KEY = "utm_medium";
    private static final String UTM_MEDIUM_VALUE = "referral";
    private static final String UTM_SOURCE_KEY = "utm_source";
    private static final String UTM_SOURCE_VALUE = "avito_android";

    @NotNull
    public static final Uri appendAutotekaUtmQueryParams(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "$this$appendAutotekaUtmQueryParams");
        Uri build = uri.buildUpon().appendQueryParameter("utm_source", UTM_SOURCE_VALUE).appendQueryParameter("utm_medium", UTM_MEDIUM_VALUE).appendQueryParameter("utm_campaign", "teaser").build();
        Intrinsics.checkNotNullExpressionValue(build, "buildUpon()\n    .appendQ…PAIGN_VALUE)\n    .build()");
        return build;
    }
}
