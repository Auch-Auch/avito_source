package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u001c\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR:\u0010\u0015\u001a&\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011 \u0012*\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u0011\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenterImpl;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemPresenter;", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "view", "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;Lcom/avito/android/tariff/edit_info/item/tabs/TabsItem;I)V", "unbindListener", "()V", AuthSource.SEND_ABUSE, "Lcom/avito/android/tariff/edit_info/item/tabs/TabsItemView;", "tabsItemView", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/tariff/edit_info/item/tabs/PeriodTab;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "tabSelectedObservable", "Lio/reactivex/Observable;", "c", "Lio/reactivex/Observable;", "getTabSelects", "()Lio/reactivex/Observable;", "tabSelects", "<init>", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TabsItemPresenterImpl implements TabsItemPresenter {
    public TabsItemView a;
    public final PublishRelay<PeriodTab> b;
    @NotNull
    public final Observable<PeriodTab> c;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ TabsItemPresenterImpl a;
        public final /* synthetic */ TabsItemView b;
        public final /* synthetic */ TabsItem c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TabsItemPresenterImpl tabsItemPresenterImpl, TabsItemView tabsItemView, TabsItem tabsItem) {
            super(1);
            this.a = tabsItemPresenterImpl;
            this.b = tabsItemView;
            this.c = tabsItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            this.c.setSelectedIndex(intValue);
            this.a.b.accept(this.c.getTabs().get(intValue));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public TabsItemPresenterImpl() {
        PublishRelay<PeriodTab> create = PublishRelay.create();
        this.b = create;
        Intrinsics.checkNotNullExpressionValue(create, "tabSelectedObservable");
        this.c = create;
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter
    @NotNull
    public Observable<PeriodTab> getTabSelects() {
        return this.c;
    }

    @Override // com.avito.android.tariff.edit_info.item.tabs.TabsItemPresenter
    public void unbindListener() {
        TabsItemView tabsItemView = this.a;
        if (tabsItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsItemView");
        }
        tabsItemView.unbindListener();
    }

    public void bindView(@NotNull TabsItemView tabsItemView, @NotNull TabsItem tabsItem, int i) {
        Intrinsics.checkNotNullParameter(tabsItemView, "view");
        Intrinsics.checkNotNullParameter(tabsItem, "item");
        this.a = tabsItemView;
        tabsItemView.bindTabs(tabsItem.getTabs());
        tabsItemView.setSelectedTab(tabsItem.getSelectedIndex());
        tabsItemView.setOnTabSelectedListener(new a(this, tabsItemView, tabsItem));
    }
}
