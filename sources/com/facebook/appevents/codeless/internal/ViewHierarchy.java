package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class ViewHierarchy {
    public static WeakReference<View> a = new WeakReference<>(null);
    @Nullable
    public static Method b = null;

    public static JSONObject a(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, view.getLeft());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Nullable
    public static View findRCTRootView(View view) {
        while (view != null) {
            if (isRCTRootView(view)) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    public static List<View> getChildrenOfView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r5.isInstance(r2) != false) goto L_0x0019;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getClassTypeBitmask(android.view.View r6) {
        /*
            boolean r0 = r6 instanceof android.widget.ImageView
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            boolean r2 = r6.isClickable()
            if (r2 == 0) goto L_0x0010
            r0 = r0 | 32
        L_0x0010:
            android.view.ViewParent r2 = r6.getParent()
            boolean r3 = r2 instanceof android.widget.AdapterView
            r4 = 1
            if (r3 == 0) goto L_0x001b
        L_0x0019:
            r1 = 1
            goto L_0x003e
        L_0x001b:
            java.lang.String r3 = "android.support.v4.view.NestedScrollingChild"
            r5 = 0
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            if (r3 == 0) goto L_0x002d
            boolean r3 = r3.isInstance(r2)
            if (r3 == 0) goto L_0x002d
            goto L_0x0019
        L_0x002d:
            java.lang.String r3 = "androidx.core.view.NestedScrollingChild"
            java.lang.Class r5 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r5 == 0) goto L_0x003e
            boolean r2 = r5.isInstance(r2)
            if (r2 == 0) goto L_0x003e
            goto L_0x0019
        L_0x003e:
            if (r1 == 0) goto L_0x0042
            r0 = r0 | 512(0x200, float:7.175E-43)
        L_0x0042:
            boolean r1 = r6 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0065
            r0 = r0 | 1024(0x400, float:1.435E-42)
            r0 = r0 | r4
            boolean r1 = r6 instanceof android.widget.Button
            if (r1 == 0) goto L_0x005e
            r0 = r0 | 4
            boolean r1 = r6 instanceof android.widget.Switch
            if (r1 == 0) goto L_0x0056
            r0 = r0 | 8192(0x2000, float:1.14794E-41)
            goto L_0x005e
        L_0x0056:
            boolean r1 = r6 instanceof android.widget.CheckBox
            if (r1 == 0) goto L_0x005e
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 | r1
        L_0x005e:
            boolean r6 = r6 instanceof android.widget.EditText
            if (r6 == 0) goto L_0x0094
            r0 = r0 | 2048(0x800, float:2.87E-42)
            goto L_0x0094
        L_0x0065:
            boolean r1 = r6 instanceof android.widget.Spinner
            if (r1 != 0) goto L_0x0092
            boolean r1 = r6 instanceof android.widget.DatePicker
            if (r1 == 0) goto L_0x006e
            goto L_0x0092
        L_0x006e:
            boolean r1 = r6 instanceof android.widget.RatingBar
            if (r1 == 0) goto L_0x0076
            r6 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 | r6
            goto L_0x0094
        L_0x0076:
            boolean r1 = r6 instanceof android.widget.RadioGroup
            if (r1 == 0) goto L_0x007d
            r0 = r0 | 16384(0x4000, float:2.2959E-41)
            goto L_0x0094
        L_0x007d:
            boolean r1 = r6 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0094
            java.lang.ref.WeakReference<android.view.View> r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.a
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            boolean r6 = isRCTButton(r6, r1)
            if (r6 == 0) goto L_0x0094
            r0 = r0 | 64
            goto L_0x0094
        L_0x0092:
            r0 = r0 | 4096(0x1000, float:5.74E-42)
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getClassTypeBitmask(android.view.View):int");
    }

    public static JSONObject getDictionaryOfView(View view) {
        if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            a = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            for (int i = 0; i < childrenOfView.size(); i++) {
                jSONArray.put(getDictionaryOfView(childrenOfView.get(i)));
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Nullable
    public static View.OnClickListener getExistingOnClickListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnClickListener) declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    @Nullable
    public static View.OnTouchListener getExistingOnTouchListener(View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (View.OnTouchListener) declaredField.get(obj);
        } catch (NoSuchFieldException e) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e);
            return null;
        } catch (ClassNotFoundException e2) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
            return null;
        } catch (IllegalAccessException e3) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e3);
            return null;
        }
    }

    public static String getHintOfView(View view) {
        CharSequence charSequence;
        if (view instanceof EditText) {
            charSequence = ((EditText) view).getHint();
        } else {
            charSequence = view instanceof TextView ? ((TextView) view).getHint() : null;
        }
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    @Nullable
    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getTextOfView(android.view.View r6) {
        /*
            boolean r0 = r6 instanceof android.widget.TextView
            r1 = 0
            if (r0 == 0) goto L_0x0020
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r1 = r0.getText()
            boolean r0 = r6 instanceof android.widget.Switch
            if (r0 == 0) goto L_0x00cb
            android.widget.Switch r6 = (android.widget.Switch) r6
            boolean r6 = r6.isChecked()
            if (r6 == 0) goto L_0x001b
            java.lang.String r6 = "1"
            goto L_0x001d
        L_0x001b:
            java.lang.String r6 = "0"
        L_0x001d:
            r1 = r6
            goto L_0x00cb
        L_0x0020:
            boolean r0 = r6 instanceof android.widget.Spinner
            if (r0 == 0) goto L_0x0038
            android.widget.Spinner r6 = (android.widget.Spinner) r6
            int r0 = r6.getCount()
            if (r0 <= 0) goto L_0x00cb
            java.lang.Object r6 = r6.getSelectedItem()
            if (r6 == 0) goto L_0x00cb
            java.lang.String r1 = r6.toString()
            goto L_0x00cb
        L_0x0038:
            boolean r0 = r6 instanceof android.widget.DatePicker
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0069
            android.widget.DatePicker r6 = (android.widget.DatePicker) r6
            int r0 = r6.getYear()
            int r1 = r6.getMonth()
            int r6 = r6.getDayOfMonth()
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r4] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            r5[r3] = r0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r2] = r6
            java.lang.String r6 = "%04d-%02d-%02d"
            java.lang.String r1 = java.lang.String.format(r6, r5)
            goto L_0x00cb
        L_0x0069:
            boolean r0 = r6 instanceof android.widget.TimePicker
            if (r0 == 0) goto L_0x0094
            android.widget.TimePicker r6 = (android.widget.TimePicker) r6
            java.lang.Integer r0 = r6.getCurrentHour()
            int r0 = r0.intValue()
            java.lang.Integer r6 = r6.getCurrentMinute()
            int r6 = r6.intValue()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1[r4] = r0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1[r3] = r6
            java.lang.String r6 = "%02d:%02d"
            java.lang.String r1 = java.lang.String.format(r6, r1)
            goto L_0x00cb
        L_0x0094:
            boolean r0 = r6 instanceof android.widget.RadioGroup
            if (r0 == 0) goto L_0x00bd
            android.widget.RadioGroup r6 = (android.widget.RadioGroup) r6
            int r0 = r6.getCheckedRadioButtonId()
            int r2 = r6.getChildCount()
        L_0x00a2:
            if (r4 >= r2) goto L_0x00cb
            android.view.View r3 = r6.getChildAt(r4)
            int r5 = r3.getId()
            if (r5 != r0) goto L_0x00ba
            boolean r5 = r3 instanceof android.widget.RadioButton
            if (r5 == 0) goto L_0x00ba
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            java.lang.CharSequence r6 = r3.getText()
            goto L_0x001d
        L_0x00ba:
            int r4 = r4 + 1
            goto L_0x00a2
        L_0x00bd:
            boolean r0 = r6 instanceof android.widget.RatingBar
            if (r0 == 0) goto L_0x00cb
            android.widget.RatingBar r6 = (android.widget.RatingBar) r6
            float r6 = r6.getRating()
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L_0x00cb:
            if (r1 != 0) goto L_0x00d0
            java.lang.String r6 = ""
            goto L_0x00d4
        L_0x00d0:
            java.lang.String r6 = r1.toString()
        L_0x00d4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(android.view.View):java.lang.String");
    }

    @Nullable
    public static View getTouchReactView(float[] fArr, @Nullable View view) {
        View view2;
        if (b == null) {
            try {
                Method declaredMethod = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
                b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (ClassNotFoundException e) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e);
            } catch (NoSuchMethodException e2) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e2);
            }
        }
        Method method = b;
        if (!(method == null || view == null)) {
            try {
                View view3 = (View) method.invoke(null, fArr, view);
                if (view3 == null || view3.getId() <= 0 || (view2 = (View) view3.getParent()) == null) {
                    return null;
                }
                return view2;
            } catch (IllegalAccessException e3) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e3);
            } catch (InvocationTargetException e4) {
                Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e4);
            }
        }
        return null;
    }

    public static boolean isRCTButton(View view, @Nullable View view2) {
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        View touchReactView = getTouchReactView(new float[]{(float) iArr[0], (float) iArr[1]}, view2);
        if (touchReactView == null || touchReactView.getId() != view.getId()) {
            return false;
        }
        return true;
    }

    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals("com.facebook.react.ReactRootView");
    }

    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals("com.facebook.react.views.view.ReactTextView");
    }

    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup");
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        Field field;
        Field field2;
        Object obj = null;
        try {
            field2 = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            try {
                field = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            } catch (ClassNotFoundException | NoSuchFieldException unused) {
            }
        } catch (ClassNotFoundException | NoSuchFieldException unused2) {
            field2 = null;
            field = null;
            if (field2 != null) {
            }
            view.setOnClickListener(onClickListener);
            return;
        }
        if (field2 != null || field == null) {
            view.setOnClickListener(onClickListener);
            return;
        }
        try {
            field2.setAccessible(true);
            field.setAccessible(true);
            try {
                field2.setAccessible(true);
                obj = field2.get(view);
            } catch (IllegalAccessException unused3) {
            }
            if (obj == null) {
                view.setOnClickListener(onClickListener);
            } else {
                field.set(obj, onClickListener);
            }
        } catch (Exception unused4) {
        }
    }

    public static void updateAppearanceOfView(View view, JSONObject jSONObject, float f) {
        Bitmap bitmap;
        TextView textView;
        Typeface typeface;
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = (textView = (TextView) view).getTypeface()) != null) {
                jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, (double) textView.getTextSize());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 44.0f && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                }
            }
        } catch (JSONException e) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e);
        }
    }

    public static void updateBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
            } else {
                jSONObject.put("text", "");
                jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
            }
            jSONObject.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
            if (tag != null) {
                jSONObject.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
            }
            jSONObject.put(ViewHierarchyConstants.DIMENSION_KEY, a(view));
        } catch (JSONException e) {
            Utility.logd("com.facebook.appevents.codeless.internal.ViewHierarchy", e);
        }
    }
}
