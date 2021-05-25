package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.MyTargetView;
public interface as {

    public interface a {
        void aa();

        void ah();

        void ai();

        void aj();

        void onClick();

        void onLoad();

        void onNoAd(@NonNull String str);
    }

    void a(@NonNull MyTargetView.AdSize adSize);

    void a(@Nullable a aVar);

    @Nullable
    String ad();

    float ae();

    void destroy();

    void pause();

    void prepare();

    void resume();

    void start();

    void stop();
}
