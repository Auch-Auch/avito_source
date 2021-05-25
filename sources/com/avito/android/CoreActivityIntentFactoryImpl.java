package com.avito.android;

import android.app.Application;
import android.content.Intent;
import com.avito.android.bottom_navigation.ui.fragment.factory.HomeFragmentData;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.bottom_navigation.util.IntentsKt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/CoreActivityIntentFactoryImpl;", "Lcom/avito/android/CoreActivityIntentFactory;", "Landroid/content/Intent;", "homeIntent", "()Landroid/content/Intent;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "data", "mainScreenWithTab", "(Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class CoreActivityIntentFactoryImpl implements CoreActivityIntentFactory {
    public final Application a;

    @Inject
    public CoreActivityIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.CoreActivityIntentFactory
    @NotNull
    public Intent homeIntent() {
        Intent intent = new Intent();
        intent.setClassName(this.a, "com.avito.android.Launcher");
        intent.setFlags(603979776);
        IntentsKt.putTabFragmentData(intent, new HomeFragmentData());
        return intent;
    }

    @Override // com.avito.android.CoreActivityIntentFactory
    @NotNull
    public Intent mainScreenWithTab(@NotNull TabFragmentFactory.Data data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intent intent = new Intent();
        intent.setClassName(this.a, "com.avito.android.Launcher");
        intent.setFlags(603979776);
        IntentsKt.putTabFragmentData(intent, data);
        return intent;
    }
}
