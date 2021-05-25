package com.avito.android.social;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.SharingManager;
import com.avito.android.util.Contexts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/social/LiveJournalSocialManagerImpl;", "Lcom/avito/android/social/LiveJournalSocialManager;", "Landroid/app/Activity;", "activity", "", "link", "Lkotlin/Function1;", "Lcom/avito/android/social/SharingManager$ShareError;", "", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class LiveJournalSocialManagerImpl implements LiveJournalSocialManager {
    @Override // com.avito.android.social.LiveJournalSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return LiveJournalSocialManager.DefaultImpls.getType(this);
    }

    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        Contexts.startActivitySafely(activity, new Intent("android.intent.action.VIEW", Uri.parse("http://www.livejournal.com/update.bml?event=<a href=\"" + str + "\">" + str + "</a>")));
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return LiveJournalSocialManager.DefaultImpls.shouldRestoreShare(this, activity);
    }
}
