package com.avito.android.remote.parse.adapter;

import android.app.Application;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.search.R;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/parse/adapter/SearchDeviceResourcesProvider;", "", "", AuthSource.SEND_ABUSE, "Z", "isTablet", "()Z", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;)V", "search_release"}, k = 1, mv = {1, 4, 2})
public final class SearchDeviceResourcesProvider {
    public final boolean a;

    @Inject
    public SearchDeviceResourcesProvider(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        this.a = application.getResources().getBoolean(R.bool.is_tablet);
    }

    public final boolean isTablet() {
        return this.a;
    }
}
