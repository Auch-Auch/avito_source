package a2.a.a.n0.d.b;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.remote.model.DopValue;
import com.avito.android.developments_catalog.remote.model.KeyValue;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends ReuseChildrenHelper<KeyValue, TextView> {
    public final ViewGroup a;
    public final Context b;
    public final LayoutInflater c;

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.developments_catalog_info_params_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.d…catalog_info_params_root)");
        this.a = (ViewGroup) findViewById;
        Context context = view.getContext();
        this.b = context;
        this.c = LayoutInflater.from(context);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public void bindData(TextView textView, KeyValue keyValue, int i) {
        SpannableString spannableString;
        int i2;
        TextView textView2 = textView;
        KeyValue keyValue2 = keyValue;
        Intrinsics.checkNotNullParameter(textView2, "view");
        Intrinsics.checkNotNullParameter(keyValue2, "data");
        String value = keyValue2.getValue();
        DopValue dopValue = keyValue2.getDopValue();
        String value2 = dopValue != null ? dopValue.getValue() : null;
        if (!(value == null || value2 == null)) {
            if (value2.length() > 0) {
                String e3 = a2.b.a.a.a.e3(value, ", ", value2);
                spannableString = new SpannableString(e3);
                Context context = this.b;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String color = dopValue.getColor();
                if (color != null && color.hashCode() == 98619139 && color.equals("green")) {
                    i2 = com.avito.android.lib.design.R.attr.green;
                } else {
                    i2 = com.avito.android.lib.design.R.attr.black;
                }
                spannableString.setSpan(new ForegroundColorSpan(Contexts.getColorByAttr(context, i2)), value.length() + 2, e3.length(), 34);
                TextViews.bindText$default(textView2, spannableString, false, 2, null);
            }
        }
        spannableString = new SpannableString(value);
        TextViews.bindText$default(textView2, spannableString, false, 2, null);
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public TextView createChild() {
        View inflate = this.c.inflate(R.layout.info_param, this.a, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        return (TextView) inflate;
    }
}
