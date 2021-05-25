package com.avito.android.advert_core.short_term_rent;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B+\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock;", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Switcher;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Switcher;", "getOnlineBookingField", "()Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Switcher;", "onlineBookingField", "", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Parameter;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getParameters", "()Ljava/util/List;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/Action;", "c", "Lcom/avito/android/remote/model/Action;", "getManageCalendarButtonAction", "()Lcom/avito/android/remote/model/Action;", "manageCalendarButtonAction", "<init>", "(Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Switcher;Ljava/util/List;Lcom/avito/android/remote/model/Action;)V", "Parameter", "Switcher", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertStrBlock {
    @Nullable
    public final Switcher a;
    @Nullable
    public final List<Parameter> b;
    @Nullable
    public final Action c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Parameter;", "", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", AuthSource.SEND_ABUSE, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parameter {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        public Parameter(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            this.a = str;
            this.b = str2;
        }

        @NotNull
        public final String getDescription() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlock$Switcher;", "", "", "c", "Ljava/lang/CharSequence;", "getDisclaimer", "()Ljava/lang/CharSequence;", "disclaimer", "", AuthSource.BOOKING_ORDER, "Z", "isEnabled", "()Z", "setEnabled", "(Z)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;ZLjava/lang/CharSequence;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Switcher {
        @NotNull
        public final String a;
        public boolean b;
        @Nullable
        public final CharSequence c;

        public Switcher(@NotNull String str, boolean z, @Nullable CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
            this.b = z;
            this.c = charSequence;
        }

        @Nullable
        public final CharSequence getDisclaimer() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public final boolean isEnabled() {
            return this.b;
        }

        public final void setEnabled(boolean z) {
            this.b = z;
        }
    }

    public AdvertStrBlock(@Nullable Switcher switcher, @Nullable List<Parameter> list, @Nullable Action action) {
        this.a = switcher;
        this.b = list;
        this.c = action;
    }

    @Nullable
    public final Action getManageCalendarButtonAction() {
        return this.c;
    }

    @Nullable
    public final Switcher getOnlineBookingField() {
        return this.a;
    }

    @Nullable
    public final List<Parameter> getParameters() {
        return this.b;
    }
}
