package ru.ok.android.sdk;
public class OkAppSuggestActivity extends OkAppInviteActivity {
    @Override // ru.ok.android.sdk.OkAppInviteActivity
    public int getActivityView() {
        return R.layout.ok_app_suggest_activity;
    }

    @Override // ru.ok.android.sdk.OkAppInviteActivity, ru.ok.android.sdk.AbstractWidgetActivity
    public int getCancelledMessageId() {
        return R.string.suggest_canceled;
    }

    @Override // ru.ok.android.sdk.OkAppInviteActivity, ru.ok.android.sdk.AbstractWidgetActivity
    public String getWidgetId() {
        return "WidgetSuggest";
    }
}
