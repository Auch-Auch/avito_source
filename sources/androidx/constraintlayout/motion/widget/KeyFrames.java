package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
public class KeyFrames {
    public static final int UNSET = -1;
    public static HashMap<String, Constructor<? extends Key>> b;
    public HashMap<Integer, ArrayList<Key>> a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        b = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            b.put("KeyPosition", KeyPosition.class.getConstructor(new Class[0]));
            b.put("KeyCycle", KeyCycle.class.getConstructor(new Class[0]));
            b.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            b.put("KeyTrigger", KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException unused) {
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> hashMap;
        Key key = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (b.containsKey(name)) {
                        try {
                            Key key2 = (Key) b.get(name).newInstance(new Object[0]);
                            try {
                                key2.load(context, Xml.asAttributeSet(xmlPullParser));
                                a(key2);
                            } catch (Exception unused) {
                            }
                            key = key2;
                        } catch (Exception unused2) {
                        }
                    } else if (!(!name.equalsIgnoreCase("CustomAttribute") || key == null || (hashMap = key.d) == null)) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(Key key) {
        if (!this.a.containsKey(Integer.valueOf(key.b))) {
            this.a.put(Integer.valueOf(key.b), new ArrayList<>());
        }
        this.a.get(Integer.valueOf(key.b)).add(key);
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.a.get(Integer.valueOf(motionController.b));
        if (arrayList != null) {
            motionController.v.addAll(arrayList);
        }
        ArrayList<Key> arrayList2 = this.a.get(-1);
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                String str = ((ConstraintLayout.LayoutParams) motionController.a.getLayoutParams()).constraintTag;
                String str2 = next.c;
                if ((str2 == null || str == null) ? false : str.matches(str2)) {
                    motionController.v.add(next);
                }
            }
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        return this.a.get(Integer.valueOf(i));
    }

    public Set<Integer> getKeys() {
        return this.a.keySet();
    }
}
