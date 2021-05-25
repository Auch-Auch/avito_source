package androidx.constraintlayout.widget;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
public class ConstraintAttribute {
    public String a;
    public AttributeType b;
    public int c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.a = str;
        this.b = attributeType;
    }

    public static int a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object string;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    string = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    string = obtainStyledAttributes.getString(index);
                }
                attributeType2 = attributeType;
                obj = string;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            String c3 = a.c3("set", str);
            try {
                switch (constraintAttribute.b.ordinal()) {
                    case 0:
                        cls.getMethod(c3, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.c));
                        continue;
                    case 1:
                        cls.getMethod(c3, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.d));
                        continue;
                    case 2:
                        cls.getMethod(c3, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.g));
                        continue;
                    case 3:
                        Method method = cls.getMethod(c3, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.g);
                        method.invoke(view, colorDrawable);
                        continue;
                    case 4:
                        cls.getMethod(c3, CharSequence.class).invoke(view, constraintAttribute.e);
                        continue;
                    case 5:
                        cls.getMethod(c3, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f));
                        continue;
                    case 6:
                        cls.getMethod(c3, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.d));
                        continue;
                    default:
                        continue;
                }
            } catch (NoSuchMethodException e2) {
                e2.getMessage();
                cls.getName();
            } catch (IllegalAccessException e3) {
                cls.getName();
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                cls.getName();
                e4.printStackTrace();
            }
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.b) != constraintAttribute.b) {
            return false;
        }
        switch (attributeType.ordinal()) {
            case 0:
                if (this.c == constraintAttribute.c) {
                    return true;
                }
                return false;
            case 1:
                if (this.d == constraintAttribute.d) {
                    return true;
                }
                return false;
            case 2:
            case 3:
                if (this.g == constraintAttribute.g) {
                    return true;
                }
                return false;
            case 4:
                if (this.c == constraintAttribute.c) {
                    return true;
                }
                return false;
            case 5:
                if (this.f == constraintAttribute.f) {
                    return true;
                }
                return false;
            case 6:
                if (this.d == constraintAttribute.d) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public AttributeType getType() {
        return this.b;
    }

    public float getValueToInterpolate() {
        switch (this.b.ordinal()) {
            case 0:
                return (float) this.c;
            case 1:
                return this.d;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.f ? 1.0f : 0.0f;
            case 6:
                return this.d;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        switch (this.b.ordinal()) {
            case 0:
                fArr[0] = (float) this.c;
                return;
            case 1:
                fArr[0] = this.d;
                return;
            case 2:
            case 3:
                int i = this.g;
                float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i >> 24) & 255)) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.f ? 1.0f : 0.0f;
                return;
            case 6:
                fArr[0] = this.d;
                return;
            default:
                return;
        }
    }

    public int noOfInterpValues() {
        int ordinal = this.b.ordinal();
        return (ordinal == 2 || ordinal == 3) ? 4 : 1;
    }

    public void setColorValue(int i) {
        this.g = i;
    }

    public void setFloatValue(float f2) {
        this.d = f2;
    }

    public void setIntValue(int i) {
        this.c = i;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005c: APUT  
      (r1v27 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Boolean : 0x0058: INVOKE  (r14v29 java.lang.Boolean) = (r8v1 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    public void setInterpolatedValue(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        StringBuilder L = a.L("set");
        L.append(this.a);
        String sb = L.toString();
        try {
            boolean z = true;
            switch (this.b.ordinal()) {
                case 0:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(sb, Drawable.class);
                    int a3 = a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int a4 = a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    int a5 = a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((a((int) (fArr[3] * 255.0f)) << 24) | (a3 << 16) | (a4 << 8) | a5);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + this.a);
                case 5:
                    Method method2 = cls.getMethod(sb, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (NoSuchMethodException e2) {
            Debug.getName(view);
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            Debug.getName(view);
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void setStringValue(String str) {
        this.e = str;
    }

    public void setValue(float[] fArr) {
        boolean z = false;
        switch (this.b.ordinal()) {
            case 0:
                this.c = (int) fArr[0];
                return;
            case 1:
                this.d = fArr[0];
                return;
            case 2:
            case 3:
                int HSVToColor = Color.HSVToColor(fArr);
                this.g = HSVToColor;
                this.g = (a((int) (fArr[3] * 255.0f)) << 24) | (HSVToColor & ViewCompat.MEASURED_SIZE_MASK);
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (((double) fArr[0]) > 0.5d) {
                    z = true;
                }
                this.f = z;
                return;
            case 6:
                this.d = fArr[0];
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj) {
        this.a = str;
        this.b = attributeType;
        setValue(obj);
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.a = constraintAttribute.a;
        this.b = constraintAttribute.b;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.b.ordinal()) {
            case 0:
                this.c = ((Integer) obj).intValue();
                return;
            case 1:
                this.d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.g = ((Integer) obj).intValue();
                return;
            case 4:
                this.e = (String) obj;
                return;
            case 5:
                this.f = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.d = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }
}
