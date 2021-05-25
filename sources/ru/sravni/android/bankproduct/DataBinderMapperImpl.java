package ru.sravni.android.bankproduct;

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
import ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.BottomNavigationFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ButtonAnswerItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ButtonAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatDocumentHeaderItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatDocumentInfoItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatDocumentItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatMessageSravniItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChatMessageUserItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ChooseAnswerFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.CloseChatAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.CreditDetailAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.CreditOfferItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.CreditOffersAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.EmptyItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ErrorDialogFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterBarrelDayLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterDescriptionLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterListInfoItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterListInfoLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterPanelItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterSliderLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterSnapPointLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterSwitcherListItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FilterSwitcherListLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.FreeTextAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.MaskTextAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListHeaderSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderAlternativeItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderWaitErrorSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoPrimaryItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoStandartItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoTitleItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductItemStatusTextSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListEmptySravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListHeaderSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListInfoItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductListPeriodFilterSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductStatusFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductStatusItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OsagoOffersAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.OsagoOrderAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.PassportAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ProfilePhoneFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.SlideupPanelButtonSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.SuggestItemSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.SuggestListSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.SuggestTextAnswerSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.TokenRefreshDialogSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.UtilsStubFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.WaitErrorFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.WebFragmentSravniBindingImpl;
import ru.sravni.android.bankproduct.databinding.WebviewDialogFragmentSravniBindingImpl;
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final SparseIntArray a;

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
        public static final HashMap<String, Integer> a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(73);
            a = hashMap;
            hashMap.put("layout/avito_phone_fragment_sravni_0", Integer.valueOf(R.layout.avito_phone_fragment_sravni));
            hashMap.put("layout/avito_sms_fragment_sravni_0", Integer.valueOf(R.layout.avito_sms_fragment_sravni));
            hashMap.put("layout/bottom_navigation_fragment_sravni_0", Integer.valueOf(R.layout.bottom_navigation_fragment_sravni));
            hashMap.put("layout/button_answer_item_sravni_0", Integer.valueOf(R.layout.button_answer_item_sravni));
            hashMap.put("layout/button_answer_layout_sravni_0", Integer.valueOf(R.layout.button_answer_layout_sravni));
            hashMap.put("layout/chat_document_header_item_sravni_0", Integer.valueOf(R.layout.chat_document_header_item_sravni));
            hashMap.put("layout/chat_document_info_item_sravni_0", Integer.valueOf(R.layout.chat_document_info_item_sravni));
            hashMap.put("layout/chat_document_item_sravni_0", Integer.valueOf(R.layout.chat_document_item_sravni));
            hashMap.put("layout/chat_fragment_sravni_0", Integer.valueOf(R.layout.chat_fragment_sravni));
            hashMap.put("layout/chat_message_sravni_item_sravni_0", Integer.valueOf(R.layout.chat_message_sravni_item_sravni));
            hashMap.put("layout/chat_message_user_item_sravni_0", Integer.valueOf(R.layout.chat_message_user_item_sravni));
            hashMap.put("layout/choose_answer_fragment_sravni_0", Integer.valueOf(R.layout.choose_answer_fragment_sravni));
            hashMap.put("layout/close_chat_answer_layout_sravni_0", Integer.valueOf(R.layout.close_chat_answer_layout_sravni));
            hashMap.put("layout/credit_detail_answer_layout_sravni_0", Integer.valueOf(R.layout.credit_detail_answer_layout_sravni));
            hashMap.put("layout/credit_offer_item_sravni_0", Integer.valueOf(R.layout.credit_offer_item_sravni));
            hashMap.put("layout/credit_offers_answer_layout_sravni_0", Integer.valueOf(R.layout.credit_offers_answer_layout_sravni));
            hashMap.put("layout/empty_item_sravni_0", Integer.valueOf(R.layout.empty_item_sravni));
            hashMap.put("layout/error_dialog_fragment_sravni_0", Integer.valueOf(R.layout.error_dialog_fragment_sravni));
            hashMap.put("layout/filter_barrel_day_layout_sravni_0", Integer.valueOf(R.layout.filter_barrel_day_layout_sravni));
            hashMap.put("layout/filter_description_layout_sravni_0", Integer.valueOf(R.layout.filter_description_layout_sravni));
            hashMap.put("layout/filter_list_info_item_sravni_0", Integer.valueOf(R.layout.filter_list_info_item_sravni));
            hashMap.put("layout/filter_list_info_layout_sravni_0", Integer.valueOf(R.layout.filter_list_info_layout_sravni));
            hashMap.put("layout/filter_panel_item_sravni_0", Integer.valueOf(R.layout.filter_panel_item_sravni));
            hashMap.put("layout/filter_slider_layout_sravni_0", Integer.valueOf(R.layout.filter_slider_layout_sravni));
            hashMap.put("layout/filter_snap_point_layout_sravni_0", Integer.valueOf(R.layout.filter_snap_point_layout_sravni));
            hashMap.put("layout/filter_switcher_list_item_sravni_0", Integer.valueOf(R.layout.filter_switcher_list_item_sravni));
            hashMap.put("layout/filter_switcher_list_layout_sravni_0", Integer.valueOf(R.layout.filter_switcher_list_layout_sravni));
            hashMap.put("layout/free_text_answer_layout_sravni_0", Integer.valueOf(R.layout.free_text_answer_layout_sravni));
            hashMap.put("layout/mask_text_answer_layout_sravni_0", Integer.valueOf(R.layout.mask_text_answer_layout_sravni));
            hashMap.put("layout/offer_osago_list_fragment_sravni_0", Integer.valueOf(R.layout.offer_osago_list_fragment_sravni));
            hashMap.put("layout/offer_osago_list_header_sravni_0", Integer.valueOf(R.layout.offer_osago_list_header_sravni));
            hashMap.put("layout/offer_osago_list_item_sravni_0", Integer.valueOf(R.layout.offer_osago_list_item_sravni));
            hashMap.put("layout/offer_osago_list_prolongation_item_sravni_0", Integer.valueOf(R.layout.offer_osago_list_prolongation_item_sravni));
            hashMap.put("layout/offer_osago_order_alternative_item_sravni_0", Integer.valueOf(R.layout.offer_osago_order_alternative_item_sravni));
            hashMap.put("layout/offer_osago_order_fragment_sravni_0", Integer.valueOf(R.layout.offer_osago_order_fragment_sravni));
            hashMap.put("layout/offer_osago_order_info_sravni_0", Integer.valueOf(R.layout.offer_osago_order_info_sravni));
            hashMap.put("layout/offer_osago_order_quote_sravni_0", Integer.valueOf(R.layout.offer_osago_order_quote_sravni));
            hashMap.put("layout/offer_osago_order_status_sravni_0", Integer.valueOf(R.layout.offer_osago_order_status_sravni));
            hashMap.put("layout/offer_osago_order_wait_error_sravni_0", Integer.valueOf(R.layout.offer_osago_order_wait_error_sravni));
            hashMap.put("layout/offer_product_detail_sravni_0", Integer.valueOf(R.layout.offer_product_detail_sravni));
            hashMap.put("layout/offer_product_info_fragment_sravni_0", Integer.valueOf(R.layout.offer_product_info_fragment_sravni));
            hashMap.put("layout/offer_product_info_header_item_sravni_0", Integer.valueOf(R.layout.offer_product_info_header_item_sravni));
            hashMap.put("layout/offer_product_info_primary_item_sravni_0", Integer.valueOf(R.layout.offer_product_info_primary_item_sravni));
            hashMap.put("layout/offer_product_info_standart_item_sravni_0", Integer.valueOf(R.layout.offer_product_info_standart_item_sravni));
            hashMap.put("layout/offer_product_info_title_item_sravni_0", Integer.valueOf(R.layout.offer_product_info_title_item_sravni));
            hashMap.put("layout/offer_product_item_status_text_sravni_0", Integer.valueOf(R.layout.offer_product_item_status_text_sravni));
            hashMap.put("layout/offer_product_list_empty_sravni_0", Integer.valueOf(R.layout.offer_product_list_empty_sravni));
            hashMap.put("layout/offer_product_list_fragment_sravni_0", Integer.valueOf(R.layout.offer_product_list_fragment_sravni));
            hashMap.put("layout/offer_product_list_header_sravni_0", Integer.valueOf(R.layout.offer_product_list_header_sravni));
            hashMap.put("layout/offer_product_list_info_item_sravni_0", Integer.valueOf(R.layout.offer_product_list_info_item_sravni));
            HashMap<String, Integer> hashMap2 = a;
            hashMap2.put("layout/offer_product_list_item_sravni_0", Integer.valueOf(R.layout.offer_product_list_item_sravni));
            hashMap2.put("layout/offer_product_list_period_filter_sravni_0", Integer.valueOf(R.layout.offer_product_list_period_filter_sravni));
            hashMap2.put("layout/offer_product_profitability_sravni_0", Integer.valueOf(R.layout.offer_product_profitability_sravni));
            hashMap2.put("layout/offer_product_status_fragment_sravni_0", Integer.valueOf(R.layout.offer_product_status_fragment_sravni));
            hashMap2.put("layout/offer_product_status_item_sravni_0", Integer.valueOf(R.layout.offer_product_status_item_sravni));
            hashMap2.put("layout/offer_product_status_sravni_0", Integer.valueOf(R.layout.offer_product_status_sravni));
            hashMap2.put("layout/offer_product_title_sravni_0", Integer.valueOf(R.layout.offer_product_title_sravni));
            hashMap2.put("layout/osago_offers_answer_layout_sravni_0", Integer.valueOf(R.layout.osago_offers_answer_layout_sravni));
            hashMap2.put("layout/osago_order_answer_layout_sravni_0", Integer.valueOf(R.layout.osago_order_answer_layout_sravni));
            hashMap2.put("layout/passport_answer_layout_sravni_0", Integer.valueOf(R.layout.passport_answer_layout_sravni));
            hashMap2.put("layout/profile_phone_fragment_sravni_0", Integer.valueOf(R.layout.profile_phone_fragment_sravni));
            hashMap2.put("layout/profile_sms_fragment_sravni_0", Integer.valueOf(R.layout.profile_sms_fragment_sravni));
            hashMap2.put("layout/slider_answer_layout_sravni_0", Integer.valueOf(R.layout.slider_answer_layout_sravni));
            hashMap2.put("layout/slideup_panel_button_sravni_0", Integer.valueOf(R.layout.slideup_panel_button_sravni));
            hashMap2.put("layout/suggest_item_sravni_0", Integer.valueOf(R.layout.suggest_item_sravni));
            hashMap2.put("layout/suggest_list_sravni_0", Integer.valueOf(R.layout.suggest_list_sravni));
            hashMap2.put("layout/suggest_text_answer_sravni_0", Integer.valueOf(R.layout.suggest_text_answer_sravni));
            hashMap2.put("layout/token_refresh_dialog_sravni_0", Integer.valueOf(R.layout.token_refresh_dialog_sravni));
            hashMap2.put("layout/utils_stub_fragment_sravni_0", Integer.valueOf(R.layout.utils_stub_fragment_sravni));
            hashMap2.put("layout/wait_error_fragment_sravni_0", Integer.valueOf(R.layout.wait_error_fragment_sravni));
            hashMap2.put("layout/waiting_layout_sravni_0", Integer.valueOf(R.layout.waiting_layout_sravni));
            hashMap2.put("layout/web_fragment_sravni_0", Integer.valueOf(R.layout.web_fragment_sravni));
            hashMap2.put("layout/webview_dialog_fragment_sravni_0", Integer.valueOf(R.layout.webview_dialog_fragment_sravni));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(73);
        a = sparseIntArray;
        sparseIntArray.put(R.layout.avito_phone_fragment_sravni, 1);
        sparseIntArray.put(R.layout.avito_sms_fragment_sravni, 2);
        sparseIntArray.put(R.layout.bottom_navigation_fragment_sravni, 3);
        sparseIntArray.put(R.layout.button_answer_item_sravni, 4);
        sparseIntArray.put(R.layout.button_answer_layout_sravni, 5);
        sparseIntArray.put(R.layout.chat_document_header_item_sravni, 6);
        sparseIntArray.put(R.layout.chat_document_info_item_sravni, 7);
        sparseIntArray.put(R.layout.chat_document_item_sravni, 8);
        sparseIntArray.put(R.layout.chat_fragment_sravni, 9);
        sparseIntArray.put(R.layout.chat_message_sravni_item_sravni, 10);
        sparseIntArray.put(R.layout.chat_message_user_item_sravni, 11);
        sparseIntArray.put(R.layout.choose_answer_fragment_sravni, 12);
        sparseIntArray.put(R.layout.close_chat_answer_layout_sravni, 13);
        sparseIntArray.put(R.layout.credit_detail_answer_layout_sravni, 14);
        sparseIntArray.put(R.layout.credit_offer_item_sravni, 15);
        sparseIntArray.put(R.layout.credit_offers_answer_layout_sravni, 16);
        sparseIntArray.put(R.layout.empty_item_sravni, 17);
        sparseIntArray.put(R.layout.error_dialog_fragment_sravni, 18);
        sparseIntArray.put(R.layout.filter_barrel_day_layout_sravni, 19);
        sparseIntArray.put(R.layout.filter_description_layout_sravni, 20);
        sparseIntArray.put(R.layout.filter_list_info_item_sravni, 21);
        sparseIntArray.put(R.layout.filter_list_info_layout_sravni, 22);
        sparseIntArray.put(R.layout.filter_panel_item_sravni, 23);
        sparseIntArray.put(R.layout.filter_slider_layout_sravni, 24);
        sparseIntArray.put(R.layout.filter_snap_point_layout_sravni, 25);
        sparseIntArray.put(R.layout.filter_switcher_list_item_sravni, 26);
        sparseIntArray.put(R.layout.filter_switcher_list_layout_sravni, 27);
        sparseIntArray.put(R.layout.free_text_answer_layout_sravni, 28);
        sparseIntArray.put(R.layout.mask_text_answer_layout_sravni, 29);
        sparseIntArray.put(R.layout.offer_osago_list_fragment_sravni, 30);
        sparseIntArray.put(R.layout.offer_osago_list_header_sravni, 31);
        sparseIntArray.put(R.layout.offer_osago_list_item_sravni, 32);
        sparseIntArray.put(R.layout.offer_osago_list_prolongation_item_sravni, 33);
        sparseIntArray.put(R.layout.offer_osago_order_alternative_item_sravni, 34);
        sparseIntArray.put(R.layout.offer_osago_order_fragment_sravni, 35);
        sparseIntArray.put(R.layout.offer_osago_order_info_sravni, 36);
        sparseIntArray.put(R.layout.offer_osago_order_quote_sravni, 37);
        sparseIntArray.put(R.layout.offer_osago_order_status_sravni, 38);
        sparseIntArray.put(R.layout.offer_osago_order_wait_error_sravni, 39);
        sparseIntArray.put(R.layout.offer_product_detail_sravni, 40);
        sparseIntArray.put(R.layout.offer_product_info_fragment_sravni, 41);
        sparseIntArray.put(R.layout.offer_product_info_header_item_sravni, 42);
        sparseIntArray.put(R.layout.offer_product_info_primary_item_sravni, 43);
        sparseIntArray.put(R.layout.offer_product_info_standart_item_sravni, 44);
        sparseIntArray.put(R.layout.offer_product_info_title_item_sravni, 45);
        sparseIntArray.put(R.layout.offer_product_item_status_text_sravni, 46);
        sparseIntArray.put(R.layout.offer_product_list_empty_sravni, 47);
        sparseIntArray.put(R.layout.offer_product_list_fragment_sravni, 48);
        sparseIntArray.put(R.layout.offer_product_list_header_sravni, 49);
        sparseIntArray.put(R.layout.offer_product_list_info_item_sravni, 50);
        SparseIntArray sparseIntArray2 = a;
        sparseIntArray2.put(R.layout.offer_product_list_item_sravni, 51);
        sparseIntArray2.put(R.layout.offer_product_list_period_filter_sravni, 52);
        sparseIntArray2.put(R.layout.offer_product_profitability_sravni, 53);
        sparseIntArray2.put(R.layout.offer_product_status_fragment_sravni, 54);
        sparseIntArray2.put(R.layout.offer_product_status_item_sravni, 55);
        sparseIntArray2.put(R.layout.offer_product_status_sravni, 56);
        sparseIntArray2.put(R.layout.offer_product_title_sravni, 57);
        sparseIntArray2.put(R.layout.osago_offers_answer_layout_sravni, 58);
        sparseIntArray2.put(R.layout.osago_order_answer_layout_sravni, 59);
        sparseIntArray2.put(R.layout.passport_answer_layout_sravni, 60);
        sparseIntArray2.put(R.layout.profile_phone_fragment_sravni, 61);
        sparseIntArray2.put(R.layout.profile_sms_fragment_sravni, 62);
        sparseIntArray2.put(R.layout.slider_answer_layout_sravni, 63);
        sparseIntArray2.put(R.layout.slideup_panel_button_sravni, 64);
        sparseIntArray2.put(R.layout.suggest_item_sravni, 65);
        sparseIntArray2.put(R.layout.suggest_list_sravni, 66);
        sparseIntArray2.put(R.layout.suggest_text_answer_sravni, 67);
        sparseIntArray2.put(R.layout.token_refresh_dialog_sravni, 68);
        sparseIntArray2.put(R.layout.utils_stub_fragment_sravni, 69);
        sparseIntArray2.put(R.layout.wait_error_fragment_sravni, 70);
        sparseIntArray2.put(R.layout.waiting_layout_sravni, 71);
        sparseIntArray2.put(R.layout.web_fragment_sravni, 72);
        sparseIntArray2.put(R.layout.webview_dialog_fragment_sravni, 73);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = a.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i3 = (i2 - 1) / 50;
                if (i3 == 0) {
                    switch (i2) {
                        case 1:
                            if ("layout/avito_phone_fragment_sravni_0".equals(tag)) {
                                return new AvitoPhoneFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for avito_phone_fragment_sravni is invalid. Received: ", tag));
                        case 2:
                            if ("layout/avito_sms_fragment_sravni_0".equals(tag)) {
                                return new AvitoSmsFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for avito_sms_fragment_sravni is invalid. Received: ", tag));
                        case 3:
                            if ("layout/bottom_navigation_fragment_sravni_0".equals(tag)) {
                                return new BottomNavigationFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for bottom_navigation_fragment_sravni is invalid. Received: ", tag));
                        case 4:
                            if ("layout/button_answer_item_sravni_0".equals(tag)) {
                                return new ButtonAnswerItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for button_answer_item_sravni is invalid. Received: ", tag));
                        case 5:
                            if ("layout/button_answer_layout_sravni_0".equals(tag)) {
                                return new ButtonAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for button_answer_layout_sravni is invalid. Received: ", tag));
                        case 6:
                            if ("layout/chat_document_header_item_sravni_0".equals(tag)) {
                                return new ChatDocumentHeaderItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_document_header_item_sravni is invalid. Received: ", tag));
                        case 7:
                            if ("layout/chat_document_info_item_sravni_0".equals(tag)) {
                                return new ChatDocumentInfoItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_document_info_item_sravni is invalid. Received: ", tag));
                        case 8:
                            if ("layout/chat_document_item_sravni_0".equals(tag)) {
                                return new ChatDocumentItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_document_item_sravni is invalid. Received: ", tag));
                        case 9:
                            if ("layout/chat_fragment_sravni_0".equals(tag)) {
                                return new ChatFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_fragment_sravni is invalid. Received: ", tag));
                        case 10:
                            if ("layout/chat_message_sravni_item_sravni_0".equals(tag)) {
                                return new ChatMessageSravniItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_message_sravni_item_sravni is invalid. Received: ", tag));
                        case 11:
                            if ("layout/chat_message_user_item_sravni_0".equals(tag)) {
                                return new ChatMessageUserItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for chat_message_user_item_sravni is invalid. Received: ", tag));
                        case 12:
                            if ("layout/choose_answer_fragment_sravni_0".equals(tag)) {
                                return new ChooseAnswerFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for choose_answer_fragment_sravni is invalid. Received: ", tag));
                        case 13:
                            if ("layout/close_chat_answer_layout_sravni_0".equals(tag)) {
                                return new CloseChatAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for close_chat_answer_layout_sravni is invalid. Received: ", tag));
                        case 14:
                            if ("layout/credit_detail_answer_layout_sravni_0".equals(tag)) {
                                return new CreditDetailAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for credit_detail_answer_layout_sravni is invalid. Received: ", tag));
                        case 15:
                            if ("layout/credit_offer_item_sravni_0".equals(tag)) {
                                return new CreditOfferItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for credit_offer_item_sravni is invalid. Received: ", tag));
                        case 16:
                            if ("layout/credit_offers_answer_layout_sravni_0".equals(tag)) {
                                return new CreditOffersAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for credit_offers_answer_layout_sravni is invalid. Received: ", tag));
                        case 17:
                            if ("layout/empty_item_sravni_0".equals(tag)) {
                                return new EmptyItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for empty_item_sravni is invalid. Received: ", tag));
                        case 18:
                            if ("layout/error_dialog_fragment_sravni_0".equals(tag)) {
                                return new ErrorDialogFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for error_dialog_fragment_sravni is invalid. Received: ", tag));
                        case 19:
                            if ("layout/filter_barrel_day_layout_sravni_0".equals(tag)) {
                                return new FilterBarrelDayLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_barrel_day_layout_sravni is invalid. Received: ", tag));
                        case 20:
                            if ("layout/filter_description_layout_sravni_0".equals(tag)) {
                                return new FilterDescriptionLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_description_layout_sravni is invalid. Received: ", tag));
                        case 21:
                            if ("layout/filter_list_info_item_sravni_0".equals(tag)) {
                                return new FilterListInfoItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_list_info_item_sravni is invalid. Received: ", tag));
                        case 22:
                            if ("layout/filter_list_info_layout_sravni_0".equals(tag)) {
                                return new FilterListInfoLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_list_info_layout_sravni is invalid. Received: ", tag));
                        case 23:
                            if ("layout/filter_panel_item_sravni_0".equals(tag)) {
                                return new FilterPanelItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_panel_item_sravni is invalid. Received: ", tag));
                        case 24:
                            if ("layout/filter_slider_layout_sravni_0".equals(tag)) {
                                return new FilterSliderLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_slider_layout_sravni is invalid. Received: ", tag));
                        case 25:
                            if ("layout/filter_snap_point_layout_sravni_0".equals(tag)) {
                                return new FilterSnapPointLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_snap_point_layout_sravni is invalid. Received: ", tag));
                        case 26:
                            if ("layout/filter_switcher_list_item_sravni_0".equals(tag)) {
                                return new FilterSwitcherListItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_switcher_list_item_sravni is invalid. Received: ", tag));
                        case 27:
                            if ("layout/filter_switcher_list_layout_sravni_0".equals(tag)) {
                                return new FilterSwitcherListLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for filter_switcher_list_layout_sravni is invalid. Received: ", tag));
                        case 28:
                            if ("layout/free_text_answer_layout_sravni_0".equals(tag)) {
                                return new FreeTextAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for free_text_answer_layout_sravni is invalid. Received: ", tag));
                        case 29:
                            if ("layout/mask_text_answer_layout_sravni_0".equals(tag)) {
                                return new MaskTextAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for mask_text_answer_layout_sravni is invalid. Received: ", tag));
                        case 30:
                            if ("layout/offer_osago_list_fragment_sravni_0".equals(tag)) {
                                return new OfferOsagoListFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_list_fragment_sravni is invalid. Received: ", tag));
                        case 31:
                            if ("layout/offer_osago_list_header_sravni_0".equals(tag)) {
                                return new OfferOsagoListHeaderSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_list_header_sravni is invalid. Received: ", tag));
                        case 32:
                            if ("layout/offer_osago_list_item_sravni_0".equals(tag)) {
                                return new OfferOsagoListItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_list_item_sravni is invalid. Received: ", tag));
                        case 33:
                            if ("layout/offer_osago_list_prolongation_item_sravni_0".equals(tag)) {
                                return new OfferOsagoListProlongationItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_list_prolongation_item_sravni is invalid. Received: ", tag));
                        case 34:
                            if ("layout/offer_osago_order_alternative_item_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderAlternativeItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_alternative_item_sravni is invalid. Received: ", tag));
                        case 35:
                            if ("layout/offer_osago_order_fragment_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_fragment_sravni is invalid. Received: ", tag));
                        case 36:
                            if ("layout/offer_osago_order_info_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderInfoSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_info_sravni is invalid. Received: ", tag));
                        case 37:
                            if ("layout/offer_osago_order_quote_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderQuoteSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_quote_sravni is invalid. Received: ", tag));
                        case 38:
                            if ("layout/offer_osago_order_status_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderStatusSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_status_sravni is invalid. Received: ", tag));
                        case 39:
                            if ("layout/offer_osago_order_wait_error_sravni_0".equals(tag)) {
                                return new OfferOsagoOrderWaitErrorSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_osago_order_wait_error_sravni is invalid. Received: ", tag));
                        case 40:
                            if ("layout/offer_product_detail_sravni_0".equals(tag)) {
                                return new OfferProductDetailSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_detail_sravni is invalid. Received: ", tag));
                        case 41:
                            if ("layout/offer_product_info_fragment_sravni_0".equals(tag)) {
                                return new OfferProductInfoFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_info_fragment_sravni is invalid. Received: ", tag));
                        case 42:
                            if ("layout/offer_product_info_header_item_sravni_0".equals(tag)) {
                                return new OfferProductInfoHeaderItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_info_header_item_sravni is invalid. Received: ", tag));
                        case 43:
                            if ("layout/offer_product_info_primary_item_sravni_0".equals(tag)) {
                                return new OfferProductInfoPrimaryItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_info_primary_item_sravni is invalid. Received: ", tag));
                        case 44:
                            if ("layout/offer_product_info_standart_item_sravni_0".equals(tag)) {
                                return new OfferProductInfoStandartItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_info_standart_item_sravni is invalid. Received: ", tag));
                        case 45:
                            if ("layout/offer_product_info_title_item_sravni_0".equals(tag)) {
                                return new OfferProductInfoTitleItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_info_title_item_sravni is invalid. Received: ", tag));
                        case 46:
                            if ("layout/offer_product_item_status_text_sravni_0".equals(tag)) {
                                return new OfferProductItemStatusTextSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_item_status_text_sravni is invalid. Received: ", tag));
                        case 47:
                            if ("layout/offer_product_list_empty_sravni_0".equals(tag)) {
                                return new OfferProductListEmptySravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_empty_sravni is invalid. Received: ", tag));
                        case 48:
                            if ("layout/offer_product_list_fragment_sravni_0".equals(tag)) {
                                return new OfferProductListFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_fragment_sravni is invalid. Received: ", tag));
                        case 49:
                            if ("layout/offer_product_list_header_sravni_0".equals(tag)) {
                                return new OfferProductListHeaderSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_header_sravni is invalid. Received: ", tag));
                        case 50:
                            if ("layout/offer_product_list_info_item_sravni_0".equals(tag)) {
                                return new OfferProductListInfoItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_info_item_sravni is invalid. Received: ", tag));
                        default:
                            return null;
                    }
                } else if (i3 == 1) {
                    switch (i2) {
                        case 51:
                            if ("layout/offer_product_list_item_sravni_0".equals(tag)) {
                                return new OfferProductListItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_item_sravni is invalid. Received: ", tag));
                        case 52:
                            if ("layout/offer_product_list_period_filter_sravni_0".equals(tag)) {
                                return new OfferProductListPeriodFilterSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_list_period_filter_sravni is invalid. Received: ", tag));
                        case 53:
                            if ("layout/offer_product_profitability_sravni_0".equals(tag)) {
                                return new OfferProductProfitabilitySravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_profitability_sravni is invalid. Received: ", tag));
                        case 54:
                            if ("layout/offer_product_status_fragment_sravni_0".equals(tag)) {
                                return new OfferProductStatusFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_status_fragment_sravni is invalid. Received: ", tag));
                        case 55:
                            if ("layout/offer_product_status_item_sravni_0".equals(tag)) {
                                return new OfferProductStatusItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_status_item_sravni is invalid. Received: ", tag));
                        case 56:
                            if ("layout/offer_product_status_sravni_0".equals(tag)) {
                                return new OfferProductStatusSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_status_sravni is invalid. Received: ", tag));
                        case 57:
                            if ("layout/offer_product_title_sravni_0".equals(tag)) {
                                return new OfferProductTitleSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for offer_product_title_sravni is invalid. Received: ", tag));
                        case 58:
                            if ("layout/osago_offers_answer_layout_sravni_0".equals(tag)) {
                                return new OsagoOffersAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for osago_offers_answer_layout_sravni is invalid. Received: ", tag));
                        case 59:
                            if ("layout/osago_order_answer_layout_sravni_0".equals(tag)) {
                                return new OsagoOrderAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for osago_order_answer_layout_sravni is invalid. Received: ", tag));
                        case 60:
                            if ("layout/passport_answer_layout_sravni_0".equals(tag)) {
                                return new PassportAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for passport_answer_layout_sravni is invalid. Received: ", tag));
                        case 61:
                            if ("layout/profile_phone_fragment_sravni_0".equals(tag)) {
                                return new ProfilePhoneFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for profile_phone_fragment_sravni is invalid. Received: ", tag));
                        case 62:
                            if ("layout/profile_sms_fragment_sravni_0".equals(tag)) {
                                return new ProfileSmsFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for profile_sms_fragment_sravni is invalid. Received: ", tag));
                        case 63:
                            if ("layout/slider_answer_layout_sravni_0".equals(tag)) {
                                return new SliderAnswerLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for slider_answer_layout_sravni is invalid. Received: ", tag));
                        case 64:
                            if ("layout/slideup_panel_button_sravni_0".equals(tag)) {
                                return new SlideupPanelButtonSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for slideup_panel_button_sravni is invalid. Received: ", tag));
                        case 65:
                            if ("layout/suggest_item_sravni_0".equals(tag)) {
                                return new SuggestItemSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for suggest_item_sravni is invalid. Received: ", tag));
                        case 66:
                            if ("layout/suggest_list_sravni_0".equals(tag)) {
                                return new SuggestListSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for suggest_list_sravni is invalid. Received: ", tag));
                        case 67:
                            if ("layout/suggest_text_answer_sravni_0".equals(tag)) {
                                return new SuggestTextAnswerSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for suggest_text_answer_sravni is invalid. Received: ", tag));
                        case 68:
                            if ("layout/token_refresh_dialog_sravni_0".equals(tag)) {
                                return new TokenRefreshDialogSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for token_refresh_dialog_sravni is invalid. Received: ", tag));
                        case 69:
                            if ("layout/utils_stub_fragment_sravni_0".equals(tag)) {
                                return new UtilsStubFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for utils_stub_fragment_sravni is invalid. Received: ", tag));
                        case 70:
                            if ("layout/wait_error_fragment_sravni_0".equals(tag)) {
                                return new WaitErrorFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for wait_error_fragment_sravni is invalid. Received: ", tag));
                        case 71:
                            if ("layout/waiting_layout_sravni_0".equals(tag)) {
                                return new WaitingLayoutSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for waiting_layout_sravni is invalid. Received: ", tag));
                        case 72:
                            if ("layout/web_fragment_sravni_0".equals(tag)) {
                                return new WebFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for web_fragment_sravni is invalid. Received: ", tag));
                        case 73:
                            if ("layout/webview_dialog_fragment_sravni_0".equals(tag)) {
                                return new WebviewDialogFragmentSravniBindingImpl(dataBindingComponent, view);
                            }
                            throw new IllegalArgumentException(a2.b.a.a.a.b3("The tag for webview_dialog_fragment_sravni is invalid. Received: ", tag));
                        default:
                            return null;
                    }
                }
            } else {
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
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
