package com.avito.android.express_cv;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.Formatter;
import com.avito.android.util.RawPhoneNumberFormatter;
import com.avito.android.util.preferences.GeoContract;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/express_cv/ParametersConverterImpl;", "Lcom/avito/android/express_cv/ParametersConverter;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "", "convertToMap", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/Map;", "Ljava/text/DecimalFormat;", AuthSource.SEND_ABUSE, "Ljava/text/DecimalFormat;", "geoFormat", "Lcom/avito/android/util/Formatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "<init>", "(Lcom/avito/android/util/Formatter;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ParametersConverterImpl implements ParametersConverter {
    public final DecimalFormat a;
    public final Formatter<String> b;

    public ParametersConverterImpl() {
        this(null, 1, null);
    }

    public ParametersConverterImpl(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        this.b = formatter;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator(FormatterType.defaultDecimalSeparator);
        Unit unit = Unit.INSTANCE;
        this.a = new DecimalFormat("0.000000", decimalFormatSymbols);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: com.avito.android.util.Formatter<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.express_cv.ParametersConverter
    @NotNull
    public Map<String, String> convertToMap(@NotNull ParametersTree parametersTree) {
        AddressParameter.Value value;
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int count = parametersTree.getCount();
        for (int i = 0; i < count; i++) {
            ParameterSlot parameterSlot = (ParameterSlot) parametersTree.getItem(i);
            if (parameterSlot instanceof PhoneParameter) {
                linkedHashMap.put(parameterSlot.getId(), this.b.format(((PhoneParameter) parameterSlot).getValue()));
            } else if (parameterSlot instanceof CharParameter) {
                String id = parameterSlot.getId();
                String str = (String) ((CharParameter) parameterSlot).getValue();
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put(id, str);
            } else if ((parameterSlot instanceof AddressParameter) && (value = (AddressParameter.Value) ((AddressParameter) parameterSlot).getValue()) != null) {
                String format = this.a.format(value.getLng());
                Intrinsics.checkNotNullExpressionValue(format, "geoFormat.format(it.lng)");
                linkedHashMap.put(GeoContract.LONGITUDE, format);
                String format2 = this.a.format(value.getLat());
                Intrinsics.checkNotNullExpressionValue(format2, "geoFormat.format(it.lat)");
                linkedHashMap.put(GeoContract.LATITUDE, format2);
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParametersConverterImpl(Formatter formatter, int i, j jVar) {
        this((i & 1) != 0 ? new RawPhoneNumberFormatter() : formatter);
    }
}
