package com.avito.android.user_advert.di;

import android.content.res.Resources;
import com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BaseAdvertDetailsModule_MyAdvertDetailsActionMenuConverterFactory implements Factory<MyAdvertDetailsActionMenuConverter> {
    public final Provider<Resources> a;

    public BaseAdvertDetailsModule_MyAdvertDetailsActionMenuConverterFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static BaseAdvertDetailsModule_MyAdvertDetailsActionMenuConverterFactory create(Provider<Resources> provider) {
        return new BaseAdvertDetailsModule_MyAdvertDetailsActionMenuConverterFactory(provider);
    }

    public static MyAdvertDetailsActionMenuConverter myAdvertDetailsActionMenuConverter(Resources resources) {
        return (MyAdvertDetailsActionMenuConverter) Preconditions.checkNotNullFromProvides(BaseAdvertDetailsModule.myAdvertDetailsActionMenuConverter(resources));
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsActionMenuConverter get() {
        return myAdvertDetailsActionMenuConverter(this.a.get());
    }
}
