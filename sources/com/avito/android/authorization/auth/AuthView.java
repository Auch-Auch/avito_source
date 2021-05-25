package com.avito.android.authorization.auth;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.social.button.SocialInfo;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001bH&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H&¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u0003H&¢\u0006\u0004\b\"\u0010\u000bJ#\u0010%\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\f2\b\u0010$\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/authorization/auth/AuthView;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "closeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "loginClicks", "registrationClicks", "Lcom/avito/android/deep_linking/links/DeepLink;", "linkClicks", "hideSocialButtons", "()V", "", "type", "Lcom/avito/android/social/button/SocialInfo;", "info", "addSocialButton", "(Ljava/lang/String;Lcom/avito/android/social/button/SocialInfo;)Lio/reactivex/rxjava3/core/Observable;", "enableSocialButtons", "disableSocialButtons", "showProgress", "showContent", "showScreenProgress", "hideScreenProgress", "error", "showError", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "setServiceAgreementText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "generateServiceAgreementAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "close", "show", "title", "message", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface AuthView {
    @NotNull
    Observable<String> addSocialButton(@NotNull String str, @NotNull SocialInfo socialInfo);

    void close();

    @NotNull
    Observable<Unit> closeClicks();

    void disableSocialButtons();

    void enableSocialButtons();

    @NotNull
    AttributedText generateServiceAgreementAttributedText();

    void hideScreenProgress();

    void hideSocialButtons();

    @NotNull
    Observable<DeepLink> linkClicks();

    @NotNull
    Observable<Unit> loginClicks();

    @NotNull
    Observable<Unit> registrationClicks();

    void setServiceAgreementText(@NotNull AttributedText attributedText);

    void show();

    void showContent();

    void showError(@NotNull String str);

    void showErrorDialog(@Nullable String str, @Nullable String str2);

    void showProgress();

    void showScreenProgress();
}
