package com.godlife.domain.todo;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String title;
	private final List<Task> tasks = new ArrayList<>();

	public Folder(String title) {
		this.title = title;
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public int count() {
		return tasks.size();
	}

	public Progress progress() {
		int totalCount = 0;
		int completedCount = 0;
		for (Task task : tasks) {
			Progress progress = task.progress();
			totalCount += progress.totalCount();
			completedCount += progress.completedCount();
		}
		return new Progress(totalCount, completedCount);
	}
}
