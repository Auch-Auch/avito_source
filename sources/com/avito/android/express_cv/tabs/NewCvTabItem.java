package com.avito.android.express_cv.tabs;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/express_cv/tabs/NewCvTabItem;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class NewCvTabItem implements CvTabItem {
    @NotNull
    public final String a;

    public NewCvTabItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = str;
    }

    @Override // com.avito.android.express_cv.tabs.CvTabItem
    @NotNull
    public String getTitle() {
        return this.a;
    }
}
