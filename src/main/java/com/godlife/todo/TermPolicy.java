package com.godlife.todo;

import java.time.LocalDate;

public interface TermPolicy {
	boolean isNotCorrect(LocalDate localDate);
}
