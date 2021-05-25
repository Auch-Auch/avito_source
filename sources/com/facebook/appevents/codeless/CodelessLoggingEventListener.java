package com.facebook.appevents.codeless;

import a2.g.k.x.a;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class CodelessLoggingEventListener {

    public static class AutoLoggingOnClickListener implements View.OnClickListener {
        public EventBinding a;
        public WeakReference<View> b;
        public WeakReference<View> c;
        @Nullable
        public View.OnClickListener d;
        public boolean e = false;

        public AutoLoggingOnClickListener(EventBinding eventBinding, View view, View view2, a aVar) {
            if (eventBinding != null && view != null && view2 != null) {
                this.d = ViewHierarchy.getExistingOnClickListener(view2);
                this.a = eventBinding;
                this.b = new WeakReference<>(view2);
                this.c = new WeakReference<>(view);
                this.e = true;
            }
        }

        public boolean getSupportCodelessLogging() {
            return this.e;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = this.d;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (this.c.get() != null && this.b.get() != null) {
                CodelessLoggingEventListener.a(this.a, this.c.get(), this.b.get());
            }
        }
    }

    public static class AutoLoggingOnItemClickListener implements AdapterView.OnItemClickListener {
        public EventBinding a;
        public WeakReference<AdapterView> b;
        public WeakReference<View> c;
        @Nullable
        public AdapterView.OnItemClickListener d;
        public boolean e = false;

        public AutoLoggingOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView, a aVar) {
            if (eventBinding != null && view != null && adapterView != null) {
                this.d = adapterView.getOnItemClickListener();
                this.a = eventBinding;
                this.b = new WeakReference<>(adapterView);
                this.c = new WeakReference<>(view);
                this.e = true;
            }
        }

        public boolean getSupportCodelessLogging() {
            return this.e;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AdapterView.OnItemClickListener onItemClickListener = this.d;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
            if (this.c.get() != null && this.b.get() != null) {
                CodelessLoggingEventListener.a(this.a, this.c.get(), this.b.get());
            }
        }
    }

    public static void a(EventBinding eventBinding, View view, View view2) {
        String eventName = eventBinding.getEventName();
        Bundle b = CodelessMatcher.b(eventBinding, view, view2);
        if (b.containsKey(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)) {
            b.putDouble(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, AppEventUtility.normalizePrice(b.getString(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM)));
        }
        b.putString(Constants.IS_CODELESS_EVENT_KEY, "1");
        FacebookSdk.getExecutor().execute(new a(eventName, b));
    }

    public static AutoLoggingOnClickListener getOnClickListener(EventBinding eventBinding, View view, View view2) {
        return new AutoLoggingOnClickListener(eventBinding, view, view2, null);
    }

    public static AutoLoggingOnItemClickListener getOnItemClickListener(EventBinding eventBinding, View view, AdapterView adapterView) {
        return new AutoLoggingOnItemClickListener(eventBinding, view, adapterView, null);
    }
}
