package com.warkiz.widget;
public class SeekParams {
    public boolean fromUser;
    public int progress;
    public float progressFloat;
    public IndicatorSeekBar seekBar;
    public int thumbPosition;
    public String tickText;

    public SeekParams(IndicatorSeekBar indicatorSeekBar) {
        this.seekBar = indicatorSeekBar;
    }
}
