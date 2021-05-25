package ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/IBottomNavigationViewModel;", "", "", "itemID", "", "bottomItemSelected", "(I)Z", "", "onStartAction", "()V", "Landroidx/lifecycle/LiveData;", "Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/SelectItemBottomNavigationEnum;", "getSelectItemElement", "()Landroidx/lifecycle/LiveData;", "selectItemElement", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public interface IBottomNavigationViewModel {
    boolean bottomItemSelected(int i);

    @NotNull
    LiveData<SelectItemBottomNavigationEnum> getSelectItemElement();

    void onStartAction();
}
