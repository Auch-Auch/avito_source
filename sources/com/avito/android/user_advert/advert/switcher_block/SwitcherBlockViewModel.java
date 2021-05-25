package com.avito.android.user_advert.advert.switcher_block;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockViewModel;", "", "", "newValue", "", "onSwitchChanged", "(Z)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherState;", "getSwitcherState", "()Landroidx/lifecycle/LiveData;", "switcherState", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherInfo;", "getDataChanges", "dataChanges", "", "getErrors", "errors", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface SwitcherBlockViewModel {
    @NotNull
    LiveData<SwitcherInfo> getDataChanges();

    @NotNull
    LiveData<String> getErrors();

    @NotNull
    LiveData<SwitcherState> getSwitcherState();

    void onSwitchChanged(boolean z);
}
