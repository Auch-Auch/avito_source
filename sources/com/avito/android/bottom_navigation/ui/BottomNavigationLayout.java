package com.avito.android.bottom_navigation.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.avito.android.bottom_navigation.NavigationTabSet;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fB\u001b\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001e\u0010\"B#\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010$J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/BottomNavigationLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/avito/android/bottom_navigation/NavigationTabSet;", "tabsSet", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "preselectedTab", "", "setTabs", "(Lcom/avito/android/bottom_navigation/NavigationTabSet;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnTabClickListener", "(Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;)V", "tab", "", "count", "setTabBadge", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;I)V", "selectTab", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", VKApiConst.Q, "Lcom/avito/android/bottom_navigation/ui/OnTabClickListener;", "onTabClickListener", "", "Lcom/avito/android/bottom_navigation/ui/BottomNavigationTabView;", "p", "Ljava/util/Map;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public final class BottomNavigationLayout extends LinearLayoutCompat {
    public Map<NavigationTabSetItem, BottomNavigationTabView> p;
    public OnTabClickListener q;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NavigationTabSetItem a;
        public final /* synthetic */ BottomNavigationLayout b;
        public final /* synthetic */ Map c;

        public a(NavigationTabSetItem navigationTabSetItem, BottomNavigationLayout bottomNavigationLayout, LayoutInflater layoutInflater, Map map) {
            this.a = navigationTabSetItem;
            this.b = bottomNavigationLayout;
            this.c = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OnTabClickListener onTabClickListener = this.b.q;
            if (onTabClickListener != null) {
                onTabClickListener.onTabClick(this.a);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }

    public final void selectTab(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        Map<NavigationTabSetItem, BottomNavigationTabView> map = this.p;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
        }
        BottomNavigationTabView bottomNavigationTabView = map.get(navigationTabSetItem);
        if (bottomNavigationTabView != null && !bottomNavigationTabView.isSelected()) {
            Map<NavigationTabSetItem, BottomNavigationTabView> map2 = this.p;
            if (map2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabs");
            }
            Iterator<T> it = map2.values().iterator();
            while (it.hasNext()) {
                it.next().setSelected(false);
            }
            bottomNavigationTabView.setSelected(true);
        }
    }

    public final void setOnTabClickListener(@NotNull OnTabClickListener onTabClickListener) {
        Intrinsics.checkNotNullParameter(onTabClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.q = onTabClickListener;
    }

    public final void setTabBadge(@NotNull NavigationTabSetItem navigationTabSetItem, int i) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        Map<NavigationTabSetItem, BottomNavigationTabView> map = this.p;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabs");
        }
        BottomNavigationTabView bottomNavigationTabView = map.get(navigationTabSetItem);
        if (bottomNavigationTabView != null) {
            bottomNavigationTabView.setBadge(i);
        }
    }

    public final void setTabs(@NotNull NavigationTabSet navigationTabSet, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSet, "tabsSet");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "preselectedTab");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LayoutInflater from = LayoutInflater.from(getContext());
        Iterator it = navigationTabSet.iterator();
        while (it.hasNext()) {
            NavigationTabSetItem navigationTabSetItem2 = (NavigationTabSetItem) it.next();
            View inflate = from.inflate(R.layout.bottom_navigation_item_view, (ViewGroup) this, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.bottom_navigation.ui.BottomNavigationTabView");
            BottomNavigationTabView bottomNavigationTabView = (BottomNavigationTabView) inflate;
            ViewGroup.LayoutParams layoutParams = bottomNavigationTabView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
            ((LinearLayoutCompat.LayoutParams) layoutParams).weight = 1.0f;
            addView(bottomNavigationTabView);
            bottomNavigationTabView.setOnClickListener(new a(navigationTabSetItem2, this, from, linkedHashMap));
            bottomNavigationTabView.initTab(navigationTabSetItem2);
            linkedHashMap.put(navigationTabSetItem2, bottomNavigationTabView);
        }
        this.p = linkedHashMap;
        selectTab(navigationTabSetItem);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
    }
}
