package com.avito.android.abuse;

import android.content.Context;
import android.content.Intent;
import com.avito.android.AbuseIntentFactory;
import com.avito.android.abuse.auth.AuthQueryActivityKt;
import com.avito.android.abuse.category.AbuseCategoryActivityKt;
import com.avito.android.abuse.details.AbuseDetailsActivityKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ9\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/abuse/AbuseIntentFactoryImpl;", "Lcom/avito/android/AbuseIntentFactory;", "", BookingInfoActivity.EXTRA_ITEM_ID, "src", "", "Lcom/avito/android/remote/model/Action;", "actions", "Landroid/content/Intent;", "abuseCategoryIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "", "abuseCategoryId", "itemId", "abuseDetails", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;", "authQueryIntent", "()Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseIntentFactoryImpl implements AbuseIntentFactory {
    public final Context a;

    @Inject
    public AbuseIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.AbuseIntentFactory
    @NotNull
    public Intent abuseCategoryIntent(@NotNull String str, @Nullable String str2, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        return AbuseCategoryActivityKt.createAbuseCategoryIntent(this.a, str, str2, list);
    }

    @Override // com.avito.android.AbuseIntentFactory
    @NotNull
    public Intent abuseDetails(int i, @NotNull String str, @Nullable String str2, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return AbuseDetailsActivityKt.createAbuseDetailsActivityIntent(this.a, i, str, str2, list);
    }

    @Override // com.avito.android.AbuseIntentFactory
    @NotNull
    public Intent authQueryIntent() {
        return AuthQueryActivityKt.createAuthQueryIntent(this.a);
    }
}
