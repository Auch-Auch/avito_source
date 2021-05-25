package ru.avito.component.floating_add_advert;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
public @interface AdvertShortcutType {
    public static final String AUTO = "transport";
    public static final String GENERAL = "general";
    public static final String JOB = "rabota";
    public static final String REALTY = "nedvizhimost";
    public static final String SERVICES = "uslugi";
}
