package com.google.android.material.datepicker;

import a2.j.b.d.j.n;
import a2.j.b.d.j.o;
import a2.j.b.d.j.p;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context c;
    @NonNull
    public final CalendarConstraints d;
    public final DateSelector<?> e;
    public final MaterialCalendar.f f;
    public final int g;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView s;
        public final MaterialCalendarGridView t;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.s = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.t = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.f fVar) {
        n nVar = calendarConstraints.a;
        n nVar2 = calendarConstraints.b;
        n nVar3 = calendarConstraints.d;
        if (nVar.compareTo(nVar3) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        } else if (nVar3.compareTo(nVar2) <= 0) {
            int i = o.f;
            int i2 = MaterialCalendar.k;
            Resources resources = context.getResources();
            int i3 = R.dimen.mtrl_calendar_day_height;
            int dimensionPixelSize = i * resources.getDimensionPixelSize(i3);
            int dimensionPixelSize2 = MaterialDatePicker.b(context) ? context.getResources().getDimensionPixelSize(i3) : 0;
            this.c = context;
            this.g = dimensionPixelSize + dimensionPixelSize2;
            this.d = calendarConstraints;
            this.e = dateSelector;
            this.f = fVar;
            setHasStableIds(true);
        } else {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
    }

    @NonNull
    public n a(int i) {
        return this.d.a.h(i);
    }

    public int b(@NonNull n nVar) {
        return this.d.a.i(nVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.d.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.d.a.h(i).a.getTimeInMillis();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        n h = this.d.a.h(i);
        viewHolder2.s.setText(h.g(viewHolder2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.t.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !h.equals(materialCalendarGridView.getAdapter().a)) {
            o oVar = new o(h, this.e, this.d);
            materialCalendarGridView.setNumColumns(h.d);
            materialCalendarGridView.setAdapter((ListAdapter) oVar);
        } else {
            materialCalendarGridView.invalidate();
            o a = materialCalendarGridView.getAdapter();
            for (Long l : a.c) {
                a.f(materialCalendarGridView, l.longValue());
            }
            DateSelector<?> dateSelector = a.b;
            if (dateSelector != null) {
                for (Long l2 : dateSelector.getSelectedDays()) {
                    a.f(materialCalendarGridView, l2.longValue());
                }
                a.c = a.b.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new p(this, materialCalendarGridView));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.b(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.g));
        return new ViewHolder(linearLayout, true);
    }
}
