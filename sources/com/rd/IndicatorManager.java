package com.rd;

import androidx.annotation.Nullable;
import com.rd.animation.AnimationManager;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.Value;
import com.rd.draw.DrawManager;
import com.rd.draw.data.Indicator;
public class IndicatorManager implements ValueController.UpdateListener {
    public DrawManager a;
    public AnimationManager b;
    public a c;

    public interface a {
        void onIndicatorUpdated();
    }

    public IndicatorManager(@Nullable a aVar) {
        this.c = aVar;
        DrawManager drawManager = new DrawManager();
        this.a = drawManager;
        this.b = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return this.b;
    }

    public DrawManager drawer() {
        return this.a;
    }

    public Indicator indicator() {
        return this.a.indicator();
    }

    @Override // com.rd.animation.controller.ValueController.UpdateListener
    public void onValueUpdated(@Nullable Value value) {
        this.a.updateValue(value);
        a aVar = this.c;
        if (aVar != null) {
            aVar.onIndicatorUpdated();
        }
    }
}
