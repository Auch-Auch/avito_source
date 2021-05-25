package com.avito.android.location_picker.providers;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.location_picker.R;
import com.avito.android.remote.auth.AuthSource;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0018\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017¨\u0006%"}, d2 = {"Lcom/avito/android/location_picker/providers/LocationPickerResourceProviderImpl;", "Lcom/avito/android/location_picker/providers/LocationPickerResourceProvider;", "", "count", "", "getAdvertsCountTitle", "(I)Ljava/lang/String;", "Ljava/text/DecimalFormat;", AuthSource.SEND_ABUSE, "Ljava/text/DecimalFormat;", "advertsCountFormatter", "Ljava/util/Locale;", g.a, "Ljava/util/Locale;", "locale", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getAdvertsCountErrorMessage", "()Ljava/lang/String;", "advertsCountErrorMessage", "d", "I", "getRadiusPadding", "()I", "radiusPadding", "e", "getRadiusWidgetOffset", "radiusWidgetOffset", "Landroid/content/res/Resources;", "f", "Landroid/content/res/Resources;", "resources", "c", "getFindMeButtonMargin", "findMeButtonMargin", "<init>", "(Landroid/content/res/Resources;Ljava/util/Locale;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerResourceProviderImpl implements LocationPickerResourceProvider {
    public final DecimalFormat a;
    @NotNull
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final Resources f;
    public final Locale g;

    @Inject
    public LocationPickerResourceProviderImpl(@NotNull Resources resources, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.f = resources;
        this.g = locale;
        NumberFormat instance = NumberFormat.getInstance(locale);
        Objects.requireNonNull(instance, "null cannot be cast to non-null type java.text.DecimalFormat");
        DecimalFormat decimalFormat = (DecimalFormat) instance;
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        Intrinsics.checkNotNullExpressionValue(decimalFormatSymbols, "it.decimalFormatSymbols");
        decimalFormatSymbols.setGroupingSeparator(' ');
        Unit unit = Unit.INSTANCE;
        this.a = decimalFormat;
        String string = resources.getString(R.string.lp_choose_radius_btn_show);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…p_choose_radius_btn_show)");
        this.b = string;
        this.c = resources.getDimensionPixelSize(R.dimen.find_me_button_margin_above_radius_list);
        this.d = resources.getDimensionPixelSize(R.dimen.location_picker_radius_padding);
        this.e = resources.getDimensionPixelSize(R.dimen.location_picker_radius_offset);
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerResourceProvider
    @NotNull
    public String getAdvertsCountErrorMessage() {
        return this.b;
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerResourceProvider
    @NotNull
    public String getAdvertsCountTitle(int i) {
        if (i > 0) {
            String quantityString = this.f.getQuantityString(R.plurals.show_n_adverts, i, this.a.format(Integer.valueOf(i)));
            Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…tFormatter.format(count))");
            return quantityString;
        }
        String string = this.f.getString(R.string.lp_choose_radius_btn_no_adverts);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…se_radius_btn_no_adverts)");
        return string;
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerResourceProvider
    public int getFindMeButtonMargin() {
        return this.c;
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerResourceProvider
    public int getRadiusPadding() {
        return this.d;
    }

    @Override // com.avito.android.location_picker.providers.LocationPickerResourceProvider
    public int getRadiusWidgetOffset() {
        return this.e;
    }
}
