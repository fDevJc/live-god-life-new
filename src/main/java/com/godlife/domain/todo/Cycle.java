package com.godlife.domain.todo;

import java.time.LocalDate;

public interface Cycle {

	boolean has(LocalDate targetDate);
}
