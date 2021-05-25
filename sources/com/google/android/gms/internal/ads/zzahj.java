package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhd;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.net.URISyntaxException;
import java.util.Map;
public final class zzahj<T extends zzbgt & zzbgs & zzbgw & zzbhb & zzbhd> implements zzahf<T> {
    @Nullable
    private final zza zzder;
    @Nullable
    private final zzapw zzdes;

    public zzahj(zza zza, zzapw zzapw) {
        this.zzder = zza;
        this.zzdes = zzapw;
    }

    @VisibleForTesting
    public static Uri zza(Context context, zzeg zzeg, Uri uri, View view, @Nullable Activity activity) {
        if (zzeg == null) {
            return uri;
        }
        try {
            if (zzeg.zzc(uri)) {
                return zzeg.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzef unused) {
            return uri;
        } catch (Exception e) {
            zzp.zzkt().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    private final void zzab(boolean z) {
        zzapw zzapw = this.zzdes;
        if (zzapw != null) {
            zzapw.zzac(z);
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzp.zzkr();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzp.zzkr();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzp.zzkr().zzxs();
        } else {
            return -1;
        }
    }

    @VisibleForTesting
    public static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            zzbbd.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e);
        }
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbgt zzbgt = (zzbgt) obj;
        String zzc = zzawq.zzc((String) map.get("u"), zzbgt.getContext(), true);
        String str = (String) map.get(AuthSource.SEND_ABUSE);
        if (str == null) {
            zzbbd.zzfe("Action missing from an open GMSG.");
            return;
        }
        zza zza = this.zzder;
        if (zza != null && !zza.zzjx()) {
            this.zzder.zzbo(zzc);
        } else if (Tracker.Events.CREATIVE_EXPAND.equalsIgnoreCase(str)) {
            if (((zzbgs) zzbgt).zzabj()) {
                zzbbd.zzfe("Cannot expand WebView that is already expanded.");
                return;
            }
            zzab(false);
            ((zzbgw) zzbgt).zzc(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            zzab(false);
            if (zzc != null) {
                ((zzbgw) zzbgt).zza(zzc(map), zzd(map), zzc);
            } else {
                ((zzbgw) zzbgt).zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("app".equalsIgnoreCase(str) && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase((String) map.get("system_browser"))) {
            zzab(true);
            if (TextUtils.isEmpty(zzc)) {
                zzbbd.zzfe("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbgw) zzbgt).zza(new zzd(new zzahm(zzbgt.getContext(), ((zzbhb) zzbgt).zzabh(), ((zzbhd) zzbgt).getView()).zze(map)));
            } catch (ActivityNotFoundException e) {
                zzbbd.zzfe(e.getMessage());
            }
        } else if ("open_app".equalsIgnoreCase(str)) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxw)).booleanValue()) {
                zzab(true);
                String str2 = (String) map.get("p");
                if (str2 == null) {
                    zzbbd.zzfe("Package name missing from open app action.");
                    return;
                }
                PackageManager packageManager = zzbgt.getContext().getPackageManager();
                if (packageManager == null) {
                    zzbbd.zzfe("Cannot get package manager from open app action.");
                    return;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str2);
                if (launchIntentForPackage != null) {
                    ((zzbgw) zzbgt).zza(new zzd(launchIntentForPackage));
                }
            }
        } else {
            zzab(true);
            String str3 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str3)) {
                try {
                    intent = Intent.parseUri(str3, 0);
                } catch (URISyntaxException e2) {
                    String valueOf = String.valueOf(str3);
                    zzbbd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                if (!Uri.EMPTY.equals(data)) {
                    intent.setData(zze(zza(zzbgt.getContext(), ((zzbhb) zzbgt).zzabh(), data, ((zzbhd) zzbgt).getView(), zzbgt.zzzq())));
                }
            }
            if (intent != null) {
                ((zzbgw) zzbgt).zza(new zzd(intent));
                return;
            }
            if (!TextUtils.isEmpty(zzc)) {
                zzc = zze(zza(zzbgt.getContext(), ((zzbhb) zzbgt).zzabh(), Uri.parse(zzc), ((zzbhd) zzbgt).getView(), zzbgt.zzzq())).toString();
            }
            ((zzbgw) zzbgt).zza(new zzd((String) map.get("i"), zzc, (String) map.get(AuthSource.OPEN_CHANNEL_LIST), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
