package com.avito.android.util.preferences;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface Preference {
    public static final String APP_VERSION = "app_version";
    public static final String FAVORITES_LAST_UPDATE_DATE = "favorites_update_date";
    public static final String GCM_TOKEN = "gcm_token";
    public static final String HMS_TOKEN = "hms_token";
    public static final String LAST_APP_VERSION_RUN = "last_app_version_run";
    public static final String LAST_LOGGED_EMAIL = "last_logged_email";
    public static final String LAST_LOGGED_USER_ID = "last_logged_user_id";
    public static final String LOCATION_ID = "location_id";
    public static final String LOCATION_JSON = "location_json";
    public static final String LOCATION_NAME = "location_name";
    public static final String LOCATION_VERSION = "location_action";
    @Deprecated
    public static final String PASSWORD = "password";
    public static final String SCHEME_VERSION = "scheme_version";
    @Deprecated
    public static final String USERNAME = "username";
}
