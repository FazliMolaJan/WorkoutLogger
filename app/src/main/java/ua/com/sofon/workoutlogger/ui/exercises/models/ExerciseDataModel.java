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

package ua.com.sofon.workoutlogger.ui.exercises.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import ua.com.sofon.workoutlogger.data.network.models.ExerciseModel;

/**
 * Created on 02.04.2017.
 * @author Dimowner
 */
public class ExerciseDataModel implements Parcelable {

	private long id;

	private int[] groups;

	private String name;

	private String description;

	private String imagePath;

	private String videoPath;

	private boolean isFavorite;

	public ExerciseDataModel(long id, int[] groups, String name, String description,
									 String imagePath, String videoPath, boolean isFavorite) {
		this.id = id;
		this.groups = groups;
		this.name = name;
		this.description = description;
		this.imagePath = imagePath;
		this.videoPath = videoPath;
		this.isFavorite = isFavorite;
	}

	public ExerciseDataModel(ExerciseModel model) {
		id = model.getId();
		groups = model.getGroups();
		name = model.getName();
		description = model.getDescription();
		imagePath = model.getImagePath();
		videoPath = model.getVideoPath();
		isFavorite = model.isFavorite();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int[] getGroups() {
		return groups;
	}

	public void setGroups(int[] groups) {
		this.groups = groups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean favorite) {
		isFavorite = favorite;
	}

	public ExerciseModel toExerciseModel() {
		return new ExerciseModel(id, groups, name, description, imagePath, videoPath, isFavorite);
	}

	//----- START Parcelable implementation ----------
	public ExerciseDataModel(Parcel in) {
		id = in.readLong();
		int groupsSize = in.readInt();
		groups = new int[groupsSize];
		in.readIntArray(groups);
		String[] data = new String[4];
		in.readStringArray(data);
		name = data[0];
		description = data[1];
		imagePath = data[2];
		videoPath = data[3];
		boolean boolData[] = new boolean[1];
		in.readBooleanArray(boolData);
		isFavorite = boolData[0];
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeLong(id);
		out.writeInt(groups.length);
		out.writeIntArray(groups);
		out.writeStringArray(new String[] {name, description, imagePath, videoPath});
		out.writeBooleanArray(new boolean[] {isFavorite});
	}

	public static final Parcelable.Creator<ExerciseDataModel> CREATOR
			= new Parcelable.Creator<ExerciseDataModel>() {
		public ExerciseDataModel createFromParcel(Parcel in) {
			return new ExerciseDataModel(in);
		}

		public ExerciseDataModel[] newArray(int size) {
			return new ExerciseDataModel[size];
		}
	};
	//----- END Parcelable implementation ----------

	@Override
	public String toString() {
		return "ExerciseDataModel{" +
				"id=" + id +
				", groups=" + Arrays.toString(groups) +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", imagePath='" + imagePath + '\'' +
				", videoPath='" + videoPath + '\'' +
				", isFavorite=" + isFavorite +
				'}';
	}
}
