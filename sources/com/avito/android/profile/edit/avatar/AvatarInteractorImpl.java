package com.avito.android.profile.edit.avatar;

import a2.a.a.b2.e1.c0.c;
import a2.a.a.b2.e1.c0.d;
import a2.a.a.b2.e1.c0.e;
import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.photo_picker.BitmapTransformer;
import com.avito.android.photo_picker.legacy.api.UploadConverterProvider;
import com.avito.android.profile.edit.refactoring.avatar.ImageAvatar;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.profile.edit.refactoring.avatar.UriAvatar;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Avatar;
import com.avito.android.remote.model.AvatarStatus;
import com.avito.android.remote.model.Image;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b#\u0010$J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/profile/edit/avatar/AvatarInteractorImpl;", "Lcom/avito/android/profile/edit/avatar/AvatarInteractor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "Lio/reactivex/Observable;", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "wrapAvatar", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)Lio/reactivex/Observable;", "Lorg/funktionale/option/Option;", "loadAvatar", "()Lio/reactivex/Observable;", "avatar", "", "updateAvatar", "(Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;)Lio/reactivex/Observable;", "Ljava/io/File;", AuthSource.SEND_ABUSE, "(Landroid/net/Uri;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/photo_picker/BitmapTransformer;", "c", "Lcom/avito/android/photo_picker/BitmapTransformer;", "bitmapTransformer", "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;", "uploadConverterProvider", "<init>", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/photo_picker/legacy/api/UploadConverterProvider;Lcom/avito/android/photo_picker/BitmapTransformer;Lcom/avito/android/util/SchedulersFactory;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AvatarInteractorImpl implements AvatarInteractor {
    public final ProfileApi a;
    public final UploadConverterProvider b;
    public final BitmapTransformer c;
    public final SchedulersFactory d;

    public static final class a<T, R> implements Function<Avatar, Option<? extends ProfileAvatar>> {
        public final /* synthetic */ AvatarInteractorImpl a;

        public a(AvatarInteractorImpl avatarInteractorImpl) {
            this.a = avatarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Option<? extends ProfileAvatar> apply(Avatar avatar) {
            Avatar avatar2 = avatar;
            Intrinsics.checkNotNullParameter(avatar2, "it");
            return OptionKt.toOption(AvatarInteractorImpl.access$toProfileAvatar(this.a, avatar2));
        }
    }

    public static final class b<T, R> implements Function<Uri, ObservableSource<? extends ProfileAvatar>> {
        public final /* synthetic */ AvatarInteractorImpl a;

        public b(AvatarInteractorImpl avatarInteractorImpl) {
            this.a = avatarInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public ObservableSource<? extends ProfileAvatar> apply(Uri uri) {
            Uri uri2 = uri;
            Intrinsics.checkNotNullParameter(uri2, "result");
            return this.a.a(uri2).map(new e(uri2));
        }
    }

    public AvatarInteractorImpl(@NotNull ProfileApi profileApi, @NotNull UploadConverterProvider uploadConverterProvider, @NotNull BitmapTransformer bitmapTransformer, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(uploadConverterProvider, "uploadConverterProvider");
        Intrinsics.checkNotNullParameter(bitmapTransformer, "bitmapTransformer");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = profileApi;
        this.b = uploadConverterProvider;
        this.c = bitmapTransformer;
        this.d = schedulersFactory;
    }

    public static final ProfileAvatar access$toProfileAvatar(AvatarInteractorImpl avatarInteractorImpl, Avatar avatar) {
        Image image;
        Objects.requireNonNull(avatarInteractorImpl);
        String status = avatar.getStatus();
        if ((status.hashCode() == 1069449574 && status.equals(AvatarStatus.MISSING)) || (image = avatar.getImage()) == null) {
            return null;
        }
        return new ImageAvatar(image);
    }

    public final Observable<File> a(Uri uri) {
        return a2.b.a.a.a.S1(this.d, this.b.getUploadConverter("profile").convertUriToFile(uri), "uploadConverterProvider.…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<Option<ProfileAvatar>> loadAvatar() {
        Observable<Option<ProfileAvatar>> map = InteropKt.toV2(ProfileApi.DefaultImpls.getProfileAvatar$default(this.a, false, 1, null)).subscribeOn(this.d.io()).map(new a(this));
        Intrinsics.checkNotNullExpressionValue(map, "api.getProfileAvatar().t…fileAvatar().toOption() }");
        return map;
    }

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<Unit> updateAvatar(@Nullable ProfileAvatar profileAvatar) {
        Uri uri = null;
        if (profileAvatar != null) {
            if (!(profileAvatar instanceof UriAvatar)) {
                profileAvatar = null;
            }
            UriAvatar uriAvatar = (UriAvatar) profileAvatar;
            if (uriAvatar != null) {
                uri = uriAvatar.getUri();
            }
        }
        if (uri != null) {
            Observable<R> map = a(uri).map(a2.a.a.b2.e1.c0.b.a).flatMap(new c(this)).map(d.a);
            Intrinsics.checkNotNullExpressionValue(map, "convertAvatar(uri)\n     …            .map { Unit }");
            return map;
        }
        Observable<Unit> map2 = InteropKt.toV2(this.a.deleteAvatar()).subscribeOn(this.d.io()).map(a2.a.a.b2.e1.c0.a.a);
        Intrinsics.checkNotNullExpressionValue(map2, "api.deleteAvatar().toV2(…            .map { Unit }");
        return map2;
    }

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    public Observable<ProfileAvatar> wrapAvatar(@NotNull Uri uri, @Nullable Transformation transformation) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        return a2.b.a.a.a.S1(this.d, BitmapTransformer.DefaultImpls.transformBitmap$default(this.c, uri, transformation, 0, 4, null).flatMap(new b(this)), "bitmapTransformer\n      …scribeOn(schedulers.io())");
    }
}
