package com.avito.android.analytics.event;

import a2.g.r.g;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003-./B\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b+\u0010,J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\bR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/avito/android/analytics/event/ClickPinEvent;", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamEvent;", "", "", "", "extraParams", "()Ljava/util/Map;", "e", "Ljava/lang/String;", "serpPanelState", g.a, "categoryId", "i", "searchHash", "Lcom/avito/android/analytics/event/ClickPinEvent$PinState;", "l", "Lcom/avito/android/analytics/event/ClickPinEvent$PinState;", "pinState", "", "j", "I", "mapZoom", "Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;", "pinHighlight", "n", "pinPrice", "", "", "f", "Ljava/util/List;", "searchArea", "h", "total", "Lcom/avito/android/analytics/event/ClickPinEvent$PinType;", "k", "Lcom/avito/android/analytics/event/ClickPinEvent$PinType;", "pinType", "", "stateId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "parent", "<init>", "(JLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;ILcom/avito/android/analytics/event/ClickPinEvent$PinType;Lcom/avito/android/analytics/event/ClickPinEvent$PinState;Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;Ljava/lang/String;)V", "PinHighlight", "PinState", "PinType", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClickPinEvent extends TreeClickStreamEvent {
    public final String e;
    public final List<Double> f;
    public final String g;
    public final int h;
    public final String i;
    public final int j;
    public final PinType k;
    public final PinState l;
    public final PinHighlight m;
    public final String n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/analytics/event/ClickPinEvent$PinHighlight;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "BRIGHT", "REGULAR", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum PinHighlight {
        BRIGHT("bright"),
        REGULAR("regular");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        PinHighlight(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/event/ClickPinEvent$PinState;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "UNVIEWED", "VIEWED", "SELECTED", "FAVORITE", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum PinState {
        UNVIEWED("unviewed"),
        VIEWED("viewed"),
        SELECTED("selected"),
        FAVORITE("favorite");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        PinState(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/event/ClickPinEvent$PinType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "RASH", "PIN", "PRICE_PIN", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum PinType {
        RASH("point"),
        PIN("pin"),
        PRICE_PIN("price_pin");
        
        @NotNull
        public final String a;

        /* access modifiers changed from: public */
        PinType(String str) {
            this.a = str;
        }

        @NotNull
        public final String getValue() {
            return this.a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClickPinEvent(long j2, TreeClickStreamParent treeClickStreamParent, String str, List list, String str2, int i2, String str3, int i3, PinType pinType, PinState pinState, PinHighlight pinHighlight, String str4, int i4, j jVar) {
        this(j2, treeClickStreamParent, (i4 & 4) != 0 ? null : str, (i4 & 8) != 0 ? null : list, (i4 & 16) != 0 ? null : str2, i2, str3, i3, pinType, pinState, pinHighlight, (i4 & 2048) != 0 ? null : str4);
    }

    @Override // com.avito.android.analytics.provider.clickstream.TreeClickStreamEvent
    @NotNull
    public Map<String, Object> extraParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putParam(linkedHashMap, "serpdisplay_type", this.e);
        putParam(linkedHashMap, "search_area", this.f);
        putParam(linkedHashMap, "cid", this.g);
        putParam(linkedHashMap, "total", Integer.valueOf(this.h));
        putParam(linkedHashMap, "x", this.i);
        putParam(linkedHashMap, "map_zoom", Integer.valueOf(this.j));
        putParam(linkedHashMap, "pin_type", this.k.getValue());
        putParam(linkedHashMap, "pin_state", this.l.getValue());
        putParam(linkedHashMap, "pin_price", this.n);
        putParam(linkedHashMap, "pin_highlight", this.m.getValue());
        return linkedHashMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickPinEvent(long j2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable String str, @Nullable List<Double> list, @Nullable String str2, int i2, @NotNull String str3, int i3, @NotNull PinType pinType, @NotNull PinState pinState, @NotNull PinHighlight pinHighlight, @Nullable String str4) {
        super(j2, treeClickStreamParent, 2666, 9);
        Intrinsics.checkNotNullParameter(str3, "searchHash");
        Intrinsics.checkNotNullParameter(pinType, "pinType");
        Intrinsics.checkNotNullParameter(pinState, "pinState");
        Intrinsics.checkNotNullParameter(pinHighlight, "pinHighlight");
        this.e = str;
        this.f = list;
        this.g = str2;
        this.h = i2;
        this.i = str3;
        this.j = i3;
        this.k = pinType;
        this.l = pinState;
        this.m = pinHighlight;
        this.n = str4;
    }
}
