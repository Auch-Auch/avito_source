package com.yandex.runtime.model;

import a2.b.a.a.a;
import java.util.UUID;
public abstract class AnimatedModelProvider {
    public static AnimatedModelProvider fromAnimatedModel(final AnimatedModel animatedModel) {
        StringBuilder L = a.L("animation/model:");
        L.append(UUID.randomUUID().toString());
        final String sb = L.toString();
        return new AnimatedModelProvider() { // from class: com.yandex.runtime.model.AnimatedModelProvider.1
            @Override // com.yandex.runtime.model.AnimatedModelProvider
            public String getId() {
                return sb;
            }

            @Override // com.yandex.runtime.model.AnimatedModelProvider
            public AnimatedModel getModel() {
                return animatedModel;
            }
        };
    }

    public abstract String getId();

    public abstract AnimatedModel getModel();
}
