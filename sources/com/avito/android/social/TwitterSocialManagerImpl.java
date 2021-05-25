package com.avito.android.social;

import a2.b.a.a.a;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.avito.android.social.SharingManager;
import com.avito.android.social.TwitterSocialManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ5\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/social/TwitterSocialManagerImpl;", "Lcom/avito/android/social/TwitterSocialManager;", "Landroid/app/Activity;", "activity", "", "link", "Lkotlin/Function1;", "Lcom/avito/android/social/SharingManager$ShareError;", "", "errorListener", "share", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "social_release"}, k = 1, mv = {1, 4, 2})
public final class TwitterSocialManagerImpl implements TwitterSocialManager {
    @Override // com.avito.android.social.TwitterSocialManager, com.avito.android.social.IsSocialNetwork
    @NotNull
    public SocialType getType() {
        return TwitterSocialManager.DefaultImpls.getType(this);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0065: APUT  (r0v6 java.lang.Object[]), (0 ??[int, short, byte, char]), (r9v2 java.lang.String) */
    @Override // com.avito.android.social.SharingManager
    public void share(@NotNull Activity activity, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "link");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = activity.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (true) {
            if (!it.hasNext()) {
                intent = null;
                break;
            }
            ResolveInfo next = it.next();
            String str2 = next.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str2, "resolveInfo.activityInfo.packageName");
            if (m.startsWith$default(str2, "com.twitter.android", false, 2, null)) {
                ActivityInfo activityInfo = next.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
                break;
            }
        }
        if (intent == null) {
            Object[] objArr = new Object[1];
            try {
                String encode = URLEncoder.encode(str, "UTF8");
                Intrinsics.checkNotNullExpressionValue(encode, "URLEncoder.encode(link, \"UTF8\")");
                objArr[0] = encode;
                intent = new Intent("android.intent.action.VIEW", Uri.parse(a.H(objArr, 1, "https://twitter.com/intent/tweet?url=%s", "java.lang.String.format(format, *args)")));
            } catch (UnsupportedEncodingException e) {
                Timber.wtf(e, "UTF-8 should always be supported", new Object[0]);
                throw e;
            }
        }
        activity.startActivity(intent);
    }

    @Override // com.avito.android.social.SharingManager
    public boolean shouldRestoreShare(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return TwitterSocialManager.DefaultImpls.shouldRestoreShare(this, activity);
    }
}
