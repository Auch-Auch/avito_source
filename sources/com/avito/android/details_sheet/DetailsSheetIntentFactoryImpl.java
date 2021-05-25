package com.avito.android.details_sheet;

import android.app.Application;
import android.content.Intent;
import com.avito.android.DetailsSheetIntentFactory;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/details_sheet/DetailsSheetIntentFactoryImpl;", "Lcom/avito/android/DetailsSheetIntentFactory;", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "clickEvent", "Landroid/content/Intent;", "detailsSheetIntent", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "details-sheet_release"}, k = 1, mv = {1, 4, 2})
public final class DetailsSheetIntentFactoryImpl implements DetailsSheetIntentFactory {
    public final Application a;

    @Inject
    public DetailsSheetIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.DetailsSheetIntentFactory
    @NotNull
    public Intent detailsSheetIntent(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
        Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
        Intent putExtra = new Intent(this.a, DetailsSheetActivity.class).putExtra(DetailsSheetActivity.EXTRA_BODY, detailsSheetLinkBody).putExtra(DetailsSheetActivity.EXTRA_BUTTON_CLICK_EVENT, parametrizedClickStreamEvent);
        Intrinsics.checkNotNullExpressionValue(putExtra, "context.createActivityIn…_CLICK_EVENT, clickEvent)");
        return putExtra;
    }
}
