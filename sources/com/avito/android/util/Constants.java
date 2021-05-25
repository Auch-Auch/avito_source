package com.avito.android.util;

import com.google.android.gms.stats.CodePackage;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b5\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u001c\u0010\u000b\u001a\u00020\n8\u0006@\u0007XT¢\u0006\f\n\u0004\b\u000b\u0010\f\u0012\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0017\u001a\u00020\n8\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0017\u0010\f\u0012\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u00020\n8\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0019\u0010\f\u0012\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001f\u0010\fR\u0016\u0010 \u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0016\u0010!\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\fR\u0016\u0010\"\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\fR\u0016\u0010#\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0016\u0010$\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\fR\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u0004R\u0016\u0010&\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u0004R\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u0004R\u0016\u0010(\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b(\u0010\u0004R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b)\u0010\u0004R\u0016\u0010*\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b*\u0010\u0004R\u0016\u0010+\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b+\u0010\u0004R\u0016\u0010,\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b,\u0010\u0004R\u0016\u0010-\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b-\u0010\u0004R\u0016\u0010.\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b.\u0010\u0004R\u0016\u0010/\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b/\u0010\u0004R\u0016\u00100\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b0\u0010\fR\u0016\u00101\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b1\u0010\u0004R\u0016\u00102\u001a\u00020\n8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b2\u0010\fR\u0016\u00103\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b3\u0010\u0004R\u0016\u00104\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b4\u0010\u0004¨\u00066"}, d2 = {"Lcom/avito/android/util/Constants;", "", "", "ITEM", "Ljava/lang/String;", "PHOTO_GALLERY_STATE_ID", "CONSULTATION_FORM", "ACTION_RESULT_MESSAGE", "SEARCH_PARAMS", "IMAGES", "", "REQ_SELL_FAST", "I", "getREQ_SELL_FAST$annotations", "()V", "LOCATION_NAMES", "RESULT_EDITED", "IMAGE_POSITION", "SUPPORTS_NESTED_INTENT", "DEFAULT_APPLICATION_ID", "DEFAULT_PAGE_SIZE", "SHOW_APP_RATER", "DEFAULT_ENCODING", "REQ_NO_INTERNET", "getREQ_NO_INTERNET$annotations", "REQ_ACTIVATE", "getREQ_ACTIVATE$annotations", "RESULT_OK", "", "NULL_LONG", "J", "RESULT_ADVERT_STOPPED", "LOC_HAS_DISTRICTS", "NULL_INT", "RESULT_CANCELED", "ITEM_CONTEXT", "RESULT_ADVERT_ACTIVATED", "ITEM_ID", CodePackage.LOCATION, "UP_INTENT", "LOCATION_ID", "IS_COMPANY", "LOC_HAS_DIRECTIONS", "NESTED_INTENT", "PHONE", "LOC_HAS_METRO", "PARENT_LOCATION_NAME", "AVITO_MOBILE_URL", "RESULT_ADVERT_RESTORED", "LOCATION_NAME", "RESULT_ADVERT_REMOVED", "MANAGER", "PARENT_LOCATION_ID", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
public final class Constants {
    @NotNull
    public static final String ACTION_RESULT_MESSAGE = "action_result_message";
    @NotNull
    public static final String AVITO_MOBILE_URL = "http://m.avito.ru";
    @NotNull
    public static final String CONSULTATION_FORM = "consultation_form";
    @NotNull
    public static final String DEFAULT_APPLICATION_ID = "com.avito.android";
    @NotNull
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final int DEFAULT_PAGE_SIZE = 30;
    @NotNull
    public static final String IMAGES = "images";
    @NotNull
    public static final String IMAGE_POSITION = "image_position";
    @NotNull
    public static final Constants INSTANCE = new Constants();
    @NotNull
    public static final String IS_COMPANY = "is_company";
    @NotNull
    public static final String ITEM = "item";
    @NotNull
    public static final String ITEM_CONTEXT = "context";
    @NotNull
    public static final String ITEM_ID = "itemId";
    @NotNull
    public static final String LOCATION = "location";
    @NotNull
    public static final String LOCATION_ID = "locationId";
    @NotNull
    public static final String LOCATION_NAME = "locationName";
    @NotNull
    public static final String LOCATION_NAMES = "location_names";
    @NotNull
    public static final String LOC_HAS_DIRECTIONS = "locationHasDirections";
    @NotNull
    public static final String LOC_HAS_DISTRICTS = "locationHasDistrics";
    @NotNull
    public static final String LOC_HAS_METRO = "locationHasMetro";
    @NotNull
    public static final String MANAGER = "manager";
    @NotNull
    public static final String NESTED_INTENT = "nested_intent";
    public static final int NULL_INT = -1;
    public static final long NULL_LONG = -1;
    @NotNull
    public static final String PARENT_LOCATION_ID = "parentLocationId";
    @NotNull
    public static final String PARENT_LOCATION_NAME = "parentLocationName";
    @NotNull
    public static final String PHONE = "phone";
    @NotNull
    public static final String PHOTO_GALLERY_STATE_ID = "photoGalleryStateId";
    public static final int REQ_ACTIVATE = 16;
    public static final int REQ_NO_INTERNET = 11;
    public static final int REQ_SELL_FAST = 13;
    public static final int RESULT_ADVERT_ACTIVATED = 7;
    public static final int RESULT_ADVERT_REMOVED = 8;
    public static final int RESULT_ADVERT_RESTORED = 10;
    public static final int RESULT_ADVERT_STOPPED = 6;
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_EDITED = 9;
    public static final int RESULT_OK = -1;
    @NotNull
    public static final String SEARCH_PARAMS = "search_params";
    @NotNull
    public static final String SHOW_APP_RATER = "show_app_rater";
    @NotNull
    public static final String SUPPORTS_NESTED_INTENT = "supports_nested_intent";
    @NotNull
    public static final String UP_INTENT = "up_intent";

    @Deprecated(message = "")
    public static /* synthetic */ void getREQ_ACTIVATE$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getREQ_NO_INTERNET$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getREQ_SELL_FAST$annotations() {
    }
}
