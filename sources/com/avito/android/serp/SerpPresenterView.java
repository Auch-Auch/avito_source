package com.avito.android.serp;

import com.avito.android.component.search.SearchBar;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.saved_searches.SavedSearchView;
import com.avito.android.serp.adapter.advert_xl.PhoneCallView;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingTooltipEventsProducer;
import com.avito.android.ui.adapter.AppendingListener;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.ShortcutNavigationBar;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\u0005H&¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u001d\u001a\u00020\u0005H&¢\u0006\u0004\b\u001d\u0010\u0007J\u000f\u0010\u001e\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u0007J\u000f\u0010\u001f\u001a\u00020\u0005H&¢\u0006\u0004\b\u001f\u0010\u0007J\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\bH&¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u0005H&¢\u0006\u0004\b\"\u0010\u0007J\u000f\u0010#\u001a\u00020\u0005H&¢\u0006\u0004\b#\u0010\u0007J\u0017\u0010$\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0010H&¢\u0006\u0004\b$\u0010\u0018J-\u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050'H&¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H&¢\u0006\u0004\b+\u0010\u0007J\u000f\u0010,\u001a\u00020\u0005H&¢\u0006\u0004\b,\u0010\u0007J\u000f\u0010-\u001a\u00020\u0005H&¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\bH&¢\u0006\u0004\b.\u0010\u000bJ\u0017\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102J'\u00105\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H&¢\u0006\u0004\b5\u0010\u0014J\u000f\u00106\u001a\u00020\u0005H&¢\u0006\u0004\b6\u0010\u0007J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u000207H&¢\u0006\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/avito/android/serp/SerpPresenterView;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "Lcom/avito/android/serp/adapter/advert_xl/PhoneCallView;", "Lcom/avito/android/saved_searches/SavedSearchView;", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingTooltipEventsProducer;", "", "showProgress", "()V", "", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "onDataChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "", "startPosition", "count", "onDataRangeChanged", "(Lcom/avito/android/ui/adapter/AppendingListener;II)V", "onDataAppended", VKApiConst.POSITION, "onRemoveItem", "(I)V", "onItemChanged", "showSavedSearchEmptyView", "showNewSearchEmptyView", "hideEmptyView", "setSubscriptionSwitchedOn", "setSubscriptionSwitchedOff", "setSubscriptionSwitchedLoading", "hint", "setSearchHint", "setSearchHintSearch", "showDefaultNavigationIcon", "setColumnsCount", "message", "action", "Lkotlin/Function0;", "actionListener", "showMessageWithAction", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "hideShortcutsWithShift", "showShortcutsWithShift", "resetScrollingToTop", "showToastMessage", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "positionStart", "itemCount", "onRemoveItemRange", "enableScroll", "", "visible", "setCartFabVisible", "(Z)V", "Lcom/avito/android/component/search/SearchBar;", "getSearchBar", "()Lcom/avito/android/component/search/SearchBar;", "searchBar", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SerpPresenterView extends ShortcutNavigationBar, PhoneCallView, SavedSearchView, SerpOnboardingTooltipEventsProducer {
    void enableScroll();

    @NotNull
    SearchBar getSearchBar();

    void hideEmptyView();

    void hideShortcutsWithShift();

    void onDataAppended(@NotNull AppendingListener appendingListener, int i, int i2);

    void onDataChanged(@NotNull AppendingListener appendingListener);

    void onDataRangeChanged(@NotNull AppendingListener appendingListener, int i, int i2);

    void onItemChanged(int i);

    void onRemoveItem(int i);

    void onRemoveItemRange(@NotNull AppendingListener appendingListener, int i, int i2);

    void resetScrollingToTop();

    void setCartFabVisible(boolean z);

    void setColumnsCount(int i);

    void setDisplayType(@NotNull SerpDisplayType serpDisplayType);

    void setSearchHint(@NotNull String str);

    void setSearchHintSearch();

    void setSubscriptionSwitchedLoading();

    void setSubscriptionSwitchedOff();

    void setSubscriptionSwitchedOn();

    void showDefaultNavigationIcon();

    @Override // com.avito.android.legacy_mvp.ErrorMessageView
    void showError(@NotNull String str);

    void showMessageWithAction(@NotNull String str, @NotNull String str2, @NotNull Function0<Unit> function0);

    void showNewSearchEmptyView();

    void showProgress();

    void showSavedSearchEmptyView();

    void showShortcutsWithShift();

    void showToastMessage(@NotNull String str);
}
