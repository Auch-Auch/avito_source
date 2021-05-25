package com.avito.android.delivery.profile_settings;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Body;", AuthSource.SEND_ABUSE, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Body;", "getBody", "()Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Body;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Switch;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Switch;", "getSwitch", "()Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Switch;", "switch", "<init>", "(Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Body;Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Switch;Lcom/avito/android/remote/model/text/AttributedText;)V", "Body", "Switch", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryProfileSettings {
    @NotNull
    public final Body a;
    @NotNull
    public final Switch b;
    @Nullable
    public final AttributedText c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Body;", "", "Lcom/avito/android/remote/model/Image;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/text/AttributedText;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "()Lcom/avito/android/remote/model/text/AttributedText;", "text", "<init>", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/text/AttributedText;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Body {
        @NotNull
        public final Image a;
        @Nullable
        public final AttributedText b;

        public Body(@NotNull Image image, @Nullable AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.a = image;
            this.b = attributedText;
        }

        @NotNull
        public final Image getImage() {
            return this.a;
        }

        @Nullable
        public final AttributedText getText() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/delivery/profile_settings/DeliveryProfileSettings$Switch;", "", "", AuthSource.BOOKING_ORDER, "Z", "getValue", "()Z", "setValue", "(Z)V", "value", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;Z)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Switch {
        @NotNull
        public final String a;
        public boolean b;

        public Switch(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
            this.b = z;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public final boolean getValue() {
            return this.b;
        }

        public final void setValue(boolean z) {
            this.b = z;
        }
    }

    public DeliveryProfileSettings(@NotNull Body body, @NotNull Switch r3, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(body, SDKConstants.PARAM_A2U_BODY);
        Intrinsics.checkNotNullParameter(r3, "switch");
        this.a = body;
        this.b = r3;
        this.c = attributedText;
    }

    @NotNull
    public final Body getBody() {
        return this.a;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.c;
    }

    @NotNull
    public final Switch getSwitch() {
        return this.b;
    }
}
