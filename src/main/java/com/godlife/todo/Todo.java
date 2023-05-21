package com.godlife.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.collection.internal.PersistentList;

public class Todo {
	private LocalDate startDate;
	private LocalDate endDate;
	private TermPolicy termPolicy;

	private List<Schedule> schedules = new ArrayList<>();

	public Todo(LocalDate startDate, LocalDate endDate, TermPolicy termPolicy) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.termPolicy = termPolicy;
	}

	public void complete(LocalDate completedDate) {
		checkDate(completedDate);
		this.schedules.add(new Schedule(completedDate));
	}

	private void checkDate(LocalDate localDate) {
		checkPeriod(localDate);
		checkTerm(localDate);
	}

	private void checkTerm(LocalDate localDate) {
		if (termPolicy.isNotCorrect(localDate)) {
			throw new RuntimeException("주기가 올바르지 않습니다");
		}
	}

	private void checkPeriod(LocalDate localDate) {
		if (startDate.isAfter(localDate) && endDate.isBefore(localDate)) {
			throw new RuntimeException("기간이 올바르지 않습니다");
		}
	}
}
