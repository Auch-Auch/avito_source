package com.facebook.appevents.codeless;

import a2.g.k.x.d;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
@AutoHandleExceptions
public class RCTCodelessLoggingEventListener {

    public static class AutoLoggingOnTouchListener implements View.OnTouchListener {
        public EventBinding a;
        public WeakReference<View> b;
        public WeakReference<View> c;
        @Nullable
        public View.OnTouchListener d;
        public boolean e = false;

        public AutoLoggingOnTouchListener(EventBinding eventBinding, View view, View view2) {
            if (eventBinding != null && view != null && view2 != null) {
                this.d = ViewHierarchy.getExistingOnTouchListener(view2);
                this.a = eventBinding;
                this.b = new WeakReference<>(view2);
                this.c = new WeakReference<>(view);
                this.e = true;
            }
        }

        public boolean getSupportCodelessLogging() {
            return this.e;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            EventBinding eventBinding;
            if (motionEvent.getAction() == 1 && (eventBinding = this.a) != null) {
                String eventName = eventBinding.getEventName();
                Bundle b2 = CodelessMatcher.b(this.a, this.c.get(), this.b.get());
                if (b2.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
                    b2.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(b2.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
                }
                b2.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
                FacebookSdk.getExecutor().execute(new d(this, eventName, b2));
            }
            View.OnTouchListener onTouchListener = this.d;
            if (onTouchListener == null || !onTouchListener.onTouch(view, motionEvent)) {
                return false;
            }
            return true;
        }
    }

    public static AutoLoggingOnTouchListener getOnTouchListener(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingOnTouchListener(eventBinding, view, view2);
    }
}
