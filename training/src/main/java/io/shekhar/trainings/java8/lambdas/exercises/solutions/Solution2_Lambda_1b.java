package io.shekhar.trainings.java8.lambdas.exercises.solutions;

import io.shekhar.trainings.java8.domain.Task;
import io.shekhar.trainings.java8.domain.TaskType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.shekhar.trainings.java8.utils.DataUtils.getTasks;

public class Solution2_Lambda_1b {

	public static void main(String[] args) {
		List<Task> tasks = getTasks();

		List<String> taskTitles = taskTitles(tasks, "s", TaskType.READING);
		
		taskTitles.forEach(System.out::println);
	}

	public static List<String> taskTitles(List<Task> tasks, String titleStartsWith, TaskType type) {
		List<String> readingTasks = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getTitle().startsWith(titleStartsWith) && task.getType() == type) {
				readingTasks.add(task.getTitle());
			}
		}
		return readingTasks;
	}
}
