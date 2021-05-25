package ru.sravni.android.bankproduct.presentation.main.viewmodel;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavOptions;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.browser.BrowserAnalyticOpenInfo;
import ru.sravni.android.bankproduct.analytic.v2.browser.IBrowserAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.utils.navigation.DataForNavigation;
import ru.sravni.android.bankproduct.utils.navigation.DataForPopBack;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfoController;
import ru.sravni.android.bankproduct.utils.navigation.entity.DataForOpenWeb;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\b>\u0010?J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J+\u0010\u0018\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001eR\"\u0010.\u001a\b\u0012\u0004\u0012\u00020+0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010\u001c\u001a\u0004\b-\u0010\u001eR\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u001c\u001a\u0004\b8\u0010\u001eR\"\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e¨\u0006@"}, d2 = {"Lru/sravni/android/bankproduct/presentation/main/viewmodel/NavigationViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/main/viewmodel/INavigationViewModel;", "", "screenID", "", "argumentJson", "Landroidx/navigation/NavOptions$Builder;", "navOptions", "", AnalyticFieldsName.route, "(ILjava/lang/String;Landroidx/navigation/NavOptions$Builder;)V", "", "inclusive", "popBackStack", "(IZ)V", "popBack", "()V", "exitFromProfile", "urlProduct", "Ljava/lang/Runnable;", "completion", "Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;", "analyticOpenInfo", "openWebView", "(Ljava/lang/String;Ljava/lang/Runnable;Lru/sravni/android/bankproduct/analytic/v2/browser/BrowserAnalyticOpenInfo;)V", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "getExitFromProfile", "()Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "i", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "h", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/navigation/DataForNavigation;", "c", "getMainNavigationData", "mainNavigationData", "Lru/sravni/android/bankproduct/utils/navigation/DataForPopBack;", "d", "getPopBackStackData", "popBackStackData", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "j", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;", "previousModuleInfoController", "Lru/sravni/android/bankproduct/analytic/v2/browser/IBrowserAnalytic;", "k", "Lru/sravni/android/bankproduct/analytic/v2/browser/IBrowserAnalytic;", "browserAnalytic", g.a, "getBackSignal", "backSignal", "Lru/sravni/android/bankproduct/utils/navigation/entity/DataForOpenWeb;", "f", "getOpenWebData", "openWebData", "<init>", "(Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfoController;Lru/sravni/android/bankproduct/analytic/v2/browser/IBrowserAnalytic;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class NavigationViewModel extends ViewModel implements INavigationViewModel {
    @NotNull
    public final MutableLiveData<DataForNavigation> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DataForPopBack> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<DataForOpenWeb> f = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Unit> g = new MutableLiveData<>();
    public final IErrorLogger h;
    public final IThrowableWrapper i;
    public final IPreviousModuleInfoController j;
    public final IBrowserAnalytic k;

    public NavigationViewModel(@NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfoController iPreviousModuleInfoController, @NotNull IBrowserAnalytic iBrowserAnalytic) {
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfoController, "previousModuleInfoController");
        Intrinsics.checkParameterIsNotNull(iBrowserAnalytic, "browserAnalytic");
        this.h = iErrorLogger;
        this.i = iThrowableWrapper;
        this.j = iPreviousModuleInfoController;
        this.k = iBrowserAnalytic;
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.INavigator
    public void exitFromProfile() {
        getExitFromProfile().postValue(Integer.valueOf(R.id.exit_from_profile));
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.INavigator
    public void openWebView(@Nullable String str, @Nullable Runnable runnable, @NotNull BrowserAnalyticOpenInfo browserAnalyticOpenInfo) {
        Intrinsics.checkParameterIsNotNull(browserAnalyticOpenInfo, "analyticOpenInfo");
        this.j.setCurrentModuleName(BaseAnalyticKt.ANALYTIC_MODULE_BROWSER);
        this.k.sendBrowserOpenEvent(browserAnalyticOpenInfo, this.j.getPreviousModuleName());
        if (str != null && !m.startsWith$default(str, "http://", false, 2, null) && !m.startsWith$default(str, "https://", false, 2, null)) {
            this.h.logError(MessagePriority.WARN, this.i.wrap(new UrlWithoutHttpError(a.c3("url = ", str))));
            str = "http://" + str;
        }
        try {
            Uri parse = Uri.parse(str);
            MutableLiveData<DataForOpenWeb> openWebData = getOpenWebData();
            Intrinsics.checkExpressionValueIsNotNull(parse, ShareConstants.MEDIA_URI);
            openWebData.postValue(new DataForOpenWeb(parse, runnable));
        } catch (Throwable unused) {
            this.h.logError(MessagePriority.ERROR, this.i.wrap(new NullUriError(a.c3("url = ", str))));
            this.k.sendBrowserFailEvent(BaseAnalyticKt.ANALYTIC_FAIL_MODULE, this.j.getPreviousModuleName(), browserAnalyticOpenInfo.getProductName(), browserAnalyticOpenInfo.getPush());
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.INavigator
    public void popBack() {
        getBackSignal().postValue(Unit.INSTANCE);
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.INavigator
    public void popBackStack(int i2, boolean z) {
        getPopBackStackData().postValue(new DataForPopBack(i2, z));
    }

    @Override // ru.sravni.android.bankproduct.utils.navigation.INavigator
    public void route(int i2, @Nullable String str, @Nullable NavOptions.Builder builder) {
        getMainNavigationData().postValue(new DataForNavigation(i2, str, builder));
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel
    @NotNull
    public MutableLiveData<Unit> getBackSignal() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel
    @NotNull
    public MutableLiveData<Integer> getExitFromProfile() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel
    @NotNull
    public MutableLiveData<DataForNavigation> getMainNavigationData() {
        return this.c;
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel
    @NotNull
    public MutableLiveData<DataForOpenWeb> getOpenWebData() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel
    @NotNull
    public MutableLiveData<DataForPopBack> getPopBackStackData() {
        return this.d;
    }
}
