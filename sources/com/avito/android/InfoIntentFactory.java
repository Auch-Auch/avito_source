package com.avito.android;

import android.content.Intent;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/InfoIntentFactory;", "", "", MessageMetaInfo.COLUMN_PATH, "title", "Landroid/content/Intent;", "infoIntent", "(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "", "id", "(Ljava/lang/String;I)Landroid/content/Intent;", "infoForUserAgreementIntent", "()Landroid/content/Intent;", "infoForAppsLicenceIntent", "infoForOfferIntent", "infoForPaidPlacementIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface InfoIntentFactory {
    @NotNull
    Intent infoForAppsLicenceIntent();

    @NotNull
    Intent infoForOfferIntent();

    @NotNull
    Intent infoForPaidPlacementIntent();

    @NotNull
    Intent infoForUserAgreementIntent();

    @NotNull
    Intent infoIntent(@NotNull String str, @StringRes int i);

    @NotNull
    Intent infoIntent(@NotNull String str, @NotNull String str2);
}
