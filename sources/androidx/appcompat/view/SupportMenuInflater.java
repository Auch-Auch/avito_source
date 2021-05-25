package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;
import com.avito.android.remote.model.Navigation;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SupportMenuInflater extends MenuInflater {
    public static final Class<?>[] e;
    public static final Class<?>[] f;
    public final Object[] a;
    public final Object[] b;
    public Context c;
    public Object d;

    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = {MenuItem.class};
        public Object a;
        public Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException(a2.b.a.a.a.B2(cls, a2.b.a.a.a.R("Couldn't resolve menu item onClick handler ", str, " in class ")));
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public class b {
        public ActionProvider A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public Menu a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.a = menu;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public SubMenu a() {
            this.h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, SupportMenuInflater.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i2 = this.v;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.z != null) {
                if (!SupportMenuInflater.this.c.isRestricted()) {
                    SupportMenuInflater supportMenuInflater = SupportMenuInflater.this;
                    if (supportMenuInflater.d == null) {
                        supportMenuInflater.d = supportMenuInflater.a(supportMenuInflater.c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(supportMenuInflater.d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).setExclusiveCheckable(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).setExclusiveCheckable(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, SupportMenuInflater.e, SupportMenuInflater.this.a));
                z2 = true;
            }
            int i3 = this.w;
            if (i3 > 0 && !z2) {
                menuItem.setActionView(i3);
            }
            ActionProvider actionProvider = this.A;
            if (actionProvider != null) {
                MenuItemCompat.setActionProvider(menuItem, actionProvider);
            }
            MenuItemCompat.setContentDescription(menuItem, this.B);
            MenuItemCompat.setTooltipText(menuItem, this.C);
            MenuItemCompat.setAlphabeticShortcut(menuItem, this.n, this.o);
            MenuItemCompat.setNumericShortcut(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                MenuItemCompat.setIconTintMode(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                MenuItemCompat.setIconTintList(menuItem, colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        char c2;
        char c3;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(a2.b.a.a.a.c3("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                            eventType = xmlPullParser.next();
                        } else if (name2.equals(Navigation.GROUP)) {
                            bVar.b = 0;
                            bVar.c = 0;
                            bVar.d = 0;
                            bVar.e = 0;
                            bVar.f = true;
                            bVar.g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.h) {
                                ActionProvider actionProvider = bVar.A;
                                if (actionProvider == null || !actionProvider.hasSubMenu()) {
                                    bVar.h = true;
                                    bVar.c(bVar.a.add(bVar.b, bVar.i, bVar.j, bVar.k));
                                } else {
                                    bVar.a();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                            eventType = xmlPullParser.next();
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals(Navigation.GROUP)) {
                        TypedArray obtainStyledAttributes = SupportMenuInflater.this.c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
                        bVar.b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
                        bVar.c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
                        bVar.d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
                        bVar.e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
                        bVar.f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
                        bVar.g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(SupportMenuInflater.this.c, attributeSet, R.styleable.MenuItem);
                        bVar.i = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_id, 0);
                        bVar.j = (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_menuCategory, bVar.c) & SupportMenu.CATEGORY_MASK) | (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_orderInCategory, bVar.d) & 65535);
                        bVar.k = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_title);
                        bVar.l = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_titleCondensed);
                        bVar.m = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_icon, 0);
                        String string = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_alphabeticShortcut);
                        if (string == null) {
                            c2 = 0;
                        } else {
                            c2 = string.charAt(0);
                        }
                        bVar.n = c2;
                        bVar.o = obtainStyledAttributes2.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
                        String string2 = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_numericShortcut);
                        if (string2 == null) {
                            c3 = 0;
                        } else {
                            c3 = string2.charAt(0);
                        }
                        bVar.p = c3;
                        bVar.q = obtainStyledAttributes2.getInt(R.styleable.MenuItem_numericModifiers, 4096);
                        int i = R.styleable.MenuItem_android_checkable;
                        if (obtainStyledAttributes2.hasValue(i)) {
                            bVar.r = obtainStyledAttributes2.getBoolean(i, false) ? 1 : 0;
                        } else {
                            bVar.r = bVar.e;
                        }
                        bVar.s = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_checked, false);
                        bVar.t = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_visible, bVar.f);
                        bVar.u = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_enabled, bVar.g);
                        bVar.v = obtainStyledAttributes2.getInt(R.styleable.MenuItem_showAsAction, -1);
                        bVar.z = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_onClick);
                        bVar.w = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_actionLayout, 0);
                        bVar.x = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionViewClass);
                        String string3 = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionProviderClass);
                        bVar.y = string3;
                        if ((string3 != null) && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (ActionProvider) bVar.b(string3, f, SupportMenuInflater.this.b);
                        } else {
                            bVar.A = null;
                        }
                        bVar.B = obtainStyledAttributes2.getText(R.styleable.MenuItem_contentDescription);
                        bVar.C = obtainStyledAttributes2.getText(R.styleable.MenuItem_tooltipText);
                        int i2 = R.styleable.MenuItem_iconTintMode;
                        if (obtainStyledAttributes2.hasValue(i2)) {
                            bVar.E = DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(i2, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        int i3 = R.styleable.MenuItem_iconTint;
                        if (obtainStyledAttributes2.hasValue(i3)) {
                            bVar.D = obtainStyledAttributes2.getColorStateList(i3);
                        } else {
                            bVar.D = null;
                        }
                        obtainStyledAttributes2.recycle();
                        bVar.h = false;
                    } else {
                        if (name3.equals("menu")) {
                            b(xmlPullParser, attributeSet, bVar.a());
                        } else {
                            z2 = true;
                            str = name3;
                        }
                        eventType = xmlPullParser.next();
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(@LayoutRes int i, Menu menu) {
        if (!(menu instanceof SupportMenu)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.c.getResources().getLayout(i);
            b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
