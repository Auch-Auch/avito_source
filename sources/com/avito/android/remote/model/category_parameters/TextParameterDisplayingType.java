package com.avito.android.remote.model.category_parameters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface TextParameterDisplayingType {
    public static final String TYPE_DEFAULT = "default";
    public static final String TYPE_HTML_EDITOR = "htmlEditor";
    public static final String TYPE_VEHICLE_REG_NUMBER = "vehicleRegNumber";
}
