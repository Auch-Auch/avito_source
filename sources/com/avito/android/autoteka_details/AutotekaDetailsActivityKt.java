package com.avito.android.autoteka_details;

import android.content.Context;
import android.content.Intent;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "", "id", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "utmQuery", "Landroid/content/Intent;", "createAutotekaDetailsIntent", "(Landroid/content/Context;Ljava/lang/String;Lcom/avito/android/remote/model/AutotekaDetailsResponse;Ljava/lang/String;)Landroid/content/Intent;", "autoteka-details_release"}, k = 2, mv = {1, 4, 2})
public final class AutotekaDetailsActivityKt {
    @NotNull
    public static final Intent createAutotekaDetailsIntent(@NotNull Context context, @NotNull String str, @Nullable AutotekaDetailsResponse autotekaDetailsResponse, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        Intent intent = new Intent(context, AutotekaDetailsActivity.class);
        intent.putExtra("autoteka_id", str);
        intent.putExtra("autoteka_details", autotekaDetailsResponse);
        intent.putExtra("autoteka_utm_query", str2);
        return intent;
    }
}
