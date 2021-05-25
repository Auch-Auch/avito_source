package com.avito.android.messenger.channels.mvi.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.design.widget.tab.CommonTab;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContent;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.channels.mvi.view.FoldersView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.BackingField;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.Views;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J+\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR9\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00038V@VX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001c\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/FoldersViewImpl;", "Lcom/avito/android/messenger/channels/mvi/view/FoldersView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "prevState", "curState", "", "doRender", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;)V", "requestOnboarding", "()V", AuthSource.SEND_ABUSE, "<set-?>", "f", "Lkotlin/properties/ReadWriteProperty;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", "setLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;)V", "lastRenderedState", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "Lcom/avito/android/design/widget/tab/CommonTab;", "c", "Lcom/avito/android/design/widget/tab/TabLayoutAdapter;", "foldersTabsAdapter", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "foldersTabsDataProvider", "Lcom/google/android/material/tabs/TabLayout;", "d", "Lcom/google/android/material/tabs/TabLayout;", "tabsLayout", "", "e", "Z", "onboardingWasRequested", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FoldersViewImpl implements FoldersView {
    public static final /* synthetic */ KProperty[] g = {Reflection.mutableProperty2(new MutablePropertyReference2Impl(FoldersViewImpl.class, "lastRenderedState", "getLastRenderedState(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Lcom/avito/android/messenger/channels/mvi/presenter/FoldersPresenter$State;", 0))};
    public final Context a;
    public final TabsDataProvider<CommonTab> b;
    public final TabLayoutAdapter<CommonTab> c;
    public final TabLayout d;
    public boolean e;
    @Nullable
    public final ReadWriteProperty f = new BackingField(null);

    public static final class a extends Lambda implements Function1<TooltipContent, Unit> {
        public final /* synthetic */ FoldersViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FoldersViewImpl foldersViewImpl) {
            super(1);
            this.a = foldersViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TooltipContent tooltipContent) {
            TooltipContent tooltipContent2 = tooltipContent;
            Intrinsics.checkNotNullParameter(tooltipContent2, "$receiver");
            tooltipContent2.setTitle(this.a.a.getString(R.string.messenger_folder_onboarding_title));
            tooltipContent2.setBody(this.a.a.getString(R.string.messenger_folder_onboarding_body));
            return Unit.INSTANCE;
        }
    }

    public FoldersViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.a = view.getContext();
        TabsDataProvider<CommonTab> tabsDataProvider = new TabsDataProvider<>();
        this.b = tabsDataProvider;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        TabLayoutAdapter<CommonTab> tabLayoutAdapter = new TabLayoutAdapter<>(tabsDataProvider, context, 0, 4, null);
        this.c = tabLayoutAdapter;
        View findViewById = view.findViewById(R.id.folders_tabs);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById;
        this.d = tabLayout;
        TabLayoutsKt.setAdapter(tabLayout, tabLayoutAdapter);
    }

    public final void a() {
        View childAt;
        View childAt2 = this.d.getChildAt(0);
        if (childAt2 != null) {
            if (!(childAt2 instanceof ViewGroup)) {
                childAt2 = null;
            }
            ViewGroup viewGroup = (ViewGroup) childAt2;
            if (viewGroup != null && (childAt = viewGroup.getChildAt(1)) != null) {
                Context context = this.a;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Tooltip tooltip = new Tooltip(context, 0, 0, 6, null);
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                TooltipContentKt.content(Tooltip.setSize$default(tooltip, (int) context2.getResources().getDimension(R.dimen.messenger_folder_onboarding_tooltip_width), 0, 2, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.End(new AnchorPositions.Center()))), new a(this)).show(childAt);
                this.e = false;
            }
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer
    @Nullable
    public FoldersPresenter.State getLastRenderedState(@NotNull Renderer<FoldersPresenter.State> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return (FoldersPresenter.State) this.f.getValue(renderer, g[0]);
    }

    public void render(@NotNull FoldersPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        FoldersView.DefaultImpls.render(this, state);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.FoldersView
    public void requestOnboarding() {
        if (this.d.getTabCount() > 1) {
            a();
        } else {
            this.e = true;
        }
    }

    public void setLastRenderedState(@NotNull Renderer<FoldersPresenter.State> renderer, @Nullable FoldersPresenter.State state) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        this.f.setValue(renderer, g[0], state);
    }

    public void doRender(@NotNull Renderer<FoldersPresenter.State> renderer, @Nullable FoldersPresenter.State state, @NotNull FoldersPresenter.State state2) {
        Intrinsics.checkNotNullParameter(renderer, "$this$doRender");
        Intrinsics.checkNotNullParameter(state2, "curState");
        Views.setVisible(this.d, !state2.getTabs().isEmpty());
        TabsDataProvider<CommonTab> tabsDataProvider = this.b;
        List<FoldersPresenter.FolderTab> tabs = state2.getTabs();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tabs, 10));
        for (T t : tabs) {
            String string = this.a.getString(t.getName());
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(it.name)");
            arrayList.add(new CommonTab(string, t.getValue()));
        }
        tabsDataProvider.updateItems(arrayList);
        this.c.notifyDataSetChanged();
        TabLayout.Tab tabAt = this.d.getTabAt(state2.getSelected());
        if (tabAt != null) {
            tabAt.select();
        }
        if (this.e && this.d.getTabCount() > 1) {
            a();
        }
    }
}
