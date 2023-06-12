package com.ivomtdias.taskmanager.services

import com.ivomtdias.taskmanager.entities.Task
import com.ivomtdias.taskmanager.entities.TaskDTO
import com.ivomtdias.taskmanager.repositories.TaskRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class TaskServiceTest {

    @Mock
    private lateinit var taskRepository: TaskRepository

    @InjectMocks
    private lateinit var taskService: TaskService

    @Test
    fun getTaskById() {
        // given
        val randomId = UUID.randomUUID()
        val task = Task(randomId, "title", "description")
        Mockito.`when`(taskRepository.findById(Mockito.any()))
            .thenReturn(Optional.of(task))

        // when
        val taskById = taskService.getTaskById(randomId)

        // then
        Mockito.verify(taskRepository).findById(randomId)

        assertEquals(taskById.id, randomId)
        assertEquals(task.title, taskById.title)
        assertEquals(task.description, taskById.description)
    }

    @Test
    fun getAllTasks() {
        // given
        val randomId = UUID.randomUUID()
        Mockito.`when`(taskRepository.findAll())
            .thenReturn(listOf())

        // when
        val tasks = taskService.getAllTasks()

        // then
        Mockito.verify(taskRepository).findAll()

        assertEquals(tasks.size, 0)
    }

    @Test
    fun createTask() {
        // given
        val taskDTO = TaskDTO("title", "description")

        // when
        taskService.createTask(taskDTO)

        // then
        Mockito.verify(taskRepository).save(Mockito.any())
    }

    @Test
    fun deleteTask() {
        // given
        val randomId = UUID.randomUUID()

        // when
        taskService.deleteTask(randomId)

        // then
        Mockito.verify(taskRepository).deleteById(randomId)

    }
}