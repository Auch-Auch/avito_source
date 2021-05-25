package com.avito.android.extended_profile;

import a2.g.r.g;
import android.os.Parcelable;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "", "<init>", "()V", "AdvertDetailsOpenEvent", "AuthEvent", "BackClickedEvent", "CallEvent", "DeepLinkEvent", "GalleryOpenEvent", "ShareClickEvent", "ShareMenuVisibleEvent", "ShowSnackbarEvent", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$GalleryOpenEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShowSnackbarEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$DeepLinkEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShareClickEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$BackClickedEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$CallEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AuthEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShareMenuVisibleEvent;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class ExtendedProfileViewSingleLiveEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b \u0010!R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AdvertDetailsOpenEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", "d", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "price", AuthSource.BOOKING_ORDER, "getContext", "context", AuthSource.SEND_ABUSE, "getItemId", "itemId", "e", "getOldPrice", "oldPrice", "c", "getTitle", "title", "", g.a, "Ljava/lang/Integer;", "getGalleryPosition", "()Ljava/lang/Integer;", "galleryPosition", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertDetailsOpenEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final String a;
        @Nullable
        public final String b;
        @NotNull
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @Nullable
        public final Image f;
        @Nullable
        public final Integer g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertDetailsOpenEvent(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, @Nullable Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(str3, "title");
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = image;
            this.g = num;
        }

        @Nullable
        public final String getContext() {
            return this.b;
        }

        @Nullable
        public final Integer getGalleryPosition() {
            return this.g;
        }

        @Nullable
        public final Image getImage() {
            return this.f;
        }

        @NotNull
        public final String getItemId() {
            return this.a;
        }

        @Nullable
        public final String getOldPrice() {
            return this.e;
        }

        @Nullable
        public final String getPrice() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$AuthEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "Landroid/os/Parcelable;", AuthSource.BOOKING_ORDER, "Landroid/os/Parcelable;", "getSuccessAuthData", "()Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "source", "<init>", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthEvent extends ExtendedProfileViewSingleLiveEvent {
        @Nullable
        public final String a;
        @Nullable
        public final Parcelable b;

        public AuthEvent() {
            this(null, null, 3, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AuthEvent(String str, Parcelable parcelable, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : parcelable);
        }

        @Nullable
        public final String getSource() {
            return this.a;
        }

        @Nullable
        public final Parcelable getSuccessAuthData() {
            return this.b;
        }

        public AuthEvent(@Nullable String str, @Nullable Parcelable parcelable) {
            super(null);
            this.a = str;
            this.b = parcelable;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$BackClickedEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "<init>", "()V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class BackClickedEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public static final BackClickedEvent INSTANCE = new BackClickedEvent();

        public BackClickedEvent() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$CallEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class CallEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final PhoneLink.Call a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CallEvent(@NotNull PhoneLink.Call call) {
            super(null);
            Intrinsics.checkNotNullParameter(call, "deepLink");
            this.a = call;
        }

        @NotNull
        public final PhoneLink.Call getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$DeepLinkEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeepLinkEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeepLinkEvent(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$GalleryOpenEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "", "Lcom/avito/android/remote/model/Image;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", "<init>", "(Ljava/util/List;I)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class GalleryOpenEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final List<Image> a;
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GalleryOpenEvent(@NotNull List<Image> list, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "images");
            this.a = list;
            this.b = i;
        }

        @NotNull
        public final List<Image> getImages() {
            return this.a;
        }

        public final int getPosition() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShareClickEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.BOOKING_ORDER, "getText", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShareClickEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShareClickEvent(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getText() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShareMenuVisibleEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "", AuthSource.SEND_ABUSE, "Z", "isVisible", "()Z", "<init>", "(Z)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShareMenuVisibleEvent extends ExtendedProfileViewSingleLiveEvent {
        public final boolean a;

        public ShareMenuVisibleEvent(boolean z) {
            super(null);
            this.a = z;
        }

        public final boolean isVisible() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent$ShowSnackbarEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShowSnackbarEvent extends ExtendedProfileViewSingleLiveEvent {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShowSnackbarEvent(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    public ExtendedProfileViewSingleLiveEvent() {
    }

    public ExtendedProfileViewSingleLiveEvent(j jVar) {
    }
}
