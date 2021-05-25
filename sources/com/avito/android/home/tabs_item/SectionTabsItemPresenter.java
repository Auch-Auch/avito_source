package com.avito.android.home.tabs_item;

import com.avito.android.home.SectionTabsViewPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/home/tabs_item/SectionTabsItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/home/tabs_item/SectionTabsItemView;", "Lcom/avito/android/home/tabs_item/SectionTabsItem;", "Lcom/avito/android/home/SectionTabsViewPresenter;", "presenter", "", "setSectionTabsPresenter", "(Lcom/avito/android/home/SectionTabsViewPresenter;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface SectionTabsItemPresenter extends ItemPresenter<SectionTabsItemView, SectionTabsItem> {
    void setSectionTabsPresenter(@NotNull SectionTabsViewPresenter sectionTabsViewPresenter);
}
