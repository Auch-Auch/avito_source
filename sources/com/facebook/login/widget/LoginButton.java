package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.content.res.AppCompatResources;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.R;
import com.facebook.login.widget.ToolTipPopup;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class LoginButton extends FacebookButtonBase {
    public static final /* synthetic */ int v = 0;
    public boolean j;
    public String k;
    public String l;
    public b m = new b();
    public String n = AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE;
    public boolean o;
    public ToolTipPopup.Style p = ToolTipPopup.Style.BLUE;
    public ToolTipMode q;
    public long r = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    public ToolTipPopup s;
    public AccessTokenTracker t;
    public LoginManager u;

    @AutoHandleExceptions
    public class LoginClickListener implements View.OnClickListener {

        public class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ LoginManager a;

            public a(LoginClickListener loginClickListener, LoginManager loginManager) {
                this.a = loginManager;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.a.logOut();
            }
        }

        public LoginClickListener() {
        }

        public LoginManager getLoginManager() {
            LoginManager instance = LoginManager.getInstance();
            instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
            instance.setAuthType(LoginButton.this.getAuthType());
            return instance;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginButton loginButton = LoginButton.this;
            int i = LoginButton.v;
            loginButton.callExternalOnClickListener(view);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (AccessToken.isCurrentAccessTokenActive()) {
                performLogout(LoginButton.this.getContext());
            } else {
                performLogin();
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
            bundle.putInt("access_token_expired", AccessToken.isCurrentAccessTokenActive() ? 1 : 0);
            internalAppEventsLogger.logEventImplicitly(LoginButton.this.n, bundle);
        }

        public void performLogin() {
            LoginManager loginManager = getLoginManager();
            if (LoginButton.this.getFragment() != null) {
                loginManager.logIn(LoginButton.this.getFragment(), LoginButton.this.m.b);
            } else if (LoginButton.this.getNativeFragment() != null) {
                loginManager.logIn(LoginButton.this.getNativeFragment(), LoginButton.this.m.b);
            } else {
                LoginButton loginButton = LoginButton.this;
                int i = LoginButton.v;
                loginManager.logIn(loginButton.getActivity(), LoginButton.this.m.b);
            }
        }

        public void performLogout(Context context) {
            String str;
            LoginManager loginManager = getLoginManager();
            LoginButton loginButton = LoginButton.this;
            if (loginButton.j) {
                String string = loginButton.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                Profile currentProfile = Profile.getCurrentProfile();
                if (currentProfile == null || currentProfile.getName() == null) {
                    str = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                } else {
                    str = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), currentProfile.getName());
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(str).setCancelable(true).setPositiveButton(string, new a(this, loginManager)).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                builder.create().show();
                return;
            }
            loginManager.logOut();
        }
    }

    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static ToolTipMode DEFAULT;
        public String a;
        public int b;

        /* access modifiers changed from: public */
        static {
            ToolTipMode toolTipMode;
            DEFAULT = toolTipMode;
        }

        /* access modifiers changed from: public */
        ToolTipMode(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public static ToolTipMode fromInt(int i) {
            ToolTipMode[] values = values();
            for (int i2 = 0; i2 < 3; i2++) {
                ToolTipMode toolTipMode = values[i2];
                if (toolTipMode.getValue() == i) {
                    return toolTipMode;
                }
            }
            return null;
        }

        public int getValue() {
            return this.b;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.a;
        }
    }

    public class a extends AccessTokenTracker {
        public a() {
        }

        @Override // com.facebook.AccessTokenTracker
        public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
            LoginButton loginButton = LoginButton.this;
            int i = LoginButton.v;
            loginButton.c();
        }
    }

    public static class b {
        public DefaultAudience a = DefaultAudience.FRIENDS;
        public List<String> b = Collections.emptyList();
        public LoginBehavior c = LoginBehavior.NATIVE_WITH_FALLBACK;
        public String d = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    @AutoHandleExceptions
    public final void a(String str) {
        ToolTipPopup toolTipPopup = new ToolTipPopup(str, this);
        this.s = toolTipPopup;
        toolTipPopup.setStyle(this.p);
        this.s.setNuxDisplayTime(this.r);
        this.s.show();
    }

    @AutoHandleExceptions
    public final int b(String str) {
        return getCompoundPaddingRight() + getCompoundDrawablePadding() + getCompoundPaddingLeft() + measureTextWidth(str);
    }

    @AutoHandleExceptions
    public final void c() {
        Resources resources = getResources();
        if (isInEditMode() || !AccessToken.isCurrentAccessTokenActive()) {
            String str = this.k;
            if (str != null) {
                setText(str);
                return;
            }
            String string = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
            int width = getWidth();
            if (width != 0 && b(string) > width) {
                string = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
            setText(string);
            return;
        }
        String str2 = this.l;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setText(str2);
    }

    public void clearPermissions() {
        this.m.b = null;
    }

    /* JADX INFO: finally extract failed */
    @Override // com.facebook.FacebookButtonBase
    @AutoHandleExceptions
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getNewLoginClickListener());
        this.q = ToolTipMode.DEFAULT;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_login_view, i, i2);
        try {
            this.j = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
            this.k = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text);
            this.l = obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text);
            this.q = ToolTipMode.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, ToolTipMode.DEFAULT.getValue()));
            obtainStyledAttributes.recycle();
            if (isInEditMode()) {
                setBackgroundColor(getResources().getColor(com.facebook.common.R.color.com_facebook_blue));
                this.k = "Continue with Facebook";
            } else {
                this.t = new a();
            }
            c();
            setCompoundDrawablesWithIntrinsicBounds(AppCompatResources.getDrawable(getContext(), com.facebook.common.R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup = this.s;
        if (toolTipPopup != null) {
            toolTipPopup.dismiss();
            this.s = null;
        }
    }

    public String getAuthType() {
        return this.m.d;
    }

    public DefaultAudience getDefaultAudience() {
        return this.m.a;
    }

    @Override // com.facebook.FacebookButtonBase
    @AutoHandleExceptions
    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    @Override // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    public LoginBehavior getLoginBehavior() {
        return this.m.c;
    }

    public LoginManager getLoginManager() {
        if (this.u == null) {
            this.u = LoginManager.getInstance();
        }
        return this.u;
    }

    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    public List<String> getPermissions() {
        return this.m.b;
    }

    public long getToolTipDisplayTime() {
        return this.r;
    }

    public ToolTipMode getToolTipMode() {
        return this.q;
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    @AutoHandleExceptions
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessTokenTracker accessTokenTracker = this.t;
        if (accessTokenTracker != null && !accessTokenTracker.isTracking()) {
            this.t.startTracking();
            c();
        }
    }

    @Override // android.view.View
    @AutoHandleExceptions
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessTokenTracker accessTokenTracker = this.t;
        if (accessTokenTracker != null) {
            accessTokenTracker.stopTracking();
        }
        dismissToolTip();
    }

    @Override // com.facebook.FacebookButtonBase, android.widget.TextView, android.view.View
    @AutoHandleExceptions
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.o && !isInEditMode()) {
            this.o = true;
            int ordinal = this.q.ordinal();
            if (ordinal == 0) {
                FacebookSdk.getExecutor().execute(new a2.g.s.t.a(this, Utility.getMetadataApplicationId(getContext())));
            } else if (ordinal == 1) {
                a(getResources().getString(R.string.com_facebook_tooltip_default));
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    @AutoHandleExceptions
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        c();
    }

    @Override // android.widget.TextView, android.view.View
    @AutoHandleExceptions
    public void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top))));
        Resources resources = getResources();
        String str = this.k;
        if (str == null) {
            str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
            int b2 = b(str);
            if (Button.resolveSize(b2, i) < b2) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
        }
        int b3 = b(str);
        String str2 = this.l;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(Button.resolveSize(Math.max(b3, b(str2)), i), compoundPaddingBottom);
    }

    @Override // android.widget.TextView, android.view.View
    @AutoHandleExceptions
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            dismissToolTip();
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager, facebookCallback);
    }

    public void setAuthType(String str) {
        this.m.d = str;
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.m.a = defaultAudience;
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.m.c = loginBehavior;
    }

    public void setLoginManager(LoginManager loginManager) {
        this.u = loginManager;
    }

    public void setLoginText(String str) {
        this.k = str;
        c();
    }

    public void setLogoutText(String str) {
        this.l = str;
        c();
    }

    public void setPermissions(List<String> list) {
        this.m.b = list;
    }

    public void setProperties(b bVar) {
        this.m = bVar;
    }

    public void setPublishPermissions(List<String> list) {
        this.m.b = list;
    }

    public void setReadPermissions(List<String> list) {
        this.m.b = list;
    }

    public void setToolTipDisplayTime(long j2) {
        this.r = j2;
    }

    public void setToolTipMode(ToolTipMode toolTipMode) {
        this.q = toolTipMode;
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.p = style;
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        getLoginManager().unregisterCallback(callbackManager);
    }

    public void setPermissions(String... strArr) {
        this.m.b = Arrays.asList(strArr);
    }

    public void setPublishPermissions(String... strArr) {
        this.m.b = Arrays.asList(strArr);
    }

    public void setReadPermissions(String... strArr) {
        this.m.b = Arrays.asList(strArr);
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
    }
}
