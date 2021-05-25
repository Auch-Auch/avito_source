package com.avito.android.messenger.map;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/map/OnLocationEnabledListener;", "", "", "onLocationEnabled", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OnLocationEnabledListener {
    @NotNull
    public static final Companion Companion = Companion.a;
    public static final int ENABLE_LOCATION_REQUEST_CODE = 69;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/map/OnLocationEnabledListener$Companion;", "", "", "ENABLE_LOCATION_REQUEST_CODE", "I", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final int ENABLE_LOCATION_REQUEST_CODE = 69;
        public static final /* synthetic */ Companion a = new Companion();
    }

    void onLocationEnabled();
}
