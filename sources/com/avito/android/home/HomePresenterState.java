package com.avito.android.home;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/home/HomePresenterState;", "", "", "d", "Ljava/lang/String;", "getMainAppearanceUuid", "()Ljava/lang/String;", "mainAppearanceUuid", "", "c", "J", "getAnalyticsState", "()J", "analyticsState", AuthSource.BOOKING_ORDER, "getIdProviderState", "idProviderState", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "e", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "getSnippetScrollDepthState", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "snippetScrollDepthState", "Lcom/avito/android/home/State;", AuthSource.SEND_ABUSE, "Lcom/avito/android/home/State;", "getState", "()Lcom/avito/android/home/State;", "state", "<init>", "(Lcom/avito/android/home/State;JJLjava/lang/String;Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class HomePresenterState {
    @NotNull
    public final State a;
    public final long b;
    public final long c;
    @NotNull
    public final String d;
    @NotNull
    public final SnippetScrollDepthTracker.State e;

    public HomePresenterState(@NotNull State state, long j, long j2, @NotNull String str, @NotNull SnippetScrollDepthTracker.State state2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(str, "mainAppearanceUuid");
        Intrinsics.checkNotNullParameter(state2, "snippetScrollDepthState");
        this.a = state;
        this.b = j;
        this.c = j2;
        this.d = str;
        this.e = state2;
    }

    public final long getAnalyticsState() {
        return this.c;
    }

    public final long getIdProviderState() {
        return this.b;
    }

    @NotNull
    public final String getMainAppearanceUuid() {
        return this.d;
    }

    @NotNull
    public final SnippetScrollDepthTracker.State getSnippetScrollDepthState() {
        return this.e;
    }

    @NotNull
    public final State getState() {
        return this.a;
    }
}
