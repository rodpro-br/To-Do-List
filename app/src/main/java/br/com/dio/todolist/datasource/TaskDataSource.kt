package br.com.dio.todolist.datasource

import br.com.dio.todolist.model.Task

object TaskDataSource {
    private val list = mutableListOf<Task>()

    fun getList() =
        list.toList().sortedWith(compareBy ({ it.date }, {it.hour}))


    fun insertTask(task: Task) {
        if (task.id == 0) {
            list.add(task.copy(id = list.size + 1))
        } else {
            list.remove(task)
            list.add(task)
        }
    }

    fun findById(taskId: Int) = list.find { it.id == taskId }

    fun deleteTask(task: Task) {
        list.remove(task)
    }
}