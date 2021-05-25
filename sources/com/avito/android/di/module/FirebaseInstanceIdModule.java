package com.avito.android.di.module;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/FirebaseInstanceIdModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/google/firebase/iid/FirebaseInstanceId;", "provideFirebaseInstanceId", "(Landroid/app/Application;)Lcom/google/firebase/iid/FirebaseInstanceId;", "<init>", "()V", "analytics_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class FirebaseInstanceIdModule {
    @Provides
    @NotNull
    public final FirebaseInstanceId provideFirebaseInstanceId(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        FirebaseApp initializeApp = FirebaseApp.initializeApp(application);
        Intrinsics.checkNotNull(initializeApp);
        Intrinsics.checkNotNullExpressionValue(initializeApp, "FirebaseApp.initializeApp(application)!!");
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance(initializeApp);
        Intrinsics.checkNotNullExpressionValue(instance, "FirebaseInstanceId.getInstance(firebaseApp)");
        return instance;
    }
}
