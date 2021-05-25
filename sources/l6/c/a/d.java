package l6.c.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
public class d implements View.OnClickListener {
    public final /* synthetic */ TextView a;

    public d(e eVar, TextView textView) {
        this.a = textView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TextViewCompat.getMaxLines(this.a) == Integer.MAX_VALUE) {
            this.a.setMaxLines(1);
            this.a.setEllipsize(TextUtils.TruncateAt.END);
            return;
        }
        this.a.setMaxLines(Integer.MAX_VALUE);
        this.a.setEllipsize(null);
    }
}
