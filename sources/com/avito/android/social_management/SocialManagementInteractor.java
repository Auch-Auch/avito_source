package com.avito.android.social_management;

import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.social.AppleSignInManagerKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/social_management/SocialManagementInteractor;", "", "Lio/reactivex/Observable;", "Lcom/avito/android/social_management/SocialManagementContent;", "loadSocialNetworks", "()Lio/reactivex/Observable;", "", "type", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "", "Lcom/avito/android/remote/model/social/SocialNetwork;", "addSocialNetwork", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "removeSocialNetwork", "(Ljava/lang/String;)Lio/reactivex/Observable;", "id", "Lio/reactivex/Completable;", "removeNotification", "(Ljava/lang/String;)Lio/reactivex/Completable;", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public interface SocialManagementInteractor {
    @NotNull
    Observable<List<SocialNetwork>> addSocialNetwork(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<SocialManagementContent> loadSocialNetworks();

    @NotNull
    Completable removeNotification(@NotNull String str);

    @NotNull
    Observable<List<SocialNetwork>> removeSocialNetwork(@NotNull String str);
}
