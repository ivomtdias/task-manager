package com.ivomtdias.taskmanager.repositories

import com.ivomtdias.taskmanager.entities.Task
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TaskRepository : MongoRepository<Task, UUID>{
}