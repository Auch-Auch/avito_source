package com.avito.android.user_advert.advert.autopublish_block;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.R;
import com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_advert/advert/autopublish_block/AutoPublishBlockResourceProvider;", "Lcom/avito/android/user_advert/advert/switcher_block/SwitcherBlockResourceProvider;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSwitcherDisableErrorText", "()Ljava/lang/String;", "switcherDisableErrorText", AuthSource.SEND_ABUSE, "getSwitcherEnableErrorText", "switcherEnableErrorText", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class AutoPublishBlockResourceProvider implements SwitcherBlockResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    @Inject
    public AutoPublishBlockResourceProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String string = resources.getString(R.string.autopublish_switcher_enable_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…sh_switcher_enable_error)");
        this.a = string;
        String string2 = resources.getString(R.string.autopublish_switcher_disable_error);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…h_switcher_disable_error)");
        this.b = string2;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider
    @NotNull
    public String getSwitcherDisableErrorText() {
        return this.b;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.SwitcherBlockResourceProvider
    @NotNull
    public String getSwitcherEnableErrorText() {
        return this.a;
    }
}
