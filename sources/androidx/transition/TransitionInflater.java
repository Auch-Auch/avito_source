package androidx.transition;

import a2.b.a.a.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import l6.z.j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class TransitionInflater {
    public static final Class<?>[] b = {Context.class, AttributeSet.class};
    public static final ArrayMap<String, Constructor<?>> c = new ArrayMap<>();
    public final Context a;

    public TransitionInflater(@NonNull Context context) {
        this.a = context;
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public final Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue != null) {
            try {
                ArrayMap<String, Constructor<?>> arrayMap = c;
                synchronized (arrayMap) {
                    Constructor<?> constructor = arrayMap.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.a.getClassLoader()).asSubclass(cls)) != null) {
                        constructor = asSubclass.getConstructor(b);
                        constructor.setAccessible(true);
                        arrayMap.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(this.a, attributeSet);
                }
                return newInstance;
            } catch (Exception e) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
            }
        } else {
            throw new InflateException(a.c3(str, " tag must have a 'class' attribute"));
        }
    }

    public final Transition b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.a, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.a, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.a, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.a, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.a, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.a, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.a, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.a, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.a, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.a, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) a(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            int depth2 = xmlPullParser.getDepth();
                            while (true) {
                                int next2 = xmlPullParser.next();
                                if ((next2 == 3 && xmlPullParser.getDepth() <= depth2) || next2 == 1) {
                                    break;
                                } else if (next2 == 2) {
                                    if (xmlPullParser.getName().equals("target")) {
                                        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, j.a);
                                        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                                        if (namedResourceId != 0) {
                                            transition.addTarget(namedResourceId);
                                        } else {
                                            int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                                            if (namedResourceId2 != 0) {
                                                transition.excludeTarget(namedResourceId2, true);
                                            } else {
                                                String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                                                if (namedString != null) {
                                                    transition.addTarget(namedString);
                                                } else {
                                                    String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                                    if (namedString2 != null) {
                                                        transition.excludeTarget(namedString2, true);
                                                    } else {
                                                        String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                                        if (namedString3 != null) {
                                                            try {
                                                                transition.excludeTarget(Class.forName(namedString3), true);
                                                            } catch (ClassNotFoundException e) {
                                                                obtainStyledAttributes.recycle();
                                                                throw new RuntimeException(a.c3("Could not create ", namedString3), e);
                                                            }
                                                        } else {
                                                            String namedString4 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                                            if (namedString4 != null) {
                                                                transition.addTarget(Class.forName(namedString4));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        obtainStyledAttributes.recycle();
                                    } else {
                                        throw new RuntimeException(a.G(xmlPullParser, a.L("Unknown scene name: ")));
                                    }
                                }
                            }
                        } else if ("arcMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion(new ArcMotion(this.a, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        } else if ("pathMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion((PathMotion) a(attributeSet, PathMotion.class, "pathMotion"));
                            } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                        } else if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException(a.G(xmlPullParser, a.L("Unknown scene name: ")));
                        } else if (transition != null) {
                            transition.setPathMotion(new PatternPathMotion(this.a, attributeSet));
                        } else {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                b(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.addTransition(transition2);
        }
        return transition2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.transition.TransitionManager c(org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.view.ViewGroup r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r9 = this;
            int r0 = r10.getDepth()
            r1 = 0
            r2 = r1
        L_0x0006:
            int r3 = r10.next()
            r4 = 3
            if (r3 != r4) goto L_0x0013
            int r4 = r10.getDepth()
            if (r4 <= r0) goto L_0x009c
        L_0x0013:
            r4 = 1
            if (r3 == r4) goto L_0x009c
            r5 = 2
            if (r3 == r5) goto L_0x001a
            goto L_0x0006
        L_0x001a:
            java.lang.String r3 = r10.getName()
            java.lang.String r6 = "transitionManager"
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x002d
            androidx.transition.TransitionManager r2 = new androidx.transition.TransitionManager
            r2.<init>()
            goto L_0x0006
        L_0x002d:
            java.lang.String r6 = "transition"
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x008c
            if (r2 == 0) goto L_0x008c
            android.content.Context r3 = r9.a
            int[] r7 = l6.z.j.b
            android.content.res.TypedArray r3 = r3.obtainStyledAttributes(r11, r7)
            r7 = -1
            int r5 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(r3, r10, r6, r5, r7)
            r6 = 0
            java.lang.String r8 = "fromScene"
            int r6 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(r3, r10, r8, r6, r7)
            if (r6 >= 0) goto L_0x0050
            r6 = r1
            goto L_0x0056
        L_0x0050:
            android.content.Context r8 = r9.a
            androidx.transition.Scene r6 = androidx.transition.Scene.getSceneForLayout(r12, r6, r8)
        L_0x0056:
            java.lang.String r8 = "toScene"
            int r4 = androidx.core.content.res.TypedArrayUtils.getNamedResourceId(r3, r10, r8, r4, r7)
            if (r4 >= 0) goto L_0x0061
            r4 = r1
            goto L_0x0067
        L_0x0061:
            android.content.Context r7 = r9.a
            androidx.transition.Scene r4 = androidx.transition.Scene.getSceneForLayout(r12, r4, r7)
        L_0x0067:
            if (r5 < 0) goto L_0x0087
            androidx.transition.Transition r7 = r9.inflateTransition(r5)
            if (r7 == 0) goto L_0x0087
            if (r4 == 0) goto L_0x007b
            if (r6 != 0) goto L_0x0077
            r2.setTransition(r4, r7)
            goto L_0x0087
        L_0x0077:
            r2.setTransition(r6, r4, r7)
            goto L_0x0087
        L_0x007b:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r11 = "No toScene for transition ID "
            java.lang.String r11 = a2.b.a.a.a.M2(r11, r5)
            r10.<init>(r11)
            throw r10
        L_0x0087:
            r3.recycle()
            goto L_0x0006
        L_0x008c:
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r12 = "Unknown scene name: "
            java.lang.StringBuilder r12 = a2.b.a.a.a.L(r12)
            java.lang.String r10 = a2.b.a.a.a.G(r10, r12)
            r11.<init>(r10)
            throw r11
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.TransitionManager");
    }

    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.a.getResources().getXml(i);
        try {
            Transition b2 = b(xml, Xml.asAttributeSet(xml), null);
            xml.close();
            return b2;
        } catch (XmlPullParserException e) {
            throw new InflateException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new InflateException(xml.getPositionDescription() + ": " + e2.getMessage(), e2);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.a.getResources().getXml(i);
        try {
            TransitionManager c2 = c(xml, Xml.asAttributeSet(xml), viewGroup);
            xml.close();
            return c2;
        } catch (XmlPullParserException e) {
            InflateException inflateException = new InflateException(e.getMessage());
            inflateException.initCause(e);
            throw inflateException;
        } catch (IOException e2) {
            InflateException inflateException2 = new InflateException(xml.getPositionDescription() + ": " + e2.getMessage());
            inflateException2.initCause(e2);
            throw inflateException2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
