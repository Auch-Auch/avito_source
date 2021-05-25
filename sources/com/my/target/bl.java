package com.my.target;

import androidx.annotation.NonNull;
import com.avito.android.remote.model.category_parameters.MultiselectParameterKt;
import com.yandex.mobile.ads.video.tracking.Tracker;
public class bl {
    @NonNull
    public final String a;
    public final boolean da;

    public bl(@NonNull String str, @NonNull String str2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1910759310:
                if (str.equals("vpaidInit")) {
                    c = 0;
                    break;
                }
                break;
            case -1886160473:
                if (str.equals("playVideo")) {
                    c = 1;
                    break;
                }
                break;
            case -1289167206:
                if (str.equals(Tracker.Events.CREATIVE_EXPAND)) {
                    c = 2;
                    break;
                }
                break;
            case -934437708:
                if (str.equals("resize")) {
                    c = 3;
                    break;
                }
                break;
            case -733616544:
                if (str.equals("createCalendarEvent")) {
                    c = 4;
                    break;
                }
                break;
            case 3417674:
                if (str.equals("open")) {
                    c = 5;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c = 6;
                    break;
                }
                break;
            case 133423073:
                if (str.equals("setOrientationProperties")) {
                    c = 7;
                    break;
                }
                break;
            case 459238621:
                if (str.equals("storePicture")) {
                    c = '\b';
                    break;
                }
                break;
            case 624734601:
                if (str.equals("setResizeProperties")) {
                    c = '\t';
                    break;
                }
                break;
            case 892543864:
                if (str.equals("vpaidEvent")) {
                    c = '\n';
                    break;
                }
                break;
            case 1797992422:
                if (str.equals("playheadEvent")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
            case 7:
            case '\t':
            case '\n':
            case 11:
                this.da = false;
                break;
            case 1:
            case 2:
                this.da = MultiselectParameterKt.DISPLAY_TYPE_INLINE.equals(str2);
                break;
            case 3:
            case 4:
            case 5:
            case '\b':
                this.da = true;
                break;
            default:
                this.da = false;
                str = "";
                break;
        }
        this.a = str;
    }

    public String toString() {
        return this.a;
    }
}
