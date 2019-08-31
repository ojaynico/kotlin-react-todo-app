package components

import app.Item
import models.Todo
import react.*
import react.dom.*

fun RBuilder.todos(todosList: MutableList<Todo>, item: Item) {
    div {
        h4 { +"My todos" }
        ul("list-group") {
            todosList.forEach {
                todoItem(it, item)
            }
        }
    }
}
