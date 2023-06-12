package com.ivomtdias.taskmanager

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskManagerApplication

fun main(args: Array<String>) {
	runApplication<TaskManagerApplication>(*args)
}