package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    public final ArrayList<c> a = new ArrayList<>();
    public FrameLayout b;
    public Context c;
    public FragmentManager d;
    public int e;
    public TabHost.OnTabChangeListener f;
    public c g;
    public boolean h;

    public static class a implements TabHost.TabContentFactory {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    public static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new a();
        public String a;

        public static class a implements Parcelable.Creator<b> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i) {
                return new b[i];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        @NonNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("FragmentTabHost.SavedState{");
            L.append(Integer.toHexString(System.identityHashCode(this)));
            L.append(" curTab=");
            return a2.b.a.a.a.t(L, this.a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
        }

        public b(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
        }
    }

    public static final class c {
        @NonNull
        public final String a;
        @NonNull
        public final Class<?> b;
        @Nullable
        public final Bundle c;
        public Fragment d;

        public c(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            this.a = str;
            this.b = cls;
            this.c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, null);
        d(context, null);
    }

    @Nullable
    public final FragmentTransaction a(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        c cVar;
        Fragment fragment;
        int size = this.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cVar = null;
                break;
            }
            cVar = this.a.get(i);
            if (cVar.a.equals(str)) {
                break;
            }
            i++;
        }
        if (this.g != cVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.d.beginTransaction();
            }
            c cVar2 = this.g;
            if (!(cVar2 == null || (fragment = cVar2.d) == null)) {
                fragmentTransaction.detach(fragment);
            }
            if (cVar != null) {
                Fragment fragment2 = cVar.d;
                if (fragment2 == null) {
                    Fragment instantiate = this.d.getFragmentFactory().instantiate(this.c.getClassLoader(), cVar.b.getName());
                    cVar.d = instantiate;
                    instantiate.setArguments(cVar.c);
                    fragmentTransaction.add(this.e, cVar.d, cVar.a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
            }
            this.g = cVar;
        }
        return fragmentTransaction;
    }

    @Deprecated
    public void addTab(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new a(this.c));
        String tag = tabSpec.getTag();
        c cVar = new c(tag, cls, bundle);
        if (this.h) {
            Fragment findFragmentByTag = this.d.findFragmentByTag(tag);
            cVar.d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.d.beginTransaction();
                beginTransaction.detach(cVar.d);
                beginTransaction.commit();
            }
        }
        this.a.add(cVar);
        addTab(tabSpec);
    }

    public final void b() {
        if (this.b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.e);
            this.b = frameLayout;
            if (frameLayout == null) {
                StringBuilder L = a2.b.a.a.a.L("No tab content FrameLayout found for id ");
                L.append(this.e);
                throw new IllegalStateException(L.toString());
            }
        }
    }

    public final void c(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.b = frameLayout2;
            frameLayout2.setId(this.e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.View, android.view.ViewGroup
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.a.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            c cVar = this.a.get(i);
            Fragment findFragmentByTag = this.d.findFragmentByTag(cVar.a);
            cVar.d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (cVar.a.equals(currentTabTag)) {
                    this.g = cVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.d.beginTransaction();
                    }
                    fragmentTransaction.detach(cVar.d);
                }
            }
        }
        this.h = true;
        FragmentTransaction a3 = a(currentTabTag, fragmentTransaction);
        if (a3 != null) {
            a3.commit();
            this.d.executePendingTransactions();
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setCurrentTabByTag(bVar.a);
    }

    @Override // android.view.View
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.a = getCurrentTabTag();
        return bVar;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction a3;
        if (this.h && (a3 = a(str, null)) != null) {
            a3.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        c(context);
        super.setup();
        this.c = context;
        this.d = fragmentManager;
        b();
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    @Deprecated
    public void setup(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i) {
        c(context);
        super.setup();
        this.c = context;
        this.d = fragmentManager;
        this.e = i;
        b();
        this.b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}
