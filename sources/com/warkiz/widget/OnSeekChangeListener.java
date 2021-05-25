package com.warkiz.widget;
public interface OnSeekChangeListener {
    void onSeeking(SeekParams seekParams);

    void onStartTrackingTouch(IndicatorSeekBar indicatorSeekBar);

    void onStopTrackingTouch(IndicatorSeekBar indicatorSeekBar);
}
