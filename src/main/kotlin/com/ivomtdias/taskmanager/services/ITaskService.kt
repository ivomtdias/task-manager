package com.ivomtdias.taskmanager.services

import com.ivomtdias.taskmanager.entities.Task
import com.ivomtdias.taskmanager.entities.TaskDTO
import java.util.UUID

interface ITaskService {
    fun getTaskById(taskId: UUID): Task
    fun getAllTasks(): List<Task>
    fun createTask(taskDTO: TaskDTO)
    fun deleteTask(taskId: UUID)
}