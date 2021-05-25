package a2.a.a.n0.d.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.remote.model.KeyValue;
import com.avito.android.lib.util.ReuseChildrenHelper;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends ReuseChildrenHelper<KeyValue, com.avito.android.advert_core.KeyValue> {
    public final ViewGroup a;
    public final LayoutInflater b;

    public a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.params_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(de…og_R.id.params_container)");
        this.a = (ViewGroup) findViewById;
        this.b = LayoutInflater.from(view.getContext());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public void bindData(com.avito.android.advert_core.KeyValue keyValue, KeyValue keyValue2, int i) {
        com.avito.android.advert_core.KeyValue keyValue3 = keyValue;
        KeyValue keyValue4 = keyValue2;
        Intrinsics.checkNotNullParameter(keyValue3, "view");
        Intrinsics.checkNotNullParameter(keyValue4, "data");
        String name = keyValue4.getName();
        String str = "";
        if (name == null) {
            name = str;
        }
        keyValue3.setTitle(name);
        String value = keyValue4.getValue();
        if (value != null) {
            str = value;
        }
        keyValue3.setText(str);
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public com.avito.android.advert_core.KeyValue createChild() {
        View inflate = this.b.inflate(com.avito.android.advert_core.R.layout.rds_key_value, this.a, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.advert_core.KeyValue");
        return (com.avito.android.advert_core.KeyValue) inflate;
    }
}
