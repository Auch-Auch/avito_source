package com.avito.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final SparseIntArray a = new SparseIntArray(0);

    public static class a {
        public static final SparseArray<String> a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(78);
            a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "alternativeCompany");
            sparseArray.put(2, "barrelDayViewModel");
            sparseArray.put(3, "buttonAnswerInfo");
            sparseArray.put(4, "buttonAnswerViewModel");
            sparseArray.put(5, "buttonPanelViewModel");
            sparseArray.put(6, "chatLifecycleOwner");
            sparseArray.put(7, "chatViewModel");
            sparseArray.put(8, "clickOfferProduct");
            sparseArray.put(9, "clickSendAnswer");
            sparseArray.put(10, "company");
            sparseArray.put(11, "creditDetailAnswerViewModel");
            sparseArray.put(12, "creditOffersAnswerViewModel");
            sparseArray.put(13, "description");
            sparseArray.put(14, "descriptionViewModel");
            sparseArray.put(15, "detailInfo");
            sparseArray.put(16, "filterInfo");
            sparseArray.put(17, "filterItem");
            sparseArray.put(18, "filterSelector");
            sparseArray.put(19, "firstItem");
            sparseArray.put(20, "freeTextAnswerViewModel");
            sparseArray.put(21, "goToDashboardAnswerViewModel");
            sparseArray.put(22, "headerInfoLogo");
            sparseArray.put(23, "iconStatus");
            sparseArray.put(24, "isAnimationActive");
            sparseArray.put(25, "isNextMessageFromBot");
            sparseArray.put(26, "listInfoViewModel");
            sparseArray.put(27, "logoInfo");
            sparseArray.put(28, "mainParam");
            sparseArray.put(29, "maskTextAnswerViewModel");
            sparseArray.put(30, "message");
            sparseArray.put(31, "messageDescription");
            sparseArray.put(32, "needAlternativeCompany");
            sparseArray.put(33, "nextContentCard");
            sparseArray.put(34, BaseAnalyticKt.ANALYTIC_MODULE_OFFER);
            sparseArray.put(35, "offerOsagoListViewModel");
            sparseArray.put(36, "offerOsagoOrderViewModel");
            sparseArray.put(37, "offerProductInfoViewModel");
            sparseArray.put(38, "offerProductListViewModel");
            sparseArray.put(39, "offerProductStatusInfo");
            sparseArray.put(40, "offerRetryErrorViewModel");
            sparseArray.put(41, "offerTitleInfo");
            sparseArray.put(42, "osagoCompanyOrder");
            sparseArray.put(43, "osagoDetail");
            sparseArray.put(44, "osagoOffersAnswerViewModel");
            sparseArray.put(45, "osagoOrderAnswerViewModel");
            sparseArray.put(46, "osagoPaymentInfo");
            sparseArray.put(47, "panelButtonViewModel");
            sparseArray.put(48, "panelViewModel");
            sparseArray.put(49, "passportScanAnswerViewModel");
            sparseArray.put(50, "phoneViewModel");
            sparseArray.put(51, "productAction");
            sparseArray.put(52, "productActionGetter");
            sparseArray.put(53, "profitability");
            sparseArray.put(54, "profitabilityText");
            sparseArray.put(55, ShareConstants.WEB_DIALOG_PARAM_QUOTE);
            sparseArray.put(56, "selectOfferOsago");
            sparseArray.put(57, "selectOfferProduct");
            sparseArray.put(58, "slideLifecycleOwner");
            sparseArray.put(59, "sliderAnswerViewModel");
            sparseArray.put(60, "sliderViewModel");
            sparseArray.put(61, "smsViewModel");
            sparseArray.put(62, "snapPointViewModel");
            sparseArray.put(63, "statusEnum");
            sparseArray.put(64, "statusInfo");
            sparseArray.put(65, "statusText");
            sparseArray.put(66, "suggestInfo");
            sparseArray.put(67, "suggestInfoSetter");
            sparseArray.put(68, "suggestList");
            sparseArray.put(69, "suggestionAnswerViewModel");
            sparseArray.put(70, "switcherChanged");
            sparseArray.put(71, "switcherInfo");
            sparseArray.put(72, "switcherListViewModel");
            sparseArray.put(73, "tapQuote");
            sparseArray.put(74, "title");
            sparseArray.put(75, "titleGroup");
            sparseArray.put(76, "viewModel");
            sparseArray.put(77, "webViewModel");
        }
    }

    public static class b {
        public static final HashMap<String, Integer> a = new HashMap<>(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new ru.sravni.android.bankproduct.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
