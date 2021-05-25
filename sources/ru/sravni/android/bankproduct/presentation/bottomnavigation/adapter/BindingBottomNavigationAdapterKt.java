package ru.sravni.android.bankproduct.presentation.bottomnavigation.adapter;

import android.view.MenuItem;
import androidx.databinding.BindingAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.SelectItemBottomNavigationEnum;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "view", "Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/IBottomNavigationViewModel;", "viewModel", "", "bindSelectNavigationItemListener", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/IBottomNavigationViewModel;)V", "", "selectedItem", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;I)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingBottomNavigationAdapterKt {

    public static final class a implements BottomNavigationView.OnNavigationItemSelectedListener {
        public final /* synthetic */ IBottomNavigationViewModel a;

        public a(IBottomNavigationViewModel iBottomNavigationViewModel) {
            this.a = iBottomNavigationViewModel;
        }

        @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
        public final boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
            Intrinsics.checkParameterIsNotNull(menuItem, "it");
            return this.a.bottomItemSelected(menuItem.getItemId());
        }
    }

    @BindingAdapter({"viewModel"})
    public static final void bindSelectNavigationItemListener(@NotNull BottomNavigationView bottomNavigationView, @NotNull IBottomNavigationViewModel iBottomNavigationViewModel) {
        Intrinsics.checkParameterIsNotNull(bottomNavigationView, "view");
        Intrinsics.checkParameterIsNotNull(iBottomNavigationViewModel, "viewModel");
        bottomNavigationView.setOnNavigationItemSelectedListener(new a(iBottomNavigationViewModel));
    }

    @BindingAdapter({"selectedItem"})
    public static final void bindSelectNavigationItemListener(@NotNull BottomNavigationView bottomNavigationView, int i) {
        int i2;
        Intrinsics.checkParameterIsNotNull(bottomNavigationView, "view");
        if (i == SelectItemBottomNavigationEnum.SELECT_DASHBOARD.getElement()) {
            i2 = R.id.actionDashboard;
        } else if (i == SelectItemBottomNavigationEnum.SELECT_PROFILE_LEGACY.getElement()) {
            i2 = R.id.actionProfile;
        } else if (i == SelectItemBottomNavigationEnum.SELECT_PROFILE.getElement()) {
            i2 = R.id.actionProfile;
        } else {
            i2 = R.id.actionDashboard;
        }
        if (i2 != bottomNavigationView.getSelectedItemId()) {
            bottomNavigationView.setSelectedItemId(i2);
        }
    }
}
