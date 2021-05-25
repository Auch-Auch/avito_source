package com.avito.android.bottom_navigation;

import com.avito.android.bottom_navigation.ui.fragment.ResultDispatcher;
import com.avito.android.ui.fragments.ResultFragmentData;
import com.avito.android.ui.fragments.ResultReportData;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationProvider;", "", "Lcom/avito/android/bottom_navigation/NavigationTab;", "currentTab", "()Lcom/avito/android/bottom_navigation/NavigationTab;", "Lcom/avito/android/ui/fragments/ResultFragmentData;", "data", "", "registerStartForResult", "(Lcom/avito/android/ui/fragments/ResultFragmentData;)V", "finishFragment", "()V", "", "fragmentId", "Lcom/avito/android/ui/fragments/ResultReportData;", "resultReportData", "reportFragmentResult", "(Ljava/lang/String;Lcom/avito/android/ui/fragments/ResultReportData;)V", "Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;", "resultDispatcher", "registerSelf", "(Lcom/avito/android/bottom_navigation/ui/fragment/ResultDispatcher;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "getTabObservable", "()Lio/reactivex/rxjava3/core/Observable;", "tabObservable", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface NavigationProvider {
    @Nullable
    NavigationTab currentTab();

    void finishFragment();

    @Nullable
    Observable<NavigationTabSetItem> getTabObservable();

    void registerSelf(@NotNull ResultDispatcher resultDispatcher);

    void registerStartForResult(@NotNull ResultFragmentData resultFragmentData);

    void reportFragmentResult(@NotNull String str, @NotNull ResultReportData resultReportData);
}
