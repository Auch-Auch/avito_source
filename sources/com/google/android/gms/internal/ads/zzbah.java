package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.material.badge.BadgeDrawable;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbah {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0123 A[Catch:{ JSONException -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0133 A[Catch:{ JSONException -> 0x014f }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zza(android.content.Context r16, @androidx.annotation.Nullable android.view.View r17) {
        /*
        // Method dump skipped, instructions count: 342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbah.zza(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static JSONObject zzb(Context context, @Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzp.zzkp();
            jSONObject.put("can_show_on_lock_screen", zzayh.zzq(view));
            zzp.zzkp();
            jSONObject.put("is_keyguard_locked", zzayh.zzay(context));
        } catch (JSONException unused) {
            zzbbd.zzfe("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zzbl(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        zzp.zzkp();
        DisplayMetrics zza = zzayh.zza((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzb(context, zza.widthPixels));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzb(context, zza.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean zzdi(int i) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcrc)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzwe.zzpu().zzd(zzaat.zzcrd)).booleanValue() || i <= 15299999;
    }

    public static JSONObject zzt(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxh)).booleanValue()) {
                zzp.zzkp();
                jSONObject.put("contained_in_scroll_view", zzayh.zzs(view));
            } else {
                zzp.zzkp();
                jSONObject.put("contained_in_scroll_view", zzayh.zzr(view) != -1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static int[] zzu(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static WindowManager.LayoutParams zzyg() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzwe.zzpu().zzd(zzaat.zzcxj)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        return layoutParams;
    }

    private static int zzb(Context context, int i) {
        return zzwe.zzpq().zzb(context, i);
    }

    public static JSONObject zza(Context context, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (!(map == null || view == null)) {
            int[] zzu = zzu(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<View>> next = it.next();
                View view2 = next.getValue().get();
                if (view2 != null) {
                    int[] zzu2 = zzu(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzb(context, view2.getMeasuredWidth()));
                        jSONObject4.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzb(context, view2.getMeasuredHeight()));
                        jSONObject4.put("x", zzb(context, zzu2[0] - zzu[0]));
                        jSONObject4.put("y", zzb(context, zzu2[1] - zzu[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put(TextureMediaEncoder.FRAME_EVENT, jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zza(context, rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0);
                            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0);
                            jSONObject.put("x", zzb(context, zzu2[0] - zzu[0]));
                            jSONObject.put("y", zzb(context, zzu2[1] - zzu[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str2 = str3;
                            str = str4;
                            try {
                                jSONObject3.put(ViewHierarchyConstants.TEXT_SIZE, (double) textView.getTextSize());
                                jSONObject3.put("text", textView.getText());
                            } catch (JSONException unused) {
                                zzbbd.zzfe("Unable to get asset views information");
                                it = it;
                                str3 = str2;
                                str4 = str;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                        }
                        jSONObject3.put("is_clickable", map2 != null && map2.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put(next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str2 = str3;
                        str = str4;
                        zzbbd.zzfe("Unable to get asset views information");
                        it = it;
                        str3 = str2;
                        str4 = str;
                    }
                    it = it;
                    str3 = str2;
                    str4 = str;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(@Nullable String str, Context context, Point point, Point point2) {
        Exception e;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("click_point", zza(context, point, point2));
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
            }
        } catch (Exception e3) {
            e = e3;
            zzbbd.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static Point zza(MotionEvent motionEvent, @Nullable View view) {
        int[] zzu = zzu(view);
        return new Point(((int) motionEvent.getRawX()) - zzu[0], ((int) motionEvent.getRawY()) - zzu[1]);
    }

    @Nullable
    private static JSONObject zza(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzb(context, point2.x));
            jSONObject.put("y", zzb(context, point2.y));
            jSONObject.put("start_x", zzb(context, point.x));
            jSONObject.put("start_y", zzb(context, point.y));
            return jSONObject;
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    public static boolean zza(zzdkx zzdkx) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxi)).booleanValue() || !zzdkx.zzhav) {
            return false;
        }
        return ((Boolean) zzwe.zzpu().zzd(zzaat.zzcxk)).booleanValue();
    }

    private static JSONObject zza(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, zzb(context, rect.right - rect.left));
        jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzb(context, rect.left));
        jSONObject.put("y", zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }
}
