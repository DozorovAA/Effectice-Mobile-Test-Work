package ru.test.EffectiveMobileTestWork.controller.mappers;

import ru.test.EffectiveMobileTestWork.model.task.Task;
import ru.test.EffectiveMobileTestWork.model.task.TaskPatch;

public class TaskMapper {
    public static TaskPatch toUpdate(Task task) {
        TaskPatch taskPatch = new TaskPatch();
        if(task.getId() == null)
            throw new RuntimeException();
        taskPatch.setId(task.getId());
        if(task.getDescription() != null) taskPatch.setDescription(task.getDescription());
        if(task.getStatus() != null) taskPatch.setStatus(task.getStatus());
        if(task.getPriority() != null) taskPatch.setPriority(task.getPriority());
        if(task.getTitle() != null) taskPatch.setTitle(task.getTitle());
        if(task.getComment() != null) taskPatch.setComment(task.getComment());
        return taskPatch;
    }
}
