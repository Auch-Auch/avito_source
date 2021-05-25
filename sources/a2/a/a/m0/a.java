package a2.a.a.m0;

import android.content.Intent;
import android.view.View;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetButton;
import com.avito.android.details_sheet.DetailsSheetActivity;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalImage;
public final class a implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog a;
    public final /* synthetic */ DetailsSheetActivity b;
    public final /* synthetic */ DetailsSheetButton c;
    public final /* synthetic */ ParametrizedClickStreamEvent d;

    public a(BottomSheetDialog bottomSheetDialog, DetailsSheetActivity detailsSheetActivity, boolean z, UniversalImage universalImage, Image image, String str, CharSequence charSequence, String str2, DetailsSheetButton detailsSheetButton, ParametrizedClickStreamEvent parametrizedClickStreamEvent, boolean z2) {
        this.a = bottomSheetDialog;
        this.b = detailsSheetActivity;
        this.c = detailsSheetButton;
        this.d = parametrizedClickStreamEvent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent;
        ParametrizedClickStreamEvent parametrizedClickStreamEvent = this.d;
        if (parametrizedClickStreamEvent != null) {
            this.b.getAnalytics().track(parametrizedClickStreamEvent);
        }
        this.a.close();
        DeepLink deeplink = this.c.getDeeplink();
        if (deeplink != null && (intent = this.b.getDeeplinkIntentFactory().getIntent(deeplink)) != null) {
            this.b.startActivity(intent);
        }
    }
}
