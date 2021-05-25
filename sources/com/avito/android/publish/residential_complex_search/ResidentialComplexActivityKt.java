package com.avito.android.publish.residential_complex_search;

import a2.b.a.a.a;
import android.content.Context;
import android.content.Intent;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001aE\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000b\"\u0016\u0010\r\u001a\u00020\f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroid/content/Context;", "context", "", "lat", "lng", "Ljava/util/ArrayList;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "Lkotlin/collections/ArrayList;", ResidentialComplexModuleKt.VALUES, "Landroid/content/Intent;", "createResidentialComplexActivityIntent", "(Landroid/content/Context;Ljava/lang/Double;Ljava/lang/Double;Ljava/util/ArrayList;)Landroid/content/Intent;", "", "EXTRA_SUGGEST_VALUE", "Ljava/lang/String;", "", "NO_RESIDENTIAL_COMPLEX_IN_LIST_ID", "I", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class ResidentialComplexActivityKt {
    @NotNull
    public static final String EXTRA_SUGGEST_VALUE = "extra_value";
    public static final int NO_RESIDENTIAL_COMPLEX_IN_LIST_ID = 0;

    @NotNull
    public static final Intent createResidentialComplexActivityIntent(@NotNull Context context, @Nullable Double d, @Nullable Double d2, @Nullable ArrayList<SelectParameter.Value> arrayList) {
        Intent X0 = a.X0(context, "context", context, ResidentialComplexActivity.class);
        if (d != null) {
            X0.putExtra("lat", d.doubleValue());
        }
        if (d2 != null) {
            X0.putExtra("lng", d2.doubleValue());
        }
        if (arrayList != null) {
            X0.putParcelableArrayListExtra(ResidentialComplexModuleKt.VALUES, arrayList);
        }
        return X0;
    }
}
