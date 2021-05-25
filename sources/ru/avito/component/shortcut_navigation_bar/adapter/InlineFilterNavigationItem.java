package ru.avito.component.shortcut_navigation_bar.adapter;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilterValueKt;
import com.avito.android.remote.model.search.InlineFiltersKt;
import com.avito.android.remote.model.search.WidgetType;
import com.avito.android.util.Collections;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010%\u001a\u00020\u0011\u0012\b\u00101\u001a\u0004\u0018\u00010,\u0012\u0006\u0010\u0019\u001a\u00020\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010!R\u0019\u0010%\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015R\u001b\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010\u001c¨\u00066"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/InlineFilterNavigationItem;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "", "isSelected", "()Z", "", "toggleStateIfPossible", "()V", "j", "Z", "isHighlighted", "Lcom/avito/android/deep_linking/links/DeepLink;", g.a, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "f", "getText", "text", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", "newState", "i", "getDisplayTitle", "setDisplayTitle", "(Ljava/lang/String;)V", "displayTitle", "d", "getFilterId", "filterId", "Lcom/avito/android/remote/model/search/Filter;", "h", "Lcom/avito/android/remote/model/search/Filter;", "getFilter", "()Lcom/avito/android/remote/model/search/Filter;", "filter", "", "e", "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "value", AuthSource.SEND_ABUSE, "currentState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/search/Filter;Ljava/lang/String;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFilterNavigationItem extends ShortcutNavigationItem {
    public Filter.InnerOptions.State a;
    public Filter.InnerOptions.State b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @Nullable
    public final Object e;
    @NotNull
    public final String f;
    @Nullable
    public final DeepLink g;
    @Nullable
    public final Filter h;
    @Nullable
    public String i;
    public boolean j;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InlineFilterNavigationItem(java.lang.String r11, java.lang.String r12, java.lang.Object r13, java.lang.String r14, com.avito.android.deep_linking.links.DeepLink r15, com.avito.android.remote.model.search.Filter r16, java.lang.String r17, boolean r18, int r19, t6.r.a.j r20) {
        /*
            r10 = this;
            r0 = r19
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0016
            if (r16 == 0) goto L_0x0013
            java.lang.Boolean r0 = r16.isHighlighted()
            if (r0 == 0) goto L_0x0013
            boolean r0 = r0.booleanValue()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            r9 = r0
            goto L_0x0018
        L_0x0016:
            r9 = r18
        L_0x0018:
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem.<init>(java.lang.String, java.lang.String, java.lang.Object, java.lang.String, com.avito.android.deep_linking.links.DeepLink, com.avito.android.remote.model.search.Filter, java.lang.String, boolean, int, t6.r.a.j):void");
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @Nullable
    public DeepLink getDeepLink() {
        return this.g;
    }

    @Nullable
    public final String getDisplayTitle() {
        return this.i;
    }

    @Nullable
    public final Filter getFilter() {
        return this.h;
    }

    @NotNull
    public final String getFilterId() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem
    @NotNull
    public String getText() {
        return this.f;
    }

    @Nullable
    public final Object getValue() {
        return this.e;
    }

    public final boolean isSelected() {
        Filter.Widget widget;
        Filter filter = this.h;
        if (((filter == null || (widget = filter.getWidget()) == null) ? null : widget.getType()) == WidgetType.Checkbox) {
            return this.j;
        }
        Object obj = this.e;
        if (!(obj instanceof InlineFilterValue.InlineFilterShortcutValue) && (obj instanceof InlineFilterValue)) {
            return InlineFilterValueKt.isNotEmpty((InlineFilterValue) obj);
        }
        return false;
    }

    public final void setDisplayTitle(@Nullable String str) {
        this.i = str;
    }

    public final void toggleStateIfPossible() {
        Filter.InnerOptions.State state = this.b;
        if (state != null) {
            this.b = this.a;
            this.a = state;
            this.i = state.getDisplayTitle();
            Boolean isHighlighted = this.a.isHighlighted();
            this.j = isHighlighted != null ? isHighlighted.booleanValue() : false;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InlineFilterNavigationItem(@NotNull String str, @NotNull String str2, @Nullable Object obj, @NotNull String str3, @Nullable DeepLink deepLink, @Nullable Filter filter, @Nullable String str4, boolean z) {
        super(null);
        Filter.InnerOptions.Options firstOption;
        a.Z0(str, "stringId", str2, "filterId", str3, "text");
        Filter.InnerOptions.State state = null;
        this.c = str;
        this.d = str2;
        this.e = obj;
        this.f = str3;
        this.g = deepLink;
        this.h = filter;
        this.i = str4;
        this.j = z;
        this.a = new Filter.InnerOptions.State(this.i, Boolean.valueOf(this.j));
        if (!(Collections.isNullOrEmpty(filter != null ? filter.getOptions() : null) || filter == null || (firstOption = InlineFiltersKt.firstOption(filter)) == null)) {
            state = firstOption.getNewState();
        }
        this.b = state;
    }
}
