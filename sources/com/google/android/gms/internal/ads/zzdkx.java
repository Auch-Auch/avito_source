package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.avito.android.lib.design.input.FormatterType;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.applinks.AppLinkData;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidSettings;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdkx {
    public final String zzagt;
    public final boolean zzboz;
    public final List<String> zzdis;
    public final List<String> zzdit;
    public final String zzdiy;
    public final boolean zzdjf;
    public final boolean zzdjg;
    public final boolean zzdjh;
    public final String zzdjo;
    public final String zzdjz;
    public final String zzdka;
    public final String zzdln;
    public final List<String> zzdru;
    public final String zzdrx;
    public final String zzdsa;
    @Nullable
    public final zzaue zzdsh;
    public final List<String> zzdsi;
    public final List<String> zzdsj;
    public final boolean zzdsr;
    public final boolean zzdsu;
    public final boolean zzdsv;
    public final boolean zzduo;
    public final boolean zzent;
    public final String zzeqb;
    public final int zzfnn;
    public final boolean zzfno;
    public final boolean zzfnp;
    public final String zzfsp;
    public final List<String> zzhaf;
    public final int zzhag;
    public final int zzhah;
    public final List<String> zzhai;
    public final List<String> zzhaj;
    public final List<String> zzhak;
    public final List<String> zzhal;
    public final int zzham;
    public final List<zzdkw> zzhan;
    @Nullable
    public final zzdlb zzhao;
    public final List<String> zzhap;
    public final List<zzdkw> zzhaq;
    public final JSONObject zzhar;
    public final zzavt zzhas;
    public final JSONObject zzhat;
    public final JSONObject zzhau;
    public final boolean zzhav;
    public final int zzhaw;
    public final int zzhax;
    public final OmidSettings zzhay;
    public final int zzhaz;
    public final boolean zzhba;
    public final zzaqq zzhbb;
    @Nullable
    public final zzvl zzhbc;
    public final String zzhbd;

    public zzdkx(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String str;
        List<zzdkw> list;
        char c;
        List<String> list2;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<String> emptyList10 = Collections.emptyList();
        List<zzdkw> emptyList11 = Collections.emptyList();
        List<String> emptyList12 = Collections.emptyList();
        List<zzdkw> emptyList13 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jsonReader.beginObject();
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        String str8 = str7;
        String str9 = str8;
        String str10 = str9;
        String str11 = str10;
        String str12 = str11;
        JSONObject jSONObject5 = jSONObject;
        JSONObject jSONObject6 = jSONObject2;
        JSONObject jSONObject7 = jSONObject3;
        JSONObject jSONObject8 = jSONObject4;
        zzaue zzaue = null;
        zzdlb zzdlb = null;
        zzavt zzavt = null;
        zzaqq zzaqq = null;
        zzvl zzvl = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i4 = -1;
        int i5 = 0;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        int i6 = 0;
        boolean z12 = false;
        int i7 = -1;
        boolean z13 = false;
        boolean z14 = true;
        List<String> list3 = emptyList12;
        List<zzdkw> list4 = emptyList13;
        List<String> list5 = emptyList10;
        List<zzdkw> list6 = emptyList11;
        List<String> list7 = emptyList8;
        List<String> list8 = emptyList9;
        List<String> list9 = emptyList6;
        List<String> list10 = emptyList7;
        List<String> list11 = emptyList4;
        List<String> list12 = emptyList5;
        List<String> list13 = emptyList2;
        List<String> list14 = emptyList3;
        List<String> list15 = emptyList;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName == null) {
                str = "";
            } else {
                str = nextName;
            }
            switch (str.hashCode()) {
                case -1980587809:
                    list = list4;
                    if (str.equals("debug_signals")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1965512151:
                    list = list4;
                    if (str.equals("omid_settings")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1812055556:
                    list = list4;
                    if (str.equals("play_prewarm_options")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1620470467:
                    list = list4;
                    if (str.equals("backend_query_id")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1440104884:
                    list = list4;
                    if (str.equals("is_custom_close_blocked")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1439500848:
                    list = list4;
                    if (str.equals("orientation")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1428969291:
                    list = list4;
                    if (str.equals("enable_omid")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1403779768:
                    list = list4;
                    if (str.equals("showable_impression_type")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case -1360811658:
                    list = list4;
                    if (str.equals("ad_sizes")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -1306015996:
                    list = list4;
                    if (str.equals("adapters")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -1303332046:
                    list = list4;
                    if (str.equals("test_mode_enabled")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -1289032093:
                    list = list4;
                    if (str.equals(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1240082064:
                    list = list4;
                    if (str.equals("ad_event_value")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case -1234181075:
                    list = list4;
                    if (str.equals("allow_pub_rendered_attribution")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case -1181000426:
                    list = list4;
                    if (str.equals("is_augmented_reality_ad")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case -1168140544:
                    list = list4;
                    if (str.equals("presentation_error_urls")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case -1152230954:
                    list = list4;
                    if (str.equals(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case -1146534047:
                    list = list4;
                    if (str.equals("is_scroll_aware")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -1115838944:
                    list = list4;
                    if (str.equals("fill_urls")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case -1081936678:
                    list = list4;
                    if (str.equals("allocation_id")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case -1078050970:
                    list = list4;
                    if (str.equals("video_complete_urls")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case -1051269058:
                    list = list4;
                    if (str.equals("active_view")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case -982608540:
                    list = list4;
                    if (str.equals("valid_from_timestamp")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case -776859333:
                    list = list4;
                    if (str.equals("click_urls")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case -544216775:
                    list = list4;
                    if (str.equals("safe_browsing")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case -437057161:
                    list = list4;
                    if (str.equals("imp_urls")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case -404326515:
                    list = list4;
                    if (str.equals("render_timeout_ms")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case -397704715:
                    list = list4;
                    if (str.equals("ad_close_time_ms")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -369773488:
                    list = list4;
                    if (str.equals("is_close_button_enabled")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case -213424028:
                    list = list4;
                    if (str.equals("watermark")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case -29338502:
                    list = list4;
                    if (str.equals("allow_custom_click_gesture")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 3107:
                    list = list4;
                    if (str.equals("ad")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case 3355:
                    list = list4;
                    if (str.equals("id")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case 3076010:
                    list = list4;
                    if (str.equals("data")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case 63195984:
                    list = list4;
                    if (str.equals("render_test_label")) {
                        c = Typography.quote;
                        break;
                    }
                    c = 65535;
                    break;
                case 107433883:
                    list = list4;
                    if (str.equals("qdata")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case 230323073:
                    list = list4;
                    if (str.equals("ad_load_urls")) {
                        c = Typography.dollar;
                        break;
                    }
                    c = 65535;
                    break;
                case 418392395:
                    list = list4;
                    if (str.equals("is_closable_area_disabled")) {
                        c = '%';
                        break;
                    }
                    c = 65535;
                    break;
                case 549176928:
                    list = list4;
                    if (str.equals("presentation_error_timeout_ms")) {
                        c = Typography.amp;
                        break;
                    }
                    c = 65535;
                    break;
                case 597473788:
                    list = list4;
                    if (str.equals("debug_dialog_string")) {
                        c = '\'';
                        break;
                    }
                    c = 65535;
                    break;
                case 673261304:
                    list = list4;
                    if (str.equals("reward_granted_urls")) {
                        c = '(';
                        break;
                    }
                    c = 65535;
                    break;
                case 754887508:
                    list = list4;
                    if (str.equals("container_sizes")) {
                        c = ')';
                        break;
                    }
                    c = 65535;
                    break;
                case 791122864:
                    list = list4;
                    if (str.equals("impression_type")) {
                        c = '*';
                        break;
                    }
                    c = 65535;
                    break;
                case 1010584092:
                    list = list4;
                    if (str.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        c = '+';
                        break;
                    }
                    c = 65535;
                    break;
                case 1100650276:
                    list = list4;
                    if (str.equals("rewards")) {
                        c = ',';
                        break;
                    }
                    c = 65535;
                    break;
                case 1321720943:
                    list = list4;
                    if (str.equals("allow_pub_owned_ad_view")) {
                        c = '-';
                        break;
                    }
                    c = 65535;
                    break;
                case 1637553475:
                    list = list4;
                    if (str.equals("bid_response")) {
                        c = FormatterType.defaultDecimalSeparator;
                        break;
                    }
                    c = 65535;
                    break;
                case 1638957285:
                    list = list4;
                    if (str.equals("video_start_urls")) {
                        c = '/';
                        break;
                    }
                    c = 65535;
                    break;
                case 1688341040:
                    list = list4;
                    if (str.equals("video_reward_urls")) {
                        c = '0';
                        break;
                    }
                    c = 65535;
                    break;
                case 1799285870:
                    list = list4;
                    if (str.equals("use_third_party_container_height")) {
                        c = '1';
                        break;
                    }
                    c = 65535;
                    break;
                case 1839650832:
                    list = list4;
                    if (str.equals("renderers")) {
                        c = '2';
                        break;
                    }
                    c = 65535;
                    break;
                case 1875425491:
                    list = list4;
                    if (str.equals("is_analytics_logging_enabled")) {
                        c = '3';
                        break;
                    }
                    c = 65535;
                    break;
                case 2068142375:
                    list = list4;
                    if (str.equals("rule_line_external_id")) {
                        c = '4';
                        break;
                    }
                    c = 65535;
                    break;
                case 2072888499:
                    list = list4;
                    if (str.equals("manual_tracking_urls")) {
                        c = '5';
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    list = list4;
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    jSONObject6 = zzbab.zzc(jsonReader);
                    break;
                case 1:
                    jSONObject8 = zzbab.zzc(jsonReader);
                    break;
                case 2:
                    JSONObject zzc = zzbab.zzc(jsonReader);
                    if (zzc == null) {
                        list2 = list3;
                        zzaqq = null;
                    } else {
                        list2 = list3;
                        zzaqq = new zzaqq(zzc.optBoolean("enable_prewarming", false), zzc.optString("prefetch_url", ""));
                    }
                    list3 = list2;
                    break;
                case 3:
                    str11 = jsonReader.nextString();
                    break;
                case 4:
                    z7 = jsonReader.nextBoolean();
                    break;
                case 5:
                    String nextString = jsonReader.nextString();
                    if (!"landscape".equalsIgnoreCase(nextString)) {
                        if (!"portrait".equalsIgnoreCase(nextString)) {
                            i4 = -1;
                            break;
                        } else {
                            zzp.zzkr();
                            i4 = 7;
                            break;
                        }
                    } else {
                        zzp.zzkr();
                        i4 = 6;
                        break;
                    }
                case 6:
                    z9 = jsonReader.nextBoolean();
                    break;
                case 7:
                    i6 = jsonReader.nextInt();
                    break;
                case '\b':
                    list4 = zzdkw.zze(jsonReader);
                    continue;
                case '\t':
                    list3 = zzbab.zza(jsonReader);
                    break;
                case '\n':
                    z5 = jsonReader.nextBoolean();
                    break;
                case 11:
                    jSONObject7 = zzbab.zzc(jsonReader);
                    break;
                case '\f':
                    zzvl = zzvl.zza(zzbab.zzc(jsonReader));
                    break;
                case '\r':
                    z = jsonReader.nextBoolean();
                    break;
                case 14:
                    z12 = jsonReader.nextBoolean();
                    break;
                case 15:
                    list8 = zzbab.zza(jsonReader);
                    break;
                case 16:
                    String nextString2 = jsonReader.nextString();
                    if (!"banner".equals(nextString2)) {
                        if (!"interstitial".equals(nextString2)) {
                            if (!"native_express".equals(nextString2)) {
                                if (!AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(nextString2)) {
                                    if (!"rewarded".equals(nextString2)) {
                                        i = 0;
                                        break;
                                    } else {
                                        i = 5;
                                        break;
                                    }
                                } else {
                                    i = 4;
                                    break;
                                }
                            } else {
                                i = 3;
                                break;
                            }
                        } else {
                            i = 2;
                            break;
                        }
                    } else {
                        i = 1;
                        break;
                    }
                case 17:
                    z11 = jsonReader.nextBoolean();
                    break;
                case 18:
                    list7 = zzbab.zza(jsonReader);
                    break;
                case 19:
                    str4 = jsonReader.nextString();
                    break;
                case 20:
                    list10 = zzbab.zza(jsonReader);
                    break;
                case 21:
                    str7 = zzbab.zzc(jsonReader).toString();
                    break;
                case 22:
                    str3 = jsonReader.nextString();
                    break;
                case 23:
                    list13 = zzbab.zza(jsonReader);
                    break;
                case 24:
                    zzavt = zzavt.zzg(zzbab.zzc(jsonReader));
                    break;
                case 25:
                    list14 = zzbab.zza(jsonReader);
                    break;
                case 26:
                    i5 = jsonReader.nextInt();
                    break;
                case 27:
                    i7 = jsonReader.nextInt();
                    break;
                case 28:
                    z14 = jsonReader.nextBoolean();
                    break;
                case 29:
                    str10 = jsonReader.nextString();
                    break;
                case 30:
                    z3 = jsonReader.nextBoolean();
                    break;
                case 31:
                    zzdlb = new zzdlb(jsonReader);
                    break;
                case ' ':
                    str5 = jsonReader.nextString();
                    break;
                case '!':
                    jSONObject5 = zzbab.zzc(jsonReader);
                    break;
                case '\"':
                    z4 = jsonReader.nextBoolean();
                    break;
                case '#':
                    str6 = jsonReader.nextString();
                    break;
                case '$':
                    list11 = zzbab.zza(jsonReader);
                    break;
                case '%':
                    z8 = jsonReader.nextBoolean();
                    break;
                case '&':
                    i3 = jsonReader.nextInt();
                    break;
                case '\'':
                    str8 = jsonReader.nextString();
                    break;
                case '(':
                    zzbab.zza(jsonReader);
                    break;
                case ')':
                    list6 = zzdkw.zze(jsonReader);
                    break;
                case '*':
                    int nextInt = jsonReader.nextInt();
                    if (nextInt != 0 && nextInt != 1) {
                        i2 = 0;
                        break;
                    } else {
                        i2 = nextInt;
                        break;
                    }
                case '+':
                    str2 = jsonReader.nextString();
                    break;
                case ',':
                    zzaue = zzaue.zza(zzbab.zzd(jsonReader));
                    break;
                case '-':
                    z2 = jsonReader.nextBoolean();
                    break;
                case '.':
                    str9 = jsonReader.nextString();
                    break;
                case '/':
                    list12 = zzbab.zza(jsonReader);
                    break;
                case '0':
                    list9 = zzbab.zza(jsonReader);
                    break;
                case '1':
                    z13 = jsonReader.nextBoolean();
                    break;
                case '2':
                    list15 = zzbab.zza(jsonReader);
                    break;
                case '3':
                    z10 = jsonReader.nextBoolean();
                    break;
                case '4':
                    str12 = jsonReader.nextString();
                    break;
                case '5':
                    list5 = zzbab.zza(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            list4 = list;
        }
        jsonReader.endObject();
        this.zzhaf = list15;
        this.zzhag = i;
        this.zzdis = list13;
        this.zzdit = list14;
        this.zzhai = list11;
        this.zzhah = i2;
        this.zzdsi = list12;
        this.zzdsj = list9;
        this.zzhaj = list10;
        this.zzdjz = str2;
        this.zzdka = str3;
        this.zzdsh = zzaue;
        this.zzhak = list7;
        this.zzhal = list8;
        this.zzdru = list5;
        this.zzham = i3;
        this.zzhan = list6;
        this.zzhao = zzdlb;
        this.zzhap = list3;
        this.zzhaq = list4;
        this.zzdjo = str4;
        this.zzhar = jSONObject5;
        this.zzagt = str5;
        this.zzdiy = str6;
        this.zzdsa = str7;
        this.zzhas = zzavt;
        this.zzdrx = str8;
        this.zzhat = jSONObject6;
        this.zzhau = jSONObject7;
        this.zzdjf = z;
        this.zzdjg = z2;
        this.zzdjh = z3;
        this.zzduo = z4;
        this.zzhav = z5;
        this.zzfnp = z7;
        this.zzboz = z8;
        this.zzhaw = i4;
        this.zzhax = i5;
        this.zzdsr = z9;
        this.zzeqb = str9;
        this.zzhay = new OmidSettings(jSONObject8);
        this.zzdsu = z10;
        this.zzdsv = z11;
        this.zzhaz = i6;
        this.zzent = z12;
        this.zzdln = str10;
        this.zzfnn = i7;
        this.zzfsp = str11;
        this.zzhba = z13;
        this.zzhbb = zzaqq;
        this.zzfno = z14;
        this.zzhbc = zzvl;
        this.zzhbd = str12;
    }
}
