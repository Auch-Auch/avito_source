package com.avito.android.abuse.details;

import android.content.res.Resources;
import com.avito.android.abuse.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/abuse/details/AbuseDetailsResourceProviderImpl;", "Lcom/avito/android/abuse/details/AbuseDetailsResourceProvider;", "", "getCommentHint", "()Ljava/lang/String;", "commentHint", "getEmotionHint", "emotionHint", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AbuseDetailsResourceProviderImpl implements AbuseDetailsResourceProvider {
    public final Resources a;

    @Inject
    public AbuseDetailsResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsResourceProvider
    @NotNull
    public String getCommentHint() {
        String string = this.a.getString(R.string.abuse_comment);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.abuse_comment)");
        return string;
    }

    @Override // com.avito.android.abuse.details.AbuseDetailsResourceProvider
    @NotNull
    public String getEmotionHint() {
        String string = this.a.getString(R.string.abuse_emotion);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.abuse_emotion)");
        return string;
    }
}
