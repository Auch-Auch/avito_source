package com.avito.android.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/util/RequestCode;", "", "<init>", "()V", "Companion", "permissions_release"}, k = 1, mv = {1, 4, 2})
@Deprecated(message = "Use local request codes instead")
@Retention(RetentionPolicy.SOURCE)
public @interface RequestCode {
    public static final int ACTIVATE = 16;
    public static final int ADD_PHONE = 19;
    public static final int ADVERTS_LIST = 9;
    public static final int ADVERT_DETAILS = 8;
    public static final int AUTHENTICATE = 17;
    public static final int CLARIFY_SEARCH = 3;
    @NotNull
    public static final Companion Companion = Companion.a;
    public static final int FEES = 22;
    public static final int LOCATION_SETTINGS = 2;
    public static final int NEW_ADVERT = 21;
    public static final int NO_INTERNET = 11;
    public static final int PASSWORD = 7;
    public static final int PAYMENT = 15;
    public static final int PHONE_LIST = 20;
    public static final int PHONE_VERIFICATION = 18;
    public static final int PHOTO_GALLERY = 4;
    public static final int REGISTERED = 10;
    public static final int SELECT_LOCATION = 1;
    public static final int SELL_FAST = 13;
    public static final int WHATS_NEW = 14;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/util/RequestCode$Companion;", "", "", "WHATS_NEW", "I", "ADVERT_DETAILS", "ADVERTS_LIST", "PHONE_LIST", "AUTHENTICATE", "SELL_FAST", "NO_INTERNET", "ADD_PHONE", "PHOTO_GALLERY", "SELECT_LOCATION", "PASSWORD", "PHONE_VERIFICATION", "CLARIFY_SEARCH", "NEW_ADVERT", "FEES", "PAYMENT", "LOCATION_SETTINGS", "ACTIVATE", "REGISTERED", "<init>", "()V", "permissions_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final int ACTIVATE = 16;
        public static final int ADD_PHONE = 19;
        public static final int ADVERTS_LIST = 9;
        public static final int ADVERT_DETAILS = 8;
        public static final int AUTHENTICATE = 17;
        public static final int CLARIFY_SEARCH = 3;
        public static final int FEES = 22;
        public static final int LOCATION_SETTINGS = 2;
        public static final int NEW_ADVERT = 21;
        public static final int NO_INTERNET = 11;
        public static final int PASSWORD = 7;
        public static final int PAYMENT = 15;
        public static final int PHONE_LIST = 20;
        public static final int PHONE_VERIFICATION = 18;
        public static final int PHOTO_GALLERY = 4;
        public static final int REGISTERED = 10;
        public static final int SELECT_LOCATION = 1;
        public static final int SELL_FAST = 13;
        public static final int WHATS_NEW = 14;
        public static final /* synthetic */ Companion a = new Companion();
    }
}
