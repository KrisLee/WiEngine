/*
 * Copyright (c) 2010 WiYun Inc.
 * Author: luma(stubma@gmail.com)
 *
 * For all entities this program is free software; you can redistribute
 * it and/or modify it under the terms of the 'WiEngine' license with
 * the additional provision that 'WiEngine' must be credited in a manner
 * that can be be observed by end users, for example, in the credits or during
 * start up. (please find WiEngine logo in sdk's logo folder)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.wiyun.engine.tests.node;

import android.graphics.Typeface;

import com.wiyun.engine.WiEngineTestActivity;
import com.wiyun.engine.nodes.Director;
import com.wiyun.engine.nodes.Label;
import com.wiyun.engine.nodes.Layer;
import com.wiyun.engine.opengl.Texture2D;
import com.wiyun.engine.types.WYSize;

public class LabelTest extends WiEngineTestActivity {
	@Override
	protected Layer createLayer() {
		return new MyLayer();
	}
    
    class MyLayer extends Layer {
    	public MyLayer() {
            // add labels
            WYSize s = Director.getInstance().getWindowSize();
            float y = s.height - 30;
            float x = s.width / 2;
            float line = 50;
            Label label = Label.make("DroidSans 12", 12, Typeface.BOLD);
            label.setPosition(x, y);
            y -= line;
            addChild(label);
            label = Label.make("DroidSans 16", 16, Typeface.ITALIC);
            label.setPosition(x, y);
            y -= line * 5;
            addChild(label);
            label = Label.make("多行标签，可以指定一个宽度，字符串超过宽度时会折行，hello world，中英文混排", 24, Typeface.BOLD_ITALIC, "DroidSans", s.width / 2);
            label.setPosition(x, y);
            y -= line * 5;
            addChild(label);
            label = Label.make("Custom Font 36\nTest\nAlign Right", 36, "samplefont.ttf", false, 0, Texture2D.RIGHT);
            label.setPosition(x, y);
            y -= line;
            addChild(label);
		}
    }
}
