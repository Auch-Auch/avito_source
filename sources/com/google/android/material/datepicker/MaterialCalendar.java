package com.google.android.material.datepicker;

import a2.j.b.d.j.g;
import a2.j.b.d.j.h;
import a2.j.b.d.j.i;
import a2.j.b.d.j.j;
import a2.j.b.d.j.k;
import a2.j.b.d.j.n;
import a2.j.b.d.j.q;
import a2.j.b.d.j.r;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialCalendar<S> extends q<S> {
    public static final /* synthetic */ int k = 0;
    @StyleRes
    public int a;
    @Nullable
    public DateSelector<S> b;
    @Nullable
    public CalendarConstraints c;
    @Nullable
    public n d;
    public e e;
    public a2.j.b.d.j.b f;
    public RecyclerView g;
    public RecyclerView h;
    public View i;
    public View j;

    public class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.h.smoothScrollToPosition(this.a);
        }
    }

    public class b extends AccessibilityDelegateCompat {
        public b(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public class c extends r {
        public final /* synthetic */ int I;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.I = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.I == 0) {
                iArr[0] = MaterialCalendar.this.h.getWidth();
                iArr[1] = MaterialCalendar.this.h.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.h.getHeight();
            iArr[1] = MaterialCalendar.this.h.getHeight();
        }
    }

    public class d implements f {
        public d() {
        }
    }

    public enum e {
        DAY,
        YEAR
    }

    public interface f {
    }

    @NonNull
    public static <T> MaterialCalendar<T> newInstance(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.d);
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    @NonNull
    public LinearLayoutManager a() {
        return (LinearLayoutManager) this.h.getLayoutManager();
    }

    @Override // a2.j.b.d.j.q
    public boolean addOnSelectionChangedListener(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.onSelectionChangedListeners.add(onSelectionChangedListener);
    }

    public final void b(int i2) {
        this.h.post(new a(i2));
    }

    public void c(n nVar) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.h.getAdapter();
        int i2 = monthsPagerAdapter.d.a.i(nVar);
        int b2 = i2 - monthsPagerAdapter.b(this.d);
        boolean z = true;
        boolean z2 = Math.abs(b2) > 3;
        if (b2 <= 0) {
            z = false;
        }
        this.d = nVar;
        if (z2 && z) {
            this.h.scrollToPosition(i2 - 3);
            b(i2);
        } else if (z2) {
            this.h.scrollToPosition(i2 + 3);
            b(i2);
        } else {
            b(i2);
        }
    }

    public void d(e eVar) {
        this.e = eVar;
        if (eVar == e.YEAR) {
            this.g.getLayoutManager().scrollToPosition(((YearGridAdapter) this.g.getAdapter()).a(this.d.c));
            this.i.setVisibility(0);
            this.j.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.i.setVisibility(8);
            this.j.setVisibility(0);
            c(this.d);
        }
    }

    @Nullable
    public DateSelector<S> getDateSelector() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.a = bundle.getInt("THEME_RES_ID_KEY");
        this.b = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.c = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.d = (n) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.a);
        this.f = new a2.j.b.d.j.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        n nVar = this.c.a;
        if (MaterialDatePicker.b(contextThemeWrapper)) {
            i3 = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new a2.j.b.d.j.e());
        gridView.setNumColumns(nVar.d);
        gridView.setEnabled(false);
        this.h = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.h.setLayoutManager(new c(getContext(), i2, false, i2));
        this.h.setTag("MONTHS_VIEW_GROUP_TAG");
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.b, this.c, new d());
        this.h.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        int i4 = R.id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i4);
        this.g = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.g.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.g.setAdapter(new YearGridAdapter(this));
            this.g.addItemDecoration(new a2.j.b.d.j.f(this));
        }
        int i5 = R.id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new g(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.i = inflate.findViewById(i4);
            this.j = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            d(e.DAY);
            materialButton.setText(this.d.g(inflate.getContext()));
            this.h.addOnScrollListener(new h(this, monthsPagerAdapter, materialButton));
            materialButton.setOnClickListener(new i(this));
            materialButton3.setOnClickListener(new j(this, monthsPagerAdapter));
            materialButton2.setOnClickListener(new k(this, monthsPagerAdapter));
        }
        if (!MaterialDatePicker.b(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.h);
        }
        this.h.scrollToPosition(monthsPagerAdapter.b(this.d));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.a);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.b);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.d);
    }
}
