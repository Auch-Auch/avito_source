package ru.avito.component.floating_add_advert;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0019"}, d2 = {"Lru/avito/component/floating_add_advert/AdvertShortcut;", "", "Lcom/avito/android/remote/model/Navigation;", "d", "Lcom/avito/android/remote/model/Navigation;", "getNavigation", "()Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getType", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/Navigation;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertShortcut {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final DeepLink c;
    @NotNull
    public final Navigation d;

    public AdvertShortcut(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink, @NotNull Navigation navigation) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "type");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        this.a = str;
        this.b = str2;
        this.c = deepLink;
        this.d = navigation;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.c;
    }

    @NotNull
    public final Navigation getNavigation() {
        return this.d;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @NotNull
    public final String getType() {
        return this.b;
    }
}
