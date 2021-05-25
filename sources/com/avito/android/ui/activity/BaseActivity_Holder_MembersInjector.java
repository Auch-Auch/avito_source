package com.avito.android.ui.activity;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.grafana.GraphitePrefix;
import com.avito.android.lib.util.DarkThemeConfig;
import com.avito.android.ui.activity.BaseActivity;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class BaseActivity_Holder_MembersInjector implements MembersInjector<BaseActivity.Holder> {
    public final Provider<Analytics> a;
    public final Provider<Features> b;
    public final Provider<DarkThemeConfig> c;
    public final Provider<GraphitePrefix> d;

    public BaseActivity_Holder_MembersInjector(Provider<Analytics> provider, Provider<Features> provider2, Provider<DarkThemeConfig> provider3, Provider<GraphitePrefix> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<BaseActivity.Holder> create(Provider<Analytics> provider, Provider<Features> provider2, Provider<DarkThemeConfig> provider3, Provider<GraphitePrefix> provider4) {
        return new BaseActivity_Holder_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.ui.activity.BaseActivity.Holder.analytics")
    public static void injectAnalytics(BaseActivity.Holder holder, Analytics analytics) {
        holder.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.ui.activity.BaseActivity.Holder.darkThemeConfig")
    public static void injectDarkThemeConfig(BaseActivity.Holder holder, DarkThemeConfig darkThemeConfig) {
        holder.darkThemeConfig = darkThemeConfig;
    }

    @InjectedFieldSignature("com.avito.android.ui.activity.BaseActivity.Holder.features")
    public static void injectFeatures(BaseActivity.Holder holder, Features features) {
        holder.features = features;
    }

    @InjectedFieldSignature("com.avito.android.ui.activity.BaseActivity.Holder.prefix")
    public static void injectPrefix(BaseActivity.Holder holder, GraphitePrefix graphitePrefix) {
        holder.prefix = graphitePrefix;
    }

    public void injectMembers(BaseActivity.Holder holder) {
        injectAnalytics(holder, this.a.get());
        injectFeatures(holder, this.b.get());
        injectDarkThemeConfig(holder, this.c.get());
        injectPrefix(holder, this.d.get());
    }
}
