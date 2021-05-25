package ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.main.IMainAnalytic;
import ru.sravni.android.bankproduct.domain.featuretoggle.IFeatureToggleRouterDomain;
import ru.sravni.android.bankproduct.featuretoggle.config.FeaturesToToggle;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/BottomNavigationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/IBottomNavigationViewModel;", "", "itemID", "", "bottomItemSelected", "(I)Z", "", "onStartAction", "()V", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "e", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousModuleInfoController", "Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;", "d", "Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;", "mainAnalytic", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "f", "Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;", "featureToggleRouter", "Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/SelectItemBottomNavigationEnum;", "c", "Landroidx/lifecycle/MutableLiveData;", "getSelectItemElement", "()Landroidx/lifecycle/MutableLiveData;", "selectItemElement", "<init>", "(Lru/sravni/android/bankproduct/analytic/v2/main/IMainAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/domain/featuretoggle/IFeatureToggleRouterDomain;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BottomNavigationViewModel extends ViewModel implements IBottomNavigationViewModel {
    @NotNull
    public final MutableLiveData<SelectItemBottomNavigationEnum> c = new MutableLiveData<>();
    public final IMainAnalytic d;
    public final IPreviousModuleInfoController e;
    public final IFeatureToggleRouterDomain f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SelectItemBottomNavigationEnum.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            SelectItemBottomNavigationEnum selectItemBottomNavigationEnum = SelectItemBottomNavigationEnum.SELECT_DASHBOARD;
            iArr[0] = 1;
            SelectItemBottomNavigationEnum selectItemBottomNavigationEnum2 = SelectItemBottomNavigationEnum.SELECT_PROFILE;
            iArr[1] = 2;
            SelectItemBottomNavigationEnum selectItemBottomNavigationEnum3 = SelectItemBottomNavigationEnum.SELECT_PROFILE_LEGACY;
            iArr[2] = 3;
        }
    }

    public BottomNavigationViewModel(@NotNull IMainAnalytic iMainAnalytic, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IFeatureToggleRouterDomain iFeatureToggleRouterDomain) {
        Intrinsics.checkParameterIsNotNull(iMainAnalytic, "mainAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousModuleInfoController");
        Intrinsics.checkParameterIsNotNull(iFeatureToggleRouterDomain, "featureToggleRouter");
        this.d = iMainAnalytic;
        this.e = iPreviousModuleInfoController;
        this.f = iFeatureToggleRouterDomain;
        getSelectItemElement().setValue(SelectItemBottomNavigationEnum.SELECT_DASHBOARD);
    }

    @Override // ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel
    public boolean bottomItemSelected(int i) {
        SelectItemBottomNavigationEnum selectItemBottomNavigationEnum;
        SelectItemBottomNavigationEnum selectItemBottomNavigationEnum2;
        SelectItemBottomNavigationEnum selectItemBottomNavigationEnum3;
        if (i == R.id.actionDashboard && getSelectItemElement().getValue() != (selectItemBottomNavigationEnum3 = SelectItemBottomNavigationEnum.SELECT_DASHBOARD)) {
            getSelectItemElement().setValue(selectItemBottomNavigationEnum3);
            onStartAction();
            return true;
        } else if (i != R.id.actionProfile || getSelectItemElement().getValue() == (selectItemBottomNavigationEnum = SelectItemBottomNavigationEnum.SELECT_PROFILE) || getSelectItemElement().getValue() == (selectItemBottomNavigationEnum2 = SelectItemBottomNavigationEnum.SELECT_PROFILE_LEGACY)) {
            return true;
        } else {
            if (this.f.featureIsEnabled(FeaturesToToggle.newProfile)) {
                getSelectItemElement().setValue(selectItemBottomNavigationEnum);
            } else {
                getSelectItemElement().setValue(selectItemBottomNavigationEnum2);
            }
            onStartAction();
            return true;
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel
    public void onStartAction() {
        SelectItemBottomNavigationEnum value = getSelectItemElement().getValue();
        if (value != null) {
            int ordinal = value.ordinal();
            if (ordinal == 0) {
                this.e.setCurrentModuleName("main");
                IBaseAnalytic.DefaultImpls.sendOpenEvent$default(this.d, this.e.getPreviousModuleName(), null, null, 6, null);
            } else if (ordinal == 1 || ordinal == 2) {
                this.e.setCurrentModuleName(BaseAnalyticKt.ANALYTIC_MODULE_ACCOUNT);
            }
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel
    @NotNull
    public MutableLiveData<SelectItemBottomNavigationEnum> getSelectItemElement() {
        return this.c;
    }
}
