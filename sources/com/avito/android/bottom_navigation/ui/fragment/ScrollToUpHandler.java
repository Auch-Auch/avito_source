package com.avito.android.bottom_navigation.ui.fragment;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "", "", "scrollToUp", "()V", HttpHeaders.HOST, "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface ScrollToUpHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler$Host;", "", "Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;", "handler", "", "setScrollToUpHandler", "(Lcom/avito/android/bottom_navigation/ui/fragment/ScrollToUpHandler;)V", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
    public interface Host {
        void setScrollToUpHandler(@Nullable ScrollToUpHandler scrollToUpHandler);
    }

    void scrollToUp();
}
