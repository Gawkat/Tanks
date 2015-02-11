package com.github.gawkat.tanks.util;

import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
 * @author Gawkat
 *
 */
public class Styles {

	public static LabelStyle titleStyle, heading1Style, heading2Style,
			bodyStyle;
	public static TextButtonStyle titleButtonStyle, heading1ButtonStyle,
			heading2ButtonStyle, bodyButtonStyle;

	public static void createStyles() {
		// Label styles
		titleStyle = new LabelStyle();
		titleStyle.font = Fonts.titleFont;

		heading1Style = new LabelStyle();
		heading1Style.font = Fonts.heading1Font;

		heading2Style = new LabelStyle();
		heading2Style.font = Fonts.heading2Font;

		bodyStyle = new LabelStyle();
		bodyStyle.font = Fonts.bodyFont;

		// Button styles
		titleButtonStyle = new TextButtonStyle();
		titleButtonStyle.font = Fonts.titleFont;

		heading1ButtonStyle = new TextButtonStyle();
		heading1ButtonStyle.font = Fonts.heading1Font;

		heading2ButtonStyle = new TextButtonStyle();
		heading2ButtonStyle.font = Fonts.heading2Font;

		bodyButtonStyle = new TextButtonStyle();
		bodyButtonStyle.font = Fonts.bodyFont;
	}

}
