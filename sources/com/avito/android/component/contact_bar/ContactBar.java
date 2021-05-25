package com.avito.android.component.contact_bar;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002+,J1\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H&¢\u0006\u0004\b\u001f\u0010\u001aJ\u000f\u0010 \u001a\u00020\u0006H&¢\u0006\u0004\b \u0010\u001aJ!\u0010#\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015H&¢\u0006\u0004\b#\u0010$J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0015H&¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0015H&¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H&¢\u0006\u0004\b*\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/component/contact_bar/ContactBar;", "", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onClickListener", "setActions", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "name", "status", "setUserStatus", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "isOnline", "setOnline", "(Z)V", "show", "()V", "hide", "Lio/reactivex/rxjava3/core/Observable;", "statusContainerClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showStatusContainer", "hideStatusContainer", "visible", "immediately", "animateShowHide", "(ZZ)V", "isEnabled", "setEnabled", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "Action", "ActionType", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ContactBar {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 82\u00020\u0001:\u00018B]\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\n\b\u0001\u00103\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020)\u0012\u0006\u0010(\u001a\u00020!\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u00105\u001a\u00020!\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b6\u00107J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010 \u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010$\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010(\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u00105\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010#\u001a\u0004\b5\u0010%¨\u00069"}, d2 = {"Lcom/avito/android/component/contact_bar/ContactBar$Action;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/component/contact_bar/ContactBar$ActionType;", "f", "Lcom/avito/android/component/contact_bar/ContactBar$ActionType;", "getType", "()Lcom/avito/android/component/contact_bar/ContactBar$ActionType;", "type", "c", "I", "getIconTintColor", "iconTintColor", "Lcom/avito/android/remote/model/ParametrizedEvent;", "i", "Lcom/avito/android/remote/model/ParametrizedEvent;", "getLogEvent", "()Lcom/avito/android/remote/model/ParametrizedEvent;", "logEvent", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "", g.a, "Z", "isDisabled", "()Z", "e", "getNeedUnauthSendMessageAttemptEvent", "needUnauthSendMessageAttemptEvent", "Lcom/avito/android/deep_linking/links/DeepLink;", "d", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getIconDrawableId", "()Ljava/lang/Integer;", "iconDrawableId", "h", "isPrimary", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;ILcom/avito/android/deep_linking/links/DeepLink;ZLcom/avito/android/component/contact_bar/ContactBar$ActionType;ZZLcom/avito/android/remote/model/ParametrizedEvent;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Action> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;
        public final int c;
        @NotNull
        public final DeepLink d;
        public final boolean e;
        @NotNull
        public final ActionType f;
        public final boolean g;
        public final boolean h;
        @Nullable
        public final ParametrizedEvent i;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/component/contact_bar/ContactBar$Action$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Action> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Action invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
                Object readValue = parcel2.readValue(Integer.class.getClassLoader());
                if (!(readValue instanceof Integer)) {
                    readValue = null;
                }
                return new Action(u2, (Integer) readValue, parcel2.readInt(), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2), ParcelsKt.readBool(parcel2), (ActionType) ParcelsKt.readEnum(parcel2, ActionType.values()), ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2), (ParametrizedEvent) parcel2.readParcelable(ParametrizedEvent.class.getClassLoader()));
            }
        }

        public Action(@NotNull String str, @DrawableRes @Nullable Integer num, @ColorRes int i2, @NotNull DeepLink deepLink, boolean z, @NotNull ActionType actionType, boolean z2, boolean z3, @Nullable ParametrizedEvent parametrizedEvent) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            Intrinsics.checkNotNullParameter(actionType, "type");
            this.a = str;
            this.b = num;
            this.c = i2;
            this.d = deepLink;
            this.e = z;
            this.f = actionType;
            this.g = z2;
            this.h = z3;
            this.i = parametrizedEvent;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.d;
        }

        @Nullable
        public final Integer getIconDrawableId() {
            return this.b;
        }

        public final int getIconTintColor() {
            return this.c;
        }

        @Nullable
        public final ParametrizedEvent getLogEvent() {
            return this.i;
        }

        public final boolean getNeedUnauthSendMessageAttemptEvent() {
            return this.e;
        }

        @NotNull
        public final String getText() {
            return this.a;
        }

        @NotNull
        public final ActionType getType() {
            return this.f;
        }

        public final boolean isDisabled() {
            return this.g;
        }

        public final boolean isPrimary() {
            return this.h;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i2) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeValue(this.b);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.d, i2);
            ParcelsKt.writeBool(parcel, this.e);
            ParcelsKt.writeEnum(parcel, this.f);
            ParcelsKt.writeBool(parcel, this.g);
            ParcelsKt.writeBool(parcel, this.h);
            parcel.writeParcelable(this.i, i2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Action(String str, Integer num, int i2, DeepLink deepLink, boolean z, ActionType actionType, boolean z2, boolean z3, ParametrizedEvent parametrizedEvent, int i3, j jVar) {
            this(str, num, i2, deepLink, z, actionType, (i3 & 64) != 0 ? false : z2, (i3 & 128) != 0 ? false : z3, (i3 & 256) != 0 ? null : parametrizedEvent);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/component/contact_bar/ContactBar$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "PHONE", "MESSENGER", "ACCESS", "TEASER", "BUY", "CART", "TRADE", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public enum ActionType {
        PHONE,
        MESSENGER,
        ACCESS,
        TEASER,
        BUY,
        CART,
        TRADE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void animateShowHide$default(ContactBar contactBar, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = false;
                }
                contactBar.animateShowHide(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateShowHide");
        }
    }

    void animateShowHide(boolean z, boolean z2);

    int getButtonsTop();

    int getButtonsVisibilityPercents();

    void hide();

    void hide(boolean z);

    void hideStatusContainer();

    void setActions(@NotNull List<Action> list, @NotNull Function1<? super Action, Unit> function1);

    void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType);

    void setEnabled(boolean z);

    void setOnline(boolean z);

    void setUserStatus(@NotNull CharSequence charSequence, @Nullable CharSequence charSequence2);

    void show();

    void showStatusContainer();

    @NotNull
    Observable<Unit> statusContainerClicks();
}
