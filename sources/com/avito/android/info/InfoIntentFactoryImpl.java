package com.avito.android.info;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.StringRes;
import com.avito.android.InfoIntentFactory;
import com.avito.android.info.ui.InfoActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\tJ!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0006\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/info/InfoIntentFactoryImpl;", "Lcom/avito/android/InfoIntentFactory;", "", MessageMetaInfo.COLUMN_PATH, "title", "Landroid/content/Intent;", "infoIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "infoForUserAgreementIntent", "()Landroid/content/Intent;", "infoForAppsLicenceIntent", "infoForOfferIntent", "infoForPaidPlacementIntent", "", "id", "(Ljava/lang/String;I)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "info_release"}, k = 1, mv = {1, 4, 2})
public final class InfoIntentFactoryImpl implements InfoIntentFactory {
    public final Context a;

    @Inject
    public InfoIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoForAppsLicenceIntent() {
        return infoIntent("apps-license-agreement", R.string.read_apps_licence);
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoForOfferIntent() {
        return infoIntent("oferta", R.string.read_offer);
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoForPaidPlacementIntent() {
        return infoIntent("app_fee", R.string.fees_paid_placement);
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoForUserAgreementIntent() {
        return infoIntent("user_agreement", R.string.read_licence);
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoIntent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        Intrinsics.checkNotNullParameter(str2, "title");
        return InfoActivityKt.createInfoIntent(this.a, str, str2);
    }

    @Override // com.avito.android.InfoIntentFactory
    @NotNull
    public Intent infoIntent(@NotNull String str, @StringRes int i) {
        Intrinsics.checkNotNullParameter(str, MessageMetaInfo.COLUMN_PATH);
        String string = this.a.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(id)");
        return infoIntent(str, string);
    }
}
