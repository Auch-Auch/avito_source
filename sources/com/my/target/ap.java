package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.Reward;
public interface ap {

    public interface a {
        void onClick();

        void onDismiss();

        void onDisplay();

        void onLoad();

        void onNoAd(@NonNull String str);

        void onVideoCompleted();
    }

    public interface b {
        void onReward(@NonNull Reward reward);
    }

    void a(@Nullable b bVar);

    @Nullable
    String ad();

    float ae();

    void destroy();

    void dismiss();

    void o(@NonNull Context context);
}
