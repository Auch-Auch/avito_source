package com.avito.android.serp;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,\u0012\u0006\u0010J\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\b\u0010<\u001a\u0004\u0018\u000107\u0012\u0006\u0010R\u001a\u00020M\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010T\u001a\u00020\u001a\u0012\u0006\u0010L\u001a\u00020\u001a\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\u0006\u0010G\u001a\u00020\u001a\u0012\u0006\u0010+\u001a\u00020&\u0012\b\u00106\u001a\u0004\u0018\u000101\u0012\u0006\u0010]\u001a\u00020\u0003\u0012\b\b\u0002\u0010D\u001a\u00020\u001a\u0012\u0006\u0010c\u001a\u00020^¢\u0006\u0004\bd\u0010eR!\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007R\u001b\u00106\u001a\u0004\u0018\u0001018\u0006@\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010<\u001a\u0004\u0018\u0001078\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018R\"\u0010D\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b@\u0010\u001c\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010CR\u0019\u0010G\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u001c\u001a\u0004\bF\u0010\u001eR\u0019\u0010J\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010\u001c\u001a\u0004\bI\u0010\u001eR\u0019\u0010L\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010\u001c\u001a\u0004\bL\u0010\u001eR\u0019\u0010R\u001a\u00020M8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0019\u0010T\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010\u001c\u001a\u0004\bT\u0010\u001eR\u001b\u0010W\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010\u0010\u001a\u0004\bV\u0010\u0012R\u001b\u0010Z\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010\u0010\u001a\u0004\bY\u0010\u0012R\u0019\u0010]\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010\u0010\u001a\u0004\b\\\u0010\u0012R\u0019\u0010c\u001a\u00020^8\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lcom/avito/android/serp/SerpPresenterState;", "", "", "", "n", "Ljava/util/List;", "getShowedShortcutBannerIds", "()Ljava/util/List;", "showedShortcutBannerIds", "Lcom/avito/android/remote/model/SerpDisplayType;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "()Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "k", "Ljava/lang/String;", "getXHash", "()Ljava/lang/String;", "xHash", "", "l", "Ljava/lang/Integer;", "getCurrentPage", "()Ljava/lang/Integer;", "currentPage", "", "c", "Z", "getHasFailureOnLoading", "()Z", "hasFailureOnLoading", "Lcom/avito/android/serp/CallInfo;", "o", "Lcom/avito/android/serp/CallInfo;", "getCallInfo", "()Lcom/avito/android/serp/CallInfo;", "callInfo", "", VKApiConst.Q, "J", "getAnalyticsState", "()J", "analyticsState", "", "Lcom/avito/android/serp/adapter/ViewTypeSerpItem;", AuthSource.SEND_ABUSE, "getItems", "items", "Lcom/avito/android/deep_linking/links/DeepLink;", "r", "Lcom/avito/android/deep_linking/links/DeepLink;", "getSubscriptionAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "subscriptionAction", "Lcom/avito/android/serp/SerpParameters;", "d", "Lcom/avito/android/serp/SerpParameters;", "getSerpParameters", "()Lcom/avito/android/serp/SerpParameters;", "serpParameters", "i", "getAuthRequestedFor", "authRequestedFor", "t", "getLoadDeepLinkForBackNavigation", "setLoadDeepLinkForBackNavigation", "(Z)V", "loadDeepLinkForBackNavigation", "p", "getSearchSubscriptionsTapTargetWasShown", "searchSubscriptionsTapTargetWasShown", AuthSource.BOOKING_ORDER, "getHasMorePages", "hasMorePages", "h", "isRefreshed", "Lcom/avito/android/serp/SerpPageParams;", "e", "Lcom/avito/android/serp/SerpPageParams;", "getPageParams", "()Lcom/avito/android/serp/SerpPageParams;", "pageParams", g.a, "isSubscribed", "f", "getSubscriptionId", "subscriptionId", "j", "getSearchHint", "searchHint", "s", "getSerpAppearanceUuid", "serpAppearanceUuid", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "u", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "getSnippetScrollDepthState", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "snippetScrollDepthState", "<init>", "(Ljava/util/List;ZZLcom/avito/android/serp/SerpParameters;Lcom/avito/android/serp/SerpPageParams;Ljava/lang/String;ZZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/SerpDisplayType;Ljava/util/List;Lcom/avito/android/serp/CallInfo;ZJLcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;ZLcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class SerpPresenterState {
    @NotNull
    public final List<ViewTypeSerpItem> a;
    public final boolean b;
    public final boolean c;
    @Nullable
    public final SerpParameters d;
    @NotNull
    public final SerpPageParams e;
    @Nullable
    public final String f;
    public final boolean g;
    public final boolean h;
    @Nullable
    public final Integer i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    @Nullable
    public final Integer l;
    @Nullable
    public final SerpDisplayType m;
    @Nullable
    public final List<String> n;
    @Nullable
    public final CallInfo o;
    public final boolean p;
    public final long q;
    @Nullable
    public final DeepLink r;
    @NotNull
    public final String s;
    public boolean t;
    @NotNull
    public final SnippetScrollDepthTracker.State u;

    public SerpPresenterState(@NotNull List<ViewTypeSerpItem> list, boolean z, boolean z2, @Nullable SerpParameters serpParameters, @NotNull SerpPageParams serpPageParams, @Nullable String str, boolean z3, boolean z4, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable Integer num2, @Nullable SerpDisplayType serpDisplayType, @Nullable List<String> list2, @Nullable CallInfo callInfo, boolean z5, long j2, @Nullable DeepLink deepLink, @NotNull String str4, boolean z7, @NotNull SnippetScrollDepthTracker.State state) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(serpPageParams, "pageParams");
        Intrinsics.checkNotNullParameter(str4, "serpAppearanceUuid");
        Intrinsics.checkNotNullParameter(state, "snippetScrollDepthState");
        this.a = list;
        this.b = z;
        this.c = z2;
        this.d = serpParameters;
        this.e = serpPageParams;
        this.f = str;
        this.g = z3;
        this.h = z4;
        this.i = num;
        this.j = str2;
        this.k = str3;
        this.l = num2;
        this.m = serpDisplayType;
        this.n = list2;
        this.o = callInfo;
        this.p = z5;
        this.q = j2;
        this.r = deepLink;
        this.s = str4;
        this.t = z7;
        this.u = state;
    }

    public final long getAnalyticsState() {
        return this.q;
    }

    @Nullable
    public final Integer getAuthRequestedFor() {
        return this.i;
    }

    @Nullable
    public final CallInfo getCallInfo() {
        return this.o;
    }

    @Nullable
    public final Integer getCurrentPage() {
        return this.l;
    }

    @Nullable
    public final SerpDisplayType getDisplayType() {
        return this.m;
    }

    public final boolean getHasFailureOnLoading() {
        return this.c;
    }

    public final boolean getHasMorePages() {
        return this.b;
    }

    @NotNull
    public final List<ViewTypeSerpItem> getItems() {
        return this.a;
    }

    public final boolean getLoadDeepLinkForBackNavigation() {
        return this.t;
    }

    @NotNull
    public final SerpPageParams getPageParams() {
        return this.e;
    }

    @Nullable
    public final String getSearchHint() {
        return this.j;
    }

    public final boolean getSearchSubscriptionsTapTargetWasShown() {
        return this.p;
    }

    @NotNull
    public final String getSerpAppearanceUuid() {
        return this.s;
    }

    @Nullable
    public final SerpParameters getSerpParameters() {
        return this.d;
    }

    @Nullable
    public final List<String> getShowedShortcutBannerIds() {
        return this.n;
    }

    @NotNull
    public final SnippetScrollDepthTracker.State getSnippetScrollDepthState() {
        return this.u;
    }

    @Nullable
    public final DeepLink getSubscriptionAction() {
        return this.r;
    }

    @Nullable
    public final String getSubscriptionId() {
        return this.f;
    }

    @Nullable
    public final String getXHash() {
        return this.k;
    }

    public final boolean isRefreshed() {
        return this.h;
    }

    public final boolean isSubscribed() {
        return this.g;
    }

    public final void setLoadDeepLinkForBackNavigation(boolean z) {
        this.t = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SerpPresenterState(List list, boolean z, boolean z2, SerpParameters serpParameters, SerpPageParams serpPageParams, String str, boolean z3, boolean z4, Integer num, String str2, String str3, Integer num2, SerpDisplayType serpDisplayType, List list2, CallInfo callInfo, boolean z5, long j2, DeepLink deepLink, String str4, boolean z7, SnippetScrollDepthTracker.State state, int i2, j jVar) {
        this(list, z, z2, serpParameters, serpPageParams, str, z3, z4, num, str2, str3, num2, serpDisplayType, list2, callInfo, z5, j2, deepLink, str4, (i2 & 524288) != 0 ? false : z7, state);
    }
}
