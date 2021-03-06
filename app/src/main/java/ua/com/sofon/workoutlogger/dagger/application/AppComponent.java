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

package ua.com.sofon.workoutlogger.dagger.application;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.sofon.workoutlogger.dagger.exercises.ExerciseDetailsModule;
import ua.com.sofon.workoutlogger.dagger.exercises.ExerciseDetailsComponent;
import ua.com.sofon.workoutlogger.dagger.exercises.ExerciseEditComponent;
import ua.com.sofon.workoutlogger.dagger.exercises.ExerciseEditModule;
import ua.com.sofon.workoutlogger.dagger.exercises.ExercisesComponent;
import ua.com.sofon.workoutlogger.dagger.exercises.ExercisesModule;
import ua.com.sofon.workoutlogger.dagger.main.MainComponent;
import ua.com.sofon.workoutlogger.dagger.main.MainModule;

/**
 * Created on 08.03.2017.
 * @author Dimowner
 */
@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

	MainComponent plus(MainModule mainModule);
	ExercisesComponent plus(ExercisesModule exerciseModule);
	ExerciseEditComponent plus(ExerciseEditModule exerciseEditModule);
	ExerciseDetailsComponent plus(ExerciseDetailsModule exerciseDetailsModule);
}
