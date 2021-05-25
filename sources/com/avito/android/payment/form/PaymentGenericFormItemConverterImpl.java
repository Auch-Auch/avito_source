package com.avito.android.payment.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.conveyor_shared_item.phone_item.PhoneInputItem;
import com.avito.android.payment.form.ScreenState;
import com.avito.android.payment.items.TextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonItem;
import ru.avito.component.info_label.InfoLabelItem;
import ru.avito.component.info_label.InfoLevel;
import t6.n.d;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/payment/form/PaymentGenericFormItemConverterImpl;", "Lcom/avito/android/payment/form/PaymentGenericFormItemConverter;", "Lcom/avito/android/payment/form/ContentModel;", "contentModel", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "forceKeyboard", "Lcom/avito/android/payment/form/ScreenState$Content;", "convert", "(Lcom/avito/android/payment/form/ContentModel;Lcom/avito/android/remote/model/category_parameters/ParametersTree;Z)Lcom/avito/android/payment/form/ScreenState$Content;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/payment/form/DelegateItemConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/form/DelegateItemConverter;", "nonPhoneParametersDelegate", "<init>", "(Lcom/avito/android/payment/form/DelegateItemConverter;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class PaymentGenericFormItemConverterImpl implements PaymentGenericFormItemConverter {
    public final DelegateItemConverter a;
    public final AttributedTextFormatter b;

    public PaymentGenericFormItemConverterImpl(@NotNull DelegateItemConverter delegateItemConverter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(delegateItemConverter, "nonPhoneParametersDelegate");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = delegateItemConverter;
        this.b = attributedTextFormatter;
    }

    @Override // com.avito.android.payment.form.PaymentGenericFormItemConverter
    @NotNull
    public ScreenState.Content convert(@NotNull ContentModel contentModel, @NotNull ParametersTree parametersTree, boolean z) {
        Intrinsics.checkNotNullParameter(contentModel, "contentModel");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        ArrayList arrayList = new ArrayList();
        CharSequence format = this.b.format(contentModel.getInformation());
        if (format == null) {
            format = "";
        }
        arrayList.addAll(d.listOf(new TextItem.InfoTextItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, format)));
        ArrayList arrayList2 = new ArrayList();
        int count = parametersTree.getCount() - 1;
        if (count >= 0) {
            int i = 0;
            while (true) {
                ParameterSlot parameterSlot = (ParameterSlot) parametersTree.getItem(i);
                if (parameterSlot instanceof PhoneParameter) {
                    PhoneParameter phoneParameter = (PhoneParameter) parameterSlot;
                    ArrayList arrayList3 = new ArrayList();
                    String id = phoneParameter.getId();
                    String title = phoneParameter.getTitle();
                    String str = (String) phoneParameter.getValue();
                    if (str == null) {
                        str = "";
                    }
                    String error = phoneParameter.getError();
                    arrayList3.add(new PhoneInputItem(id, title, str, !(error == null || m.isBlank(error))));
                    String error2 = phoneParameter.getError();
                    if (!(error2 == null || m.isBlank(error2))) {
                        String str2 = phoneParameter.getId() + " info label";
                        String error3 = phoneParameter.getError();
                        Intrinsics.checkNotNull(error3);
                        arrayList3.add(new InfoLabelItem(str2, error3, InfoLevel.ERROR));
                    }
                    arrayList2.addAll(arrayList3);
                } else {
                    arrayList2.addAll(this.a.convert(parameterSlot));
                }
                if (i == count) {
                    break;
                }
                i++;
            }
        }
        arrayList.addAll(arrayList2);
        arrayList.addAll(d.listOf(new ButtonItem("id", true, contentModel.getSubmitText())));
        return new ScreenState.Content(contentModel.getTitle(), arrayList, z);
    }
}
