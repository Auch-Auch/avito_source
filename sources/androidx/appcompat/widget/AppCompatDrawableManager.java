package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager c;
    public ResourceManagerInternal a;

    public class a implements ResourceManagerInternal.e {
        public final int[] a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        public final int[] b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        public final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
        public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public final boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList b(@NonNull Context context, @ColorInt int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{ThemeUtils.b, ThemeUtils.d, ThemeUtils.c, ThemeUtils.f}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0055: APUT  
          (r0v15 int[][])
          (0 ??[int, short, byte, char])
          (wrap: int[] : 0x0053: SGET  (r3v1 int[]) =  androidx.appcompat.widget.ThemeUtils.b int[])
         */
        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005b: APUT  
          (r9v11 int[])
          (0 ??[int, short, byte, char])
          (wrap: int : 0x0057: INVOKE  (r3v2 int) = (r8v0 android.content.Context), (r2v0 int) type: STATIC call: androidx.appcompat.widget.ThemeUtils.getDisabledThemeAttrColor(android.content.Context, int):int)
         */
        public ColorStateList c(@NonNull Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i == R.drawable.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                int i2 = R.attr.colorSwitchThumbNormal;
                ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, i2);
                if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                    iArr[0] = ThemeUtils.b;
                    iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, i2);
                    iArr[1] = ThemeUtils.e;
                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                    iArr[2] = ThemeUtils.f;
                    iArr2[2] = ThemeUtils.getThemeAttrColor(context, i2);
                } else {
                    iArr[0] = ThemeUtils.b;
                    iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                    iArr[1] = ThemeUtils.e;
                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                    iArr[2] = ThemeUtils.f;
                    iArr2[2] = themeAttrColorStateList.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return b(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
            } else {
                if (i == R.drawable.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i == R.drawable.abc_btn_colored_material) {
                    return b(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                }
                if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                    return AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
                }
                if (a(this.b, i)) {
                    return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                }
                if (a(this.e, i)) {
                    return AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
                }
                if (a(this.f, i)) {
                    return AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
                }
                if (i == R.drawable.abc_seekbar_thumb_material) {
                    return AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
        }

        public final void d(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = AppCompatDrawableManager.b;
            }
            drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }
    }

    public static void b(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        PorterDuff.Mode mode = ResourceManagerInternal.h;
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            boolean z = tintInfo.mHasTintList;
            if (z || tintInfo.mHasTintMode) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                ColorStateList colorStateList = z ? tintInfo.mTintList : null;
                PorterDuff.Mode mode2 = tintInfo.mHasTintMode ? tintInfo.mTintMode : ResourceManagerInternal.h;
                if (!(colorStateList == null || mode2 == null)) {
                    porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode2);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (c == null) {
                preload();
            }
            appCompatDrawableManager = c;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                c = appCompatDrawableManager;
                appCompatDrawableManager.a = ResourceManagerInternal.get();
                c.a.setHooks(new a());
            }
        }
    }

    public synchronized ColorStateList a(@NonNull Context context, @DrawableRes int i) {
        return this.a.f(context, i);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.a.getDrawable(context, i);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.a.onConfigurationChanged(context);
    }
}
