package com.avito.android.user_stats;

import android.content.res.Resources;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/user_stats/UserStatsResourcesProviderImpl;", "Lcom/avito/android/user_stats/UserStatsResourcesProvider;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getNetworkErrorMessage", "()Ljava/lang/String;", "networkErrorMessage", AuthSource.BOOKING_ORDER, "getDefaultErrorMessage", "defaultErrorMessage", "Lcom/avito/android/remote/model/UniversalColor;", "c", "Lcom/avito/android/remote/model/UniversalColor;", "getEmptyBarColor", "()Lcom/avito/android/remote/model/UniversalColor;", "emptyBarColor", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsResourcesProviderImpl implements UserStatsResourcesProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final UniversalColor c;

    @Inject
    public UserStatsResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.connection_problem);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…tring.connection_problem)");
        this.a = string;
        String string2 = resources.getString(R.string.unknown_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(ui_R.string.unknown_error)");
        this.b = string2;
        int i = com.avito.android.lib.design.avito.R.color.avito_gray_8;
        this.c = new UniversalColor("gray8", new Color(ResourcesCompat.getColor(resources, i, null)), new Color(ResourcesCompat.getColor(resources, i, null)));
    }

    @Override // com.avito.android.user_stats.UserStatsResourcesProvider
    @NotNull
    public String getDefaultErrorMessage() {
        return this.b;
    }

    @Override // com.avito.android.user_stats.UserStatsResourcesProvider
    @NotNull
    public UniversalColor getEmptyBarColor() {
        return this.c;
    }

    @Override // com.avito.android.user_stats.UserStatsResourcesProvider
    @NotNull
    public String getNetworkErrorMessage() {
        return this.a;
    }
}
