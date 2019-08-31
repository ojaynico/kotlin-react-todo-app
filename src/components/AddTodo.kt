package components

import app.Item
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import models.Todo
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.dom.*
import kotlin.browser.document

fun RBuilder.addTodo(item: Item) {
    form {
        div("form-group") {
            input(classes = "form-control") {
                attrs.name = "title"
                attrs.id = "title"
                attrs.placeholder = "Add Todo..."
            }
        }
        div("text-right") {
            button(classes = "btn btn-primary") {
                attrs.onClickFunction = {
                    it.preventDefault()
                    val title = document.getElementById("title") as HTMLInputElement
                    val valueOfTitle = title.value
                    val myTodo = Todo(5, valueOfTitle, false)
                    item.addTodo(myTodo)
                    title.value = ""
                }
                +"Add"
            }
        }
    }
}
