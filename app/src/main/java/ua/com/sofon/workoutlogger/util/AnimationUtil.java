/*
 * Copyright 2017 Dmitriy Ponomarenko, sofon.com.ua
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ua.com.sofon.workoutlogger.util;

import android.support.design.widget.FloatingActionButton;
import android.view.animation.AnimationUtils;

/**
 * Created on 14.06.2017.
 *
 * @author Dimowner
 */
public class AnimationUtil {

	private AnimationUtil() {}

	public static void fabRevealAnimation(FloatingActionButton fab) {
		fab.setAlpha(0f);
		fab.setScaleX(0f);
		fab.setScaleY(0f);
		fab.setTranslationY(fab.getHeight() / 2);
		fab.animate()
				.alpha(1f)
				.scaleX(1f)
				.scaleY(1f)
				.translationY(0f)
				.setDuration(350L)
				.setInterpolator(AnimationUtils.loadInterpolator(fab.getContext(),
						android.R.interpolator.accelerate_decelerate))
				.start();
	}
}
