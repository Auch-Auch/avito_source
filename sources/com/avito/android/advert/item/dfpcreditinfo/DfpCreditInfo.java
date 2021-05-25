package com.avito.android.advert.item.dfpcreditinfo;

import a2.b.a.a.a;
import a2.g.r.g;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator;
import com.avito.android.advert.item.dfpcreditinfo.calculator.DefaultAnnuityCreditCalculator;
import com.avito.android.advert.item.dfpcreditinfo.calculator.TinkoffAnnuityCreditCalculator;
import com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0006\u000e\u000f\u0010\u0011\u0012\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\u0004R\u0015\u0010\r\u001a\u0004\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "", "", "getLegalInfoOpt", "()Ljava/lang/String;", "legalInfoOpt", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSource", "source", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "getTemplateAdOpt", "()Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "templateAdOpt", "Companion", "CreditCalculator", "Empty", "Stub", "Type", "Web", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Web;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Empty;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Stub;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public abstract class DfpCreditInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    public final String a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Companion;", "", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "nativeCustomTemplateAd", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Type;", "parseType", "(Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;)Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Type;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Type parseType(@NotNull NativeCustomTemplateAd nativeCustomTemplateAd) {
            String obj;
            Type type;
            Intrinsics.checkNotNullParameter(nativeCustomTemplateAd, "nativeCustomTemplateAd");
            CharSequence text = nativeCustomTemplateAd.getText("banner_type");
            if (text == null || (obj = text.toString()) == null) {
                return Type.Web;
            }
            try {
                int parseInt = Integer.parseInt(obj);
                Type[] values = Type.values();
                int i = 0;
                while (true) {
                    if (i >= 5) {
                        type = null;
                        break;
                    }
                    type = values[i];
                    if (type.getValue() == parseInt) {
                        break;
                    }
                    i++;
                }
                if (type != null) {
                    return type;
                }
                return Type.Web;
            } catch (Throwable unused) {
                return Type.Web;
            }
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0001\u0001\u0001BB\b\u0002\u0012\u0006\u0010h\u001a\u00020c\u0012\u0007\u0010\u0001\u001a\u00020\u0002\u0012\u0006\u0010m\u001a\u00020i\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\b\u0002\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000fR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0019\u0010\"\u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010+\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b*\u0010\u000fR\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00104\u001a\u00020/8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0019\u00109\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b;\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010\r\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010BR\u0019\u0010F\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010\r\u001a\u0004\bE\u0010\u000fR\u0019\u0010I\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010\r\u001a\u0004\bH\u0010\u000fR\u0019\u0010L\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010\r\u001a\u0004\bK\u0010\u000fR$\u0010P\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bM\u0010\r\u001a\u0004\bN\u0010\u000f\"\u0004\bO\u0010BR\"\u0010T\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bQ\u0010\r\u001a\u0004\bR\u0010\u000f\"\u0004\bS\u0010BR\u0019\u0010W\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bU\u00106\u001a\u0004\bV\u00108R\u0019\u0010Z\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010\r\u001a\u0004\bY\u0010\u000fR\"\u0010^\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b[\u00106\u001a\u0004\b\\\u00108\"\u0004\b]\u0010>R\"\u0010b\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b_\u0010\r\u001a\u0004\b`\u0010\u000f\"\u0004\ba\u0010BR\u0019\u0010h\u001a\u00020c8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0019\u0010m\u001a\u00020i8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010j\u001a\u0004\bk\u0010lR)\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u00020nj\b\u0012\u0004\u0012\u00020\u0002`o8\u0006@\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR*\u0010\u0005\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\bu\u00106\u001a\u0004\bv\u00108\"\u0004\bw\u0010>R\u0018\u0010z\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u001b\u0010~\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010y\u001a\u0004\b|\u0010}R-\u0010\u0001\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0014\n\u0004\b\u00106\u001a\u0005\b\u0001\u00108\"\u0005\b\u0001\u0010>R!\u0010\u0001\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010\r\u001a\u0005\b\u0001\u0010\u000fR\u001c\u0010\u0001\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u00106\u001a\u0005\b\u0001\u00108\u0001\u0004\u0001\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "loan", "", "calculate", "(III)V", "updateTitleWithMonthlyPayment", "()V", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "r", "getMaxLoanFormatted", "maxLoanFormatted", "Ljava/text/NumberFormat;", ExifInterface.LONGITUDE_EAST, "Ljava/text/NumberFormat;", "priceFormatter", "e", "getText", "text", "c", "headerPriceHolder", "Landroid/net/Uri;", "j", "Landroid/net/Uri;", "getClickUri", "()Landroid/net/Uri;", "clickUri", "", "n", "Ljava/lang/Double;", "getPercentYear", "()Ljava/lang/Double;", "percentYear", "f", "getLegalInfo", "legalInfo", "k", "D", "initialFeePercent", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", "getConverter", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", "converter", "o", "I", "getMinLoan", "()I", "minLoan", "value", "u", "getInitialPayment", "setInitialPayment", "(I)V", "y", "getMonthlyPaymentFormatted", "setMonthlyPaymentFormatted", "(Ljava/lang/String;)V", "monthlyPaymentFormatted", "h", "getPrivacyText", "privacyText", "s", "getPercentFormatted", "percentFormatted", g.a, "getButtonText", "buttonText", "x", "getTitleWithPrice", "setTitleWithPrice", "titleWithPrice", "z", "getInitialPaymentFormatted", "setInitialPaymentFormatted", "initialPaymentFormatted", "p", "getMaxLoan", "maxLoan", "i", "getPrivacyLink", "privacyLink", "w", "getPaymentTerm", "setPaymentTerm", "paymentTerm", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getLoanFormatted", "setLoanFormatted", "loanFormatted", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "B", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "getNativeCustomTemplateAd", "()Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "nativeCustomTemplateAd", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "getLinkType", "()Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "linkType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", VKApiConst.Q, "Ljava/util/ArrayList;", "getTerms", "()Ljava/util/ArrayList;", "terms", "t", "getLoan", "setLoan", "l", "Ljava/lang/Integer;", "maxMonthlyPayment", AuthSource.OPEN_CHANNEL_LIST, "getMaxLoanDefaultValue", "()Ljava/lang/Integer;", "maxLoanDefaultValue", VKApiConst.VERSION, "getMonthlyPayment", "setMonthlyPayment", "monthlyPayment", "inputHint", "getInputHint", "C", "getPrice", "price", "Ljava/text/DecimalFormat;", "percentFormatter", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;", "annuityCalculator", "<init>", "(Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;ILcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;Ljava/text/NumberFormat;Ljava/text/DecimalFormat;Lcom/avito/android/advert/item/dfpcreditinfo/calculator/AnnuityCreditCalculator;)V", "CalculatorLinkType", "Sravni", "Tinkoff", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Tinkoff;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Sravni;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class CreditCalculator extends DfpCreditInfo {
        @NotNull
        public String A;
        @NotNull
        public final NativeCustomTemplateAd B;
        public final int C;
        @NotNull
        public final CalculatorLinkType D;
        public final NumberFormat E;
        @NotNull
        public final DfpCreditConverter b;
        public final String c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @NotNull
        public final String f;
        @NotNull
        public final String g;
        @NotNull
        public final String h;
        @NotNull
        public final String i;
        @NotNull
        public final Uri j;
        public final double k;
        public final Integer l;
        @Nullable
        public final Integer m;
        @Nullable
        public final Double n;
        public final int o;
        public final int p;
        @NotNull
        public final ArrayList<Integer> q;
        @NotNull
        public final String r;
        @NotNull
        public final String s;
        public int t;
        public int u;
        public int v;
        public int w;
        @Nullable
        public String x;
        @NotNull
        public String y;
        @NotNull
        public String z;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$CalculatorLinkType;", "", "<init>", "(Ljava/lang/String;I)V", "SRAVNI", "TINKOFF", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public enum CalculatorLinkType {
            SRAVNI,
            TINKOFF
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Sravni;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator;", "", "phone", "Landroid/net/Uri;", "buildUri", "(Ljava/lang/String;)Landroid/net/Uri;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "loan", "", "calculate", "(III)V", "F", "Landroid/net/Uri;", "partnerUrl", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "nativeCustomTemplateAd", "price", "Ljava/text/NumberFormat;", "priceFormatter", "Ljava/text/DecimalFormat;", "percentFormatter", "<init>", "(Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;ILjava/text/NumberFormat;Ljava/text/DecimalFormat;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static class Sravni extends CreditCalculator {
            @NotNull
            public static final Companion Companion = new Companion(null);
            public final Uri F;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Sravni$Companion;", "", "", "CREDIT_AMOUNT_KEY", "Ljava/lang/String;", "DOWN_PAYMENT_KEY", "PHONE_KEY", "TERM_KEY", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                public Companion(j jVar) {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Sravni(@NotNull NativeCustomTemplateAd nativeCustomTemplateAd, int i, @NotNull NumberFormat numberFormat, @NotNull DecimalFormat decimalFormat) {
                super(nativeCustomTemplateAd, i, CalculatorLinkType.SRAVNI, numberFormat, decimalFormat, new DefaultAnnuityCreditCalculator());
                Uri uri;
                Intrinsics.checkNotNullParameter(nativeCustomTemplateAd, "nativeCustomTemplateAd");
                Intrinsics.checkNotNullParameter(numberFormat, "priceFormatter");
                Intrinsics.checkNotNullParameter(decimalFormat, "percentFormatter");
                try {
                    CharSequence text = nativeCustomTemplateAd.getText("click_url");
                    uri = Uri.parse(text != null ? text.toString() : null);
                    Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(nativeCustomTe…PARTNER_URL)?.toString())");
                } catch (Throwable unused) {
                    uri = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                }
                this.F = uri;
            }

            public static /* synthetic */ Uri buildUri$default(Sravni sravni, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = "";
                    }
                    return sravni.buildUri(str);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildUri");
            }

            @NotNull
            public final Uri buildUri(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "phone");
                if (Intrinsics.areEqual(this.F, Uri.EMPTY)) {
                    Uri uri = Uri.EMPTY;
                    Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                    return uri;
                }
                Uri.Builder appendQueryParameter = this.F.buildUpon().appendQueryParameter("desired_credit_amount", String.valueOf(getLoan()));
                int paymentTerm = getPaymentTerm();
                StringBuilder I = a.I('P');
                I.append(paymentTerm / 12);
                I.append('Y');
                Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("desired_credit_term_years", I.toString()).appendQueryParameter("down_payment", String.valueOf(getInitialPayment()));
                if (!m.isBlank(str)) {
                    appendQueryParameter2.appendQueryParameter("phone_mobile", new Regex("[^0-9]").replace(str, ""));
                }
                Uri build = appendQueryParameter2.build();
                Intrinsics.checkNotNullExpressionValue(build, "partnerUrl\n             …                 .build()");
                return build;
            }

            @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator
            public void calculate(int i, int i2, int i3) {
                if (getPercentYear() != null) {
                    setLoan(getPrice() - i);
                    Integer rublesPerMonth = getConverter().rublesPerMonth(getLoan(), getPercentYear().doubleValue(), i2);
                    if (rublesPerMonth != null) {
                        int intValue = rublesPerMonth.intValue();
                        setInitialPayment(i);
                        setMonthlyPayment(intValue);
                        setPaymentTerm(i2);
                        updateTitleWithMonthlyPayment();
                    }
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b \u0010!J'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\f\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0012\u001a\u00020\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Tinkoff;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "loan", "", "calculate", "(III)V", "Landroid/net/Uri;", "getExternalUri", "()Landroid/net/Uri;", "externalUri", "", "F", "Ljava/lang/String;", "getInputHint", "()Ljava/lang/String;", "inputHint", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "G", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;", "creditBrokerSessionProvider", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "nativeCustomTemplateAd", "price", "Ljava/text/NumberFormat;", "priceFormatter", "Ljava/text/DecimalFormat;", "percentFormatter", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "<init>", "(Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;ILjava/text/NumberFormat;Ljava/text/DecimalFormat;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;Lcom/avito/android/advert_core/analytics/broker/CreditBrokerSessionProvider;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
        public static final class Tinkoff extends CreditCalculator {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            public final String F;
            public final CreditBrokerSessionProvider G;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$CreditCalculator$Tinkoff$Companion;", "", "", "CREDIT_AMOUNT_KEY", "Ljava/lang/String;", "DOWN_PAYMENT_KEY", "PARTNER_INTEGRATION_ID_KEY", "TERM_KEY", "TID_KEY", "TID_VALUE", "UTM_SOURCE_KEY", "UTM_SOURCE_VALUE", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                public Companion(j jVar) {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Tinkoff(@NotNull NativeCustomTemplateAd nativeCustomTemplateAd, int i, @NotNull NumberFormat numberFormat, @NotNull DecimalFormat decimalFormat, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider, @NotNull CreditBrokerSessionProvider creditBrokerSessionProvider) {
                super(nativeCustomTemplateAd, i, CalculatorLinkType.TINKOFF, numberFormat, decimalFormat, new TinkoffAnnuityCreditCalculator(), null);
                Intrinsics.checkNotNullParameter(nativeCustomTemplateAd, "nativeCustomTemplateAd");
                Intrinsics.checkNotNullParameter(numberFormat, "priceFormatter");
                Intrinsics.checkNotNullParameter(decimalFormat, "percentFormatter");
                Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
                Intrinsics.checkNotNullParameter(creditBrokerSessionProvider, "creditBrokerSessionProvider");
                this.G = creditBrokerSessionProvider;
                this.F = creditInfoResourcesProvider.getValueLimit(getMaxLoanFormatted());
            }

            @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator
            public void calculate(int i, int i2, int i3) {
                if (getPercentYear() != null) {
                    setLoan(getConverter().limitValue(i3, getMinLoan(), getMaxLoan()));
                    setInitialPayment(getPrice() - getLoan());
                    setPaymentTerm(i2);
                    Integer rublesPerMonth = getConverter().rublesPerMonth(getLoan(), getPercentYear().doubleValue(), getPaymentTerm());
                    if (rublesPerMonth != null) {
                        setMonthlyPayment(rublesPerMonth.intValue());
                        updateTitleWithMonthlyPayment();
                    }
                }
            }

            @NotNull
            public final Uri getExternalUri() {
                Uri build = getClickUri().buildUpon().appendQueryParameter("desired_credit_amount", String.valueOf(getLoan())).appendQueryParameter("desired_credit_term", String.valueOf(getPaymentTerm())).appendQueryParameter("down_payment", String.valueOf(getInitialPayment())).appendQueryParameter("tid", "4766a559fadd8ece91cb32a5dba9a0dd").appendQueryParameter("utm_source", "android").appendQueryParameter("partnerIntegrationId", this.G.getSession()).build();
                Intrinsics.checkNotNullExpressionValue(build, "clickUri\n               …\n                .build()");
                return build;
            }

            @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator
            @NotNull
            public String getInputHint() {
                return this.F;
            }
        }

        public /* synthetic */ CreditCalculator(NativeCustomTemplateAd nativeCustomTemplateAd, int i2, CalculatorLinkType calculatorLinkType, NumberFormat numberFormat, DecimalFormat decimalFormat, AnnuityCreditCalculator annuityCreditCalculator, j jVar) {
            this(nativeCustomTemplateAd, i2, calculatorLinkType, numberFormat, decimalFormat, annuityCreditCalculator);
        }

        public abstract void calculate(int i2, int i3, int i4);

        @NotNull
        public final String getButtonText() {
            return this.g;
        }

        @NotNull
        public final Uri getClickUri() {
            return this.j;
        }

        @NotNull
        public final DfpCreditConverter getConverter() {
            return this.b;
        }

        public final int getInitialPayment() {
            return this.u;
        }

        @NotNull
        public final String getInitialPaymentFormatted() {
            return this.z;
        }

        @Nullable
        public String getInputHint() {
            return null;
        }

        @NotNull
        public final String getLegalInfo() {
            return this.f;
        }

        @NotNull
        public final CalculatorLinkType getLinkType() {
            return this.D;
        }

        public final int getLoan() {
            return this.t;
        }

        @NotNull
        public final String getLoanFormatted() {
            return this.A;
        }

        public final int getMaxLoan() {
            return this.p;
        }

        @Nullable
        public final Integer getMaxLoanDefaultValue() {
            return this.m;
        }

        @NotNull
        public final String getMaxLoanFormatted() {
            return this.r;
        }

        public final int getMinLoan() {
            return this.o;
        }

        public final int getMonthlyPayment() {
            return this.v;
        }

        @NotNull
        public final String getMonthlyPaymentFormatted() {
            return this.y;
        }

        @NotNull
        public final NativeCustomTemplateAd getNativeCustomTemplateAd() {
            return this.B;
        }

        public final int getPaymentTerm() {
            return this.w;
        }

        @NotNull
        public final String getPercentFormatted() {
            return this.s;
        }

        @Nullable
        public final Double getPercentYear() {
            return this.n;
        }

        public final int getPrice() {
            return this.C;
        }

        @NotNull
        public final String getPrivacyLink() {
            return this.i;
        }

        @NotNull
        public final String getPrivacyText() {
            return this.h;
        }

        @NotNull
        public final ArrayList<Integer> getTerms() {
            return this.q;
        }

        @NotNull
        public final String getText() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.d;
        }

        @Nullable
        public final String getTitleWithPrice() {
            return this.x;
        }

        public final void setInitialPayment(int i2) {
            String format = this.E.format(Integer.valueOf(i2));
            Intrinsics.checkNotNullExpressionValue(format, "priceFormatter.format(value)");
            this.z = format;
            this.u = i2;
        }

        public final void setInitialPaymentFormatted(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.z = str;
        }

        public final void setLoan(int i2) {
            String format = this.E.format(Integer.valueOf(i2));
            Intrinsics.checkNotNullExpressionValue(format, "priceFormatter.format(value)");
            this.A = format;
            this.t = i2;
        }

        public final void setLoanFormatted(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.A = str;
        }

        public final void setMonthlyPayment(int i2) {
            String format = this.E.format(Integer.valueOf(i2));
            Intrinsics.checkNotNullExpressionValue(format, "priceFormatter.format(value)");
            this.y = format;
            this.v = i2;
        }

        public final void setMonthlyPaymentFormatted(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.y = str;
        }

        public final void setPaymentTerm(int i2) {
            this.w = i2;
        }

        public final void setTitleWithPrice(@Nullable String str) {
            this.x = str;
        }

        public final void updateTitleWithMonthlyPayment() {
            String str = this.c;
            String str2 = null;
            if (str != null && StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "{price_placeholder}", false, 2, (Object) null)) {
                str2 = m.replace$default(this.c, "{price_placeholder}", this.y, false, 4, (Object) null);
            }
            this.x = str2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x012e, code lost:
            if ((r4.intValue() > 0) != false) goto L_0x0132;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public CreditCalculator(com.google.android.gms.ads.formats.NativeCustomTemplateAd r16, int r17, com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator.CalculatorLinkType r18, java.text.NumberFormat r19, java.text.DecimalFormat r20, com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator r21) {
            /*
            // Method dump skipped, instructions count: 622
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo.CreditCalculator.<init>(com.google.android.gms.ads.formats.NativeCustomTemplateAd, int, com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfo$CreditCalculator$CalculatorLinkType, java.text.NumberFormat, java.text.DecimalFormat, com.avito.android.advert.item.dfpcreditinfo.calculator.AnnuityCreditCalculator):void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Empty;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty extends DfpCreditInfo {
        public Empty() {
            super(null, 1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Stub;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Stub extends DfpCreditInfo {
        public Stub() {
            super(null, 1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Type;", "", "", AuthSource.SEND_ABUSE, "I", "getValue", "()I", "value", "<init>", "(Ljava/lang/String;II)V", "Web", "Sravni", ScreenPublicConstsKt.BRANDSPACE_SCREEN_NAME, "Tinkoff", "SravniWeb", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        Web(0),
        Sravni(2),
        Brandspace(4),
        Tinkoff(5),
        SravniWeb(6);
        
        public final int a;

        /* access modifiers changed from: public */
        Type(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010-\u001a\u00020(\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001a\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u001d\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b#\u0010\u000bR\u001b\u0010'\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b&\u0010\u000bR\u0019\u0010-\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u00103\u001a\u00020.8\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo$Web;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfo;", "", "onHeaderClick", "()V", "onTextClick", "onLogoClick", "", "i", "Ljava/lang/String;", "getBrandSlug", "()Ljava/lang/String;", "brandSlug", "Lcom/avito/android/serp/ad/BannerInfo;", "k", "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", g.a, "Z", "isTinkoffTest", "()Z", "d", "getTitle", "title", "f", "getLegalInfo", "legalInfo", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditConverter;", "converter", "e", "getText", "text", "h", "getTitleWithPrice", "titleWithPrice", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "j", "Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "getNativeCustomTemplateAd", "()Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;", "nativeCustomTemplateAd", "Landroid/net/Uri;", "c", "Landroid/net/Uri;", "getImageUri", "()Landroid/net/Uri;", "imageUri", "", "price", "Ljava/text/NumberFormat;", "priceFormatter", "<init>", "(Lcom/google/android/gms/ads/formats/NativeCustomTemplateAd;Lcom/avito/android/serp/ad/BannerInfo;ILjava/text/NumberFormat;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Web extends DfpCreditInfo {
        public final DfpCreditConverter b;
        @NotNull
        public final Uri c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @NotNull
        public final String f;
        public final boolean g;
        @Nullable
        public final String h;
        @Nullable
        public final String i;
        @NotNull
        public final NativeCustomTemplateAd j;
        @NotNull
        public final BannerInfo k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Web(@NotNull NativeCustomTemplateAd nativeCustomTemplateAd, @NotNull BannerInfo bannerInfo, int i2, @NotNull NumberFormat numberFormat) {
            super(null, 1);
            String str;
            Intrinsics.checkNotNullParameter(nativeCustomTemplateAd, "nativeCustomTemplateAd");
            Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
            Intrinsics.checkNotNullParameter(numberFormat, "priceFormatter");
            String str2 = null;
            this.j = nativeCustomTemplateAd;
            this.k = bannerInfo;
            DfpCreditConverter dfpCreditConverter = new DfpCreditConverter(null, 1, null);
            this.b = dfpCreditConverter;
            NativeAd.Image image = nativeCustomTemplateAd.getImage("logo");
            Intrinsics.checkNotNullExpressionValue(image, "nativeCustomTemplateAd.getImage(KEY_LOGO)");
            Uri uri = image.getUri();
            Intrinsics.checkNotNullExpressionValue(uri, "nativeCustomTemplateAd.getImage(KEY_LOGO).uri");
            this.c = uri;
            CharSequence text = nativeCustomTemplateAd.getText(TariffPackageInfoConverterKt.HEADER_STRING_ID);
            this.d = (text == null || (str = text.toString()) == null) ? "" : str;
            this.e = nativeCustomTemplateAd.getText(SDKConstants.PARAM_A2U_BODY).toString();
            this.f = nativeCustomTemplateAd.getText("legacy").toString();
            CharSequence text2 = nativeCustomTemplateAd.getText("is_auto_tinkoff_test");
            this.g = Intrinsics.areEqual(text2 != null ? text2.toString() : null, "1");
            CharSequence text3 = nativeCustomTemplateAd.getText("brand_slug");
            this.i = text3 != null ? text3.toString() : null;
            CharSequence text4 = nativeCustomTemplateAd.getText("percent");
            Double convertToNumber = dfpCreditConverter.convertToNumber(text4 != null ? text4.toString() : null);
            CharSequence text5 = nativeCustomTemplateAd.getText("initial_fee");
            Double convertToNumber2 = dfpCreditConverter.convertToNumber(text5 != null ? text5.toString() : null);
            CharSequence text6 = nativeCustomTemplateAd.getText(FirebaseAnalytics.Param.TERM);
            Double convertToNumber3 = dfpCreditConverter.convertToNumber(text6 != null ? text6.toString() : null);
            Integer valueOf = convertToNumber3 != null ? Integer.valueOf((int) convertToNumber3.doubleValue()) : null;
            Integer rublesPerMonth = (convertToNumber2 == null || convertToNumber == null || valueOf == null) ? null : dfpCreditConverter.rublesPerMonth(i2, convertToNumber2.doubleValue(), convertToNumber.doubleValue(), valueOf.intValue());
            CharSequence text7 = nativeCustomTemplateAd.getText("header_price_placeholder");
            String obj = text7 != null ? text7.toString() : null;
            if (!(obj == null || rublesPerMonth == null || !StringsKt__StringsKt.contains$default((CharSequence) obj, (CharSequence) "{price_placeholder}", false, 2, (Object) null))) {
                String format = numberFormat.format(rublesPerMonth);
                Intrinsics.checkNotNullExpressionValue(format, "priceFormatter.format(payment)");
                str2 = m.replace$default(obj, "{price_placeholder}", format, false, 4, (Object) null);
            }
            this.h = str2;
        }

        @NotNull
        public final BannerInfo getBannerInfo() {
            return this.k;
        }

        @Nullable
        public final String getBrandSlug() {
            return this.i;
        }

        @NotNull
        public final Uri getImageUri() {
            return this.c;
        }

        @NotNull
        public final String getLegalInfo() {
            return this.f;
        }

        @NotNull
        public final NativeCustomTemplateAd getNativeCustomTemplateAd() {
            return this.j;
        }

        @NotNull
        public final String getText() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.d;
        }

        @Nullable
        public final String getTitleWithPrice() {
            return this.h;
        }

        public final boolean isTinkoffTest() {
            return this.g;
        }

        public final void onHeaderClick() {
            this.j.performClick(TariffPackageInfoConverterKt.HEADER_STRING_ID);
        }

        public final void onLogoClick() {
            this.j.performClick("logo");
        }

        public final void onTextClick() {
            this.j.performClick(SDKConstants.PARAM_A2U_BODY);
        }
    }

    public DfpCreditInfo(String str, int i) {
        int i2 = i & 1;
    }

    @Nullable
    public final String getLegalInfoOpt() {
        if (this instanceof Web) {
            return ((Web) this).getLegalInfo();
        }
        if (this instanceof CreditCalculator.Sravni) {
            return ((CreditCalculator.Sravni) this).getLegalInfo();
        }
        return null;
    }

    @Nullable
    public final String getSource() {
        return this.a;
    }

    @Nullable
    public final NativeCustomTemplateAd getTemplateAdOpt() {
        if (this instanceof Web) {
            return ((Web) this).getNativeCustomTemplateAd();
        }
        if (this instanceof CreditCalculator.Sravni) {
            return ((CreditCalculator.Sravni) this).getNativeCustomTemplateAd();
        }
        return null;
    }
}
