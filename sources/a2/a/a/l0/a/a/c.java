package a2.a.a.l0.a.a;

import android.view.View;
import com.avito.android.design.widget.picker.HorizontalPickerView;
public final class c implements View.OnClickListener {
    public final /* synthetic */ HorizontalPickerView.a a;
    public final /* synthetic */ HorizontalPickerView.b b;

    public c(HorizontalPickerView.a aVar, HorizontalPickerView.b bVar) {
        this.a = aVar;
        this.b = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.d.invoke(Integer.valueOf(this.b.getAdapterPosition()));
    }
}
