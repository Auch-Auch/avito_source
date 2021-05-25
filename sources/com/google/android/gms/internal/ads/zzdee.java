package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdee implements zzden<zzdek<Bundle>> {
    private final Context zzaai;
    private final zzdvw zzgay;

    public zzdee(zzdvw zzdvw, Context context) {
        this.zzgay = zzdvw;
        this.zzaai = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i;
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt("type", -1);
            if (optInt == 0) {
                i = zzdei.zzgvd;
            } else if (optInt == 1) {
                i = zzdei.zzgve;
            } else if (optInt != 2) {
                i = 0;
            } else {
                i = zzdei.zzgvf;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i3 = zzdej.zzgvh[i - 1];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && (obj instanceof Boolean)) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzden
    public final zzdvt<zzdek<Bundle>> zzaqs() {
        return this.zzgay.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdeh
            private final zzdee zzgvc;

            {
                this.zzgvc = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgvc.zzarh();
            }
        });
    }

    public final /* synthetic */ zzdek zzarh() throws Exception {
        String str = (String) zzwe.zzpu().zzd(zzaat.zzcvt);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new zzdek(zza(this.zzaai, new JSONArray(str))) { // from class: com.google.android.gms.internal.ads.zzdeg
                private final Bundle zzgvb;

                {
                    this.zzgvb = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzdek
                public final void zzs(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", this.zzgvb);
                }
            };
        } catch (JSONException e) {
            zzbbd.zzb("JSON parsing error", e);
            return null;
        }
    }
}
