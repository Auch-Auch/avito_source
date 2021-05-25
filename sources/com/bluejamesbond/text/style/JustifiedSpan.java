package com.bluejamesbond.text.style;
public class JustifiedSpan extends TextAlignmentSpan {
    @Override // com.bluejamesbond.text.style.TextAlignmentSpan
    public TextAlignment getTextAlignment() {
        return TextAlignment.JUSTIFIED;
    }
}
