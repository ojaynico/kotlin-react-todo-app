@file:Suppress("UnsafeCastFromDynamic")

package components

import app.Item
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.style
import models.Todo
import react.RBuilder
import react.dom.button
import react.dom.input
import react.dom.li
import react.dom.span
import kotlinext.js.*

fun RBuilder.todoItem(todo: Todo, item: Item) {
    li("list-group-item") {
        attrs.style = js {
            background = "lightgrey"
        }
        span {
            input {
                attrs.type = InputType.checkBox
                attrs.onChangeFunction = {
                    item.markComplete(todo.id)
                }
            }
        }

        span {
            attrs.style = js {
                textDecoration = if (todo.completed) "line-through" else "none"
            }
            +" ${todo.title}"
        }

        span("badge badge-pill") {
            attrs.style = js {
                float = "right"
            }
            button {
                attrs.style = js {
                    color = "red"
                }
                attrs.onClickFunction = {
                    item.deleteTodo(todo.id)
                }
                +"x"
            }
        }
    }
}
