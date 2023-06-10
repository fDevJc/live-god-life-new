package com.godlife.domain.todo;

public class Progress {
	private int totalCount;
	private int completedCount;

	public Progress(int totalCount, int completedCount) {
		this.totalCount = totalCount;
		this.completedCount = completedCount;
	}

	public int totalCount() {
		return totalCount;
	}

	public int completedCount() {
		return completedCount;
	}
}
