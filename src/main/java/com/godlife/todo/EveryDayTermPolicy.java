package com.godlife.todo;

import java.time.LocalDate;

public class EveryDayTermPolicy implements TermPolicy{

	@Override
	public boolean isNotCorrect(LocalDate localDate) {
		return false;
	}
}
