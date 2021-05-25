package com.avito.android.user_adverts;

import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_adverts.root_screen.UserAdvertsFragmentData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/user_adverts/UserAdvertsIntentFactoryImpl;", "Lcom/avito/android/UserAdvertsIntentFactory;", "", "shortcut", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "advertAction", "", "openPublish", "Landroid/content/Intent;", "createUserAdvertsIntent", "(Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;Z)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsIntentFactoryImpl implements UserAdvertsIntentFactory {
    public final CoreActivityIntentFactory a;

    @Inject
    public UserAdvertsIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = coreActivityIntentFactory;
    }

    @Override // com.avito.android.UserAdvertsIntentFactory
    @NotNull
    public Intent createUserAdvertsIntent(@Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData, boolean z) {
        return this.a.mainScreenWithTab(new UserAdvertsFragmentData(str, null, advertActionTransferData, z, 2, null));
    }
}
