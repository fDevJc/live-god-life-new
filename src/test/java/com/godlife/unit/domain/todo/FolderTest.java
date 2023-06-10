package com.godlife.unit.domain.todo;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.godlife.domain.todo.Folder;
import com.godlife.domain.todo.Progress;

public class FolderTest {
	@Test
	void addTaskTest() throws Exception {
		//given
		Folder folder = new Folder("폴더1");
		//when
		folder.add(TaskFactory.defaultTask());
		//then
		assertThat(folder.count()).isEqualTo(1);
	}

	@Test
	void progressTest() throws Exception {
		//given
		Folder folder = new Folder("폴더1");
		//when
		folder.add(TaskFactory.defaultTask()); //365
		folder.add(TaskFactory.defaultTask()); //365

		//then
		Progress progress = folder.progress();

		assertThat(progress.completedCount()).isEqualTo(0);
		assertThat(progress.totalCount()).isEqualTo(365 + 365);
	}
}
