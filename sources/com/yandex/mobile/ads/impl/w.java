package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
public final class w {

    public static final class a {
        public static final int a = Color.parseColor("#fffeec95");
        public static final int b = Color.parseColor("#fff5cf60");
        public static final int c = Color.parseColor("#ffd8d8d8");
    }

    public static final class b {
        public static final ColorDrawable a = new ColorDrawable(Color.parseColor("#80ffffff"));
        public static final LayerDrawable b;

        static {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, 0});
            gradientDrawable.setCornerRadius(0.0f);
            int i = a.b;
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{i, i});
            gradientDrawable2.setCornerRadius(0.0f);
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(gradientDrawable2, 3, 1)});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908301);
            b = layerDrawable;
        }

        public static StateListDrawable a() {
            ColorDrawable colorDrawable = new ColorDrawable(a.a);
            ColorDrawable colorDrawable2 = new ColorDrawable(0);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, colorDrawable);
            stateListDrawable.addState(new int[0], colorDrawable2);
            return stateListDrawable;
        }
    }

    public static final class c {
        @NonNull
        public static LinearLayout.LayoutParams a() {
            return new LinearLayout.LayoutParams(-2, -1);
        }
    }

    public static final class d {
        @NonNull
        public static ImageView a(@NonNull Context context, @NonNull String str, int i) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(dt.a(str));
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(i, i, i, i);
            imageView.setBackgroundDrawable(b.a());
            return imageView;
        }
    }

    public enum e {
        BROWSER_CONTROL_PANEL_HEIGHT,
        BROWSER_CONTROL_PANEL_BUTTON_PADDING,
        BROWSER_CONTROL_PANEL_TITLE_TEXT_SIZE;
        
        private static final Map<String, Object> d;

        /* access modifiers changed from: public */
        static {
            e eVar;
            e eVar2;
            e eVar3;
            HashMap hashMap = new HashMap();
            d = hashMap;
            hashMap.put(eVar.a("values_dimen_%s"), 48);
            hashMap.put(eVar.a("values_dimen_%s_sw600dp"), 56);
            hashMap.put(eVar2.a("values_dimen_%s"), 15);
            hashMap.put(eVar2.a("values_dimen_%s_sw600dp"), 17);
            hashMap.put(eVar3.a("values_dimen_%s"), 19);
            hashMap.put(eVar3.a("values_dimen_%s_sw600dp"), 23);
        }

        private static String a(String str, String str2) {
            return String.format(Locale.US, str, str2);
        }

        public final int b(Context context) {
            return dv.a(context, (float) a(context));
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return name();
        }

        private String a(String str) {
            return a(str, name());
        }

        public final int a(Context context) {
            try {
                StringBuilder sb = new StringBuilder(name());
                if (Math.min(eg.c(context), eg.d(context)) >= 600) {
                    sb.append("_sw600dp");
                }
                Integer num = (Integer) d.get(a("values_dimen_%s", sb.toString()));
                if (num != null) {
                    return num.intValue();
                }
            } catch (Exception unused) {
            }
            try {
                Integer num2 = (Integer) d.get(a("values_dimen_%s", name()));
                if (num2 != null) {
                    return num2.intValue();
                }
                return 0;
            } catch (Exception unused2) {
                return 0;
            }
        }
    }
}
