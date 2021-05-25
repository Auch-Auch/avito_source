package a2.a.a.m0;

import android.content.DialogInterface;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.deep_linking.links.DetailsSheetButton;
import com.avito.android.details_sheet.DetailsSheetActivity;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalImage;
public final class b implements DialogInterface.OnDismissListener {
    public final /* synthetic */ DetailsSheetActivity a;

    public b(DetailsSheetActivity detailsSheetActivity, boolean z, UniversalImage universalImage, Image image, String str, CharSequence charSequence, String str2, DetailsSheetButton detailsSheetButton, ParametrizedClickStreamEvent parametrizedClickStreamEvent, boolean z2) {
        this.a = detailsSheetActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
