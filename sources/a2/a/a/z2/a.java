package a2.a.a.z2;

import android.content.Context;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.spare_parts.SparePartsFormatterImpl;
import com.avito.android.spare_parts.SparePartsItemClickListener;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a implements OnUrlClickListener {
    public final /* synthetic */ SparePartsResponse.SparePartsGroup a;
    public final /* synthetic */ SparePartsItemClickListener b;

    public a(SparePartsResponse.SparePartsGroup sparePartsGroup, SparePartsFormatterImpl sparePartsFormatterImpl, SparePartsItemClickListener sparePartsItemClickListener, Context context, ArrayList arrayList) {
        this.a = sparePartsGroup;
        this.b = sparePartsItemClickListener;
    }

    @Override // com.avito.android.deep_linking.links.OnUrlClickListener
    public final boolean onUrlClick(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        SparePartsItemClickListener sparePartsItemClickListener = this.b;
        if (sparePartsItemClickListener == null) {
            return true;
        }
        sparePartsItemClickListener.onItemClicked(this.a);
        return true;
    }
}
