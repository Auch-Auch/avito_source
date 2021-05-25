package com.avito.android.social_management;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.social.SocialNotification;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/avito/android/social_management/SocialManagementContent;", "", "", "Lcom/avito/android/remote/model/social/SocialNotification;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "notifications", "Lcom/avito/android/remote/model/social/SocialNetwork;", AuthSource.SEND_ABUSE, "getSocialNetworks", "socialNetworks", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementContent {
    @NotNull
    public final List<SocialNetwork> a;
    @NotNull
    public final List<SocialNotification> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.social.SocialNetwork> */
    /* JADX WARN: Multi-variable type inference failed */
    public SocialManagementContent(@NotNull List<? extends SocialNetwork> list, @NotNull List<SocialNotification> list2) {
        Intrinsics.checkNotNullParameter(list, "socialNetworks");
        Intrinsics.checkNotNullParameter(list2, "notifications");
        this.a = list;
        this.b = list2;
    }

    @NotNull
    public final List<SocialNotification> getNotifications() {
        return this.b;
    }

    @NotNull
    public final List<SocialNetwork> getSocialNetworks() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocialManagementContent(List list, List list2, int i, j jVar) {
        this(list, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }
}
