package com.ivomtdias.taskmanager.services

import com.ivomtdias.taskmanager.entities.Task
import com.ivomtdias.taskmanager.entities.TaskDTO
import com.ivomtdias.taskmanager.exceptions.NotFoundException
import com.ivomtdias.taskmanager.repositories.TaskRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService(private val taskRepository: TaskRepository) : ITaskService{
    override fun getTaskById(taskId: UUID): Task {
        return taskRepository.findById(taskId)
            .orElseThrow { NotFoundException("Task not found") }
    }

    override fun getAllTasks(): List<Task> {
        return taskRepository.findAll()
    }

    override fun createTask(taskDTO: TaskDTO) {
        taskRepository.save(Task(UUID.randomUUID(), taskDTO.title, taskDTO.description))
    }

    override fun deleteTask(taskId: UUID) {
        taskRepository.deleteById(taskId)
    }
}