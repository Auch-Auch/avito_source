package l6.k.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.databinding.ObservableList;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class a<T> extends BaseAdapter {
    public List<T> a;
    public ObservableList.OnListChangedCallback b;
    public final Context c;
    public final int d;
    public final int e;
    public final int f;
    public final LayoutInflater g;

    /* renamed from: l6.k.b.a$a  reason: collision with other inner class name */
    public class C0530a extends ObservableList.OnListChangedCallback {
        public C0530a() {
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(ObservableList observableList) {
            a.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(ObservableList observableList, int i, int i2) {
            a.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(ObservableList observableList, int i, int i2) {
            a.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(ObservableList observableList, int i, int i2, int i3) {
            a.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(ObservableList observableList, int i, int i2) {
            a.this.notifyDataSetChanged();
        }
    }

    public a(Context context, List<T> list, int i, int i2, int i3) {
        LayoutInflater layoutInflater;
        this.c = context;
        this.e = i;
        this.d = i2;
        this.f = i3;
        if (i == 0) {
            layoutInflater = null;
        } else {
            layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }
        this.g = layoutInflater;
        b(list);
    }

    public View a(int i, int i2, View view, ViewGroup viewGroup) {
        View view2;
        T t;
        if (view == null) {
            if (i == 0) {
                view = new TextView(this.c);
            } else {
                view = this.g.inflate(i, viewGroup, false);
            }
        }
        int i3 = this.f;
        if (i3 == 0) {
            view2 = view;
        } else {
            view2 = view.findViewById(i3);
        }
        TextView textView = (TextView) view2;
        T t2 = this.a.get(i2);
        if (t2 instanceof CharSequence) {
            t = t2;
        } else {
            t = String.valueOf(t2);
        }
        textView.setText(t);
        return view;
    }

    public void b(List<T> list) {
        List<T> list2 = this.a;
        if (list2 != list) {
            if (list2 instanceof ObservableList) {
                ((ObservableList) list2).removeOnListChangedCallback(this.b);
            }
            this.a = list;
            if (list instanceof ObservableList) {
                if (this.b == null) {
                    this.b = new C0530a();
                }
                ((ObservableList) this.a).addOnListChangedCallback(this.b);
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(this.d, i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(this.e, i, view, viewGroup);
    }
}
