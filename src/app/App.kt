package app

import components.addTodo
import components.todos
import react.*
import react.dom.*
import models.*

interface AppState : RState {
    var todosList: MutableList<Todo>
}

abstract class Item {
     open fun markComplete(id: Int) {}

     open fun deleteTodo(id: Int) {}

     open fun addTodo(todo: Todo) {}
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        todosList = mutableListOf(
                Todo(1, "Kotlin for react", false),
                Todo(2, "Develop an android app in Kotlin", false),
                Todo(3, "Express application in kotlin", false),
                Todo(4, "Kotlin for IOS", false),
                Todo(8, "Kotligfg hghjgh", false))
    }

    override fun RBuilder.render() {
        div("container") {
            div("row") {
                div("col-lg-3") {  }
                div("col-lg-6") {
                    div {
                        h2("text-center") { +"Kotlin React Todo App" }
                    }
                    br {  }

                    addTodo(object: Item() {

                        override fun addTodo(todo: Todo) {
                            setState {
                                todosList.add(todo)
                            }
                        }

                    })

                    hr {  }

                    todos(state.todosList, object: Item() {

                        override fun deleteTodo(id: Int) {
                            setState {
                                todosList.forEach {
                                    if (it.id == id)
                                        todosList.remove(it)
                                }
                            }
                        }

                        override fun markComplete(id: Int) {
                            setState {
                                todosList.map {
                                    if (it.id == id)
                                        it.completed = !it.completed

                                    return@map it
                                }
                            }
                        }
                    })
                }
                div("col-lg-3") {  }
            }
        }
    }

}

fun RBuilder.app() = child(App::class) {}

