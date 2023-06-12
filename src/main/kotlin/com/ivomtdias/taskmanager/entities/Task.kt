package com.ivomtdias.taskmanager.entities

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID
import javax.annotation.processing.Generated

@Document(collection = "tasks")
data class Task(
    @Id
    @Generated
    val id: UUID,
    val title: String,
    val description: String
)
