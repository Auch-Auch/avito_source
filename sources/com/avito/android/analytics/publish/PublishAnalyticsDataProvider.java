package com.avito.android.analytics.publish;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.webview.analytics.WebViewAnalyticsInteractorKt;
import java.util.Map;
import java.util.Objects;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00038F@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00038F@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "", "Lkotlin/Pair;", "", "getSessionIdKeyValue", "()Lkotlin/Pair;", "", "getCommonAnalyticsParameters", "()Ljava/util/Map;", "d", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "itemId", AuthSource.SEND_ABUSE, "getSessionId", "setSessionId", "sessionId", AuthSource.BOOKING_ORDER, "getSelectedWizardId", "setSelectedWizardId", "selectedWizardId", "Lcom/avito/android/analytics/publish/FromPage;", "c", "Lcom/avito/android/analytics/publish/FromPage;", "getFromPage", "()Lcom/avito/android/analytics/publish/FromPage;", "setFromPage", "(Lcom/avito/android/analytics/publish/FromPage;)V", "fromPage", "", "e", "Ljava/lang/Integer;", "getTrackedCategory", "()Ljava/lang/Integer;", "setTrackedCategory", "(Ljava/lang/Integer;)V", "trackedCategory", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAnalyticsDataProvider {
    @NotNull
    public String a = "";
    @NotNull
    public String b = "";
    @NotNull
    public FromPage c = FromPage.ITEM_ADD;
    @Nullable
    public String d;
    @Nullable
    public Integer e;

    @NotNull
    public final Map<String, String> getCommonAnalyticsParameters() {
        boolean z = false;
        String name = this.c.name();
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = name.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        Map<String, String> mutableMapOf = r.mutableMapOf(getSessionIdKeyValue(), TuplesKt.to(WebViewAnalyticsInteractorKt.FROM_PAGE_KEY, lowerCase));
        String str = this.d;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            String str2 = this.d;
            Intrinsics.checkNotNull(str2);
            mutableMapOf.put("iid", str2);
        }
        return mutableMapOf;
    }

    @NotNull
    public final FromPage getFromPage() {
        return this.c;
    }

    @Nullable
    public final String getItemId() {
        return this.d;
    }

    @NotNull
    public final String getSelectedWizardId() {
        if (!(this.b.length() == 0)) {
            return this.b;
        }
        Logs.error$default("PublishAnalyticsDataProvider", "Read empty wizard Id", null, 4, null);
        return "ERROR_EMPTY_WIZARD_ID";
    }

    @NotNull
    public final String getSessionId() {
        if (!(this.a.length() == 0)) {
            return this.a;
        }
        Logs.error$default("PublishAnalyticsDataProvider", "Read not generated Id", null, 4, null);
        return "ERROR_NOT_GENERATED_ID";
    }

    @NotNull
    public final Pair<String, String> getSessionIdKeyValue() {
        return TuplesKt.to("esid", getSessionId());
    }

    @Nullable
    public final Integer getTrackedCategory() {
        return this.e;
    }

    public final void setFromPage(@NotNull FromPage fromPage) {
        Intrinsics.checkNotNullParameter(fromPage, "<set-?>");
        this.c = fromPage;
    }

    public final void setItemId(@Nullable String str) {
        this.d = str;
    }

    public final void setSelectedWizardId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.b = str;
    }

    public final void setSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public final void setTrackedCategory(@Nullable Integer num) {
        this.e = num;
    }
}
