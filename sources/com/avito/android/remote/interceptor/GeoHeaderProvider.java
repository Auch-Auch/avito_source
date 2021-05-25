package com.avito.android.remote.interceptor;

import android.location.Location;
import com.avito.android.geo.GeoStorage;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.auth.AuthSource;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/interceptor/GeoHeaderProvider;", "Lcom/avito/android/remote/interceptor/HeaderProvider;", "Lcom/avito/android/geo/GeoStorage;", "c", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "", "isMandatory", "Z", "()Z", "Ljava/text/DecimalFormat;", AuthSource.SEND_ABUSE, "Ljava/text/DecimalFormat;", "format", "", "getValue", "()Ljava/lang/String;", "value", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getKey", "key", "<init>", "(Lcom/avito/android/geo/GeoStorage;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class GeoHeaderProvider implements HeaderProvider {
    public final DecimalFormat a;
    @NotNull
    public final String b = "X-Geo";
    public final GeoStorage c;

    @Inject
    public GeoHeaderProvider(@NotNull GeoStorage geoStorage) {
        Intrinsics.checkNotNullParameter(geoStorage, "geoStorage");
        this.c = geoStorage;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator(FormatterType.defaultDecimalSeparator);
        DecimalFormat decimalFormat = new DecimalFormat("0.######", decimalFormatSymbols);
        this.a = decimalFormat;
        decimalFormat.setGroupingUsed(false);
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @NotNull
    public String getKey() {
        return this.b;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    @Nullable
    public String getValue() {
        Location location = this.c.getLocation();
        if (location == null) {
            return null;
        }
        String format = String.format(Locale.ENGLISH, "%s;%s;%s;%d", Arrays.copyOf(new Object[]{this.a.format(location.getLatitude()), this.a.format(location.getLongitude()), this.a.format((double) location.getAccuracy()), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(location.getTime()))}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    @Override // com.avito.android.remote.interceptor.HeaderProvider
    public boolean isMandatory() {
        return false;
    }
}
