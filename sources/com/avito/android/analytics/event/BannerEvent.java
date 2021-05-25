package com.avito.android.analytics.event;

import a2.b.a.a.a;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00042\u00020\u0001:\u0005\u0005\u0006\u0004\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "<init>", "()V", "Companion", "Action", "Closed", "ProfileBannerClosed", "Shown", "analytics_release"}, k = 1, mv = {1, 4, 2})
public abstract class BannerEvent implements ClickStreamEvent {
    @NotNull
    public static final String ACTION_BUTTON_CLICK = "button_click";
    @NotNull
    public static final String ACTION_CLICK = "click";
    @NotNull
    public static final String ACTION_LINK_CLICK = "click";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String ID_NOTIFICATIONS = "notifications";
    @NotNull
    public static final String PAGE_TYPE_MESSENGER = "messenger";
    @NotNull
    public static final String PAGE_TYPE_PROFILE = "profile";
    @NotNull
    public static final String PLACEMENT_TOP = "top";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent$Action;", "Lcom/avito/android/analytics/event/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "getVersion", "version", "bannerId", "pageType", "placement", "actionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action extends BannerEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        public Action(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
            a.b1(str, "bannerId", str2, "pageType", str3, "placement", str4, "actionType");
            this.a = new ParametrizedClickStreamEvent(3207, 1, r.mapOf(TuplesKt.to("banner_id", str), TuplesKt.to("pagetype", str2), TuplesKt.to("placement", str3), TuplesKt.to(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, str4)), null, 8, null);
        }

        @Override // com.avito.android.analytics.event.BannerEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public String description() {
            return this.a.description();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getEventId() {
            return this.a.getEventId();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public Map<String, Object> getParams() {
            return this.a.getParams();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getVersion() {
            return this.a.getVersion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent$Closed;", "Lcom/avito/android/analytics/event/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getEventId", "()I", "eventId", "getVersion", "version", "", "", "getParams", "()Ljava/util/Map;", "params", "bannerId", "pageType", "placement", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Closed extends BannerEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        public Closed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "bannerId", str2, "pageType", str3, "placement");
            this.a = new ParametrizedClickStreamEvent(3282, 1, r.mapOf(TuplesKt.to("banner_id", str), TuplesKt.to("pagetype", str2), TuplesKt.to("placement", str3)), null, 8, null);
        }

        @Override // com.avito.android.analytics.event.BannerEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public String description() {
            return this.a.description();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getEventId() {
            return this.a.getEventId();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public Map<String, Object> getParams() {
            return this.a.getParams();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getVersion() {
            return this.a.getVersion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent$Companion;", "", "", "ACTION_BUTTON_CLICK", "Ljava/lang/String;", "ACTION_CLICK", "ACTION_LINK_CLICK", "ID_NOTIFICATIONS", "PAGE_TYPE_MESSENGER", "PAGE_TYPE_PROFILE", "PLACEMENT_TOP", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent$ProfileBannerClosed;", "Lcom/avito/android/analytics/event/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "", "getParams", "()Ljava/util/Map;", "params", "", "getVersion", "()I", "version", "getEventId", "eventId", "bannerId", "pageType", "placement", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class ProfileBannerClosed extends BannerEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        public ProfileBannerClosed(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "bannerId", str2, "pageType", str3, "placement");
            this.a = new ParametrizedClickStreamEvent(3182, 1, r.mapOf(TuplesKt.to("banner_id", str), TuplesKt.to("pagetype", str2), TuplesKt.to("placement", str3)), null, 8, null);
        }

        @Override // com.avito.android.analytics.event.BannerEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public String description() {
            return this.a.description();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getEventId() {
            return this.a.getEventId();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public Map<String, Object> getParams() {
            return this.a.getParams();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getVersion() {
            return this.a.getVersion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/event/BannerEvent$Shown;", "Lcom/avito/android/analytics/event/BannerEvent;", "Lcom/avito/android/analytics/provider/clickstream/ClickStreamEvent;", "", "description", "()Ljava/lang/String;", "", "getVersion", "()I", "version", "getEventId", "eventId", "", "", "getParams", "()Ljava/util/Map;", "params", "bannerId", "pageType", "placement", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
    public static final class Shown extends BannerEvent implements ClickStreamEvent {
        public final /* synthetic */ ParametrizedClickStreamEvent a;

        public Shown(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "bannerId", str2, "pageType", str3, "placement");
            this.a = new ParametrizedClickStreamEvent(3180, 0, r.mapOf(TuplesKt.to("banner_id", str), TuplesKt.to("pagetype", str2), TuplesKt.to("placement", str3)), null, 8, null);
        }

        @Override // com.avito.android.analytics.event.BannerEvent, com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public String description() {
            return this.a.description();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getEventId() {
            return this.a.getEventId();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        @NotNull
        public Map<String, Object> getParams() {
            return this.a.getParams();
        }

        @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
        public int getVersion() {
            return this.a.getVersion();
        }
    }

    @Override // com.avito.android.analytics.provider.clickstream.ClickStreamEvent
    @NotNull
    public String description() {
        return ClickStreamEvent.DefaultImpls.description(this);
    }
}
