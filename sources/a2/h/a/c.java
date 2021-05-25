package a2.h.a;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.ArrayList;
import java.util.Stack;
public class c extends d {

    @TargetApi(21)
    public static class a implements AbstractC0030c {
        public final Toolbar a;

        public a(Toolbar toolbar) {
            this.a = toolbar;
        }

        @Override // a2.h.a.c.AbstractC0030c
        public View a(int i) {
            return this.a.getChildAt(i);
        }

        @Override // a2.h.a.c.AbstractC0030c
        public void b(ArrayList<View> arrayList, CharSequence charSequence, int i) {
            this.a.findViewsWithText(arrayList, charSequence, i);
        }

        @Override // a2.h.a.c.AbstractC0030c
        public int c() {
            return this.a.getChildCount();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public CharSequence d() {
            return this.a.getNavigationContentDescription();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public Drawable e() {
            return this.a.getNavigationIcon();
        }

        @Override // a2.h.a.c.AbstractC0030c
        @Nullable
        public Drawable f() {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.a.getOverflowIcon();
            }
            return null;
        }

        @Override // a2.h.a.c.AbstractC0030c
        public Object g() {
            return this.a;
        }

        @Override // a2.h.a.c.AbstractC0030c
        public void setNavigationContentDescription(CharSequence charSequence) {
            this.a.setNavigationContentDescription(charSequence);
        }
    }

    public static class b implements AbstractC0030c {
        public final androidx.appcompat.widget.Toolbar a;

        public b(androidx.appcompat.widget.Toolbar toolbar) {
            this.a = toolbar;
        }

        @Override // a2.h.a.c.AbstractC0030c
        public View a(int i) {
            return this.a.getChildAt(i);
        }

        @Override // a2.h.a.c.AbstractC0030c
        public void b(ArrayList<View> arrayList, CharSequence charSequence, int i) {
            this.a.findViewsWithText(arrayList, charSequence, i);
        }

        @Override // a2.h.a.c.AbstractC0030c
        public int c() {
            return this.a.getChildCount();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public CharSequence d() {
            return this.a.getNavigationContentDescription();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public Drawable e() {
            return this.a.getNavigationIcon();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public Drawable f() {
            return this.a.getOverflowIcon();
        }

        @Override // a2.h.a.c.AbstractC0030c
        public Object g() {
            return this.a;
        }

        @Override // a2.h.a.c.AbstractC0030c
        public void setNavigationContentDescription(CharSequence charSequence) {
            this.a.setNavigationContentDescription(charSequence);
        }
    }

    /* renamed from: a2.h.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0030c {
        View a(int i);

        void b(ArrayList<View> arrayList, CharSequence charSequence, int i);

        int c();

        CharSequence d();

        Drawable e();

        @Nullable
        Drawable f();

        Object g();

        void setNavigationContentDescription(CharSequence charSequence);
    }

    public c(androidx.appcompat.widget.Toolbar toolbar, @IdRes int i, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(toolbar.findViewById(i), charSequence, charSequence2);
    }

    public static View c(Object obj) {
        AbstractC0030c e = e(obj);
        CharSequence d = e.d();
        boolean z = !TextUtils.isEmpty(d);
        if (!z) {
            d = "taptarget-findme";
        }
        e.setNavigationContentDescription(d);
        ArrayList<View> arrayList = new ArrayList<>(1);
        e.b(arrayList, d, 2);
        if (!z) {
            e.setNavigationContentDescription(null);
        }
        if (arrayList.size() > 0) {
            return arrayList.get(0);
        }
        Drawable e2 = e.e();
        if (e2 != null) {
            int c = e.c();
            for (int i = 0; i < c; i++) {
                View a3 = e.a(i);
                if ((a3 instanceof ImageButton) && ((ImageButton) a3).getDrawable() == e2) {
                    return a3;
                }
            }
            throw new IllegalStateException("Could not find navigation view for Toolbar!");
        }
        throw new IllegalStateException("Toolbar does not have a navigation view set!");
    }

    public static View d(Object obj) {
        AbstractC0030c e = e(obj);
        Drawable f = e.f();
        if (f != null) {
            Stack stack = new Stack();
            stack.push((ViewGroup) e.g());
            while (!stack.empty()) {
                ViewGroup viewGroup = (ViewGroup) stack.pop();
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i < childCount) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof ViewGroup) {
                            stack.push((ViewGroup) childAt);
                        } else if ((childAt instanceof ImageView) && ((ImageView) childAt).getDrawable() == f) {
                            return childAt;
                        }
                        i++;
                    }
                }
            }
        }
        try {
            return (View) AppCompatDelegateImpl.i.H0(AppCompatDelegateImpl.i.H0(AppCompatDelegateImpl.i.H0(e.g(), "mMenuView"), "mPresenter"), "mOverflowButton");
        } catch (NoSuchFieldException e2) {
            throw new IllegalStateException("Could not find overflow view for Toolbar!", e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unable to access overflow view for Toolbar!", e3);
        }
    }

    public static AbstractC0030c e(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Given null instance");
        } else if (obj instanceof androidx.appcompat.widget.Toolbar) {
            return new b((androidx.appcompat.widget.Toolbar) obj);
        } else {
            if (obj instanceof Toolbar) {
                return new a((Toolbar) obj);
            }
            throw new IllegalStateException("Couldn't provide proper toolbar proxy instance");
        }
    }

    public c(Toolbar toolbar, @IdRes int i, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(toolbar.findViewById(i), charSequence, charSequence2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(androidx.appcompat.widget.Toolbar toolbar, boolean z, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(z ? c(toolbar) : d(toolbar), charSequence, charSequence2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Toolbar toolbar, boolean z, CharSequence charSequence, @Nullable CharSequence charSequence2) {
        super(z ? c(toolbar) : d(toolbar), charSequence, charSequence2);
    }
}
