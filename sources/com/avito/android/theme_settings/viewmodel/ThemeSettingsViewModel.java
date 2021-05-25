package com.avito.android.theme_settings.viewmodel;

import androidx.lifecycle.LiveData;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.theme_settings.item.ThemeModeItemPresenter;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/theme_settings/viewmodel/ThemeSettingsViewModel;", "", "", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter;", "itemPresenterSet", "", "observeItemClicks", "(Ljava/util/Set;)V", "refreshItems", "()V", "Landroidx/lifecycle/LiveData;", "", "Lcom/avito/android/serp/adapter/SpannedItem;", "getItemChanges", "()Landroidx/lifecycle/LiveData;", "itemChanges", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface ThemeSettingsViewModel {
    @NotNull
    LiveData<List<SpannedItem>> getItemChanges();

    void observeItemClicks(@NotNull Set<? extends ThemeModeItemPresenter> set);

    void refreshItems();
}
