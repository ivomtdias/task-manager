package com.ivomtdias.taskmanager.controllers

import com.ivomtdias.taskmanager.entities.Task
import com.ivomtdias.taskmanager.entities.TaskDTO
import com.ivomtdias.taskmanager.services.ITaskService
import com.ivomtdias.taskmanager.services.TaskService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: ITaskService) {
    @GetMapping("/{taskId}")
    fun getTaskById(@PathVariable taskId: UUID): Task {
        return taskService.getTaskById(taskId)
    }

    @GetMapping("/")
    fun getAllTasks(): List<Task> {
        return taskService.getAllTasks()
    }

    @PostMapping("/")
    fun createTask(@RequestBody taskDTO: TaskDTO) {
        taskService.createTask(taskDTO)
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId: UUID) {
        taskService.deleteTask(taskId)
    }
}