package com.google.android.material.datepicker;

import a2.j.b.d.j.a;
import a2.j.b.d.j.b;
import a2.j.b.d.j.t;
import a2.j.b.d.j.u;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> c;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView s;

        public ViewHolder(TextView textView) {
            super(textView);
            this.s = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.c = materialCalendar;
    }

    public int a(int i) {
        return i - this.c.c.a.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.c.e;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = viewHolder;
        int i2 = this.c.c.a.c + i;
        String string = viewHolder2.s.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder2.s.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        viewHolder2.s.setContentDescription(String.format(string, Integer.valueOf(i2)));
        b bVar = this.c.f;
        Calendar h = t.h();
        a aVar = h.get(1) == i2 ? bVar.f : bVar.d;
        for (Long l : this.c.getDateSelector().getSelectedDays()) {
            h.setTimeInMillis(l.longValue());
            if (h.get(1) == i2) {
                aVar = bVar.e;
            }
        }
        aVar.b(viewHolder2.s);
        viewHolder2.s.setOnClickListener(new u(this, i2));
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$ViewHolder' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
